package com.qa.stepDefinition;

import org.openqa.selenium.WebDriver;
import com.qa.driverFactory.DriverFactory;
import com.qa.pages.RegistryListPage;
import com.qa.util.CommonMethodUtil;
import com.qa.util.ExcelReaderRandhir;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @authorID Rat105478
 * @authorName RameshRathod
 */
public class AmazonStep {
	private WebDriver driver = DriverFactory.getDriver();
	private CommonMethodUtil util = new CommonMethodUtil(DriverFactory.getDriver());
	
	@Given("validate user click on the registry links")
	public void validate_user_click_on_the_registry_links() throws Throwable {

		CommonMethodUtil.clickElement(RegistryListPage.registryOption, "clicking on registry link");
		Thread.sleep(3000);
	}

	@When("validate user enter registryName")
	public void validate_user_enter_registry_name() throws Throwable {

		CommonMethodUtil.doSendKeys(RegistryListPage.registryName, "Test");
	}

	@Given("validate user hover mouse on SignIn option and click on signIn button")
	public void mouseHover_onSingInbtn() throws Throwable {

		CommonMethodUtil.mouseHover(RegistryListPage.signInMouseHover);

		CommonMethodUtil.clickElement(RegistryListPage.signInbtn, "signIn button click");
	}

	@When("validate user enter userName and password from excel file {string} and click on signIn button")
	public void enter_userName_password(String sheetName) throws Throwable {
		
		/*
		 * List<String> sheetNameList = sheetName.asList(); String listString =""; for
		 * (String sheetnames : sheetNameList) { listString = sheetnames + "\t"; }
		 */
		CommonMethodUtil.doSendKeys(RegistryListPage.email, ExcelReaderRandhir.readvaluefromExcelSheet(sheetName).get(1).get("Username"));
		CommonMethodUtil.clickElement(RegistryListPage.continueBtn, "continue button click");
		CommonMethodUtil.doSendKeys(RegistryListPage.password, ExcelReaderRandhir.readvaluefromExcelSheet(sheetName).get(1).get("Password"));
		CommonMethodUtil.clickElement(RegistryListPage.signInSubmit, "continue button click");

	}

}

