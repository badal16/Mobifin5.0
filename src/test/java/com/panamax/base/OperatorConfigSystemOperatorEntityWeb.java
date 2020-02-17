package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.panamax.init.Common;

public class OperatorConfigSystemOperatorEntityWeb extends Common {
	By txtSystemOperatorEntityName = By.id(readJSFile("INPUT_SYSTEMOPERATORENTITY_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_SYSTEMOPERATORENTITY_DESCRIPTION", FileType.element));
	By drpUserCategory = By.xpath("//*[@id='" + readJSFile("INPUT_SYSTEMOPERATORENTITY_USERCATEGORY", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpBusinessZone = By.xpath("//*[@id='inputSystemoperatorentityBusinessZone']//*[@class='ant-select-arrow']");
	By drpKYC = By.xpath("//*[@id='inputSystemoperatorentityKYC']//*[@class='ant-select-arrow']");
	By drpKYCLevel = By.xpath("//*[@id='" + readJSFile("INPUT_SYSTEMOPERATORENTITY_KYCLEVEL", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpRole = By.xpath("//*[@id='" + readJSFile("INPUT_SYSTEMOPERATORENTITY_ROLE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpTimeZone = By.xpath("//*[@id='inputSystemoperatorentityTimeZone']//*[@class='ant-select-arrow']");
	By drpAccessChannel = By.xpath("(//*[contains(@id,'accesschannalFields')]//*[@class='ant-select-arrow'])[last()]");
	By drpAllowedAPI = By
			.xpath("(//*[contains(@id,'allowedapi')]//*[@class='ant-select-selection__rendered'])[last()]");
	String IsYes = "Yes";
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_ROLES_EDIT_DESCRIPTION", FileType.element));
	By drpUsedBy = By.xpath("//*[@id='inputSystemOperatorEntityAddUsedBy']//*[@class='ant-select-arrow']");
	By drpUsedByInSearch = By.xpath(
			"//*[normalize-space(text())='Used By']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By btnAddKYCLevel = By.xpath("//*[normalize-space(text())='Add Field']//parent::button");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 24/09/2019
	 */
	public OperatorConfigSystemOperatorEntityWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtSystemOperatorEntityName, name);
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescription, description);
	}

	public void selectUserCategory(String userCategory) {
		clickOnElement(drpUserCategory);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + userCategory + "']"));
	}

	public void selectBusinessZone(String businessZone) {
		clickOnElement(drpBusinessZone);
		commonWait();
		clickOnElement(By.xpath("//li[normalize-space(text())='" + businessZone + "']"));
	}

	public void selectKYC(String kyc) {
		clickOnElement(drpKYC);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + kyc + "']"));
	}

	public void selectKYCLevel(String kycLevel) {
		clickOnElement(drpKYCLevel);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + kycLevel + "']"));
	}

	public void selectRole(String role) {
		clickOnElement(drpRole);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + role + "']"));
	}

	public void selectTimeZone(String timeZone) {
		clickOnElement(drpTimeZone);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + timeZone + "']"));
	}

	public void selectAccessChannel(String accessChannel) {
		clickOnElement(drpAccessChannel);
		sendTextInTextBox(
				By.xpath("(//*[contains(@id,'accesschannalFields') and @class='ant-select-search__field'])[last()]"),
				accessChannel + Keys.ENTER);
	}

	public void sendTextInAllowedAPI(String allowedAPI) {
		// clickOnElement(drpAllowedAPI);
		sendTextInTextBox(By.xpath("(//*[contains(@id,'allowedapi')]//*[@class='ant-select-search__field'])[last()]"),
				allowedAPI + Keys.ENTER);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(
				"//*[@id='inputSystemoperatorentityStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'2faAllowed')])[last()]"));
		}
	}

	public void selectIsEditable(String isEditable) {
		if (isEditable.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'"
					+ readJSFile("INPUT_PARAMETER_ADD_CHILDFIELDEDITABLE", FileType.element) + "')])[last()]"));
		}
	}

	public void sendTextInSystemOperatorEntityNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void clickOnAddField() {
		clickOnElement(btnAddKYCLevel);
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		commonWait(10);
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInSystemOperatorEntityNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addSystemOperatorEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void addSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(13)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectUserCategory(map.get(mapKeys.get(3)).toString());
			selectBusinessZone(map.get(mapKeys.get(4)).toString());
			selectKYC(map.get(mapKeys.get(5)).toString());
			selectKYCLevel(map.get(mapKeys.get(6)).toString());
			selectRole(map.get(mapKeys.get(7)).toString());
			selectTimeZone(map.get(mapKeys.get(8)).toString());
			int rows = Integer.parseInt(map.get(mapKeys.get(9)).toString());
			String[] accessChannelList = map.get(mapKeys.get(10)).toString().split(";");
			for (int m = 0; m < rows; m++) {
				clickOnAddField();
				selectAccessChannel(accessChannelList[m].trim());
				String[] allowedAPIList = map.get(mapKeys.get(11)).toString().split(";");
				String[] twofactor = map.get(mapKeys.get(12)).toString().split(";");
				String[] levelfield = allowedAPIList[m].split(",");
				for (int j = 0; j < levelfield.length; j++) {
					sendTextInAllowedAPI(levelfield[j].trim());
					clickOnElement(By.xpath("//*[normalize-space(text())='Access Channel']"));
				}
				selectIsMandatory(twofactor[m].trim());
			}
			selectStatus(map.get(mapKeys.get(13)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("systemoperatorentity.label.name", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("systemoperatorentity.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By userCategory = By.xpath("//*[normalize-space(text()) = '"
				+ readJSFile("systemoperatorentity.label.usercategory", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(3)).toString() + "']");
		By businessZone = By
				.xpath("//*[normalize-space(text()) = 'Business Zone']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		By kycLevel = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("systemoperatorentity.label.kyclevel", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(6)).toString() + "']");
		By role = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("systemoperatorentity.label.role", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");
		By timeZone = By
				.xpath("//*[normalize-space(text()) = 'Time Zone']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(8)).toString() + "']");
		By status = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("systemoperatorentity.label.status", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(13)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(13)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, true))
				return false;
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(userCategory, false))
				return false;
			if (!verifyElement(businessZone, false))
				return false;
			if (!verifyElement(kycLevel, false))
				return false;
			if (!verifyElement(role, false))
				return false;
			if (!verifyElement(timeZone, false))
				return false;
			int rows = Integer.parseInt(map.get(mapKeys.get(9)).toString());
			String[] accessChannelList = map.get(mapKeys.get(10)).toString().split(";");
			for (int m = 0; m < rows; m++) {
				if (!verifyElement(By.xpath("//table//tbody//tr[" + (m + 1) + "]//td[normalize-space(text())='"
						+ accessChannelList[m] + "']"), false))
					return false;
				String[] allowedAPIList = map.get(mapKeys.get(11)).toString().split(";");
				String[] twofactor = map.get(mapKeys.get(12)).toString().split(";");
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
							By.xpath("//table//tbody//tr[" + (m + 1) + "]//td//i[contains(@class,'text-danger')]"),
							false))
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
	 * @author shivani.patel Create addSystemOperatorEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 14/10/2019
	 */
	public void editSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(13)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectUserCategory(map.get(mapKeys.get(3)).toString());
			selectBusinessZone(map.get(mapKeys.get(4)).toString());
			selectKYC(map.get(mapKeys.get(5)).toString());
			selectKYCLevel(map.get(mapKeys.get(6)).toString());
			selectRole(map.get(mapKeys.get(7)).toString());
			selectTimeZone(map.get(mapKeys.get(8)).toString());
			List<WebElement> removeList = getElementList(By.xpath("//*[normalize-space(text())='Remove']"));
			for (int i = 0; i < removeList.size(); i++) {
				clickOnElement(By.xpath("//tbody//tr[1]//td[contains(@class,'text')]//button"));
			}
			int rows = Integer.parseInt(map.get(mapKeys.get(9)).toString());
			String[] accessChannelList = map.get(mapKeys.get(10)).toString().split(";");
			for (int m = 0; m < rows; m++) {
				clickOnAddField();
				selectAccessChannel(accessChannelList[m].trim());
				String[] allowedAPIList = map.get(mapKeys.get(11)).toString().split(";");
				String[] twofactor = map.get(mapKeys.get(12)).toString().split(";");
				String[] levelfield = allowedAPIList[m].split(",");
				for (int j = 0; j < levelfield.length; j++) {
					sendTextInAllowedAPI(levelfield[j].trim());
				}
				selectIsMandatory(twofactor[m].trim());
			}
			selectStatus(map.get(mapKeys.get(14)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By.xpath("//*[normalize-space(text()) = '" + readJSFile("role.description", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(2)).toString() + "']");
		By userCategory = By.xpath("//*[normalize-space(text()) = '"
				+ readJSFile("systemoperatorentity.label.usercategory", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(3)).toString() + "']");
		By businessZone = By
				.xpath("//*[normalize-space(text()) = 'Business Zone']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		By kycLevel = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("systemoperatorentity.label.kyclevel", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(6)).toString() + "']");
		By role = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("systemoperatorentity.label.role", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");
		By timeZone = By
				.xpath("//*[normalize-space(text()) = 'Time Zone']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(8)).toString() + "']");
		By status = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("systemoperatorentity.label.status", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(14)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(userCategory, false))
				return false;
			if (!verifyElement(businessZone, false))
				return false;
			if (!verifyElement(kycLevel, false))
				return false;
			if (!verifyElement(role, false))
				return false;
			if (!verifyElement(timeZone, false))
				return false;
			int rows = Integer.parseInt(map.get(mapKeys.get(9)).toString());
			String[] accessChannelList = map.get(mapKeys.get(10)).toString().split(";");
			for (int m = 0; m < rows; m++) {
				if (!verifyElement(By.xpath("//table//tbody//tr[" + (m + 1) + "]//td[normalize-space(text())='"
						+ accessChannelList[m] + "']"), false))
					return false;
				String[] allowedAPIList = map.get(mapKeys.get(11)).toString().split(";");
				String[] twofactor = map.get(mapKeys.get(12)).toString().split(";");
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
							By.xpath("//table//tbody//tr[" + (m + 1) + "]//td//i[contains(@class,'text-danger')]"),
							false))
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
	 * @author shivani.patel Create DeleteSystemOperatorEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 14/10/2019
	 */
	public boolean deleteSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			delete();
			return true;
		} else {
			String string = "SystemOperatorEntity already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedSystemOperatorEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 14/10/2019
	 */
	public boolean verifyDeletedSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}

	public boolean sortSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
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
