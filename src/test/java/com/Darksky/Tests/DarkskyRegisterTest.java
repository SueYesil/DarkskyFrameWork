package com.Darksky.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Darksky.Util.Constants;
import com.Darksky.Util.ElementUtil;
import com.Darksky.base.BasePage;

import com.Darksky.pages.DarkskyAddressTimezonePage;
import com.Darksky.pages.DarkskyHomepage1;
import com.Darksky.pages.DarkskyHourVerificationPage;
import com.Darksky.pages.DarkskyRegisterPage;


public class DarkskyRegisterTest {

	WebDriver driver;
	ElementUtil elementUtil;
	BasePage basePage;
	Properties prop;
	DarkskyHomepage1 darkskyHomepage1;
    DarkskyHourVerificationPage darkskyHourVerificationPage;
    DarkskyAddressTimezonePage  darkskyAddressTimezonePage;
  
    DarkskyRegisterPage darkskyRegisterPage;
    
    
	@BeforeMethod


	public void setUp() throws InterruptedException{
				basePage = new BasePage();
				prop = basePage.initialize_properties();
				driver = basePage.initialize_driver(prop);
			
		      
		     
		     
		      darkskyRegisterPage  =new DarkskyRegisterPage(driver);
		      Thread.sleep(2000);
	}
	@Test
	
	public void APIandSignUp(){
		darkskyRegisterPage.ClickAPI();
	}
	
	@Test
	public void RegisterPage() throws InterruptedException{
		darkskyRegisterPage.Login(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("confirmation"));
		Thread.sleep(2000);
		darkskyRegisterPage.Gmail();
		
	}
	@Test
	public void title(){
		String title=darkskyRegisterPage.gettitle();
		System.out.println("Register title is :  "+title);
		Assert.assertEquals(title, Constants.DARKSKY_LAST_PAGE_TITLE);
		
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}
	
	
}
