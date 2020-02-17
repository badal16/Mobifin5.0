package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationServiceWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationService extends Common {
	HomeWeb homePage;
	PlatformConfigurationServiceWeb platformConfigurationServiceWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - Service - Add
	 * @creation date 31/07/2019
	 */
	@Test(dataProvider = "Service_Add", dataProviderClass = TestDataImport.class, description = "Id: AddService, Author: shivani.patel")
	public void addService(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationServiceWeb = homePage.clickOnPlateformConfigurationService();
			count++;
		}
		platformConfigurationServiceWeb.addService(map, getMapKeys(map));
		verifyTrue(platformConfigurationServiceWeb.verifyAddedService(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Service - Edit
	 * @creation date 31/07/2019
	 */
	@Test(dataProvider = "Service_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditService, Author: shivani.patel")
	public void editService(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationServiceWeb = homePage.clickOnPlateformConfigurationService();
			count++;
		}
		platformConfigurationServiceWeb.editService(map, getMapKeys(map));
		verifyTrue(platformConfigurationServiceWeb.verifyEditedService(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Service - Delete
	 * @creation date 31/07/2019
	 */
	@Test(dataProvider = "Service_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteService, Author: shivani.patel")
	public void deleteService(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationServiceWeb = homePage.clickOnPlateformConfigurationService();
			count++;
		}
		if (platformConfigurationServiceWeb.deleteService(map, getMapKeys(map)))
			verifyFalse(platformConfigurationServiceWeb.verifyDeletedService(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For service
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Service_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortService, Author: Dishant Doshi")
	public void sortService(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationServiceWeb = homePage.clickOnPlateformConfigurationService();
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
			verifyTrue(platformConfigurationServiceWeb.sortService(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
