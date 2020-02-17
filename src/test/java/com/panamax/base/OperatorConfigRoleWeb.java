package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class OperatorConfigRoleWeb extends Common {
	By txtRoleName = By.id(readJSFile("INPUT_ROLES_ADD_ROLES", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_ROLES_ADD_DESCRIPTION", FileType.element));
	By drpUserCategory = By.xpath("//*[@id='" + readJSFile("INPUT_ROLE_USER_CATEGORY", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	String IsYes = "Yes";
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_ROLES_EDIT_DESCRIPTION", FileType.element));
	By drpUsedBy = By.xpath("//*[@id='inputRoleAddUsedBy']//*[@class='ant-select-arrow']");
	By drpUsedByInSearch = By.xpath(
			"//*[normalize-space(text())='Used By']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 24/09/2019
	 */
	public OperatorConfigRoleWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInRoleName(String name) {
		sendTextInTextBox(txtRoleName, name);
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectUserCategory(String userCategory) {
		clickOnElement(drpUserCategory);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + userCategory + "']"));
	}

	public void selectStatus(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputrolesAddStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void clickOnSelectAll() {
		clickOnElement(By.xpath("//*[normalize-space(text())='Select All']"));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputrolesEditStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'"
					+ readJSFile("INPUT_PARAMETER_ADD_CHILDFIELDMANDATORY", FileType.element) + "')])[last()]"));
		}
	}

	public void selectIsEditable(String isEditable) {
		if (isEditable.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'"
					+ readJSFile("INPUT_PARAMETER_ADD_CHILDFIELDEDITABLE", FileType.element) + "')])[last()]"));
		}
	}

	public void sendTextInRoleNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInRoleNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addRole Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void addRole(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInRoleName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectUserCategory(map.get(mapKeys.get(3)).toString());
			selectStatus(map.get(mapKeys.get(4)).toString());
			clickOnSelectAll();
			/*
			 * String[] Module = map.get(mapKeys.get(5)).toString().split("/");
			 * for (int i = 0; i < Module.length; i++) {
			 * if(!Module[i].toLowerCase().equals("platform config")){
			 * clickOnElement(By .xpath(
			 * "//div[contains(@class,'module-access')]//*[normalize-space(text())='"
			 * + Module[i] + "']"));} String[] moduledevide =
			 * map.get(mapKeys.get(6)).toString().split("/"); String[]
			 * accessData = moduledevide[i].split(";"); for (int j = 0; j <
			 * accessData.length; j++) { String[] moduleAccess =
			 * accessData[j].trim().split(":"); String[] access =
			 * moduleAccess[1].trim().split(","); for (int k = 0; k <
			 * access.length; k++) { if (access[k].toLowerCase().equals("add"))
			 * {
			 * clickOnElement(By.xpath("(//*[contains(@value,'"+moduleAccess[0].
			 * trim ()+"')]//parent::span)[1]")); } else if
			 * (access[k].toLowerCase().equals("edit")) {
			 * clickOnElement(By.xpath("(//*[contains(@value,'"+moduleAccess[0].
			 * trim ()+"')]//parent::span)[2]")); } else if
			 * (access[k].toLowerCase().equals("delete")) {
			 * clickOnElement(By.xpath("(//*[contains(@value,'"+moduleAccess[0].
			 * trim ()+"')]//parent::span)[3]")); } else if
			 * (access[k].toLowerCase().equals("view")) {
			 * clickOnElement(By.xpath("(//*[contains(@value,'"+moduleAccess[0].
			 * trim ()+"')]//parent::span)[4]")); } else if
			 * (access[k].toLowerCase().equals("import")) {
			 * clickOnElement(By.xpath("(//*[contains(@value,'"+moduleAccess[0].
			 * trim ()+"')]//parent::span)[5]")); } else if
			 * (access[k].toLowerCase().equals("export")) {
			 * clickOnElement(By.xpath("(//*[contains(@value,'"+moduleAccess[0].
			 * trim ()+"')]//parent::span)[6]")); } } } }
			 */
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedRole(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("role.label.role", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By.xpath("//*[normalize-space(text()) = '" + readJSFile("role.description", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(2)).toString() + "']");
		By userCategory = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("role.label.usercategory", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("role.status", FileType.label)
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
			if (!verifyElement(userCategory, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create addRole Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void editRole(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectUserCategory(map.get(mapKeys.get(3)).toString());
			selectStatusInEdit(map.get(mapKeys.get(5)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedRole(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By.xpath("//*[normalize-space(text()) = '" + readJSFile("role.description", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(2)).toString() + "']");
		By userCategory = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("role.label.usercategory", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("role.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(5)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(userCategory, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create DeleteRole Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean deleteRole(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			delete();
			return true;
		} else {
			String string = "Role already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedRole Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean verifyDeletedRole(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}

	public boolean sortRole(Map<Object, Object> map, List<Object> mapKeys) {
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
