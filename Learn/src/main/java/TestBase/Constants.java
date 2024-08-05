package TestBase;

import utility.DateNTime;

public class Constants {
static DateNTime date = new DateNTime();
	
	// Path of the project properties file
	public static final String RPCHDCONFIG = "src/test/properties/RPCConfig.properties";
	
	// Path of MAC Firefox and Chrome exes
	public static final String MAC_FIREFOXPATH = "/Volumes/samanth_data/Java_Related/RemotePCHelpdesk/Jars/geckodriver";
	public static final String MAC_CHROMEPATH = "/Volumes/samanth_data/Java_Related/RemotePCHelpdesk/Jars/chromedriver";
	

	// Path of Windows Firefox and Chrome exes
	public static final String WINDOWS_FIREFOXPATH = null;
	public static final String WINDOWS_CHROMEPATH = null;
	
	// Browser names
	public static final String FIREFOX = "firefox";
	public static final String CHROME = "chrome";
	public static final String EDGE = "edge";
	public static final String SAFARI = "safari";
	
	// Path of the Credentials file
	public static final String CREDENTIALS_RESOURCEHOME = "RPC";
	public static final String CREDENTIALS_RESOURCESPATH = "resources";
	public static final String CREDENTIALS_NAME = "sheetsAPIclient_secret.json";
	public static String CREDENTIALS_PATH = "null"; //"src/test/resources/sheetsAPIclient_secret.json";
	public static final String CREDENTIALS_PATH1 = "resources/sheetsAPIclient_secret.json";
	public static final String AUTOMATION_SERVER_CREDENTIALS_PATH = "C:/Users/Samanth/.jenkins/workspace/RemotePC_Automation_Tests/resources/sheetsAPIclient_secret.json";
	

	// The worksheet ID where test result report will be written.
	// Account : automationreports@idrive.com / WorkSheet Name : TestResults 

	public static final String AUTOMATION_SERVER = "SamanthDAVDesktop";
	public static final String WORKSHEETID_ACCOUNTS = "19jeHfrDSczvHhmVTI7e10rSluCQcqQa2p96uk2Y63Mk";
	//Old testResults sheet kept for reference containing data till 15/03/24
//	public static final String WORKSHEETID_TESTRESULTS	= "1aDVRkXuCFKUL-dsByCs3ZMGyGtiZvqbiS1LNRM3WXWY";
	public static final String WORKSHEETID_TESTRESULTS	= "1JULF0zi1TyuCkUZyDwWCE-QSoWDwgwFL6_ud4W8SUOM";
	public static final String WORKSHEETID_DEVELOPMENT_TESTRESULTS = "1zXnSKJU2Z0JqQ3jR5sGxGM7uyjB2NZh4xN4gWhXr2jg";
	
	// Below are the sheetranges to be used for fetching username details.
	public static final String SHEETRANGE_LOGIN = "Login!A2:D";
	public static final String SHEETRANGE_CANCELACCOUNTSINBULK = "CancelRPCAccountsInBulk!A2:E";
	public static final String SHEETRANGE_CANCELACCOUNT = "CancelAccount!A2:O";
	public static final String SHEETRANGE_FORGOTPASSWORD = "ForgotPassword!A3:E";
	public static final String SHEETRANGE_DISABLEAUTORENEWAL = "DisableAutoRenewal!A2:E";
	public static final String SHEETRANGE_UPGRADE = "Upgrade!A2:J";
	//public static final String SHEETRANGE_PROFILECASES = "ProfileCases!A3:E";
	public static final String SHEETRANGE_SIGNUP = "Signup!A2:P";
	public static final String SHEETRANGE_PROFILE = "Profile!A2:J";
	public static final String SHEETRANGE_SSO = "SSO!A2:J";
	public static final String SHEETRANGE_SETTINGS = "Settings!A2:E";
	public static final String SHEETRANGE_DEPLOYPACKAGEANDPREFERENCEPOLICY = "DeployPackageAndPreferencePolicy!A2:K";
	public static final String SHEETRANGE_USERMANAGEMENT = "UserManagement!A2:Z";
	public static final String SHEETRANGE_LHSMENU = "LHSMenu!A2:D";
	public static final String SHEETRANGE_COMPUTERMANAGEMENT = "ComputerManagement!A2:J";
	public static final String SHEETRANGE_ENDTOEND = "EndToEnd!A2:AU";
	
	// not specifying the sheet name below for test results sheet as, it will be dynamically fetched at the 
	//time or writing the test results
	public static final String SHEETRANGE_TESTRESULTS = "!A2:E";
	public static final String SHEETRANGE_DEVELOMENT_TESTRESULTS = "!A2:E";
	
	//Below are the constants for the column names of signup sheet
	public static final int COLUMN_DATA_IDENTIFIER = 1;
	public static final int COLUMN_EMAILID = 2;
	public static final int COLUMN_PWD = 3;
	public static final int COLUMN_FNAME = 4;
	public static final int COLUMN_LNAME = 5;
	public static final int COLUMN_PHNO = 6;
	public static final int COLUMN_CCNO = 7;
	public static final int COLUMN_CC_MM = 8;
	public static final int COLUMN_CC_YY = 9;
	public static final int COLUMN_CC_CVV = 10;
	public static final int COLUMN_BILLING_ADDRESS = 11;
	public static final int COLUMN_ZIPCODE = 12;
	public static final int COLUMN_PROMOCODE = 13;
	
	//Below are the contants for the column names of login sheet
	public static final int COLUMN_LOGIN_EMAILID = 2;
	public static final int COLUMN_LOGIN_PWD = 3;
	
	//Below are the constants for the column names of profile sheet
	public static final int COLUMN_PROFILE_DATA_IDENTIFIER = 1;
	public static final int COLUMN_PROFILE_EMAILID = 2;
	public static final int COLUMN_PROFILE_PWD = 3;
	public static final int COLUMN_PROFILE_NEW_FNAME = 4;
	public static final int COLUMN_PROFILE_NEW_LNAME = 5;
	public static final int COLUMN_PROFILE_NEW_EMAILID = 6;
	public static final int COLUMN_PROFILE_NEWPWD = 7;
	public static final int COLUMN_PROFILE_NEW_PHNO = 8;
	
	public static final int COLUMN_USERMANAGEMENT_ADDUSER_GROUP = 3;
	
	//Sam: 20/07/20 
	// adding hardcoded values for emailable report to be used in the email utilities. 
	public static final String MAC_EMAILABLE_REPORT = "/Volumes/samanth_data/Java_Related/IDrive/target/surefire-reports/emailable-report.html";
	public static final String WINDOWS_EMAILABLE_REPORT = "D:\\Office\\Backup\\RPC\\AutomatedRemotePC\\target\\surefire-reports\\emailable-report.html";
	
	//Below are the constants for the CSV upload
	
//	public final static String CSV_UPLOADPATH = System.getProperty("user.home")+"\\git\\webremotepc\\src\\test\\java\\RemotePC\\projectData\\";
	public final static String CSV_UPLOADPATH = "\\RPC\\projectData\\";
	public final static String CSV_FILENAME_ENT = "Template_Add_ENT_Multiple_Users.csv";
	public final static String CSV_FILENAME_TEAM = "Template_Add_TEAM_Multiple_Users.csv";
	public final static String CSV_FILENAME_TEAM_EXISTING = "Template_Add_TEAM_Multiple_Users_Existing.csv";
	public final static String CSV_FILENAME_ENT_EXISTING = "Template_Add_ENT_Multiple_Users_Existing.csv";
	public final static String DEFAULT_DOWNLOADPATH = System.getProperty("user.home")+"\\Downloads\\";

	public static final String PROD_EXECUTION_ENVIRONMENT = "prod_server";
	public static final String STAGING_EXECUTION_ENVIRONMENT = "staging_server_243";
	public static final String TEST_EXECUTION_ENVIRONMENT_91 = "test_server_91";
	public static final String TEST_EXECUTION_ENVIRONMENT_125 = "test_server_125";
	
	//Host address of Test and Staging server
	public static final String TEST_SERVER_91 = "173.255.9.91";
	public static final String TEST_SERVER_125 = "173.255.9.125";
	public static final String STAGING_SERVER_243 = "64.90.202.243";
	
	// SCreenshots path
	public static final String SCREENSHOTSPASSEDTESTPATH = System.getProperty("user.home")+"\\git\\webremotepc\\Screenshots\\PassTests\\";
	public static final String SCREENSHOTSFAILEDTESTPATH = System.getProperty("user.home")+"\\git\\webremotepc\\Screenshots\\FailTests\\";
	
	//Extent report path
	public static final String EXTENTREPORTFILENAME = "ExtentReport_" + date.printCurrentDateTime().replace("/", "_").replace(":", "_").replace(" ", "_") + ".html";
	public static final String EXTENTREPORTFILEPATH = System.getProperty("user.dir") + "\\test-output\\ExtentReport\\";
	
	//log4j file path
	public static final String LOG4JOUTPUTFILEDIRECTORY = System.getProperty("user.home")+"\\RPC\\logs-output\\log4j\\";
	public static final int DAYSBEFOREDELETINGOLDLOG4JFILE = 30;

}
