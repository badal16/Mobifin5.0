package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationCounterWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationCounter extends Common{
	HomeWeb homePage;
	PlatformConfigurationCounterWeb platformConfigurationCounterWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - Counter - Add
	 * @creation date 06/08/2019
	 */
	@Test(dataProvider = "Counter_Add", dataProviderClass = TestDataImport.class, description = "Id: AddCounter, Author: shivani.patel")
	public void addCounter(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationCounterWeb = homePage.clickOnPlateformConfigurationCounter();
			count++;
		}

		platformConfigurationCounterWeb.addCounter(map, getMapKeys(map));
		verifyTrue(platformConfigurationCounterWeb.verifyAddedCounter(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Counter - Edit
	 * @creation date 06/08/2019
	 */
	@Test(dataProvider = "Counter_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditCounter, Author: shivani.patel")
	public void editCounter(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationCounterWeb = homePage.clickOnPlateformConfigurationCounter();
			count++;
		}
		platformConfigurationCounterWeb.editCounter(map, getMapKeys(map));
		verifyTrue(platformConfigurationCounterWeb.verifyEditedCounter(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Counter - Delete
	 * @creation date 06/08/2019
	 */
	@Test(dataProvider = "Counter_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteCounter, Author: shivani.patel")
	public void deleteCounter(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationCounterWeb = homePage.clickOnPlateformConfigurationCounter();
			count++;
		}
		if (platformConfigurationCounterWeb.deleteCounter(map, getMapKeys(map)))
			verifyFalse(platformConfigurationCounterWeb.verifyDeletedCounter(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For counter
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Counter_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortCounter, Author: Dishant Doshi")
	public void sortCounter(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationCounterWeb = homePage.clickOnPlateformConfigurationCounter();
			count++;
		}
		if(sortCounter==0)
		{
			sortCounter++;
			List<String> list = addColumnInGrid();
			if (verifyColumnInGrid(list))
				booleanValue = true;
		}
		if (booleanValue)
			verifyTrue(platformConfigurationCounterWeb.sortCounter(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
