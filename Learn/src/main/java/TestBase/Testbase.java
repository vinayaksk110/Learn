package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Automation.Listener.LearnITestResultListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import utility.CaptureConsoleLogs;
import utility.CaptureNetworkLogs;
import utility.DateNTime;
import utility.DeleteFiles;
import utility.TakeScreenShotUtility;

public class Testbase {
	
	public static Logger log = LogManager.getLogger(Testbase.class.getName());
	public static Properties repository = new Properties();
	public File f = null;
	public InputStream fis = null;
	public static WebDriver driver = null;
	public Wait<WebDriver> wait = null;
	public WebDriverWait explicitelyWait = null;
	public DateNTime dateNTime = new DateNTime();
	public DeleteFiles deleteFiles = new DeleteFiles();
	public String filePath = null;
	String os = null;
	String loggedInUserName = null;
	String firefoxDriverPath = null;
	String chromeDriverPath = null;
	boolean excelStatus = false;
	boolean headless = false;
	public boolean isLoginSuccess = false;

	// browser
	EdgeOptions edgeOptions = null;
	ChromeOptions chromeOptions = null;
	FirefoxOptions firefoxOptions = null;

	
	public static TakeScreenShotUtility takeScreenShotUtility = null;
	LearnITestResultListeners rpcListener = null;
	CaptureConsoleLogs captureConsoleLogs = null;
	CaptureNetworkLogs captureNetworkLogs = null;
	protected String resourceHome = null;
	public String ipAddress = null;

//	// For writing to excel sheet.
//	public String testName = null;
//	public String testResult = "FAIL";
//	public String testResultComment = "Test has not yet started";


	protected SoftAssert softAssertion = new SoftAssert();

	/**
	 * This method loads the project config file
	 * 
	 * @throws IOException, FileNotFoundException
	 */
	private void loadPropertiesFile() throws IOException, FileNotFoundException {
		f = new File(Constants.RPCHDCONFIG);
		fis = new FileInputStream(f);

		if (fis != null) {
			repository.load(fis);
			System.out.println("Loaded properties file successfully");
		} else {
			throw new FileNotFoundException("Property file RemotePCConfig.propertes not found in the resource path");
		}
	}

	/**
	 * This method initialized the project by loading the properties files, creates
	 * the required browser and creates the wait element of the project.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void initializeTestingEnvironment(String excelFileStatus, String browser, String headless) throws Exception {
		System.out.println("==========Initializing Test Environment==============");
		// System.out.println(excelFileStatus + " : " + browser + " : " + headless);
		if (excelFileStatus.equalsIgnoreCase("yes")) {
			this.excelStatus = true;
		}

		if (headless.equalsIgnoreCase("yes")) {
			this.headless = true;
		}

		try {
			// Proceed with loading properties and browser driver creation only if,
			// the reports can be written to an excel sheet.
			Assert.assertEquals(this.excelStatus, true);

			// log4j log capture
			log4jInitiator();

			// Load the project properties file and create the required browser
			loadPropertiesFile();

			loggedInUserName = System.getProperty("user.name");
			// Deprecated resourcehome
			// Get the resource path from the environment variable of the local system.
//			resourceHome = System.getenv("RESOURCE_HOME");
//			Constants.CREDENTIALS_PATH = resourceHome;

			Constants.CREDENTIALS_PATH = getResourceHome();
			System.out.println("Resource home path is>>>>>>" + getResourceHome());

			// Create the browser driver
			createBrowser(browser, this.headless);

			// consoleLogs
			captureConsoleLogs = new CaptureConsoleLogs();
			captureConsoleLogs.captureConsoleLogs(driver, browser);

			// networkLogs
			captureNetworkLogs = new CaptureNetworkLogs();
			captureNetworkLogs.captureNetworkLogs(driver, browser);

			// Setting implicit wait to handle synchronization issues
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

			String systemName = InetAddress.getLocalHost().getHostName();

//			//Screenshot utility initialized
			takeScreenShotUtility = new TakeScreenShotUtility(driver);

			// Create the extent report object for writing the report
			setupExtentRepoter();

			System.out.println("\n\n============================");
			System.out.println("Project will run in:");
			System.out.println("Brower: " + browser.toUpperCase());
			System.out.println("Headless = " + this.headless);
			System.out.println("============================");

		} catch (AssertionError ae) {
			System.out.println("Aborting!! : Your excel file is not ready. ");
			throw ae;

			// ae.getMessage();
			// return;`
		} catch (NullPointerException npe) {
			System.out.println("Was unable to create the object for excel drive uitility");
			npe.getMessage();
		}
	}

	public void initializeTestingEnvironment(String excelFileStatus, String browser, String headless,
			String executionEnvironment) throws Exception {
		System.out.println("==========Initializing Test Environment==============");
		// System.out.println(excelFileStatus + " : " + browser + " : " + headless);
		if (excelFileStatus.equalsIgnoreCase("yes")) {
			this.excelStatus = true;
		}

		if (headless.equalsIgnoreCase("yes")) {
			this.headless = true;
		}

		try {
			// Proceed with loading properties and browser driver creation only if,
			// the reports can be written to an excel sheet.
			Assert.assertEquals(this.excelStatus, true);

			// log4j logs creator
			log4jInitiator();

			// Load the project properties file and create the required browser
			loadPropertiesFile();

			loggedInUserName = System.getProperty("user.name");
			// Depricated the old resourcehome path.
			// Get the resource path from the environment variable of the local system.
//			resourceHome = System.getenv("RESOURCE_HOME");
//			Constants.CREDENTIALS_PATH = resourceHome;

			Constants.CREDENTIALS_PATH = getResourceHome();
			System.out.println("Resource home path is>>>>>>" + getResourceHome());


			// Verifying the host IP with expected execution environment
			if (verifyHostAddress(executionEnvironment)) {
				// Create the browser driver
				createBrowser(browser, this.headless);

				// consolelogs
				captureConsoleLogs = new CaptureConsoleLogs();
				captureConsoleLogs.captureConsoleLogs(driver, browser);

				// networkLogs
				captureNetworkLogs = new CaptureNetworkLogs();
				captureNetworkLogs.captureNetworkLogs(driver, browser);

				// Setting implicit wait to handle synchronization issues
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

				String systemName = InetAddress.getLocalHost().getHostName();

//				//Screenshot utility initialized
				takeScreenShotUtility = new TakeScreenShotUtility(driver);

				// rpcListener = new RPCListeners(driver);

				// Create the extent report object for writing the report
				setupExtentRepoter();

				System.out.println("\n\n============================");
				System.out.println("Project will run in:");
				System.out.println("Brower: " + browser.toUpperCase());
				System.out.println("Headless = " + this.headless);
				System.out.println("============================");

				getPublicIP();
			}

		} catch (AssertionError ae) {
			System.out.println("Aborting!! : Your excel file is not ready. ");
			throw ae;

			// ae.getMessage();
			// return;`
		} catch (NullPointerException npe) {
			System.out.println("Was unable to create the object for excel drive uitility");
			npe.getMessage();
		}
	}

	private void setupExtentRepoter() {

	}

	/**
	 * 
	 * @param browser  : browser received from Jenkins i.e chrome/ edge/ firefox
	 * @param headless : headless true or false received from Jenkins
	 * @throws Exception : Handling Exception
	 */
	public void createBrowser(String browser, boolean headless) throws Exception {
//		EdgeOptions edgeOptions = new EdgeOptions();
//		ChromeOptions chromeOptions = new ChromeOptions();
//		FirefoxOptions firefoxOptions = new FirefoxOptions();

		// Find the operating system.
		os = System.getProperty("os.name");
		System.out.println("Environment Operating System: " + os);
		System.out.println("Logged in user : " + loggedInUserName);
		if (headless) {
			System.out.println("Creating Environment: " + browser + " driver in headless mode");
		} else if (!headless) {
			System.out.println("Creating Environment: " + browser + " driver in head mode");
		}
		try {
			if (browser.equalsIgnoreCase(Constants.EDGE)) {
				// Form the default profile path, to load in the browser profile
				createBrowserEdge();
			} else if (browser.equalsIgnoreCase(Constants.CHROME)) {
				createBrowserChrome();
			} else if (browser.equalsIgnoreCase(Constants.FIREFOX)) {
				createBrowserFireFox();
			} else if (browser.equalsIgnoreCase(Constants.SAFARI)) {
				createBrowserSafari();
			}
			System.out.println(browser + " driver created");
			// This is a fallback logic if incase the browser creation fails we will try to
			// run the code in other browser
		} catch (SessionNotCreatedException | NullPointerException | IllegalArgumentException
				| WebDriverManagerException snce) {
			snce.printStackTrace();
			System.out.println("Since the browser creation failed, starting test with browser: " + browser);
			if (browser.equalsIgnoreCase(Constants.FIREFOX) || browser.equalsIgnoreCase(Constants.CHROME)) {
				try {
					System.out.println("Creating Environment: Edge driver");
					createBrowserEdge();
				} catch (SessionNotCreatedException snce1) {
					Assert.assertTrue(false);
				}
			} else if (browser.equalsIgnoreCase(Constants.EDGE) || browser.equalsIgnoreCase(Constants.SAFARI)) {
				try {
					System.out.println("Creating Environment: Chrome driver");
					createBrowserChrome();
				} catch (SessionNotCreatedException snce1) {
					Assert.assertTrue(false);
				}
			}
		}

		// Once the web driver element is successfully created,
		// Create the fluent wait element using the driver.
		createFluentWait(wait);
		explicitWait(explicitelyWait);
	}

	public boolean verifyHostAddress(String executionEnvironment) {
		System.out.println("Verifying host IP address");
		// The URL for which IP address needs to be fetched
		String url = repository.getProperty("rpcLoginPage");
		System.out.println(url);
		InetAddress ip = null;

		try {
			// Fetch IP address by getByName()
			ip = InetAddress.getByName(new URL(url).getHost());
			// Print the IP address
			System.out.println("Host Address of: " + ip.getHostName() + " is ==>" + ip.getHostAddress());
		} catch (MalformedURLException mue) {
			// It means the URL is invalid
			System.out.println("Invalid URL");
			mue.printStackTrace();
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		}

		String hostIPAddress = ip.getHostAddress();

		// Set the present environment as per the IP address
		if (hostIPAddress.equalsIgnoreCase(Constants.TEST_SERVER_125)
				&& executionEnvironment.equalsIgnoreCase(Constants.TEST_EXECUTION_ENVIRONMENT_125)) {
			System.out.println("=========>Running execution on 173.255.9.125 server<=========");
			return true;
		} else if (hostIPAddress.equalsIgnoreCase(Constants.TEST_SERVER_91)
				&& executionEnvironment.equalsIgnoreCase(Constants.TEST_EXECUTION_ENVIRONMENT_91)) {
			System.out.println("=========>Running execution on 173.255.9.91 server<=========");
			return true;
		} else if (hostIPAddress.equalsIgnoreCase(Constants.STAGING_SERVER_243)
				&& executionEnvironment.equalsIgnoreCase(Constants.STAGING_EXECUTION_ENVIRONMENT)) {
			System.out.println("=========>Running execution on 64.90.202.243 server<=========");
			return true;
		} else if (!hostIPAddress.equalsIgnoreCase(Constants.STAGING_SERVER_243)
				&& !hostIPAddress.equalsIgnoreCase(Constants.TEST_SERVER_91)
				&& !hostIPAddress.equalsIgnoreCase(Constants.TEST_SERVER_125)
				&& executionEnvironment.equalsIgnoreCase(Constants.PROD_EXECUTION_ENVIRONMENT)) {
			System.out.println("=========>Running execution on PRODUCTION server<=========");
			return true;
		} else {
			String hostAddress = "";
			switch (hostIPAddress) {
			case ("173.255.9.91"):
				hostAddress = "TEST_SERVER_91";
				break;
			case ("173.255.9.125"):
				hostAddress = "TEST_SERVER_125";
				break;
			case ("64.90.202.243"):
				hostAddress = "STAGING_SERVER_243";
				break;
			default:
				hostAddress = "PRODUCTION_SERVER";
				break;

			}

			String message = "Execution environment selected is : " + executionEnvironment + " but host is pointing to "
					+ hostAddress + ", future tests may not be continued";
			System.out.println(message);
			return false;
		}

	}

	/**
	 * This method creates the project specific wait.
	 * 
	 * @param wait
	 */
	public void createFluentWait(Wait<WebDriver> wait) throws Exception {
		if (wait == null) {
			int timeOut = 60;
			this.wait = new FluentWait<WebDriver>(driver)
					// Timeout time is set to 60
					.withTimeout(Duration.ofSeconds(timeOut))
					// polling interval
					.pollingEvery(Duration.ofMillis(100))
					// ignore the exception
					.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
			System.out.println("Created wait with browser timeout of " + timeOut + " seconds");
		}
	}

	public void explicitWait(WebDriverWait explicitelyWait) throws Exception {
		if (explicitelyWait == null) {
			int timeOut = 180;
			this.explicitelyWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			System.out.println("Created explicit wait with browser timeout of " + timeOut + " seconds");
		}
	}

	public void log4jInitiator() throws FileNotFoundException, IOException {
		System.out.println("Initiating log4j logging");
		System.setProperty("log4jDateTime", dateNTime.printCurrentDate().replaceAll("[^0-9A-Za-z]", ""));
		System.setProperty("log4jFilePath", System.getProperty("user.home") + "\\RPC\\logs-output\\log4j\\");
		// this is for property file
		String log4jConfPath = System.getProperty("user.dir") + "\\src\\test\\properties\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		System.out.println(">>>>>>>>log4j logging started successfully");
	}

	public void createBrowserEdge() {
		edgeOptions = new EdgeOptions();
		String browserProfilePath1 = "C:\\Users\\";
		String browserProfilePath2 = "\\AppData\\Local\\Microsoft\\Edge\\User Data\\Default";
		String browserDefaultProfilePath = (browserProfilePath1.concat(loggedInUserName)).concat(browserProfilePath2);
		System.out.println("The default profile path: " + browserDefaultProfilePath);
		System.setProperty("webdriver.edge.silentOutput", "true");

		// logging preferences
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		edgeOptions.setCapability("goog:loggingPrefs", logPrefs);
		if (headless) {
			edgeOptions.addArguments("--headless", "--window-size=1920,1200");
		} else if (!headless) {
			edgeOptions.addArguments("--start-maximized");
		}
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(edgeOptions);
	}

	public void createBrowserChrome() {
		chromeOptions = new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput", "true");

		// logging preferences
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		chromeOptions.setCapability("goog:loggingPrefs", logPrefs);

		if (headless) {
			chromeOptions.addArguments("--headless", "--window-size=1920,1200");
		} else if (!headless) {
			// chromeOptions.addArguments (browserDefaultProfilePath);
			chromeOptions.addArguments("--start-maximized");
			// chromeOptions.addArguments("--auto-open-devtools-for-tabs");
		}
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
	}

	public void createBrowserFireFox() {
		firefoxOptions = new FirefoxOptions();
		WebDriverManager.firefoxdriver().setup();
		// Enable Logging preferences
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_PROFILE, "/dev/null");
		System.out.println("Logging preferences set");
		if (headless) {
			firefoxOptions.addArguments("--headless", "--window-size=1920,1200");
		} else if (!headless) {
			firefoxOptions.addArguments("--start-maximized");
		}
		driver = new FirefoxDriver(firefoxOptions);
	}

	public void createBrowserSafari() {
		if (headless) {
			System.out.println("There is no headless mode in Safari browser. Creating in non headless mode");
		}
		driver = new SafariDriver();
	}

	public boolean waitForElement(String element, String elementType) {
		boolean waitResult = false;

		if (elementType.equalsIgnoreCase("xpath")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
				waitResult = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return waitResult;
			}
		} else if (elementType.equalsIgnoreCase("id")) {
			if (elementType.equalsIgnoreCase("id")) {
				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
					waitResult = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return waitResult;
				}
			}

		} else if (elementType.equalsIgnoreCase("name")) {
			if (elementType.equalsIgnoreCase("name")) {
				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
					waitResult = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return waitResult;
				}
			}

		}
		return waitResult;
	}

	public String getPublicIP() {
		driver.navigate().to("http://botwhatismyipaddress.com/");
		WebElement ipAddressWebElement = driver.findElement(By.xpath("//section[@class='main']//strong"));
		ipAddress = ipAddressWebElement.getText();
		System.out.println("Your public IP address is :" + ipAddress);
		return ipAddress;
	}

	public String getResourceHome() {
		return System.getProperty("user.home").concat(System.getProperty("file.separator"))
				.concat(Constants.CREDENTIALS_RESOURCEHOME).concat(System.getProperty("file.separator"))
				.concat(Constants.CREDENTIALS_RESOURCESPATH).concat(System.getProperty("file.separator"))
				.concat(Constants.CREDENTIALS_NAME);
	}

}
