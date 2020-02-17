package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationRuleWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationRule extends Common{
	HomeWeb homePage;
	PlatformConfigurationRuleWeb platformConfigurationRuleWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - Rule - Add
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Rule_Add", dataProviderClass = TestDataImport.class, description = "Id: AddRule, Author: shivani.patel")
	public void addRule(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationRuleWeb = homePage.clickOnPlateformConfigurationRule();
			count++;
		}
		platformConfigurationRuleWeb.addRule(map, getMapKeys(map));
		verifyTrue(platformConfigurationRuleWeb.verifyAddedRule(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Rule - Edit
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Rule_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditRule, Author: shivani.patel")
	public void editRule(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationRuleWeb = homePage.clickOnPlateformConfigurationRule();
			count++;
		}
		platformConfigurationRuleWeb.editRule(map, getMapKeys(map));
		verifyTrue(platformConfigurationRuleWeb.verifyEditedRule(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Rule - Delete
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Rule_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteRule, Author: shivani.patel")
	public void deleteRule(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationRuleWeb = homePage.clickOnPlateformConfigurationRule();
			count++;
		}
		if (platformConfigurationRuleWeb.deleteRule(map, getMapKeys(map)))
			verifyFalse(platformConfigurationRuleWeb.verifyDeletedRule(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For rule
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Rule_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortRule, Author: Dishant Doshi")
	public void sortRule(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationRuleWeb = homePage.clickOnPlateformConfigurationRule();
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
			verifyTrue(platformConfigurationRuleWeb.sortRule(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
