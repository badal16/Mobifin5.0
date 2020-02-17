package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;
import com.panamax.init.Common.FileType;

public class PlatformConfigurationServiceWeb extends Common {
	By txtName = By.id(readJSFile("INPUT_SERVICES_ADD_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_SERVICES_ADD_DESCRIPTION", FileType.element));
	By drpServiceType = By.xpath("//*[@id='inputServicesAddServiceType']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_SERVICES_EDIT_DESCRIPTION", FileType.element));
	By drpServiceTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Service Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpServiceTypeInEdit = By.xpath("//*[@id='inputServicesAddServiceType']//*[@class='ant-select-arrow']");
	String IsYes = "Yes";
	By txtOTPTimeOut = By.id("inputServiceAddsTimeout");
	By drpParameter = By.xpath("(//*[contains(@id,'parameters')]//*[@class='ant-select-arrow'])[last()]");
	By txtDefaultValue = By.xpath("(//*[contains(@id,'defaultValue')])[last()]");
	By btnAddParameter = By.xpath("//*[normalize-space(text())='Add Parameter']//parent::button");
	By txtOTPTimeOutInEdit = By.id("inputServiceEditsTimeout");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 31/07/2019
	 */
	public PlatformConfigurationServiceWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtName, name);
	}

	public void selectServiceType(String serviceType) {
		clickOnElement(drpServiceType);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + serviceType + "']"));
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void selectStatus(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputServicesStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputServicesStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectServiceTypeInEdit(String serviceType) {
		clickOnElement(drpServiceTypeInEdit);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + serviceType + "']"));
	}

	public void sendTextInNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void selectIsTwoStepEnable(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'inputServiceAddstwoStepEnable')])[last()]"));
			commonWait();
		}
	}

	public void selectIsBalanceReservation(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'inputServiceAddsreservationEnable')])[last()]"));
		}
	}

	public void sendTextInOTPTimeOut(String timeout) {
		clearAndSendTextInTextBox(txtOTPTimeOut, timeout);
	}

	public void selectIsTwoStepEnableInEdit(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'inputServiceEditstwoStepEnable')])[last()]"));
			commonWait();
		}
	}

	public void selectIsBalanceReservationInEdit(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'inputServiceEditsreservationEnable')])[last()]"));
		}
	}

	public void sendTextInOTPTimeOutInEdit(String timeout) {
		clearAndSendTextInTextBox(txtOTPTimeOutInEdit, timeout);
	}

	public void selectParameter(String parameter) {
		clickOnElement(drpParameter);
		clickOnElement(By.xpath("(//li[text()='" + parameter + "'])[last()]"));
	}

	public void sendTextInDefaultValue(String defaultValue) {
		clearAndSendTextInTextBox(txtDefaultValue, defaultValue);
	}

	public void selectIsVisible(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			if (!verifyElement(By.xpath("(//*[contains(@id,'visibility') and contains(@class,'checked')])[last()]"))) {
				clickOnElement(By.xpath("(//*[contains(@id,'visibility')])[last()]"));
			}
		}
	}

	public void selectIsMandatory(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			if (!verifyElement(By.xpath("(//*[contains(@id,'isMandatory') and contains(@class,'checked')])[last()]"))) {
				clickOnElement(By.xpath("(//*[contains(@id,'isMandatory')])[last()]"));
			}
		}
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addService Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public void addService(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectServiceType(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				selectIsTwoStepEnable(map.get(mapKeys.get(5)).toString());
			}
			if (!map.get(mapKeys.get(6)).toString().equals("")) {
				selectIsBalanceReservation(map.get(mapKeys.get(6)).toString());
			}
			if (!map.get(mapKeys.get(7)).toString().equals("")) {
				sendTextInOTPTimeOut(map.get(mapKeys.get(7)).toString());
			}
			if (!map.get(mapKeys.get(8)).toString().equals("")) {
				String[] parameteList = map.get(mapKeys.get(8)).toString().split(",");
				String[] DefaultValueList = map.get(mapKeys.get(9)).toString().split(",");
				String[] VisibleList = map.get(mapKeys.get(10)).toString().split(",");
				String[] MandatoryList = map.get(mapKeys.get(11)).toString().split(",");
				for (int i = 0; i < parameteList.length; i++) {
					clickOnElement(btnAddParameter);
					selectParameter(parameteList[i].trim());
					sendTextInDefaultValue(DefaultValueList[i].trim());
					selectIsVisible(VisibleList[i].trim());
					selectIsMandatory(MandatoryList[i].trim());
				}
			}
			selectStatus(map.get(mapKeys.get(4)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedService(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("services.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By.xpath("//*[normalize-space(text()) = '" + readJSFile("services.description", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(2)).toString() + "']");
		By serviceType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("services.label.servicetype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("services.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(4)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(serviceType, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create editService Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public void editService(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectServiceTypeInEdit(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(6)).toString().equals("")) {
				selectIsTwoStepEnableInEdit(map.get(mapKeys.get(6)).toString());
			}
			if (!map.get(mapKeys.get(7)).toString().equals("")) {
				selectIsBalanceReservationInEdit(map.get(mapKeys.get(7)).toString());
			}
			if (!map.get(mapKeys.get(8)).toString().equals("")) {
				sendTextInOTPTimeOut(map.get(mapKeys.get(8)).toString());
			}
			if (!map.get(mapKeys.get(9)).toString().equals("")) {
				String[] parameteList = map.get(mapKeys.get(9)).toString().split(",");
				String[] DefaultValueList = map.get(mapKeys.get(10)).toString().split(",");
				String[] VisibleList = map.get(mapKeys.get(11)).toString().split(",");
				String[] MandatoryList = map.get(mapKeys.get(12)).toString().split(",");
				for (int i = 0; i < parameteList.length; i++) {
					clickOnElement(btnAddParameter);
					selectParameter(parameteList[i].trim());
					sendTextInDefaultValue(DefaultValueList[i].trim());
					selectIsVisible(VisibleList[i].trim());
					selectIsMandatory(MandatoryList[i].trim());
				}
			}
			selectStatusInEdit(map.get(mapKeys.get(5)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedService(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By.xpath("//*[normalize-space(text()) = '" + readJSFile("services.description", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(2)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("services.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(5)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create deleteService Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean deleteService(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "Service already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deleteService Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean verifyDeletedService(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}

	public boolean sortService(Map<Object, Object> map, List<Object> mapKeys) {
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
