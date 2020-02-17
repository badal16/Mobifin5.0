package com.panamax.init;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IClassListener;
import org.testng.IMethodInstance;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.Utils;

import com.panamax.elasticUtils.LogMatrics;

public class TestListner implements ISuiteListener, ITestListener, IClassListener {
	Map<String, Object> executiondData = new LinkedHashMap<>();
	private String stackTrace;
	RemoteWebDriver driver;
	private long startTime;
	private long endTime;
	long end = Long.MIN_VALUE;
	long start = Long.MAX_VALUE;
	long startMS;

	@Override
	public void onTestStart(ITestResult result) {
		startTime = System.currentTimeMillis();
		driver = (RemoteWebDriver) result.getTestContext().getAttribute("WebDriver");
		executiondData.put("Task Name", "Mobifin_5.0_Execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		executiondData.put("Method Name", result.getName());
		endTime = System.currentTimeMillis();
		if (endTime > end)
			end = endTime / 1000;
		if (startTime < start) {
			startMS = startTime;
			start = startMS / 1000;
		}
		DateFormat formatter = new SimpleDateFormat("kk:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Calendar calendar1 = Calendar.getInstance();
		calendar.setTimeInMillis(startMS);
		calendar1.setTimeInMillis(endTime);
		executiondData.put("Value", 100);
		executiondData.put("Test Start Time", formatter.format(calendar.getTime()));
		executiondData.put("Test End Time", formatter.format(calendar1.getTime()));
		executiondData.put("Total Execution Time", millisToTimeConversion(end - start));
		executiondData.put("Failure Reason", "N/A");
		executiondData.put("Executor IP", getIPOfNode());
		dataDumpInElasticSearch(executiondData);
	}

	private static String millisToTimeConversion(long seconds) {
		final int MINUTES_IN_AN_HOUR = 60;
		final int SECONDS_IN_A_MINUTE = 60;
		int minutes = (int) (seconds / SECONDS_IN_A_MINUTE);
		seconds -= minutes * SECONDS_IN_A_MINUTE;
		int hours = minutes / MINUTES_IN_AN_HOUR;
		minutes -= hours * MINUTES_IN_AN_HOUR;
		return prefixZeroToDigit(hours) + ":" + prefixZeroToDigit(minutes) + ":" + prefixZeroToDigit((int) seconds);
	}

	private static String prefixZeroToDigit(int num) {
		int number = num;
		if (number <= 9) {
			String sNumber = "0" + number;
			return sNumber;
		} else
			return "" + number;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		executiondData.put("Method Name", result.getName());
		endTime = System.currentTimeMillis();
		if (endTime > end)
			end = endTime / 1000;
		if (startTime < start) {
			startMS = startTime;
			start = startMS / 1000;
		}
		DateFormat formatter = new SimpleDateFormat("kk:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Calendar calendar1 = Calendar.getInstance();
		calendar.setTimeInMillis(startMS);
		calendar1.setTimeInMillis(endTime);
		executiondData.put("Value", 100);
		executiondData.put("Test Start Time", formatter.format(calendar.getTime()));
		executiondData.put("Test End Time", formatter.format(calendar1.getTime()));
		executiondData.put("Total Execution Time", millisToTimeConversion(end - start));
		executiondData.put("Value", 0);
		Scanner sc;
		String firstLine = "N/A";
		Throwable exception = result.getThrowable();
		boolean hasThrowable = exception != null;
		if (hasThrowable) {
			stackTrace = Utils.stackTrace(exception, true)[0];
			sc = new Scanner(stackTrace);
			firstLine = sc.nextLine();
		}
		executiondData.put("Detail Failure Reason", stackTrace);
		executiondData.put("Failure Reason", firstLine);
		executiondData.put("Executor IP", getIPOfNode());
		dataDumpInElasticSearch(executiondData);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		executiondData.put("Method Name", result.getName());
		endTime = System.currentTimeMillis();
		if (endTime > end)
			end = endTime / 1000;
		if (startTime < start) {
			startMS = startTime;
			start = startMS / 1000;
		}
		DateFormat formatter = new SimpleDateFormat("kk:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Calendar calendar1 = Calendar.getInstance();
		calendar.setTimeInMillis(startMS);
		calendar1.setTimeInMillis(endTime);
		executiondData.put("Value", 100);
		executiondData.put("Test Start Time", formatter.format(calendar.getTime()));
		executiondData.put("Test End Time", formatter.format(calendar1.getTime()));
		executiondData.put("Total Execution Time", millisToTimeConversion(end - start));
		executiondData.put("Value", 50);
		Scanner sc;
		String firstLine = "N/A";
		Throwable exception = result.getThrowable();
		boolean hasThrowable = exception != null;
		if (hasThrowable) {
			stackTrace = Utils.stackTrace(exception, true)[0];
			sc = new Scanner(stackTrace);
			firstLine = sc.nextLine();
		}
		executiondData.put("Detail Failure Reason", stackTrace);
		executiondData.put("Failure Reason", firstLine);
		executiondData.put("Executor IP", getIPOfNode());
		dataDumpInElasticSearch(executiondData);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

	private void dataDumpInElasticSearch(Map<String, Object> map) {
		LogMatrics logMatrics = new LogMatrics("mobifin_5_automation", "data");
		logMatrics.logToElasticsearch(map);
	}

	public String getIPOfNode() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String hostFound = null;
		try {
			HttpCommandExecutor ce = (HttpCommandExecutor) ((RemoteWebDriver) driver).getCommandExecutor();
			String hostName = ce.getAddressOfRemoteServer().getHost();
			int port = ce.getAddressOfRemoteServer().getPort();
			HttpHost host = new HttpHost(hostName, port);
			HttpClient client = new DefaultHttpClient();
			URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session="
					+ ((RemoteWebDriver) driver).getSessionId());
			BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST",
					sessionURL.toExternalForm());
			HttpResponse response = client.execute(host, r);
			JSONObject object = extractObject(response);
			URL myURL = new URL(object.getString("proxyId"));
			if ((myURL.getHost() != null) && (myURL.getPort() != -1)) {
				hostFound = myURL.getHost();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return hostFound;
	}

	public JSONObject extractObject(HttpResponse resp) throws IOException, JSONException {
		InputStream contents = resp.getEntity().getContent();
		StringWriter writer = new StringWriter();
		IOUtils.copy(contents, writer, "UTF8");
		JSONObject objToReturn = new JSONObject(writer.toString());
		return objToReturn;
	}

	@Override
	public void onStart(ISuite suite) {
		executiondData.put("Suite Name", suite.getName());
	}

	@Override
	public void onFinish(ISuite suite) {

	}

	@Override
	public void onBeforeClass(ITestClass testClass, IMethodInstance mi) {

	}

	@Override
	public void onAfterClass(ITestClass testClass, IMethodInstance mi) {

	}

	private String milliSecondToDefaultTime(long t) {
		int hours = (int) t / 60;
		int minutes = (int) t % 60;
		BigDecimal secondsPrecision = new BigDecimal((t - Math.floor(t)) * 100).setScale(2, RoundingMode.HALF_UP);
		int seconds = secondsPrecision.intValue();

		boolean nextDay = false;

		if (seconds > 59) {
			minutes++; // increment minutes by one
			seconds = seconds - 60; // recalculate seconds
		}

		if (minutes > 59) {
			hours++;
			minutes = minutes - 60;
		}
		final String myFormat = seconds >= 10 ? "%d:%02d:%d" : "%d:%02d:0%d";
		final String time = String.format(myFormat, hours, minutes, seconds);
		return time;
	}
}