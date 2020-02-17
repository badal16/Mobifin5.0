package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.BusinessConfigurationRegionalEntityWeb;
import com.panamax.base.HomeWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class BusinessConfigurationRegionalEntity extends Common{

	HomeWeb homePage;
	BusinessConfigurationRegionalEntityWeb businessConfigurationRegionalEntityWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel 
	 * For Business Configuration - RegionalEntity - Add
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "RegionalEntity_Add", dataProviderClass = TestDataImport.class, description = "Id: AddRegionalEntity, Author: shivani.patel")
	public void addRegionalEntity(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationRegionalEntityWeb = homePage.clickOnBusinessConfigRegionalEntity();
			count++;
		}
		businessConfigurationRegionalEntityWeb.addRegionalEntity(map, getMapKeys(map));
		verifyTrue(businessConfigurationRegionalEntityWeb.verifyAddedRegionalEntity(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel         
	 * For Platform Configuration - RegionalEntity - Edit
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "RegionalEntity_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditRegionalEntity, Author: shivani.patel")
	public void editRegionalEntity(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationRegionalEntityWeb = homePage.clickOnBusinessConfigRegionalEntity();
			count++;
		}
		businessConfigurationRegionalEntityWeb.editRegionalEntity(map, getMapKeys(map));
		verifyTrue(businessConfigurationRegionalEntityWeb.verifyEditedRegionalEntity(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel
	 * For Platform Configuration - RegionalEntity - Delete
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "RegionalEntity_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteRegionalEntity, Author: shivani.patel")
	public void deleteRegionalEntity(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationRegionalEntityWeb = homePage.clickOnBusinessConfigRegionalEntity();
			count++;
		}
		if (businessConfigurationRegionalEntityWeb.deleteRegionalEntity(map, getMapKeys(map)))
			verifyFalse(businessConfigurationRegionalEntityWeb.verifyDeletedRegionalEntity(map, getMapKeys(map)));
	}
}
