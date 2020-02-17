package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class PlatformConfigurationParameterWeb extends Common {
	By txtName = By.id(readJSFile("INPUT_PARAMETER_ADD_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_PARAMETER_ADD_DESCRIPTION", FileType.element));
	By drpFieldType = By.xpath("//*[@id='inputParameterAddFieldtype']//*[@class='ant-select-arrow']");
	By drpComponentType = By.xpath("//*[@id='inputParameterAddComponenttype']//*[@class='ant-select-arrow']");
	By txtPossibleValue = By.id(readJSFile("INPUT_PARAMETER_ADD_POSSIBLEVALUE", FileType.element));
	By txtPossibleValueInEdit = By.id(readJSFile("INPUT_PARAMETER_EDIT_POSSIBLEVALUE", FileType.element));
	By drpDataType = By.xpath("//*[@id='" + readJSFile("INPUT_PARAMETER_ADD_DATATYPE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpDataTypeInEdit = By.xpath("//*[@id='" + readJSFile("INPUT_PARAMETER_EDIT_DATATYPE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By txtRegEx = By.id(readJSFile("INPUT_PARAMETER_ADD_REGEX", FileType.element));
	By txtRegExInEdit = By.id(readJSFile("INPUT_PARAMETER_EDIT_REGEX", FileType.element));
	By txtValidationMessage = By.id(readJSFile("INPUT_PARAMETER_ADD_VALIDATION_MESSAGE", FileType.element));
	By txtValidationMessageInEdit = By.id(readJSFile("INPUT_PARAMETER_EDIT_VALIDATION_MESSAGE", FileType.element));
	By drpFieldName = By.xpath("(//*[contains(@id,'" + readJSFile("INPUT_PARAMETER_ADD_CHILDFIELD", FileType.element)
			+ "')]//*[@class='ant-select-arrow'])[last()]");
	String IsYes = "Yes";
	By btnChildFieldAdd = By.xpath(
			"//*[@class='custom-table has-btn has-textbox']//button[@type='button' and @class='ant-btn ant-btn-primary']");
	By drpChildField = By.xpath(
			"(//*[contains(@id,'" + readJSFile("INPUT_PARAMETER_ADD_CHILDFIELD", FileType.element) + "')])[last()]");
	By drpChildFieldInEdit = By.xpath(
			"(//*[contains(@id,'" + readJSFile("INPUT_PARAMETER_EDIT_CHILDFIELD", FileType.element) + "')])[last()]");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_PARAMETER_EDIT_DESCRIPTION", FileType.element));
	By clickChildFieldText = By
			.xpath("//*[normalize-space(text())='" + readJSFile("parameter.label.childfield", FileType.label) + "']");
	By drpUsedBy = By.xpath("//*[@id='inputParameterAddUsedBy']//*[@class='ant-select-arrow']");
	By drpUsedByInSearch = By.xpath(
			"//*[normalize-space(text())='Used By']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpValueSource = By.xpath("//*[@id='inputParameterAddValueSource']//*[@class='ant-select-arrow']");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 17/07/2019
	 */
	public PlatformConfigurationParameterWeb(WebDriver driver) {
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
		commonWait();
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectFieldType(String fieldType) {
		clickOnElement(drpFieldType);
		clickOnElement(By.xpath("//*[normalize-space(text())='" + fieldType + "']"));
	}

	public void selectUsedBy(String usedBy) {
		clickOnElement(drpUsedBy);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + usedBy.trim() + "']"));
	}

	public void selectComponentType(String componentType) {
		clickOnElement(drpComponentType);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + componentType + "']"));
	}

	public void sendTextInPossibleValue(String possibleValue) {
		sendTextInTextBox(txtPossibleValue, possibleValue);
	}

	public void sendTextInPossibleValueInEdit(String possibleValue) {
		clearAndSendTextInTextBox(txtPossibleValueInEdit, possibleValue);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_PARAMETER_ADD_STATUS", FileType.element)
				+ "']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_PARAMETER_EDIT_STATUS", FileType.element)
				+ "']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void selectDataType(String dataType) {
		clickOnElement(drpDataType);
		clickOnElement(By.xpath("//*[normalize-space(text())='" + dataType + "']"));
	}

	public void selectDataTypeInEdit(String dataType) {
		clickOnElement(drpDataTypeInEdit);
		clickOnElement(By.xpath("//*[normalize-space(text())='" + dataType + "']"));
	}

	public void sendTextInRegEx(String regEx) {
		clearAndSendTextInTextBox(txtRegEx, regEx);
	}

	public void sendTextInRegExInEdit(String regEx) {
		clearAndSendTextInTextBox(txtRegExInEdit, regEx);
	}

	public void sendTextInValidationMessage(String validationMessage) {
		clearAndSendTextInTextBox(txtValidationMessage, validationMessage);
	}

	public void sendTextInValidationMessageInEdit(String validationMessage) {
		clearAndSendTextInTextBox(txtValidationMessageInEdit, validationMessage);
	}

	public void selectFieldName(String fieldName) {
		clickOnElement(drpFieldName);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + fieldName.trim() + "'])[last()]"));
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'"
					+ readJSFile("INPUT_PARAMETER_ADD_CHILDFIELDMANDATORY", FileType.element) + "')])[last()]"));
		}
	}

	public void selectIsEditable(String isEditable) {
		if (isEditable.equalsIgnoreCase(IsYes)) {
			clickOnElement(By.xpath("(//*[contains(@id,'"
					+ readJSFile("INPUT_PARAMETER_ADD_CHILDFIELDEDITABLE", FileType.element) + "')])[last()]"));
		}
	}

	public void clickOnChildFieldAdd() {
		clickOnElement(btnChildFieldAdd);
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

	public void selectUsedByInFilterSearch(String usedBy) {
		clickOnElement(drpUsedByInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + usedBy.trim() + "'])[last()]"));
	}

	public void clickOnChildText() {
		clickOnElement(clickChildFieldText);
	}

	public void selectValueSource(String valueSource) {
		clickOnElement(drpValueSource);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + valueSource + "'])[last()]"));
	}

	public void sendTextInPossibleValueInDropdown(String possibleValue) {
		sendTextInTextBox(By.xpath("(//*[@id='inputParameterAddPossiblevalue'])[last()]"), possibleValue);
	}

	public void filterSearch(String str1, String str2, String str3, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInNameFilterSearch(str1);
		selectUsedByInFilterSearch(str3);
		selectStatusInFilterSearch(str2);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addParameter Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 22/07/2019
	 */
	public void addParameter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(),
				map.get(mapKeys.get(15)).toString(), true);
		commonWait();
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectUsedBy(map.get(mapKeys.get(15)).toString());
			selectFieldType(map.get(mapKeys.get(3)).toString());
			if (map.get(mapKeys.get(3)).toString().toLowerCase().equals("base")) {
				selectComponentType(map.get(mapKeys.get(4)).toString());
				switch (map.get(mapKeys.get(4)).toString().toLowerCase()) {
				case "textbox":
					selectDataType(map.get(mapKeys.get(5)).toString());
					if (!map.get(mapKeys.get(6)).toString().equals("")) {
						sendTextInRegEx(map.get(mapKeys.get(6)).toString());
					}
					if (!map.get(mapKeys.get(7)).toString().equals("")) {
						sendTextInValidationMessage(map.get(mapKeys.get(7)).toString());
					}
					break;
				case "dropdown":
					selectValueSource(map.get(mapKeys.get(16)).toString());
					if (map.get(mapKeys.get(16)).toString().trim().toLowerCase().equals("parameter")) {
						int rows = Integer.parseInt(map.get(mapKeys.get(10)).toString());
						String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
						String[] ismandatory = map.get(mapKeys.get(12)).toString().split(",");
						String[] isEditable = map.get(mapKeys.get(13)).toString().split(",");
						for (int m = 0; m < rows; m++) {
							selectFieldName(fieldNameList[m].trim());
							if (m > 0) {
								selectIsMandatory(ismandatory[m].trim());
								selectIsEditable(isEditable[m].trim());
							}
							if (m < rows - 1) {
								clickOnChildFieldAdd();
							}
						}
					} else {
						sendTextInPossibleValueInDropdown(map.get(mapKeys.get(9)).toString());
					}
					break;
				case "checkbox":
					String[] checkchildFieldList = map.get(mapKeys.get(8)).toString().split(",");
					clickOnElement(drpChildField);
					for (int i = 0; i < checkchildFieldList.length; i++) {
						selectChildField(checkchildFieldList[i].trim());
					}
					clickOnChildText();
					break;
				case "radiobutton":
					String[] radioFieldList = map.get(mapKeys.get(8)).toString().split(",");
					clickOnElement(drpChildField);
					for (int i = 0; i < radioFieldList.length; i++) {
						selectChildField(radioFieldList[i].trim());
					}
					clickOnChildText();
					break;
				case "label":
					sendTextInPossibleValue(map.get(mapKeys.get(9)).toString());
					break;
				case "datepicker":
					break;
				case "fileselector":
					if (!map.get(mapKeys.get(6)).toString().equals("")) {
						sendTextInRegEx(map.get(mapKeys.get(6)).toString());
					}
					sendTextInValidationMessage(map.get(mapKeys.get(7)).toString());
					break;
				case "hyperlink":
					sendTextInPossibleValue(map.get(mapKeys.get(9)).toString());
					break;
				case "password":
					selectDataType(map.get(mapKeys.get(5)).toString());
					if (!map.get(mapKeys.get(6)).toString().equals("")) {
						sendTextInRegEx(map.get(mapKeys.get(6)).toString());
					}
					sendTextInValidationMessage(map.get(mapKeys.get(7)).toString());
					break;
				}
			} else {
				int rows = Integer.parseInt(map.get(mapKeys.get(10)).toString());
				String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
				String[] ismandatory = map.get(mapKeys.get(12)).toString().split(",");
				String[] isEditable = map.get(mapKeys.get(13)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					selectFieldName(fieldNameList[m].trim());
					if (m > 0) {
						selectIsMandatory(ismandatory[m].trim());
						selectIsEditable(isEditable[m].trim());
					}
					if (m < rows - 1) {
						clickOnChildFieldAdd();
					}
				}
			}
			selectStatus(map.get(mapKeys.get(14)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedParameter(Map<Object, Object> map, List<Object> mapKeys) {
		commonWait();
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By FieldType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.fieldtype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By usedBy = By
				.xpath("//*[normalize-space(text()) = 'Used By']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(15)).toString() + "']");
		By ComponentType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.componenttype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		By DataType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.datatype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(5)).toString() + "']");
		By RegEx = By.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.regex", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(6)).toString() + "']");
		By ValidationMessage = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("parameter.label.validationmessage", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");
		By PossibleValue = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.possiblevalue", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(9)).toString() + "']");
		By ChildField = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.childfield", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(8)).toString() + "']");
		By ValueSource = By
				.xpath("//*[normalize-space(text()) = 'Value Source']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(16)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(),
				map.get(mapKeys.get(15)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			if (!verifyElement(name, true))
				return false;
			if (!verifyElement(description, true))
				return false;
			if (!verifyElement(usedBy, true))
				return false;
			if (!verifyElement(FieldType, true))
				return false;
			if (map.get(mapKeys.get(3)).toString().toLowerCase().equals("base")) {
				if (!verifyElement(ComponentType, true))
					return false;
				switch (map.get(mapKeys.get(4)).toString().toLowerCase()) {
				case "textbox":
					if (!verifyElement(DataType, true))
						return false;
					if (!map.get(mapKeys.get(3)).toString().trim().equals("")) {
						if (!verifyElement(RegEx, true))
							return false;
					}
					if (!verifyElement(ValidationMessage, true))
						return false;
					break;
				case "dropdown":
					if (!verifyElement(ValueSource, true))
						return false;
					if (map.get(mapKeys.get(16)).toString().trim().toLowerCase().equals("parameter")) {
						String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
						for (int m = 0; m < fieldNameList.length; m++) {
							if (!verifyElement(By.xpath("//*[normalize-space(text()) = '" + fieldNameList[m] + "']"),
									true)) {
								return false;
							}
						}
					} else {
						if (!verifyElement(PossibleValue, true))
							return false;
					}
					break;
				case "checkbox":
					if (!verifyElement(ChildField, true))
						return false;

					break;
				case "radiobutton":
					if (!verifyElement(ChildField, true))
						return false;
					break;
				case "label":
					if (!verifyElement(PossibleValue, true))
						return false;
					break;
				case "datepicker":
					break;
				case "fileselector":
					if (!map.get(mapKeys.get(3)).toString().trim().equals("")) {
						if (!verifyElement(RegEx, true))
							return false;
					}
					if (!verifyElement(ValidationMessage, true))
						return false;
					break;
				case "hyperlink":
					if (!verifyElement(PossibleValue, true))
						return false;
					break;
				case "password":
					if (!verifyElement(DataType, true))
						return false;
					if (!map.get(mapKeys.get(3)).toString().trim().equals("")) {
						if (!verifyElement(RegEx, true))
							return false;
					}
					if (!verifyElement(ValidationMessage, true))
						return false;
					break;
				}
			} else {
				String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
				for (int m = 0; m < fieldNameList.length; m++) {
					if (!verifyElement(By.xpath("//*[normalize-space(text()) = '" + fieldNameList[m] + "']"), true)) {
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create addParameter Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 22/07/2019
	 */
	public void editParameter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(15)).toString(),
				map.get(mapKeys.get(16)).toString(), true);
		commonWait();
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			if (map.get(mapKeys.get(3)).toString().toLowerCase().equals("base")) {
				switch (map.get(mapKeys.get(4)).toString().toLowerCase()) {
				case "textbox":
					selectDataTypeInEdit(map.get(mapKeys.get(5)).toString());
					if (!map.get(mapKeys.get(6)).toString().equals("")) {
						sendTextInRegExInEdit(map.get(mapKeys.get(6)).toString());
					}
					sendTextInValidationMessageInEdit(map.get(mapKeys.get(7)).toString());
					break;
				case "dropdown":
					if (!map.get(mapKeys.get(10)).toString().equals("")) {
						int rows = Integer.parseInt(map.get(mapKeys.get(10)).toString());
						String[] removeFieldNameList = map.get(mapKeys.get(11)).toString().split(",");
						String[] fieldNameList = map.get(mapKeys.get(12)).toString().split(",");
						String[] ismandatory = map.get(mapKeys.get(13)).toString().split(",");
						String[] isEditable = map.get(mapKeys.get(14)).toString().split(",");
						if (!map.get(mapKeys.get(11)).toString().equals("")) {
							for (int j = 0; j < removeFieldNameList.length; j++) {
								clickOnElement(By.xpath("//*[normalize-space(text())='" + removeFieldNameList[j].trim()
										+ "']//ancestor  :: div[@class='ant-row ant-form-item']//parent :: td//following-sibling :: td//*[contains(@class,'ant-btn deleteBtn')]"));
							}
						}
						for (int m = 0; m < rows; m++) {
							clickOnChildFieldAdd();
							selectFieldName(fieldNameList[m].trim());
							selectIsMandatory(ismandatory[m].trim());
							selectIsEditable(isEditable[m].trim());
						}
					}
					break;
				case "checkbox":
					String[] checkchildFieldList = map.get(mapKeys.get(8)).toString().split(",");
					clickOnElement(drpChildFieldInEdit);
					for (int i = 0; i < checkchildFieldList.length; i++) {
						selectChildField(checkchildFieldList[i].trim());
					}
					break;
				case "radiobutton":
					String[] radioFieldList = map.get(mapKeys.get(8)).toString().split(",");
					clickOnElement(drpChildFieldInEdit);
					for (int i = 0; i < radioFieldList.length; i++) {
						selectChildField(radioFieldList[i].trim());
					}
					break;
				case "label":
					sendTextInPossibleValueInEdit(map.get(mapKeys.get(9)).toString());
					break;
				case "datepicker":
					break;
				case "fileselector":
					if (!map.get(mapKeys.get(6)).toString().equals("")) {
						sendTextInRegExInEdit(map.get(mapKeys.get(6)).toString());
					}
					sendTextInValidationMessageInEdit(map.get(mapKeys.get(7)).toString());
					break;
				case "hyperlink":
					sendTextInPossibleValueInEdit(map.get(mapKeys.get(9)).toString());
					break;
				case "password":
					selectDataTypeInEdit(map.get(mapKeys.get(5)).toString());
					if (!map.get(mapKeys.get(6)).toString().equals("")) {
						sendTextInRegEx(map.get(mapKeys.get(6)).toString());
					}
					sendTextInValidationMessageInEdit(map.get(mapKeys.get(7)).toString());
					break;
				}
			} else {
				int rows = Integer.parseInt(map.get(mapKeys.get(10)).toString());
				String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
				String[] ismandatory = map.get(mapKeys.get(12)).toString().split(",");
				String[] isEditable = map.get(mapKeys.get(13)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					selectFieldName(fieldNameList[m].trim());
					if (m > 0) {
						selectIsMandatory(ismandatory[m].trim());
						selectIsEditable(isEditable[m].trim());
					}
					if (m < rows - 1) {
						clickOnChildFieldAdd();
					}
				}
			}
			selectStatusInEdit(map.get(mapKeys.get(17)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedParameter(Map<Object, Object> map, List<Object> mapKeys) {
		commonWait();
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By FieldType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.fieldtype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By ComponentType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.componenttype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		By DataType = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.datatype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(5)).toString() + "']");
		By RegEx = By.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.regex", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(6)).toString() + "']");
		By ValidationMessage = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("parameter.label.validationmessage", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");
		By PossibleValue = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.possiblevalue", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(9)).toString() + "']");
		By ChildField = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("parameter.label.childfield", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(8)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(17)).toString(),
				map.get(mapKeys.get(16)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			if (!verifyElement(description, true))
				return false;
			if (!verifyElement(FieldType, true))
				return false;
			if (map.get(mapKeys.get(3)).toString().toLowerCase().equals("base")) {
				if (!verifyElement(ComponentType, true))
					return false;
				switch (map.get(mapKeys.get(4)).toString().toLowerCase()) {
				case "textbox":
					if (!verifyElement(DataType, true))
						return false;
					if (!map.get(mapKeys.get(6)).toString().trim().equals("")) {
						if (!verifyElement(RegEx, true))
							return false;
					}
					if (!verifyElement(ValidationMessage, true))
						return false;
					break;
				case "dropdown":
					String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
					for (int m = 0; m < fieldNameList.length; m++) {
						if (!verifyElement(By.xpath("//*[normalize-space(text()) = '" + fieldNameList[m] + "']"),
								true)) {
							return false;
						}
					}
					break;
				case "checkbox":
					if (!verifyElement(ChildField, true))
						return false;

					break;
				case "radiobutton":
					if (!verifyElement(ChildField, true))
						return false;
					break;
				case "label":
					if (!verifyElement(PossibleValue, true))
						return false;
					break;
				case "datepicker":
					break;
				case "fileselector":
					if (!map.get(mapKeys.get(3)).toString().trim().equals("")) {
						if (!verifyElement(RegEx, true))
							return false;
					}
					if (!verifyElement(ValidationMessage, true))
						return false;
					break;
				case "hyperlink":
					if (!verifyElement(PossibleValue, true))
						return false;
					break;
				case "password":
					if (!verifyElement(DataType, true))
						return false;
					if (!map.get(mapKeys.get(6)).toString().trim().equals("")) {
						if (!verifyElement(RegEx, true))
							return false;
					}
					if (!verifyElement(ValidationMessage, true))
						return false;
					break;
				}
			} else {
				String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
				for (int m = 0; m < fieldNameList.length; m++) {
					if (!verifyElement(By.xpath("//*[normalize-space(text()) = '" + fieldNameList[m] + "']"), true)) {
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create DeleteParameter Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 05/10/2018
	 */
	public boolean deleteParameter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			delete();
			return true;
		} else {
			String string = "Parameter already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedParameter Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 05/10/2019
	 */
	public boolean verifyDeletedParameter(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
					map.get(mapKeys.get(3)).toString(), true);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}

	public boolean sortParameter(Map<Object, Object> map, List<Object> mapKeys) {
		clickOnElement(By.xpath("(//*[text()='Parameter'])[1]"));
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
