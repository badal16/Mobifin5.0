package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.BusinessConfigurationOperatingEntityTemplateWeb;
import com.panamax.base.HomeWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class BusinessConfigurationOperatingEntityTemplate extends Common{

	HomeWeb homePage;
	BusinessConfigurationOperatingEntityTemplateWeb businessConfigurationOperatingEntityTemplateWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel 
	 * For Business Configuration - OperatingEntityTemplate - Add
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "OperatingEntityTemplate_Add", dataProviderClass = TestDataImport.class, description = "Id: AddOperatingEntityTemplate, Author: shivani.patel")
	public void addOperatingEntityTemplate(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationOperatingEntityTemplateWeb = homePage.clickOnBusinessConfigOperatingEntityTemplate();
			count++;
		}
		businessConfigurationOperatingEntityTemplateWeb.addOperatingEntityTemplate(map, getMapKeys(map));
		verifyTrue(businessConfigurationOperatingEntityTemplateWeb.verifyAddedOperatingEntityTemplate(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel         
	 * For Platform Configuration - OperatingEntityTemplate - Edit
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "OperatingEntityTemplate_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditOperatingEntityTemplate, Author: shivani.patel")
	public void editOperatingEntityTemplate(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationOperatingEntityTemplateWeb = homePage.clickOnBusinessConfigOperatingEntityTemplate();
			count++;
		}
		businessConfigurationOperatingEntityTemplateWeb.editOperatingEntityTemplate(map, getMapKeys(map));
		verifyTrue(businessConfigurationOperatingEntityTemplateWeb.verifyEditedOperatingEntityTemplate(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel
	 * For Platform Configuration - OperatingEntityTemplate - Delete
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "OperatingEntityTemplate_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteOperatingEntityTemplate, Author: shivani.patel")
	public void deleteOperatingEntityTemplate(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationOperatingEntityTemplateWeb = homePage.clickOnBusinessConfigOperatingEntityTemplate();
			count++;
		}
		if (businessConfigurationOperatingEntityTemplateWeb.deleteOperatingEntityTemplate(map, getMapKeys(map)))
			verifyFalse(businessConfigurationOperatingEntityTemplateWeb.verifyDeletedOperatingEntityTemplate(map, getMapKeys(map)));
	}
}
