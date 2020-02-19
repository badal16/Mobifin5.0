package com.panamax.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.panamax.base.HomeWeb;
import com.panamax.base.LoginWeb;
import com.panamax.elasticUtils.LogMatrics;
import com.ssts.pcloudy.dto.screenshot.CaptureDeviceScreenshotDto;

import oracle.jdbc.pool.OracleDataSource;

//import oracle.jdbc.pool.OracleDataSource;

public class Common extends SetupInit {
	public String paginationValue = "25";
	public static boolean booleanValue = false;
	protected Boolean failure = false;
	protected String reason = "None";
	protected String detailedFailureReason = "None";
	protected String stacktrace = "None";
	protected float ScriptExecution = 50;
	private long endTime;
	long end = Long.MIN_VALUE;
	long start = Long.MAX_VALUE;
	long startMS;
	By btnAdd = By.id(readJSFile("OPERATIONBAR_BUTTON_ADD", FileType.element));
	By btnSave = By.id(readJSFile("OPERATIONBAR_BUTTON_SAVE", FileType.element));
	By btnCancel = By.xpath("(//*[normalize-space(text())='Cancel'])[last()]");
	By validationToolTip = By.xpath("//*[contains(text(),'already ')]");
	By validationToolTipSelect = By.xpath("(//*[contains(@class,'has-error')])[1]");
	By btnFilter = By.id(readJSFile("OPERATIONBAR_BUTTON_SERVERSEARCH", FileType.element));
	By btnFilterSearch = By.id("searchbutton");
	By btnInfo = By.xpath("(//td[@class='rest-table-action'])[last()]");
	By btnBack = By.id(readJSFile("OPERATIONBAR_BUTTON_BACK", FileType.element));
	By btnClear = By.id("clearbutton");
	By btnEdit = By.id(readJSFile("OPERATIONBAR_BUTTON_EDIT", FileType.element));
	By btnDelete = By.id(readJSFile("OPERATIONBAR_BUTTON_DELETE", FileType.element));
	By btnDeleteConfirm = By.xpath("(//*[@class='ant-btn ant-btn-primary'])[last()]");
	By drpPagination = By.xpath("(//div[contains(@class,'recordCount')]//select)[1]");
	By paginationCurrentValue = By
			.xpath("(//*[@class='dataTables_recordCount boot-style']//*[@class='chosen-single']//span)[1]");
	By txtQuickSearch = By.id("tableSearch");
	By stripText = By.xpath("(//*[@class='ant-notification-notice-message'])[last()]");
	By btnNext = By.xpath("(//*[text()='Next'])[last()]");
	By btnLog = By.xpath("(//button//*[normalize-space(text())='Log'])[last()]");
	By logPagination = By.id("defaultLogPagination");
	By btnLogIcon = By.id("editVendorProductInfoLog");
	By logPaginationIcon = By.id("productDivLogUL");
	By rows = By.xpath("//tbody//tr");
	By btnGridAdd = By.id("operationbarbuttongridsetting");
	By gridValues = By.xpath(
			"//*[contains(@class,'ant-select-dropdown ant-select-dropdown--multiple')]//li[@aria-selected='false']");
	By gridSetting = By.xpath("//*[contains(@class,'ant-select-search__field__wrap')]");
	By gridLabelValues = By.xpath("//*[contains(@role,'listbox')]//li");
	By btnDone = By.xpath("(//*[@value='Done'])[1]");
	By gridHeaders = By.xpath("//thead//th//span//span");
	By logout = By.xpath("//a[@title='Logout']");
	By verifyTable = By.xpath("//*[@class='table-responsive']//*[@id='moduleListTable_wrapper']");
	By verifyInnerDetailTable = By.xpath(".//*[@id='moduleListTable']/tbody//td[contains(@class,'dataTables_empty')]");
	By drpSearchBy = By.id("SearchBy");
	By txtPhoneORWalletAccountID = By.id("Phone");
	By txtDateOfBirth = By.id("DOB");
	By supportCustomer = By.xpath(".//*[@data-name='" + ConstantsFile.CUSTOMER + "']/a");
	By resetText = By.xpath("(//*[normalize-space()='Reset'])[last()]");
	By drpKYCStatus = By.id("SupportKycStatus");
	By blockLink = By.xpath(".//*[normalize-space(text())='" + ConstantsFile.CLICKHERETOBLOCK + "']");
	By unBlockLink = By.xpath(".//*[normalize-space(text())='" + ConstantsFile.CLICKHERETOUNBLOCK + "']");
	By supportComment = By.id("supportComment");
	By btnSubmitRequest = By.id("btnSearchGrid");
	By txtRequestNumber = By.id("requestID");
	By btnCheckStatus = By.id("btnCheckRequestStatus");
	By closeText = By.xpath("(//*[normalize-space()='Close'])[last()]");
	By terminal = By.id("DeviceCheck");
	By emailBox = By.xpath(".//*[@class='code-email']//a");
	By txtNewNumber = By.id("NewNumber");
	By txtOTP = By.id("OTP");
	By btnSubmit = By.xpath("//*[contains(@class,'submit')]");
	By btnYes = By.id("btnReset");
	By btnAddNominee = By.id("btnAddNominee");
	By btnStopSchedule = By.id("btnStopSchedule");
	By txtSupportComment = By.id("deleteComment");

	protected ReadXMLData fwTestData;
	public ReadXMLData fwConfigData;
	LoginWeb loginPage;
	HomeWeb homePage;
	LogMatrics logMatrics = new LogMatrics("automation_r&d_19_02_20", "data");

	public enum FileType {
		element, label
	}

	public void logData(Map<Object, Object> map) {
		// map.put("Steps To Reproduce", logList);
		Map<String, Object> dataMap =  getDataMap(map);
		if (dataMap.get("value") == null) {
			dataMap.put("value", 50);

			endTime = System.currentTimeMillis();
			if (endTime > end)
				end = endTime / 1000;
			if ((Long)map.get("Test Start Time") < start) {
				startMS = (Long)dataMap.get("Test Start Time");
				start = startMS / 1000;
			}
			dataMap.put("Test Start Time", formatTime(startMS));
			dataMap.put("Test End Time", formatTime(endTime));
			dataMap.put("Total Execution Time", millisToTimeConversion(end - start));
			logMatrics.logToElasticsearch(dataMap);
			
		} else if ((Integer) map.get("value") == 100) {
			
			endTime = System.currentTimeMillis();
			if (endTime > end)
				end = endTime / 1000;
			if ((Long)map.get("Test Start Time") < start) {
				startMS = (Long)dataMap.get("Test Start Time");
				start = startMS / 1000;
			}
			dataMap.put("Test Start Time", formatTime(startMS));
			dataMap.put("Test End Time", formatTime(endTime));
			dataMap.put("Total Execution Time", millisToTimeConversion(end - start));
			
			logMatrics.logToElasticsearch(dataMap);
		} else if ((Integer) dataMap.get("value") == 0) {
			try {
				logStatus(false);
				Assert.assertTrue(false);
			} catch (Exception e) {
				throw new RuntimeException(dataMap.get("Failure Reason").toString());
			}
		}
	}

	public Map<String, Object> getDataMap(Map<Object, Object> map) {
		Map<String, Object> dataToDump = new HashMap<>();
		for (Map.Entry<Object, Object> e : map.entrySet()) {
			dataToDump.put(e.getKey().toString(), e.getValue());
		}
		dataToDump.put("Executor IP", getIPOfNode());
		return dataToDump;
	}

	protected void logException(Throwable e, Map<Object, Object> map) {
		// map.put("Steps To Reproduce", logList);
		stacktrace = getStackStrace(e);
		Scanner sc = new Scanner(stacktrace);
		String firstLine = sc.nextLine();
		sc.close();
		Map<String, Object> dataMap = getDataMap(map);
		dataMap.put("Failure Reason", firstLine);
		dataMap.put("Datailed Failure Reason", stacktrace);
		
		endTime = System.currentTimeMillis();
		if (endTime > end)
			end = endTime / 1000;
		if ((Long)dataMap.get("Test Start Time") < start) {
			startMS = (Long)dataMap.get("Test Start Time");
			start = startMS / 1000;
		}
		
		dataMap.put("Test Start Time", formatTime(startMS));
		dataMap.put("Test End Time", formatTime(endTime));
		dataMap.put("Total Execution Time", millisToTimeConversion(end - start));
		
		String clsName = dataMap.get("Class Name").toString();
		String className =  clsName.contains(".") ? clsName.substring(clsName.lastIndexOf('.')+1) : clsName;
		dataMap.put("Failed Screenshot path", makeScreenshot(className, dataMap.get("Method Name").toString()));
		
		logMatrics.logToElasticsearch(dataMap);
		e.printStackTrace();
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
	
	public String formatTime(long time) {
		DateFormat formatter = new SimpleDateFormat("kk:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return formatter.format(calendar.getTime());
	}

	public static String getStackStrace(Throwable e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	protected String getExceptionMessage(Throwable e) {
		if (null != e.getMessage()) {
			return e.getMessage();
		} else {
			return "";
		}
	}

	/**
	 * @author dishant.doshi comparator for sort column data in descending order
	 * @creation date 17/12/2018
	 */
	Comparator<Entry<String, Integer>> descComparator = new Comparator<Entry<String, Integer>>() {

		@Override
		public int compare(Entry<String, Integer> a, Entry<String, Integer> b) {

			int compareWordCount = a.getValue().compareTo(b.getValue());

			if (compareWordCount == 0) {
				return b.getKey().compareToIgnoreCase(a.getKey());
			}
			return compareWordCount;
		}

	};

	/**
	 * @author dishant.doshi comparator for sort column data in ascending order
	 * @creation date 17/12/2018
	 */
	Comparator<Entry<String, Integer>> ascComparator = new Comparator<Entry<String, Integer>>() {

		@Override
		public int compare(Entry<String, Integer> a, Entry<String, Integer> b) {

			int compareWordCount = a.getValue().compareTo(b.getValue());

			if (compareWordCount == 0) {
				return a.getKey().compareToIgnoreCase(b.getKey());
			}
			return compareWordCount;
		}

	};

	protected WebElement highlightElement(WebElement element) {
		((JavascriptExecutor) this.driver).executeScript("arguments[0].style.border='2px solid blue'",
				new Object[] { element });
		return element;
	}

	/**
	 * @author vivek.mishra
	 * @param node1
	 *            top node
	 * @param node2
	 *            lower node
	 * @return node2 value
	 * @creation date 27/09/2018
	 */
	public String getTestData(String node1, String node2) {

		if (fwTestData == null)
			fwTestData = new ReadXMLData(test_data_folder_path + configFileName);
		return fwTestData.get(node1, node2);

	}

	/**
	 * @author dishant.doshi common actions for filter search
	 * @creation date 01/10/2018
	 */
	public void filterSearch() {
		commonFilterSearch();
		waitForLoader();
	}

	/**
	 * @author vivek.mishra
	 * @param element
	 *            to which text send
	 * @param text
	 *            to be sent
	 * @creation date 27/09/2018
	 * @modification by dishant.doshi
	 * @modification add report logs method
	 * @modification date 09/10/2018
	 */
	public void sendTextInTextBox(By element, String text) {
		String value = null;
		WebElement webElement = findVisibleElement(element);
		webElement.sendKeys(text.trim());
		List<String> attributes = getElementAttributes(webElement);
		if (attributes.contains("name")
				&& (!webElement.getAttribute("name").equals("") || !webElement.getAttribute("name").equals(null))) {
			value = webElement.getAttribute("name");
		} else if (attributes.contains("id")
				&& (!webElement.getAttribute("id").equals("") || !webElement.getAttribute("id").equals(null))) {
			value = webElement.getAttribute("id");
		} else if (attributes.contains("class")
				&& (!webElement.getAttribute("class").equals("") || !webElement.getAttribute("class").equals(null))) {
			value = webElement.getAttribute("class");
		}
		allureLog("Sent text in " + value + ": " + text);
		// logList.add("Sent text in " + value + ": " + text);
		value = "<b><span style='color:#3f0713'>" + value + "</span></b>";
		text = "<b><span style='color:#418eb5'>" + text + "</span></b>";
		log("Sent text in " + value + ": " + text);
	}

	/**
	 * @author dishant.doshi
	 * @param element
	 *            to which text send
	 * @param key
	 *            to be sent
	 * @creation date 22/11/2018
	 */
	public void sendTextInTextBox(By element, Keys key) {
		String value = null;
		WebElement webElement = findVisibleElement(element);
		webElement.sendKeys(key);
		List<String> attributes = getElementAttributes(webElement);
		if (attributes.contains("name")
				&& (!webElement.getAttribute("name").equals("") || !webElement.getAttribute("name").equals(null))) {
			value = webElement.getAttribute("name");
		} else if (attributes.contains("id")
				&& (!webElement.getAttribute("id").equals("") || !webElement.getAttribute("id").equals(null))) {
			value = webElement.getAttribute("id");
		} else if (attributes.contains("class")
				&& (!webElement.getAttribute("class").equals("") || !webElement.getAttribute("class").equals(null))) {
			value = webElement.getAttribute("class");
		}
		// logList.add("Sent text in " + value + ": " + key);
		value = "<b><span style='color:#3f0713'>" + value + "</span></b>";
		String text = "<b><span style='color:#418eb5'>" + key + "</span></b>";
		log("Sent text in " + value + ": " + text);
	}

	/**
	 * @author vivek.mishra
	 * @param element
	 *            to be clicked
	 * @creation date 27/09/2018
	 * @modification by dishant.doshi
	 * @modification add report logs method
	 * @modification date 09/10/2018
	 */
	public void clickOnElement(By element) {
		String value;
		WebElement webElement = findVisibleElement(element);
		highlightElement(webElement);
		value = getUIText(element);
		if (value.equals("") || value.equals(null) || value.equals(" ")) {
			List<String> attributes = getElementAttributes(webElement);
			if (attributes.contains("name")
					&& (!webElement.getAttribute("name").equals("") || !webElement.getAttribute("name").equals(null))) {
				value = webElement.getAttribute("name");
			} else if (attributes.contains("id")
					&& (!webElement.getAttribute("id").equals("") || !webElement.getAttribute("id").equals(null))) {
				value = webElement.getAttribute("id");
			} else if (attributes.contains("class") && (!webElement.getAttribute("class").equals("")
					|| !webElement.getAttribute("class").equals(null))) {
				value = webElement.getAttribute("class");
			} else if (attributes.contains("value") && (!webElement.getAttribute("value").equals("")
					|| !webElement.getAttribute("value").equals(null))) {
				value = webElement.getAttribute("value");
			}
		}
		findVisibleElement(element).click();
		allureLog("Clicked on " + value);
		// logList.add("Clicked on " + value);
		value = "<b><span style='color:#3f0713'>" + value + "</span></b>";
		log("Clicked on " + value);
	}

	/**
	 * @author dishant.doshi to get element's attributes
	 * @param element
	 * @return element's attributes list
	 * @creation date 09/10/2018
	 */
	public List<String> getElementAttributes(WebElement element) {
		List<String> elementAttributes = new ArrayList<String>();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			Object attribute = executor.executeScript(
					"var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",
					element);
			String[] attributes = attribute.toString().split(",");
			for (int i = 0; i < attributes.length; i++) {
				elementAttributes.add(attributes[i].split("=")[0].replace("{", "").replaceAll(" ", ""));
			}
		} catch (Exception e) {
			log("<b><span style='color:red'> Element " + element
					+ " contaning an attribute having null value </span></b>");
		}
		return elementAttributes;
	}

	/**
	 * @author dishant.doshi
	 * @param element
	 * @param attribute
	 *            - attribute name
	 * @return true if attribute present
	 * @creation date 10/10/2018
	 */
	public boolean isAttribtuePresent(WebElement element, String attribute) {
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		return result;
	}

	/**
	 * @author dishant.doshi to get element list
	 * @param elementsLocator
	 * @return lis of webelements
	 * @creation date 18/12/2018
	 */
	public List<WebElement> getElementList(By elementsLocator) {
		List<WebElement> listOfElemets = driver.findElements(elementsLocator);
		return listOfElemets;
	}

	/**
	 * @author vivek.mishra
	 * @return the home page reference
	 * @creation date 28/09/2018
	 */
	public HomeWeb goToHome() {
		HomeWeb homePage = new HomeWeb(getDriver());
		return homePage.clickOnHomeButton();
	}

	/**
	 * @author dishant.doshi To clear the text box
	 * @param element
	 * @creation date 28/09/2018
	 */
	public void clearTextFromTextBox(By element) {
		findVisibleElement(element).clear();
	}

	/**
	 * @author dishant.doshi To clear the text box and send new value in text box
	 * @param element
	 *            for clear value and send new value
	 * @param text
	 */
	public void clearAndSendTextInTextBox(By element, String text) {
		clearTextFromTextBox(element);
		sendTextInTextBox(element, text);
	}

	/**
	 * @author dishant.doshi Select value from drop down
	 * @param element
	 *            drop down box
	 * @param String
	 *            value to be selected
	 * @creation date 28/09/2018
	 * @modification by dishant.doshi
	 * @modification add report logs method
	 * @modification date 09/10/2018
	 */
	public void selectFromDropdown(By element, String string) {
		// removeReadonlyPropertyInDropdown(By.tagName("select"));
		String value = null;
		WebElement webElement = findPresentElement(element);
		Select select = new Select(webElement);
		String selectedValue = "";
		try {
			selectedValue = select.getFirstSelectedOption().getText().trim();
		} catch (Exception e) {
			selectedValue = "abc";
		}

		if (!selectedValue.equals(string)) {
			try {
				select.selectByVisibleText(string.trim());
			} catch (Exception e) {
				reloadCurrentPage();
			}
		}
		List<String> attributes = getElementAttributes(webElement);
		if (attributes == null || !attributes.isEmpty()) {
			if (attributes.contains("name") && (!webElement.getAttribute("name").equals(""))) {
				value = webElement.getAttribute("name");
			} else if (attributes.contains("id") && (!webElement.getAttribute("id").equals(""))) {
				value = webElement.getAttribute("id");
			} else if (attributes.contains("class") && (!webElement.getAttribute("class").equals(""))) {
				value = webElement.getAttribute("class");
			} else if (attributes.contains("value") && (!webElement.getAttribute("value").equals("")
					|| !webElement.getAttribute("value").equals(null))) {
				value = webElement.getAttribute("value");
			}
			// logList.add("Selected text " + string + " from " + value);
			value = "<b><span style='color:#3f0713'>" + value + "</span></b>";
			string = "<b><span style='color:#418eb5'>" + string + "</span></b>";
			log("Selected text " + string + " from " + value);
		}
	}

	/**
	 * @author dishant.doshi Select value from drop down
	 * @param element
	 *            drop down box using index of values
	 * @param String
	 *            value to be selected
	 * @creation date 18/10/2018
	 */
	public void selectFromDropdownByIndex(By element, int index) {
		removeReadonlyPropertyInDropdown(By.tagName("select"));
		String value = null;
		WebElement webElement = findVisibleElement(element);
		Select select = new Select(webElement);
		select.selectByIndex(index);
		List<String> attributes = getElementAttributes(webElement);
		if (attributes == null || !attributes.isEmpty()) {
			if (attributes.contains("name") && (!webElement.getAttribute("name").equals(""))) {
				value = webElement.getAttribute("name");
			} else if (attributes.contains("id") && (!webElement.getAttribute("id").equals(""))) {
				value = webElement.getAttribute("id");
			} else if (attributes.contains("class") && (!webElement.getAttribute("class").equals(""))) {
				value = webElement.getAttribute("class");
			}
			allureLog("Selected text " + index + " from " + value);
			// logList.add("Selected text " + index + " from " + value);
			value = "<b><span style='color:#3f0713'>" + value + "</span></b>";
			String string = "<b><span style='color:#418eb5'>" + index + "</span></b>";
			log("Selected text " + string + " from " + value);
		}
	}

	/**
	 * @author dishant.doshi To remove read only property
	 * @param List<elements>
	 *            to be set read only
	 * @creation date 28/09/2018
	 */
	public void removeReadonlyPropertyInDropdown(By elements) {
		findVisibleElement(elements);
		List<WebElement> inputs = getElementList(elements);
		for (WebElement element : inputs) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block'", element);
		}
	}

	/**
	 * @author dishant.doshi Select date
	 * @param element
	 * @param date
	 * @creation date 28/09/2018
	 */
	public void setDate(By element, String date) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value',arguments[1]);",
				findVisibleElement(element), date);
	}

	/**
	 * @author dishant.doshi Select current date return current date as a String
	 * @creation date 28/09/2018
	 */
	public String getCurrentDate() {
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime currentDate = LocalDateTime.now();
		String date = dateformatter.format(currentDate);
		return date;
	}

	/**
	 * @author dishant.doshi Get center point of element return center point of
	 *         element
	 * @creation date 28/09/2018
	 */
	public Point getCenter(By element) {
		Point point = findVisibleElement(element).getLocation();
		Dimension dimensions = findVisibleElement(element).getSize();
		return new Point(point.getX() + (dimensions.getWidth() / 2), point.getY() + (dimensions.getHeight() / 2));
	}

	/**
	 * @author dishant.doshi click on Add Button
	 * @creation date 28/09/2018
	 */
	public void clickOnAddBtn() {
		clickOnElement(btnAdd);
	}

	/**
	 * @author dishant.doshi click on Save Button
	 * @creation date 28/09/2018
	 */
	public void clickOnSaveBtn() {
		clickOnElement(btnSave);
		getStriptText();
		if (verifyToolTip()) {
			clickOnBackBtn();
		}
	}

	/**
	 * @author dishant.doshi click on Cancel Button
	 * @creation date 28/09/2018
	 */
	public void clickOnCancelBtn() {
		clickOnElement(btnCancel);
	}

	/**
	 * @author dishant.doshi common Filter Search
	 * @creation date 01/10/2018
	 */
	public void commonFilterSearch() {
		clickOnFilterBtn();
		clickOnClearBtn();
		// clickOnFilterBtn();
	}

	/**
	 * @author dishant.doshi click on Filter Button
	 * @creation date 01/10/2018
	 */
	public void clickOnFilterBtn() {
		clickOnElement(btnFilter);
	}

	/**
	 * @author dishant.doshi click on Edit Button
	 * @creation date 01/10/2018
	 */
	public void clickOnEditBtn() {
		clickOnElement(btnEdit);
	}

	/**
	 * @author dishant.doshi click on Filter Button
	 * @creation date 01/10/2018
	 */
	public void clickOnFilterSearchBtn() {
		clickOnElement(btnFilterSearch);
	}

	/**
	 * @author dishant.doshi click on Info Button
	 * @creation date 01/10/2018
	 */
	public void clickOnInfoBtn(String string) {
		clickOnElement(By.xpath("//td[normalize-space(text())='" + string.trim()
				+ "']//preceding-sibling::td[@class='center-align']//i"));
	}

	/**
	 * @author dishant.doshi click on Back Button
	 * @creation date 01/10/2018
	 */
	public void clickOnBackBtn() {
		clickOnElement(btnBack);
	}

	/**
	 * @author dishant.doshi click on Clear Button
	 * @creation date 01/10/2018
	 */
	public void clickOnClearBtn() {
		clickOnElement(btnClear);
	}

	/**
	 * @author dishant.doshi click on Delete Button
	 * @creation date 01/10/2018
	 */
	public void clickOnDeleteBtn() {
		clickOnElement(btnDelete);
	}

	public boolean verifyDeleteBtn() {
		return verifyElement(btnDelete, false);
	}

	/**
	 * @author dishant.doshi common actions for confirm delete
	 * @creation date 25/10/2018
	 */
	public void clickOnDeleteConfirm() {
		clickOnElement(btnDeleteConfirm);
	}

	/**
	 * @author dishant.doshi common actions for delete
	 * @creation date 02/10/2018
	 */
	public void delete() {
		clickOnDeleteBtn();
		clickOnDeleteConfirm();
		getStriptText();
	}

	/**
	 * @author dishant.doshi
	 * @param element
	 *            for which text to get
	 * @return text value
	 * @creation date 28/09/2018
	 */
	public String getUIText(By element) {
		return findPresentElement(element).getText().trim();
	}

	/**
	 * @author dishant.doshi to verify back button is available?
	 * @return true if back button is available
	 * @creation date 26/10/2018
	 */
	public boolean verifyBackBtn() {
		return verifyElement(btnBack, false);
	}

	/**
	 * @author dishant.doshi to verify filter search button is available?
	 * @return true if filter search button is available
	 * @creation date 30/10/2018
	 */
	public boolean verifyFilterBtn() {
		return verifyElement(btnFilter, false);
	}

	/**
	 * @author dishant.doshi
	 * @param state
	 *            Assert true
	 * @throws Exception
	 * @creation date 28/09/2018
	 */
	public void verifyTrue(boolean state) {
		if (verifyBackBtn())
			clickOnBackBtn();
		try {
			logStatus(state);
			Assert.assertTrue(state);
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
		String str = "Test Data Successfuly Verified";
		// logList.add(str);
		log("</br><b style='color:#02563d'>" + str + "</b></br>");
	}

	public void logStatus(boolean success) throws Exception {
		if (!success) {
			throw new Exception("Method has return false");
		}
	}

	public void logStatus(boolean success, String message) throws Exception {
		if (!success) {
			throw new Exception(message);
		}
	}

	public void verifyTrue(boolean state, boolean backBtn) {
		Assert.assertTrue(state);
		String str = "Test Data Successfuly Verified";
		// logList.add(str);
		log("</br><b style='color:#02563d'>" + str + "</b></br>");
	}

	/**
	 * @author dishant.doshi
	 * @param state
	 *            Assert false
	 * @creation date 28/09/2018
	 */
	public void verifyFalse(boolean state) {
		Assert.assertFalse(state);
		String str = "Test Data Successfuly Verified";
		// logList.add(str);
		log("</br><b style='color:#02563d'>" + str + "</b></br>");
	}

	/**
	 * @author dishant.doshi
	 * @param element
	 * @return true if element is displayed on UI
	 * @creation date 28/09/2018
	 */
	public boolean verifyElement(By element) {
		return isDisplayed(element);
	}

	/**
	 * @author dishant.doshi
	 * @param element
	 * @param wait
	 *            true if required to wait for 150 seconds
	 * @return true if element is displayed on UI
	 * @creation date 04/10/2018
	 */
	public boolean verifyElement(By element, boolean wait) {
		return isDisplayed(element);
	}

	/**
	 * @author dishant.doshi
	 * @param element
	 * @return true if validation message appear
	 * @creation date 28/09/2018
	 */
	public boolean verifyToolTip() {
		if (isDisplayed(validationToolTipSelect)) {
			String validationMessage = "Tooltip Validation Message : "
					+ getAttributeValue(validationToolTipSelect, "data-original-title");
			// logList.add(validationMessage);
			log("</br><b style='color:#E82F08'>" + validationMessage + "</b></br>");
			return true;
		} else if (isDisplayed(validationToolTip)) {
			String validationMessage = "Tooltip Validation Message : "
					+ getAttributeValue(validationToolTip, "data-original-title");
			// logList.add(validationMessage);
			log("</br><b style='color:#E82F08'>" + validationMessage + "</b></br>");

			return true;
		}
		return false;
	}

	/**
	 * @author dishant.doshi
	 * @param map
	 * @return list of keys of given map
	 * @creation date 01/10/2018
	 */
	public List<Object> getMapKeys(Map<Object, Object> map) {
		Set<Object> keySet = map.keySet();
		List<Object> keys = new ArrayList<Object>(keySet);
		return keys;
	}

	/**
	 * @author dishant.doshi
	 * @creation date 02/10/2018
	 */
	public void pagination() {
		if (!(getSelectedPaginationValue().equals(paginationValue)))
			selectFromDropdown(drpPagination, paginationValue);
	}

	public void pagination(int value) {
		if (!(getSelectedPaginationValue().equals(paginationValue)))
			selectFromDropdown(drpPagination, String.valueOf(value));
	}

	/**
	 * @author dishant.doshi
	 * @return to return selected pagination value
	 * @creation date 04/10/2018
	 */
	public String getSelectedPaginationValue() {
		if (verifyElement(paginationCurrentValue, false))
			return getUIText(paginationCurrentValue);
		else {
			String str = "No Records Found";
			// logList.add(str);
			log("</br><b style='color:#02563d'>" + str + "</b></br>");
			return paginationValue;
		}
	}

	/**
	 * @author dishant.doshi
	 * @param quick
	 *            search
	 * @creation date 02/10/2018
	 */
	public void quickSearch(String string) {
		pagination();
		clearAndSendTextInTextBox(txtQuickSearch, string);
	}

	/**
	 * @author dishant.doshi to get strip message
	 * @return strip message
	 * @creation date 10/10/2018
	 */
	public boolean getStriptText() {
		if (verifyElement(stripText, false)) {
			String text;
			try {
				text = "Strip Confirmation Message : " + getUIText(stripText);
			} catch (Exception e) {
				// logList.add("Strip Message Not Generated.");
				log("</br><b style='color:#02563d'> Strip Message Not Generated.</b></br>");
				return false;
			}
			// logList.add(text);
			log("</br><b style='color:#02563d'>" + text + "</b></br>");
			return true;
		} else {
			// logList.add("Strip Message Not Generated.");
			log("</br><b style='color:#02563d'> Strip Message Not Generated.</b></br>");
			return false;
		}
	}

	/**
	 * @author dishant.doshi to print logs
	 * @param message
	 * @creation date 10/10/2018
	 */
	public void log(String message) {
		Reporter.log(message);
	}

	/**
	 * @author shivani.patel
	 * @param click
	 *            on Next Button
	 * @creation date 03/10/2018
	 */
	public void clickOnNextBtn() {
		clickOnElement(btnNext);
	}

	/**
	 * @author Dishant.Doshi to wait for an actions values get loaded at other
	 *         element exception
	 * @creation date 12/10/2018
	 */
	public void commonWait() {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author kutbuddin.compounder to remove read only property from text box and
	 *         clear and send text in text box
	 * @param webElement
	 * @param string
	 * @creation date 25/10/2018
	 */
	public void sendTextWithRemoveReadOnlyProperty(String string, By webElement) {
		removeReadOnlyProperty(webElement);
		clearAndSendTextInTextBox(webElement, string);
	}

	/**
	 * @author kutbuddin.compounder to remove read only property from text box
	 * @param webElement
	 * @param string
	 * @creation date 31/10/2018
	 */
	public void removeReadOnlyProperty(By webElement) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')",
				findVisibleElement(webElement));
	}

	/**
	 * @author dishant.doshi to get given attribute value
	 * @param element
	 * @param attributeName
	 * @return attribute value if attribute is present
	 * @creation date 31/10/2018
	 */
	public String getAttributeValue(By element, String attributeName) {
		WebElement webElement = findVisibleElement(element);
		if (isAttribtuePresent(webElement, attributeName))
			return webElement.getAttribute(attributeName);
		return "";
	}

	/**
	 * @author dishant.doshi
	 * @param downloadPath
	 * @return file name
	 * @creation date 31/11/2018
	 */
	public String getFileName(String downloadPath) {
		String getLatestFile = getLatestFilefromDir(downloadPath).getAbsolutePath();
		return getLatestFile;
	}

	/**
	 * @author dishant.doshi to get latest file from given path
	 * @param dirPath
	 * @return latest file
	 * @creation date 23/11/2018
	 */
	public File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}
		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	/**
	 * @author dishant.doshi to copy file from one destination to other
	 * @param inputFile
	 * @creation date 23/11/2018
	 */
	public void copyFile(String inputFile) {
		FileInputStream instream = null;
		FileOutputStream outstream = null;
		String home = System.getProperty("user.home");
		String outputFile = home + "\\Downloads";
		try {
			File infile = new File(inputFile);
			File outfile = new File(outputFile);

			instream = new FileInputStream(infile);
			outstream = new FileOutputStream(outfile);

			byte[] buffer = new byte[1024];

			int length;
			while ((length = instream.read(buffer)) > 0) {
				outstream.write(buffer, 0, length);
			}

			instream.close();
			outstream.close();
			System.out.println("File copied successfully!!");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * @author dishant.doshi to set first letter of string in capital
	 * @param string
	 * @param onlyFirstChar
	 *            - true if only first letter of first word in caps and false if all
	 *            first char in caps
	 * @return string with first letter in capital
	 * @creation date 04/12/2018
	 */
	public String setFirstCharInCaps(String string, boolean onlyFirstChar) {
		string = string.toLowerCase();
		String text = "";
		if (!onlyFirstChar) {
			String[] words = string.split(" ");
			for (int i = 0; i < words.length; i++) {
				text = text + " " + words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
			}
		} else {
			string = string.toLowerCase();
			text = text + string.substring(0, 1).toUpperCase() + string.substring(1);
		}
		return text;
	}

	/**
	 * @author shivani.patel Select current date and time return current datetime as
	 *         a String
	 * @creation date 13/12/2018
	 */
	public String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);
		return dateTime;
	}

	/**
	 * @author kutbuddin.compounder click on log Button
	 * @creation date 13/12/2018
	 */
	public void clickOnLogBtn() {
		clickOnElement(btnLog);
	}

	/**
	 * @author kutbuddin.compounder click on log Button icon
	 * @creation date 13/12/2018
	 */
	public void clickOnLogIconBtn() {
		clickOnElement(btnLogIcon);
	}

	/**
	 * @author kutbuddin.compounder @ Verify Log Pagination
	 * @creation date 13/12/2018
	 */
	public boolean verifyLogPagination() {
		return verifyElement(logPagination, false);
	}

	/**
	 * @author kutbuddin.compounder @ Verify Log Pagination
	 * @creation date 20/12/2018
	 */
	public boolean verifyLogPaginationIcon() {
		return verifyElement(logPaginationIcon, false);
	}

	/**
	 * @author dishant.doshi to get grid table data
	 * @param uniqueColumnName
	 * @return map
	 * @creation date 14/12/2018
	 */
	public Map<String, List<String>> getTableData(String uniqueColumnName) {
		List<WebElement> tableRows = getElementList(rows);
		List<String> list;
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		for (int i = 1; i <= tableRows.size(); i++) {
			list = new ArrayList<String>();
			List<WebElement> tableCols = getElementList(
					By.xpath("//tbody//tr[" + i + "]//td[contains(@class,'sorters')]"));
			for (int j = 0; j < tableCols.size(); j++) {
				list.add(tableCols.get(j).getText());
			}
			By uniqueColumn = By.xpath("//tbody//tr[" + i + "]//td[3]");
			if (verifyElement(uniqueColumn, false))
				map.put(getUIText(uniqueColumn), list);
		}
		return map;
	}

	/**
	 * @author dishant.doshi to get grid column data
	 * @return list
	 * @creation date 14/12/2018
	 */
	public List<String> getColumnData(String columnName) {
		List<String> columnData = new ArrayList<String>();
		List<WebElement> columns = getElementList(By.xpath("//tbody//td[3]"));
		for (int i = 0; i < columns.size(); i++) {
			columnData.add(columns.get(i).getText().toString());
		}
		return columnData;
	}

	/**
	 * @author dishant.doshi to click on sort button
	 * @param columnName
	 *            - column name for sorting
	 * @param order
	 *            - ascending or descending
	 */
	public void clickOnSortBtn(String columnName, String order) {
		clickOnElement(By.xpath("//thead//*[normalize-space(text())='" + columnName + "']"));
		if (order.equalsIgnoreCase("Asc")) {
			if (!verifyElement(By.xpath("//thead//*[normalize-space(text())='" + columnName
					+ "']//ancestor::div[contains(@class,'sorter')]//i[contains(@class,'up off')]"), false))// Ascending
				clickOnElement(By.xpath("//thead//*[normalize-space(text())='" + columnName + "']"));
		} else {
			if (!verifyElement(By.xpath("//thead//*[normalize-space(text())='" + columnName
					+ "']//ancestor::div[contains(@class,'sorter')]//i[contains(@class,'up off')]"), false))
				clickOnElement(By.xpath("//thead//*[normalize-space(text())='" + columnName + "']"));
		}
	}

	/**
	 * @author dishant.doshi to compare two list values
	 * @param list1
	 * @param list2
	 * @return true is both list are same
	 */
	public boolean compareTwoLists(List<String> list1, List<String> list2) {
		return list1.toString().contentEquals(list2.toString()) ? true : false;
	}

	/**
	 * @author dishant.doshi
	 * @param list
	 *            - to be sorted
	 * @param order
	 *            - Asc for Ascending Order & Desc for Descending Order
	 * @creation date 17/12/2018
	 */
	public void sortColumn(List<String> list, String order) {
		if (order.equalsIgnoreCase("Desc")) {
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				String word = list.get(i);
				if (map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word, 1);
				}
			}
			List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
			Collections.sort(entries, descComparator);
		}

		else {
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				String word = list.get(i);
				if (map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word, 1);
				}
			}
			List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
			Collections.sort(entries, ascComparator);
		}
	}

	/**
	 * @author dishant.doshi to click on grid add icon
	 * @creation date 18/12/2018
	 */
	public void clickOnGridAddBtn() {
		clickOnElement(btnGridAdd);
	}

	/**
	 * @author dishant.doshi to click on done button
	 * @creation date 18/12/2018
	 */
	public void clickOnDoneBtn() {
		clickOnElement(btnDone);
	}

	/**
	 * @author dishant.doshi to add column in to grid
	 * @return list of columns
	 * @creation date 18/12/2018
	 */
	public List<String> addColumnInGrid() {
		String value = null;
		clickOnGridAddBtn();
		commonWait();
		clickOnElement(gridSetting);
		List<WebElement> list = getElementList(gridValues);
		List<String> gridValues = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).click();
			value = list.get(i).getAttribute("value");
			// logList.add(value);
			value = "<b><span style='color:#3f0713'>" + value + "</span></b>";
			log("Clicked on " + value);
		}
		List<WebElement> labelText = getElementList(gridLabelValues);
		for (int i = 0; i < labelText.size(); i++) {
			gridValues.add(labelText.get(i).getText().trim());
		}
		clickOnGridAddBtn();
		System.out.println(gridValues);
		return gridValues;
	}

	/**
	 * @author dishant.doshi verify column is added in grid
	 * @param list
	 * @return true if column is added in grid
	 * @creation date 18/12/2018
	 */
	public boolean verifyColumnInGrid(List<String> list) {
		List<WebElement> listHeaders = getElementList(gridHeaders);
		List<String> gridHeaderValues = new ArrayList<String>();
		for (int i = 0; i < listHeaders.size(); i++) {
			gridHeaderValues.add(listHeaders.get(i).getText().toString());
		}
		gridHeaderValues.remove(0);
		gridHeaderValues.remove(0);
		System.out.println(gridHeaderValues);
		for (int i = 0; i < list.size(); i++) {
			if (!gridHeaderValues.contains(list.get(i)))
				return false;
		}
		return true;
	}

	/**
	 * @author dishant.doshi to convert webelement to by type element
	 * @param webElement
	 * @return by element
	 * @creation date 18/12/2018
	 */
	public By toByVal(WebElement webElement) {
		String webElementString = webElement.toString();
		String[] data = webElementString.split(" -> ")[1].split(": ");
		String locator = data[0];
		String term = data[1];
		term = term.substring(0, term.length() - 1);

		switch (locator) {
		case "xpath":
			return By.xpath(term);
		case "css selector":
			return By.cssSelector(term);
		case "id":
			return By.id(term);
		case "tag name":
			return By.tagName(term);
		case "name":
			return By.name(term);
		case "link text":
			return By.linkText(term);
		case "class name":
			return By.className(term);
		}
		return (By) webElement;
	}

	/**
	 * @author dishant.doshi get activation link from db
	 * @return activation link as string
	 * @creation date 03/01/2019
	 */
	public String getActivationLinkFromDB() {
		fwConfigData = new ReadXMLData(test_data_folder_path + configFileName);
		String activationLink = "";
		Connection con = null;
		String IP = fwConfigData.get("DataBaseDetails", "IP");
		String port = fwConfigData.get("DataBaseDetails", "Port");
		String SID = fwConfigData.get("DataBaseDetails", "SID");
		String userName = fwConfigData.get("DataBaseDetails", "UserName");
		String password = fwConfigData.get("DataBaseDetails", "Password");
		try {

			OracleDataSource dataSource = new OracleDataSource();
			dataSource.setDriverType("thin");
			dataSource.setServerName(IP);
			dataSource.setPortNumber(Integer.parseInt(port));
			dataSource.setDatabaseName(SID);
			dataSource.setUser(userName);
			dataSource.setPassword(password);
			con = dataSource.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT OTP FROM COMOTP ORDER BY UPDATIONDATE DESC FETCH FIRST 1 ROWS ONLY");
			if (rs.next()) {
				activationLink = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return activationLink;
	}

	/**
	 * @author dishant.doshi to open new tab in browser
	 * @creation data 11/01/2019
	 * 
	 */
	public void openNewTabInBrowser() {
		((JavascriptExecutor) driver).executeScript("window.open()");
	}

	/**
	 * @author dishant.doshi to log out
	 * @creation data 15/01/2019
	 * 
	 */
	public void logout() {
		clickOnElement(logout);
	}

	/**
	 * @author dishant.doshi to verify table (in reports)
	 * @creation data 05/02/2019
	 * 
	 */
	public boolean verifyReportTable() {
		return verifyElement(verifyTable, false);
	}

	/**
	 * @author dishant.doshi to verify inner details table (in reports)
	 * @creation data 05/02/2019
	 * 
	 */
	public boolean verifyInnerDetailTable() {
		return verifyElement(verifyInnerDetailTable, false);
	}

	/**
	 * @author dishant.doshi to get text of inner table (in reports)
	 * @creation data 05/02/2019
	 * 
	 */
	public String getInnerTableText() {
		return getUIText(verifyInnerDetailTable);
	}

	/**
	 * @author shivani.patel to click on customer
	 * @creation data 30/05/2019
	 * 
	 */
	public void clickOnCustomer() {
		clickOnElement(supportCustomer);
	}

	/**
	 * @author shivani.patel to select search By from dropdown
	 * @creation data 30/05/2019
	 * 
	 */
	public void selectSearchBy(String str) {
		selectFromDropdown(drpSearchBy, str);
	}

	/**
	 * @author shivani.patel to send text in phone or walletaAccountId field
	 * @creation data 30/05/2019
	 * 
	 */
	public void sendTextInPhoneORWalletAccountID(String str) {
		clearAndSendTextInTextBox(txtPhoneORWalletAccountID, str);
	}

	/**
	 * @author shivani.patel to send text in dateOfBirth field
	 * @creation data 30/05/2019
	 * 
	 */
	public void sendTextInDateOfBirth(String str) {
		sendTextWithRemoveReadOnlyProperty(str, txtDateOfBirth);
	}

	/**
	 * @author shivani.patel to click on reset
	 * @creation data 30/05/2019
	 * 
	 */
	public void clickOnReset() {
		clickOnElement(resetText);
	}

	/**
	 * @author shivani.patel to click on close
	 * @creation data 31/05/2019
	 * 
	 */
	public void clickOnClose() {
		clickOnElement(closeText);
	}

	/**
	 * @author shivani.patel to search customerUser in support
	 * @creation data 30/05/2019
	 * 
	 */
	public void searchCustomerUser(String searchBy, String phone, String dateOfBirth) {
		selectSearchBy(searchBy);
		sendTextInPhoneORWalletAccountID(phone);
		sendTextInDateOfBirth(dateOfBirth);
	}

	/**
	 * @author shivani.patel to select kyc status from dropdown
	 * @creation data 30/05/2019
	 * 
	 */
	public void selectKYCStatus(String str) {
		selectFromDropdown(drpKYCStatus, str);
	}

	/**
	 * @author shivani.patel to click on blocklink
	 * @creation data 31/05/2019
	 * 
	 */
	public void clickOnBlockLink() {
		clickOnElement(blockLink);
	}

	/**
	 * @author shivani.patel to click on unblocklink
	 * @creation data 31/05/2019
	 * 
	 */
	public void clickOnUnblockLink() {
		clickOnElement(unBlockLink);
	}

	/**
	 * @author shivani.patel to send text in reson field
	 * @creation data 31/05/2019
	 * 
	 */
	public void sendTextInSupportComment(String str) {
		sendTextInTextBox(supportComment, str);
	}

	/**
	 * @author shivani.patel to click on submitRequest button
	 * @creation data 31/05/2019
	 * 
	 */
	public void clickOnSubmitRequestBtn() {
		clickOnElement(btnSubmitRequest);
	}

	/**
	 * @author shivani.patel get text of requestID
	 * @creation date 31/05/2019
	 */
	public String getRequestIDText() {
		String[] requestID = getUIText(stripText).split(":");
		return requestID[1].trim().toString();
	}

	/**
	 * @author shivani.patel sendText of requestNumber field
	 * @creation date 31/05/2019
	 */
	public void sendTextInRequestNumber(String str) {
		sendTextInTextBox(txtRequestNumber, str);
	}

	/**
	 * @author shivani.patel to click on checkStatus button
	 * @creation data 31/05/2019
	 * 
	 */
	public void clickOnCheckStatusBtn() {
		clickOnElement(btnCheckStatus);
	}

	/**
	 * @author shivani.patel Select Terminal
	 * @creation date 03/06/2019
	 */
	public void selectTerminal() {
		clickOnElement(terminal);
	}

	/**
	 * @author shivani.patel clickOnEmailBox
	 * @creation date 03/06/2019
	 */
	public void clickOnEmailBox() {
		clickOnElement(emailBox);
	}

	/**
	 * @author shivani.patel sendTextInNewPhoneNumber
	 * @creation date 05/06/2019
	 */
	public void sendTextInNewPhoneNumber(String str) {
		sendTextInTextBox(txtNewNumber, str);
	}

	/**
	 * @author shivani.patel clickOnGenerateOTP
	 * @creation date 05/06/2019
	 */
	public void clickOnGenerateOTP() {
		clickOnElement(btnSubmitRequest);
	}

	/**
	 * @author shivani.patel send text in otp field
	 * @creation date 05/06/2019
	 */
	public void sendTextInOTPField(String str) {
		sendTextInTextBox(txtOTP, str);
	}

	/**
	 * @author shivani.patel clickOn EmailBox
	 * @creation date 05/06/2019
	 */
	public void clickOnSubmitBtn() {
		clickOnElement(btnSubmit);
	}

	/**
	 * @author shivani.patel clickOn Yesbtn
	 * @creation date 05/06/2019
	 */
	public void clickOnYesBtn() {
		clickOnElement(btnYes);
	}

	/**
	 * @author shivani.patel clickOn AddNominee
	 * @creation date 05/06/2019
	 */
	public void clickOnAddNomineeBtn() {
		clickOnElement(btnAddNominee);
	}

	/**
	 * @author shivani.patel clickOn StopScheduleBtn
	 * @creation date 06/06/2019
	 */
	public void clickOnAddStopScheduleBtn() {
		clickOnElement(btnStopSchedule);
	}

	/**
	 * @author shivani.patel clickOn Transsction Reversal
	 * @creation date 13/06/2019
	 */
	public void sendTextInSupportDeleteComment(String str) {
		sendTextInTextBox(txtSupportComment, str);
	}

	public String readJSFile(String search, FileType fileType) {
		String fileName = "";
		if (fileType.equals(FileType.label)) {
			fileName = "./en-US.js";
			search = "'" + search + "'";
		} else if (fileType.equals(FileType.element)) {
			fileName = "./constants.js";
		}
		String[] searchString = null;
		String result = "";
		Path path = Paths.get(fileName);
		try (Scanner scanner = new Scanner(path)) {
			while (scanner.hasNextLine()) {
				searchString = scanner.nextLine().split(":");
				if (searchString[0].trim().equalsIgnoreCase(search.trim()))
					result = searchString[1].trim();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.substring(0, result.length() - 1).replaceAll("'", "");
	}

	public void commonWait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getIPOfNode() {
		// boolean isRemote = Boolean.parseBoolean(ReadProperty.getPropertyValue(""));
		boolean isRemote = Boolean.parseBoolean(getTestData("Master", "isRemoteEnable"));
		if (isRemote) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String hostFound = null;
			try {
				HttpCommandExecutor ce = (HttpCommandExecutor) ((RemoteWebDriver) this.driver).getCommandExecutor();
				String hostName = ce.getAddressOfRemoteServer().getHost();
				int port = ce.getAddressOfRemoteServer().getPort();
				HttpHost host = new HttpHost(hostName, port);
				HttpClient client = new DefaultHttpClient();
				URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session="
						+ ((RemoteWebDriver) this.driver).getSessionId());
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
		} else {
			String inetAddress = null;
			try {
				inetAddress = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException e) {
			}
			return inetAddress;
		}
	}

	public JSONObject extractObject(HttpResponse resp) throws IOException, JSONException {
		InputStream contents = resp.getEntity().getContent();
		StringWriter writer = new StringWriter();
		IOUtils.copy(contents, writer, "UTF8");
		JSONObject objToReturn = new JSONObject(writer.toString());
		return objToReturn;
	}

}
