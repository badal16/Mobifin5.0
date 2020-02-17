package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.TechnicalConfigSchedulerWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class TechnicalConfigScheduler extends Common {

	HomeWeb homePage;
	TechnicalConfigSchedulerWeb technicalConfignSchedulerWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author dharti.patel For Technical Configuration - Scheduler - Add
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "TechnicalConfig_AddScheduler", dataProviderClass = TestDataImport.class, description = "Id: Add Scheduler, Author: dharti.patel")
	public void addScheduler(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			technicalConfignSchedulerWeb = homePage
					.clickOnTechnicalConfigScheduler();
			count++;
		}

		technicalConfignSchedulerWeb.addScheduler(map, getMapKeys(map));
		verifyTrue(technicalConfignSchedulerWeb.verifyScheduler(map,
				getMapKeys(map)));

	}

	/**
	 * @author dharti.patel For Technical Configuration - Scheduler - Add
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "TechnicalConfig_EditScheduler", dataProviderClass = TestDataImport.class, description = "Id: Add Scheduler, Author: dharti.patel")
	public void editScheduler(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			technicalConfignSchedulerWeb = homePage
					.clickOnTechnicalConfigScheduler();
			count++;
		}

		technicalConfignSchedulerWeb.editScheduler(map, getMapKeys(map));
		verifyTrue(technicalConfignSchedulerWeb.verifyEditedScheduler(map,
				getMapKeys(map)));

	}

	/**
	 * @author dharti.patel For Technical Configuration - Scheduler - Delete
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "TechnicalConfig_DeleteScheduler", dataProviderClass = TestDataImport.class, description = "Id: Add Scheduler, Author: dharti.patel")
	public void deleteScheduler(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			technicalConfignSchedulerWeb = homePage
					.clickOnTechnicalConfigScheduler();
			count++;
		}

		technicalConfignSchedulerWeb.deleteScheduler(map, getMapKeys(map));
		verifyTrue(technicalConfignSchedulerWeb.verifyDeleteScheduler(map,
				getMapKeys(map)));

	}

}
