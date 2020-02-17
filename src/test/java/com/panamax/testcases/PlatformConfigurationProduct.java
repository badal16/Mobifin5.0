package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.PlatformConfigurationProductWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class PlatformConfigurationProduct extends Common{
	HomeWeb homePage;
	PlatformConfigurationProductWeb platformConfigurationProductWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - Product - Add
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Product_Add", dataProviderClass = TestDataImport.class, description = "Id: AddProduct, Author: shivani.patel")
	public void addProduct(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationProductWeb = homePage.clickOnPlateformConfigurationProduct();
			count++;
		}
		platformConfigurationProductWeb.addProduct(map, getMapKeys(map));
		verifyTrue(platformConfigurationProductWeb.verifyAddedProduct(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Product - Edit
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Product_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditProduct, Author: shivani.patel")
	public void editProduct(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationProductWeb = homePage.clickOnPlateformConfigurationProduct();
			count++;
		}
		platformConfigurationProductWeb.editProduct(map, getMapKeys(map));
		verifyTrue(platformConfigurationProductWeb.verifyEditedProduct(map, getMapKeys(map)));
	}

	/**
	 * @author shivani.patel For Platform Configuration - Product - Delete
	 * @creation date 30/07/2019
	 */
	@Test(dataProvider = "Product_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteProduct, Author: shivani.patel")
	public void deleteProduct(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationProductWeb = homePage.clickOnPlateformConfigurationProduct();
			count++;
		}
		if (platformConfigurationProductWeb.deleteProduct(map, getMapKeys(map)))
			verifyFalse(platformConfigurationProductWeb.verifyDeletedProduct(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For rule
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Product_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortProduct, Author: Dishant Doshi")
	public void sortProduct(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			platformConfigurationProductWeb = homePage.clickOnPlateformConfigurationProduct();
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
			verifyTrue(platformConfigurationProductWeb.sortProduct(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
