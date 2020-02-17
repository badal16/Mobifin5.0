package com.panamax.base;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class PlateformConfigurationWalletTemplateWeb extends Common {
	By txtName = By.id("inputWalletTemplateName");
	By txtDescription = By.id("inputWalletTemplateDescription");
	By txtSecret = By.id("inputAccesschannelSecret");
	By txtConfirmSecret = By.id("inputAccesschannelConfirmSecret");
	By txtAccessToken = By.id("inputAccesschannelAccessTokenValidity");
	By drpWalletTemplateType = By.xpath(
			"//*[@id='" + readJSFile("INPUT_WALLET_WALLETTYPE", FileType.element) + "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_ACCESSCHANNEL_EDIT_DESCRIPTION", FileType.element));
	By drpWalletTemplateTypeInSearch = By.xpath(
			"//*[normalize-space(text())='WalletTemplate Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpWallet = By.xpath("(//*[contains(@id,'walletFields')]//*[@class='ant-select-arrow'])[last()]");
	By btnAddField = By.xpath("//*[normalize-space(text())='Add Field']//parent::button");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 31/07/2019
	 */
	public PlateformConfigurationWalletTemplateWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtName, name);
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void selectStatus(String status) {
		clickOnElement(By
				.xpath("//*[@id='inputWalletTemplateStatus']//span[normalize-space(text())='" + status.trim() + "']"));
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

	public void selectWallet(String wallet) {
		clickOnElement(drpWallet);
		sendTextInTextBox(By.xpath("(//*[contains(@id,'walletFields')]//*[@class='ant-select-search__field'])[last()]"),
				wallet + Keys.ENTER);
	}

	public void selectPouch(String pouch) {
		// clickOnElement(drpWallet);
		sendTextInTextBox(By.xpath("(//*[contains(@id,'pouchFields')]//*[@class='ant-select-search__field'])[last()]"),
				pouch + Keys.ENTER);
		// clickOnElement(By.xpath("(//*[normalize-space(text())='Wallet'])[1]"));
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
	 * @author shivani.patel Create addWalletTemplate Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public void addWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
			String[] wallet = map.get(mapKeys.get(5)).toString().split("/");
			String[] pouchList = map.get(mapKeys.get(6)).toString().split("/");
			for (int j = 0; j < rows; j++) {
				selectWallet(wallet[j].trim());
				String[] pouch = pouchList[j].split(",");
				for (int i = 0; i < pouch.length; i++) {
					selectPouch(pouch[i].trim());
				}
				if (j < rows - 1) {
					clickOnElement(btnAddField);
				}
			}
			selectStatus(map.get(mapKeys.get(3)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By
				.xpath("//*[normalize-space(text()) = 'Name']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = 'Description']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");

		By status = By.xpath("//*[normalize-space(text()) = 'Status']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(3)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			if (!map.get(mapKeys.get(4)).toString().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
				String[] walletList = map.get(mapKeys.get(4)).toString().trim().split("/");
				String[] pouchList = map.get(mapKeys.get(4)).toString().trim().split("/");
				for (int i = 0; i < rows; i++) {
					if (!verifyElement(By.xpath("//tr["+(i+1)+"]//*[normalize-space(text())='"+walletList[i].trim()+"']"), false))
						return false;
					String[] pouch = pouchList[i].split(",");
					for (int j = 0; j < pouch.length; j++) {
						if (!verifyElement(By.xpath("//tr[1]//*[contains(text(),'"+pouch[j].trim()+"')]"), false))
							return false;
					}
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
	 * @author shivani.patel Create editWalletTemplate Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public void editWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
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

	public boolean verifyEditedWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
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
	 * @author shivani.patel Create deleteWalletTemplate Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean deleteWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "WalletTemplate already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deleteWalletTemplate Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean verifyDeletedWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}
}
