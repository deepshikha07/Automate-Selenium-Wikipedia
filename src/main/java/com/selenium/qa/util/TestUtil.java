package com.selenium.qa.util;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;



public class TestUtil extends com.selenium.qa.base.TestBase{

	
	public static void takeScreenshot(WebElement element) throws IOException {
		File scrFile = element.getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		FileHandler.copy(scrFile, new File("E:\\Screenshot.png"));
		//FileHandler.copy(, new File("E:\\Screenshot.png"));
		
	}
	}
