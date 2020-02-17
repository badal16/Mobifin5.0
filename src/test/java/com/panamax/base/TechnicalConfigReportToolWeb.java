package com.panamax.base;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class TechnicalConfigReportToolWeb extends Common {
	By txtName = By.id("inputReporttoolAddName");
	By txtDescription = By.id("inputReporttoolAddSrNo");
	By drpFieldType = By.xpath("//*[@id='inputReportToolAddFieldtype']//*[@class='ant-select-arrow']");
	String IsYes = "Yes";
	By btnAddColumn = By.xpath("//*[normalize-space(text())='Add Columns']//parent::button");
	By btnAddFilter = By.xpath("//*[normalize-space(text())='Add Filters']//parent::button");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id("inputReporttoolEditDescription");
	By txtQuery = By.id("inputReporttoolAddQuery");
	By drpParameter = By.xpath("(//*[contains(@id,'parameters')]//*[@class='ant-select-arrow'])[last()]");
	By txtDefaultValue = By.xpath("(//*[contains(@id,'defaultValue')])[last()]");
	By drpDefaultCriteria = By.xpath("(//*[contains(@id,'defaultCriteria')]//*[@class='ant-select-arrow'])[last()]");
	By drpDataType = By.xpath("(//*[contains(@id,'datatype')]//*[@class='ant-select-arrow'])[last()]");
	By drpAlignment = By.xpath("(//*[contains(@id,'alignment')]//*[@class='ant-select-arrow'])[last()]");
	By txtDisplayName = By.xpath("(//*[contains(@id,'displayname')])[last()]");
	By txtColumnName = By.xpath("(//*[contains(@id,'columnname')])[last()]");
	By txtQueryInEdit = By.id("inputReporttoolEditQuery");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 17/07/2019
	 */
	public TechnicalConfigReportToolWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendTextInTextBox(txtName, name);
	}

	public void sendTextInDescription(String description) {
		sendTextInTextBox(txtDescription, description);
	}

	public void sendTextInOutputFileFormat(String outputFileFormat) {
		sendTextInTextBox(By.xpath("//*[@id='inputReporttoolAddOutputFileFormat']//input"),
				outputFileFormat + Keys.ENTER);
	}

	public void sendTextInOutputFileFormatInEdit(String outputFileFormat) {
		sendTextInTextBox(By.xpath("//*[@id='inputReporttoolEditFileformat']//input"), outputFileFormat + Keys.ENTER);
	}

	public void sendTextInDescriptionInEdit(String description) {
		commonWait();
		commonWait();
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void select(String fieldType) {
		clickOnElement(drpFieldType);
		clickOnElement(By.xpath("//*[normalize-space(text())='" + fieldType + "']"));
	}

	public void sendTextInQuery(String query) {
		sendTextInTextBox(txtQuery, query);
	}

	public void sendTextInQueryInEdit(String query) {
		clearAndSendTextInTextBox(txtQueryInEdit, query);
	}

	public void sendTextInDeafaltValue(String defaultValue) {
		sendTextInTextBox(txtDefaultValue, defaultValue);
	}

	public void sendTextInDisplayName(String displayName) {
		sendTextInTextBox(txtDisplayName, displayName);
	}

	public void sendTextInColumnName(String columnName) {
		sendTextInTextBox(txtColumnName, columnName);
	}

	public void selectStatus(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputReporttoolAddStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectReportType(String reportType) {
		clickOnElement(By.xpath(
				"//*[@id='inputReporttoolAddReporttype']//span[normalize-space(text())='" + reportType.trim() + "']"));
	}

	public void selectReportTypeInEdit(String reportType) {
		clickOnElement(By.xpath(
				"//*[@id='inputReporttoolEditReportType']//span[normalize-space(text())='" + reportType.trim() + "']"));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(
				By.xpath("//*[@id='inputReporttoolAddStatus']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'isMandatory')])[last()]"));
		}
	}

	public void selectIsVisible(String isVisible) {
		if (!isVisible.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'visible')])[last()]"));
		}
	}

	public void clickOnAddColumn() {
		clickOnElement(btnAddColumn);
	}

	public void clickOnAddFilters() {
		clickOnElement(btnAddFilter);
	}

	public void sendTextInNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectChildField(String childField) {
		clickOnElement(By.xpath("//*[normalize-space(text())='" + childField + "']"));
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void sendTextInPossibleValueInDropdown(String possibleValue) {
		sendTextInTextBox(By.xpath("(//*[@id='inputReportToolAddPossiblevalue'])[last()]"), possibleValue);
	}

	public void selectParameter(String parameter) {
		clickOnElement(drpParameter);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + parameter.trim() + "'])[last()]"));
	}

	public void selectDefaultCriteria(String defaultCriteria) {
		clickOnElement(drpDefaultCriteria);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + defaultCriteria.trim() + "'])[last()]"));
	}

	public void selectDataType(String dataType) {
		clickOnElement(drpDataType);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + dataType.trim() + "'])[last()]"));
	}

	public void selectAlignment(String alignment) {
		clickOnElement(drpAlignment);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + alignment.trim() + "'])[last()]"));
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
	 * @author shivani.patel Create addReportTool Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 22/07/2019
	 */
	public void addReportTool(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		commonWait();
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			String[] OutputFileFormatList = map.get(mapKeys.get(3)).toString().split(",");
			for (int m = 0; m < OutputFileFormatList.length; m++) {
				sendTextInOutputFileFormat(OutputFileFormatList[m].trim());
				clickOnElement(By.xpath("//*[text()='Output File Format']"));
			}
			selectStatus(map.get(mapKeys.get(4)).toString());
			selectReportType(map.get(mapKeys.get(5)).toString());
			sendTextInQuery(map.get(mapKeys.get(6)).toString());
			if (!map.get(mapKeys.get(5)).toString().toLowerCase().equals("scheduled")) {
				String[] fieldNameList = map.get(mapKeys.get(7)).toString().split(",");
				String[] defaultValueList = map.get(mapKeys.get(8)).toString().split(",");
				String[] defaultCriteriaList = map.get(mapKeys.get(9)).toString().split(",");
				String[] ismandatory = map.get(mapKeys.get(10)).toString().split(",");
				String[] isVisible = map.get(mapKeys.get(11)).toString().split(",");
				for (int m = 0; m < fieldNameList.length; m++) {
					clickOnAddFilters();
					selectParameter(fieldNameList[m].trim());
					sendTextInDeafaltValue(defaultValueList[m].trim());
					selectDefaultCriteria(defaultCriteriaList[m].trim());
					selectIsMandatory(ismandatory[m].trim());
					selectIsVisible(isVisible[m].trim());
				}
				int rows = Integer.parseInt(map.get(mapKeys.get(12)).toString());
				String[] displayNameList = map.get(mapKeys.get(13)).toString().split(",");
				String[] columnNameList = map.get(mapKeys.get(14)).toString().split(",");
				String[] dataTypeList = map.get(mapKeys.get(15)).toString().split(",");
				String[] alignmentList = map.get(mapKeys.get(16)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					sendTextInDisplayName(displayNameList[m].trim());
					sendTextInColumnName(columnNameList[m].trim());
					selectDataType(dataTypeList[m].trim());
					selectAlignment(alignmentList[m].trim());
					if (m < rows - 1) {
						clickOnAddColumn();
					}
				}
			}
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedReportTool(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By
				.xpath("//*[normalize-space(text()) = 'Name']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = 'Description']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By status = By
				.xpath("//*[normalize-space(text()) = 'Status']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			String[] OutputFileFormatList = map.get(mapKeys.get(3)).toString().split(",");
			for (int m = 0; m < OutputFileFormatList.length; m++) {
				if (!verifyElement(By
						.xpath("//*[normalize-space(text()) = 'Output File Format']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
								+ OutputFileFormatList[m].toUpperCase() + "')]"),
						false))
					return false;
			}
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create addReportTool Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 22/07/2019
	 */
	public void editReportTool(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			commonWait();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				String[] OutputFileFormatList = map.get(mapKeys.get(3)).toString().split(",");
				for (int m = 0; m < OutputFileFormatList.length; m++) {
					sendTextInOutputFileFormatInEdit(OutputFileFormatList[m].trim());
					clickOnElement(By.xpath("//*[text()='Output File Format']"));
				}
			}
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				selectReportTypeInEdit(map.get(mapKeys.get(5)).toString());
			}
			if (!map.get(mapKeys.get(6)).toString().equals("")) {
				sendTextInQueryInEdit(map.get(mapKeys.get(6)).toString());
			}
			if (!map.get(mapKeys.get(5)).toString().toLowerCase().equals("scheduled")) {
				if (!map.get(mapKeys.get(7)).toString().equals("")) {
					String[] fieldNameList = map.get(mapKeys.get(7)).toString().split(",");
					String[] defaultValueList = map.get(mapKeys.get(8)).toString().split(",");
					String[] defaultCriteriaList = map.get(mapKeys.get(9)).toString().split(",");
					String[] ismandatory = map.get(mapKeys.get(10)).toString().split(",");
					String[] isVisible = map.get(mapKeys.get(11)).toString().split(",");
					for (int m = 0; m < fieldNameList.length; m++) {
						clickOnAddFilters();
						selectParameter(fieldNameList[m].trim());
						sendTextInDeafaltValue(defaultValueList[m].trim());
						selectDefaultCriteria(defaultCriteriaList[m].trim());
						selectIsMandatory(ismandatory[m].trim());
						selectIsVisible(isVisible[m].trim());
					}
				}
				if (!map.get(mapKeys.get(12)).toString().equals("")) {
					int rows = Integer.parseInt(map.get(mapKeys.get(12)).toString());
					String[] displayNameList = map.get(mapKeys.get(13)).toString().split(",");
					String[] columnNameList = map.get(mapKeys.get(14)).toString().split(",");
					String[] dataTypeList = map.get(mapKeys.get(15)).toString().split(",");
					String[] alignmentList = map.get(mapKeys.get(16)).toString().split(",");
					for (int m = 0; m < rows; m++) {
						sendTextInDisplayName(displayNameList[m].trim());
						sendTextInColumnName(columnNameList[m].trim());
						selectDataType(dataTypeList[m].trim());
						selectAlignment(alignmentList[m].trim());
						if (m < rows - 1) {
							clickOnAddColumn();

						}
					}
				}
			}
			selectStatusInEdit(map.get(mapKeys.get(17)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedReportTool(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By
				.xpath("//*[normalize-space(text()) = 'Name']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = 'Description']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By status = By
				.xpath("//*[normalize-space(text()) = 'Status']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(17)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(17)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(description, false))
				return false;
			String[] OutputFileFormatList = map.get(mapKeys.get(3)).toString().split(",");
			for (int m = 0; m < OutputFileFormatList.length; m++) {
				if (!verifyElement(By
						.xpath("//*[normalize-space(text()) = 'Output File Format']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
								+ OutputFileFormatList[m].toUpperCase() + "')]"),
						false))
					return false;
			}
			if (!verifyElement(status, false))
				return false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create DeleteReportTool Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 05/10/2018
	 */
	public boolean deleteReportTool(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "ReportTool already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedReportTool Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 05/10/2019
	 */
	public boolean verifyDeletedReportTool(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}
}
