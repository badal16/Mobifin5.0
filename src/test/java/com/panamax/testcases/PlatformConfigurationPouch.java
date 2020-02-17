package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationPouchWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationPouch extends Common{
	HomeWeb homePage;
	PlatformConfigurationPouchWeb platformConfigurationPouchWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - Pouch - Add
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Pouch_Add", dataProviderClass = TestDataImport.class, description = "Id: AddPouch, Author: shivani.patel")
	public void addPouch(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationPouchWeb = homePage.clickOnPlateformConfigurationPouch();
			count++;
		}
		platformConfigurationPouchWeb.addPouch(map, getMapKeys(map));
		verifyTrue(platformConfigurationPouchWeb.verifyAddedPouch(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Pouch - Edit
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Pouch_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditPouch, Author: shivani.patel")
	public void editPouch(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationPouchWeb = homePage.clickOnPlateformConfigurationPouch();
			count++;
		}
		platformConfigurationPouchWeb.editPouch(map, getMapKeys(map));
		verifyTrue(platformConfigurationPouchWeb.verifyEditedPouch(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Pouch - Delete
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Pouch_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeletePouch, Author: shivani.patel")
	public void deletePouch(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationPouchWeb = homePage.clickOnPlateformConfigurationPouch();
			count++;
		}
		if (platformConfigurationPouchWeb.deletePouch(map, getMapKeys(map)))
			verifyFalse(platformConfigurationPouchWeb.verifyDeletedPouch(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For pouch
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Pouch_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortPouch, Author: Dishant Doshi")
	public void sortPouch(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationPouchWeb = homePage.clickOnPlateformConfigurationPouch();
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
			verifyTrue(platformConfigurationPouchWeb.sortPouch(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
