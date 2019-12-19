package com.Darksky.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Darksky.Util.ElementUtil;
import com.Darksky.base.BasePage;
import com.Darksky.pages.DarkskyAddressTimezonePage;
import com.Darksky.pages.DarkskyHomepage1;
import com.Darksky.pages.DarkskyHourVerificationPage;

public class DarkskyTimezoneVerificationTest {
	WebDriver driver;
	ElementUtil elementUtil;
	BasePage basePage;
	Properties prop;
	DarkskyHomepage1 darkskyHomepage1;
    DarkskyHourVerificationPage darkskyHourVerificationPage;
    DarkskyAddressTimezonePage  darkskyAddressTimezonePage;
	@BeforeMethod


	public void setUp() throws InterruptedException{
				basePage = new BasePage();
				prop = basePage.initialize_properties();
				driver = basePage.initialize_driver(prop);
				darkskyHomepage1=new DarkskyHomepage1(driver);
				darkskyHomepage1.TodayClick();
				darkskyHomepage1.maxTemp();
				darkskyHomepage1.minTemp();
				darkskyHomepage1.verificationOfMaxAndMin();
				darkskyHomepage1.searchAddress();
				darkskyHomepage1.timemachine();
				darkskyHomepage1.getHomePageTitle();
				darkskyHourVerificationPage=new DarkskyHourVerificationPage(driver);
		        darkskyHourVerificationPage.hourVerification();
		        darkskyAddressTimezonePage=new DarkskyAddressTimezonePage(driver);
		      
	}
	
//	
//	@Test
//	
//	public void addressTimezone() throws InterruptedException{
//		darkskyAddressTimezonePage.takeTimezone();
//	}
//	
	
	@Test
	public void verifyTimeZone() throws InterruptedException {
		
		int expectedTime = darkskyAddressTimezonePage.takeTimezone();
		System.out.println("According to GMT, expected time is " + expectedTime + " o'clock");
		
		int actualTime = darkskyAddressTimezonePage.addTwoHoursOnCurrentTime();
		System.out.println("According to test case, actual time is "+ actualTime + " o'clock");
		
		Assert.assertEquals(actualTime, expectedTime ); 
				
	}
	
	
	@AfterMethod
	public void teardown(){
		basePage.closeBrowser();
	}
	
}
