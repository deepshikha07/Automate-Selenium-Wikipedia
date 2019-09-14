package com.selenium.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.selenium.qa.base.TestBase;
import com.selenium.qa.pages.SeleniumWikipage;

public class SeleniumWikiPageTest extends TestBase {
	
	SeleniumWikipage seleniumWikipage;
	//HomePage homePage;
	
	public SeleniumWikiPageTest(){
		super();
	}
	
	@BeforeTest
	public void setUp(){
		initialization();
		seleniumWikipage = new SeleniumWikipage();	
	}
	
	@Test(priority=3)
	public void verifyExternalLinksTest(){
		
	//	seleniumWikipage.verifyExternalLinks();
	}
	@Test(priority=1)
	public void navigaeToOxygenPageTest() {
		seleniumWikipage.navigateToOxypage();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
