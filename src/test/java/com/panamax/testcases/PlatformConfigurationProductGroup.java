package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationProductGroupWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationProductGroup extends Common{
	HomeWeb homePage;
	PlatformConfigurationProductGroupWeb platformConfigurationProductGroupWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - ProductGroup - Add
	 * @creation date 05/08/2019
	 */
	@Test(dataProvider = "ProductGroup_Add", dataProviderClass = TestDataImport.class, description = "Id: AddProductGroup, Author: shivani.patel")
	public void addProductGroup(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationProductGroupWeb = homePage.clickOnPlateformConfigurationProductGroup();
			count++;
		}
		platformConfigurationProductGroupWeb.addProductGroup(map, getMapKeys(map));
		verifyTrue(platformConfigurationProductGroupWeb.verifyAddedProductGroup(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - ProductGroup - Edit
	 * @creation date 05/08/2019
	 */
	@Test(dataProvider = "ProductGroup_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditProductGroup, Author: shivani.patel")
	public void editProductGroup(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationProductGroupWeb = homePage.clickOnPlateformConfigurationProductGroup();
			count++;
		}
		platformConfigurationProductGroupWeb.editProductGroup(map, getMapKeys(map));
		verifyTrue(platformConfigurationProductGroupWeb.verifyEditedProductGroup(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - ProductGroup - Delete
	 * @creation date 05/08/2019
	 */
	@Test(dataProvider = "ProductGroup_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteProductGroup, Author: shivani.patel")
	public void deleteProductGroup(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationProductGroupWeb = homePage.clickOnPlateformConfigurationProductGroup();
			count++;
		}
		if (platformConfigurationProductGroupWeb.deleteProductGroup(map, getMapKeys(map)))
			verifyFalse(platformConfigurationProductGroupWeb.verifyDeletedProductGroup(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For productgroup
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "ProductGroup_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortProductGroup, Author: Dishant Doshi")
	public void sortProductGroup(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationProductGroupWeb = homePage.clickOnPlateformConfigurationProductGroup();
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
			verifyTrue(platformConfigurationProductGroupWeb.sortProductGroup(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
