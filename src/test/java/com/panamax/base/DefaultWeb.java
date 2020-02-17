package com.panamax.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

/**
 * @author dishant.doshi Actions of Settings - User Management - Role
 * @creation date 31/12/2018
 */
public class DefaultWeb extends Common {
	HomeWeb homePage;
	DefaultWeb defaultWeb;

	By maker = By.xpath("//a[normalize-space(text())='Maker']");
	By readOnly = By.xpath("//a[normalize-space(text())='Readonly']");
	By body = By.cssSelector("body");
	By fcmAccountName = By.id("FCMAccountName");
	By fcmAccountStatus = By.id("IsActive");
	By signInWithNewAccount = By.xpath("//*[text()='Sign in with a different account']");
	By addNewAccount = By.xpath("//*[text()='Add account']");

	/**
	 * @author dishant.doshi
	 * @param driver
	 *            constructor
	 * @creation date 31/12/2018
	 */
	public DefaultWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnSignInWithNewAccount() {
		clickOnElement(signInWithNewAccount);
	}

	public void clickOnAddNewAccount() {
		clickOnElement(addNewAccount);
	}

	public void clickOnMakerLink() {
		clickOnElement(maker);
	}

	public void clickOnReadOnlyLink() {
		clickOnElement(readOnly);
	}

	public void selectTextInFCMAccountName(String fcmAccName) {
		selectFromDropdown(fcmAccountName, fcmAccName);
	}

	public void selectTextInStatus(String status) {
		selectFromDropdown(fcmAccountStatus, status);
	}

	public void sendTextInAppKey(By element, String appKey) {
		sendTextInTextBox(element, appKey);
	}


	public void login() {
		LoginWeb loginPage = new LoginWeb(this.driver);
		loginPage.login("admin", "123456");
	}

}
