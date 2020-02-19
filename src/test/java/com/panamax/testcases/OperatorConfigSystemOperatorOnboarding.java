package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.OperatorConfigSystemOperatorOnboardingWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class OperatorConfigSystemOperatorOnboarding extends Common {

	HomeWeb homePage;
	OperatorConfigSystemOperatorOnboardingWeb operatorConfigSystemOperatorOnboardingWeb;
	int sortCounter = 0;
	private long startTime;
	long start = Long.MAX_VALUE;
	long startMS;

	/**
	 * @author shivani.patel For Platform Configuration - SystemOperatorOnboarding -
	 *         Add
	 * @creation date 24/09/2019
	 */
	@Test(dataProvider = "SystemOperatorOnboarding_Add", dataProviderClass = TestDataImport.class, description = "Id: AddSystemOperatorOnboarding, Author: shivani.patel")
	public void addSystemOperatorOnboarding(Map<Object, Object> map) {
		startTime = System.currentTimeMillis();
		try {
			map.put("Test Start Time", startTime);
			map.put("Class Name", this.getClass().getName());
			map.put("Method Name", "addSystemOperatorOnboarding");
			homePage = goToHome();
			operatorConfigSystemOperatorOnboardingWeb = homePage.clickOnOperatorConfigSystemOperatorOnboarding();
			operatorConfigSystemOperatorOnboardingWeb.addSystemOperatorOnboarding(map, getMapKeys(map));
			verifyTrue(operatorConfigSystemOperatorOnboardingWeb.verifyAddedSystemOperatorOnboarding(map,
					getMapKeys(map)));

			map.put("value", 100);
		} catch (Exception e) {
			map.put("value", 0);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
