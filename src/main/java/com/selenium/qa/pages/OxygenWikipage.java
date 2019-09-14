package com.selenium.qa.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.qa.util.TestUtil;
import com.selenium.qa.base.TestBase;

public class OxygenWikipage extends TestBase{

	TestUtil testutil;
	public String verifyFeaturedArticle()
	{
		TestUtil testutil;
		WebElement articleType =driver.findElement(By.xpath("//*[@id='mw-indicator-featured-star']/a"));
		String arttype= articleType.getAttribute("title");
		return arttype;


	}

	public int totalpdflinks()
	{
		List<WebElement> totallinks= driver.findElements(By.xpath("//*[@id='mw-content-text']/div/div[47]/ol//child::li//a"));
		//*[@id="mw-content-text"]/div/div[47]/ol
		int count=0;
		for (WebElement webElement : totallinks) {
			String link=webElement.getAttribute("href");

			if(link.contains(".pdf"))
			{
				count++;
			}
		}

		return count;
	}

	public Integer verifySuggestion()
	{
		driver.findElement(By.id("searchInput")).sendKeys("Pluto");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> totallinks=  driver.findElements(By.xpath("//*[@class='suggestions']//a"));
		int count=0;
		for (WebElement webElement : totallinks) {
			String suggest=webElement.getAttribute("title");
			System.out.println(suggest);
			count++;
			if(suggest.equals("Plutonium"))
			{
				return count;
			}



		}
		return 0;
	}

	public void TakeElementSS() {
		WebElement element = driver.findElement(By.xpath("//*[@id='mw-content-text']/div/table[1]"));
		try {
			TestUtil.takeScreenshot(element);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
