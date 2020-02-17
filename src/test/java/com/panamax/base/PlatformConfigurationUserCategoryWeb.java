package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class PlatformConfigurationUserCategoryWeb extends Common {
	By txtName = By.id(readJSFile("INPUT_USERCATEGORY_ADD_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_USERCATEGORY_ADD_DESCRIPTION", FileType.element));
	By drpCategoryType = By.xpath("//*[@id='" + readJSFile("INPUT_USERCATEGORY_ADD_CATEGORYTYPE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_USERCATEGORY_EDIT_DESCRIPTION", FileType.element));
	By drpCategoryTypeInEdit = By
			.xpath("//*[@id='" + readJSFile("INPUT_USERCATEGORY_EDIT_CATEGORYTYPE", FileType.element)
					+ "']//*[@class='ant-select-arrow']");
	By drpUserIdentifierField = By
			.xpath("(//*[contains(@id,'userIdentifierParam')]//*[@class='ant-select-arrow'])[last()]");
	By drpUserCredentialField = By.xpath("(//*[contains(@id,'userCrential')]//*[@class='ant-select-arrow'])[last()]");
	By btnIdentifierField = By.xpath("//*[@class='ant-btn addBtn ant-btn-primary']");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 29/07/2019
	 */
	public PlatformConfigurationUserCategoryWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtName, name);
	}

	public void selectCategoryType(String categoryType) {
		clickOnElement(drpCategoryType);
		clickOnElement(By.xpath("//*[normalize-space(text())='" + categoryType + "']"));
	}

	public void selectCategoryTypeInEdit(String categoryType) {
		clickOnElement(drpCategoryTypeInEdit);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + categoryType + "']"));
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void selectStatus(String status) {
		clickOnElement(By
				.xpath("//*[@id='inputAddUserCategoryStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInDescriptionInEdit(String description) {
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(
				"//*[@id='inputEditUsercategoryStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void selectUserIdentifierField(String userIdentifierField) {
		clickOnElement(drpUserIdentifierField);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + userIdentifierField + "'])[last()]"));
	}

	public void selectUserCredentialField(String userIdentifierField) {
		clickOnElement(drpUserCredentialField);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + userIdentifierField + "'])[last()]"));
	}

	public void clickOnIdentifierFieldFieldAddBtn() {
		clickOnElement(btnIdentifierField);
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
	 * @author shivani.patel Create addUserCategory Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 29/07/2019
	 */
	public void addUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		commonWait();
		commonWait();
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			selectCategoryType(map.get(mapKeys.get(2)).toString());
			sendTextInDescription(map.get(mapKeys.get(3)).toString());
			selectStatus(map.get(mapKeys.get(4)).toString());
			int rows = Integer.parseInt(map.get(mapKeys.get(5)).toString());
			String[] userIdentifierFieldList = map.get(mapKeys.get(6)).toString().split(",");
			String[] userCredentialField = map.get(mapKeys.get(7)).toString().split(",");
			for (int j = 0; j < rows; j++) {
				selectUserIdentifierField(userIdentifierFieldList[j].trim());
				selectUserCredentialField(userCredentialField[j].trim());
				if (j < rows - 1) {
					clickOnIdentifierFieldFieldAddBtn();
				}
			}
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("usercategory.grid.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("usercategory.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By categoryType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("usercategory.label.categorytype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("usercategory.grid.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(4)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(categoryType, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create editUserCategory Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 22/07/2019
	 */
	public void editUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			commonWait();
			selectCategoryTypeInEdit(map.get(mapKeys.get(2)).toString());
			sendTextInDescriptionInEdit(map.get(mapKeys.get(3)).toString());
			selectStatusInEdit(map.get(mapKeys.get(5)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("usercategory.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By categoryType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("usercategory.label.categorytype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("usercategory.grid.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(4)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(categoryType, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create deleteUserCategory Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 05/10/2018
	 */
	public boolean deleteUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "UserCategory already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deleteUserCategory Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 05/10/2019
	 */
	public boolean verifyDeletedUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}
	/**
	 * @author dishant.doshi to sort country
	 * @param map
	 *            - for excel data
	 * @param mapKeys
	 *            - for excel header
	 * @return
	 * @creation date 26/12/2018
	 */
	public boolean sortCountry(Map<Object, Object> map, List<Object> mapKeys) {
		commonWait();
		commonWait();
		commonWait();
		clickOnElement(By.xpath("(//*[text()='User Category'])[1]"));
		Map<String, List<String>> getBeforeSortTableData = getTableData(map.get(getMapKeys(map).get(2)).toString());
		clickOnSortBtn(map.get(getMapKeys(map).get(0)).toString(), map.get(getMapKeys(map).get(1)).toString());
		List<String> sortedUIColumnData = getColumnData(map.get(getMapKeys(map).get(0)).toString());
		List<String> sortedUIColumnDataCopy = new ArrayList<String>(sortedUIColumnData);
		sortColumn(sortedUIColumnData, map.get(getMapKeys(map).get(1)).toString());
		if (!compareTwoLists(sortedUIColumnData, sortedUIColumnDataCopy))
			return false;
		Map<String, List<String>> getAfterSortTableData = getTableData(map.get(getMapKeys(map).get(2)).toString());
		if (!getBeforeSortTableData.equals(getAfterSortTableData))
			return false;
		return true;
	}
}
