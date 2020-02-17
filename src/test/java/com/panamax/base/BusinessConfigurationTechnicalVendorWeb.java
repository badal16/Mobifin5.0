package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;
import com.panamax.init.Common.FileType;

public class BusinessConfigurationTechnicalVendorWeb extends Common {
	By txtTechnicalVendorName = By.id(readJSFile("INPUT_SERVICES_ADD_NAME", FileType.element));
	By drpVendorService = By.xpath("//*[@id='" + readJSFile("INPUT_SERVICES_ADD_VENDOR_SERVICE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpOperatingEntity = By.xpath("//*[@id='inputOperatingEntity']//*[@class='ant-select-arrow']");
	By txtProviderApiName = By.id("inputProviderApiName");
	By txtTimeOut = By.id(readJSFile("INPUT_SERVICES_ADD_TIMEOUT", FileType.element));
	By txtFailureCode = By.id(readJSFile("INPUT_SERVICES_ADD_FAILURE_CODE", FileType.element));
	By txtSucessCode = By.id(readJSFile("INPUT_SERVICES_ADD_SUCCESS_CODE", FileType.element));
	By drpCommunicationProtocol = By.xpath("//*[@id='inputCommunicationProtocol']//*[@class='ant-select-arrow']");
	By drpHttpType = By.xpath("//*[@id='" + readJSFile("INPUT_SERVICES_ADD_HTTP_TYPE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpRequestType = By.xpath("//*[@id='" + readJSFile("INPUT_SERVICES_ADD_REQUEST_TYPE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpHttpProtocol = By.xpath("//*[@id='" + readJSFile("INPUT_SERVICES_ADD_HTTP_PROTOCOL", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By txtApiUrl = By.id(readJSFile("INPUT_SERVICES_ADD_API_URL", FileType.element));
	By txtRetryCount = By.id(readJSFile("INPUT_SERVICES_ADD_RETRY_COUNT", FileType.element));
	By txtSSLPassword = By.id("inputSslPassword");
	By btnNext = By.xpath("//*[contains(@class,'next')]");
	By txtApiTemplate = By.id(readJSFile("INPUT_SERVICES_ADD_API_TEMPLATE", FileType.element));
	By btnSubmit = By.xpath("//*[normalize-space(text())='Submit']//parent::button");
	By drpConnectionType = By.xpath("//*[@id='inputConnectionType']//*[@class='ant-select-arrow']");
	By drpAuth = By.xpath("//*[@id='inputAuth']//*[@class='ant-select-arrow']");
	By drpStartTLS = By.xpath("//*[@id='inputStartTls']//*[@class='ant-select-arrow']");
	By txtHost = By.id("inputHost");
	By txtPort = By.id("inputPort");
	By txtSoapUrl = By.id("inputSoapUrl");
	By drpSoapVersion = By.xpath("//*[@id='inputSoapVersion']//*[@class='ant-select-arrow']");
	By btnAddService = By.id(readJSFile("OPERATIONBAR_BUTTON_ADD_SERVICE", FileType.element));
	By txtNameInSearch = By.name("vendorName");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_ROLES_EDIT_DESCRIPTION", FileType.element));
	By drpUsedBy = By.xpath("//*[@id='inputTechnicalVendorAddUsedBy']//*[@class='ant-select-arrow']");
	By btnAddKYCLevel = By
			.xpath("//*[contains(@class,'current')]//*[normalize-space(text())='Add field']//parent::button");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 24/09/2019
	 */
	public BusinessConfigurationTechnicalVendorWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtTechnicalVendorName, name);
	}

	public void selectVendorService(String vendorService) {
		clickOnElement(drpVendorService);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + vendorService + "']"));
	}

	public void selectOperatingEntity(String operatingEntity) {
		clickOnElement(drpOperatingEntity);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + operatingEntity + "']"));
	}

	public void sendTextInProviderApiName(String providerApiName) {
		clearAndSendTextInTextBox(txtProviderApiName, providerApiName);
	}

	public void sendTextInTimeOut(String timeOut) {
		clearAndSendTextInTextBox(txtTimeOut, timeOut);
	}

	public void sendTextInFailureCode(String failureCode) {
		clearAndSendTextInTextBox(txtFailureCode, failureCode);
	}

	public void sendTextInSuccessCode(String successCode) {
		clearAndSendTextInTextBox(txtSucessCode, successCode);
	}

	public void selectCommunicationProtocol(String communicationProtocol) {
		clickOnElement(drpCommunicationProtocol);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + communicationProtocol + "']"));
	}

	public void selectHttpType(String httpType) {
		clickOnElement(drpHttpType);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + httpType + "']"));
	}

	public void selectRequestType(String requestType) {
		clickOnElement(drpRequestType);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + requestType + "']"));
	}

	public void selectHttpProtocol(String httpProtocol) {
		clickOnElement(drpHttpProtocol);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + httpProtocol + "']"));
	}

	public void sendTextInApiUrl(String apiUrl) {
		clearAndSendTextInTextBox(txtApiUrl, apiUrl);
	}

	public void sendTextInRetryCount(String retryCount) {
		clearAndSendTextInTextBox(txtRetryCount, retryCount);
	}

	public void sendTextInSSLPassword(String sslPassword) {
		clearAndSendTextInTextBox(txtSSLPassword, sslPassword);
	}

	public void sendTextInApiField(By element, String apiField) {
		commonWait();
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(element, apiField);
	}

	public void sendTextInMobifinPacket(By element, String mobifinPacket) {
		clearAndSendTextInTextBox(element, mobifinPacket);
	}

	public void sendTextInDefaultValue(By element, String defaultValue) {
		clearAndSendTextInTextBox(element, defaultValue);
	}

	public void sendTextInAPITemplate(String apiTemplate) {
		clearAndSendTextInTextBox(txtApiTemplate, apiTemplate);
	}

	public void clickOnSubmit() {
		clickOnElement(btnSubmit);
	}

	public void selectConnectionType(String connectionType) {
		clickOnElement(drpConnectionType);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + connectionType + "']"));
	}

	public void selectAuth(String auth) {
		clickOnElement(drpAuth);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + auth + "']"));
	}

	public void selectStartTLS(String startTLS) {
		clickOnElement(drpStartTLS);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + startTLS + "'])[last()]"));
	}

	public void sendTextInHost(String host) {
		clearAndSendTextInTextBox(txtHost, host);
	}

	public void sendTextInPort(String port) {
		clearAndSendTextInTextBox(txtPort, port);
	}

	public void sendTextInSoapUrl(String soapUrl) {
		clearAndSendTextInTextBox(txtSoapUrl, soapUrl);
	}

	public void selectSoapVersion(String soapVersion) {
		clickOnElement(drpSoapVersion);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + soapVersion + "']"));
	}

	public void sendTextInTechnicalVendorNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void clickOnAddField() {
		clickOnElement(btnAddKYCLevel);
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInTechnicalVendorNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addTechnicalVendor Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void addTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(35)).toString(), true);
		if (!map.get(mapKeys.get(2)).toString().equals("")) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnElement(btnAddService);
			selectVendorService(map.get(mapKeys.get(2)).toString());
			clickOnElement(btnNext);
		} else {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			selectVendorService(map.get(mapKeys.get(3)).toString());
			clickOnElement(btnNext);
		}
		sendTextInProviderApiName(map.get(mapKeys.get(5)).toString());
		sendTextInTimeOut(map.get(mapKeys.get(6)).toString());
		sendTextInFailureCode(map.get(mapKeys.get(7)).toString());
		sendTextInSuccessCode(map.get(mapKeys.get(8)).toString());
		selectCommunicationProtocol(map.get(mapKeys.get(9)).toString());
		clickOnElement(btnNext);
		if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("rest")) {
			if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
				sendTextInApiUrl(map.get(mapKeys.get(10)).toString());
				selectHttpType(map.get(mapKeys.get(12)).toString());
				selectRequestType(map.get(mapKeys.get(13)).toString());
			}
			selectHttpProtocol(map.get(mapKeys.get(11)).toString());
			if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
				sendTextInRetryCount(map.get(mapKeys.get(14)).toString());
			}
			if (map.get(mapKeys.get(11)).toString().toLowerCase().equals("https")) {
				sendTextInSSLPassword(map.get(mapKeys.get(15)).toString());
				// sendTextInSSLCertificate(map.get(mapKeys.get(16)).toString());
			}
		}
		if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
			selectConnectionType(map.get(mapKeys.get(30)).toString());
			sendTextInHost(map.get(mapKeys.get(31)).toString());
			sendTextInPort(map.get(mapKeys.get(32)).toString());
			if (!map.get(mapKeys.get(33)).toString().trim().equals("")) {
				selectAuth(map.get(mapKeys.get(33)).toString());
				selectStartTLS(map.get(mapKeys.get(34)).toString());
			}
		}
		if (!map.get(mapKeys.get(17)).toString().trim().equals("")) {
			clickOnElement(btnNext);
			int rows = Integer.parseInt(map.get(mapKeys.get(17)).toString());
			String[] apiFieldList = map.get(mapKeys.get(18)).toString().split(",");
			String[] mobifinPacketList = map.get(mapKeys.get(18)).toString().split(",");
			String[] defaultValueList = map.get(mapKeys.get(19)).toString().split(",");
			for (int m = 0; m < rows; m++) {
				clickOnAddField();
				sendTextInApiField(By.id("headerMappingApiField[" + (m + 1) + "]"), apiFieldList[m]);
				sendTextInMobifinPacket(By.id("headerMappingMobifinPacketField[" + (m + 1) + "]"),
						mobifinPacketList[m]);
				sendTextInDefaultValue(By.id("headerMappingDeafultValueField[" + (m + 1) + "]"), defaultValueList[m]);

			}
			clickOnElement(btnNext);
		}
		if (!map.get(mapKeys.get(21)).toString().trim().equals("")) {
			sendTextInAPITemplate(map.get(mapKeys.get(21)).toString());
		} else {
			if (!map.get(mapKeys.get(22)).toString().trim().equals("")) {
				int requestrows = Integer.parseInt(map.get(mapKeys.get(22)).toString());
				String[] requestapiFieldList = map.get(mapKeys.get(23)).toString().split(",");
				String[] requestmobifinPacketList = map.get(mapKeys.get(24)).toString().split(",");
				String[] requestdefaultValueList = map.get(mapKeys.get(25)).toString().split(",");
				for (int m = 0; m < requestrows; m++) {
					clickOnAddField();
					sendTextInApiField(By.id("requestMappingApiField[" + (m + 1) + "]"), requestapiFieldList[m]);
					sendTextInMobifinPacket(By.id("requestMappingMobifinPacketField[" + (m + 1) + "]"),
							requestmobifinPacketList[m]);
					sendTextInDefaultValue(By.id("requestMappingDefaultValueField[" + (m + 1) + "]"),
							requestdefaultValueList[m]);
				}
			}
		}
		if (!map.get(mapKeys.get(26)).toString().trim().equals("")) {
			clickOnElement(btnNext);
			int responserows = Integer.parseInt(map.get(mapKeys.get(26)).toString());
			String[] responseapiFieldList = map.get(mapKeys.get(27)).toString().split(",");
			String[] responsemobifinPacketList = map.get(mapKeys.get(28)).toString().split(",");
			String[] responsedefaultValueList = map.get(mapKeys.get(29)).toString().split(",");
			for (int m = 0; m < responserows; m++) {
				clickOnAddField();
				sendTextInApiField(By.id("responseMappingApiField[" + (m + 1) + "]"), responseapiFieldList[m]);
				sendTextInMobifinPacket(By.id("responseMappingMobifinPacketField[" + (m + 1) + "]"),
						responsemobifinPacketList[m]);
				sendTextInDefaultValue(By.id("responseMappingDefaultValueField[" + (m + 1) + "]"),
						responsedefaultValueList[m]);
			}
		}
		clickOnSubmit();
		if (verifyElement(By.xpath("//*[contains(@class,'alert-error')]"), false)) {
			clickOnBackBtn();
			log("Given Technical Service Already Exits");
		}
	}

	public boolean verifyAddedTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By providerApiName = By
				.xpath("//*[normalize-space(text()) = 'Provider Api Name']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(5)).toString() + "']");
		By timeOut = By.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.timeout", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(6)).toString() + "']");
		By failureCode = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.failureCode", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");
		By successCode = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.successCode", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(8)).toString() + "']");
		By communicationProtocol = By
				.xpath("//*[normalize-space(text()) = 'Communication Protocol']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(9)).toString() + "']");
		By apiUrl = By.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.apiUrl", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(10)).toString() + "']");
		By httpType = By.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.httpType", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(12)).toString() + "']");
		By requestType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.requestType", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(13)).toString() + "']");
		By httpProtocol = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.httpProtocol", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(11)).toString() + "']");
		By retryCount = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.retryCount", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(14)).toString() + "']");
		By connectionType = By
				.xpath("//*[normalize-space(text()) = 'Connection Type']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(30)).toString() + "']");
		By host = By
				.xpath("//*[normalize-space(text()) = 'Host']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(31)).toString() + "']");
		By port = By
				.xpath("//*[normalize-space(text()) = 'Port']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(32)).toString() + "']");
		By StartTLS = By
				.xpath("//*[normalize-space(text()) = 'Library']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(34)).toString() + "']");
		By auth = By
				.xpath("//*[normalize-space(text()) = 'Auth']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(35)).toString() + "']");
		By apiTemplate = By
				.xpath("//*[normalize-space(text()) = 'API Template']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(21)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(35)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			commonWait();
			selectVendorService(map.get(mapKeys.get(3)).toString());
			if (!verifyElement(name, false))
				return false;
			String[] navigation = map.get(mapKeys.get(36)).toString().split(",");
			clickOnElement(By.xpath("//*[normalize-space(text())='" + navigation[0] + "']"));
			if (!verifyElement(providerApiName, false))
				return false;
			if (!verifyElement(timeOut, false))
				return false;
			if (!verifyElement(failureCode, false))
				return false;
			if (!verifyElement(successCode, false))
				return false;
			if (!verifyElement(communicationProtocol, false))
				return false;
			clickOnElement(By.xpath("//*[normalize-space(text())='" + navigation[1] + "']"));
			if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("rest")) {
				if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
					if (!verifyElement(apiUrl, false))
						return false;
					if (!verifyElement(httpType, false))
						return false;
					if (!verifyElement(requestType, false))
						return false;
				}
				if (!verifyElement(httpProtocol, false))
					return false;
				if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
					if (!verifyElement(retryCount, false))
						return false;
				}
			}
			if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
				if (!verifyElement(connectionType, false))
					return false;
				if (!verifyElement(host, false))
					return false;
				if (!verifyElement(port, false))
					return false;
				if (!map.get(mapKeys.get(34)).toString().trim().equals("")) {
					if (!verifyElement(StartTLS, false))
						return false;
					if (!verifyElement(auth, false))
						return false;
				}
			}
			if (!map.get(mapKeys.get(17)).toString().trim().equals("")) {
				clickOnElement(By.xpath("//*[normalize-space(text())='" + navigation[2] + "']"));
				int rows = Integer.parseInt(map.get(mapKeys.get(17)).toString());
				String[] apiFieldList = map.get(mapKeys.get(18)).toString().split(",");
				String[] mobifinPacketList = map.get(mapKeys.get(18)).toString().split(",");
				String[] defaultValueList = map.get(mapKeys.get(19)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					commonWait();
					commonWait();
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ apiFieldList[m].trim() + "'][last()]"), false))
						return false;
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ mobifinPacketList[m].trim() + "'][last()]"), false))
						return false;
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ defaultValueList[m].trim() + "'][last()]"), false))
						return false;
				}
				clickOnElement(By.xpath("//*[normalize-space(text())='" + navigation[3] + "']"));
			}
			if (!map.get(mapKeys.get(21)).toString().trim().equals("")) {
				if (!verifyElement(apiTemplate, false))
					return false;
			} else {
				if (!map.get(mapKeys.get(22)).toString().trim().equals("")) {
					int requestrows = Integer.parseInt(map.get(mapKeys.get(22)).toString());
					String[] requestapiFieldList = map.get(mapKeys.get(23)).toString().split(",");
					String[] requestmobifinPacketList = map.get(mapKeys.get(24)).toString().split(",");
					String[] requestdefaultValueList = map.get(mapKeys.get(25)).toString().split(",");
					for (int m = 0; m < requestrows; m++) {
						commonWait();
						commonWait();
						commonWait();
						if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//tr[" + (m + 1)
								+ "]//td[normalize-space(text())='" + requestapiFieldList[m].trim() + "'][last()]"),
								false))
							return false;
						if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//tr[" + (m + 1)
								+ "]//td[normalize-space(text())='" + requestmobifinPacketList[m].trim()
								+ "'][last()]"), false))
							return false;
						if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//tr[" + (m + 1)
								+ "]//td[normalize-space(text())='" + requestdefaultValueList[m].trim() + "'][last()]"),
								false))
							return false;
					}
				}
			}
			if (!map.get(mapKeys.get(26)).toString().trim().equals("")) {
				clickOnElement(By.xpath("//*[normalize-space(text())='" + navigation[4] + "']"));
				int responserows = Integer.parseInt(map.get(mapKeys.get(26)).toString());
				String[] responseapiFieldList = map.get(mapKeys.get(27)).toString().split(",");
				String[] responsemobifinPacketList = map.get(mapKeys.get(28)).toString().split(",");
				String[] responsedefaultValueList = map.get(mapKeys.get(29)).toString().split(",");
				for (int m = 0; m < responserows; m++) {
					commonWait();
					commonWait();
					commonWait();
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ responseapiFieldList[m].trim() + "'][last()]"), false))
						return false;
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ responsemobifinPacketList[m].trim() + "'][last()]"), false))
						return false;
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ responsedefaultValueList[m].trim() + "'][last()]"), false))
						return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create addTechnicalVendor Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 14/10/2019
	 */
	public void editTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(35)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			selectVendorService(map.get(mapKeys.get(3)).toString());
			clickOnElement(btnNext);
			sendTextInProviderApiName(map.get(mapKeys.get(5)).toString());
			sendTextInTimeOut(map.get(mapKeys.get(6)).toString());
			sendTextInFailureCode(map.get(mapKeys.get(7)).toString());
			sendTextInSuccessCode(map.get(mapKeys.get(8)).toString());
			clickOnElement(btnNext);
			if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("rest")) {
				if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
					sendTextInApiUrl(map.get(mapKeys.get(10)).toString());
					selectHttpType(map.get(mapKeys.get(12)).toString());
					selectRequestType(map.get(mapKeys.get(13)).toString());
				}
				selectHttpProtocol(map.get(mapKeys.get(11)).toString());
				if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
					sendTextInRetryCount(map.get(mapKeys.get(14)).toString());
				}
				if (map.get(mapKeys.get(11)).toString().toLowerCase().equals("https")) {
					sendTextInSSLPassword(map.get(mapKeys.get(15)).toString());
					// sendTextInSSLCertificate(map.get(mapKeys.get(16)).toString());
				}
			}
			if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
				selectConnectionType(map.get(mapKeys.get(30)).toString());
				sendTextInHost(map.get(mapKeys.get(31)).toString());
				sendTextInPort(map.get(mapKeys.get(32)).toString());
				if (!map.get(mapKeys.get(33)).toString().trim().equals("")) {
					selectAuth(map.get(mapKeys.get(33)).toString());
					selectStartTLS(map.get(mapKeys.get(34)).toString());
				}
			}
			if (!map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
				clickOnElement(btnNext);
			}
			if (!map.get(mapKeys.get(17)).toString().trim().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(17)).toString());
				String[] apiFieldList = map.get(mapKeys.get(18)).toString().split(",");
				String[] mobifinPacketList = map.get(mapKeys.get(18)).toString().split(",");
				String[] defaultValueList = map.get(mapKeys.get(19)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					clickOnAddField();
					sendTextInApiField(By.id("headerMappingApiField[" + (m + 1) + "]"), apiFieldList[m]);
					sendTextInMobifinPacket(By.id("headerMappingMobifinPacketField[" + (m + 1) + "]"),
							mobifinPacketList[m]);
					sendTextInDefaultValue(By.id("headerMappingDeafultValueField[" + (m + 1) + "]"),
							defaultValueList[m]);

				}
			}
			if (!map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
				clickOnElement(btnNext);
			}
			if (!map.get(mapKeys.get(21)).toString().trim().equals("")) {
				sendTextInAPITemplate(map.get(mapKeys.get(21)).toString());
			} else {
				if (!map.get(mapKeys.get(22)).toString().trim().equals("")) {
					int requestrows = Integer.parseInt(map.get(mapKeys.get(22)).toString());
					String[] requestapiFieldList = map.get(mapKeys.get(23)).toString().split(",");
					String[] requestmobifinPacketList = map.get(mapKeys.get(24)).toString().split(",");
					String[] requestdefaultValueList = map.get(mapKeys.get(25)).toString().split(",");
					for (int m = 0; m < requestrows; m++) {
						clickOnAddField();
						sendTextInApiField(By.id("requestMappingApiField[" + (m + 1) + "]"), requestapiFieldList[m]);
						sendTextInMobifinPacket(By.id("requestMappingMobifinPacketField[" + (m + 1) + "]"),
								requestmobifinPacketList[m]);
						sendTextInDefaultValue(By.id("requestMappingDefaultValueField[" + (m + 1) + "]"),
								requestdefaultValueList[m]);
					}
				}
			}
			if (!map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
				clickOnElement(btnNext);
			}
			if (!map.get(mapKeys.get(26)).toString().trim().equals("")) {
				int responserows = Integer.parseInt(map.get(mapKeys.get(26)).toString());
				String[] responseapiFieldList = map.get(mapKeys.get(27)).toString().split(",");
				String[] responsemobifinPacketList = map.get(mapKeys.get(28)).toString().split(",");
				String[] responsedefaultValueList = map.get(mapKeys.get(29)).toString().split(",");
				for (int m = 0; m < responserows; m++) {
					clickOnAddField();
					sendTextInApiField(By.id("responseMappingApiField[" + (m + 1) + "]"), responseapiFieldList[m]);
					sendTextInMobifinPacket(By.id("responseMappingMobifinPacketField[" + (m + 1) + "]"),
							responsemobifinPacketList[m]);
					sendTextInDefaultValue(By.id("responseMappingDefaultValueField[" + (m + 1) + "]"),
							responsedefaultValueList[m]);
				}
			}
			clickOnSubmit();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By providerApiName = By
				.xpath("//*[normalize-space(text()) = 'Provider Api Name']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(5)).toString() + "']");
		By timeOut = By.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.timeout", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(6)).toString() + "']");
		By failureCode = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.failureCode", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");
		By successCode = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.successCode", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(8)).toString() + "']");
		By communicationProtocol = By
				.xpath("//*[normalize-space(text()) = 'Communication Protocol']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(9)).toString() + "']");
		By apiUrl = By.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.apiUrl", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(10)).toString() + "']");
		By httpType = By.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.httpType", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(12)).toString() + "']");
		By requestType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.requestType", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(13)).toString() + "']");
		By httpProtocol = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.httpProtocol", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(11)).toString() + "']");
		By retryCount = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("servicevendor.retryCount", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(14)).toString() + "']");
		By connectionType = By
				.xpath("//*[normalize-space(text()) = 'Connection Type']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(30)).toString() + "']");
		By host = By
				.xpath("//*[normalize-space(text()) = 'Host']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(31)).toString() + "']");
		By port = By
				.xpath("//*[normalize-space(text()) = 'Port']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(32)).toString() + "']");
		By StartTLS = By
				.xpath("//*[normalize-space(text()) = 'Library']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(34)).toString() + "']");
		By auth = By
				.xpath("//*[normalize-space(text()) = 'Auth']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(35)).toString() + "']");
		By apiTemplate = By
				.xpath("//*[normalize-space(text()) = 'API Template']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(21)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(35)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			commonWait();
			if (!verifyElement(name, false))
				return false;
			selectVendorService(map.get(mapKeys.get(3)).toString());
			String[] navigation = map.get(mapKeys.get(36)).toString().split(",");
			clickOnElement(By.xpath("//*[normalize-space(text())='" + navigation[0] + "']"));
			if (!verifyElement(providerApiName, false))
				return false;
			if (!verifyElement(timeOut, false))
				return false;
			if (!verifyElement(failureCode, false))
				return false;
			if (!verifyElement(successCode, false))
				return false;
			if (!verifyElement(communicationProtocol, false))
				return false;
			clickOnElement(By.xpath("//*[normalize-space(text())='" + navigation[1] + "']"));
			if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("rest")) {
				if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
					if (!verifyElement(apiUrl, false))
						return false;
					if (!verifyElement(httpType, false))
						return false;
					if (!verifyElement(requestType, false))
						return false;
				}
				if (!verifyElement(httpProtocol, false))
					return false;
				if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
					if (!verifyElement(retryCount, false))
						return false;
				}
			}
			if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
				if (!verifyElement(connectionType, false))
					return false;
				if (!verifyElement(host, false))
					return false;
				if (!verifyElement(port, false))
					return false;
				if (!map.get(mapKeys.get(34)).toString().trim().equals("")) {
					if (!verifyElement(StartTLS, false))
						return false;
					if (!verifyElement(auth, false))
						return false;
				}
			}
			if (!map.get(mapKeys.get(17)).toString().trim().equals("")) {
				clickOnElement(By.xpath("//*[normalize-space(text())='" + navigation[2] + "']"));
				int rows = Integer.parseInt(map.get(mapKeys.get(17)).toString());
				String[] apiFieldList = map.get(mapKeys.get(18)).toString().split(",");
				String[] mobifinPacketList = map.get(mapKeys.get(18)).toString().split(",");
				String[] defaultValueList = map.get(mapKeys.get(19)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					commonWait();
					commonWait();
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ apiFieldList[m].trim() + "'][last()]"), false))
						return false;
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ mobifinPacketList[m].trim() + "'][last()]"), false))
						return false;
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ defaultValueList[m].trim() + "'][last()]"), false))
						return false;
				}
				clickOnElement(By.xpath("//*[normalize-space(text())='" + navigation[3] + "']"));
			}
			if (!map.get(mapKeys.get(21)).toString().trim().equals("")) {
				if (!verifyElement(apiTemplate, false))
					return false;
			} else {
				if (!map.get(mapKeys.get(22)).toString().trim().equals("")) {
					int requestrows = Integer.parseInt(map.get(mapKeys.get(22)).toString());
					String[] requestapiFieldList = map.get(mapKeys.get(23)).toString().split(",");
					String[] requestmobifinPacketList = map.get(mapKeys.get(24)).toString().split(",");
					String[] requestdefaultValueList = map.get(mapKeys.get(25)).toString().split(",");
					for (int m = 0; m < requestrows; m++) {
						commonWait();
						commonWait();
						if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//tr[" + (m + 1)
								+ "]//td[normalize-space(text())='" + requestapiFieldList[m].trim() + "'][last()]"),
								false))
							return false;
						if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//tr[" + (m + 1)
								+ "]//td[normalize-space(text())='" + requestmobifinPacketList[m].trim()
								+ "'][last()]"), false))
							return false;
						if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//tr[" + (m + 1)
								+ "]//td[normalize-space(text())='" + requestdefaultValueList[m].trim() + "'][last()]"),
								false))
							return false;
					}
				}
			}
			if (!map.get(mapKeys.get(26)).toString().trim().equals("")) {
				clickOnElement(By.xpath("//*[normalize-space(text())='" + navigation[4] + "']"));
				int responserows = Integer.parseInt(map.get(mapKeys.get(26)).toString());
				String[] responseapiFieldList = map.get(mapKeys.get(27)).toString().split(",");
				String[] responsemobifinPacketList = map.get(mapKeys.get(28)).toString().split(",");
				String[] responsedefaultValueList = map.get(mapKeys.get(29)).toString().split(",");
				for (int m = 0; m < responserows; m++) {
					commonWait();
					commonWait();
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ responseapiFieldList[m].trim() + "'][last()]"), false))
						return false;
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ responsemobifinPacketList[m].trim() + "'][last()]"), false))
						return false;
					if (!verifyElement(By.xpath("//*[contains(@class,'tabpane-active')]//td[normalize-space(text())='"
							+ responsedefaultValueList[m].trim() + "'][last()]"), false))
						return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create DeleteTechnicalVendor Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 14/10/2019
	 */
	public boolean deleteTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			delete();
			return true;
		} else {
			String string = "TechnicalVendor already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedTechnicalVendor Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 14/10/2019
	 */
	public boolean verifyDeletedTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}

	public boolean sortTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		Map<String, List<String>> getBeforeSortTableData = getTableData(map.get(getMapKeys(map).get(2)).toString());
		clickOnSortBtn(map.get(getMapKeys(map).get(0)).toString(), map.get(getMapKeys(map).get(1)).toString());
		List<String> sortedUIColumnData = getColumnData(map.get(getMapKeys(map).get(0)).toString());
		List<String> sortedUIColumnDataCopy = new ArrayList<>(sortedUIColumnData);
		sortColumn(sortedUIColumnData, map.get(getMapKeys(map).get(1)).toString());
		if (!compareTwoLists(sortedUIColumnData, sortedUIColumnDataCopy))
			return false;
		Map<String, List<String>> getAfterSortTableData = getTableData(map.get(getMapKeys(map).get(2)).toString());
		if (!getBeforeSortTableData.equals(getAfterSortTableData))
			return false;
		return true;
	}
}
