package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.TechnicalConfigProcessSchedulerWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class TechnicalConfigProcessScheduler extends Common {

	HomeWeb homePage;
	TechnicalConfigProcessSchedulerWeb technicalConfignProcessSchedulerWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author dharti.patel For Technical Configuration - Process Scheduler -
	 *         Add
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "TechnicalConfig_AddProcessScheduler", dataProviderClass = TestDataImport.class, description = "Add Process Scheduler")
	public void addProcessScheduler(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			technicalConfignProcessSchedulerWeb = homePage
					.clickOnTechnicalConfigProcessScheduler();
			count++;
		}

		technicalConfignProcessSchedulerWeb.addProcessScheduler(map,
				getMapKeys(map));
		verifyTrue(technicalConfignProcessSchedulerWeb
				.verifyProcessScheduler(map, getMapKeys(map)));

	}

	/**
	 * @author dharti.patel For Technical Configuration - Process Scheduler -
	 *         Edit
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "TechnicalConfig_EditProcessScheduler", dataProviderClass = TestDataImport.class, description = "Edit Scheduler")
	public void editProcessScheduler(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			technicalConfignProcessSchedulerWeb = homePage
					.clickOnTechnicalConfigProcessScheduler();
			count++;
		}

		technicalConfignProcessSchedulerWeb.editProcessScheduler(map,
				getMapKeys(map));
		verifyTrue(technicalConfignProcessSchedulerWeb
				.verifyEditProcessScheduler(map, getMapKeys(map)));

	}

	/**
	 * @author dharti.patel For Technical Configuration - Process Scheduler -
	 *         Delete
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "TechnicalConfig_DeleteProcessScheduler", dataProviderClass = TestDataImport.class, description = "Delete Scheduler")
	public void deleteProcessScheduler(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			technicalConfignProcessSchedulerWeb = homePage
					.clickOnTechnicalConfigProcessScheduler();
			count++;
		}

		technicalConfignProcessSchedulerWeb.deleteProcessScheduler(map,
				getMapKeys(map));
		verifyTrue(technicalConfignProcessSchedulerWeb
				.verifyDeleteProcessScheduler(map, getMapKeys(map)));

	}

}
