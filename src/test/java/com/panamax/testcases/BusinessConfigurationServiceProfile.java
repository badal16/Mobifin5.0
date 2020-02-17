package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.BusinessConfigurationServiceProfileWeb;
import com.panamax.base.HomeWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class BusinessConfigurationServiceProfile extends Common{

	HomeWeb homePage;
	BusinessConfigurationServiceProfileWeb businessConfigurationServiceProfileWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel 
	 * For Business Configuration - ServiceProfile - Add
	 * @creation date 05/11/2019
	 */
	@Test(dataProvider = "ServiceProfile_Add", dataProviderClass = TestDataImport.class, description = "Id: AddServiceProfile, Author: shivani.patel")
	public void addServiceProfile(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationServiceProfileWeb = homePage.clickOnBusinessConfigServiceProfile();
			count++;
		}
		businessConfigurationServiceProfileWeb.addServiceProfile(map, getMapKeys(map));
		verifyTrue(businessConfigurationServiceProfileWeb.verifyAddedServiceProfile(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel         
	 * For Platform Configuration - ServiceProfile - Edit
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "ServiceProfile_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditServiceProfile, Author: shivani.patel")
	public void editServiceProfile(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationServiceProfileWeb = homePage.clickOnBusinessConfigServiceProfile();
			count++;
		}
		businessConfigurationServiceProfileWeb.editServiceProfile(map, getMapKeys(map));
		verifyTrue(businessConfigurationServiceProfileWeb.verifyEditedServiceProfile(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel
	 * For Platform Configuration - ServiceProfile - Delete
	 * @creation date 04/10/2018
	 */
	@Test(dataProvider = "ServiceProfile_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteServiceProfile, Author: shivani.patel")
	public void deleteServiceProfile(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationServiceProfileWeb = homePage.clickOnBusinessConfigServiceProfile();
			count++;
		}
		if (businessConfigurationServiceProfileWeb.deleteServiceProfile(map, getMapKeys(map)))
			verifyFalse(businessConfigurationServiceProfileWeb.verifyDeletedServiceProfile(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For ServiceProfile
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "ServiceProfile_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortServiceProfile, Author: Dishant Doshi")
	public void sortServiceProfile(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationServiceProfileWeb = homePage.clickOnBusinessConfigServiceProfile();
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
			verifyTrue(businessConfigurationServiceProfileWeb.sortServiceProfile(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
