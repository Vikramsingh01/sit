package com.meganexus.SIT_AutomationTesting.utility;

import java.sql.Timestamp;
import java.util.Date;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener, IInvokedMethodListener {
	public void generateReports() {

	}

	@Override
	public void onFinish(ITestContext arg0) {
		Reporter.log("Completed executing test " + arg0.getName(), true);

	}

	@Override
	public void onStart(ITestContext arg0) {
		Reporter.log("About to begin executting test " + arg0.getName(), true);

	}

	// !EbrUs4ne
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		printTestResults(result);
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		String timeStamp = t.toString();
		timeStamp = timeStamp.replace(' ', '_');
		timeStamp = timeStamp.replace(':', '_');
		System.out.println("Taking failed tests screen shots");
		String methodName = result.getName().toString().trim();
		// String dateTime=Utils.getSysDateAndTime();
		Utils.takeScreenShot("failedSS\\", methodName + " " + timeStamp);

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		printTestResults(arg0);

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		printTestResults(result);
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		String timeStamp = t.toString();
		timeStamp = timeStamp.replace(' ', '_');
		timeStamp = timeStamp.replace(':', '_');
		Log.info("Taking Passed tests screen shots");
		String methodName = result.getName().toString().trim();
		// String dateTime=Utils.getSysDateAndTime();
		Utils.takeScreenShot("passeddSS\\", methodName + " " + timeStamp);

	}

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		String textMsg = "Completed executing " + returnMethodName(arg0.getTestMethod());
		Reporter.log(textMsg, true);

	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		String textMsg = "About to begin executing " + returnMethodName(arg0.getTestMethod());
		Reporter.log(textMsg, true);

	}

	private String returnMethodName(ITestNGMethod method) {
		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}

	private void printTestResults(ITestResult result) {
		Reporter.log("TestName = " + result.getTestName(), true);
		Reporter.log("Test method resides in " + result.getTestClass(), true);
		if (result.getParameters().length != 0) {
			String params = null;
			for (Object parameter : result.getParameters()) {
				params += parameter.toString() + ",";
			}
			Reporter.log("Test Method had the following parameters : " + params, true);
		}
		String status = null;
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			status = "Pass";
		case ITestResult.FAILURE:
			status = "Failed";
		case ITestResult.SKIP:
			status = "Skipped";
		}
		Reporter.log("Test status: " + status, true);
	}

}
