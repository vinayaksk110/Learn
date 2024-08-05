package Automation.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import TestBase.Constants;
import TestBase.Testbase;
import utility.DateNTime;



public class LearnITestResultListeners extends Testbase implements ITestListener {

	static DateNTime date = new DateNTime();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(
				"\n \n================Test being executed: " + result.getMethod().getMethodName() + "============\n");
		ITestListener.super.onTestStart(result);
		System.out.println("Page Title for this test is >>>> "+driver.getTitle());
		System.out.println("");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		if (!result.isSuccess())
			System.out.println("Testname: " + result.getMethod().getMethodName() + ", Test Failed==============>");
		try {
			takeScreenShotUtility.takeSnapShot(result.getMethod().getMethodName(), driver,
					Constants.SCREENSHOTSFAILEDTESTPATH);
		} catch (Exception e) {
			System.out.println("Error while taking screenshot: " + e.getStackTrace());
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		if (result.isSuccess())
			System.out.println("Testname: " + result.getMethod().getMethodName() + ", Test successful==============>");
		try {
			takeScreenShotUtility.takeSnapShot(result.getMethod().getMethodName(), driver,
					Constants.SCREENSHOTSPASSEDTESTPATH);
		} catch (Exception e) {
			System.out.println("Error while taking screenshot: " + e.getStackTrace());
		}
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(
				"Testname: " + result.getMethod().getMethodName() + ", Test Failed With Timeout==============>");
		ITestListener.super.onTestFailedWithTimeout(result);
		try {
			takeScreenShotUtility.takeSnapShot(result.getMethod().getMethodName(), driver,
					Constants.SCREENSHOTSFAILEDTESTPATH);
		} catch (Exception e) {
			System.out.println("Error while taking screenshot: " + e.getStackTrace());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testname: " + result.getMethod().getMethodName() + ", Test skipped==============>");
//		takeScreenShotUtility.takeSnapShot(result.getMethod().getMethodName(), driver, RPCConstants.SSFAILEDTESTPATH);
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
		System.out.println("\n \n================All tests completed ============\n");
	}

}
