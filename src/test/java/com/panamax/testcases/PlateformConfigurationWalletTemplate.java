package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlateformConfigurationWalletTemplateWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlateformConfigurationWalletTemplate extends Common{
	HomeWeb homePage;
	PlateformConfigurationWalletTemplateWeb plateformConfigurationWalletTemplateWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - WalletTemplate - Add
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "WalletTemplate_Add", dataProviderClass = TestDataImport.class, description = "Id: AddWalletTemplate, Author: shivani.patel")
	public void addWalletTemplate(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			plateformConfigurationWalletTemplateWeb = homePage.clickOnPlateformConfigurationWalletTemplate();
			count++;
		}
		plateformConfigurationWalletTemplateWeb.addWalletTemplate(map, getMapKeys(map));
		verifyTrue(plateformConfigurationWalletTemplateWeb.verifyAddedWalletTemplate(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - WalletTemplate - Edit
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "WalletTemplate_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditWalletTemplate, Author: shivani.patel")
	public void editWalletTemplate(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			plateformConfigurationWalletTemplateWeb = homePage.clickOnPlateformConfigurationWalletTemplate();
			count++;
		}
		plateformConfigurationWalletTemplateWeb.editWalletTemplate(map, getMapKeys(map));
		verifyTrue(plateformConfigurationWalletTemplateWeb.verifyEditedWalletTemplate(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - WalletTemplate - Delete
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "WalletTemplate_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteWalletTemplate, Author: shivani.patel")
	public void deleteWalletTemplate(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			plateformConfigurationWalletTemplateWeb = homePage.clickOnPlateformConfigurationWalletTemplate();
			count++;
		}
		if (plateformConfigurationWalletTemplateWeb.deleteWalletTemplate(map, getMapKeys(map)))
			verifyFalse(plateformConfigurationWalletTemplateWeb.verifyDeletedWalletTemplate(map, getMapKeys(map)));
	}

	

}
