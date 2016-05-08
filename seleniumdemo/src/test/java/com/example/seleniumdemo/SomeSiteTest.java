package com.example.seleniumdemo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;




import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;


public class SomeSiteTest {

	private static WebDriver driver;
	WebElement element;
	String Actualtext;

	@BeforeClass
	public static void driverSetup() {
		// ChromeDrirver, FireforxDriver, ...
		//System.setProperty("webdriver.chrome.driver", "/home/studinf/apopko/Pulpit/chromedriver");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Ada/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/*
	@Test
	public void homePage(){
		driver.get("http://www.seleniumframework.com/Practiceform/");
		
		element = driver.findElement(By.linkText("Alert Box"));
		assertNotNull(element);
	}
	*/
	
	@Test
	public void NewBowserWindow(){
		driver.get("http://www.seleniumframework.com/Practiceform/");
		element = driver.findElement(By.id("button1"));
		element.click();
		assertNotNull(element);

	}
	
	@Test
	public void Checkbox(){
		driver.get("http://www.seleniumframework.com/Practiceform/");
		element = driver.findElement(By.id("vfb-6-0"));
		element.click();
		assertNotNull(element);

	}
	
	@Test
	public void Select(){
		driver.get("http://www.seleniumframework.com/Practiceform/");
		new Select(driver.findElement(By.id("vfb-12"))).selectByVisibleText("Option 2");
		
	}
	
	@Test
	public void Verification(){
		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.findElement(By.id("vfb-3")).sendKeys(Keys.TAB,"12");		
		element = driver.findElement(By.id("vfb-4"));
		element.click();
	}
	
	@Test
	public void Draganddrop(){
		driver.get("http://www.seleniumframework.com/Practiceform/");
	    WebElement element = driver.findElement(By.id("draga"));
	    WebElement target = driver.findElement(By.id("dragb"));
	    (new Actions(driver)).dragAndDrop(element, target).perform();
	}
	
	@Test
	public void Alert(){
		driver.get("http://www.seleniumframework.com/Practiceform/");
		element = driver.findElement(By.id("alert"));
		element.click();

		try {
			//Handle the alert pop-up using seithTO alert statement
			Alert alert = driver.switchTo().alert();

			//Print alert is present
			System.out.println("Alert is present");

			//get the message which is present on pop-up
			String message = alert.getText();

			//print the pop-up message
			System.out.println(message);

			alert.sendKeys("");
			//Click on OK button on pop-up
			alert.accept();
			} 
		catch (NoAlertPresentException e){
        //if alert is not present print message
        System.out.println("alert is not present");
    	}		
	}
	
	@Test
	public void Link(){
		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.findElement(By.linkText("This is a link")).click();
	}

	@AfterClass
	public static void cleanp() {
		//driver.quit();
	}
}
