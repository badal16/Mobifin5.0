package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class PlatformConfigurationAccessChannelWeb extends Common {
	By txtName = By.id(readJSFile("INPUT_ACCESSCHANNEL_ADD_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_ACCESSCHANNEL_ADD_DESCRIPTION", FileType.element));
	By txtSecret = By.id("inputAccesschannelSecret");
	By txtConfirmSecret = By.id("inputAccesschannelConfirmSecret");
	By txtAccessToken = By.id("inputAccesschannelAccessTokenValidity");
	By drpAccessChannelType = By.xpath(
			"//*[@id='" + readJSFile("INPUT_WALLET_WALLETTYPE", FileType.element) + "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_ACCESSCHANNEL_EDIT_DESCRIPTION", FileType.element));
	By drpAccessChannelTypeInSearch = By.xpath(
			"//*[normalize-space(text())='AccessChannel Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 31/07/2019
	 */
	public PlatformConfigurationAccessChannelWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtName, name);
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void sendTextInSecret(String secret) {
		sendTextInTextBox(txtSecret, secret);
	}

	public void sendTextInConfirmSecret(String confirmSecret) {
		sendTextInTextBox(txtConfirmSecret, confirmSecret);
	}

	public void sendTextInAccessTokenValidity(String accessTokenValidity) {
		clearAndSendTextInTextBox(txtAccessToken, accessTokenValidity);
	}

	public void selectStatus(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputAccesschannelStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectGrantType(By element) {
		clickOnElement(element);
	}

	public void sendTextInNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addAccessChannel Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public void addAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(6)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			sendTextInSecret(map.get(mapKeys.get(3)).toString());
			sendTextInConfirmSecret(map.get(mapKeys.get(3)).toString());
			sendTextInAccessTokenValidity(map.get(mapKeys.get(4)).toString());
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				String[] grantTypelist = map.get(mapKeys.get(5)).toString().trim().split(",");
				for (int i = 0; i < grantTypelist.length; i++) {
					selectGrantType(By.xpath("//*[normalize-space(text())='" + grantTypelist[i].trim()
							+ "']//following-sibling::td//span[@class='ant-checkbox']"));
				}
			}
			selectStatus(map.get(mapKeys.get(6)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("accesschannel.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("accesschannel.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");

		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("accesschannel.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(6)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(6)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			String[] grantTypelist = map.get(mapKeys.get(5)).toString().trim().split(",");
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				for (int i = 0; i < grantTypelist.length; i++) {
					if (!verifyElement(By.xpath("//*[normalize-space(text())='" + grantTypelist[i].trim()
							+ "']//following-sibling::td//i[contains(@class,'success')]"), false))
						return false;
				}
			}
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create editAccessChannel Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public void editAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				sendTextInAccessTokenValidity(map.get(mapKeys.get(3)).toString());
			}
			if (!map.get(mapKeys.get(4)).toString().equals("")) {
				String[] grantTypelist = map.get(mapKeys.get(4)).toString().trim().split(",");
				for (int i = 0; i < grantTypelist.length; i++) {
					selectGrantType(By.xpath("//*[normalize-space(text())='" + grantTypelist[i].trim()
							+ "']//following-sibling::td//span[@class='ant-checkbox']"));
				}
			}
			selectStatus(map.get(mapKeys.get(6)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("accesschannel.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");

		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("accesschannel.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(6)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(6)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(description, false))
				return false;
			if (!map.get(mapKeys.get(4)).toString().equals("")) {
				String[] grantTypelist = map.get(mapKeys.get(4)).toString().trim().split(",");
				for (int i = 0; i < grantTypelist.length; i++) {
					if (!verifyElement(By.xpath("//*[normalize-space(text())='" + grantTypelist[i].trim()
							+ "']//following-sibling::td//i[contains(@class,'success')]"), false))
						return false;
				}
			}
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create deleteAccessChannel Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean deleteAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "AccessChannel already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deleteAccessChannel Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean verifyDeletedAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}

	public boolean sortAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		Map<String, List<String>> getBeforeSortTableData = getTableData(map.get(getMapKeys(map).get(2)).toString());
		clickOnSortBtn(map.get(getMapKeys(map).get(0)).toString(), map.get(getMapKeys(map).get(1)).toString());
		List<String> sortedUIColumnData = getColumnData(map.get(getMapKeys(map).get(0)).toString());
		List<String> sortedUIColumnDataCopy = new ArrayList<>(sortedUIColumnData);
		sortColumn(sortedUIColumnData, map.get(getMapKeys(map).get(1)).toString());
		if (!compareTwoLists(sortedUIColumnData, sortedUIColumnDataCopy))
			return false;
		Map<String, List<String>> getAfterSortTableData = getTableData(map.get(getMapKeys(map).get(2)).toString());
		if (!getBeforeSortTableData.equals(getAfterSortTableData))
			return false;
		return true;
	}
}
