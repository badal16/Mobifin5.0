package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationExchangeRateManagerWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationExchangeRateManager extends Common{
	HomeWeb homePage;
	PlatformConfigurationExchangeRateManagerWeb platformConfigurationExchangeRateManagerWeb;
	int count = 0;

	/**
	 * @author shivani.patel For Platform Configuration - ExchangeRateManager - Add
	 * @creation date 05/08/2019
	 */
	@Test(dataProvider = "ExchangeRateManager_Add", dataProviderClass = TestDataImport.class, description = "Id: AddExchangeRateManager, Author: shivani.patel")
	public void addExchangeRateManager(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationExchangeRateManagerWeb = homePage.clickOnPlateformConfigurationExchangeRateManager();
			count++;
		}
		platformConfigurationExchangeRateManagerWeb.addExchangeRateManager(map, getMapKeys(map));
		//verifyTrue(platformConfigurationExchangeRateManagerWeb.verifyAddedExchangeRateManager(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - ExchangeRateManager - Edit
	 * @creation date 05/08/2019
	 */
	@Test(dataProvider = "ExchangeRateManager_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditExchangeRateManager, Author: shivani.patel")
	public void editExchangeRateManager(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationExchangeRateManagerWeb = homePage.clickOnPlateformConfigurationExchangeRateManager();
			count++;
		}
		platformConfigurationExchangeRateManagerWeb.editExchangeRateManager(map, getMapKeys(map));
		verifyTrue(platformConfigurationExchangeRateManagerWeb.verifyEditedExchangeRateManager(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - ExchangeRateManager - Delete
	 * @creation date 05/08/2019
	 */
	@Test(dataProvider = "ExchangeRateManager_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteExchangeRateManager, Author: shivani.patel")
	public void deleteExchangeRateManager(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationExchangeRateManagerWeb = homePage.clickOnPlateformConfigurationExchangeRateManager();
			count++;
		}
		platformConfigurationExchangeRateManagerWeb.deleteExchangeRateManager(map, getMapKeys(map));
		//	verifyFalse(platformConfigurationExchangeRateManagerWeb.verifyDeletedExchangeRateManager(map, getMapKeys(map)));
	}
}
