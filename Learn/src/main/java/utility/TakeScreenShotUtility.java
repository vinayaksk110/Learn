package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShotUtility {
	public static WebDriver driver = null;
	
	public TakeScreenShotUtility() {
		
	}
	
	public TakeScreenShotUtility(WebDriver driver) {
		TakeScreenShotUtility.driver = driver;
	}

	public void takeSnapShot(String testName, WebDriver driver, String destinationPath) {
		try {
			Date date = new Date() ;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmm") ;
			// Call getScreenshotAs method to create image file
			File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Move image file to new destination
			File DestFile = new File(destinationPath+dateFormat.format(date)+"_"+testName+".png");
			// Copy file at destination
			FileUtils.copyFile(SrcFile,DestFile);
			System.out.println("Screenshot saved to the path ====>"+destinationPath);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Screenshot method failed due to following reason"+ioe.getMessage());
		}
	}

}
