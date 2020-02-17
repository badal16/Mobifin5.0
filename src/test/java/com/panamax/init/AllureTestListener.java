package com.panamax.init;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public abstract class AllureTestListener extends Common implements ITestListener {
	 @Attachment
	    public byte[] captureScreenshot(WebDriver d) {
	        return ((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES);
	    }
	    @Override
	    public void onTestFailure(ITestResult tr) {
	        Object webDriverAttribute = tr.getTestContext().getAttribute("WebDriver");
	        if (webDriverAttribute instanceof WebDriver) {
	            System.out.println("Screesnshot captured for test case:" + tr.getMethod().getMethodName());
	            captureScreenshot((WebDriver) webDriverAttribute);
	        }
	    }

}
