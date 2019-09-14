package com.selenium.qa.pages;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import com.selenium.qa.base.TestBase;

public class SeleniumWikipage extends TestBase {

	

	public void verifyExternalLinks()
	{
		List<WebElement> externallinks;
		externallinks=driver.findElements(By.xpath("//*[@id='mw-content-text']/div/ul[2]//li//a"));
		System.out.println("Number of links is"+externallinks.size());
		for (WebElement webElement : externallinks) {


			String link=webElement.getAttribute("href");
			System.out.println(link);
			try 
			{
				URL url = new URL(link);

				HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();

				httpURLConnect.setConnectTimeout(3000);

				httpURLConnect.connect();

				if(httpURLConnect.getResponseCode()==200)
				{
					System.out.println(link+" - "+httpURLConnect.getResponseMessage());
				}
				if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
				{
					System.out.println(link+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
				}
			} catch (Exception e) {

			}

		}
	}

		public OxygenWikipage navigateToOxypage()
		{
			WebElement oxygenPage=driver.findElement(By.xpath("//td[@class='navbox-list navbox-odd wraplinks']//*[@href='/wiki/Oxygen' and @title='Oxygen']"));
			oxygenPage.click();
			return new OxygenWikipage();
		}
		
		


}