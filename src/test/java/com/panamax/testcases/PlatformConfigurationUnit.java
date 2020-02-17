package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationUnitWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationUnit extends Common{

	
	HomeWeb homePage;
	PlatformConfigurationUnitWeb platformConfigurationUnitWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - Unit - Add
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Unit_Add", dataProviderClass = TestDataImport.class, description = "Id: AddUnit, Author: shivani.patel")
	public void addUnit(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUnitWeb = homePage.clickOnPlateformConfigurationUnit();
			count++;
		}
		platformConfigurationUnitWeb.addUnit(map, getMapKeys(map));
		verifyTrue(platformConfigurationUnitWeb.verifyAddedUnit(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Unit - Edit
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Unit_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditUnit, Author: shivani.patel")
	public void editUnit(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUnitWeb = homePage.clickOnPlateformConfigurationUnit();
			count++;
		}
		platformConfigurationUnitWeb.editUnit(map, getMapKeys(map));
		verifyTrue(platformConfigurationUnitWeb.verifyEditedUnit(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Unit - Delete
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Unit_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteUnit, Author: shivani.patel")
	public void deleteUnit(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUnitWeb = homePage.clickOnPlateformConfigurationUnit();
			count++;
		}
		if (platformConfigurationUnitWeb.deleteUnit(map, getMapKeys(map)))
			verifyFalse(platformConfigurationUnitWeb.verifyDeletedUnit(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For Unit
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Unit_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortUnit, Author: Dishant Doshi")
	public void sortUnit(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationUnitWeb = homePage.clickOnPlateformConfigurationUnit();
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
			verifyTrue(platformConfigurationUnitWeb.sortUnit(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
