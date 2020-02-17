package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationKYCWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationKYC extends Common{

	HomeWeb homePage;
	PlatformConfigurationKYCWeb platformConfigurationKYCKYCWeb;
	int count = 0;
	int sortCounter = 0;
	/**
	 * @author shivani.patel 
	 * For Platform Configuration - KYC - Add
	 * @creation date 09/08/2019
	 */
	@Test(dataProvider = "KYC_Add", dataProviderClass = TestDataImport.class, description = "Id: AddKYC, Author: shivani.patel")
	public void addKYC(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationKYCKYCWeb = homePage.clickOnPlateformConfigurationKYC();
			count++;
		}
		platformConfigurationKYCKYCWeb.addKYC(map, getMapKeys(map));
		verifyTrue(platformConfigurationKYCKYCWeb.verifyAddedKYC(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel 
	 * For Platform Configuration - KYC - Edit
	 * @creation date 09/08/2019
	 */
	@Test(dataProvider = "KYC_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditKYC, Author: shivani.patel")
	public void editKYC(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationKYCKYCWeb = homePage.clickOnPlateformConfigurationKYC();
			count++;
		}
		platformConfigurationKYCKYCWeb.editKYC(map, getMapKeys(map));
		verifyTrue(platformConfigurationKYCKYCWeb.verifyEditedKYC(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel
	 * For Platform Configuration - KYC - Delete
	 * @creation date 04/10/2018
	 */
	@Test(dataProvider = "KYC_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteKYC, Author: shivani.patel")
	public void deleteKYC(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationKYCKYCWeb = homePage.clickOnPlateformConfigurationKYC();
			count++;
		}
		if (platformConfigurationKYCKYCWeb.deleteKYC(map, getMapKeys(map)))
			verifyFalse(platformConfigurationKYCKYCWeb.verifyDeletedKYC(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For Platform Config - KYC
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "KYC_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortCountry, Author: Dishant Doshi")
	public void sortKYC(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationKYCKYCWeb = homePage.clickOnPlateformConfigurationKYC();
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
			verifyTrue(platformConfigurationKYCKYCWeb.sortKYC(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
