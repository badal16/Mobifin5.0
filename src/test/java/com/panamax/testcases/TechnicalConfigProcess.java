package com.panamax.testcases;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.TechnicalConfigProcessWeb;
import com.panamax.init.Common;

public class TechnicalConfigProcess extends Common {

	HomeWeb homePage;
	TechnicalConfigProcessWeb technicalConfignProcessWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author dharti.patel For Technical Config - Process
	 * @creation date 05/02/2020
	 */
	@Test(description = "Verify Process Report")
	public void process() {
		if (count == 0) {
			homePage = goToHome();
			technicalConfignProcessWeb = homePage
					.clickOnTechnicalConfigProcess();
			count++;
		}

		verifyTrue(technicalConfignProcessWeb.verifyProcessTable());

	}

}
