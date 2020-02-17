package com.panamax.base;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;
import com.panamax.init.ConstantsFile;

public class BusinessConfigurationRegionalEntityWeb extends Common {
	By txtRegionalEntityName = By.id("form_in_modal_inputBusinessentityAddName");
	By txtDescription = By.id("form_in_modal_inputBusinessentityDescription");
	String IsYes = "Yes";
	By txtNameInSearch = By.id("search");
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");
	By btnOk = By.xpath("//*[normalize-space(text()) = '" + ConstantsFile.REGIONALENTITY_OK + "']//parent::button");
	By btnSave = By.xpath("//*[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_SAVE + "']//parent::button");
	By drpAccessChannel = By
			.xpath("(//*[contains(@id,'form_in_modal_accesschannalFields')]//*[@class='ant-select-arrow'])[last()]");
	By btnAddKYCLevel = By.xpath("//*[normalize-space(text())='Add Field']//parent::button");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 24/09/2019
	 */
	public BusinessConfigurationRegionalEntityWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInRegionalEntityName(String name) {
		sendTextInTextBox(txtRegionalEntityName, name);
	}

	public void sendTextInDescription(String description) {
		clearAndSendTextInTextBox(txtDescription, description);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath("//*[@id='form_in_modal_inputBusinessentityAddStatus']//span[normalize-space(text())='"
				+ status.trim() + "']"));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath("//*[@id='form_in_modal_inputBusinessentityEditStatus']//span[normalize-space(text())='"
				+ status.trim() + "']"));
	}

	public void sendTextInRegionalEntityNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectField(String field) {
		clickOnElement(drpSelection);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + field.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1) {
		clickOnElement(By.xpath("//*[contains(@class,'anticon-reload')]//parent::button"));
		sendTextInRegionalEntityNameFilterSearch(str1);
		clickOnElement(By.xpath("//*[contains(@class,'anticon-search')]//parent::button"));
	}

	public void clickOnRegionalEntityAddIcon(String parentBusinessZone) {
		commonWait();
		filterSearch(parentBusinessZone);
		clickOnElement(By.xpath("//*[normalize-space(text())='" + parentBusinessZone
				+ "']//ancestor::div[contains(@class,'business-zone')]//div[contains(@class,'action-button')]//button[2]"));
	}

	public void selectRegionalEntity() {
		clickOnElement(By.xpath("(//*[normalize-space(text())='Select']//parent::button)[last()]"));
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + ConstantsFile.ADDREGIONALENTITY + "'])[last()]"));
	}

	public void clickOnViewDetail() {
		clickOnElement(By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]"));
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_VIEW + "'])[last()]"));
	}

	public void clickOnEditDetail() {
		clickOnElement(By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]"));
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_EDIT + "'])[last()]"));
	}

	public void clickOnRegionalEntityDelete(String regionalEntity) {
		commonWait();
		clickOnElement(By.xpath("//*[normalize-space(text())='" + regionalEntity
				+ "']//ancestor::div[contains(@class,'regional-business')]//div[contains(@class,'action-button')]//button[3]"));
		clickOnDeleteConfirm();
	}

	public void clickOnAddField() {
		clickOnElement(btnAddKYCLevel);
	}

	public void selectAccessChannel(String accessChannel) {
		clickOnElement(drpAccessChannel);
		sendTextInTextBox(
				By.xpath("(//*[contains(@id,'accesschannalFields') and @class='ant-select-search__field'])[last()]"),
				accessChannel + Keys.ENTER);
	}

	public void sendTextInAllowedAPI(String allowedAPI) {
		// clickOnElement(drpAllowedAPI);
		sendTextInTextBox(
				By.xpath(
						"(//*[contains(@id,'form_in_modal_allowedapi')]//*[@class='ant-select-search__field'])[last()]"),
				allowedAPI + Keys.ENTER);
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'2faAllowed')])[last()]"));
		}
	}

	/**
	 * @author shivani.patel Create addRegionalEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void addRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		commonWait();
		commonWait();
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (!verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnElement(By.xpath("//*[contains(@class,'anticon-reload')]//parent::button"));
			clickOnRegionalEntityAddIcon(map.get(mapKeys.get(2)).toString());
			selectRegionalEntity();
			sendTextInRegionalEntityName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(3)).toString());
			int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
			String[] accessChannelList = map.get(mapKeys.get(5)).toString().split(";");
			for (int m = 0; m < rows; m++) {
				selectAccessChannel(accessChannelList[m].trim());
				String[] allowedAPIList = map.get(mapKeys.get(6)).toString().split(";");
				String[] twofactor = map.get(mapKeys.get(7)).toString().split(";");
				String[] levelfield = allowedAPIList[m].split(",");
				for (int j = 0; j < levelfield.length; j++) {
					sendTextInAllowedAPI(levelfield[j].trim());
					clickOnElement(By.xpath("//*[normalize-space(text())='Access Channel']"));
				}
				selectIsMandatory(twofactor[m].trim());
				if (m < rows - 1) {
					clickOnAddField();
				}
			}
			selectStatus(map.get(mapKeys.get(8)).toString());
			clickOnElement(btnSave);
		}
	}

	public boolean verifyAddedRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("businessentity.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("businessentity.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(8)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnViewDetail();
			commonWait();
			commonWait();
			commonWait();
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
			String[] accessChannelList = map.get(mapKeys.get(5)).toString().split(";");
			for (int m = 0; m < rows; m++) {
				if (!verifyElement(By.xpath("//table//tbody//tr[" + (m + 1) + "]//td[normalize-space(text())='"
						+ accessChannelList[m] + "']"), false))
					return false;
				String[] allowedAPIList = map.get(mapKeys.get(6)).toString().split(";");
				String[] twofactor = map.get(mapKeys.get(7)).toString().split(";");
				String[] levelfield = allowedAPIList[m].split(",");
				for (int j = 0; j < levelfield.length; j++) {
					if (!verifyElement(By
							.xpath("//table//tbody//tr[" + (m + 1) + "]//td[contains(text(),'" + levelfield[j] + "')]"),
							false))
						return false;
				}
				if (twofactor[m].equalsIgnoreCase(IsYes)) {
					if (!verifyElement(
							By.xpath("//table//tbody//tr[" + (m + 1) + "]//td//i[contains(@class,'text-success')]"),
							false))
						return false;
				} else {
					if (!verifyElement(
							By.xpath("//table//tbody//tr[" + (m + 1) + "]//td[normalize-space(text())='false']"),
							false))
						return false;
				}
			}
			clickOnElement(btnOk);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create addRegionalEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void editRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnEditDetail();
			commonWait();
			commonWait();
			sendTextInDescription(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(4)).toString().trim().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
				String[] accessChannelList = map.get(mapKeys.get(5)).toString().split(";");
				for (int m = 0; m < rows; m++) {
					selectAccessChannel(accessChannelList[m].trim());
					String[] allowedAPIList = map.get(mapKeys.get(6)).toString().split(";");
					String[] twofactor = map.get(mapKeys.get(7)).toString().split(";");
					String[] levelfield = allowedAPIList[m].split(",");
					for (int j = 0; j < levelfield.length; j++) {
						sendTextInAllowedAPI(levelfield[j].trim());
						clickOnElement(By.xpath("//*[normalize-space(text())='Access Channel']"));
					}
					selectIsMandatory(twofactor[m].trim());
					if (m < rows - 1) {
						clickOnAddField();
					}
				}
			}
			selectStatusInEdit(map.get(mapKeys.get(9)).toString());
			clickOnElement(btnSave);
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("businessentity.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("businessentity.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(9)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnViewDetail();
			commonWait();
			commonWait();
			commonWait();
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			if (!map.get(mapKeys.get(4)).toString().trim().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
				String[] accessChannelList = map.get(mapKeys.get(5)).toString().split(";");
				for (int m = 0; m < rows; m++) {
					if (!verifyElement(By.xpath("//table//tbody//tr[" + (m + 1) + "]//td[normalize-space(text())='"
							+ accessChannelList[m] + "']"), false))
						return false;
					String[] allowedAPIList = map.get(mapKeys.get(6)).toString().split(";");
					String[] twofactor = map.get(mapKeys.get(7)).toString().split(";");
					String[] levelfield = allowedAPIList[m].split(",");
					for (int j = 0; j < levelfield.length; j++) {
						if (!verifyElement(By.xpath(
								"//table//tbody//tr[" + (m + 1) + "]//td[contains(text(),'" + levelfield[j] + "')]"),
								false))
							return false;
					}
					if (twofactor[m].equalsIgnoreCase(IsYes)) {
						if (!verifyElement(
								By.xpath("//table//tbody//tr[" + (m + 1) + "]//td//i[contains(@class,'text-success')]"),
								false))
							return false;
					} else {
						if (!verifyElement(
								By.xpath("//table//tbody//tr[" + (m + 1) + "]//td[normalize-space(text())='false']"),
								false))
							return false;
					}
				}
			}
			clickOnElement(btnOk);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create DeleteRegionalEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean deleteRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnRegionalEntityDelete(map.get(mapKeys.get(1)).toString());
			return true;
		} else {
			String string = "RegionalEntity already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedRegionalEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean verifyDeletedRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		return verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false);

	}
}
