package com.Darksky.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Darksky.Util.ElementUtil;
import com.Darksky.Util.JavaScriptUtil;
import com.Darksky.base.BasePage;

public class DarkskyHourVerificationPage extends BasePage{
	 WebDriver driver;
		ElementUtil elementUtil;
		JavaScriptUtil javaScriptUtil;
		
		
		By search =By.xpath("//form[@id='searchForm']//input");//
		 By clicksearchBy=By.xpath("//div[@id='header']/form[@id='searchForm']/a[@class='searchButton']");
		 By timeMachineBy=By.cssSelector("a[class='button']");//
	//	By picaDateBy=By.xpath("//tr[@class='pika-row']");
		//By datepick=By.cssSelector("td[data-day='27']");//
		By slider=By.xpath("//div[@class='handle']//div");
		By Hour=By.xpath("//div[@class='hours']//span[5]");
		By temphour=By.xpath("//div[@class='temps']//span[3]");
		
		/*Test2
		 * Enter search box Taylor Street, Hammonton, NJ
				Scroll down
				Click on timemachine
				Click on December 27
				Take temprature at 4 am and verify this is correct or not
		*/
		

		public DarkskyHourVerificationPage(WebDriver driver){
			this.driver=driver;
			elementUtil=new ElementUtil(driver);
		
		}

		
		
	
		
		public void hourVerification() throws InterruptedException{
	      Thread.sleep(2000);
	
	     	WebElement slider1 = driver.findElement(slider);
			WebElement hour4 = driver.findElement(Hour);
			
			Dimension dim=slider1.getSize();
			 System.out.println(dim);
		    Actions actions=new Actions(driver);
		    actions.dragAndDrop(hour4, hour4);
			 
			actions.clickAndHold(hour4).moveByOffset(2, 0).release().perform();
			
			List<WebElement> allhours=driver.findElements(Hour);
			
			for(WebElement am4:allhours)
			{
			
			String text = am4.getText().substring(0,3);
			System.out.println("The hour is:  "+text);
			System.out.println("4 am is Displayed:  "+am4.isDisplayed());
					
					 
			List<WebElement> alltemp=driver.findElements(temphour);
						
			for(WebElement temp:alltemp){
						
			String  temprature= temp.getText().substring(0,3);
			System.out.println("The temprature of selected hour :"+temprature);
			System.out.println("The temp of selected hour:  "+temp.isDisplayed());
					
		}	
		}	
}
		
		
		
}
