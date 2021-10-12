package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void regPageSetup() {
		registerationPage = loginPage.navigateToRegisterPage();
	}

	public String getRandomNumber() {
		Random random = new Random();
		String email = "testautomation"+random.nextInt(50000)+"@gmail.com";
		return email;
	}
	
	
	@DataProvider
	public Object[][] getRegTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;	
	}

	@Test(dataProvider = "getRegTestData")
	public void registerationTest(String firstname, String lastname, 
						 String telephone, String password,
							String subscribe) {
		Assert.assertTrue(registerationPage.registration(firstname,lastname,getRandomNumber(),telephone,password,subscribe));
	}

}
