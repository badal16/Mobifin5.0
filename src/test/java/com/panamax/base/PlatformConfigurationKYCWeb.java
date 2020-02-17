package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class PlatformConfigurationKYCWeb extends Common {
	By txtName = By.id(readJSFile("INPUT_KYC_ADD_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_KYC_ADD_DESCRIPTION", FileType.element));
	By btnAddKYCLevel = By.xpath("//*[@class='card-body']//*[@class='ant-btn addBtn ant-btn-primary']");
	By btnAddLevelFiels = By
			.xpath("(//*[@class='ant-modal-body']//*[@class='ant-btn addBtn ant-btn-primary'])[last()]");
	By txtLevelName = By.xpath("(//*[contains(@id,'LevelName')])[last()]");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_KYC_EDIT_DESCRIPTION", FileType.element));
	By drplevelField = By.xpath("(//*[contains(@id,'LevelFields')]//*[@class='ant-select-arrow'])[last()]");
	String IsYes = "Yes";
	By btnLevelFielsOk = By.xpath("(//*[@class='ant-btn ant-btn-primary'])[last()]");
	By btnselectLevelField = By.xpath("(//*[contains(@id,'LevelFieldsButton')])[last()]");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 09/08/2019
	 */
	public PlatformConfigurationKYCWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtName, name);
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath("//*[@id='inputKYCAddStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputKYCEditStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void clickOnAddKYCLevel() {
		clickOnElement(btnAddKYCLevel);
	}

	public void clickOnAddLevelFields() {
		clickOnElement(btnAddLevelFiels);
	}

	public void sendtextInLevelNameField(String levelName) {
		sendTextInTextBox(txtLevelName, levelName);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void selectLevelField(String levalField) {
		clickOnElement(drplevelField);
		sendTextInTextBox(
				By.xpath("(//*[contains(@id,'LevelFields') and @class='ant-select-search__field'])[last()]"),
				levalField + Keys.ENTER);
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'IsMandatory')])[last()]"));
		}
	}

	public void selectIsEditable(String isEditable) {
		if (isEditable.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'IsEditable')])[last()]"));
		}
	}

	public void clickOnLevelFieldOkBtn() {
		clickOnElement(btnLevelFielsOk);
	}

	public void clickOnSelectLevelField() {
		clickOnElement(btnselectLevelField);
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
	 * @author shivani.patel Create addKYC Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 22/07/2019
	 */
	public void addKYC(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectStatus(map.get(mapKeys.get(3)).toString());
			int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
			String[] levelNameList = map.get(mapKeys.get(5)).toString().split(",");
			for (int m = 0; m < rows; m++) {
				clickOnAddKYCLevel();
				sendtextInLevelNameField(levelNameList[m].trim());
				if (!map.get(mapKeys.get(6)).toString().equals("")) {
					clickOnSelectLevelField();
					String[] levelfieldList = map.get(mapKeys.get(6)).toString().split(";");
					String[] ismandatoryList = map.get(mapKeys.get(7)).toString().split(";");
					String[] isEditableList = map.get(mapKeys.get(8)).toString().split(";");
					String[] levelfield = levelfieldList[m].split(",");
					String[] ismandatory = ismandatoryList[m].split(",");
					String[] isEditable = isEditableList[m].split(",");
					for (int j = 0; j < levelfield.length; j++) {
						clickOnAddLevelFields();
						selectLevelField(levelfield[j].trim());
						selectIsMandatory(ismandatory[j].trim());
						selectIsEditable(isEditable[j].trim());
					}
					clickOnLevelFieldOkBtn();
				}
			}
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedKYC(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("kyc.label.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("kyc.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("kyc.label.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(3)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
			String[] levelNameList = map.get(mapKeys.get(5)).toString().split(",");
			for (int m = 0; m < rows; m++) {
				clickOnElement(By.xpath("//*[normalize-space(text())='" + levelNameList[m]
						+ "']//parent::tr//*[@class='ant-btn addBtn ant-btn-primary']"));
				if (!map.get(mapKeys.get(6)).toString().equals("")) {
					String[] levelfieldList = map.get(mapKeys.get(6)).toString().split(";");
					String[] levelfield = levelfieldList[m].split(",");
					for (int j = 0; j < levelfield.length; j++) {
						if (!verifyElement(By.xpath("//*[normalize-space(text())='" + levelfield[j] + "']"), false)) {
							return false;
						}
					}
					clickOnLevelFieldOkBtn();
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create addKYC Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 22/07/2019
	 */
	public void editKYC(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectStatusInEdit(map.get(mapKeys.get(9)).toString());
			if (!map.get(mapKeys.get(4)).toString().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
				String[] levelNameList = map.get(mapKeys.get(5)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					clickOnAddKYCLevel();
					sendtextInLevelNameField(levelNameList[m].trim());
					if (!map.get(mapKeys.get(6)).toString().equals("")) {
						clickOnSelectLevelField();
						String[] levelfieldList = map.get(mapKeys.get(6)).toString().split(";");
						String[] ismandatoryList = map.get(mapKeys.get(7)).toString().split(";");
						String[] isEditableList = map.get(mapKeys.get(8)).toString().split(";");
						String[] levelfield = levelfieldList[m].split(",");
						String[] ismandatory = ismandatoryList[m].split(",");
						String[] isEditable = isEditableList[m].split(",");
						for (int j = 0; j < levelfield.length; j++) {
							clickOnAddLevelFields();
							selectLevelField(levelfield[j].trim());
							selectIsMandatory(ismandatory[j].trim());
							selectIsEditable(isEditable[j].trim());
						}
						clickOnLevelFieldOkBtn();
					}
				}
			}
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedKYC(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("kyc.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("kyc.label.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(9)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(9)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(status, false))
				return false;
			if(!map.get(mapKeys.get(4)).toString().equals("")){
			int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
			String[] levelNameList = map.get(mapKeys.get(5)).toString().split(",");
			for (int m = 0; m < rows; m++) {
				clickOnElement(By.xpath("//*[normalize-space(text())='" + levelNameList[m]
						+ "']//parent::tr//*[@class='ant-btn addBtn ant-btn-primary']"));
				if (!map.get(mapKeys.get(6)).toString().equals("")) {
					String[] levelfieldList = map.get(mapKeys.get(6)).toString().split(";");
					String[] levelfield = levelfieldList[m].split(",");
					for (int j = 0; j < levelfield.length; j++) {
						if (!verifyElement(By.xpath("//*[normalize-space(text())='" + levelfield[j] + "']"), false)) {
							return false;
						}
					}
					clickOnLevelFieldOkBtn();
				}
			}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create DeleteKYC Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 05/10/2018
	 */
	public boolean deleteKYC(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "KYC already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedKYC Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 09/08/2019
	 */
	public boolean verifyDeletedKYC(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}
	public boolean sortKYC(Map<Object, Object> map, List<Object> mapKeys) {
		commonWait();
		commonWait();
		commonWait();
		clickOnElement(By.xpath("(//*[text()='KYC'])[1]"));
		Map<String, List<String>> getBeforeSortTableData = getTableData(map.get(getMapKeys(map).get(2)).toString());
		clickOnSortBtn(map.get(getMapKeys(map).get(0)).toString(), map.get(getMapKeys(map).get(1)).toString());
		List<String> sortedUIColumnData = getColumnData(map.get(getMapKeys(map).get(0)).toString());
		List<String> sortedUIColumnDataCopy = new ArrayList<String>(sortedUIColumnData);
		sortColumn(sortedUIColumnData, map.get(getMapKeys(map).get(1)).toString());
		if (!compareTwoLists(sortedUIColumnData, sortedUIColumnDataCopy))
			return false;
		Map<String, List<String>> getAfterSortTableData = getTableData(map.get(getMapKeys(map).get(2)).toString());
		if (!getBeforeSortTableData.equals(getAfterSortTableData))
			return false;
		return true;
	}
}
