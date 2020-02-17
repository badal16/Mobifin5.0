package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationUcpWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationUcp extends Common {
	HomeWeb homePage;
	PlatformConfigurationUcpWeb platformConfigurationUcpWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - Ucp - Add
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "Ucp_Add", dataProviderClass = TestDataImport.class, description = "Id: AddUcp, Author: shivani.patel")
	public void addUcp(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUcpWeb = homePage.clickOnPlateformConfigurationUcp();
			count++;
		}
		platformConfigurationUcpWeb.addUcp(map, getMapKeys(map));
		verifyTrue(platformConfigurationUcpWeb.verifyAddedUcp(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Ucp - Edit
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "Ucp_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditUcp, Author: shivani.patel")
	public void editUcp(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUcpWeb = homePage.clickOnPlateformConfigurationUcp();
			count++;
		}
		platformConfigurationUcpWeb.editUcp(map, getMapKeys(map));
		verifyTrue(platformConfigurationUcpWeb.verifyEditedUcp(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Ucp - Delete
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "Ucp_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteUcp, Author: shivani.patel")
	public void deleteUcp(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUcpWeb = homePage.clickOnPlateformConfigurationUcp();
			count++;
		}
		if (platformConfigurationUcpWeb.deleteUcp(map, getMapKeys(map)))
			verifyFalse(platformConfigurationUcpWeb.verifyDeletedUcp(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For ucp
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Ucp_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortUCP, Author: Dishant Doshi")
	public void sortUcp(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUcpWeb = homePage.clickOnPlateformConfigurationUcp();
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
			verifyTrue(platformConfigurationUcpWeb.sortUcp(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
