package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.BusinessConfigurationServiceVendorWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class BusinessConfigurationServiceVendor extends Common{

	HomeWeb homePage;
	BusinessConfigurationServiceVendorWeb businessConfigurationServiceVendorWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel 
	 * For Platform Configuration - ServiceVendor - Add
	 * @creation date 24/09/2019
	 */
	@Test(dataProvider = "ServiceVendor_Add", dataProviderClass = TestDataImport.class, description = "Id: AddServiceVendor, Author: shivani.patel")
	public void addServiceVendor(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationServiceVendorWeb = homePage.clickOnBusinessConfigServiceVendor();
			count++;
		}
		businessConfigurationServiceVendorWeb.addServiceVendor(map, getMapKeys(map));
		verifyTrue(businessConfigurationServiceVendorWeb.verifyAddedServiceVendor(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel         
	 * For Platform Configuration - ServiceVendor - Edit
	 * @creation date 24/09/2019
	 */
	@Test(dataProvider = "ServiceVendor_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditServiceVendor, Author: shivani.patel")
	public void editServiceVendor(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationServiceVendorWeb = homePage.clickOnBusinessConfigServiceVendor();
			count++;
		}
		businessConfigurationServiceVendorWeb.editServiceVendor(map, getMapKeys(map));
		verifyTrue(businessConfigurationServiceVendorWeb.verifyEditedServiceVendor(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel
	 * For Platform Configuration - ServiceVendor - Delete
	 * @creation date 24/09/2019
	 */
	@Test(dataProvider = "ServiceVendor_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteServiceVendor, Author: shivani.patel")
	public void deleteServiceVendor(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationServiceVendorWeb = homePage.clickOnBusinessConfigServiceVendor();
			count++;
		}
		if (businessConfigurationServiceVendorWeb.deleteServiceVendor(map, getMapKeys(map)))
			verifyFalse(businessConfigurationServiceVendorWeb.verifyDeletedServiceVendor(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For ServiceProfile
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "ServiceVendor_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortServiceVendor, Author: Dishant Doshi")
	public void sortServiceVendor(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationServiceVendorWeb = homePage.clickOnBusinessConfigServiceVendor();
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
			verifyTrue(businessConfigurationServiceVendorWeb.sortServiceVendor(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
