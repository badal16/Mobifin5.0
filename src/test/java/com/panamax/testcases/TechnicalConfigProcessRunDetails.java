package com.panamax.testcases;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.TechnicalConfigProcessRunDetailsWeb;
import com.panamax.init.Common;

public class TechnicalConfigProcessRunDetails extends Common {

	HomeWeb homePage;
	TechnicalConfigProcessRunDetailsWeb technicalConfignProcessRunDetailsWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author dharti.patel For Technical Configuration - Process Run Details -
	 *         Verify
	 * @creation date 17/07/2019
	 */
	@Test(description = "Verify Process run report")
	public void processRunDetails() {
		if (count == 0) {
			homePage = goToHome();
			technicalConfignProcessRunDetailsWeb = homePage
					.clickOnTechnicalConfigProcessRunDetails();
			count++;
		}

		verifyTrue(
				technicalConfignProcessRunDetailsWeb.verifyProcessRunDetails());

	}

}
