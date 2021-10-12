package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1. By Locators - PO - OR
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");

	// 2. page constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. page actions/methods/features:

	@Step("getting login page title....")
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	@Step("getting login page url....")
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	@Step("checking Forgot Pwd link Exist or not....")
	public boolean isForgotPwdlinkExist() {
		return elementUtil.doIsDiplayed(forgotPwdLink);
	}

	@Step("checking register link Exist or not....")
	public boolean isRegisterlinkExist() {
		return elementUtil.doIsDiplayed(registerLink);
	}

	@Step("login with username : {0} and password: {1}")
	public AccountsPage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);
	}
	
	@Step("navigating to register page....")
	public RegisterationPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegisterationPage(driver);
	}

}
