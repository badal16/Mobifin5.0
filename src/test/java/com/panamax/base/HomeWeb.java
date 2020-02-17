package com.panamax.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class HomeWeb extends BaseWeb {

	By homeButton = By.xpath("//*[@class='ant-breadcrumb-link']//i");

	String homeURL;

	public HomeWeb(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @author dishant.doshi
	 * @return the home web
	 * @creation date 28/09/2018
	 */
	public HomeWeb clickOnHomeButton() {
		Common commonWeb = new Common();
		homeURL = commonWeb.getTestData("Admin", "homeURL");
		/*
		 * if(!getCurrentURL().equals(homeURL)) clickOnElement(homeButton);
		 */
		return new HomeWeb(this.driver);
	}

}
