package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationWalletWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationWallet extends Common {
	HomeWeb homePage;
	PlatformConfigurationWalletWeb platformConfigurationWalletWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - Wallet - Add
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "Wallet_Add", dataProviderClass = TestDataImport.class, description = "Id: AddWallet, Author: shivani.patel")
	public void addWallet(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationWalletWeb = homePage.clickOnPlateformConfigurationWallet();
			count++;
		}
		platformConfigurationWalletWeb.addWallet(map, getMapKeys(map));
		verifyTrue(platformConfigurationWalletWeb.verifyAddedWallet(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Wallet - Edit
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "Wallet_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditWallet, Author: shivani.patel")
	public void editWallet(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationWalletWeb = homePage.clickOnPlateformConfigurationWallet();
			count++;
		}
		platformConfigurationWalletWeb.editWallet(map, getMapKeys(map));
		verifyTrue(platformConfigurationWalletWeb.verifyEditedWallet(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Wallet - Delete
	 * @creation date 29/07/2019
	 */
	@Test(dataProvider = "Wallet_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteWallet, Author: shivani.patel")
	public void deleteWallet(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationWalletWeb = homePage.clickOnPlateformConfigurationWallet();
			count++;
		}
		if (platformConfigurationWalletWeb.deleteWallet(map, getMapKeys(map)))
			verifyFalse(platformConfigurationWalletWeb.verifyDeletedWallet(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For GISMaster - Country - Sort
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Wallet_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortCountry, Author: Dishant Doshi")
	public void sortWallet(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationWalletWeb = homePage.clickOnPlateformConfigurationWallet();
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
			verifyTrue(platformConfigurationWalletWeb.sortWallet(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
