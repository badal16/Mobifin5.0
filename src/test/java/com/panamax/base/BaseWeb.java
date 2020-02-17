package com.panamax.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.panamax.init.Common;
import com.panamax.init.ConstantsFile;

public class BaseWeb extends Common {
	By platformConfiguration = By.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='"
			+ ConstantsFile.PLATFORM_CONFIGURATION + "']");
	By parameter = By.id(readJSFile("module.name.parameter", FileType.label));
	By KYC = By.id("Kyc");
	By userCategory = By.id(readJSFile("role.label.usercategory", FileType.label));
	By wallet = By.id(readJSFile("module.name.wallet", FileType.label));
	By unit = By.id("Unit");
	By pouch = By.id(readJSFile("module.name.pouch", FileType.label));
	By service = By.id("Service");
	By accessChannel = By.id(readJSFile("module.name.accesschannel", FileType.label));
	By UCP = By.id("Ucp");
	By counter = By.id(readJSFile("module.name.counter", FileType.label));
	By rule = By.id(readJSFile("module.name.rule", FileType.label));
	By product = By.id("Product");
	By productGroup = By.id(readJSFile("module.name.productgroup", FileType.label));
	By notificationTemplate = By.id(readJSFile("module.name.notificationtemplate", FileType.label));
	By exchnageRateManager = By.id(readJSFile("module.name.exchangeratemanager", FileType.label));
	By operatorConfiguration = By
			.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Operator Config']");
	By role = By.id(readJSFile("module.name.role", FileType.label));
	By systemOperatorEntity = By.id(readJSFile("module.name.systemoperatorentity", FileType.label));
	By systemOperatorOnboarding = By.id("System Operator Onboarding");
	By businessConfiguration = By
			.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Business Config']");
	By vendorManagement = By.id(readJSFile("module.name.vendormanagement", FileType.label));
	By serviceVendor = By.id(readJSFile("module.name.servicevendor", FileType.label));
	By notification = By.id(readJSFile("module.name.notification", FileType.label));
	By serviceProfile = By.id(readJSFile("module.name.serviceprofile", FileType.label));
	By productManagement = By.id(readJSFile("module.name.productmanagement", FileType.label));
	By businessZone = By.id("Business Hierarchy");
	By technicalVendor = By.id(readJSFile("module.name.technicalvendor", FileType.label));
	By walletTemplate = By.id("Wallet Template");
	By operation = By.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Operation']");
	By reportTool = By.id("Report Tool");
	By technicalConfig = By
			.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Technical Config']");
	By addMoney = By.id("Add Money");
	By process = By.id("Process");
	By scheduler = By.id("Scheduler");
	By processScheduler = By.id("Process Scheduler");
	By processRunDetails = By.id("Process Run Details");

	public BaseWeb() {
		this.driver = driver;
	}

	/**
	 * @author shivani.patel To click on platform configuration
	 * @creation date 17/07/2019
	 */
	public void clickOnPlateformConfiguration() {
		commonWait();
		clickOnElement(platformConfiguration);
	}

	/**
	 * @author shivani.patel To click on Parameter Directly
	 * @creation date 18/10/2018
	 */
	public PlatformConfigurationParameterWeb clickOnPlateformConfigurationParameter() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(parameter);
		commonWait(10);
		return new PlatformConfigurationParameterWeb(driver);
	}

	/**
	 * @author shivani.patel To click on KYC Directly
	 * @creation date 18/10/2018
	 */
	public PlatformConfigurationKYCWeb clickOnPlateformConfigurationKYC() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(KYC);
		commonWait();
		return new PlatformConfigurationKYCWeb(driver);
	}

	/**
	 * @author shivani.patel To click on UserCategory Directly
	 * @creation date 18/10/2018
	 */
	public PlatformConfigurationUserCategoryWeb clickOnPlateformConfigurationUserCategory() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(userCategory);
		commonWait();
		return new PlatformConfigurationUserCategoryWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Wallet Directly
	 * @creation date 18/10/2018
	 */
	public PlatformConfigurationWalletWeb clickOnPlateformConfigurationWallet() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(wallet);
		commonWait();
		return new PlatformConfigurationWalletWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Unit Directly
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationUnitWeb clickOnPlateformConfigurationUnit() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(unit);
		commonWait();
		return new PlatformConfigurationUnitWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Unit Directly
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationPouchWeb clickOnPlateformConfigurationPouch() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(pouch);
		commonWait();
		return new PlatformConfigurationPouchWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Service Directly
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationServiceWeb clickOnPlateformConfigurationService() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(service);
		return new PlatformConfigurationServiceWeb(driver);
	}

	/**
	 * @author shivani.patel To click on AccessChannel Directly
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationAccessChannelWeb clickOnPlateformConfigurationAccessChannel() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(accessChannel);
		commonWait();
		return new PlatformConfigurationAccessChannelWeb(driver);
	}

	/**
	 * @author shivani.patel To click on UCp Directly
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationUcpWeb clickOnPlateformConfigurationUcp() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(UCP);
		return new PlatformConfigurationUcpWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Counter Directly
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationCounterWeb clickOnPlateformConfigurationCounter() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(counter);
		return new PlatformConfigurationCounterWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Rule Directly
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationRuleWeb clickOnPlateformConfigurationRule() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(rule);
		return new PlatformConfigurationRuleWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Product Directly
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationProductWeb clickOnPlateformConfigurationProduct() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(product);
		return new PlatformConfigurationProductWeb(driver);
	}

	/**
	 * @author shivani.patel To click on ProductGroup Directly
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationProductGroupWeb clickOnPlateformConfigurationProductGroup() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(productGroup);
		return new PlatformConfigurationProductGroupWeb(driver);
	}

	/**
	 * @author shivani.patel To click on NotificationTemplate Directly
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationNotificationTemplateWeb clickOnPlateformConfigurationNotificationTemplate() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(notificationTemplate);
		return new PlatformConfigurationNotificationTemplateWeb(driver);
	}

	/**
	 * @author shivani.patel To click on ExchangeRateManager Directly
	 * @creation date 30/07/2019
	 */
	public PlatformConfigurationExchangeRateManagerWeb clickOnPlateformConfigurationExchangeRateManager() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(exchnageRateManager);
		return new PlatformConfigurationExchangeRateManagerWeb(driver);
	}

	/**
	 * @author shivani.patel To click on operator configuration
	 * @creation date 23/07/2019
	 */
	public void clickOnOperatorConfig() {
		commonWait();
		commonWait();
		clickOnElement(operatorConfiguration);
	}

	/**
	 * @author shivani.patel To click on Role Directly
	 * @creation date 18/10/2018
	 */
	public OperatorConfigRoleWeb clickOnOperatorConfigRole() {
		commonWait();
		clickOnOperatorConfig();
		clickOnElement(role);
		return new OperatorConfigRoleWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Role Directly
	 * @creation date 18/10/2018
	 */
	public OperatorConfigSystemOperatorEntityWeb clickOnOperatorConfigSystemOperatorEntity() {
		commonWait();
		clickOnOperatorConfig();
		clickOnElement(systemOperatorEntity);
		return new OperatorConfigSystemOperatorEntityWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Role Directly
	 * @creation date 18/10/2018
	 */
	public OperatorConfigSystemOperatorOnboardingWeb clickOnOperatorConfigSystemOperatorOnboarding() {
		commonWait();
		clickOnOperatorConfig();
		clickOnElement(systemOperatorOnboarding);
		return new OperatorConfigSystemOperatorOnboardingWeb(driver);
	}

	/**
	 * @author shivani.patel To click on operator configuration
	 * @creation date 23/07/2019
	 */
	public void clickOnBusinessConfig() {
		commonWait();
		clickOnElement(businessConfiguration);
	}

	/**
	 * @author shivani.patel To click on service vendor Directly
	 * @creation date 18/10/2018
	 */
	public BusinessConfigurationServiceVendorWeb clickOnBusinessConfigServiceVendor() {
		commonWait();
		commonWait();
		commonWait();
		commonWait();

		clickOnBusinessConfig();
		Actions actions = new Actions(driver);
		/*
		 * WebElement businessConfig = driver.findElement(By.
		 * xpath("//*[normalize-space(text())='Business Config']"));
		 * actions.moveToElement(businessConfig).build().perform();
		 */
		commonWait();
		WebElement vendorManagement = driver.findElement(By.xpath("//*[normalize-space(text())='Vendor Management']"));
		actions.moveToElement(vendorManagement).build().perform();
		/*
		 * WebElement ServiceVendor = driver.findElement(By.
		 * xpath("//*[normalize-space(text())='Service Vendor']"));
		 * actions.moveToElement(ServiceVendor).build().perform();
		 */
		clickOnElement(serviceVendor);
		return new BusinessConfigurationServiceVendorWeb(driver);
	}

	/**
	 * @author shivani.patel To click on notification Directly
	 * @creation date 18/10/2018
	 */
	public BusinessConfigurationNotificationWeb clickOnBusinessConfigNotification() {
		commonWait();
		clickOnBusinessConfig();
		clickOnElement(notification);
		return new BusinessConfigurationNotificationWeb(driver);
	}

	/**
	 * @author shivani.patel To click on service profile Directly
	 * @creation date 18/10/2018
	 */
	public BusinessConfigurationServiceProfileWeb clickOnBusinessConfigServiceProfile() {
		commonWait();
		clickOnBusinessConfig();
		clickOnElement(serviceProfile);
		return new BusinessConfigurationServiceProfileWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Role Directly
	 * @creation date 18/10/2018
	 */
	public BusinessConfigurationProductManagementWeb clickOnBusinessConfigProductManagement() {
		commonWait();
		clickOnBusinessConfig();
		clickOnElement(productManagement);
		return new BusinessConfigurationProductManagementWeb(driver);
	}

	/**
	 * @author shivani.patel To click on service vendor Directly
	 * @creation date 18/10/2018
	 */
	public BusinessConfigurationTechnicalVendorWeb clickOnBusinessConfigTechnicalVendor() {
		commonWait();
		commonWait();
		commonWait();
		commonWait();
		clickOnBusinessConfig();
		Actions actions = new Actions(driver);
		commonWait();
		WebElement vendorManagement = driver.findElement(By.xpath("//*[normalize-space(text())='Vendor Management']"));
		actions.moveToElement(vendorManagement).build().perform();
		clickOnElement(technicalVendor);
		return new BusinessConfigurationTechnicalVendorWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Role Directly
	 * @creation date 18/10/2018
	 */
	public BusinessConfigurationBusinessZoneWeb clickOnBusinessConfigBusinessZone() {
		commonWait();
		clickOnBusinessConfig();
		clickOnElement(businessZone);
		return new BusinessConfigurationBusinessZoneWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Role Directly
	 * @creation date 18/10/2018
	 */
	public BusinessConfigurationRegionalEntityWeb clickOnBusinessConfigRegionalEntity() {
		commonWait();
		clickOnBusinessConfig();
		clickOnElement(businessZone);
		return new BusinessConfigurationRegionalEntityWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Role Directly
	 * @creation date 18/10/2018
	 */
	public BusinessConfigurationOperatingEntityTemplateWeb clickOnBusinessConfigOperatingEntityTemplate() {
		commonWait();
		clickOnBusinessConfig();
		clickOnElement(businessZone);
		return new BusinessConfigurationOperatingEntityTemplateWeb(driver);
	}

	/**
	 * @author shivani.patel To click on walletTemplate Directly
	 * @creation date 30/07/2019
	 */
	public PlateformConfigurationWalletTemplateWeb clickOnPlateformConfigurationWalletTemplate() {
		commonWait();
		clickOnPlateformConfiguration();
		clickOnElement(walletTemplate);
		return new PlateformConfigurationWalletTemplateWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Role Directly
	 * @creation date 18/10/2018
	 */
	public BusinessConfigurationOperatingEntityWeb clickOnBusinessConfigOperatingEntity() {
		commonWait();
		clickOnBusinessConfig();
		clickOnElement(businessZone);
		return new BusinessConfigurationOperatingEntityWeb(driver);
	}

	/**
	 * @author shivani.patel To click on operation
	 * @creation date 23/07/2019
	 */
	public void clickOnOperation() {
		commonWait();
		clickOnElement(operation);
	}

	/**
	 * @author shivani.patel To click on Role Directly
	 * @creation date 18/10/2018
	 */
	public TechnicalConfigReportToolWeb clickOnTechnicalConfigReportTool() {
		commonWait();
		clickOnTechnicalConfig();
		clickOnElement(reportTool);
		return new TechnicalConfigReportToolWeb(driver);
	}

	/**
	 * @author shivani.patel To click on Role Directly
	 * @creation date 18/10/2018
	 */
	public OperationAddMoneyWeb clickOnOperationAddMoney() {
		commonWait();
		clickOnOperation();
		clickOnElement(addMoney);
		return new OperationAddMoneyWeb(driver);
	}

	/**
	 * @author shivani.patel To click on technical config
	 * @creation date 23/07/2019
	 */
	public void clickOnTechnicalConfig() {
		commonWait();
		commonWait();
		clickOnElement(technicalConfig);
	}

	/**
	 * @author dharti.patel To click on Process
	 * @creation date 18/10/2018
	 */
	public TechnicalConfigProcessWeb clickOnTechnicalConfigProcess() {
		commonWait();
		clickOnTechnicalConfig();
		clickOnElement(process);
		commonWait();
		return new TechnicalConfigProcessWeb(driver);
	}

	/**
	 * @author dharti.patel To click on Scheduler
	 * @creation date 18/10/2018
	 */
	public TechnicalConfigSchedulerWeb clickOnTechnicalConfigScheduler() {
		commonWait();
		clickOnTechnicalConfig();
		clickOnElement(scheduler);
		return new TechnicalConfigSchedulerWeb(driver);
	}

	/**
	 * @author dharti.patel To click on Process Scheduler
	 * @creation date 18/10/2018
	 */
	public TechnicalConfigProcessSchedulerWeb clickOnTechnicalConfigProcessScheduler() {
		commonWait();
		clickOnTechnicalConfig();
		clickOnElement(processScheduler);
		commonWait();
		return new TechnicalConfigProcessSchedulerWeb(driver);
	}

	/**
	 * @author dharti.patel To click on Process Run Details
	 * @creation date 18/10/2018
	 */
	public TechnicalConfigProcessRunDetailsWeb clickOnTechnicalConfigProcessRunDetails() {
		commonWait();
		clickOnTechnicalConfig();
		clickOnElement(processRunDetails);
		commonWait();
		return new TechnicalConfigProcessRunDetailsWeb(driver);
	}
}
