package com.Darksky.pages;



import java.util.List;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import com.Darksky.Util.ElementUtil;
import com.Darksky.Util.JavaScriptUtil;
import com.Darksky.base.BasePage;



public class DarkskyHomepage1 extends BasePage{

	 WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	
	int todayhours;
	int maxTemp;
	int mintemp;
	
	By temprature =By.xpath("//div[@id='week']//div[@class='temps']//span[contains(text(),'°')]");
	By search =By.xpath("//form[@id='searchForm']//input");//
	By clicksearchBy=By.xpath("//div[@id='header']/form[@id='searchForm']/a[@class='searchButton']");
	By timeMachine=By.xpath("/html[1]/body[1]/div[7]/div[2]/a[1]");
	//By timeMachine=By.cssSelector("//a[@class='button']");
	//By timeMachine=By.linkText("Time Machine");
	//By picaDateBy=By.xpath("//tr[@class='pika-row']");//
	By datepick=By.xpath("//button[contains(text(),'27')]");
	By slider=By.xpath("//div[@class='handle']//div");
	By Hour=By.xpath("//div[@class='hours']//span[5]");
	By temphour=By.xpath("//div[@class='temps']//span[3]");

	
	//By currentDaysTempRange =By.xpath("//a[@class='day revealed']");
	By currentDaysTempRange =By.xpath("//span[contains(text(),'Today')]");
	
	
	
	public DarkskyHomepage1(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	
	}


	public void TodayClick() throws InterruptedException{
		JavaScriptUtil.scrollDownBy(driver);
		Thread.sleep(3000);
        
		WebElement today =driver.findElement(By.xpath("//span[contains(text(),'Today')]"));
         JavaScriptUtil.clickElementByJS(today, driver);
		
	}
	public void maxTemp() throws InterruptedException{
	
		
		Thread.sleep(3000);
			
		List<WebElement> tempList = driver.findElements(temprature);
        
        String defaultValue= tempList.get(0).getText().substring(0,2); //--->default value
         maxTemp =Integer.parseInt(defaultValue);
    
		for(WebElement tempElement : tempList) {
        String text = tempElement.getText().substring(0,2);		//-->each value
        todayhours = Integer.parseInt(text);
        System.out.println("Today's temperatures : " +todayhours);
		
        if (todayhours>maxTemp){
        	maxTemp=todayhours;
        
		}
       
    }
		 System.out.println("Maximum temperature is "+maxTemp);}
		
	public void minTemp() throws InterruptedException{
		
	
	
			List<WebElement> tempList = driver.findElements(temprature);
	        
	        String defaultValue= tempList.get(0).getText().substring(0,2); //--->default value
	       mintemp =Integer.parseInt(defaultValue);
	    
			for(WebElement tempElement : tempList) {
	        String text = tempElement.getText().substring(0,2);		//-->each value
	        todayhours = Integer.parseInt(text);
	     //   System.out.println("Today's temperatures : " +todayhours);
			
	        if (todayhours<mintemp){
	        	mintemp=todayhours;
	      }
	      
	    }
			 System.out.println("Minimum temperature is "+mintemp);

	
	
	
	}
			
	
	
	public void findTodaysTemperature() throws InterruptedException{
		Thread.sleep(1000);
		List<WebElement> tempList = driver.findElements(By.xpath("//div[@id='week']//div[@class='temps']//span[contains(text(),'')]//span"));
		ArrayList<Integer> temp_list = new ArrayList<Integer>(); 
		
		for(int i=0; i<tempList.size(); i++){
			String text = tempList.get(i).getText().substring(0,2);
			todayhours = Integer.parseInt(text);
			temp_list.add(todayhours);
			System.out.println("Today Tempures : "+todayhours);
			
		}
		System.out.println("***********");
		Thread.sleep(1000);
		String currentTemp =driver.findElement(By.cssSelector(".summary.swap")).getText();
		System.out.println("Current Temp : " + currentTemp);
		System.out.println("Max tempeture is ------> "+Collections.max(temp_list));
		System.out.println("Min tempeture is ------> "+Collections.min(temp_list));
		WebElement maximum = driver.findElement(By.xpath("//span[@class='maxTemp'][contains(text(),'')]"));
		System.out.println("Maximum Tempeture Enable : "+maximum.isEnabled());
		WebElement minimum = driver.findElement(By.xpath("//span[@class='minTemp'][contains(text(),'')]"));
		System.out.println("Minimum Tempeture is Enable : "+minimum.isEnabled());
		
	}
			
		public void verificationOfMaxAndMin(){
			int	max = maxTemp;
			WebElement maxtemper = driver.findElement(temprature);
			System.out.println("Max temprature : "+maxtemper.isDisplayed());
			
			int	min = mintemp;
			WebElement mintemper = driver.findElement(temprature);
			System.out.println("Min temprature : "+mintemper.isDisplayed());
		}
		
		
		public void searchAddress() throws InterruptedException{
//             elementUtil.waitForElementPresent(search);
		  elementUtil.doSendKeys(search, "Taylor Street, Hammonton, NJ");
	        WebElement click=driver.findElement(clicksearchBy);
			JavaScriptUtil.clickElementByJS(click, driver);
			
			Thread.sleep(2000);
			
		}
		
		
		public void scrolldown() throws InterruptedException{
			for (int i = 0; i < 2; i++) {
				JavaScriptUtil.scrollDownBy(driver);
				Thread.sleep(1000);
			}
		}
		public void timemachine() throws InterruptedException{
			scrolldown();
			//JavaScriptUtil.scrollDownBy(driver);
			Thread.sleep(3000);
			elementUtil.doClick(timeMachine);
			scrolldown();
			elementUtil.doClick(datepick);
		}
		
		public String getHomePageTitle(){
			return driver.getTitle();
		}
		
		
}
		
//            Thread.sleep(3000);
//            Calendar calendar=Calendar.getInstance();
//    		calendar.add(Calendar.DAY_OF_MONTH,27);
//    		SimpleDateFormat dateFormat=new SimpleDateFormat("dd");
//    		
//    		return dateFormat.format(calendar.getTime()); }
//
//		
          
		
		
			
	
