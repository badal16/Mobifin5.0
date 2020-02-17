package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class PlatformConfigurationCounterWeb extends Common {
	By txtName = By.id(readJSFile("INPUT_COUNTER_ADD_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_COUNTER_ADD_DESCRIPTION", FileType.element));
	By txtInterval = By.id(readJSFile("INPUT_COUNTER_ADD_INTERVAL", FileType.element));
	By txtIntervalInEdit = By.id(readJSFile("INPUT_COUNTER_EDIT_INTERVAL", FileType.element));
	By txtCounterLimit = By.id(readJSFile("INPUT_COUNTER_ADD_COUNTERLIMIT", FileType.element));
	By txtCounterLimitInEdit = By.id(readJSFile("INPUT_COUNTER_EDIT_COUNTERLIMIT", FileType.element));
	By txtOccurence = By.id(readJSFile("INPUT_COUNTER_ADD_OCCURENCE", FileType.element));
	By txtOccurenceInEdit = By.id(readJSFile("INPUT_COUNTER_EDIT_OCCURENCE", FileType.element));
	By drpCreditOn = By.xpath(
			"//*[@id='" + readJSFile("INPUT_UCP_ADD_CREDITON", FileType.element) + "']//*[@class='ant-select-arrow']");
	By drpDayOftheWeek = By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_ADD_WEEKDAYS", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpDayOftheWeekInEdit = By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_EDIT_WEEKDAYS", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpDayOfMonth = By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_ADD_MONTHOFDAY", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpDayOfMonthInEdit = By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_EDIT_MONTHOFDAY", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpMonthOfYear = By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_ADD_MONTHOFYEAR", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpMonthOfYearInEdit = By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_EDIT_MONTHOFYEAR", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpCreditOnInEdit = By.xpath(
			"//*[@id='" + readJSFile("INPUT_UCP_EDIT_CREDITON", FileType.element) + "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpResetTypeInSearch = By.xpath("//*[normalize-space(text())='"
			+ readJSFile("counter.grid.resettype", FileType.label)
			+ "']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpCountOnInSearch = By.xpath(
			"//*[normalize-space(text())='Count On']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_COUNTER_EDIT_DESCRIPTION", FileType.element));
	By drpCounterTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Counter Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpUnit = By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_ADD_COUNTERONVALUE", FileType.element) + "']//li");
	By drpUnitInEdit = By
			.xpath("//input[@id='" + readJSFile("INPUT_COUNTER_EDIT_COUNTERONVALUE", FileType.element) + "']");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 08/08/2019
	 */
	public PlatformConfigurationCounterWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtName, name);
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void sendTextInInterval(String interval) {
		sendTextInTextBox(txtInterval, interval);
	}

	public void sendTextInIntervalInEdit(String interval) {
		clearAndSendTextInTextBox(txtIntervalInEdit, interval);
	}

	public void sendTextInOccurence(String occurence) {
		sendTextInTextBox(txtOccurence, occurence);
	}

	public void sendTextInOccurenceInEdit(String occurence) {
		clearAndSendTextInTextBox(txtOccurenceInEdit, occurence);
	}

	public void sendTextInCounterLimit(String counterLimit) {
		sendTextInTextBox(txtCounterLimit, counterLimit);
	}

	public void sendTextInCounterLimitInEdit(String counterLimit) {
		clearAndSendTextInTextBox(txtCounterLimitInEdit, counterLimit);
	}

	public void selectCountOn(String counterOn) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_ADD_COUNTON", FileType.element)
				+ "']//span[normalize-space(text())='" + counterOn + "']"));
	}

	public void selectCountOnInEdit(String counterOn) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_EDIT_COUNTON", FileType.element)
				+ "']//span[normalize-space(text())='" + counterOn + "']"));
	}

	public void selectResetType(String resetType) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_ADD_RESET_TYPE", FileType.element)
				+ "']//span[normalize-space(text())='" + resetType + "']"));
	}

	public void selectResetTypeInEdit(String resetType) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_EDIT_RESET_TYPE", FileType.element)
				+ "']//span[normalize-space(text())='" + resetType + "']"));
	}

	public void selectUnit(String unit) {
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + unit + "'])[last()]"));
	}

	public void selectStatus(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputCounterAddStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectMonitoringEndType(String monitoringEndType) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_ADD_MONITORING_ENDTYPE", FileType.element)
				+ "']//span[normalize-space(text())='" + monitoringEndType.trim() + "']"));
	}

	public void selectMonitoringEndTypeInEdit(String monitoringEndType) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_EDIT_MONITORING_ENDTYPE", FileType.element)
				+ "']//span[normalize-space(text())='" + monitoringEndType.trim() + "']"));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputCountereditStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void sendTextInNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectResetTypeInFilterSearch(String resetType) {
		clickOnElement(drpResetTypeInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + resetType.trim() + "'])[last()]"));
	}

	public void selectDayOftheWeek(String dayOftheWeek) {
		clickOnElement(drpDayOftheWeek);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + dayOftheWeek.trim() + "'])[last()]"));
	}

	public void selectDayOftheWeekInEdit(String dayOftheWeek) {
		clickOnElement(drpDayOftheWeekInEdit);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + dayOftheWeek.trim() + "'])[last()]"));
	}

	public void selectDayOfMonth(String dayOfMonth) {
		clickOnElement(drpDayOfMonth);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + dayOfMonth.trim() + "'])[last()]"));
	}

	public void selectDayOfMonthInEdit(String dayOfMonth) {
		clickOnElement(drpDayOfMonthInEdit);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + dayOfMonth.trim() + "'])[last()]"));
	}

	public void selectMonthOfYear(String monthOfYear) {
		clickOnElement(drpMonthOfYear);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + monthOfYear.trim() + "'])[last()]"));
	}

	public void selectMonthOfYearInEdit(String monthOfYear) {
		clickOnElement(drpMonthOfYearInEdit);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + monthOfYear.trim() + "'])[last()]"));
	}

	public void selectCounterOnInFilterSearch(String resetType) {
		clickOnElement(drpCountOnInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + resetType.trim() + "'])[last()]"));
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1, String str2, String str3, String str4, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInNameFilterSearch(str1);
		selectCounterOnInFilterSearch(str2);
		selectStatusInFilterSearch(str3);
		selectResetTypeInFilterSearch(str4);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addCounter Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 08/08/2019
	 */
	public void addCounter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(13)).toString(), map.get(mapKeys.get(6)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectCountOn(map.get(mapKeys.get(3)).toString());
			if (verifyElement(By.id(readJSFile("INPUT_COUNTER_ADD_COUNTERONVALUE", FileType.element)))) {
				String[] unitlist = map.get(mapKeys.get(4)).toString().trim().split(",");
				clickOnElement(drpUnit);
				for (int i = 0; i < unitlist.length; i++) {
					selectUnit(unitlist[i].trim());
				}
			}
			sendTextInCounterLimit(map.get(mapKeys.get(5)).toString());
			selectResetType(map.get(mapKeys.get(6)).toString());
			if (!map.get(mapKeys.get(7)).toString().trim().equals("")) {
				selectDayOftheWeek(map.get(mapKeys.get(7)).toString());
			}
			if (!map.get(mapKeys.get(8)).toString().trim().equals("")) {
				selectDayOfMonth(map.get(mapKeys.get(8)).toString());
			}
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				selectMonthOfYear(map.get(mapKeys.get(9)).toString());
			}
			sendTextInInterval(map.get(mapKeys.get(10)).toString());
			selectMonitoringEndType(map.get(mapKeys.get(11)).toString());
			if (verifyElement(By.id(readJSFile("INPUT_COUNTER_ADD_OCCURENCE", FileType.element)))) {
				sendTextInOccurence(map.get(mapKeys.get(12)).toString());
			}
			selectStatus(map.get(mapKeys.get(13)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedCounter(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By countOn = By.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.counton", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(3)).toString() + "']");
		By counterLimit = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.counterlimit", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
						+ map.get(mapKeys.get(5)).toString() + "')]");
		By resetType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.resettype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(6)).toString() + "']");
		By dayOftheWeek = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.dayoftheweek", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
						+ map.get(mapKeys.get(7)).toString() + "')]");
		By dayOfMonth = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.dayofthemonth", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
						+ map.get(mapKeys.get(8)).toString() + "')]");
		By monthOfYear = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.monthofyear", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
						+ map.get(mapKeys.get(9)).toString() + "')]");
		By interval = By.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.interval", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(10)).toString() + "']");
		By occurence = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.occurrence", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(12)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(13)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(13)).toString(), map.get(mapKeys.get(6)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(countOn, false))
				return false;
			if (!map.get(mapKeys.get(7)).toString().trim().equals("")) {
				String[] unitlist = map.get(mapKeys.get(4)).toString().trim().split(",");
				for (int i = 0; i < unitlist.length; i++) {
					if (!verifyElement(By.xpath("//*[normalize-space(text()) = '"
							+ readJSFile("counter.label.counteronvalue", FileType.label)
							+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'" + unitlist[i]
							+ "')]"), false))
						return false;
				}
			}
			if (!verifyElement(counterLimit, false))
				return false;
			if (!verifyElement(resetType, false))
				return false;
			if (!map.get(mapKeys.get(7)).toString().trim().equals("")) {
				if (!verifyElement(dayOftheWeek, false))
					return false;
			}
			if (!map.get(mapKeys.get(8)).toString().trim().equals("")) {
				if (!verifyElement(dayOfMonth, false))
					return false;
			}
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				if (!verifyElement(monthOfYear, false))
					return false;
			}
			if (!verifyElement(interval, false))
				return false;
			if (!map.get(mapKeys.get(12)).toString().trim().equals("")) {
				if (!verifyElement(occurence, false))
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
	 * @author shivani.patel Create editCounter Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 08/08/2019
	 */
	public void editCounter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(15)).toString(), map.get(mapKeys.get(7)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectCountOnInEdit(map.get(mapKeys.get(4)).toString());
			if (!map.get(mapKeys.get(5)).toString().trim().equals("")) {
				if (verifyElement(By.id(readJSFile("INPUT_COUNTER_EDIT_COUNTERONVALUE", FileType.element)))) {
					String[] unitlist = map.get(mapKeys.get(5)).toString().trim().split(",");
					clickOnElement(drpUnitInEdit);
					for (int i = 0; i < unitlist.length; i++) {
						if (!verifyElement(
								By.xpath("//*[@id='" + readJSFile("INPUT_COUNTER_EDIT_COUNTERONVALUE", FileType.element)
										+ "']//*[normalize-space(text())='" + unitlist[i].trim() + "']"))) {
							selectUnit(unitlist[i].trim());
						}
					}
				}
			}
			sendTextInCounterLimitInEdit(map.get(mapKeys.get(6)).toString());
			selectResetTypeInEdit(map.get(mapKeys.get(8)).toString());
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				selectDayOftheWeekInEdit(map.get(mapKeys.get(9)).toString());
			}
			if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
				selectDayOfMonth(map.get(mapKeys.get(10)).toString());
			}
			if (!map.get(mapKeys.get(11)).toString().trim().equals("")) {
				selectMonthOfYear(map.get(mapKeys.get(11)).toString());
			}
			sendTextInIntervalInEdit(map.get(mapKeys.get(12)).toString());
			selectMonitoringEndTypeInEdit(map.get(mapKeys.get(13)).toString());
			if (verifyElement(By.id(readJSFile("INPUT_COUNTER_EDIT_OCCURENCE", FileType.element)))) {
				sendTextInOccurenceInEdit(map.get(mapKeys.get(14)).toString());
			}
			selectStatusInEdit(map.get(mapKeys.get(16)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedCounter(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By countOn = By.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.counton", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(4)).toString() + "']");
		By counterLimit = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.counterlimit", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
						+ map.get(mapKeys.get(6)).toString() + "')]");
		By resetType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.resettype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(8)).toString() + "']");
		By dayOftheWeek = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.dayoftheweek", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
						+ map.get(mapKeys.get(9)).toString() + "')]");
		By dayOfMonth = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.dayofthemonth", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
						+ map.get(mapKeys.get(10)).toString() + "')]");
		By monthOfYear = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.monthofyear", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
						+ map.get(mapKeys.get(11)).toString() + "')]");
		By interval = By.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.interval", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(12)).toString() + "']");
		By occurence = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.occurrence", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(14)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("counter.label.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(16)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(),
				map.get(mapKeys.get(16)).toString(), map.get(mapKeys.get(8)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(countOn, false))
				return false;
			if (!map.get(mapKeys.get(5)).toString().trim().equals("")) {
				String[] unitlist = map.get(mapKeys.get(4)).toString().trim().split(",");
				for (int i = 0; i < unitlist.length; i++) {
					if (!verifyElement(By.xpath("//*[normalize-space(text()) = '"
							+ readJSFile("counter.label.counteronvalue", FileType.label)
							+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'" + unitlist[i]
							+ "')]"), false))
						return false;
				}
			}
			if (!verifyElement(counterLimit, false))
				return false;
			if (!verifyElement(resetType, false))
				return false;
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				if (!verifyElement(dayOftheWeek, false))
					return false;
			}
			if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
				if (!verifyElement(dayOfMonth, false))
					return false;
			}
			if (!map.get(mapKeys.get(11)).toString().trim().equals("")) {
				if (!verifyElement(monthOfYear, false))
					return false;
			}
			if (!verifyElement(interval, false))
				return false;
			if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
				if (!verifyElement(occurence, false))
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
	 * @author shivani.patel Create deleteCounter Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 08/08/2019
	 */
	public boolean deleteCounter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "Counter already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deleteCounter Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 08/08/2019
	 */
	public boolean verifyDeletedCounter(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
					map.get(mapKeys.get(3)).toString(), map.get(mapKeys.get(4)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}
	public boolean sortCounter(Map<Object, Object> map, List<Object> mapKeys) {
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
