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

	/**
	 * @author shivani.patel For Business Configuration - OperatingEntity - Add
	 * @creation date 22/11/2019
	 */
	@Test(dataProvider = "OperatingEntity_Add", dataProviderClass = TestDataImport.class, description = "Id: AddOperatingEntity, Author: shivani.patel")
	public void addOperatingEntity(Map<Object, Object> map) {
		try {
			map.put("Method Name", "addSystemOperatorEntity");
			if (count == 0) {
				homePage = goToHome();
				businessConfigurationOperatingEntityWeb = homePage.clickOnBusinessConfigOperatingEntity();
				count++;
			}
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
		try {
			map.put("Method Name", "addSystemOperatorEntity");
			if (count == 0) {
				homePage = goToHome();
				businessConfigurationOperatingEntityWeb = homePage.clickOnBusinessConfigOperatingEntity();
				count++;
			}
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
		try {
			map.put("Method Name", "addSystemOperatorEntity");
			if (count == 0) {
				homePage = goToHome();
				businessConfigurationOperatingEntityWeb = homePage.clickOnBusinessConfigOperatingEntity();
				count++;
			}
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
