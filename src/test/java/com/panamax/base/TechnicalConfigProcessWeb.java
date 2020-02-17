package com.panamax.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class TechnicalConfigProcessWeb extends Common {

	By table = By.xpath(".//*[@class='ant-table-body']");

	/**
	 * @author dharti.patel
	 * @param driver
	 *            constructor
	 * @creation date 05/02/2020
	 */
	public TechnicalConfigProcessWeb(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @author dharti.patel
	 * 
	 *         Verify process table
	 * @creation date 05/02/2020
	 */
	public boolean verifyProcessTable() {
		waitForLoader();
		commonWait(10);
		return verifyElement(table);
	}

}
