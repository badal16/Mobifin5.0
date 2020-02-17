package com.panamax.base;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;
import com.panamax.init.ConstantsFile;
import com.panamax.init.Common.FileType;

public class BusinessConfigurationOperatingEntityTemplateWeb extends Common {
	By txtOperatingEntityTemplateName = By.id("form_in_modal_inputOperatingentityAddName");
	By txtDescription = By.id("form_in_modal_inputOperatingentityAddDescription");
	By txtDescriptionInEdit = By.id("form_in_modal_inputOperatingentityEditDescription");
	String IsYes = "Yes";
	By txtNameInSearch = By.id("search");
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");
	By btnOk = By.xpath("//*[normalize-space(text()) = '" + ConstantsFile.REGIONALENTITY_OK + "']//parent::button");
	By btnSave = By.xpath("//*[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_SAVE + "']//parent::button");
	By drpAccessChannel = By
			.xpath("(//*[contains(@id,'form_in_modal_accesschannalFields')]//*[@class='ant-select-arrow'])[last()]");
	By btnAddKYCLevel = By.xpath("//*[normalize-space(text())='Add Field']//parent::button");
	By drpUserCategory = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddUsercategory')]//*[@class='ant-select-arrow'])[last()]");
	By drpUserCategoryInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditUsercategory')]//*[@class='ant-select-arrow'])[last()]");
	By drprole = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddRole')]//parent::div[contains(@class,'rendered')])[last()]");
	By drproleInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditRole')]//parent::div[contains(@class,'rendered')])[last()]");
	By drpKyc = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddKyc')]//*[@class='ant-select-arrow'])[last()]");
	By drpKycInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditKyc')]//*[@class='ant-select-arrow'])[last()]");
	By drpKycLevel = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityKycAddLevel')]//*[@class='ant-select-arrow'])[last()]");
	By drpKycLevelInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditKycLevel')]//*[@class='ant-select-arrow'])[last()]");
	By drpWalletTemplate = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityWalletTemplate')]//*[@class='ant-select-arrow'])[last()]");
	By drpServiceProfile = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityServiceProfile')]//*[@class='ant-select-arrow'])[last()]");
	By drpCurrency = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddCurrency')]//*[@class='ant-select-arrow'])[last()]");
	By drpCurrencyInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditCurrency')]//*[@class='ant-select-arrow'])[last()]");
	By drpReportingCurrency = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddReportingCurrency')]//*[@class='ant-select-arrow'])[last()]");
	By drpReportingCurrencyInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditReportingCurrency')]//*[@class='ant-select-arrow'])[last()]");
	By drpTimeZone = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddTimezone')]//*[@class='ant-select-arrow'])[last()]");
	By drpTimeZoneInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditTimeZone')]//*[@class='ant-select-arrow'])[last()]");
	By drpAllowBusinessZone = By
			.xpath("(//*[contains(@id,'form_in_modal_inputOperatingentityAddAllowedBusinessZone')])[last()]");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 24/09/2019
	 */
	public BusinessConfigurationOperatingEntityTemplateWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInOperatingEntityTemplateName(String name) {
		sendTextInTextBox(txtOperatingEntityTemplateName, name);
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

	public void sendTextInOperatingEntityTemplateNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectField(String field) {
		clickOnElement(drpSelection);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + field.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1) {
		clickOnElement(By.xpath("//*[contains(@class,'anticon-reload')]//parent::button"));
		sendTextInOperatingEntityTemplateNameFilterSearch(str1);
		clickOnElement(By.xpath("//*[contains(@class,'anticon-search')]//parent::button"));
	}

	public void clickOnOperatingEntityTemplateAddIcon(String parentRegionalEntity) {
		commonWait();
		filterSearch(parentRegionalEntity);
		clickOnElement(By.xpath("//*[normalize-space(text())='" + parentRegionalEntity
				+ "']//ancestor::div[contains(@class,'regional-business')]//div[contains(@class,'action-button')]//button[1]"));
	}

	public void selectOperatingEntityTemplate() {
		clickOnElement(By.xpath("(//*[normalize-space(text())='Select']//parent::button)[last()]"));
		clickOnElement(
				By.xpath("(//li[normalize-space(text())='" + ConstantsFile.ADDOPERATINGENTITYTEMPLATE + "'])[last()]"));
	}

	public void clickOnViewDetail() {
		clickOnElement(By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]"));
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_VIEW + "'])[last()]"));
	}

	public void clickOnEditDetail() {
		clickOnElement(By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]"));
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_EDIT + "'])[last()]"));
	}

	public void clickOnOperatingEntityTemplateDelete(String regionalEntity) {
		commonWait();
		clickOnElement(By.xpath("//*[normalize-space(text())='" + regionalEntity.trim()
				+ "']//ancestor::div[contains(@class,'template')]//div[contains(@class,'action-button')]//button[2]"));
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

	public void selectUserCategory(String userCategory) {
		clickOnElement(drpUserCategory);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + userCategory + "']"));
	}

	public void selectUserCategoryInEdit(String userCategory) {
		clickOnElement(drpUserCategoryInEdit);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + userCategory + "']"));
	}

	public void selectRole(String role) {
		clickOnElement(drprole);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + role + "']"));
	}

	public void selectRoleInEdit(String role) {
		clickOnElement(drproleInEdit);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + role + "']"));
	}

	public void selectKYC(String Kyc) {
		clickOnElement(drpKyc);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + Kyc + "']"));
	}

	public void selectKYCINEdit(String Kyc) {
		clickOnElement(drpKycInEdit);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + Kyc + "']"));
	}

	public void selectKYCLevel(String KycLevel) {
		clickOnElement(drpKycLevel);
		clickOnElement(By.xpath("(//li[text()='" + KycLevel + "'])[last()]"));
	}

	public void selectKYCLevelInEdit(String KycLevel) {
		clickOnElement(drpKycLevelInEdit);
		clickOnElement(By.xpath("(//li[text()='" + KycLevel + "'])[last()]"));
	}

	public void selectCurrency(String currency) {
		clickOnElement(drpCurrency);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + currency + "']"));
	}

	public void selectCurrencyInEdit(String currency) {
		clickOnElement(drpCurrencyInEdit);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + currency + "']"));
	}

	public void selectReportingCurrency(String reportingCurrency) {
		clickOnElement(drpReportingCurrency);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + reportingCurrency + "'])[last()]"));
	}

	public void selectReportingCurrencyInEdit(String reportingCurrency) {
		clickOnElement(drpReportingCurrencyInEdit);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + reportingCurrency + "'])[last()]"));
	}

	public void selectTimeZone(String timeZone) {
		clickOnElement(drpTimeZone);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + timeZone + "']"));
	}

	public void selectTimeZoneInEdit(String timeZone) {
		clickOnElement(drpTimeZoneInEdit);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + timeZone + "']"));
	}

	public void selectWalletTemplate(String walletTemplate) {
		clickOnElement(drpWalletTemplate);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + walletTemplate + "']"));
	}

	public void selectIsBalanceReservation(String isRerservation) {
		if (!isRerservation.equalsIgnoreCase(IsYes)) {
			clickOnElement(
					By.xpath("(//*[contains(@id,'form_in_modal_inputOperatingentityAddBalanceReservation')])[last()]"));
		}
	}

	public void selectIsBalanceReservationInEdit(String isRerservation) {
		if (!isRerservation.equalsIgnoreCase(IsYes)) {
			clickOnElement(By
					.xpath("(//*[contains(@id,'form_in_modal_inputOperatingentityEditBalanaceReservation')])[last()]"));
		}
	}

	public void selectServiceProfile(String serviceProfile) {
		clickOnElement(drpServiceProfile);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + serviceProfile + "']"));
	}

	public void selectAllowBusinessZone(String businessZone) {
		clickOnElement(drpAllowBusinessZone);
		sendTextInTextBox(
				By.xpath(
						"(//*[contains(@id,'form_in_modal_inputOperatingentityAddAllowedBusinessZone') and @class='ant-select-search__field'])[last()]"),
				businessZone + Keys.ENTER);
		clickOnElement(By.xpath("//*[normalize-space(text())='Timezone']"));
	}

	public void selectProduct(String product) {
		clickOnElement(By.xpath("//*[contains(@class,'tabpane-active')]//*[normalize-space(text())='" + product.trim()
				+ "']//parent::div[contains(@class,'checkbox')]//input//parent::span"));
	}

	public void selectmodules(String moduleName) {
		clickOnElement(By.xpath("//div[normalize-space(text())='" + moduleName + "']"));
	}

	public void selectFieldsOfOperatingEntityTEmplate(By element, String operatingEntityTemplate) {
		clickOnElement(element);
		clickOnElement(By.xpath("(//li[text()='" + operatingEntityTemplate + "'])[last()]"));
	}

	public void selectFieldsOfFromWallet(By element, String string) {
		clickOnElement(element);
		clickOnElement(By.xpath("(//li[text()='" + string + "'])[last()]"));

	}

	public void sendTextInUserIdentifier(By element, String userIdentifier) {
		clearAndSendTextInTextBox(element, userIdentifier);
	}

	public void selectValidationProfile(By element, String isValidationProfile) {
		if (isValidationProfile.equalsIgnoreCase(IsYes)) {
			clickOnElement(element);
		}
	}

	/**
	 * @author shivani.patel Create addOperatingEntityTemplate Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void addOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (!verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			// clickOnElement(By.xpath("//*[contains(@class,'anticon-reload')]//parent::button"));
			clickOnOperatingEntityTemplateAddIcon(map.get(mapKeys.get(2)).toString());
			selectOperatingEntityTemplate();
			sendTextInOperatingEntityTemplateName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(3)).toString());
			selectUserCategory(map.get(mapKeys.get(4)).toString());
			selectRole(map.get(mapKeys.get(5)).toString());
			selectKYC(map.get(mapKeys.get(6)).toString());
			selectKYCLevel(map.get(mapKeys.get(7)).toString());
			selectCurrency(map.get(mapKeys.get(8)).toString());
			selectReportingCurrency(map.get(mapKeys.get(9)).toString());
			String[] allowBusinessZoneList = map.get(mapKeys.get(10)).toString().trim().split(",");
			for (int k = 0; k < allowBusinessZoneList.length; k++) {
				selectAllowBusinessZone(allowBusinessZoneList[k]);
			}
			selectTimeZone(map.get(mapKeys.get(11)).toString());
			selectWalletTemplate(map.get(mapKeys.get(12)).toString());
			selectIsBalanceReservation(map.get(mapKeys.get(13)).toString());

			selectStatus(map.get(mapKeys.get(14)).toString());
			selectServiceProfile(map.get(mapKeys.get(15)).toString());

			if (!map.get(mapKeys.get(16)).toString().trim().equals("")) {
				String[] moduleList = map.get(mapKeys.get(16)).toString().trim().split("/");
				String[] productList = map.get(mapKeys.get(17)).toString().trim().split("/");
				String[] fromOperatingEntityList = map.get(mapKeys.get(18)).toString().trim().split("/");
				String[] fromUserIdentifierList = map.get(mapKeys.get(19)).toString().trim().split("/");
				String[] fromWalletList = map.get(mapKeys.get(20)).toString().trim().split("/");
				String[] fromPouchList = map.get(mapKeys.get(21)).toString().trim().split("/");
				String[] fromValidateProfileList = map.get(mapKeys.get(22)).toString().trim().split("/");
				String[] toOperatingEntityList = map.get(mapKeys.get(23)).toString().trim().split("/");
				String[] toUserIdentifierList = map.get(mapKeys.get(24)).toString().trim().split("/");
				String[] toWalletList = map.get(mapKeys.get(25)).toString().trim().split("/");
				String[] toPouchList = map.get(mapKeys.get(26)).toString().trim().split("/");
				String[] toValidtaeProfileList = map.get(mapKeys.get(27)).toString().trim().split("/");
				for (int i = 0; i < moduleList.length; i++) {
					selectmodules(moduleList[i].trim());
					String[] productselect = productList[i].split(";");
					String[] fromOperatingEntity = fromOperatingEntityList[i].split(";");
					String[] fromUserIdentifier = fromUserIdentifierList[i].split(";");
					String[] fromWallet = fromWalletList[i].split(";");
					String[] fromPouch = fromPouchList[i].split(";");
					String[] fromValidateProfile = fromValidateProfileList[i].split(";");
					String[] toOperatingEntity = toOperatingEntityList[i].split(";");
					String[] toUserIdentifier = toUserIdentifierList[i].split(";");
					String[] toWallet = toWalletList[i].split(";");
					String[] toPouch = toPouchList[i].split(";");
					String[] toValidtaeProfile = toValidtaeProfileList[i].split(";");

					for (int j = 0; j < productselect.length; j++) {
						if (productselect[j].toLowerCase().equals("select all")) {
							selectProduct(productselect[j]);
						}
						// from
						if (moduleList[i].toLowerCase().equals("products")) {
							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductFromOperatingEntity')]"),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUseridentifierFrom')]"),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductFromWallet')]"),
									fromWallet[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductFromPouch')]"),
									fromPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileValidateProfileFrom')]"),
									fromValidateProfile[j].trim());

							// to

							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductToOperatingEntity')]"),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUseridentifierTo')]"),
									toUserIdentifier[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductToWallet')]"),
									toWallet[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductToPouch')]"),
									toPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileValidateProfileTo')]"),
									toValidtaeProfile[j].trim());
						}

						if (moduleList[i].toLowerCase().equals("ucps")) {
							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPFromOperatingEntity')]"),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPUseridentifierFrom')]"),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPFromWallet')]"),
									fromWallet[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPFromPouch')]"),
									fromPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPValidateProfileFrom')]"),
									fromValidateProfile[j].trim());

							// to

							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPToOperatingEntity')]"),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPUseridentifierTo')]"),
									toUserIdentifier[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPToWallet')]"),
									toWallet[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPToPouch')]"),
									toPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPValidateProfileTo')]"),
									toValidtaeProfile[j].trim());
						}
						if (moduleList[i].toLowerCase().equals("product groups")) {
							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromOperatingEntity')]"),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromUserIdf')]"),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromWallet')]"),
									fromWallet[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromPouch')]"),
									fromPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductGroupValidateProfileFrom')]"),
									fromValidateProfile[j].trim());

							// to

							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToOperatingEntity')]"),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToUserIdf')]"),
									toUserIdentifier[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToWallet')]"),
									toWallet[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToPouch')]"),
									toPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductGroupValidateProfileTo')]"),
									toValidtaeProfile[j].trim());
						}
					}
				}
			}
			int rows = Integer.parseInt(map.get(mapKeys.get(28)).toString());
			String[] accessChannelList = map.get(mapKeys.get(29)).toString().split(";");
			for (int m = 0; m < rows; m++) {
				selectAccessChannel(accessChannelList[m].trim());
				String[] allowedAPIList = map.get(mapKeys.get(30)).toString().split(";");
				String[] twofactor = map.get(mapKeys.get(31)).toString().split(";");
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
			clickOnElement(btnSave);
		}
	}

	public boolean verifyAddedOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By
				.xpath("//*[normalize-space(text()) = 'Name']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(1)).toString() + "']");
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
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(userCatefory, false))
				return false;
			if (!verifyElement(role, false))
				return false;
			if (!verifyElement(currency, false))
				return false;
			if (!verifyElement(reportingCurrency, false))
				return false;
			if (!verifyElement(kyc, false))
				return false;
			if (!verifyElement(kycLevel, false))
				return false;
			if (!verifyElement(timezone, false))
				return false;
			if (!verifyElement(walletTemplate, false))
				return false;
			if (!verifyElement(status, false))
				return false;
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
	 * @author shivani.patel Create addOperatingEntityTemplate Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void editOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnEditDetail();
			commonWait();
			commonWait();
			commonWait();
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				sendTextInDescriptionInEdit(map.get(mapKeys.get(3)).toString());
			}
			if (!map.get(mapKeys.get(4)).toString().equals("")) {
				selectUserCategoryInEdit(map.get(mapKeys.get(4)).toString());
			}
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				selectRoleInEdit(map.get(mapKeys.get(5)).toString());
			}
			if (!map.get(mapKeys.get(6)).toString().equals("")) {
				selectKYCINEdit(map.get(mapKeys.get(6)).toString());
			}
			if (!map.get(mapKeys.get(7)).toString().equals("")) {
				selectKYCLevelInEdit(map.get(mapKeys.get(7)).toString());
			}
			if (!map.get(mapKeys.get(8)).toString().equals("")) {
				selectCurrencyInEdit(map.get(mapKeys.get(8)).toString());
			}
			if (!map.get(mapKeys.get(9)).toString().equals("")) {
				selectReportingCurrencyInEdit(map.get(mapKeys.get(9)).toString());
			}
			if (!map.get(mapKeys.get(10)).toString().equals("")) {
				String[] allowBusinessZoneList = map.get(mapKeys.get(10)).toString().trim().split(",");
				for (int k = 0; k < allowBusinessZoneList.length; k++) {
					selectAllowBusinessZone(allowBusinessZoneList[k]);
				}
			}
			if (!map.get(mapKeys.get(11)).toString().equals("")) {
				selectTimeZoneInEdit(map.get(mapKeys.get(11)).toString());
			}
			if (!map.get(mapKeys.get(12)).toString().equals("")) {
				selectWalletTemplate(map.get(mapKeys.get(12)).toString());
			}
			if (!map.get(mapKeys.get(13)).toString().equals("")) {
				selectIsBalanceReservationInEdit(map.get(mapKeys.get(13)).toString());
			}
			if (!map.get(mapKeys.get(14)).toString().equals("")) {
				selectStatusInEdit(map.get(mapKeys.get(14)).toString());
			}
			if (!map.get(mapKeys.get(16)).toString().trim().equals("")) {
				String[] moduleList = map.get(mapKeys.get(16)).toString().trim().split("/");
				String[] productList = map.get(mapKeys.get(17)).toString().trim().split("/");
				String[] fromOperatingEntityList = map.get(mapKeys.get(18)).toString().trim().split("/");
				String[] fromUserIdentifierList = map.get(mapKeys.get(19)).toString().trim().split("/");
				String[] fromWalletList = map.get(mapKeys.get(20)).toString().trim().split("/");
				String[] fromPouchList = map.get(mapKeys.get(21)).toString().trim().split("/");
				String[] fromValidateProfileList = map.get(mapKeys.get(22)).toString().trim().split("/");
				String[] toOperatingEntityList = map.get(mapKeys.get(23)).toString().trim().split("/");
				String[] toUserIdentifierList = map.get(mapKeys.get(24)).toString().trim().split("/");
				String[] toWalletList = map.get(mapKeys.get(25)).toString().trim().split("/");
				String[] toPouchList = map.get(mapKeys.get(26)).toString().trim().split("/");
				String[] toValidtaeProfileList = map.get(mapKeys.get(27)).toString().trim().split("/");
				for (int i = 0; i < moduleList.length; i++) {
					selectmodules(moduleList[i].trim());
					String[] productselect = productList[i].split(";");
					String[] fromOperatingEntity = fromOperatingEntityList[i].split(";");
					String[] fromUserIdentifier = fromUserIdentifierList[i].split(";");
					String[] fromWallet = fromWalletList[i].split(";");
					String[] fromPouch = fromPouchList[i].split(";");
					String[] fromValidateProfile = fromValidateProfileList[i].split(";");
					String[] toOperatingEntity = toOperatingEntityList[i].split(";");
					String[] toUserIdentifier = toUserIdentifierList[i].split(";");
					String[] toWallet = toWalletList[i].split(";");
					String[] toPouch = toPouchList[i].split(";");
					String[] toValidtaeProfile = toValidtaeProfileList[i].split(";");

					for (int j = 0; j < productselect.length; j++) {
						if (productselect[j].toLowerCase().equals("select all")) {
							selectProduct(productselect[j]);
						}
						// from
						if (moduleList[i].toLowerCase().equals("products")) {
							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductFromOperatingEntity')]"),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUseridentifierFrom')]"),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductFromWallet')]"),
									fromWallet[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductFromPouch')]"),
									fromPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileValidateProfileFrom')]"),
									fromValidateProfile[j].trim());

							// to

							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductToOperatingEntity')]"),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUseridentifierTo')]"),
									toUserIdentifier[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductToWallet')]"),
									toWallet[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductToPouch')]"),
									toPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileValidateProfileTo')]"),
									toValidtaeProfile[j].trim());
						}

						if (moduleList[i].toLowerCase().equals("ucps")) {
							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPFromOperatingEntity')]"),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPUseridentifierFrom')]"),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPFromWallet')]"),
									fromWallet[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPFromPouch')]"),
									fromPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPValidateProfileFrom')]"),
									fromValidateProfile[j].trim());

							// to

							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPToOperatingEntity')]"),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPUseridentifierTo')]"),
									toUserIdentifier[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPToWallet')]"),
									toWallet[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPToPouch')]"),
									toPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPValidateProfileTo')]"),
									toValidtaeProfile[j].trim());
						}
						if (moduleList[i].toLowerCase().equals("product groups")) {
							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromOperatingEntity')]"),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromUserIdf')]"),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromWallet')]"),
									fromWallet[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromPouch')]"),
									fromPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductGroupValidateProfileFrom')]"),
									fromValidateProfile[j].trim());

							// to

							selectFieldsOfOperatingEntityTEmplate(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToOperatingEntity')]"),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToUserIdf')]"),
									toUserIdentifier[j].trim());

							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToWallet')]"),
									toWallet[j].trim());
							selectFieldsOfFromWallet(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToPouch')]"),
									toPouch[j].trim());
							selectValidationProfile(
									By.xpath("//tr[" + (j + 1)
											+ "]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductGroupValidateProfileTo')]"),
									toValidtaeProfile[j].trim());
						}
					}
				}
			}
			if (!map.get(mapKeys.get(28)).toString().trim().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(28)).toString());
				String[] accessChannelList = map.get(mapKeys.get(29)).toString().split(";");
				for (int m = 0; m < rows; m++) {
					selectAccessChannel(accessChannelList[m].trim());
					String[] allowedAPIList = map.get(mapKeys.get(30)).toString().split(";");
					String[] twofactor = map.get(mapKeys.get(31)).toString().split(";");
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
			clickOnElement(btnSave);
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
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
	 * @author shivani.patel Create DeleteOperatingEntityTemplate Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean deleteOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnOperatingEntityTemplateDelete(map.get(mapKeys.get(1)).toString());
			return true;
		} else {
			String string = "OperatingEntityTemplate already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedOperatingEntityTemplate Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean verifyDeletedOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		return verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false);

	}
}
