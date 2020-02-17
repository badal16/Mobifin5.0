package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class PlatformConfigurationProductGroupWeb extends Common {
	By txtName = By.id(readJSFile("INPUT_PRODUCTGROUP_ADD_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_PRODUCTGROUP_ADD_DESCRIPTION", FileType.element));
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_SERVICES_EDIT_DESCRIPTION", FileType.element));
	By drpProductGroupTypeInSearch = By.xpath(
			"//*[normalize-space(text())='ProductGroup Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpProductGroupTypeInEdit = By.xpath("//*[@id='" + readJSFile("INPUT_SERVICES_ADD_SERVICETYPE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpProduct = By.xpath("//*[contains(@class,'ant-select-selection__rendered')]");
	By drpProductInEdit = By.xpath("//*[@class='ant-select-search__field']");
	By clickProductText = By.id(readJSFile("LBL_PRODUCTGROUP_ADD_PRODUCT", FileType.element));
	By clickProductTextInEdit = By.id(readJSFile("LBL_PRODUCTGROUP_EDIT_PRODUCT", FileType.element));

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 05/08/2019
	 */
	public PlatformConfigurationProductGroupWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtName, name);
	}

	public void selectProductGroupType(String serviceType) {
		clickOnElement(drpProduct);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + serviceType + "']"));
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void clickOnProductText() {
		clickOnElement(clickProductText);
	}

	public void clickOnProductTextInEdit() {
		clickOnElement(clickProductTextInEdit);
	}

	public void selectProduct(String product) {
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + product + "'])[last()]"));
	}

	public void selectStatus(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputProductgroupStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescription, description);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputProductgroupStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectProductInEdit(String serviceType) {
		clickOnElement(drpProductGroupTypeInEdit);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + serviceType + "']"));
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
	 * @author shivani.patel Create addProductGroup Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 05/08/2019
	 */
	public void addProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				String[] unitlist = map.get(mapKeys.get(3)).toString().trim().split(",");
				clickOnElement(drpProduct);
				for (int i = 0; i < unitlist.length; i++) {
					selectProduct(unitlist[i].trim());
				}
			}
			clickOnProductText();
			selectStatus(map.get(mapKeys.get(4)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("productgroup.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("productgroup.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By product = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("productgroup.label.product", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("productgroup.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(4)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(product, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create editProductGroup Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 05/08/2019
	 */
	public void editProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				String[] unitlist = map.get(mapKeys.get(3)).toString().trim().split(",");
				clickOnElement(drpProductInEdit);
				for (int i = 0; i < unitlist.length; i++) {
					if (!verifyElement(
							By.xpath("//*[@id = '" + readJSFile("INPUT_PRODUCTGROUP_EDIT_PRODUCT", FileType.element)
									+ "']//*[normalize-space(text())='" + unitlist[i] + "']"))) {
						selectProduct(unitlist[i].trim());
					}
				}
			}
			clickOnProductTextInEdit();
			selectStatusInEdit(map.get(mapKeys.get(5)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("productgroup.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By product = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("productgroup.label.product", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("productgroup.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(5)).toString() + "']");
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			commonWait();
			if (!verifyElement(description, false))
				return false;
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				if (!verifyElement(product, false))
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
	 * @author shivani.patel Create deleteProductGroup Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 05/08/2019
	 */
	public boolean deleteProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "ProductGroup already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deleteProductGroup Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 05/08/2019
	 */
	public boolean verifyDeletedProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}

	public boolean sortProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
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
