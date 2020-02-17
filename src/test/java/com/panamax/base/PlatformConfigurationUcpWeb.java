package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class PlatformConfigurationUcpWeb extends Common {
	By txtName = By.id(readJSFile("INPUT_UCP_ADD_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_UCP_ADD_DESCRIPTION", FileType.element));
	By txtValue = By.id(readJSFile("INPUT_UCP_ADD_VALUE", FileType.element));
	By txtAccessToken = By.id("inputAccesschannelAccessTokenValidity");
	By drpUnitType = By.xpath(
			"//*[@id='" + readJSFile("INPUT_UCP_ADD_UNITTYPE", FileType.element) + "']//*[@class='ant-select-arrow']");
	By drpUnitTypeInEdit = By.xpath(
			"//*[@id='" + readJSFile("INPUT_UCP_EDIT_UNITTYPE", FileType.element) + "']//*[@class='ant-select-arrow']");
	By drpCreditType = By.xpath("//*[@id='" + readJSFile("INPUT_UCP_ADD_CREDITTYPE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpCreditTypeInEdit = By.xpath("//*[@id='" + readJSFile("INPUT_UCP_EDIT_CREDITTYPE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpCreditOn = By.xpath(
			"//*[@id='" + readJSFile("INPUT_UCP_ADD_CREDITON", FileType.element) + "']//*[@class='ant-select-arrow']");
	By drpCreditOnInEdit = By.xpath(
			"//*[@id='" + readJSFile("INPUT_UCP_EDIT_CREDITON", FileType.element) + "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpUnitTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Unit Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_UCP_EDIT_DESCRIPTION", FileType.element));
	By txtValueInEdit = By.id(readJSFile("INPUT_UCP_EDIT_VALUE", FileType.element));
	By drpUcpTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Ucp Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpUnit = By.xpath("//*[@class='ant-select ant-select-enabled ant-select-allow-clear']//li");
	By drpUnitInEdit = By.xpath("//input[@id='" + readJSFile("INPUT_UCP_EDIT_UNIT", FileType.element) + "']");
	By removeUnit = By.xpath("//*[@id='" + readJSFile("INPUT_UCP_EDIT_UNIT", FileType.element)
			+ "']//ancestor :: span[contains(@class,'choice__remove')]");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 31/07/2019
	 */
	public PlatformConfigurationUcpWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtName, name);
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void sendTextInValue(String value) {
		sendTextInTextBox(txtValue, value);
	}

	public void sendTextInValueInEdit(String value) {
		clearAndSendTextInTextBox(txtValueInEdit, value);
	}

	public void selectUnitType(String unitType) {
		clickOnElement(drpUnitType);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + unitType.trim() + "'])[last()]"));
	}

	public void selectUnitTypeInEdit(String unitType) {
		clickOnElement(drpUnitTypeInEdit);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + unitType.trim() + "'])[last()]"));
	}

	public void selectCreditType(String creditType) {
		clickOnElement(drpCreditType);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + creditType.trim() + "'])[last()]"));
	}

	public void selectCreditTypeInEdit(String creditType) {
		clickOnElement(drpCreditTypeInEdit);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + creditType.trim() + "'])[last()]"));
	}

	public void selectCreditOn(String creditOn) {
		clickOnElement(drpCreditOn);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + creditOn.trim() + "'])[last()]"));
	}

	public void selectCreditOnInEdit(String creditOn) {
		clickOnElement(drpCreditOnInEdit);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + creditOn.trim() + "'])[last()]"));
	}

	public void selectUnit(String unit) {
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + unit + "'])[last()]"));
	}

	public void clickOnRemoveUnitIcon() {
		clickOnElement(removeUnit);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_UCP_ADD_STATUS", FileType.element)
				+ "']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_UCP_EDIT_STATUS", FileType.element)
				+ "']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void sendTextInNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectUnitTypeInFilterSearch(String unitType) {
		clickOnElement(drpUnitTypeInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + unitType.trim() + "'])[last()]"));
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1, String str2, String str3, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInNameFilterSearch(str1);
		selectUnitTypeInFilterSearch(str2);
		selectStatusInFilterSearch(str3);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addUcp Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public void addUcp(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(8)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			selectUnitType(map.get(mapKeys.get(2)).toString());
			sendTextInDescription(map.get(mapKeys.get(3)).toString());
			selectCreditType(map.get(mapKeys.get(4)).toString());
			if (map.get(mapKeys.get(4)).toString().toLowerCase().equals("percentage")) {
				selectCreditOn(map.get(mapKeys.get(6)).toString());
				if (!map.get(mapKeys.get(6)).toString().toLowerCase().equals("amount")) {
					String[] unitlist = map.get(mapKeys.get(7)).toString().trim().split(",");
					clickOnElement(drpUnit);
					for (int i = 0; i < unitlist.length; i++) {
						selectUnit(unitlist[i].trim());
					}
				}
			}
			sendTextInValue(map.get(mapKeys.get(5)).toString());
			selectStatus(map.get(mapKeys.get(8)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedUcp(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By unitType = By.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.unittype", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(2)).toString() + "']");
		By creditType = By.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.credittype", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(4)).toString() + "']");
		By value = By.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.value", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(5)).toString() + "']");
		By creditOn = By.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.crediton", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(6)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(8)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(8)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(unitType, false))
				return false;
			if (!verifyElement(creditType, false))
				return false;
			if (map.get(mapKeys.get(4)).toString().toLowerCase().equals("percentage")) {
				if (!verifyElement(creditOn, false))
					return false;
				if (!map.get(mapKeys.get(6)).toString().toLowerCase().equals("amount")) {
					String[] unitlist = map.get(mapKeys.get(7)).toString().trim().split(",");
					for (int i = 0; i < unitlist.length; i++) {
						if (!verifyElement(By
								.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.unit", FileType.label)
										+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
										+ unitlist[i].trim() + "')]"),
								false))
							return false;
					}
				}
			}
			if (!verifyElement(value, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create editUcp Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public void editUcp(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(9)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			selectUnitTypeInEdit(map.get(mapKeys.get(3)).toString());
			sendTextInDescriptionInEdit(map.get(mapKeys.get(4)).toString());
			selectCreditTypeInEdit(map.get(mapKeys.get(5)).toString());
			if (map.get(mapKeys.get(5)).toString().toLowerCase().equals("percentage")) {
				selectCreditOnInEdit(map.get(mapKeys.get(7)).toString());
				if (!map.get(mapKeys.get(7)).toString().toLowerCase().equals("amount")) {
					String[] unitlist = map.get(mapKeys.get(8)).toString().trim().split(",");
					if (verifyElement(removeUnit)) {
						clickOnRemoveUnitIcon();
					}
					clickOnElement(drpUnitInEdit);
					for (int i = 0; i < unitlist.length; i++) {
						selectUnit(unitlist[i].trim());
					}
				}
			}
			sendTextInValueInEdit(map.get(mapKeys.get(6)).toString());
			selectStatusInEdit(map.get(mapKeys.get(10)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedUcp(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		By unitType = By.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.unittype", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(3)).toString() + "']");
		By creditType = By.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.credittype", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(5)).toString() + "']");
		By value = By.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.value", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(6)).toString() + "']");
		By creditOn = By.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.crediton", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(7)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("ucp.label.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(10)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(10)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(unitType, false))
				return false;
			if (!verifyElement(creditType, false))
				return false;
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				if (map.get(mapKeys.get(5)).toString().toLowerCase().equals("percentage")) {
					if (!verifyElement(creditOn, false))
						return false;
					if (!map.get(mapKeys.get(7)).toString().equals("")) {
						if (!map.get(mapKeys.get(7)).toString().toLowerCase().equals("amount")) {
							String[] unitlist = map.get(mapKeys.get(8)).toString().trim().split(",");
							for (int i = 0; i < unitlist.length; i++) {
								if (!verifyElement(By.xpath(
										"//*[normalize-space(text()) = '" + readJSFile("ucp.label.unit", FileType.label)
												+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
												+ unitlist[i].trim() + "')]"),
										false))
									return false;
							}
						}
					}
				}
			}
			if (!verifyElement(value, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create deleteUcp Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean deleteUcp(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "Ucp already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deleteUcp Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean verifyDeletedUcp(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
					map.get(mapKeys.get(3)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}

	public boolean sortUcp(Map<Object, Object> map, List<Object> mapKeys) {
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
