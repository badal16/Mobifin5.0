package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationUserCategoryWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationUserCategory extends Common{
	HomeWeb homePage;
	PlatformConfigurationUserCategoryWeb platformConfigurationUserCategoryWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel 
	 * For Platform Configuration - UserCategory - Add
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "UserCategory_Add", dataProviderClass = TestDataImport.class, description = "Id: AddUserCategory, Author: shivani.patel")
	public void addUserCategory(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUserCategoryWeb = homePage.clickOnPlateformConfigurationUserCategory();
			count++;
		}
		platformConfigurationUserCategoryWeb.addUserCategory(map, getMapKeys(map));
		verifyTrue(platformConfigurationUserCategoryWeb.verifyAddedUserCategory(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel 
	 * For Platform Configuration - UserCategory - Edit
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "UserCategory_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditUserCategory, Author: shivani.patel")
	public void editUserCategory(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUserCategoryWeb = homePage.clickOnPlateformConfigurationUserCategory();
			count++;
		}
		platformConfigurationUserCategoryWeb.editUserCategory(map, getMapKeys(map));
		verifyTrue(platformConfigurationUserCategoryWeb.verifyEditedUserCategory(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel
	 * For Platform Configuration - UserCategory - Delete
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "UserCategory_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteUserCategory, Author: shivani.patel")
	public void deleteUserCategory(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUserCategoryWeb = homePage.clickOnPlateformConfigurationUserCategory();
			count++;
		}
		if (platformConfigurationUserCategoryWeb.deleteUserCategory(map, getMapKeys(map)))
			verifyFalse(platformConfigurationUserCategoryWeb.verifyDeletedUserCategory(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For GISMaster - Country - Sort
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Usercategory_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortCountry, Author: Dishant Doshi")
	public void sortUsercategory(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUserCategoryWeb = homePage.clickOnPlateformConfigurationUserCategory();
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
			verifyTrue(platformConfigurationUserCategoryWeb.sortCountry(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
