package com.panamax.base;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class OperationAddMoneyWeb extends Common {
	By txtFromUserName = By.id("inputEmoneyAddFromUserName");
	By txtToUserName = By.id("inputEmoneyAddToUserName");
	By drpFromWallet = By.xpath("//*[@id='inputEmoneyAddFromWallet']//*[@class='ant-select-arrow']");
	By drpToWallet = By.xpath("//*[@id='inputEmoneyAddToWallet']//*[@class='ant-select-arrow']");
	By drpFromPouch = By.xpath("//*[@id='inputEmoneyAddFromPouch']//*[@class='ant-select-arrow']");
	By drpToPouch = By.xpath("//*[@id='inputEmoneyAddToPouch']//*[@class='ant-select-arrow']");
	By txtAmount = By.id("inputEmoneyAddAmount");
	By drpService = By.xpath("//*[@id='inputEmoneyAddService']//*[@class='ant-select-arrow']");
	By drpProduct = By.xpath("//*[@id='inputEmoneyAddProduct']//*[@class='ant-select-arrow']");
	By txtRemark = By.id("inputEmoneyAddRemark");

	By txtDescription = By.id("inputReporttoolAddSrNo");
	By drpFieldType = By.xpath("//*[@id='inputAddMoneyAddFieldtype']//*[@class='ant-select-arrow']");
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
	public OperationAddMoneyWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInFromUserName(String name) {
		sendTextInTextBox(txtFromUserName, name);
	}

	public void sendTextInToUserName(String name) {
		sendTextInTextBox(txtToUserName, name);
	}

	public void sendTextInAmount(String amount) {
		sendTextInTextBox(txtAmount, amount);
	}

	public void selectFromWallet(String wallet) {
		clickOnElement(drpFromWallet);
		clickOnElement(By.xpath("//*[normalize-space(text())='" + wallet + "']"));
	}

	public void selectToWallet(String wallet) {
		clickOnElement(drpToWallet);
		clickOnElement(By.xpath("(//*[text()='" + wallet + "'])[last()]"));
	}

	public void selectFromPouch(String pouch) {
		clickOnElement(drpFromPouch);
		clickOnElement(By.xpath("//*[normalize-space(text())='" + pouch + "']"));
	}

	public void selectToPouch(String pouch) {
		clickOnElement(drpToPouch);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + pouch + "'])[last()]"));
	}

	public void selectService(String service) {
		clickOnElement(drpService);
		clickOnElement(By.xpath("//*[normalize-space(text())='" + service + "']"));
	}

	public void selectProduct(String product) {
		clickOnElement(drpProduct);
		clickOnElement(By.xpath("(//*[normalize-space(text())='" + product + "'])[last()]"));
	}

	public void sendTextInRemark(String remark) {
		sendTextInTextBox(txtRemark, remark);
	}

	/**
	 * @author shivani.patel Create addAddMoney Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 22/07/2019
	 */
	public void addAddMoney(Map<Object, Object> map, List<Object> mapKeys) {
		sendTextInFromUserName(map.get(mapKeys.get(1)).toString());
		selectFromWallet(map.get(mapKeys.get(2)).toString());
		selectFromPouch(map.get(mapKeys.get(3)).toString());
		sendTextInToUserName(map.get(mapKeys.get(4)).toString());
		selectToWallet(map.get(mapKeys.get(5)).toString());
		selectToPouch(map.get(mapKeys.get(6)).toString());
		sendTextInAmount(map.get(mapKeys.get(7)).toString());
		selectService(map.get(mapKeys.get(8)).toString());
		selectProduct(map.get(mapKeys.get(9)).toString());
		sendTextInRemark(map.get(mapKeys.get(10)).toString());
		clickOnSaveBtn();
	}
}
