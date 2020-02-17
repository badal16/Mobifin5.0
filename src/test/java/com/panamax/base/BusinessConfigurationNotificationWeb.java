package com.panamax.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.panamax.init.Common;

public class BusinessConfigurationNotificationWeb extends Common {
	By txtNotificationName = By.id(readJSFile("INPUT_NOTIFICATION_ADD_NAME", FileType.element));
	By txtDescription = By.id(readJSFile("INPUT_NOTIFICATION_ADD_DESCRIPTION", FileType.element));
	By drpNotificationType = By
			.xpath("//*[@id='" + readJSFile("INPUT_NOTIFICATION_ADD_NOTIFICATIONTYPE", FileType.element)
					+ "']//*[@class='ant-select-arrow']");
	String IsYes = "Yes";
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(readJSFile("INPUT_ROLES_EDIT_DESCRIPTION", FileType.element));
	By txtSubject = By.id("inputNotificationAddSubject");
	By txtFromUserName = By.id("inputNotificationAddUsername");
	By txtPassword = By.id("inputNotificationAddPassword");
	By txtCC = By.id("btnNotificationAddCCBtn");
	By txtBCC = By.id("btnNotificationAddBCCBtn");
	By drpNotificationTemplate = By
			.xpath("//*[@id='" + readJSFile("INPUT_NOTIFICATION_ADD_NOTIFICATIONTMP", FileType.element)
					+ "']//*[@class='ant-select-arrow']");
	By drpVendor = By.xpath("//*[@id='" + readJSFile("INPUT_NOTIFICATION_ADD_VENDOR", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By drpVendorService = By.xpath("//*[@id='" + readJSFile("INPUT_NOTIFICATION_ADD_VENDORSERVICE", FileType.element)
			+ "']//*[@class='ant-select-arrow']");
	By btnReceiverAdd = By.id(readJSFile("INPUT_NOTIFICATION_ADD_RECEIVERBTN", FileType.element));

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 24/09/2019
	 */
	public BusinessConfigurationNotificationWeb(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInNotificationName(String name) {
		sendTextInTextBox(txtNotificationName, name);
	}

	public void sendTextInDescription(String description) {
		commonWait();
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtDescription, description);
	}

	public void sendTextInDescriptionInEdit(String description) {
		clearAndSendTextInTextBox(txtDescriptionInEdit, description);
	}

	public void selectNotificationType(String notificationType) {
		clickOnElement(drpNotificationType);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + notificationType + "']"));
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath("//*[@id='" + readJSFile("INPUT_NOTIFICATION_ADD_STATUS", FileType.element)
				+ "']//span[normalize-space(text())='" + status.trim() + "']"));
	}

	public void sendTextInSubject(String subject) {
		commonWait();
		commonWait();
		commonWait();
		commonWait();
		clearAndSendTextInTextBox(txtSubject, subject);
	}

	public void sendTextInFromUserName(String fromUsername) {
		clearAndSendTextInTextBox(txtFromUserName, fromUsername);
	}

	public void sendTextInPassword(String password) {
		clearAndSendTextInTextBox(txtPassword, password);
	}

	public void sendTextInCC(String cc) {
		clearAndSendTextInTextBox(txtCC, cc);
	}

	public void sendTextInBCC(String bcc) {
		clearAndSendTextInTextBox(txtBCC, bcc);
	}

	public void selectNotificationTemplate(String notificationTemplate) {
		clickOnElement(drpNotificationTemplate);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + notificationTemplate + "']"));
	}

	public void selectVendor(String vendor) {
		clickOnElement(drpVendor);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + vendor + "']"));
	}

	public void selectVendorService(String vendorService) {
		clickOnElement(drpVendorService);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + vendorService + "']"));
	}

	public void sendTextInReceiverName(By elemnet, String receiverName) {
		clearAndSendTextInTextBox(elemnet, receiverName);
	}

	public void sendTextInNotificationNameFilterSearch(String name) {
		clearAndSendTextInTextBox(txtNameInSearch, name);
	}

	public void clickOnReceiverAddBtn() {
		clickOnElement(btnReceiverAdd);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + status.trim() + "'])[last()]"));
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']"));
			clickOnElement(By.xpath("//li[normalize-space(text())='Equals']"));
		}
		sendTextInNotificationNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addNotification Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void addNotification(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(), true);
		if (!verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnAddBtn();
			sendTextInNotificationName(map.get(mapKeys.get(1)).toString());
			sendTextInSubject(map.get(mapKeys.get(3)).toString());
			selectNotificationType(map.get(mapKeys.get(2)).toString());
			if (map.get(mapKeys.get(2)).toString().trim().toLowerCase().equals("email")) {
				sendTextInFromUserName(map.get(mapKeys.get(4)).toString());
				//sendTextInPassword(map.get(mapKeys.get(5)).toString());
				sendTextInCC(map.get(mapKeys.get(6)).toString());
				sendTextInBCC(map.get(mapKeys.get(7)).toString());
			}
			sendTextInDescription(map.get(mapKeys.get(8)).toString());
			selectNotificationTemplate(map.get(mapKeys.get(9)).toString());
			selectVendor(map.get(mapKeys.get(10)).toString());
			selectVendorService(map.get(mapKeys.get(11)).toString());
			int rows = Integer.parseInt(map.get(mapKeys.get(12)).toString());
			String[] receiverNameList = map.get(mapKeys.get(13)).toString().split(",");
			for (int m = 0; m < rows; m++) {
				sendTextInReceiverName(By.id("inputNotificationAddReciver[" + m + "]"), receiverNameList[m]);
				if (m < rows - 1) {
					clickOnReceiverAddBtn();
				}
			}
			selectStatus(map.get(mapKeys.get(14)).toString());
			clickOnSaveBtn();
		}
	}

	public boolean verifyAddedNotification(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath("//*[normalize-space(text()) = '" + readJSFile("notification.label.name", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(1)).toString() + "']");
		By notificationType = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("notification.label.notificatontype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By subject = By
				.xpath("//*[normalize-space(text()) = 'Subject']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By fromUserName = By
				.xpath("//*[normalize-space(text()) = 'From UserName']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		By CC = By
				.xpath("//*[normalize-space(text()) = 'CC']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(6)).toString() + "']");
		By BCC = By
				.xpath("//*[normalize-space(text()) = 'BCC']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");
		By notificationTemplate = By.xpath("//*[normalize-space(text()) = '"
				+ readJSFile("notification.label.notificationtemplate", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(9)).toString() + "']");
		By vendor = By.xpath("//*[normalize-space(text()) = '" + readJSFile("notification.label.vendor", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(10)).toString() + "']");
		By vendorService = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("notification.label.vendorservice", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(11)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("notification.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(8)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("role.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(14)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			commonWait();
			if (!verifyElement(name, false))
				return false;
			if (!verifyElement(subject, false))
				return false;
			if (!verifyElement(notificationType, false))
				return false;
			if (map.get(mapKeys.get(2)).toString().trim().toLowerCase().equals("email")) {
				if (!verifyElement(fromUserName, false))
					return false;
				if (!verifyElement(CC, false))
					return false;
				if (!verifyElement(BCC, false))
					return false;
			}
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(notificationTemplate, false))
				return false;
			if (!verifyElement(vendor, false))
				return false;
			if (!verifyElement(vendorService, false))
				return false;
			String[] receiverNameList = map.get(mapKeys.get(13)).toString().split(",");
			for (int m = 0; m < receiverNameList.length; m++) {
				if (!verifyElement(By.xpath(
						"//*[normalize-space(text()) = '" + readJSFile("notification.label.receiver", FileType.label)
								+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
								+ receiverNameList[m].trim() + "')]"),
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
	 * @author shivani.patel Create addNotification Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public void editNotification(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			clickOnEditBtn();
			commonWait();
			commonWait();
			sendTextInSubject(map.get(mapKeys.get(3)).toString());
			selectNotificationType(map.get(mapKeys.get(2)).toString());
			if (map.get(mapKeys.get(2)).toString().trim().toLowerCase().equals("email")) {
				sendTextInFromUserName(map.get(mapKeys.get(4)).toString());
				//sendTextInPassword(map.get(mapKeys.get(5)).toString());
				sendTextInCC(map.get(mapKeys.get(6)).toString());
				sendTextInBCC(map.get(mapKeys.get(7)).toString());
			}
			sendTextInDescription(map.get(mapKeys.get(8)).toString());
			selectNotificationTemplate(map.get(mapKeys.get(9)).toString());
			selectVendor(map.get(mapKeys.get(10)).toString());
			selectVendorService(map.get(mapKeys.get(11)).toString());
			if (!map.get(mapKeys.get(12)).toString().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(12)).toString());
				String[] receiverNameList = map.get(mapKeys.get(13)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					sendTextInReceiverName(By.id("inputNotificationAddReciver[" + m + "]"), receiverNameList[m]);
				}
			}
			selectStatus(map.get(mapKeys.get(15)).toString());
			clickOnSaveBtn();
		} else {
			verifyFalse(true);
		}
	}

	public boolean verifyEditedNotification(Map<Object, Object> map, List<Object> mapKeys) {
		By notificationType = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("notification.label.notificatontype", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(2)).toString() + "']");
		By subject = By
				.xpath("//*[normalize-space(text()) = 'Subject']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(3)).toString() + "']");
		By fromUserName = By
				.xpath("//*[normalize-space(text()) = 'From UserName']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(4)).toString() + "']");
		By CC = By
				.xpath("//*[normalize-space(text()) = 'CC']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(6)).toString() + "']");
		By BCC = By
				.xpath("//*[normalize-space(text()) = 'BCC']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(7)).toString() + "']");
		By notificationTemplate = By.xpath("//*[normalize-space(text()) = '"
				+ readJSFile("notification.label.notificationtemplate", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(9)).toString() + "']");
		By vendor = By.xpath("//*[normalize-space(text()) = '" + readJSFile("notification.label.vendor", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(10)).toString() + "']");
		By vendorService = By.xpath(
				"//*[normalize-space(text()) = '" + readJSFile("notification.label.vendorservice", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(11)).toString() + "']");
		By description = By
				.xpath("//*[normalize-space(text()) = '" + readJSFile("notification.label.description", FileType.label)
						+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
						+ map.get(mapKeys.get(8)).toString() + "']");
		By status = By.xpath("//*[normalize-space(text()) = '" + readJSFile("role.status", FileType.label)
				+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='"
				+ map.get(mapKeys.get(15)).toString() + "']");

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(15)).toString(), true);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			commonWait();
			if (!verifyElement(subject, false))
				return false;
			if (!verifyElement(notificationType, false))
				return false;
			if (map.get(mapKeys.get(2)).toString().trim().toLowerCase().equals("email")) {
				if (!verifyElement(fromUserName, false))
					return false;
				if (!verifyElement(CC, false))
					return false;
				if (!verifyElement(BCC, false))
					return false;
			}
			if (!verifyElement(description, false))
				return false;
			if (!verifyElement(notificationTemplate, false))
				return false;
			if (!verifyElement(vendor, false))
				return false;
			if (!verifyElement(vendorService, false))
				return false;
			String[] receiverNameList = map.get(mapKeys.get(13)).toString().split(",");
			for (int m = 0; m < receiverNameList.length; m++) {
				if (!verifyElement(By.xpath(
						"//*[normalize-space(text()) = '" + readJSFile("notification.label.receiver", FileType.label)
								+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'"
								+ receiverNameList[m].trim() + "')]"),
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
	 * @author shivani.patel Create DeleteNotification Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean deleteNotification(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), false);
		if (verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"), false)) {
			clickOnInfoBtn(map.get(getMapKeys(map).get(1)).toString());
			commonWait();
			commonWait();
			delete();
			return true;
		} else {
			String string = "Notification already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verifyDeletedNotification Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 24/09/2019
	 */
	public boolean verifyDeletedNotification(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyFilterBtn()) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), false);
			return verifyElement(By.xpath("(//td[text()='" + map.get(getMapKeys(map).get(1)).toString() + "'])[1]"),
					false);
		} else {
			return true;
		}
	}

	public boolean sortNotification(Map<Object, Object> map, List<Object> mapKeys) {
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
