package com.panamax.base;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;
import com.panamax.init.Common.FileType;
import com.panamax.init.ConstantsFile;

public class BusinessConfigurationBusinessZoneWeb extends Common {
	By txtBusinessZoneName = By.id("form_in_modal_inputBusinesszoneAddName");
	By txtNameInSearch = By.id("search");
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");
	By btnOk = By.xpath("//*[normalize-space(text()) = '" + ConstantsFile.BUSINESSZONE_OK + "']//parent::button");
	By btnSave = By.xpath("//*[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_SAVE + "']//parent::button");

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 24/09/2019
	 */
	public BusinessConfigurationBusinessZoneWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInBusinessZoneName(String name) {
		sendTextInTextBox(txtBusinessZoneName, name);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath("//*[@id='form_in_modal_inputBusinesszoneAddStatus']//span[normalize-space(text())='"
				+ status.trim() + "']"));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath("//*[@id='form_in_modal_inputBusinesszoneEditStatus']//span[normalize-space(text())='"
				+ status.trim() + "']"));
	}

	public void sendTextInBusinessZoneNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void selectField(String field) {
		clickOnElement(drpSelection);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + field.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1) {
		clickOnElement(By.xpath("//*[contains(@class,'anticon-reload')]//parent::button"));
		sendTextInBusinessZoneNameFilterSearch(str1);
		clickOnElement(By.xpath("//*[contains(@class,'anticon-search')]//parent::button"));
	}

	public void clickOnBusinessZoneAddIcon(String parentBusinessZone) {
		commonWait();
		filterSearch(parentBusinessZone);
		clickOnElement(By.xpath("//*[normalize-space(text())='" + parentBusinessZone
				+ "']//ancestor::div[contains(@class,'business-zone')]//div[contains(@class,'action-button')]//button[1]"));
	}

	public void selectBusinessZone() {
		clickOnElement(By.xpath("(//*[normalize-space(text())='Select']//parent::button)[last()]"));
		clickOnElement(By
				.xpath("(//li[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_ADDBUSINESSZONE + "'])[last()]"));
	}

	public void clickOnViewDetail() {
		clickOnElement(By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]"));
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_VIEW + "'])[last()]"));
	}

	public void clickOnEditDetail() {
		clickOnElement(By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]"));
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + ConstantsFile.BUSINESSZONE_EDIT + "'])[last()]"));
	}

	public void clickOnBusinessZoneDelete(String businessZone) {
		commonWait();
		clickOnElement(By.xpath("//*[normalize-space(text())='" + businessZone
				+ "']//ancestor::div[contains(@class,'business-zone')]//div[contains(@class,'action-button')]//button[3]"));
		clickOnDeleteConfirm();
	}

	/**
	 * @author shivani.patel Create addBusinessZone Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void addBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (!verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnElement(By.xpath("//*[contains(@class,'anticon-reload')]//parent::button"));
			clickOnBusinessZoneAddIcon(map.get(mapKeys.get(2)).toString());
			selectBusinessZone();
			sendTextInBusinessZoneName(map.get(mapKeys.get(1)).toString());
			selectStatus(map.get(mapKeys.get(3)).toString());
			clickOnElement(btnSave);
		}
	}

	public boolean verifyAddedBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("businesszone.grid.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("businesszone.grid.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(3)).toString() + "']");

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
			clickOnElement(btnOk);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create addBusinessZone Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void editBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnEditDetail();
			commonWait();
			commonWait();
			selectStatusInEdit(map.get(mapKeys.get(4)).toString());
			clickOnElement(btnSave);
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("businesszone.grid.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(4)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnViewDetail();
			commonWait();
			commonWait();
			if (!verifyElement(status, false))
				return false;
			clickOnElement(btnOk);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create DeleteBusinessZone Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean deleteBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false)) {
			clickOnBusinessZoneDelete(map.get(mapKeys.get(1)).toString());
			return true;
		} else {
			String string = "BusinessZone already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedBusinessZone Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean verifyDeletedBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		return verifyElement(By.xpath("//*[text()='" + map.get(getMapKeys(map).get(1)).toString() + "']"), false);

	}
}
