package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class PlatformConfigurationProductWeb extends Common {
	By txtName = By.id(readJSFile("INPUT_PRODUCT_ADD_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_PRODUCT_ADD_DESCRIPTION", FileType.element));
	By drpService = By.xpath("//*[@id='" + readJSFile("INPUT_PRODUCT_ADD_SERVICE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpServiceInEdit = By.xpath("//*[@id='" + readJSFile("INPUT_PRODUCT_EDIT_SERVICE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_PRODUCT_EDIT_DESCRIPTION", FileType.element));
	By drpProductTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Product Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtSKUID = By.id("inputProductAddSKUID");
	By txtSKUIDInEdit = By.id("inputProductEditSKUID");
	By drpCurrency = By.xpath("//*[@id='inputProductAddCurrency']//*[@class='ant-select-arrow']");
	By drpDenominationType = By.xpath("//*[@id='inputProductAddDenominationType']//*[@class='ant-select-arrow']");
	By txtFromAmount = By.id("inputProductAddFromAmount");
	By txtToAmount = By.id("inputProductAddToAmount");
	By drpPrecision = By.xpath("//*[@id='inputProductAddPrecision']//*[@class='ant-select-arrow']");
	By txtamount = By.id("inputProductAddAmount");
	By drpCurrencyInEdit = By.xpath("//*[@id='inputProductEditCurrency']//*[@class='ant-select-arrow']");
	By drpCountryName = By.xpath("//*[@id='inputProductAddParamStr2']//*[@class='ant-select-arrow']");
	By txtParaStr1 = By.id("inputProductAddParamStr1");
	By txtParaStr2 = By.id("inputProductAddParamStr3");
	By txtParaStr3 = By.id("inputProductAddParamStr4");
	By txtParaStr4 = By.id("inputProductAddParamStr5");
	By txtEditParaStr1 = By.id("inputProductEditParamStr1");
	By txtEditParaStr2 = By.id("inputProductEditParamStr3");
	By txtEditParaStr3 = By.id("inputProductEditParamStr4");
	By txtEditParaStr4 = By.id("inputProductEditParamStr5");
	By drpCountryNameInEdit = By.xpath("//*[@id='inputProductEditParamStr2']//*[@class='ant-select-arrow']");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 02/08/2019
	 */
	public PlatformConfigurationProductWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtName, name);
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void selectService(String service) {
		clickOnElement(drpService);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + service.trim() + "'])[last()]"));
	}

	public void selectServiceInEdit(String service) {
		clickOnElement(drpServiceInEdit);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + service.trim() + "'])[last()]"));
	}

	public void sendTextInSKUID(String SKUID) {
		sendTextInTextBox(txtSKUID, SKUID);
	}

	public void sendTextInSKUIDInEdit(String SKUID) {
		clearAndSendTextInTextBox(txtSKUIDInEdit, SKUID);
	}

	public void sendTextInParamStr(By element, String paramStr) {
		clearAndSendTextInTextBox(element, paramStr);
	}

	public void selectStatus(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputProductAddStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(
				By.xpath("//*[@id='lblProducteditStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void selectCurrency(String currency) {
		clickOnElement(drpCurrency);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + currency.trim() + "'])[last()]"));
	}

	public void selectCurrencyInEdit(String currency) {
		clickOnElement(drpCurrency);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + currency.trim() + "'])[last()]"));
	}

	public void selectDenominationType(String denominationType) {
		clickOnElement(drpDenominationType);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + denominationType.trim() + "'])[last()]"));
	}

	public void sendTextInFromAmount(String fromAmount) {
		clearAndSendTextInTextBox(txtFromAmount, fromAmount);
	}

	public void sendTextInToAmount(String toAmount) {
		clearAndSendTextInTextBox(txtToAmount, toAmount);
	}

	public void selectPrecision(String precision) {
		clickOnElement(drpPrecision);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + precision.trim() + "'])[last()]"));
	}

	public void sendTextInAmount(String amount) {
		clearAndSendTextInTextBox(txtamount, amount);
	}

	public void selectCountryName(String countryName) {
		clickOnElement(drpCountryName);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + countryName.trim() + "'])[last()]"));
	}

	public void selectCountryNameInEdit(String countryName) {
		clickOnElement(drpCountryNameInEdit);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + countryName.trim() + "'])[last()]"));
	}

	public void sendTextInPrameterStr1(String paraStr1) {
		sendTextInTextBox(txtParaStr1, paraStr1);
	}

	public void sendTextInPrameterStr2(String paraStr2) {
		sendTextInTextBox(txtParaStr2, paraStr2);
	}

	public void sendTextInPrameterStr3(String paraStr3) {
		sendTextInTextBox(txtParaStr3, paraStr3);
	}

	public void sendTextInPrameterStr4(String paraStr4) {
		sendTextInTextBox(txtParaStr4, paraStr4);
	}

	public void sendTextInEditPrameterStr1(String paraStr1) {
		clearAndSendTextInTextBox(txtEditParaStr1, paraStr1);
	}

	public void sendTextInEditPrameterStr2(String paraStr2) {
		clearAndSendTextInTextBox(txtEditParaStr2, paraStr2);
	}

	public void sendTextInEditPrameterStr3(String paraStr3) {
		clearAndSendTextInTextBox(txtEditParaStr3, paraStr3);
	}

	public void sendTextInEditPrameterStr4(String paraStr4) {
		clearAndSendTextInTextBox(txtEditParaStr4, paraStr4);
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
	 * @author shivani.patel Create addProduct Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 02/08/2019
	 */
	public void addProduct(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(15)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString().trim() + "'])[1]"),
				false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectService(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(4)).toString().trim().equals("")) {
				selectCurrency(map.get(mapKeys.get(4)).toString());
				selectDenominationType(map.get(mapKeys.get(5)).toString());
				if (map.get(mapKeys.get(5)).toString().toLowerCase().equals("flexi")) {
					sendTextInFromAmount(map.get(mapKeys.get(6)).toString());
					sendTextInToAmount(map.get(mapKeys.get(7)).toString());
					selectPrecision(map.get(mapKeys.get(8)).toString());
				} else {
					sendTextInAmount(map.get(mapKeys.get(6)).toString());
				}
			}
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				sendTextInSKUID(map.get(mapKeys.get(9)).toString());
			}
			if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
				selectCountryName(map.get(mapKeys.get(10)).toString());
			}
			if (!map.get(mapKeys.get(11)).toString().trim().equals("")) {
				sendTextInPrameterStr1(map.get(mapKeys.get(11)).toString());
			}
			if (!map.get(mapKeys.get(12)).toString().trim().equals("")) {
				sendTextInPrameterStr2(map.get(mapKeys.get(12)).toString());
			}
			if (!map.get(mapKeys.get(13)).toString().trim().equals("")) {
				sendTextInPrameterStr3(map.get(mapKeys.get(13)).toString());
			}
			if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
				sendTextInPrameterStr4(map.get(mapKeys.get(14)).toString());
			}
			selectStatus(map.get(mapKeys.get(15)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedProduct(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("product.label.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("product.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By service = By.xpath("//*[normalize-space(text()) = '" + readJSFile("product.label.service", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(3)).toString() + "']");
		By SKUID = By
				.xpath("//*[normalize-space(text()) = 'SKUID']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(9)).toString() + "']");

		By status = By
				.xpath("//*[normalize-space(text()) = 'Status']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(15)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(15)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(service, false))
				return false;
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				if (!verifyElement(SKUID, false))
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
	 * @author shivani.patel Create editProduct Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 02/08/2019
	 */
	public void editProduct(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(6)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			commonWait();
			commonWait();
			commonWait();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectServiceInEdit(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(8)).toString().trim().equals("")) {
				selectCurrency(map.get(mapKeys.get(8)).toString());
				selectDenominationType(map.get(mapKeys.get(9)).toString());
				if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("flexi")) {
					sendTextInFromAmount(map.get(mapKeys.get(10)).toString());
					sendTextInToAmount(map.get(mapKeys.get(11)).toString());
					selectPrecision(map.get(mapKeys.get(12)).toString());
				} else {
					sendTextInAmount(map.get(mapKeys.get(10)).toString());
				}
			}
			if (!map.get(mapKeys.get(4)).toString().trim().equals("")) {
				sendTextInSKUIDInEdit(map.get(mapKeys.get(4)).toString());
			}
			if (!map.get(mapKeys.get(5)).toString().trim().equals("")) {
				selectCountryNameInEdit(map.get(mapKeys.get(5)).toString());
			}
			if (!map.get(mapKeys.get(13)).toString().trim().equals("")) {
				sendTextInEditPrameterStr1(map.get(mapKeys.get(13)).toString());
			}
			if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
				sendTextInEditPrameterStr2(map.get(mapKeys.get(14)).toString());
			}
			if (!map.get(mapKeys.get(15)).toString().trim().equals("")) {
				sendTextInEditPrameterStr3(map.get(mapKeys.get(15)).toString());
			}
			if (!map.get(mapKeys.get(16)).toString().trim().equals("")) {
				sendTextInEditPrameterStr4(map.get(mapKeys.get(16)).toString());
			}
			selectStatusInEdit(map.get(mapKeys.get(7)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedProduct(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("product.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By service = By.xpath("//*[normalize-space(text()) = '" + readJSFile("product.label.service", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(3)).toString() + "']");
		By SKUID = By
				.xpath("//*[normalize-space(text()) = 'SKUID']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");

		By status = By
				.xpath("//*[normalize-space(text()) = 'Status']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(7)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(service, false))
				return false;
			if (!map.get(mapKeys.get(4)).toString().trim().equals("")) {
				if (!verifyElement(SKUID, false))
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
	 * @author shivani.patel Create deleteProduct Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 02/08/2019
	 */
	public boolean deleteProduct(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "Product already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deleteProduct Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 02/08/2019
	 */
	public boolean verifyDeletedProduct(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}

	public boolean sortProduct(Map<Object, Object> map, List<Object> mapKeys) {
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
