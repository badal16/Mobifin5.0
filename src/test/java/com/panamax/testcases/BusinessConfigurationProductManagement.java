package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.BusinessConfigurationProductManagementWeb;
import com.panamax.base.HomeWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class BusinessConfigurationProductManagement extends Common {

	HomeWeb homePage;
	BusinessConfigurationProductManagementWeb businessConfigurationProductManagementWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Business Configuration - ProductManagement - Edit
	 * @creation date 05/11/2019
	 */
	@Test(dataProvider = "ProductManagement_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditProductManagement, Author: shivani.patel")
	public void editProductManagement(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationProductManagementWeb = homePage.clickOnBusinessConfigProductManagement();
			count++;
		}
		businessConfigurationProductManagementWeb.editProductManagement(map, getMapKeys(map));
		//verifyTrue(businessConfigurationProductManagementWeb.verifyAddedProductManagement(map, getMapKeys(map)));
	}
}
