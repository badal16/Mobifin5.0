package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.BusinessConfigurationTechnicalVendorWeb;
import com.panamax.base.HomeWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class BusinessConfigurationTechnicalVendor extends Common{

	HomeWeb homePage;
	BusinessConfigurationTechnicalVendorWeb businessConfigurationTechnicalVendorWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel 
	 * For Platform Configuration - TechnicalVendor - Add
	 * @creation date 24/09/2019
	 */
	@Test(dataProvider = "TechnicalVendor_Add", dataProviderClass = TestDataImport.class, description = "Id: AddTechnicalVendor, Author: shivani.patel")
	public void addTechnicalVendor(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationTechnicalVendorWeb = homePage.clickOnBusinessConfigTechnicalVendor();
			count++;
		}
		businessConfigurationTechnicalVendorWeb.addTechnicalVendor(map, getMapKeys(map));
		verifyTrue(businessConfigurationTechnicalVendorWeb.verifyAddedTechnicalVendor(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel         
	 * For Platform Configuration - TechnicalVendor - Edit
	 * @creation date 24/09/2019
	 */
	@Test(dataProvider = "TechnicalVendor_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditTechnicalVendor, Author: shivani.patel")
	public void editTechnicalVendor(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationTechnicalVendorWeb = homePage.clickOnBusinessConfigTechnicalVendor();
			count++;
		}
		businessConfigurationTechnicalVendorWeb.editTechnicalVendor(map, getMapKeys(map));
		verifyTrue(businessConfigurationTechnicalVendorWeb.verifyEditedTechnicalVendor(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel
	 * For Platform Configuration - TechnicalVendor - Delete
	 * @creation date 24/09/2019
	 */
	@Test(dataProvider = "TechnicalVendor_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteTechnicalVendor, Author: shivani.patel")
	public void deleteTechnicalVendor(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationTechnicalVendorWeb = homePage.clickOnBusinessConfigTechnicalVendor();
			count++;
		}
		if (businessConfigurationTechnicalVendorWeb.deleteTechnicalVendor(map, getMapKeys(map)))
			verifyFalse(businessConfigurationTechnicalVendorWeb.verifyDeletedTechnicalVendor(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For ServiceProfile
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "TechnicalVendor_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortTechnicalVendor, Author: Dishant Doshi")
	public void sortTechnicalVendor(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationTechnicalVendorWeb = homePage.clickOnBusinessConfigTechnicalVendor();
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
			verifyTrue(businessConfigurationTechnicalVendorWeb.sortTechnicalVendor(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
