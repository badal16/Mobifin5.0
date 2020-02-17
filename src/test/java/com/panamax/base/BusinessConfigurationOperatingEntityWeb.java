package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;
import com.panamax.init.ConstantsFile;

public class BusinessConfigurationOperatingEntityWeb extends Common {
	By txtOperatingEntityTemplate = By
			.xpath("(//*[@id='inputOnBoadingBusinessEntityName']//*[@class='ant-select-arrow'])[last()]");
	By txtDescription = By.id("form_in_modal_inputOperatingentityAddDescription");
	By txtDescriptionInEdit = By.id("form_in_modal_inputOperatingentityEditDescription");
	String IsYes = "Yes";
	By txtNameInSearch = By.id("search");
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");
	By btnOk = By.xpath("//*[normalize-space(text()) = '" + ConstantsFile.REGIONALENTITY_OK + "']//parent::button");
	By btnSave = By.xpath("//*[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_SAVE + "']//parent::button");
	By drpAccessChannel = By
			.xpath("(//*[contains(@id,'form_in_modal_accesschannalFields')]//*[@class='ant-select-arrow'])[last()]");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 24/09/2019
	 */
	public BusinessConfigurationOperatingEntityWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void selectOperatingEntityTemplate(String operatingEntityTemplate) {
		clickOnElement(txtOperatingEntityTemplate);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + operatingEntityTemplate.trim() + "']"));
	}

	public void sendTextInDescription(String description) {
		clearAndSendTextInTextBox(txtDescription, description);
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath("//*[@id='form_in_modal_inputOperatingentityAddStatus']//span[normalize-space(text())='"
				+ status.trim() + "']"));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(
				By.xpath("//*[@id='form_in_modal_inputOperatingentityEditStatus']//span[normalize-space(text())='"
						+ status.trim() + "']"));
	}

	public void sendTextInOperatingEntityNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectField(String field) {
		clickOnElement(drpSelection);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + field.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1) {
		clickOnElement(By.xpath("//*[contains(@class,'anticon-reload')]//parent::button"));
		sendTextInOperatingEntityNameFilterSearch(str1);
		clickOnElement(By.xpath("//*[contains(@class,'anticon-search')]//parent::button"));
	}

	public void clickOnOperatingEntityAddIcon(String parentRegionalEntity) {
		clickOnElement(By.xpath("//*[normalize-space(text())='" + parentRegionalEntity
				+ "']//ancestor::div[contains(@class,'regional-business')]//div[contains(@class,'action-button')]//button[2]"));
	}

	public void selectOperatingEntityOnboarding() {
		clickOnElement(By.xpath("(//*[normalize-space(text())='Select']//parent::button)[last()]"));
		clickOnElement(By.xpath(
				"(//li[normalize-space(text())='" + ConstantsFile.ADD_OPERATINGENTITY_ONBOARDING + "'])[last()]"));
	}

	public void clickOnViewDetail() {
		clickOnElement(By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]"));
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_VIEW + "'])[last()]"));
	}

	public void clickOnEditDetail() {
		clickOnElement(By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]"));
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_EDIT + "'])[last()]"));
	}

	public void clickOnOperatingEntityDelete(String regionalEntity) {
		commonWait();
		clickOnElement(By.xpath("//*[normalize-space(text())='" + regionalEntity.trim()
				+ "']//ancestor::div[contains(@class,'template')]//div[contains(@class,'action-button')]//button[2]"));
		clickOnDeleteConfirm();
	}

	public void clickOnRadioFeild(By element) {
		clickOnElement(element);
	}

	public void selectMultipleField(By element, String value) {
		// clickOnElement(element);
		sendTextInTextBox(element, value + Keys.ENTER);
		clickOnElement(By.xpath("//*[@class='ant-steps ant-steps-horizontal ant-steps-label-horizontal']"));
	}

	public void sendTextInStringField(String value, By element) {
		clickOnElement(element);
		sendTextInTextBox(element, value);
		// sendTextWithRemoveReadOnlyProperty(value, element);
	}

	public void selectDateOfBirth(String value, By element) {
		clickOnElement(element);
		clearAndSendTextInTextBox(By.xpath("//*[@class='ant-calendar-input ']"), value);
		clickOnElement(By.xpath("//*[@class='ant-calendar-ok-btn']"));
	}

	public void clickOnDropdown(By element, String value) {
		clickOnElement(element);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + value + "']"));
	}

	/**
	 * @author shivani.patel Create addOperatingEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void addOperatingEntity(Map<Object, Object> map, List<Object> mapKeys) {
		commonWait();
		filterSearch(map.get(mapKeys.get(1)).toString());
		clickOnOperatingEntityAddIcon(map.get(mapKeys.get(2)).toString());
		selectOperatingEntityOnboarding();
		selectOperatingEntityTemplate(map.get(mapKeys.get(1)).toString());
		commonWait();
		String[] navigateList = map.get(mapKeys.get(4)).toString().trim().split("/");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < navigateList.length; i++) {
			// String or text
			if (!(map.get(mapKeys.get(6)).toString()).trim().isEmpty()) {
				String[] CategoryField = map.get(mapKeys.get(6)).toString().split("/");
				for (int j = 0; j < CategoryField.length; j++) {
					String[] CategoryFieldlist = CategoryField[j].split(":");
					if (verifyElement(
							By.xpath("//div[@class='current-content clearfix']//label[normalize-space(text())='"
									+ CategoryFieldlist[0].trim() + "']"))
							&& !list.contains(CategoryFieldlist[0].trim())) {
						sendTextInStringField(CategoryFieldlist[1],
								By.xpath("//*[normalize-space(text())='" + CategoryFieldlist[0].trim()
										+ "']//parent::div//parent::div//span//input[@type='text']"));
						list.add(CategoryFieldlist[0].trim());
					}
				}
			}
			// Password
			if (!(map.get(mapKeys.get(7)).toString()).trim().isEmpty()) {
				String[] CategoryField = map.get(mapKeys.get(7)).toString().split("/");
				for (int j = 0; j < CategoryField.length; j++) {
					String[] CategoryFieldlist = CategoryField[j].split(":");
					if (verifyElement(
							By.xpath("//div[@class='current-content clearfix']//label[normalize-space(text())='"
									+ CategoryFieldlist[0].trim() + "']"))
							&& !list.contains(CategoryFieldlist[0].trim())) {
						sendTextInStringField(CategoryFieldlist[1],
								By.xpath("//*[normalize-space(text())='" + CategoryFieldlist[0].trim()
										+ "']//parent::div//parent::div//span//input[@type='password']"));
						list.add(CategoryFieldlist[0].trim());
					}
				}
			}
			// DropDown
			if (!(map.get(mapKeys.get(8)).toString()).trim().isEmpty()) {
				String[] CategoryField = map.get(mapKeys.get(8)).toString().split("/");
				for (int j = 0; j < CategoryField.length; j++) {
					String[] CategoryFieldlist = CategoryField[j].split(":");
					if (verifyElement(
							By.xpath("//div[@class='current-content clearfix']//label[normalize-space(text())='"
									+ CategoryFieldlist[0].trim() + "']"))
							&& !list.contains(CategoryFieldlist[0].trim())) {
						clickOnDropdown(
								By.xpath("//div[@class='current-content clearfix']//label[normalize-space(text())='"
										+ CategoryFieldlist[0].trim() + "']//..//..//span[contains(@class,'select')]"),
								CategoryFieldlist[1].trim());
						list.add(CategoryFieldlist[0].trim());
					}
				}
			}

			// Radio
			if (!(map.get(mapKeys.get(9)).toString()).trim().isEmpty()) {
				String[] CategoryField = map.get(mapKeys.get(9)).toString().split("/");
				String[] CategoryFieldlist = CategoryField[i].split(";");
				for (int j = 0; j < CategoryFieldlist.length; j++) {
					String[] CategoryFeieldSub = CategoryFieldlist[j].split(":");
					clickOnRadioFeild(
							By.xpath("//div[@class='current-content clearfix']//label[normalize-space(text())='"
									+ CategoryFeieldSub[0].trim()
									+ "']//..//..//div[contains(@class,'radio')]//*[normalize-space(text())='"
									+ CategoryFeieldSub[1].trim() + "']"));
				}
			}

			// DateOfBirth
			if (!(map.get(mapKeys.get(12)).toString()).trim().isEmpty()) {
				String[] CategoryField = map.get(mapKeys.get(12)).toString().split("/");

				for (int j = 0; j < CategoryField.length; j++) {
					String[] CategoryFieldlist = CategoryField[j].split(":");
					if (verifyElement(
							By.xpath("//div[@class='current-content clearfix']//label[normalize-space(text())='"
									+ CategoryFieldlist[0].trim() + "']"))
							&& !list.contains(CategoryFieldlist[0].trim())) {
						selectDateOfBirth(CategoryFieldlist[1], By.xpath("//*[normalize-space(text())='"
								+ CategoryFieldlist[0].trim()
								+ "']//parent::div//parent::div//span//input[contains(@class,'calendar-picker')]"));
						list.add(CategoryFieldlist[0].trim());
					}
				}
			}

			// Multiple
			if (!map.get(mapKeys.get(14)).toString().equals("")) {
				String[] CategoryField = map.get(mapKeys.get(14)).toString().split("/");
				String[] CategoryFeieldSub = CategoryField[i].split(":");
				for (int k = 0; k < CategoryFeieldSub.length; k++) {
					String[] subCategoryField = CategoryFeieldSub[k].split(",");
					for (int j = 0; j < subCategoryField.length; j++) {
						selectMultipleField(
								By.xpath("//div[@class='current-content clearfix']//label[normalize-space(text())='"
										+ CategoryFeieldSub[0].trim()
										+ "']//..//..//*[contains(@class,'multiple')]//div[contains(@class,'rendered')]//input"),
								subCategoryField[j].trim());
					}
				}
			}
			if (verifyElement(By.xpath("(//*[text()='Next ']//parent::button)[last()]"))) {
				clickOnElement(By.xpath("(//*[text()='Next ']//parent::button)[last()]"));
			}
		}
		clickOnSubmitBtn();
		commonWait();
		if (verifyElement(By.xpath("//*[text()='error.userexists']"))) {
			clickOnElement(By.xpath("//*[contains(@class,'close-icon')]"));
		}
	}

	public boolean verifyAddedOperatingEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create addOperatingEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void editOperatingEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnEditDetail();
			commonWait();
			commonWait();
			commonWait();
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				sendTextInDescriptionInEdit(map.get(mapKeys.get(3)).toString());
			}

			clickOnElement(btnSave);
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedOperatingEntity(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By
				.xpath("//*[normalize-space(text()) = 'Description']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By userCatefory = By
				.xpath("//*[normalize-space(text()) = 'User Category']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		By role = By
				.xpath("//*[normalize-space(text()) = 'Role']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(5)).toString() + "']");
		By currency = By
				.xpath("//*[normalize-space(text()) = 'Currency']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(8)).toString() + "']");
		By reportingCurrency = By
				.xpath("//*[normalize-space(text()) = 'Reporting Currency']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(9)).toString() + "']");
		By kyc = By
				.xpath("//*[normalize-space(text()) = 'KYC']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(6)).toString() + "']");
		By kycLevel = By
				.xpath("//*[normalize-space(text()) = 'KYC Level']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");
		By timezone = By
				.xpath("//*[normalize-space(text()) = 'Timezone']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(11)).toString() + "']");
		By walletTemplate = By
				.xpath("//*[normalize-space(text()) = 'Wallet Template']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(12)).toString() + "']");
		By status = By
				.xpath("//*[normalize-space(text()) = 'Status']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(14)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnViewDetail();
			commonWait();
			commonWait();
			commonWait();
			if (!map.get(mapKeys.get(3)).toString().trim().equals("")) {
				if (!verifyElement(description, false))
					return false;
			}
			if (!map.get(mapKeys.get(4)).toString().trim().equals("")) {
				if (!verifyElement(userCatefory, false))
					return false;
			}
			if (!map.get(mapKeys.get(5)).toString().trim().equals("")) {
				if (!verifyElement(role, false))
					return false;
			}
			if (!map.get(mapKeys.get(8)).toString().trim().equals("")) {
				if (!verifyElement(currency, false))
					return false;
			}
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				if (!verifyElement(reportingCurrency, false))
					return false;
			}
			if (!map.get(mapKeys.get(6)).toString().trim().equals("")) {
				if (!verifyElement(kyc, false))
					return false;
			}
			if (!map.get(mapKeys.get(7)).toString().trim().equals("")) {
				if (!verifyElement(kycLevel, false))
					return false;
			}
			if (!map.get(mapKeys.get(11)).toString().trim().equals("")) {
				if (!verifyElement(timezone, false))
					return false;
			}
			if (!map.get(mapKeys.get(12)).toString().trim().equals("")) {
				if (!verifyElement(walletTemplate, false))
					return false;
			}
			if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
				if (!verifyElement(status, false))
					return false;
			}
			if (!map.get(mapKeys.get(28)).toString().trim().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(28)).toString());
				String[] accessChannelList = map.get(mapKeys.get(29)).toString().split(";");
				for (int m = 0; m < rows; m++) {
					if (!verifyElement(By.xpath("//table//tbody//tr[" + (m + 1) + "]//td[normalize-space(text())='"
							+ accessChannelList[m] + "']"), false))
						return false;
					String[] allowedAPIList = map.get(mapKeys.get(30)).toString().split(";");
					String[] twofactor = map.get(mapKeys.get(31)).toString().split(";");
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
	 * @author shivani.patel Create DeleteOperatingEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean deleteOperatingEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnOperatingEntityDelete(map.get(mapKeys.get(1)).toString());
			return true;
		} else {
			String string = "OperatingEntity already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedOperatingEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean verifyDeletedOperatingEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		return verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false);

	}
}
