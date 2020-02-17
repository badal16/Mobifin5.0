package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.OperationAddMoneyWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class OperationAddMoney extends Common{

	HomeWeb homePage;
	OperationAddMoneyWeb operationAddMoneyWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel 
	 * For Platform Configuration - AddMoney - Add
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "AddMoney_Add", dataProviderClass = TestDataImport.class, description = "Id: AddAddMoney, Author: shivani.patel")
	public void addAddMoney(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			operationAddMoneyWeb = homePage.clickOnOperationAddMoney();
			count++;
		}
		operationAddMoneyWeb.addAddMoney(map, getMapKeys(map));
	}
}
