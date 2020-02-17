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

public class TechnicalConfigSchedulerWeb extends Common {

	By addBtn = By.id("operationbarbuttonadd");
	By name = By.id("inputSchedulerName");
	By description = By.id("inputSchedulerDiscription");
	String schedulerType = ".//*[@id='inputSchedulerAddSchedulerType']//*[normalize-space(text())='%s']";
	String schedulerEndType = ".//*[@id='inputSchedulerAddSchedulerEndType']//*[normalize-space(text())='%s']";
	By daysOfWeek = By.xpath(
			".//*[@id='inputSchedulerAddWeekdays']//*[@class='ant-select-arrow']");
	By daysOfMonth = By.xpath(
			".//*[@id='inputSchedulerAddMonthofdays']//*[@class='ant-select-arrow']");
	By daysOfYear = By.xpath(
			".//*[@id='inputSchedulerAdddaysofmonth']//*[@class='ant-select-arrow']");
	String selectDays = ".//*[normalize-space(text())='%s']";
	By executionInterval = By.id("inputSchedulerAddInterval");
	String status = ".//*[@id='inputSchedulerAddStatus']//*[normalize-space(text())='%s']";
	String scheduler = "//*[@class='ant-table-tbody']//*[normalize-space(text())='%s']";
	By save = By.id("operationbarbuttonsave");
	By backBtn = By.id("operationbarbuttonback");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"(//*[normalize-space(text())='Status']//following::*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow'])[1]");
	By drpSchedulerInSearch = By.xpath(
			"(//*[normalize-space(text())='Scheduler Type']//following::*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow'])[1]");
	By occurrence = By.id("inputSchedulerAddOccurence");
	By endDate = By.id("inputSchedulerAddEndDate");
	By editBtn = By.id("operationbarbuttonedit");
	By descriptionEdit = By.id("inputSchedulereditDescription");
	String schedulerTypeEdit = ".//*[@id='inputSchedulereditSchedulerType']//*[normalize-space(text())='%s']";
	By executionIntervalEdit = By.id("inputSchedulereditInterval");
	String schedulerEndTypeEdit = ".//*[@id='inputSchedulereditSchedulerEndType']//*[normalize-space(text())='%s']";
	String statusEdit = ".//*[@id='inputSchedulereditStatus']//*[normalize-space(text())='%s']";
	By daysOfWeekEdit = By.xpath(
			".//*[@id='inputSchedulereditWeekdays']//*[@class='ant-select-arrow']");
	By daysOfMonthEdit = By.xpath(
			".//*[@id='inputSchedulereditMonthofdays']//*[@class='ant-select-arrow']");
	By daysOfYearEdit = By.xpath(
			".//*[@id='inputSchedulereditdaysofmonth']//*[@class='ant-select-arrow']");
	By occurrenceEdit = By.id("inputSchedulereditOccurence");
	By deleteBtn = By.id("operationbarbuttondelete");

	/**
	 * @author dharti.patel
	 * @param driver
	 *            constructor
	 * @creation date 05/02/2020
	 */
	public TechnicalConfigSchedulerWeb(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @author dharti.patel
	 * 
	 *         Add Scheduler
	 * @creation date 05/02/2020
	 */
	public void addScheduler(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(0)).toString(),
				map.get(mapKeys.get(6)).toString(),
				map.get(mapKeys.get(2)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {
			clickOnElement(addBtn);
			commonWait(10);
			sendTextInName(map.get(mapKeys.get(0)).toString());
			sendTextInDescription(map.get(mapKeys.get(1)).toString());
			selectSchedulerType(map.get(mapKeys.get(2)).toString());

			if (map.get(mapKeys.get(2)).toString().trim().equals("Weekly")) {
				selectValueFromDaysOfWeek(map.get(mapKeys.get(3)).toString());
			} else if (map.get(mapKeys.get(2)).toString().trim()
					.equals("Monthly")) {
				selectValueFromDaysOfMonth(map.get(mapKeys.get(10)).toString());
			} else if (map.get(mapKeys.get(2)).toString().trim()
					.equals("Yearly")) {
				selectValueFromDaysOfYear(map.get(mapKeys.get(9)).toString());
			}

			sendTextInExecutionInterval(map.get(mapKeys.get(4)).toString());
			selectSchedulerEndType(map.get(mapKeys.get(5)).toString());
			if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Occurrence")) {
				sendTextInOccurrenceField(map.get(mapKeys.get(7)).toString());
			} else if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Date")) {
				sendTextInFromDate();
			}

			selectStatus(map.get(mapKeys.get(6)).toString());

			clickOnSaveBtn();
		}

	}

	/**
	 * @author dharti.patel
	 * @param schedulerName
	 *            send text in Name field
	 * @creation date 05/02/2020
	 */
	public void sendTextInName(String schedulerName) {
		sendTextInTextBox(name, schedulerName);
	}

	/**
	 * @author dharti.patel
	 * @param schedulerDescription
	 *            send text in Description field
	 * @creation date 05/02/2020
	 */
	public void sendTextInDescription(String schedulerDescription) {
		sendTextInTextBox(description, schedulerDescription);
	}

	/**
	 * @author dharti.patel
	 * @param type
	 *            select Scheduler type
	 * @creation date 05/02/2020
	 */
	public void selectSchedulerType(String type) {
		String stype = String.format(schedulerType, type);
		clickOnElement(By.xpath(stype));
	}

	/**
	 * @author dharti.patel
	 * @param days
	 *            select Days of week from Dropdown
	 * @creation date 05/02/2020
	 */
	public void selectValueFromDaysOfWeek(String days) {

		clickOnElement(daysOfWeek);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}

	/**
	 * @author dharti.patel
	 * @param time
	 *            send text in execution Interval field
	 * @creation date 05/02/2020
	 */
	public void sendTextInExecutionInterval(String time) {
		sendTextInTextBox(executionInterval, time);
	}

	/**
	 * @author dharti.patel
	 * @param state
	 *            select Status
	 * @creation date 05/02/2020
	 */
	public void selectStatus(String state) {
		String s = String.format(status, state);
		clickOnElement(By.xpath(s));
	}

	/**
	 * @author dharti.patel
	 * @param state
	 *            select Scheduler End Type
	 * @creation date 05/02/2020
	 */
	public void selectSchedulerEndType(String type) {
		String stype = String.format(schedulerEndType, type);
		clickOnElement(By.xpath(stype));
	}

	/**
	 * @author dharti.patel
	 * @param days
	 *            select Days of Month from Dropdown
	 * @creation date 05/02/2020
	 */
	public void selectValueFromDaysOfMonth(String days) {

		clickOnElement(daysOfMonth);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}

	/**
	 * @author dharti.patel
	 * @param days
	 *            select Days of Month from Dropdown
	 * @creation date 05/02/2020
	 */
	public void selectValueFromDaysOfYear(String days) {

		clickOnElement(daysOfYear);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}

	/**
	 * @author dharti.patel
	 * 
	 *         Verify Scheduler
	 * @creation date 05/02/2020
	 */
	public boolean verifyScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {

		By name = By.xpath(
				"//*[@id='lblSchedulerViewName'][normalize-space(text())='"
						+ map.get(mapKeys.get(0)).toString() + "']");
		By description = By.xpath(
				"//*[@id='lblSchedulerDescription'][normalize-space(text())='"
						+ map.get(mapKeys.get(1)).toString() + "']");
		By type = By.xpath(
				"//*[normalize-space(text())='Scheduler Type']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By interval = By.xpath(
				"//*[normalize-space(text())='Execution Interval']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		By endType = By.xpath(
				"//*[@id='lblSchedularEndType'][normalize-space(text())='"
						+ map.get(mapKeys.get(5)).toString() + "']");
		By status = By.xpath(
				"//*[@id='lblSchedulerViewStatus']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(6)).toString() + "']");
		By dayofWeek = By
				.xpath("//*[@id='lblSchedulerDayofWeek'][contains(text(),'"
						+ map.get(mapKeys.get(3)).toString() + "')]");

		By dayOfMonth = By
				.xpath("//*[@id='lblSchedulerDay'][normalize-space(text())='"
						+ map.get(mapKeys.get(10)).toString() + "']");

		By monthoOfYear = By.xpath(
				"//*[@id='lblSchedulerMonthofYear'][normalize-space(text())='"
						+ map.get(mapKeys.get(9)).toString() + "']");
		By occurrence = By.xpath(
				"//*[normalize-space(text())='Occurence']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");
		waitForLoader();
		commonWait(10);
		filterSearch(map.get(mapKeys.get(0)).toString(),
				map.get(mapKeys.get(6)).toString(),
				map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {

			commonWait();
			waitForLoader();
			clickOnInfoBtn(map.get(getMapKeys(map).get(0)).toString());
			waitForLoader();
			if (!verifyElement(name)) {
				return false;
			}
			if (!verifyElement(description)) {
				return false;
			}
			if (!verifyElement(type)) {
				return false;
			}
			if (!verifyElement(interval)) {
				return false;
			}
			// if (!verifyElement(endType)) {
			// return false;
			// }

			if (!verifyElement(status)) {
				return false;
			}

			if (map.get(mapKeys.get(4)).toString().trim().equals("Weekly")) {
				if (!verifyElement(dayofWeek)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(4)).toString().trim().equals("Monthly")) {
				if (!verifyElement(dayOfMonth)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(4)).toString().trim().equals("Yearly")) {
				if (!verifyElement(monthoOfYear)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Occurrence")) {
				if (!verifyElement(occurrence)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Date")) {

			}

			return true;

		} else {
			return false;
		}

	}

	/**
	 * @author dharti.patel
	 * 
	 *         Filter search
	 * @creation date 05/02/2020
	 */
	public void filterSearch(String name, String state, String type,
			boolean isSubString) {
		commonFilterSearch();
		commonWait();
		if (isSubString) {
			clickOnElement(By.xpath(
					"//*[@class='filter-group-first ant-select ant-select-enabled']"));

			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInNameFilterSearch(name);
		selectStatusInFilterSearch(state);
		commonWait();
		selectSchedulerInFilterSearch(type);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author dharti.patel
	 * 
	 *         send Text In Name FilterSearch
	 * @creation date 05/02/2020
	 */
	public void sendTextInNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	/**
	 * @author dharti.patel
	 * 
	 *         select Status In FilterSearch
	 * @creation date 05/02/2020
	 */
	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='"
				+ status.trim() + "'])[last()]"));
	}

	/**
	 * @author dharti.patel
	 * 
	 *         select Scheduler In FilterSearch
	 * @creation date 05/02/2020
	 */
	public void selectSchedulerInFilterSearch(String type) {
		clickOnElement(drpSchedulerInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + type.trim()
				+ "'])[last()]"));
	}

	/**
	 * @author dharti.patel
	 * 
	 *         send Text In Occurrence Field
	 * @creation date 05/02/2020
	 */
	public void sendTextInOccurrenceField(String occur) {
		sendTextInTextBox(occurrence, occur);
	}

	/**
	 * @author dharti.patel
	 * 
	 *         send Text In Date Field
	 * @creation date 05/02/2020
	 */
	public void sendTextInFromDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);
		clickOnElement(endDate);

		String day = dateTime.split("-")[2];
		if (day.startsWith("0"))
			day = day.replaceFirst("0", "");
		clickOnElement(By.xpath(
				".//*[@class='ant-calendar-date' and @aria-selected='true'][normalize-space(text())='"
						+ day.trim() + "']"));

		clickOnElement(By.xpath("//*[@class='ant-calendar-ok-btn']"));
	}

	/**
	 * @author dharti.patel
	 * 
	 *         send Text In Date Field
	 * @creation date 05/02/2020
	 */
	public void sendTextInToDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, +30);
		Date currentDatePlusOne = c.getTime();
		String fromDate = dateFormat.format(currentDatePlusOne);
		clickOnElement(endDate);
		clearAndSendTextInTextBox(By.xpath("//*[@class='ant-calendar-input ']"),
				fromDate);
		clickOnElement(By.xpath("//*[@class='ant-calendar-ok-btn']"));
	}

	/**
	 * @author dharti.patel
	 * 
	 *         Edit Scheduler
	 * @creation date 05/02/2020
	 */
	public void editScheduler(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearchForEdit(map.get(mapKeys.get(0)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {
			clickOnInfoBtn(map.get(mapKeys.get(0)).toString());
			commonWait();
			clickOnElement(editBtn);
			commonWait();
			waitForLoader();
			sendTextInDescriptionEdit(map.get(mapKeys.get(1)).toString());
			selectSchedulerTypeEdit(map.get(mapKeys.get(2)).toString());

			if (map.get(mapKeys.get(2)).toString().trim().equals("Weekly")) {
				selectValueFromDaysOfWeekEdit(
						map.get(mapKeys.get(3)).toString());
			} else if (map.get(mapKeys.get(2)).toString().trim()
					.equals("Monthly")) {
				selectValueFromDaysOfMonthEdit(
						map.get(mapKeys.get(10)).toString());
			} else if (map.get(mapKeys.get(2)).toString().trim()
					.equals("Yearly")) {
				selectValueFromDaysOfYearEdit(
						map.get(mapKeys.get(9)).toString());
			}

			sendTextInExecutionIntervalEdit(map.get(mapKeys.get(4)).toString());
			selectSchedulerEndTypeEdit(map.get(mapKeys.get(5)).toString());
			if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Occurrence")) {
				sendTextInOccurrenceFieldEdit(
						map.get(mapKeys.get(7)).toString());
			} else if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Date")) {
				sendTextInFromDate();
			}

			selectStatusEdit(map.get(mapKeys.get(6)).toString());

			clickOnSaveBtn();
		}

	}

	/**
	 * @author dharti.patel
	 * 
	 *         Verify Edited Scheduler
	 * @creation date 05/02/2020
	 */
	public boolean verifyEditedScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {

		By name = By.xpath(
				"//*[@id='lblSchedulerViewName'][normalize-space(text())='"
						+ map.get(mapKeys.get(0)).toString() + "']");
		By description = By.xpath(
				"//*[@id='lblSchedulerDescription'][normalize-space(text())='"
						+ map.get(mapKeys.get(1)).toString() + "']");
		By type = By.xpath(
				"//*[normalize-space(text())='Scheduler Type']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By interval = By.xpath(
				"//*[normalize-space(text())='Execution Interval']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		By endType = By.xpath(
				"//*[@id='lblSchedularEndType'][normalize-space(text())='"
						+ map.get(mapKeys.get(5)).toString() + "']");
		By status = By.xpath(
				"//*[@id='lblSchedulerViewStatus']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(6)).toString() + "']");
		By dayofWeek = By
				.xpath("//*[@id='lblSchedulerDayofWeek'][contains(text(),'"
						+ map.get(mapKeys.get(3)).toString() + "')]");

		By dayOfMonth = By
				.xpath("//*[@id='lblSchedulerDay'][normalize-space(text())='"
						+ map.get(mapKeys.get(10)).toString() + "']");

		By monthoOfYear = By.xpath(
				"//*[@id='lblSchedulerMonthofYear'][normalize-space(text())='"
						+ map.get(mapKeys.get(9)).toString() + "']");
		By occurrence = By.xpath(
				"//*[normalize-space(text())='Occurence']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");

		filterSearch(map.get(mapKeys.get(0)).toString(),
				map.get(mapKeys.get(6)).toString(),
				map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {

			commonWait();
			waitForLoader();
			clickOnInfoBtn(map.get(getMapKeys(map).get(0)).toString());
			waitForLoader();
			if (!verifyElement(name)) {
				return false;
			}
			if (!verifyElement(description)) {
				return false;
			}
			if (!verifyElement(type)) {
				return false;
			}
			if (!verifyElement(interval)) {
				return false;
			}
			// if (!verifyElement(endType)) {
			// return false;
			// }

			if (!verifyElement(status)) {
				return false;
			}

			if (map.get(mapKeys.get(4)).toString().trim().equals("Weekly")) {
				if (!verifyElement(dayofWeek)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(4)).toString().trim().equals("Monthly")) {
				if (!verifyElement(dayOfMonth)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(4)).toString().trim().equals("Yearly")) {
				if (!verifyElement(monthoOfYear)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Occurrence")) {
				if (!verifyElement(occurrence)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Date")) {

			}

			return true;

		} else {
			return false;
		}

	}

	/**
	 * @author dharti.patel
	 * 
	 *         filter Search
	 * @creation date 05/02/2020
	 */
	public void filterSearchForEdit(String name, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath(
					"//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInNameFilterSearch(name);

		clickOnFilterSearchBtn();
	}

	/**
	 * @author dharti.patel
	 * @param schedulerDescription
	 *            send text in Description field
	 * @creation date 05/02/2020
	 */
	public void sendTextInDescriptionEdit(String schedulerDescription) {
		clearAndSendTextInTextBox(descriptionEdit, schedulerDescription);
	}

	/**
	 * @author dharti.patel
	 * @param type
	 *            select Scheduler type
	 * @creation date 05/02/2020
	 */
	public void selectSchedulerTypeEdit(String type) {
		String stype = String.format(schedulerTypeEdit, type);
		clickOnElement(By.xpath(stype));
	}

	/**
	 * @author dharti.patel
	 * @param days
	 *            select Days of week from Dropdown
	 * @creation date 05/02/2020
	 */
	public void selectValueFromDaysOfWeekEdit(String days) {

		clickOnElement(daysOfWeekEdit);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}

	/**
	 * @author dharti.patel
	 * @param time
	 *            send text in execution Interval field
	 * @creation date 05/02/2020
	 */
	public void sendTextInExecutionIntervalEdit(String time) {
		clearAndSendTextInTextBox(executionIntervalEdit, time);
	}

	/**
	 * @author dharti.patel
	 * @param state
	 *            select Status
	 * @creation date 05/02/2020
	 */
	public void selectStatusEdit(String state) {
		String s = String.format(statusEdit, state);
		clickOnElement(By.xpath(s));
	}

	/**
	 * @author dharti.patel
	 * 
	 *         select Scheduler End Type
	 * @creation date 05/02/2020
	 */
	public void selectSchedulerEndTypeEdit(String type) {
		String stype = String.format(schedulerEndTypeEdit, type);
		clickOnElement(By.xpath(stype));
	}

	/**
	 * @author dharti.patel
	 * @param days
	 *            select Days of Month from Dropdown
	 * @creation date 05/02/2020
	 */
	public void selectValueFromDaysOfMonthEdit(String days) {

		clickOnElement(daysOfMonthEdit);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}

	/**
	 * @author dharti.patel
	 * @param days
	 *            select Days of Month from Dropdown
	 * @creation date 05/02/2020
	 */
	public void selectValueFromDaysOfYearEdit(String days) {

		clickOnElement(daysOfYearEdit);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}

	/**
	 * @author dharti.patel
	 * 
	 *         send Text In Occurrence FieldEdit
	 * @creation date 05/02/2020
	 */
	public void sendTextInOccurrenceFieldEdit(String occur) {
		clearAndSendTextInTextBox(occurrenceEdit, occur);
	}

	/**
	 * @author dharti.patel Edit Scheduler
	 * @creation date 05/02/2020
	 */
	public void deleteScheduler(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearchForEdit(map.get(mapKeys.get(0)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {
			clickOnInfoBtn(map.get(mapKeys.get(0)).toString());
			commonWait();
			delete();
			commonWait();

		}
	}

	/**
	 * @author dharti.patel
	 * 
	 *         Delete Scheduler
	 * @creation date 05/02/2020
	 */
	public boolean verifyDeleteScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {
		filterSearchForEdit(map.get(mapKeys.get(0)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {
			return true;

		}
		return false;
	}

}
