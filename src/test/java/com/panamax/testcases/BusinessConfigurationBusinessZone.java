package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.BusinessConfigurationBusinessZoneWeb;
import com.panamax.base.HomeWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class BusinessConfigurationBusinessZone extends Common{

	HomeWeb homePage;
	BusinessConfigurationBusinessZoneWeb businessConfigurationBusinessZoneWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel 
	 * For Business Configuration - BusinessZone - Add
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "BusinessZone_Add", dataProviderClass = TestDataImport.class, description = "Id: AddBusinessZone, Author: shivani.patel")
	public void addBusinessZone(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationBusinessZoneWeb = homePage.clickOnBusinessConfigBusinessZone();
			count++;
		}
		businessConfigurationBusinessZoneWeb.addBusinessZone(map, getMapKeys(map));
		verifyTrue(businessConfigurationBusinessZoneWeb.verifyAddedBusinessZone(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel         
	 * For Platform Configuration - BusinessZone - Edit
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "BusinessZone_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditBusinessZone, Author: shivani.patel")
	public void editBusinessZone(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationBusinessZoneWeb = homePage.clickOnBusinessConfigBusinessZone();
			count++;
		}
		businessConfigurationBusinessZoneWeb.editBusinessZone(map, getMapKeys(map));
		verifyTrue(businessConfigurationBusinessZoneWeb.verifyEditedBusinessZone(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel
	 * For Platform Configuration - BusinessZone - Delete
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "BusinessZone_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteBusinessZone, Author: shivani.patel")
	public void deleteBusinessZone(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationBusinessZoneWeb = homePage.clickOnBusinessConfigBusinessZone();
			count++;
		}
		if (businessConfigurationBusinessZoneWeb.deleteBusinessZone(map, getMapKeys(map)))
			verifyFalse(businessConfigurationBusinessZoneWeb.verifyDeletedBusinessZone(map, getMapKeys(map)));
	}
}
