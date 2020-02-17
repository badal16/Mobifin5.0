package com.panamax.pcloudy;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.panamax.init.ReadProperty;
import com.panamax.init.ReadXMLData;
import com.ssts.pcloudy.Connector;
import com.ssts.pcloudy.Version;
import com.ssts.pcloudy.appium.PCloudyAppiumSession;
import com.ssts.pcloudy.dto.appium.booking.BookingDtoDevice;
import com.ssts.pcloudy.dto.device.MobileDevice;
import com.ssts.pcloudy.dto.file.PDriveFileDTO;

public class pCloudyController_Runner {

	public static Map<String, DeviceContext> allDeviceContexts = new HashMap<String, DeviceContext>();
	static int deviceBookDuration;
	static boolean autoSelectDevices;
	public final static String TESTDATA_FOLDER = ReadProperty.getPropertyValue( "TESTDATA_FOLDER");
	public static String configFileName = ReadProperty.getPropertyValue( "ConfigurationFileName");

	public static ReadXMLData configFileObj;
	static String Your_pCloudy_Email;
	static String Your_pCloudy_Apikey;

	public static void main(String args[]) throws Exception {
		pCloudyController_Runner runExecutionOnPCloudy = new pCloudyController_Runner();
		String test_data_folder_path = new File(TESTDATA_FOLDER).getAbsolutePath() + "\\";
		configFileObj = new ReadXMLData(test_data_folder_path + configFileName);
		Your_pCloudy_Email=configFileObj.get("PCloudy", "UserName");
		Your_pCloudy_Apikey=configFileObj.get("PCloudy", "AccessKey");
		deviceBookDuration = Integer.parseInt(configFileObj.get("PCloudy", "BookingDuration"));
		autoSelectDevices = Boolean.parseBoolean(configFileObj.get("PCloudy", "AutoSelect"));
		runExecutionOnPCloudy.runTestNGTest();
		System.exit(0);
	}





	public void runTestNGTest() throws Exception {

		String listener = "com.panamax.init.CustomizedEmailableReport";
		// Create an instance on TestNG
		TestNG myTestNG = new TestNG();

		// Create an instance of XML Suite and assign a name for it.
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName(configFileObj.get("PCloudy", "SuiteName"));
		mySuite.addListener(listener);
		mySuite.setParallel("tests");
		mySuite.setConfigFailurePolicy("continue");

		// Create a list which can contain the classes that you want to run.
		List<XmlClass> myClasses = new ArrayList<XmlClass>();
		//myClasses.add(new XmlClass("com.test.verifications.COCServiceTest"));
		String[] testCases = configFileObj.get("PCloudy", "TestCaseName").split(",");
		for(int i=0;i<testCases.length;i++)
			myClasses.add(new XmlClass("com.panamax.testcases."+testCases[i].trim()));

		// Create a list of XmlTests and add the Xmltest you created earlier to it.
		List<XmlTest> allDevicesTests = new ArrayList<XmlTest>();
		//allDevicesTests.add(new XmlTest("AgentApp_InternalService_AgentLastNode"));

		Connector con = new Connector("https://device.pcloudy.com/api/");
		// User Authentication over pCloudy
		String authToken = con.authenticateUser(Your_pCloudy_Email, Your_pCloudy_Apikey);
		ArrayList<MobileDevice> selectedDevices = new ArrayList<>();
		// Select apk in pCloudy Cloud Drive
		File fileToBeUploaded = new File("./"+ReadProperty.getPropertyValue("APPLICATIONS_FOLDER")+File.separator+configFileObj.get("PCloudy", "AppName"));
		PDriveFileDTO alreadyUploadedApp = con.getAvailableAppIfUploaded(authToken, fileToBeUploaded.getName());
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
			selectedDevices.addAll(con.chooseDevices(authToken, configFileObj.get("PCloudy", "PlateFormName"), new Version(configFileObj.get("PCloudy", "PlateFormVersionFrom")), new Version(configFileObj.get("PCloudy", "PlateFormVersionTo")), Integer.parseInt(configFileObj.get("PCloudy", "DeviceCount"))));
		else
			selectedDevices.addAll(con.chooseMultipleDevices(authToken, configFileObj.get("PCloudy", "PlateFormName")));

		String sessionName = selectedDevices.get(0).display_name + " Appium Session";

		BookingDtoDevice[] bookedDevices = con.AppiumApis().bookDevicesForAppium(authToken, selectedDevices, deviceBookDuration, sessionName);
		System.out.println("Devices booked successfully");

		con.AppiumApis().initAppiumHubForApp(authToken, alreadyUploadedApp);
		URL endpoint = con.AppiumApis().getAppiumEndpoint(authToken);
		URL reportFolderOnPCloudy = con.AppiumApis().getAppiumReportFolder(authToken);
		for (int i = 0; i < bookedDevices.length; i++) {
			BookingDtoDevice aDevice = bookedDevices[i];

			PCloudyAppiumSession pCloudySession = new PCloudyAppiumSession(con, authToken, aDevice);
			String uniqueName = aDevice.manufacturer + " " + aDevice.model + " " + aDevice.version;

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("newCommandTimeout", 800);
			capabilities.setCapability("launchTimeout", 9000);
			capabilities.setCapability("deviceName", aDevice.capabilities.deviceName);
			//			capabilities.setCapability("browserName", aDevice.capabilities.deviceName);
			capabilities.setCapability("platformName", configFileObj.get("PCloudy", "PlateFormName"));
			capabilities.setCapability("rotatable", true);
			capabilities.setCapability("autoGrantPermissions", true);	
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("appWaitActivity", configFileObj.get("Master", "appWaitActivity"));
			capabilities.setCapability("unicodeKeyboard", "true");
			capabilities.setCapability("resetKeyboard", "true"); 

			DeviceContext aDeviceContext = new DeviceContext(uniqueName);
			aDeviceContext.endpoint = endpoint;
			aDeviceContext.device = aDevice;
			aDeviceContext.pCloudySession = pCloudySession;
			aDeviceContext.capabilities = capabilities;

			allDeviceContexts.put(uniqueName, aDeviceContext);

			XmlTest aTestNgDeviceTest = new XmlTest(mySuite);
			aTestNgDeviceTest.setName("test_" + uniqueName);
			aTestNgDeviceTest.addParameter("myDeviceContext", uniqueName);

			aTestNgDeviceTest.setXmlClasses(myClasses);
			allDevicesTests.add(aTestNgDeviceTest);
		}
		mySuite.setThreadCount(bookedDevices.length);

		// add the list of tests to your Suite.
		mySuite.setTests(allDevicesTests);

		// Add the suite to the list of suites.
		List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		mySuites.add(mySuite);

		// Set the list of Suites to the testNG object you created earlier.
		myTestNG.setXmlSuites(mySuites);

		// Create TestNG.xml
		File file = new File("./"+ReadProperty.getPropertyValue( "SUITES_FOLDER")+"/pcloudyRunner.xml");
		FileWriter writer = new FileWriter(file);
		writer.write(mySuite.toXml());
		writer.close();
		// invoke run() - this will run your class.
		myTestNG.run();

		con.revokeTokenPrivileges(authToken);

		System.out.println("Execution Completed...");

	}
}