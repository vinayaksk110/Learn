package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.log.Log;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import org.apache.log4j.Logger;

public class CaptureConsoleLogs {

	DevTools devTools;
	Logger consoleLog;

	public void captureConsoleLogs(WebDriver driver, String browserName) {
//		log = LogManager.getLogger(CaptureConsoleLogs.class.getName());
		consoleLog = Logger.getLogger("consoleLog");
		if (browserName.equalsIgnoreCase("Chrome")) {
			devTools = ((ChromeDriver) driver).getDevTools();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			devTools = ((EdgeDriver) driver).getDevTools();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.out.println("Cannot store console logs for Firefox driver");
		}

		// As we are moving console logs as a experimental feature commented the old
		// code, in case if we need old code we can move back
//		try {
//		devTools.createSession();
//		devTools.send(Log.enable());
//		devTools.addListener(Log.entryAdded(), LogEntry -> {
//			consoleLog.info(LogEntry.getLevel() + " - " + LogEntry.getText() + "\n" + LogEntry.getUrl().toString());
//		});
//	} catch (Exception e) {
//		e.printStackTrace();
//		System.out.println("Error while capturing console logs from capture console logs.");
//	}

		try {
			devTools.createSession();
			devTools.send(Log.enable());
			devTools.addListener(Log.entryAdded(), LogEntries -> {
				LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
				List<LogEntry> logs = entry.getAll();
				for (LogEntry log : logs) {
					consoleLog.info(log.getLevel() + " - " + log.getMessage());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error while capturing console logs from capture console logs.");
		}
	}
}
