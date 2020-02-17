package com.panamax.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class PlatformConfigurationExchangeRateManagerWeb extends Common {
	By drpFromCurrency = By.xpath("//*[@id='" + readJSFile("INPUT_EXCHANGERATE_ADD_FROMCURRENCY", FileType.element)
			+ "']//span[@class='ant-select-arrow']");
	By drpFromCurrencyInEdit = By
			.xpath("//*[@id='" + readJSFile("INPUT_EXCHANGERATE_EDIT_FROMCURRENCY", FileType.element)
					+ "']//span[@class='ant-select-arrow']");
	By drpToCurrency = By.xpath("//*[@id='" + readJSFile("INPUT_EXCHANGERATE_ADD_TOCURRENCY", FileType.element)
			+ "']//span[@class='ant-select-arrow']");
	By drpToCurrencyInEdit = By.xpath("//*[@id='" + readJSFile("INPUT_EXCHANGERATE_EDIT_TOCURRENCY", FileType.element)
			+ "']//span[@class='ant-select-arrow']");
	By txtExchangeRate = By.id(readJSFile("INPUT_EXCHANGERATE_ADD_EXCHANGERATE", FileType.element));
	By txtExchangeRateInEdit = By.id(readJSFile("INPUT_EXCHANGERATE_EDIT_EXCHANGERATE", FileType.element));
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpSearchType = By.xpath("//*[normalize-space(text())='"
			+ readJSFile("exchangerate.label.validfromdate", FileType.label)
			+ "']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 05/08/2019
	 */
	public PlatformConfigurationExchangeRateManagerWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void selectFromCurrency(String fromCurrency) {
		clickOnElement(drpFromCurrency);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + fromCurrency.trim() + "'])[last()]"));
	}

	public void selectFromCurrencyInEdit(String fromCurrency) {
		clickOnElement(drpFromCurrencyInEdit);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + fromCurrency.trim() + "'])[last()]"));
	}

	public void selectToCurrency(String toCurrency) {
		clickOnElement(drpToCurrency);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + toCurrency.trim() + "'])[last()]"));
	}

	public void selectToCurrencyInEdit(String toCurrency) {
		clickOnElement(drpToCurrencyInEdit);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + toCurrency.trim() + "'])[last()]"));
	}

	public void sendTextInExchangeRate(String exchangeRate) {
		sendTextInTextBox(txtExchangeRate, exchangeRate);
	}

	public void sendTextInExchangeRateInEdit(String exchangeRate) {
		clearAndSendTextInTextBox(txtExchangeRateInEdit, exchangeRate);
	}

	public void selectStatus(String status) {
		clickOnElement(By
				.xpath("//*[@id='inputExchangeRateAddStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath("//*[@id='inputExchangeRateEditStatus']//span[normalize-space(text())='"
				+ status.trim() + "']"));
	}

	public void sendTextInFromDate() {
		String endDate = getCurrentDateTime();
		clickOnElement(By.id("inputExchangeRateAddValidFromDate"));
		clearAndSendTextInTextBox(By.xpath("//*[@class='ant-calendar-input ']"), endDate);
		clickOnElement(By.xpath("//*[@class='ant-calendar-ok-btn']"));
	}

	public void sendTextInToDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, +30);
		Date currentDatePlusOne = c.getTime();
		String fromDate = dateFormat.format(currentDatePlusOne);
		clickOnElement(By.id("inputExchangeRateAddValidToDate"));
		clearAndSendTextInTextBox(By.xpath("//*[@class='ant-calendar-input ']"), fromDate);
		clickOnElement(By.xpath("//*[@class='ant-calendar-ok-btn']"));
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void sendTextInValidFromDateInFilterSearch(String fromDate) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + fromDate.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(drpSearchType);
			clickOnElement(By.xpath("//li[normalize-space(text())='>=']"));
		}
		sendTextInValidFromDateInFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addExchangeRateManager Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 05/08/2019
	 */
	public void addExchangeRateManager(Map<Object, Object> map, List<Object> mapKeys) {
		clickOnAddBtn();
		selectFromCurrency(map.get(mapKeys.get(1)).toString());
		selectToCurrency(map.get(mapKeys.get(2)).toString());
		sendTextInExchangeRate(map.get(mapKeys.get(3)).toString());
		sendTextInFromDate();
		sendTextInToDate();
		selectStatus(map.get(mapKeys.get(4)).toString());
		clickOnSaveBtn();

	}

	public boolean verifyAddedExchangeRateManager(Map<Object, Object> map, List<Object> mapKeys) {
		By fromCurrency = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("exchangerate.label.fromcurrency", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(1)).toString() + "']");
		By toCurrency = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("exchangerate.label.tocurrency", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By exchangeRate = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("exchangerate.label.exchangerate", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By status = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("notificationTemplate.label.status", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnElement(By.xpath("//*[@class='ant-table-tbody']//tr[1]//td[1]"));
			if (!verifyElement(fromCurrency, false))
				return false;
			if (!verifyElement(toCurrency, false))
				return false;
			if (!verifyElement(exchangeRate, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create editExchangeRateManager Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 05/08/2019
	 */
	public void editExchangeRateManager(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnElement(By.xpath("//*[@class='ant-table-tbody']//tr[1]//td[1]"));
			clickOnEditBtn();
			commonWait();
			commonWait();
			if (!map.get(mapKeys.get(1)).toString().equals("")) {
				selectFromCurrencyInEdit(map.get(mapKeys.get(1)).toString());
			}
			if (!map.get(mapKeys.get(2)).toString().equals("")) {
				selectToCurrencyInEdit(map.get(mapKeys.get(2)).toString());
			}
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				sendTextInExchangeRateInEdit(map.get(mapKeys.get(3)).toString());
			}
			selectStatusInEdit(map.get(mapKeys.get(4)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyEditedExchangeRateManager(Map<Object, Object> map, List<Object> mapKeys) {
		By fromCurrency = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("exchangerate.label.fromcurrency", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(1)).toString() + "']");
		By toCurrency = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("exchangerate.label.tocurrency", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By exchangeRate = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("exchangerate.label.exchangerate", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By status = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("notificationTemplate.label.status", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnElement(By.xpath("//*[@class='ant-table-tbody']//tr[1]//td[1]"));
			if (!map.get(mapKeys.get(1)).toString().equals("")) {
				if (!verifyElement(fromCurrency, false))
					return false;
			}
			if (!map.get(mapKeys.get(2)).toString().equals("")) {
				if (!verifyElement(toCurrency, false))
					return false;
			}
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				if (!verifyElement(exchangeRate, false))
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
	 * @author shivani.patel Create deleteExchangeRateManager Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 05/08/2019
	 */
	public boolean deleteExchangeRateManager(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnElement(By.xpath("//*[@class='ant-table-tbody']//tr[1]//td[1]"));
			delete();
			return true;
		} else {
			String string = "ExchangeRateManager already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deleteExchangeRateManager Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 05/08/2019
	 */
	public boolean verifyDeletedExchangeRateManager(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), false);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}
}
