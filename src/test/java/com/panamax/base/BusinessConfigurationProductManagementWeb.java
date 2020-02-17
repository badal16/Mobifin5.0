package com.panamax.base;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class BusinessConfigurationProductManagementWeb extends Common {
	By txtProductManagementName = By.id(readJSFile("INPUT_SERVICEPROFILE_ADD_NAME", FileType.element));
	By drpVendorService = By.xpath("//*[@id='" + readJSFile("INPUT_PRODUCTMGMT_VENDORSERVICE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	String IsYes = "Yes";
	By txtNameInSearch = By.name("vendorName");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_SERVICEPROFILE_ADD_DESCRIPTION", FileType.element));
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 24/09/2019
	 */
	public BusinessConfigurationProductManagementWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInProductManagementName(String name) {
		sendTextInTextBox(txtProductManagementName, name);
	}

	public void selectVendorService(String vendorService) {
		clickOnElement(drpVendorService);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + vendorService + "']"));
	}

	public void sendTextInDescriptionInEdit(String description) {
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(
				"//*[@id='inputServiceprofileAddStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInProductManagementNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void selectField(String field) {
		clickOnElement(drpSelection);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + field.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInProductManagementNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create editProductManagement Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 11/11/2019
	 */
	public void editProductManagement(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			selectVendorService(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(4)).toString().trim().equals("")) {
				String[] fieldlist = map.get(mapKeys.get(4)).toString().trim().split(",");
				for (int j = 0; j < fieldlist.length; j++) {
					clickOnElement(By.xpath("//*[normalize-space(text())='" + fieldlist[j].trim() + "']"));
					clickOnElement(By.xpath("(//button[contains(@class,'icon')])[1]"));
				}
			}
			if (!map.get(mapKeys.get(5)).toString().trim().equals("")) {
				String[] fieldlist = map.get(mapKeys.get(5)).toString().trim().split(",");
				for (int j = 0; j < fieldlist.length; j++) {
					clickOnElement(By.xpath("//*[normalize-space(text())='" + fieldlist[j].trim() + "']"));
					clickOnElement(By.xpath("(//button[contains(@class,'icon')])[last()]"));
				}
			}
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}
}
