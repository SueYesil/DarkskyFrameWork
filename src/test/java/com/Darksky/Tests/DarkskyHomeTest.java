package com.Darksky.Tests;

import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Darksky.Util.ElementUtil;
import com.Darksky.base.BasePage;

import com.Darksky.pages.DarkskyHomepage1;

import com.Darksky.Util.Constants;

//@Listeners(com.Darksky.Listeners.TestAllureListener.class)
public class DarkskyHomeTest {
WebDriver driver;
ElementUtil elementUtil;
BasePage basePage;
Properties prop;
DarkskyHomepage1 darkskyHomepage1;

@BeforeMethod


public void setUp(){
			basePage = new BasePage();
			prop = basePage.initialize_properties();
			driver = basePage.initialize_driver(prop);
			darkskyHomepage1=new DarkskyHomepage1(driver);
			
}
           @Test
        public void TodaysTemp() throws InterruptedException{
			darkskyHomepage1.TodayClick();
			darkskyHomepage1.findTodaysTemperature();
			darkskyHomepage1.verificationOfMaxAndMin();
//			darkskyHomepage1.maxTemp();
//			darkskyHomepage1.minTemp();
//			darkskyHomepage1.verificationOfMaxAndMin();
			darkskyHomepage1.searchAddress();
			
			darkskyHomepage1.timemachine();
}
			@Test	
			public void homepageTitle(){
				String titleString=darkskyHomepage1.getHomePageTitle();
				System.out.println("Home Page Title:  "+titleString);
				Assert.assertEquals(titleString, Constants.DARKSKY_HOMEPAGE_TITLE);
				
}	
			
			
			@AfterMethod
			public void teardown(){
				basePage.closeBrowser();
			}	
			
			}	
		







