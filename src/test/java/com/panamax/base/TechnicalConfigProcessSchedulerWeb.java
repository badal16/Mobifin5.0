package com.panamax.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class TechnicalConfigProcessSchedulerWeb extends Common {

	By addBtn = By.id("operationbarbuttonadd");
	By name = By.id("inputProcessSchedulerAddName");
	By description = By.id("inputProcessSchedulerAddDescription");
	String schedulerType = ".//*[normalize-space(text())='%s']";
	String status = ".//*[@id='inputProcessSchedulerAddStatus']//*[normalize-space(text())='%s']";
	By scheduler = By.xpath(
			".//*[@id='inputProcessSchedulerAddScheduler']//*[@class='ant-select-arrow']");
	By save = By.id("operationbarbuttonsave");
	By backBtn = By.id("operationbarbuttonback");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"(//*[normalize-space(text())='Status']//following::*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow'])[1]");
	By process = By.xpath(
			".//*[@id='inputProcessSchedulerAddProcess']//*[@class='ant-select-arrow']");
	By date = By.id("inputProcessSchedulerAddStartDate");
	String processType = ".//*[@id='inputProcessSchedulerAddProcess']//following::*[normalize-space(text())='%s']";
	String txtBox = "(.//*[normalize-space(text())='%s']//following::input[@type='text' and contains(@id,'defaultValue')])[1]";
	By editBtn = By.id("operationbarbuttonedit");
	By deleteBtn = By.id("operationbarbuttondelete");
	By descriptionEdit = By.id("inputProcessSchedulerEditDescription");
	String statusEdit = ".//*[@id='inputProcessSchedulerEditStatus']//*[normalize-space(text())='%s']";
	By schedulerEdit = By.xpath(
			".//*[@id='inputProcessSchedulerEditScheduler']//*[@class='ant-select-arrow']");
	By dateEdit = By.id("inputProcessSchedulerEditStartDate");
	String processTypeEdit = ".//*[@id='inputProcessSchedulerEditProcess']//following::*[normalize-space(text())='%s']";
	By processEdit = By.xpath(
			".//*[@id='inputProcessSchedulerEditProcess']//*[@class='ant-select-arrow']");

	/**
	 * @author dharti.patel
	 * @param driver
	 *            constructor
	 * @creation date 05/02/2020
	 */
	public TechnicalConfigProcessSchedulerWeb(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @author dharti.patel
	 * @param driver
	 *            Add Scheduler
	 * @creation date 05/02/2020
	 */
	public void addProcessScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(0)).toString(),
				map.get(mapKeys.get(4)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {
			clickOnElement(addBtn);
			commonWait(10);
			sendTextInName(map.get(mapKeys.get(0)).toString());
			sendTextInDescription(map.get(mapKeys.get(1)).toString());
			selectSchedulerType(map.get(mapKeys.get(2)).toString());
			selectProcess(map.get(mapKeys.get(3)).toString());

			sendTextInFromDate();
			selectStatus(map.get(mapKeys.get(4)).toString());

			if (!map.get(mapKeys.get(5)).toString().isEmpty()) {

				String[] param = map.get(mapKeys.get(5)).toString().split(",");
				System.out.println("====================" + param);

				for (int i = 0; i < param.length; i++) {
					String name = param[i].split(":")[0];
					String value = param[i].split(":")[1];
					if (verifyElement(By.xpath(
							".//*[normalize-space(text())='" + name + "']"))) {

						String val = String.format(txtBox, name);
						sendTextInTextBox(By.xpath(val), value);

					}
				}

			}

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
		clearAndSendTextInTextBox(description, schedulerDescription);
	}

	/**
	 * @author dharti.patel
	 * @param type
	 *            select Scheduler type
	 * @creation date 05/02/2020
	 */
	public void selectSchedulerType(String type) {
		clickOnElement(scheduler);
		String stype = String.format(schedulerType, type);
		clickOnElement(By.xpath(stype));
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

	public void selectProcess(String type) {
		clickOnElement(process);
		String stype = String.format(processType, type);
		clickOnElement(By.xpath(stype));

	}

	/**
	 * @author dharti.patel
	 * 
	 *         Verify Scheduler
	 * @creation date 05/02/2020
	 */
	public boolean verifyProcessScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);

		By name = By.xpath(
				".//*[normalize-space(text())='Name']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(0)).toString() + "']");
		By description = By.xpath(
				".//*[normalize-space(text())='Description']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(1)).toString() + "']");
		By type = By.xpath(
				"//*[normalize-space(text())='Scheduler']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By process = By.xpath(
				".//*[normalize-space(text())='Process']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By startDate = By.xpath(
				".//*[normalize-space(text())='Start Date']//following::*[contains(normalize-space(text()),'"
						+ dateTime + "')]");
		By status = By.xpath(
				".//*[normalize-space(text())='Status']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		commonWait(10);
		filterSearch(map.get(mapKeys.get(0)).toString(),
				map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {

			clickOnInfoBtn(map.get(getMapKeys(map).get(0)).toString());
			if (!verifyElement(name)) {
				return false;
			}
			if (!verifyElement(description)) {
				return false;
			}
			if (!verifyElement(type)) {
				return false;
			}

			if (!verifyElement(process)) {
				return false;
			}
			if (!verifyElement(startDate)) {
				return false;
			}
			if (!verifyElement(status)) {
				return false;
			}

			if (!map.get(mapKeys.get(5)).toString().isEmpty()) {

				String[] param = map.get(mapKeys.get(5)).toString().split(",");
				System.out.println("====================" + param);

				for (int i = 0; i < param.length; i++) {
					String nameID = param[i].split(":")[0];
					String value = param[i].split(":")[1];
					if (verifyElement(By.xpath(".//*[normalize-space(text())='"
							+ nameID + "']"))) {

						if (!verifyElement(By.xpath(
								"(.//*[normalize-space(text())='" + nameID
										+ "']//following::*[normalize-space(text())='"
										+ value + "'])[1]"))) {
							return false;
						}

					}
				}

			}

			return true;

		} else {
			return false;
		}

	}

	public void filterSearch(String name, String state, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath(
					"//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInNameFilterSearch(name);
		selectStatusInFilterSearch(state);

		clickOnFilterSearchBtn();
	}

	public void sendTextInNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='"
				+ status.trim() + "'])[last()]"));
	}

	/**
	 * @author dharti.patel
	 * @param driver
	 *            Edit Process Scheduler
	 * @creation date 05/02/2020
	 */
	public void editProcessScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(0)).toString(),
				map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {
			clickOnInfoBtn(map.get(mapKeys.get(0)).toString());
			clickOnElement(editBtn);
			commonWait(10);

			sendTextInDescriptionEdit(map.get(mapKeys.get(1)).toString());
			selectSchedulerTypeEdit(map.get(mapKeys.get(2)).toString());
			selectProcessEdit(map.get(mapKeys.get(3)).toString());
			sendTextInFromDateEdit();
			selectStatusEdit(map.get(mapKeys.get(4)).toString());

			if (!map.get(mapKeys.get(5)).toString().isEmpty()) {

				String[] param = map.get(mapKeys.get(5)).toString().split(",");

				for (int i = 0; i < param.length; i++) {
					String name = param[i].split(":")[0];
					String value = param[i].split(":")[1];
					if (verifyElement(By.xpath(
							".//*[normalize-space(text())='" + name + "']"))) {

						String val = String.format(txtBox, name);
						clearAndSendTextInTextBox(By.xpath(val), value);

					}
				}

			}

			clickOnSaveBtn();
		}

	}

	/**
	 * @author dharti.patel
	 * 
	 *         Verify Scheduler
	 * @creation date 05/02/2020
	 */
	public boolean verifyEditProcessScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);

		By name = By.xpath(
				".//*[normalize-space(text())='Name']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(0)).toString() + "']");
		By description = By.xpath(
				".//*[normalize-space(text())='Description']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(1)).toString() + "']");
		By type = By.xpath(
				"//*[normalize-space(text())='Scheduler']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By process = By.xpath(
				".//*[normalize-space(text())='Process']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By startDate = By.xpath(
				".//*[normalize-space(text())='Start Date']//following::*[contains(normalize-space(text()),'"
						+ dateTime + "')]");
		By status = By.xpath(
				"//*[normalize-space(text())='Status']//following::*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		commonWait(10);
		filterSearch(map.get(mapKeys.get(0)).toString(),
				map.get(mapKeys.get(4)).toString(), true);

		commonWait(10);
		if (verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {

			clickOnInfoBtn(map.get(getMapKeys(map).get(0)).toString());

			waitForLoader();
			commonWait(10);
			if (!verifyElement(name)) {
				return false;
			}
			if (!verifyElement(description)) {
				return false;
			}
			if (!verifyElement(type)) {
				return false;
			}

			if (!verifyElement(process)) {
				return false;
			}
			if (!verifyElement(startDate)) {
				return false;
			}
			if (!verifyElement(status)) {
				return false;
			}

			if (!map.get(mapKeys.get(5)).toString().isEmpty()) {

				String[] param = map.get(mapKeys.get(5)).toString().split(",");
				System.out.println("====================" + param);

				for (int i = 0; i < param.length; i++) {
					String nameID = param[i].split(":")[0];
					String value = param[i].split(":")[1];
					if (verifyElement(By.xpath(".//*[normalize-space(text())='"
							+ nameID + "']"))) {

						if (!verifyElement(By.xpath(
								"(.//*[normalize-space(text())='" + nameID
										+ "']//following::*[normalize-space(text())='"
										+ value + "'])[1]"))) {
							return false;
						}

					}
				}
			}

			return true;

		} else {
			return false;
		}

	}

	/**
	 * @author dharti.patel
	 * @param driver
	 *            Delete Process Scheduler
	 * @creation date 05/02/2020
	 */
	public void deleteProcessScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {
		filterSearchForDelete(map.get(mapKeys.get(0)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {
			clickOnInfoBtn(map.get(mapKeys.get(0)).toString());
			commonWait();
			delete();
			commonWait();

		}

	}

	public boolean VerifyDeleteProcessScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {

		filterSearchForDelete(map.get(mapKeys.get(0)).toString(), true);
		return verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false);

	}

	public void sendTextInFromDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);
		clickOnElement(date);

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
		if (!verifyElement(By.xpath(
				"//*[contains(@class,'ant-select-selection-selected-value')][normalize-space(text())='"
						+ type + "']"))) {
			clickOnElement(schedulerEdit);
			String stype = String.format(schedulerType, type);

			clickOnElement(By.xpath(stype));
		}

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

	public void selectProcessEdit(String type) {
		if (!verifyElement(By.xpath(
				"//*[contains(@class,'ant-select-selection-selected-value')][normalize-space(text())='"
						+ type + "']"))) {
			clickOnElement(processEdit);
			String stype = String.format(processTypeEdit, type);
			clickOnElement(By.xpath(stype));
		}

	}

	public void sendTextInFromDateEdit() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);
		clickOnElement(dateEdit);

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
	 * @param driver
	 *            Edit Scheduler
	 * @creation date 05/02/2020
	 */
	public boolean verifyDeleteProcessScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {
		filterSearchForDelete(map.get(mapKeys.get(0)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='"
				+ map.get(getMapKeys(map).get(0)).toString() + "'])[1]"),
				false)) {
			return true;

		}
		return false;
	}

	public void filterSearchForDelete(String name, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath(
					"//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInNameFilterSearch(name);

		clickOnFilterSearchBtn();
	}

}
