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
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - SystemOperatorOnboarding -
	 *         Add
	 * @creation date 24/09/2019
	 */
	@Test(dataProvider = "SystemOperatorOnboarding_Add", dataProviderClass = TestDataImport.class, description = "Id: AddSystemOperatorOnboarding, Author: shivani.patel")
	public void addSystemOperatorOnboarding(Map<Object, Object> map) {
		try {
			map.put("Method Name", "addSystemOperatorEntity");
			if (count == 0) {
				homePage = goToHome();
				operatorConfigSystemOperatorOnboardingWeb = homePage.clickOnOperatorConfigSystemOperatorOnboarding();
				count++;
			}
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
