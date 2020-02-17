package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationNotificationTemplateWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationNotificationTemplate extends Common{
	HomeWeb homePage;
	PlatformConfigurationNotificationTemplateWeb platformConfigurationNotificationTemplateWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - NotificationTemplate - Add
	 * @creation date 02/08/2019
	 */
	@Test(dataProvider = "NotificationTemplate_Add", dataProviderClass = TestDataImport.class, description = "Id: AddNotificationTemplate, Author: shivani.patel")
	public void addNotificationTemplate(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationNotificationTemplateWeb = homePage.clickOnPlateformConfigurationNotificationTemplate();
			count++;
		}
		platformConfigurationNotificationTemplateWeb.addNotificationTemplate(map, getMapKeys(map));
		verifyTrue(platformConfigurationNotificationTemplateWeb.verifyAddedNotificationTemplate(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - NotificationTemplate - Edit
	 * @creation date 02/08/2019
	 */
	@Test(dataProvider = "NotificationTemplate_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditNotificationTemplate, Author: shivani.patel")
	public void editNotificationTemplate(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationNotificationTemplateWeb = homePage.clickOnPlateformConfigurationNotificationTemplate();
			count++;
		}
		platformConfigurationNotificationTemplateWeb.editNotificationTemplate(map, getMapKeys(map));
		verifyTrue(platformConfigurationNotificationTemplateWeb.verifyEditedNotificationTemplate(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - NotificationTemplate - Delete
	 * @creation date 02/08/2019
	 */
	@Test(dataProvider = "NotificationTemplate_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteNotificationTemplate, Author: shivani.patel")
	public void deleteNotificationTemplate(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationNotificationTemplateWeb = homePage.clickOnPlateformConfigurationNotificationTemplate();
			count++;
		}
		if (platformConfigurationNotificationTemplateWeb.deleteNotificationTemplate(map, getMapKeys(map)))
			verifyFalse(platformConfigurationNotificationTemplateWeb.verifyDeletedNotificationTemplate(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For rule
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "NotificationTemplate_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortNotificationTemplate, Author: Dishant Doshi")
	public void sortNotificationTemplate(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationNotificationTemplateWeb = homePage.clickOnPlateformConfigurationNotificationTemplate();
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
			verifyTrue(platformConfigurationNotificationTemplateWeb.sortNotificationTemplate(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
