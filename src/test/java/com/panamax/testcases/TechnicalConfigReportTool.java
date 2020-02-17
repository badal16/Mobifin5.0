package com.panamax.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.panamax.base.HomeWeb;
import com.panamax.base.TechnicalConfigReportToolWeb;
import com.panamax.init.Common;
import com.panamax.init.TestDataImport;

public class TechnicalConfigReportTool extends Common{

	HomeWeb homePage;
	TechnicalConfigReportToolWeb technicalConfignReportToolWeb;
	int count = 0;
	int sortCounter = 0;

	/**
	 * @author shivani.patel 
	 * For Platform Configuration - ReportTool - Add
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "ReportTool_Add", dataProviderClass = TestDataImport.class, description = "Id: AddReportTool, Author: shivani.patel")
	public void addReportTool(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			technicalConfignReportToolWeb = homePage.clickOnTechnicalConfigReportTool();
			count++;
		}
		technicalConfignReportToolWeb.addReportTool(map, getMapKeys(map));
		verifyTrue(technicalConfignReportToolWeb.verifyAddedReportTool(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel         
	 * For Platform Configuration - ReportTool - Edit
	 * @creation date 17/07/2019
	 */
	@Test(dataProvider = "ReportTool_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditReportTool, Author: shivani.patel")
	public void editReportTool(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			technicalConfignReportToolWeb = homePage.clickOnTechnicalConfigReportTool();
			count++;
		}
		technicalConfignReportToolWeb.editReportTool(map, getMapKeys(map));
		verifyTrue(technicalConfignReportToolWeb.verifyEditedReportTool(map, getMapKeys(map)));
	}
	/**
	 * @author shivani.patel
	 * For Platform Configuration - ReportTool - Delete
	 * @creation date 04/10/2018
	 */
	@Test(dataProvider = "ReportTool_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteReportTool, Author: shivani.patel")
	public void deleteReportTool(Map<Object, Object> map) {
		if (count == 0) {
			homePage = goToHome();
			technicalConfignReportToolWeb = homePage.clickOnTechnicalConfigReportTool();
			count++;
		}
		if (technicalConfignReportToolWeb.deleteReportTool(map, getMapKeys(map)))
			verifyFalse(technicalConfignReportToolWeb.verifyDeletedReportTool(map, getMapKeys(map)));
	}
}
