package utility;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.network.Network;
import org.openqa.selenium.devtools.v125.network.model.Request;
import org.openqa.selenium.devtools.v125.network.model.Response;
import org.openqa.selenium.edge.EdgeDriver;

public class CaptureNetworkLogs {

	DevTools devTools;
	Logger networkLog;

	public void captureNetworkLogs(WebDriver driver, String browserName) {
//		log = LogManager.getLogger(CaptureNetworkLogs.class.getName());
		networkLog = Logger.getLogger("networkLog");
		if (browserName.equalsIgnoreCase("Chrome")) {
			devTools = ((ChromeDriver) driver).getDevTools();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			devTools = ((EdgeDriver) driver).getDevTools();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.out.println("Cannot store console logs for Firefox driver");
		}

		try {
			devTools.createSession();
			devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			devTools.addListener(Network.requestWillBeSent(), requestConsumer -> {
				Request request = requestConsumer.getRequest();
				networkLog.info("Request>>> "+request.getUrl());
			});
			
			devTools.addListener(Network.responseReceived(), responseConsumer -> {
				Response response = responseConsumer.getResponse();
				networkLog.info("Response>>> "+response.getStatus() + " " + response.getUrl() + " "+ response);
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error while capturing console logs from capture console logs.");
		}
	}

}
