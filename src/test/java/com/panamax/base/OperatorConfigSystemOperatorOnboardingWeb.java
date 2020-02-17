package com.panamax.base;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.panamax.init.Common;

public class OperatorConfigSystemOperatorOnboardingWeb extends Common {
	By txtSystemOperatorEntityName = By.id(
			readJSFile("INPUT_SYSTEMOPERATORENTITY_NAME", FileType.element));
	By drpSystemOperatorEntity = By.xpath(
			"//*[@id='inputSystemOperatorOnBoadingBusinessEntityName']//*[@class='ant-select-arrow']");
	List<String> list = new ArrayList<String>();
	By btnSubmit = By.xpath("//*[contains(@class,'submit')]");
	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 14/10/2019
	 */
	public OperatorConfigSystemOperatorOnboardingWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInStringField(String value, By element) {
		sendTextWithRemoveReadOnlyProperty(value, element);
	}

	public void selectSystemOperatorEntity(String SysOperatorEntity) {
		clickOnElement(drpSystemOperatorEntity);
		clickOnElement(By.xpath(
				"//li[normalize-space(text())='" + SysOperatorEntity + "']"));
	}

	public void selectMultipleField(By element, String value) {
		clickOnElement(element);
		clickOnElement(
				By.xpath("//*[normalize-space(text())='" + value + "']"));
	}

	public void clickOnRadioFeild(By element) {
		clickOnElement(element);
	}

	/**
	 * @author shivani.patel Create addSystemOperatorEntity Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void addSystemOperatorOnboarding(Map<Object, Object> map,
			List<Object> mapKeys) {

		commonWait();
		selectSystemOperatorEntity(map.get(mapKeys.get(1)).toString());
		String[] navigateList = map.get(mapKeys.get(2)).toString().trim()
				.split("/");
		for (int i = 0; i < navigateList.length; i++) {

			// Radio
			if (!(map.get(mapKeys.get(7)).toString()).trim().isEmpty()) {
				String[] CategoryField = map.get(mapKeys.get(7)).toString()
						.split("/");
				String[] CategoryFieldlist = CategoryField[i].split(";");
				for (int j = 0; j < CategoryFieldlist.length; j++) {
					String[] CategoryFeieldSub = CategoryFieldlist[j]
							.split(":");
					clickOnRadioFeild(By.xpath(
							"//div[@class='current-content clearfix']//label[normalize-space(text())='"
									+ CategoryFeieldSub[0].trim()
									+ "']//..//..//div[contains(@class,'radio')]//*[normalize-space(text())='"
									+ CategoryFeieldSub[1].trim() + "']"));
				}

			}

			// MultiSelect
			if (!map.get(mapKeys.get(12)).toString().equals("")) {
				String[] CategoryField = map.get(mapKeys.get(12)).toString()
						.split("/");
				String[] CategoryFeieldSub = CategoryField[i].split(":");
				for (int k = 0; k < CategoryFeieldSub.length; k++) {
					String[] subCategoryField = CategoryFeieldSub[k].split(",");
					for (int j = 0; j < subCategoryField.length; j++) {
						selectMultipleField(By.xpath(
								"//div[@class='current-content clearfix']//label[normalize-space(text())='"
										+ CategoryFeieldSub[0].trim()
										+ "']//..//..//*[contains(@class,'multiple')]//div[contains(@class,'rendered')]//input"),
								subCategoryField[j].trim());
					}
				}
			}

			// String
			if (!map.get(mapKeys.get(4)).toString().equals("")) {
				String[] CategoryField = map.get(mapKeys.get(4)).toString()
						.split(",");
				for (int j = 0; j < CategoryField.length; j++) {
					String[] subCategoryField = CategoryField[j].split(":");
					String value = subCategoryField[0].trim().toUpperCase();

					sendTextInStringField(subCategoryField[1],
							By.xpath("//*[normalize-space(text())='"
									+ subCategoryField[0]
									+ "']//following::input[@type='text' and @id='"
									+ value + "']"));
				}
			}

			// Password
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				String[] CategoryField = map.get(mapKeys.get(5)).toString()
						.split(",");
				for (int j = 0; j < CategoryField.length; j++) {
					String[] subCategoryField = CategoryField[j].split(":");
					String value = subCategoryField[0].trim().toUpperCase();

					sendTextInStringField(subCategoryField[1],
							By.xpath("//*[normalize-space(text())='"
									+ subCategoryField[0]
									+ "']//following::input[@type='password' and @id='"
									+ value + "']"));
				}
			}

			// DropDown
			if (!(map.get(mapKeys.get(6)).toString()).trim().isEmpty()) {
				String[] CategoryField = map.get(mapKeys.get(6)).toString()
						.split("/");
				for (int j = 0; j < CategoryField.length; j++) {
					String[] CategoryFieldlist = CategoryField[j].split(":");
					if (verifyElement(By.xpath(
							"//div[@class='current-content clearfix']//label[normalize-space(text())='"
									+ CategoryFieldlist[0].trim() + "']"))
							&& !list.contains(CategoryFieldlist[0].trim())) {
						clickOnDropdown(By.xpath(
								"//div[@class='current-content clearfix']//label[normalize-space(text())='"
										+ CategoryFieldlist[0].trim()
										+ "']//..//..//span[contains(@class,'select')]"),
								CategoryFieldlist[1].trim());
						list.add(CategoryFieldlist[0].trim());
					}
				}
			}

			// DateOfBirth
			if (!(map.get(mapKeys.get(10)).toString()).trim().isEmpty()) {
				String[] CategoryField = map.get(mapKeys.get(10)).toString()
						.split("/");

				for (int j = 0; j < CategoryField.length; j++) {
					String[] CategoryFieldlist = CategoryField[j].split(":");
					if (verifyElement(By.xpath(
							"//div[@class='current-content clearfix']//label[normalize-space(text())='"
									+ CategoryFieldlist[0].trim() + "']"))
							&& !list.contains(CategoryFieldlist[0].trim())) {
						selectDateOfBirth(CategoryFieldlist[1],
								By.xpath("//*[normalize-space(text())='"
										+ CategoryFieldlist[0].trim()
										+ "']//parent::div//parent::div//span//input[contains(@class,'calendar-picker')]"));
						list.add(CategoryFieldlist[0].trim());
					}
				}
			}

			// file upload
			if (!map.get(mapKeys.get(3)).toString().isEmpty()) {
				String[] CategoryField = map.get(mapKeys.get(3)).toString()
						.split("/");

				String[] CategoryFeieldSub = CategoryField[i].split(":");

				String[] subCategoryField = CategoryFeieldSub[1].split(",");
				for (int j = 0; j < subCategoryField.length; j++) {

					sendFile(CategoryFeieldSub[0].trim(), subCategoryField[j]);
				}

			}

			if (verifyElement(By.xpath("(//*[text()='Next'])[last()]"))) {
				clickOnNextBtn();
			}
		}
		clickOnSubmit();

	}

	public void clickOnDropdown(By element, String value) {
		clickOnElement(element);
		clickOnElement(
				By.xpath("//li[normalize-space(text())='" + value + "']"));
	}

	public void selectDateOfBirth(String value, By element) {
		clickOnElement(element);
		clearAndSendTextInTextBox(By.xpath("//*[@class='ant-calendar-input ']"),
				value);
		clickOnElement(By.xpath("//*[@class='ant-calendar-ok-btn']"));
	}

	public boolean verifyAddedSystemOperatorOnboarding(Map<Object, Object> map,
			List<Object> mapKeys) {
		clickOnElement(drpSystemOperatorEntity);
		if (verifyElement(By.xpath("//li[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']"))) {
			return false;
		}
		return true;

	}

	public void sendFile(String field, String fileName) {

		WebElement file = findVisibleElement(
				By.xpath(".//label[normalize-space(text())='" + field
						+ "']//following::button//*[contains(@class,'anticon anticon-upload')]"));

		resources_folder_path = new File(RESOURCES_FOLDER).getAbsolutePath()
				+ "\\";

		String filedata = resources_folder_path + fileName;
		// file.sendKeys(filedata);

		StringSelection selec = new StringSelection(filedata);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selec, selec);

		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL)
				.perform();
	}

	public void clickOnSubmit() {
		clickOnElement(btnSubmit);
		getStriptText();
		if (verifyToolTip()
				|| verifyElement(By.xpath("//*[text()='error.userexists']"))) {
			clickOnCancelBtn();
		}
	}

}
