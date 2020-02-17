package com.panamax.testcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.OperatorConfigSystemOperatorEntityWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class OperatorConfigSystemOperatorEntity extends Common {

	HomeWeb homePage;
	OperatorConfigSystemOperatorEntityWeb operatorConfigSystemOperatorEntityWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel For Platform Configuration - SystemOperatorEntity - Add
	 * @creation date 24/09/2019
	 */
	@Test(dataProvider = "SystemOperatorEntity_Add", dataProviderClass = TestDataImport.class, description = "Id: AddSystemOperatorEntity, Author: shivani.patel")
	public void addSystemOperatorEntity(Map<Object, Object> map) {

		try {
			map.put("Method Name", "addSystemOperatorEntity");
			if (count == 0) {
				homePage = goToHome();
				operatorConfigSystemOperatorEntityWeb = homePage.clickOnOperatorConfigSystemOperatorEntity();
				count++;
			}
			operatorConfigSystemOperatorEntityWeb.addSystemOperatorEntity(map, getMapKeys(map));
			verifyTrue(operatorConfigSystemOperatorEntityWeb.verifyAddedSystemOperatorEntity(map, getMapKeys(map)));
			map.put("value", 100);
		} catch (Exception e) {
			map.put("value", 0);
			logException(e, map);
		} finally {
			logData(map);
		}

	}

	/**
	 * @author shivani.patel For Platform Configuration - SystemOperatorEntity -
	 *         Edit
	 * @creation date 24/09/2019
	 */
	@Test(dataProvider = "SystemOperatorEntity_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditSystemOperatorEntity, Author: shivani.patel")
	public void editSystemOperatorEntity(Map<Object, Object> map) {
		try {
			map.put("Method Name", "addSystemOperatorEntity");
			if (count == 0) {
				homePage = goToHome();
				operatorConfigSystemOperatorEntityWeb = homePage.clickOnOperatorConfigSystemOperatorEntity();
				count++;
			}
			operatorConfigSystemOperatorEntityWeb.editSystemOperatorEntity(map, getMapKeys(map));
			verifyTrue(operatorConfigSystemOperatorEntityWeb.verifyEditedSystemOperatorEntity(map, getMapKeys(map)));
			map.put("value", 100);
		} catch (Exception e) {
			map.put("value", 0);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	/**
	 * @author shivani.patel For Platform Configuration - SystemOperatorEntity -
	 *         Delete
	 * @creation date 24/09/2019
	 */
	@Test(dataProvider = "SystemOperatorEntity_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteSystemOperatorEntity, Author: shivani.patel")
	public void deleteSystemOperatorEntity(Map<Object, Object> map) {
		try {
			map.put("Method Name", "addSystemOperatorEntity");
			if (count == 0) {
				homePage = goToHome();
				operatorConfigSystemOperatorEntityWeb = homePage.clickOnOperatorConfigSystemOperatorEntity();
				count++;
			}
			if (operatorConfigSystemOperatorEntityWeb.deleteSystemOperatorEntity(map, getMapKeys(map)))
				verifyFalse(
						operatorConfigSystemOperatorEntityWeb.verifyDeletedSystemOperatorEntity(map, getMapKeys(map)));
			map.put("value", 100);
		} catch (Exception e) {
			map.put("value", 0);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	/**
	 * @author dishant.doshi For role
	 * @creation date 26/12/2018
	 */
	@Test(dataProvider = "SystemOperatorEntity_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortSystemOperatorEntity, Author: Dishant Doshi")
	public void sortSystemOperatorEntity(Map<Object, Object> map) {
		try {
			map.put("Method Name", "addSystemOperatorEntity");
			if (count == 0) {
				homePage = goToHome();
				operatorConfigSystemOperatorEntityWeb = homePage.clickOnOperatorConfigSystemOperatorEntity();
				count++;
			}
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = addColumnInGrid();
				if (verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue)
				verifyTrue(operatorConfigSystemOperatorEntityWeb.sortSystemOperatorEntity(map, getMapKeys(map)));
			else
				verifyTrue(booleanValue);

			map.put("value", 100);
		} catch (Exception e) {
			map.put("value", 0);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
