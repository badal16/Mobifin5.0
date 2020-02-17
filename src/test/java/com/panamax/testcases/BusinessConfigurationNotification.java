package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.BusinessConfigurationNotificationWeb;
import com.panamax.base.HomeWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class BusinessConfigurationNotification extends Common{

	HomeWeb homePage;
	BusinessConfigurationNotificationWeb businessConfigurationNotificationWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel 
	 * For Business Configuration - Notification - Add
	 * @creation date 05/11/2019
	 */
	@Test(dataProvider = "Notification_Add", dataProviderClass = TestDataImport.class, description = "Id: AddNotification, Author: shivani.patel")
	public void addNotification(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationNotificationWeb = homePage.clickOnBusinessConfigNotification();
			count++;
		}
		businessConfigurationNotificationWeb.addNotification(map, getMapKeys(map));
		verifyTrue(businessConfigurationNotificationWeb.verifyAddedNotification(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel         
	 * For Platform Configuration - Notification - Edit
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "Notification_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditNotification, Author: shivani.patel")
	public void editNotification(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationNotificationWeb = homePage.clickOnBusinessConfigNotification();
			count++;
		}
		businessConfigurationNotificationWeb.editNotification(map, getMapKeys(map));
		verifyTrue(businessConfigurationNotificationWeb.verifyEditedNotification(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel
	 * For Platform Configuration - Notification - Delete
	 * @creation date 04/10/2018
	 */
	@Test(dataProvider = "Notification_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteNotification, Author: shivani.patel")
	public void deleteNotification(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationNotificationWeb = homePage.clickOnBusinessConfigNotification();
			count++;
		}
		if (businessConfigurationNotificationWeb.deleteNotification(map, getMapKeys(map)))
			verifyFalse(businessConfigurationNotificationWeb.verifyDeletedNotification(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For notification
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Notification_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortNotification, Author: Dishant Doshi")
	public void sortNotification(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			businessConfigurationNotificationWeb = homePage.clickOnBusinessConfigNotification();
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
			verifyTrue(businessConfigurationNotificationWeb.sortNotification(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
