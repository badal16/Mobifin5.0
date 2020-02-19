package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.BusinessConfigurationOperatingEntityWeb;
import com.panamax.base.HomeWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class BusinessConfigurationOperatingEntity extends Common {

	HomeWeb homePage;
	BusinessConfigurationOperatingEntityWeb businessConfigurationOperatingEntityWeb;
	int count = 0;
	int sortCounter = 0;
	private long startTime;
	long start = Long.MAX_VALUE;
	long startMS;

	/**
	 * @author shivani.patel For Business Configuration - OperatingEntity - Add
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "OperatingEntity_Add", dataProviderClass = TestDataImport.class, description = "Id: AddOperatingEntity, Author: shivani.patel")
	public void addOperatingEntity(Map<Object, Object> map) {
		startTime = System.currentTimeMillis();
		try {
			map.put("Test Start Time", startTime);
			map.put("Class Name", this.getClass().getName());
			map.put("Method Name", "addOperatingEntity");
			homePage = goToHome();
			businessConfigurationOperatingEntityWeb = homePage.clickOnBusinessConfigOperatingEntity();
			businessConfigurationOperatingEntityWeb.addOperatingEntity(map, getMapKeys(map));
			verifyTrue(businessConfigurationOperatingEntityWeb.verifyAddedOperatingEntity(map, getMapKeys(map)));
			map.put("value", 100);
		} catch (Exception e) {
			map.put("value", 0);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	/**
	 * @author shivani.patel For Platform Configuration - OperatingEntity - Edit
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "OperatingEntity_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditOperatingEntity, Author: shivani.patel")
	public void editOperatingEntity(Map<Object, Object> map) {
		startTime = System.currentTimeMillis();
		try {
			map.put("Test Start Time", startTime);
			map.put("Class Name", this.getClass().getName());
			map.put("Method Name", "addSystemOperatorEntity");
			homePage = goToHome();
			businessConfigurationOperatingEntityWeb = homePage.clickOnBusinessConfigOperatingEntity();
			businessConfigurationOperatingEntityWeb.editOperatingEntity(map, getMapKeys(map));
			verifyTrue(businessConfigurationOperatingEntityWeb.verifyEditedOperatingEntity(map, getMapKeys(map)));
			map.put("value", 100);
		} catch (Exception e) {
			map.put("value", 0);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	/**
	 * @author shivani.patel For Platform Configuration - OperatingEntity - Delete
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "OperatingEntity_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteOperatingEntity, Author: shivani.patel")
	public void deleteOperatingEntity(Map<Object, Object> map) {
		startTime = System.currentTimeMillis();
		try {
			map.put("Test Start Time", startTime);
			map.put("Class Name", this.getClass().getName());
			map.put("Method Name", "addSystemOperatorEntity");
			homePage = goToHome();
			businessConfigurationOperatingEntityWeb = homePage.clickOnBusinessConfigOperatingEntity();
			if (businessConfigurationOperatingEntityWeb.deleteOperatingEntity(map, getMapKeys(map)))
				verifyFalse(businessConfigurationOperatingEntityWeb.verifyDeletedOperatingEntity(map, getMapKeys(map)));

			map.put("value", 100);
		} catch (Exception e) {
			map.put("value", 0);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
