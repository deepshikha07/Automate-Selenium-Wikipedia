package com.selenium.qa.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.crm.qa.pages.LoginPage;
import com.selenium.qa.base.TestBase;
import com.selenium.qa.pages.OxygenWikipage;
import com.selenium.qa.pages.SeleniumWikipage;

public class OxygenWikiPageTest extends TestBase {
	OxygenWikipage oxygenWikipage;
	SeleniumWikipage seleniumWikiPage;

	public OxygenWikiPageTest(){
		super();
	}
	
	@BeforeTest
	public void setUp(){
		initialization();
		seleniumWikiPage = new SeleniumWikipage();		
		oxygenWikipage=seleniumWikiPage.navigateToOxypage();
	
	}
	@Test(priority=1)
	public void verifyFeaturedArtTest() {
		
		String oxygen= oxygenWikipage.verifyFeaturedArticle();
		Assert.assertEquals(oxygen, "This is a featured article. Click here for more information.");
	}
	
	@Test(priority=2)
	public void totalReferencePdflinksTest()
	{
		int pdfcount=oxygenWikipage.totalpdflinks();
		System.out.println(pdfcount);
	}
	
	@Test(priority=3)
	public void verifySuggestionTest()
	{
		int count=oxygenWikipage.verifySuggestion();
		assertEquals(count, 2);
	}
	
	@Test(priority=4)
	public void TakeElementSSTest() {
	oxygenWikipage.TakeElementSS();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
