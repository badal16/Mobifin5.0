package com.panamax.init;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.panamax.base.LoginWeb;
import com.panamax.pcloudy.DeviceContext;
import com.panamax.pcloudy.pCloudyController_Runner;
import com.ssts.pcloudy.Connector;
import com.ssts.pcloudy.Version;
import com.ssts.pcloudy.appium.PCloudyAppiumSession;
import com.ssts.pcloudy.dto.appium.booking.BookingDtoDevice;
import com.ssts.pcloudy.dto.device.MobileDevice;
import com.ssts.pcloudy.dto.file.PDriveFileDTO;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

public class SetupInit {
	private static int setupCounter = 0;
	public boolean maskingAllowed = Boolean.parseBoolean(ReadProperty.getPropertyValue("MaskingAllowed"));
	public boolean viewReport = Boolean.parseBoolean(ReadProperty.getPropertyValue("ViewReport"));
	public static String configFileName = ReadProperty.getPropertyValue("ConfigurationFileName");
	public static String dkycFile = ReadProperty.getPropertyValue("DKYCFileName");
	public final String REPORT_FOLDER = ReadProperty.getPropertyValue("REPORT_FOLDER") + File.separator;
	public final String SCREENSHOT_FOLDER = ReadProperty.getPropertyValue("SCREENSHOT_FOLDER");
	public final String VIDEOS_FOLDER = ReadProperty.getPropertyValue("VIDEOS_FOLDER");
	public final String TESTDATA_FOLDER = ReadProperty.getPropertyValue("TESTDATA_FOLDER");
	public final String RESOURCES_FOLDER = TESTDATA_FOLDER + "/" + ReadProperty.getPropertyValue("RESOURCES_FOLDER")
			+ "/";
	public final String DOWNLOADS_FOLDER = ReadProperty.getPropertyValue("DOWNLOADS_FOLDER") + "/";
	public final String currentDir = System.getProperty("user.dir");
	public final String DEPENDENCIES_FOLDER = (currentDir + "\\" + ReadProperty.getPropertyValue("DEPENDENCIES_FOLDER")
			+ "\\");
	public final String APPLICATIONS_FOLDER = (currentDir + "\\" + ReadProperty.getPropertyValue("APPLICATIONS_FOLDER")
			+ "\\");
	public final String MOBILE_APP_PACKAGE_NAME = ReadProperty.getPropertyValue("MOBILE_APP_PACKAGE_NAME");

	private int GENERAL_TIMEOUT = 30;
	private int MOBILE_GENERAL_TIMEOUT = 15;
	private int MAX_WAIT_TIME_IN_SEC = 10;// Integer.parseInt(ReadProperty.getPropertyValue("MAX_WAIT_TIME_IN_SEC"));
	private int POLLING_MAX_TIME_IN_MILLISEC = 400;
	private int MOBILE_POLLING_IN_MILLISECONDS = 30;

	public Date testStartTime;
	protected WebDriver driver;
	protected RemoteWebDriver mobileDriver;
	Wait<WebDriver> wait;
	static URL remote_grid;
	int reloadCounter = 0;

	public ReadXMLData configFileObj;
	protected ReadXMLData fwTestData = null;

	/* Minimum requirement for test configuration */
	protected String appType; // AUT Type
	protected String isRemoteEnable;
	protected String hubUrl; // Selenium hub IP
	protected String hubPort; // Selenium hub port
	protected String appWaitActivity;

	public String testUrl;

	protected String targetBrowser;

	protected static String test_data_folder_path = null;
	protected static String screenshot_folder_path = null;
	protected static String resources_folder_path = null;
	public boolean logDefectAutomated = false;
	public boolean recordSessionVideo = false;
	private static boolean incognito;
	static ReadXMLData readFilePath = null;
	protected static String proxyIP;
	protected static String proxyPort;
	String regexTCID;
	String regexAuthor;
	String sessionid = "";
	String videoURL = "";

	// **********PCloudy relevant************/////////
	boolean autoSelectDevices;
	String pcloudyMailID;
	String pCloudyApikey;
	int deviceBookDuration;
	String pcloudyPlateformName;
	String pcloudyPlateformVersionFrom;
	String pcloudyPlateformVersionTo;
	int pcloudyDeviceCount;
	PCloudyAppiumSession pCloudySession;
	static int pcloudyCounter = 0;
	static DesiredCapabilities capabilities;
	static URL endpoint;
	// **********PCloudy relevant************/////////

	Common commonWeb;
	LoginWeb loginPage;

	@Step("{0}.")
	public void allureLog(String message) {
		System.out.println(message);
	}

	protected enum Condition {
		isDisplayed, isClickable, isPresent
	}

	protected enum Speed {
		slow
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public RemoteWebDriver getAndroidDriver() {
		return this.mobileDriver;
	}

	private void setDriver(String browserType) {
		String toLowerCase = browserType.toLowerCase();
		int obj = -1;
		switch (toLowerCase.hashCode()) {
		case -1361128838:
			if (toLowerCase.equals("chrome")) {
				obj = 0;
				break;
			}
		case -1115062407:
			if (toLowerCase.equals("headless")) {
				obj = 1;
				break;
			}
		case -849452327:
			if (toLowerCase.equals("firefox")) {
				obj = 2;
				break;
			}
		case 3356:
			if (toLowerCase.equals("ie")) {
				obj = 3;
				break;
			}
		case 472085556:
			if (toLowerCase.equals("chromeproxy")) {
				obj = 4;
				break;
			}
		case -1862645963:
			if (toLowerCase.equals("firefoxproxy")) {
				obj = 5;
				break;
			}
		default:
			obj = 2;
			break;
		}
		switch (obj) {
		case 0:
			this.driver = initChromeDriver();
			return;
		case 1:
			this.driver = initChromeHeadlessDriver();
			return;
		case 2:
			this.driver = initFirefoxDriver();
			return;
		case 3:
			this.driver = initIEDriver();
			return;
		case 4:
			this.driver = initChromeProxyDriver();
			return;
		case 5:
			this.driver = initFirefoxProxyDriver();
			return;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			this.driver = initFirefoxDriver();
			return;
		}
	}

	private WebDriver initChromeHeadlessDriver() {
		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments(new String[] { "headless" });
		chromeOptions.addArguments(new String[] { "window-size=1200x600" });
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	private WebDriver initChromeDriver() {
		System.out.println("Launching google chrome with new profile..");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", Integer.valueOf(0));
		chromePrefs.put("download.default_directory", DOWNLOADS_FOLDER);
		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		if (incognito)
			options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extenstions");
		options.addArguments(new String[] { "disable-infobars" });
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("acceptSslCerts", true);
		capabilities.setCapability("goog:chromeOptions", options);
		capabilities.setCapability("screen-resolution", "1280x1024");
		if (isRemoteEnable.equalsIgnoreCase("true")) {
			driver = new RemoteWebDriver(remote_grid, capabilities);
			return driver;
		}
		driver = new ChromeDriver(capabilities);
		return driver;
	}

	private WebDriver initFirefoxDriver() {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", DEPENDENCIES_FOLDER + "geckodriver.exe");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability("gecko", true);
		if (isRemoteEnable.equalsIgnoreCase("true")) {
			driver = new RemoteWebDriver(remote_grid, dc);
			return driver;
		}
		driver = new FirefoxDriver(dc);
		return driver;
	}

	private WebDriver initIEDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setPlatform(Platform.ANY);
		capabilities.setBrowserName("internet explorer");
		// capabilities.setVersion("8.0");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		capabilities.setJavascriptEnabled(true);
		if (isRemoteEnable.equalsIgnoreCase("true")) {
			driver = new RemoteWebDriver(remote_grid, capabilities);
			return driver;
		}
		driver = new InternetExplorerDriver(capabilities);
		return driver;
	}

	private WebDriver initChromeProxyDriver() {
		configFileObj = new ReadXMLData(test_data_folder_path + configFileName);
		proxyIP = configFileObj.get("Proxy", "ProxyIP");
		proxyPort = configFileObj.get("Proxy", "ProxyPort");
		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyIP + ":" + proxyPort);
		proxy.setFtpProxy(proxyIP + ":" + proxyPort);
		proxy.setSslProxy(proxyIP + ":" + proxyPort);
		proxy.setSocksProxy(proxyIP + ":" + proxyPort);

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setProxy(proxy);
		chromeOptions.addArguments("test-type");
		if (incognito)
			chromeOptions.addArguments("--incognito");
		chromeOptions.addArguments("disable-infobars");
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		capabilities.setCapability("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setBrowserName("chrome");
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("proxy", proxy);
		if (isRemoteEnable.equalsIgnoreCase("true")) {
			driver = new RemoteWebDriver(remote_grid, capabilities);
			return driver;
		}
		driver = new ChromeDriver(capabilities);
		return driver;
	}

	private WebDriver initFirefoxProxyDriver() {
		FirefoxProfile profile1 = new FirefoxProfile();
		configFileObj = new ReadXMLData(test_data_folder_path + configFileName);
		proxyIP = configFileObj.get("Proxy", "ProxyIP");
		proxyPort = configFileObj.get("Proxy", "ProxyPort");
		System.setProperty("webdriver.gecko.driver", DEPENDENCIES_FOLDER + "geckodriver.exe");
		profile1.setPreference("dom.max_chrome_script_run_time", "999");
		profile1.setPreference("dom.max_script_run_time", "999");
		profile1.setPreference("browser.download.folderList", 2);
		profile1.setPreference("browser.download.useDownloadDir", true);
		profile1.setPreference("browser.download.manager.showWhenStarting", false);
		profile1.setPreference("javascript.enabled", true);
		profile1.setPreference("network.http.use-cache", false);
		profile1.setPreference("network.proxy.type", 1);
		profile1.setPreference("network.proxy.http", proxyIP);
		profile1.setPreference("network.proxy.http_port", proxyPort);
		profile1.setPreference("network.proxy.ssl", proxyIP);
		profile1.setPreference("network.proxy.ssl_port", proxyPort);
		profile1.setPreference("network.proxy.ftp", proxyIP);
		profile1.setPreference("network.proxy.ftp_port", proxyPort);
		profile1.setPreference("network.proxy.socks", proxyIP);
		profile1.setPreference("network.proxy.socks_port", proxyPort);
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setProfile(profile1);
		options1.setAcceptInsecureCerts(true);
		if (isRemoteEnable.equalsIgnoreCase("true")) {
			driver = new RemoteWebDriver(remote_grid, options1);
			return driver;
		}
		driver = new FirefoxDriver(options1);
		return driver;
	}

	private RemoteWebDriver initAndroidDriver(String browserType, String appName) {
		String deviceName = browserType.split(":")[0].trim();
		String platformVersion = browserType.split(":")[1].trim();
		File app = new File(APPLICATIONS_FOLDER + appName.trim());
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appWaitActivity", appWaitActivity);
		capabilities.setCapability("newCommandTimeout", 800);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		mobileDriver = new AndroidDriver(remote_grid, capabilities);
		return mobileDriver;
	}

	private RemoteWebDriver initPcloudyDriver(String appName) {
		if (pcloudyCounter == 0) {
			pcloudyCounter++;
			String authToken = null;
			PDriveFileDTO alreadyUploadedApp;
			BookingDtoDevice[] bookedDevices = null;
			ArrayList<MobileDevice> selectedDevices = new ArrayList<>();

			Connector con = new Connector("https://device.pcloudy.com/api/");
			// User Authentication over pCloudy
			try {
				authToken = con.authenticateUser(pcloudyMailID, pCloudyApikey);

				// Select apk in pCloudy Cloud Drive
				File fileToBeUploaded = new File(APPLICATIONS_FOLDER + appName.trim());
				alreadyUploadedApp = con.getAvailableAppIfUploaded(authToken, fileToBeUploaded.getName());
				if (alreadyUploadedApp == null) {
					System.out.println("Uploading App: " + fileToBeUploaded.getAbsolutePath());
					PDriveFileDTO uploadedApp = con.uploadApp(authToken, fileToBeUploaded, false);
					System.out.println("App uploaded");
					alreadyUploadedApp = new PDriveFileDTO();
					alreadyUploadedApp.file = uploadedApp.file;
				} else {
					System.out.println("App already present. Not uploading... ");
				}

				if (autoSelectDevices)
					selectedDevices.addAll(
							con.chooseDevices(authToken, pcloudyPlateformName, new Version(pcloudyPlateformVersionFrom),
									new Version(pcloudyPlateformVersionTo), pcloudyDeviceCount));
				else
					selectedDevices.addAll(con.chooseMultipleDevices(authToken, pcloudyPlateformName));

				String sessionName = selectedDevices.get(0).display_name + " Appium Session";

				bookedDevices = con.AppiumApis().bookDevicesForAppium(authToken, selectedDevices, deviceBookDuration,
						sessionName);
				System.out.println("Devices booked successfully");

				con.AppiumApis().initAppiumHubForApp(authToken, alreadyUploadedApp);
				endpoint = con.AppiumApis().getAppiumEndpoint(authToken);
				URL reportFolderOnPCloudy = con.AppiumApis().getAppiumReportFolder(authToken);
			} catch (Exception e) {
				e.printStackTrace();
			}

			for (int i = 0; i < bookedDevices.length; i++) {
				BookingDtoDevice aDevice = bookedDevices[i];
				pCloudySession = new PCloudyAppiumSession(con, authToken, aDevice);
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("newCommandTimeout", 800);
				capabilities.setCapability("launchTimeout", 9000);
				capabilities.setCapability("deviceName", aDevice.capabilities.deviceName);
				capabilities.setCapability("platformName", pcloudyPlateformName);
				capabilities.setCapability("rotatable", true);
				capabilities.setCapability("autoGrantPermissions", true);
				capabilities.setCapability("appWaitActivity", appWaitActivity);
				capabilities.setCapability("unicodeKeyboard", "true");
				capabilities.setCapability("resetKeyboard", "true");
			}
		}
		mobileDriver = new AndroidDriver<WebElement>(endpoint, capabilities);
		return mobileDriver;
	}

	private RemoteWebDriver initPcloudyRunner(String myDeviceContext) {
		DeviceContext myContext = pCloudyController_Runner.allDeviceContexts.get(myDeviceContext);
		myContext.driver = new AndroidDriver<WebElement>(myContext.endpoint, myContext.capabilities);
		return myContext.driver;
	}

	public WebElement findVisibleElement(By locator) {
		return waitAndFindElement(locator, Condition.isDisplayed, this.MAX_WAIT_TIME_IN_SEC,
				this.POLLING_MAX_TIME_IN_MILLISEC);
	}

	public WebElement findPresentElement(By locator) {
		return waitAndFindElement(locator, Condition.isPresent, this.MAX_WAIT_TIME_IN_SEC,
				this.POLLING_MAX_TIME_IN_MILLISEC);
	}

	private WebElement waitAndFindElement(By locator, Condition condition, int timeOutInSeconds,
			int pollingInMilliSeconds) {
		WebElement foo = null;
		do {
		} while (!waitForLoader());
		do {
		} while (!isAjaxCallCompleted());
		this.wait = new FluentWait(this.driver).withTimeout((long) timeOutInSeconds, TimeUnit.SECONDS)
				.pollingEvery((long) pollingInMilliSeconds, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		switch (condition) {
		case isClickable:
			try {
				foo = (WebElement) this.wait.until(ExpectedConditions.elementToBeClickable(locator));
			} catch (Exception e) {
			}

			break;
		case isDisplayed:
			try {
				foo = (WebElement) this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			} catch (Exception e) {
			}
			break;
		case isPresent:
			try {
				foo = (WebElement) this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			} catch (Exception e) {
			}
			break;
		}
		if (!isVisibleInViewport(foo)) {
			scrollToElement(foo);
		}
		return foo;
	}

	protected void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		if (!isVisibleInViewport(element)) {
			((JavascriptExecutor) driver).executeScript(
					"window.scrollTo(" + element.getLocation().x + "," + (element.getLocation().y - 80) + ");");
		}
	}

	private boolean isAjaxCallCompleted() {
		WebDriverWait wait = new WebDriverWait(this.driver, (long) this.GENERAL_TIMEOUT);
		wait.ignoring(StaleElementReferenceException.class);
		try {
			return ((Boolean) wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver inDriver) {
					boolean z = SetupInit.this.isJQueryLoaded() && SetupInit.this.isJSLoaded();
					return Boolean.valueOf(z);
				}

				public String toString() {
					return "Waiting for Ajax call to be completed";
				}
			})).booleanValue();
		} catch (TimeoutException e) {
			return false;
		}
	}

	private boolean isJSLoaded() {
		return ((JavascriptExecutor) this.driver).executeScript("return document.readyState", new Object[0]).toString()
				.equals("complete");
	}

	public boolean isJQueryLoaded() {
		try {
			return ((Long) ((JavascriptExecutor) this.driver).executeScript("return jQuery.active", new Object[0]))
					.longValue() == 0;
		} catch (Exception e) {
			return true;
		}
	}

	protected boolean isVisibleInViewport(WebElement element) {
		return ((Boolean) ((JavascriptExecutor) ((RemoteWebElement) element).getWrappedDriver()).executeScript(
				"var elem = arguments[0],                   box = elem.getBoundingClientRect(),      cx = box.left + box.width / 2,           cy = box.top + box.height / 2,           e = document.elementFromPoint(cx, cy); for (; e; e = e.parentElement) {           if (e === elem)                            return true;                         }                                        return false;                            ",
				new Object[] { element })).booleanValue();
	}

	@Parameters({ "browserType", "appURL", "myDeviceContext" })
	@BeforeClass
	public void initializeSetupInit(@Optional String browserType, @Optional String appURL,
			@Optional String myDeviceContext, ITestContext testContext) {
		this.targetBrowser = browserType;
		this.testUrl = appURL;
		test_data_folder_path = new File(TESTDATA_FOLDER).getAbsolutePath() + "\\";
		screenshot_folder_path = new File(SCREENSHOT_FOLDER).getAbsolutePath() + "\\";
		resources_folder_path = new File(RESOURCES_FOLDER).getAbsolutePath() + "\\";
		File downloadsDirectoryName = new File(DOWNLOADS_FOLDER);
		if (!downloadsDirectoryName.exists()) {
			downloadsDirectoryName.mkdir();
		}
		removeFolder("allure-report");
		if (setupCounter == 0) {
			removeFolder(ReadProperty.getPropertyValue("REPORT_FOLDER"));
			setupCounter++;
		}
		fetchSuiteConfiguration("Master");
		testStartTime = new Date();
		if (isRemoteEnable.equalsIgnoreCase("true")) {
			try {
				remote_grid = new URL("http://" + hubUrl + ":" + hubPort + "/wd/hub");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
		if (recordSessionVideo == true) {
			File f = new File(REPORT_FOLDER + VIDEOS_FOLDER);
			if (!f.exists()) {
				f.mkdirs();
			}

		}
		commonWeb = new Common();
		switch (appType) {
		case "web":
			try {
				setDriver(targetBrowser);
				testContext.setAttribute("WebDriver", this.driver);
			} catch (Exception e) {
				System.out.println(e);
			}
			this.driver.get(testUrl);
			// driver.manage().window().maximize();
			String userNameVal = commonWeb.getTestData("Admin", "username");
			String passwordVal = commonWeb.getTestData("Admin", "password");
			loginPage = new LoginWeb(this.driver);
			loginPage.login(userNameVal, passwordVal);
			break;

		case "android":
			this.mobileDriver = initAndroidDriver(browserType, appURL);
			break;
		case "pcloudy":
			this.mobileDriver = initPcloudyDriver(appURL);
			break;
		case "pcloudyrunner":
			this.mobileDriver = initPcloudyRunner(myDeviceContext);
			break;
		case "ios":
			break;
		default:
			break;
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {
		if (appType.equals("pcloudy") || appType.equals("pcloudyrunner")) {
			String methodDesc = testResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class)
					.description().toString();
			Reporter.setCurrentTestResult(testResult);
		}
		if (!testResult.isSuccess()) {
			System.out.println(testResult);
			Reporter.setCurrentTestResult(testResult);
			String[] testClass = testResult.getTestClass().toString().split("\\.");
			String testClassName = testClass[testClass.length - 1].replace("]", "\\");
			String testMethod = testResult.getName().toString();

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			String currentDate = dateFormat.format(date);
			String currentTime = timeFormat.format(date);

			File screenshotLocation = new File(REPORT_FOLDER + SCREENSHOT_FOLDER + File.separator + testClassName
					+ testMethod + File.separator + currentDate.replaceAll("/", "-"));
			if (!screenshotLocation.getAbsoluteFile().exists())
				screenshotLocation.mkdir();

			String screenshotName = currentTime.replace(":", ";") + ".png";
			Reporter.log("<br> <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Please click for screenshot - </b>");
			makeScreenshot(screenshotName, screenshotLocation);
		}
	}

	@AfterClass
	public void closeBrowser() {
		if (appType.equalsIgnoreCase("web"))
			this.driver.quit();
		else
			this.mobileDriver.quit();
	}

	@Parameters({ "myDeviceContext" })
	@AfterSuite
	public void finalizeExecution(@Optional String myDeviceContext) {
		executeCommand("./dependencies/allure-generate.bat");
		moveFolder("./allure-report/history", "allure-results");
		if (appType.equals("pcloudyrunner")) {
			DeviceContext myContext = pCloudyController_Runner.allDeviceContexts.get(myDeviceContext);
			try {
				myContext.pCloudySession.releaseSessionNow();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (appType.equals("pcloudy")) {
			try {
				pCloudySession.releaseSessionNow();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (appType.equals("android"))
			executeCommand("adb uninstall io.appium.settings");
		if (viewReport)
			executeCommand("./allure-serve.bat");
	}

	public boolean isLoderDisplayed(By locator) {
		boolean state = false;
		try {
			state = driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			state = false;
		}
		return state;
	}

	public boolean isDisplayed(By locator, int... wait) {
		// waitForLoader();
		boolean state = false;
		// if (wait)
		// driver.manage().timeouts().implicitlyWait(MAX_WAIT_TIME_IN_SEC,
		// TimeUnit.SECONDS);
		// else
		// driver.manage().timeouts().implicitlyWait(POLLING_MAX_TIME_IN_MILLISEC,
		// TimeUnit.MILLISECONDS);
		// try {
		// state = driver.findElement(locator).isDisplayed();
		// } catch (Exception e) {
		// state = false;
		// }
		// return state;+
		int time = Integer.parseInt(ReadProperty.getPropertyValue("MAX_WAIT_TIME_IN_SEC"));
		if (wait.length != 0)
			if (wait[0] > 0)
				time = wait[0];
		WebDriverWait explicitWait = new WebDriverWait(this.driver, time);
		WebElement element = null;
		try {
			element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			state = element.isDisplayed();
		} catch (Exception e) {
		}
		return state;
	}

	public boolean waitForLoader() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (isLoderDisplayed(By.xpath("//html[@class='nprogress-busy']"))) {
			Instant currentTime = getCurrentTime();
			while (isLoderDisplayed(By.xpath("//html[@class='nprogress-busy']"))) {
				Instant loopingTime = getCurrentTime();
				Duration timeElapsed = Duration.between(currentTime, loopingTime);
				long sec = timeElapsed.toMillis() / 1000;
				int durDiff = (int) sec;
				if (durDiff >= MAX_WAIT_TIME_IN_SEC) {
					reloadCurrentPage();
					reloadCounter++;
					if (reloadCounter == 3)
						driver.close();
				}
			}
			// this.wait = new FluentWait(this.driver).withTimeout((long)
			// MAX_WAIT_TIME_FOR_LOADER, TimeUnit.SECONDS).pollingEvery((long)
			// SPINNERS_POLLING_TIME,
			// TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
			//
			// this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='loader']//*[@class='bars-loading'])[last()]")));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public void fetchSuiteConfiguration(String configuration) {
		configFileObj = new ReadXMLData(test_data_folder_path + configFileName);
		appType = configFileObj.get("MasterType").toLowerCase();
		isRemoteEnable = configFileObj.get(configuration, "isRemoteEnable");
		if (appType.equals("android") || appType.equals("pcloudy")) {
			appWaitActivity = configFileObj.get(configuration, "appWaitActivity");
			if (appType.equals("android")) {
				hubUrl = configFileObj.get(configuration, "Hub");
				hubPort = configFileObj.get(configuration, "Port");
			} else if (appType.equals("pcloudy")) {
				pcloudyMailID = configFileObj.get("PCloudy", "UserName");
				pCloudyApikey = configFileObj.get("PCloudy", "AccessKey");
				deviceBookDuration = Integer.parseInt(configFileObj.get("PCloudy", "BookingDuration"));
				pcloudyPlateformName = configFileObj.get("PCloudy", "PlateFormName");
				autoSelectDevices = Boolean.parseBoolean(configFileObj.get("PCloudy", "AutoSelect"));
				if (autoSelectDevices) {
					pcloudyPlateformVersionFrom = configFileObj.get("PCloudy", "PlateFormVersionFrom");
					pcloudyPlateformVersionTo = configFileObj.get("PCloudy", "PlateFormVersionTo");
					pcloudyDeviceCount = Integer.parseInt(configFileObj.get("PCloudy", "DeviceCount"));
				}
			}

		} else if (appType.equalsIgnoreCase("web")) {
			incognito = Boolean.parseBoolean(configFileObj.get(configuration, "incognito"));
			if (isRemoteEnable.equalsIgnoreCase("True")) {
				hubUrl = configFileObj.get(configuration, "Hub");
				hubPort = configFileObj.get(configuration, "Port");
			}
			logDefectAutomated = new Boolean(configFileObj.get(configuration, "AutoLogDefectInJira"));
			recordSessionVideo = new Boolean(configFileObj.get(configuration, "RecordVideoOfTestExecution"));
		}
		regexTCID = configFileObj.get("Configuration", "TestIdRegex");
		regexAuthor = configFileObj.get("Configuration", "TestAuthorRegex");
	}

	public void makeScreenshot(String screenShotName, File screenShotLoaction) {
		File screenshot;
		WebDriver augmentedDriver = null;
		if (appType.equalsIgnoreCase("web"))
			augmentedDriver = new Augmenter().augment(driver);
		else
			augmentedDriver = new Augmenter().augment(mobileDriver);
		screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		try {
			File f = new File(screenShotLoaction + File.separator + screenShotName);
			FileUtils.copyFile(screenshot, f);
		} catch (IOException e) {
			e.printStackTrace();
			commonWeb = new Common();
			commonWeb.log("Failed to capture screenshot:" + e.getMessage());
		}
		commonWeb = new Common();
		commonWeb.log(createScreenshotLink(screenShotName, screenShotLoaction.toString()));
	}

	public String createScreenshotLink(String screenShotName, String link_text) {
		return "<br><Strong><font color=#FF0000>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Failed screenshot name = </font></strong><a target='_blank' href='../"
				+ link_text + File.separator + screenShotName + "'>" + screenShotName + "</a>";
	}

	/**
	 * @author vivek.mishra
	 * @return current time in integer
	 * @created on 25/02/2019
	 */
	public Instant getCurrentTime() {
		return Instant.now();
	}

	/**
	 * @author vivek.mishra
	 * @return the current URL
	 * @created on 25/02/2019
	 */
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	/**
	 * @author dishant.doshi to reload current url
	 * @creation date 23/11/2018
	 */
	public void reloadCurrentPage() {
		String url = getCurrentURL();
		driver.get(url);
	}

	//// ****************************************** Mobile methods
	//// ***************** //

	private MobileElement waitAndFindAndroidElement(By locator, Condition condition, int timeOutInSeconds,
			int mobilePollingInMilliSeconds) {
		MobileElement foo = null;
		waitForAndroidLoader();
		this.wait = new FluentWait(this.mobileDriver).withTimeout((long) timeOutInSeconds, TimeUnit.SECONDS)
				.pollingEvery((long) mobilePollingInMilliSeconds, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		if (!isAndroidElmentDisplayed(locator))
			scrollAndroidElement((AndroidDriver<MobileElement>) mobileDriver, locator);
		switch (condition) {
		case isClickable:
			try {
				foo = (MobileElement) this.wait.until(ExpectedConditions.elementToBeClickable(locator));
			} catch (Exception e) {
				System.out.println(e);
			}

			break;
		case isDisplayed:
			try {
				foo = (MobileElement) this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case isPresent:
			try {
				foo = (MobileElement) this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		}
		return foo;
	}

	public void scrollUpAndroidElement(AndroidDriver<MobileElement> mobileDriver, By mobileElement) {
		Dimension dimension = mobileDriver.manage().window().getSize();
		int scrollHeight = dimension.getHeight();
		int scrollWidth = dimension.getWidth();
		new TouchAction(mobileDriver).press(PointOption.point(scrollWidth / 2, scrollHeight / 2))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(scrollWidth / 2, 10)).release().perform();
	}

	public void scrollDownAndroidElement(AndroidDriver<MobileElement> mobileDriver, By mobileElement) {
		Dimension dimension = mobileDriver.manage().window().getSize();
		int scrollHeight = dimension.getHeight();
		int scrollWidth = dimension.getWidth();
		new TouchAction(mobileDriver).press(PointOption.point(scrollWidth / 2, scrollHeight / 2))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(scrollWidth / 2, scrollHeight - 10)).release().perform();
	}

	public void scrollAndroidElement(AndroidDriver<MobileElement> mobileDriver, By mobileElement) {
		waitForAndroidLoader();
		int counter = 0;
		do {
			if (!isAndroidElmentDisplayed(mobileElement))
				scrollUpAndroidElement(mobileDriver, mobileElement);
			if (!isAndroidElmentDisplayed(mobileElement))
				scrollDownAndroidElement(mobileDriver, mobileElement);
			counter++;
		} while (!isAndroidElmentDisplayed(mobileElement) && counter <= 2);
	}

	public MobileElement findVisibleAndroidElement(By locator) {
		return waitAndFindAndroidElement(locator, Condition.isDisplayed, this.MAX_WAIT_TIME_IN_SEC,
				this.MOBILE_POLLING_IN_MILLISECONDS);
	}

	public MobileElement findPresentAndroidElement(By locator) {
		return waitAndFindAndroidElement(locator, Condition.isPresent, this.MAX_WAIT_TIME_IN_SEC,
				this.MOBILE_POLLING_IN_MILLISECONDS);
	}

	public void waitForAndroidLoader() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (isAndroidElmentDisplayed(By.id(MOBILE_APP_PACKAGE_NAME + ":id/progress_wheel"))) {
			while (isAndroidElmentDisplayed(By.id(MOBILE_APP_PACKAGE_NAME + ":id/progress_wheel"))) {
				;
			}
		}
	}

	public boolean isAndroidElmentDisplayed(By locator) {
		boolean state = false;
		try {
			state = mobileDriver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			state = false;
		}
		return state;
	}

	public boolean isAndroidElmentDisplayed(By locator, boolean wait) {
		boolean state = false;
		if (wait)
			mobileDriver.manage().timeouts().implicitlyWait(MOBILE_GENERAL_TIMEOUT, TimeUnit.SECONDS);
		try {
			state = findPresentAndroidElement(locator).isDisplayed();
		} catch (Exception e) {
			state = false;
		}
		return state;
	}

	public void removeFolder(String file) {
		File rmFile = new File(file);
		File[] contents = rmFile.listFiles();
		if (contents != null) {
			for (File f : contents) {
				String deleteFile = f.toString();
				removeFolder(deleteFile);
			}
		}
		rmFile.delete();
	}

	private void executeCommand(String command) {
		Process process;
		try {
			process = Runtime.getRuntime().exec(command);
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void moveFolder(String source, String destination) {
		Path sourcePath = Paths.get(source);
		Path destinationPath = Paths.get(destination);
		Path destinationHistoryPath = Paths.get(destination + "/history");
		boolean exist = Files.exists(destinationHistoryPath, new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
		if (!exist) {
			try {
				Files.move(sourcePath, destinationPath.resolve(sourcePath.getFileName()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			List<String> sourceHistoryFiles = getFiles(source);
			for (int i = 0; i < sourceHistoryFiles.size(); i++)
				overwriteFile(source + File.separator + sourceHistoryFiles.get(i),
						destinationHistoryPath + File.separator + sourceHistoryFiles.get(i));
		}
	}

	public void overwriteFile(String source, String destination) {
		FileReader fr = null;
		int i;
		String string = "";
		try {
			fr = new FileReader(source);
			while ((i = fr.read()) != -1)
				string = string + ((char) i);
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			File file = new File(destination);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(string);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> getFiles(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		List<String> files = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile())
				files.add(listOfFiles[i].getName());
		}
		return files;
	}
}