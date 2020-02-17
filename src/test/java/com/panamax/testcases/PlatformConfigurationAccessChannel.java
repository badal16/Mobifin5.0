package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationAccessChannelWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationAccessChannel extends Common{
	HomeWeb homePage;
	PlatformConfigurationAccessChannelWeb platformConfigurationAccessChannelWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - AccessChannel - Add
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "AccessChannel_Add", dataProviderClass = TestDataImport.class, description = "Id: AddAccessChannel, Author: shivani.patel")
	public void addAccessChannel(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationAccessChannelWeb = homePage.clickOnPlateformConfigurationAccessChannel();
			count++;
		}
		platformConfigurationAccessChannelWeb.addAccessChannel(map, getMapKeys(map));
		verifyTrue(platformConfigurationAccessChannelWeb.verifyAddedAccessChannel(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - AccessChannel - Edit
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "AccessChannel_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditAccessChannel, Author: shivani.patel")
	public void editAccessChannel(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationAccessChannelWeb = homePage.clickOnPlateformConfigurationAccessChannel();
			count++;
		}
		platformConfigurationAccessChannelWeb.editAccessChannel(map, getMapKeys(map));
		verifyTrue(platformConfigurationAccessChannelWeb.verifyEditedAccessChannel(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - AccessChannel - Delete
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "AccessChannel_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteAccessChannel, Author: shivani.patel")
	public void deleteAccessChannel(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationAccessChannelWeb = homePage.clickOnPlateformConfigurationAccessChannel();
			count++;
		}
		if (platformConfigurationAccessChannelWeb.deleteAccessChannel(map, getMapKeys(map)))
			verifyFalse(platformConfigurationAccessChannelWeb.verifyDeletedAccessChannel(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For accessChannel
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "AccessChannel_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortAccessChannel, Author: Dishant Doshi")
	public void sortAccessChannel(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationAccessChannelWeb = homePage.clickOnPlateformConfigurationAccessChannel();
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
			verifyTrue(platformConfigurationAccessChannelWeb.sortAccessChannel(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
