package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class BusinessConfigurationServiceProfileWeb extends Common {
	By txtServiceProfileName = By.id(readJSFile("INPUT_SERVICEPROFILE_ADD_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_SERVICEPROFILE_ADD_DESCRIPTION", FileType.element));
	String IsYes = "Yes";
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_SERVICEPROFILE_ADD_DESCRIPTION", FileType.element));
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 24/09/2019
	 */
	public BusinessConfigurationServiceProfileWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInServiceProfileName(String name) {
		sendTextInTextBox(txtServiceProfileName, name);
	}

	public void sendTextInDescription(String description) {
		commonWait();
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescription, description);
	}

	public void sendTextInDescriptionInEdit(String description) {
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(
				"//*[@id='inputServiceprofileAddStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInServiceProfileNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void selectField(String field) {
		clickOnElement(drpSelection);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + field.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInServiceProfileNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addServiceProfile Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void addServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInServiceProfileName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectStatus(map.get(mapKeys.get(3)).toString());
			String[] fieldlist = map.get(mapKeys.get(4)).toString().trim().split(",");
			for (int j = 0; j < fieldlist.length; j++) {
				clickOnElement(
						By.xpath("(//*[contains(@class,'node-action-buttons')]//*[contains(@class,'add')])[last()]"));
				String[] fieldname = fieldlist[j].trim().split("-");
				selectField(fieldname[0]);
				clickOnElement(By.xpath("(//li[normalize-space(text())='" + fieldname[1].trim() + "'])[last()]"));
			}
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("serviceprofile.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("serviceprofile.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By status = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("serviceprofile.label.status", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			commonWait();
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			String[] fieldlist = map.get(mapKeys.get(4)).toString().trim().split(",");
			for (int j = 0; j < fieldlist.length; j++) {
				String[] fieldname = fieldlist[j].trim().split("-");
				if (!verifyElement(By.xpath("//*[normalize-space(text())='" + fieldname[0].trim()
						+ "']//..//*[normalize-space(text())='" + fieldname[1].trim() + "']"), false))
					return false;
			}
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create addServiceProfile Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void editServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			String[] fieldlist = map.get(mapKeys.get(5)).toString().trim().split(",");
			for (int j = 0; j < fieldlist.length; j++) {
				clickOnElement(
						By.xpath("(//*[contains(@class,'node-action-buttons')]//*[contains(@class,'add')])[last()]"));
				String[] fieldname = fieldlist[j].trim().split("-");
				selectField(fieldname[0]);
				clickOnElement(By.xpath("(//li[normalize-space(text())='" + fieldname[1].trim() + "'])[last()]"));
			}
			selectStatus(map.get(mapKeys.get(3)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("serviceprofile.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("serviceprofile.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By status = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("serviceprofile.label.status", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			commonWait();
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			String[] fieldlist = map.get(mapKeys.get(5)).toString().trim().split(",");
			for (int j = 0; j < fieldlist.length; j++) {
				String[] fieldname = fieldlist[j].trim().split("-");
				if (!verifyElement(By.xpath("//*[normalize-space(text())='" + fieldname[0].trim()
						+ "']//..//*[normalize-space(text())='" + fieldname[1].trim() + "']"), false))
					return false;
			}
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create DeleteServiceProfile Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean deleteServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), false);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			delete();
			return true;
		} else {
			String string = "ServiceProfile already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedServiceProfile Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean verifyDeletedServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), false);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}

	public boolean sortServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
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
