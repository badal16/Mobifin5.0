package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationParameterWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationParameter extends Common {

	HomeWeb homePage;
	PlatformConfigurationParameterWeb platformConfigurationParameterWeb;
	int count = 0;
	int sortCounter = 0;

	@Test
	public void skipTest() {
		throw new SkipException("message");
	}

	@Test
	public void failTest() {
		verifyTrue(false);
	}

	/**
	 * @author shivani.patel For Platform Configuration - Parameter - Add
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "Parameter_Add", dataProviderClass = TestDataImport.class, description = "Id: AddParameter, Author: shivani.patel")
	public void addParameter(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationParameterWeb = homePage.clickOnPlateformConfigurationParameter();
			count++;
		}
		platformConfigurationParameterWeb.addParameter(map, getMapKeys(map));
		verifyTrue(platformConfigurationParameterWeb.verifyAddedParameter(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Parameter - Edit
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "Parameter_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditParameter, Author: shivani.patel")
	public void editParameter(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationParameterWeb = homePage.clickOnPlateformConfigurationParameter();
			count++;
		}
		platformConfigurationParameterWeb.editParameter(map, getMapKeys(map));
		verifyTrue(platformConfigurationParameterWeb.verifyEditedParameter(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Parameter - Delete
	 * @creation date 04/10/2018
	 */
	@Test(dataProvider = "Parameter_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteParameter, Author: shivani.patel")
	public void deleteParameter(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationParameterWeb = homePage.clickOnPlateformConfigurationParameter();
			count++;
		}
		if (platformConfigurationParameterWeb.deleteParameter(map, getMapKeys(map)))
			verifyFalse(platformConfigurationParameterWeb.verifyDeletedParameter(map, getMapKeys(map)));
	}

	/**
	 * @author dishant.doshi For Platform Config - Parameter
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Parameter_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortCountry, Author: Dishant Doshi")
	public void sortParameter(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationParameterWeb = homePage.clickOnPlateformConfigurationParameter();
			count++;
		}
		if (sortCounter == 0) {
			sortCounter++;
			clickOnFilterBtn();
			clickOnClearBtn();
			clickOnFilterBtn();
			commonWait();
			commonWait();
			List<String> list = addColumnInGrid();
			if (verifyColumnInGrid(list))
				booleanValue = true;
		}
		if (booleanValue)
			verifyTrue(platformConfigurationParameterWeb.sortParameter(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
