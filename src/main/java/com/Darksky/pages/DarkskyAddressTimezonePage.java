package com.Darksky.pages;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Darksky.Util.ElementUtil;
import com.Darksky.Util.JavaScriptUtil;
import com.Darksky.base.BasePage;


public class DarkskyAddressTimezonePage extends BasePage{
	 WebDriver driver;
		ElementUtil elementUtil;
		JavaScriptUtil javaScriptUtil;
		By search =By.xpath("//form[@id='searchForm']//input");//
		By clicksearchBy=By.xpath("//div[@id='header']/form[@id='searchForm']/a[@class='searchButton']");
		By timeOnThePage=By.xpath("//div[@class='hours']//span[3]");
		/*@Test 3
           Enter search box Taylor Street, Hammonton, NJ Verify city's time zone*/


		public DarkskyAddressTimezonePage(WebDriver driver){
				this.driver=driver;
				elementUtil=new ElementUtil(driver);
			}
        public int  takeTimezone() throws InterruptedException{
			driver.navigate().back();
			Thread.sleep(2000);
	    	elementUtil.doSendKeys(search, "Taylor Street, Hammonton, NJ");
			Thread.sleep(2000);
			elementUtil.doClick(clicksearchBy);
			
			Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("GMT-3"));
		    return calendar.get(Calendar.HOUR);
		 
			

        }
       
    	
    	
    	public int addTwoHoursOnCurrentTime() throws InterruptedException{
    		String time=elementUtil.doGetText(timeOnThePage);
    		Thread.sleep(3000);
    		int timeForTwoHoursLater=Integer.parseInt(time.replaceAll("[^\\d.]", ""));
    			return timeForTwoHoursLater;	
    	
    	}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//			String[] validIDs = TimeZone.getAvailableIDs();
//			for (String str : validIDs) {
//				//System.out.println(str);
//			      if (str != null && str.contains("Etc/GMT-5")) {
//			    	//  System.out.println("Etc/GMT-5");
//			        System.out.println("Hammonton Newjersey Timezone: "+str);
//			       
//			      }

			      
			      
			      
			      
			      
			      
			      
//			TimeZone timezone = TimeZone.getTimeZone("TimeZone");
//			 Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//			String LocalTimeZoneName = timezone.getDisplayName();
//			
//			System.out.println("Current timezone : "+timezone.getID());
		//	System.out.println("Local Time Zone: "+ LocalTimeZoneName);
//			System.out.println("Current Time&zone :"+ calendar.getTime());
			//return timezone.getDisplayName();
			 
		
			
        }


		

