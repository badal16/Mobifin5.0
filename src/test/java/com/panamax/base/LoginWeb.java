package com.panamax.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginWeb extends BaseWeb {

	public LoginWeb(WebDriver driver) {
		this.driver = driver;
	}

	By unmTextBox = By.id("inputLoginUsername");
	By pwdTextBox = By.id("inputLoginPd");
	By loginBtn = By.id("btnLoginLogin");
	By languageDropDown = By.id("Language");

	/**
	 * @author vivek.mishra
	 * @param unm
	 *            to be send
	 * @creation date 27/09/2018
	 */
	public void sendTextInUnmField(String unm) {
		sendTextInTextBox(unmTextBox, unm);
	}

	/**
	 * @author vivek.mishra
	 * @param pwd
	 *            to be send
	 * @creation date 27/09/2018
	 */
	public void sendTextInPwdField(String pwd) {
		sendTextInTextBox(pwdTextBox, pwd);
	}

	/**
	 * @author vivek.mishra To click on an element
	 * @creation date 27/09/2018
	 */
	public void clickOnLoginBtn() {
		clickOnElement(loginBtn);
	}

	public void selectLanguage(String language) {
		selectFromDropdown(languageDropDown, language);
	}

	/**
	 * @author vivek.mishra To login
	 * @creation date 27/09/2018
	 */
	public void login(String userName, String password) {
		sendTextInUnmField(userName);
		sendTextInPwdField(password);
		clickOnLoginBtn();
	}

}
