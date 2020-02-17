package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.OperatorConfigRoleWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class OperatorConfigRole extends Common{

	HomeWeb homePage;
	OperatorConfigRoleWeb operatorConfigRoleWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel 
	 * For Platform Configuration - Role - Add
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "Role_Add", dataProviderClass = TestDataImport.class, description = "Id: AddRole, Author: shivani.patel")
	public void addRole(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			operatorConfigRoleWeb = homePage.clickOnOperatorConfigRole();
			count++;
		}
		operatorConfigRoleWeb.addRole(map, getMapKeys(map));
		verifyTrue(operatorConfigRoleWeb.verifyAddedRole(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel         
	 * For Platform Configuration - Role - Edit
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "Role_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditRole, Author: shivani.patel")
	public void editRole(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			operatorConfigRoleWeb = homePage.clickOnOperatorConfigRole();
			count++;
		}
		operatorConfigRoleWeb.editRole(map, getMapKeys(map));
		verifyTrue(operatorConfigRoleWeb.verifyEditedRole(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel
	 * For Platform Configuration - Role - Delete
	 * @creation date 04/10/2018
	 */
	@Test(dataProvider = "Role_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteRole, Author: shivani.patel")
	public void deleteRole(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			operatorConfigRoleWeb = homePage.clickOnOperatorConfigRole();
			count++;
		}
		if (operatorConfigRoleWeb.deleteRole(map, getMapKeys(map)))
			verifyFalse(operatorConfigRoleWeb.verifyDeletedRole(map, getMapKeys(map)));
	}
	/**
	 * @author dishant.doshi For role
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "Role_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortRole, Author: Dishant Doshi")
	public void sortRole(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			operatorConfigRoleWeb = homePage.clickOnOperatorConfigRole();
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
			verifyTrue(operatorConfigRoleWeb.sortRole(map, getMapKeys(map)));
		else
			verifyTrue(booleanValue);
	}
}
