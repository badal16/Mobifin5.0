package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class PlatformConfigurationPouchWeb extends Common {
	By txtName = By.id(readJSFile("INPUT_POUCH_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_POUCH_DESCRIPTION", FileType.element));
	By drpPouchType = By.xpath("//*[@id='inputPouchType']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_POUCH_DESCRIPTION", FileType.element));
	By drpPouchTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Pouch Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationPouchWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtName, name);
	}

	public void selectPouchType(String pouchType) {
		clickOnElement(drpPouchType);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + pouchType + "']"));
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_POUCH_STATUS", FileType.element)
				+ "']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath("//*[@id='inputPouchStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + status.trim() + "'])[last()]"));
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
	 * @author shivani.patel Create addPouch Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 30/07/2019
	 */
	public void addPouch(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectPouchType(map.get(mapKeys.get(3)).toString());
			selectStatus(map.get(mapKeys.get(4)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedPouch(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("pouch.label.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("pouch.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By pouchType = By
				.xpath("//*[normalize-space(text()) = 'Pouch Type']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("pouch.label.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(4)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(pouchType, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create editPouch Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 30/07/2019
	 */
	public void editPouch(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			commonWait();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectStatusInEdit(map.get(mapKeys.get(3)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedPouch(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("pouch.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("pouch.label.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(4)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
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
	 * @author shivani.patel Create deletePouch Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 30/07/2019
	 */
	public boolean deletePouch(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "Pouch already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deletePouch Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 30/07/2019
	 */
	public boolean verifyDeletedPouch(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}
	public boolean sortPouch(Map<Object, Object> map, List<Object> mapKeys) {
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
