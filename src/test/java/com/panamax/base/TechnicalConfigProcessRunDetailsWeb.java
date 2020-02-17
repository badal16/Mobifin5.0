package com.panamax.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class TechnicalConfigProcessRunDetailsWeb extends Common {

	By addBtn = By.id("operationbarbuttonadd");
	By name = By.id("inputProcessSchedulerAddName");
	By description = By.id("inputProcessSchedulerAddDescription");
	String schedulerType = ".//*[@id='inputSchedulerAddSchedulerType']//*[normalize-space(text())='%s']";
	String status = ".//*[@id='inputSchedulerAddStatus']//*[normalize-space(text())='%s']";
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
	String processType = ".//*[@id='inputProcessSchedulerAddProcess']//*[normalize-space(text())='%s']";
	String txtBox = "(.//*[normalize-space(text())='%s']//following::input[@type='text' and contains(@id,'defaultValue')])[1]";
	By editBtn = By.id("operationbarbuttonedit");
	By deleteBtn = By.id("operationbarbuttondelete");
	By remarks = By.xpath(".//*[@name='remarks']");

	/**
	 * @author dharti.patel
	 * @param driver
	 *            constructor
	 * @creation date 05/02/2020
	 */
	public TechnicalConfigProcessRunDetailsWeb(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @author dharti.patel
	 * @param driver
	 *            Add Scheduler
	 * @creation date 05/02/2020
	 */
	public boolean verifyProcessRunDetails() {

		return verifyElement(By.xpath(".//*[@class='ant-table-body']"));
	}

	public void filterSearch(String remarksName, String state,
			boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath(
					"//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}

		sendTextInRemarksInFilterSearch(remarksName);
		selectStatusInFilterSearch(state);
		clickOnFilterSearchBtn();
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='"
				+ status.trim() + "'])[last()]"));
	}

	public void sendTextInRemarksInFilterSearch(String remarksName) {
		sendTextInTextBox(remarks, remarksName);
	}

}
