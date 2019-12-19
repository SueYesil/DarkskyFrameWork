package com.Darksky.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Darksky.Util.ElementUtil;
import com.Darksky.Util.JavaScriptUtil;


public class DarkskyRegisterPage {
	 WebDriver driver;
		ElementUtil elementUtil;
		JavaScriptUtil javaScriptUtil;
		By API=By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
		By signUp=By.xpath("//a[@class='button filled']");
		By Register=By.xpath("//input[@placeholder='hacker@example.com']");
        By password=By.xpath("//input[@name='password']");
        By confirmPassword= By.xpath("//input[@name='confirmation']");
        By clickregisterBy=By.xpath("//button[contains(text(),'Register')]");
        By email=By.cssSelector("input[id='identifierId']");
        By nextBy=By.cssSelector("span[class='RveJvd snByac']");
        By passwordgmail=By.cssSelector("input[name='password']");
        By clicknextBy=By.cssSelector("span[class='CwaK9']");
       
        By linkmail=By.xpath("//div[@id=':38']//span[@name='Dark Sky Developer .'][contains(text(),'Dark Sky Developer .')]");
        By returnmail=By.xpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tr[1]/td[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[3]/div[1]/a[1]");
        By headerBy=By.xpath("//h1[@class='title stand-alone']");
        public DarkskyRegisterPage (WebDriver driver){
			this.driver=driver;
			elementUtil=new ElementUtil(driver);
		
		}
        public void ClickAPI(){
    		elementUtil.waitForElementPresent(API);
    		elementUtil.doClick(API);
    		elementUtil.doClick(signUp);
		}
    	
    	
		
		public void Login(String username,String pwd,String confirmation){
			
				elementUtil.doSendKeys(Register, username);
				elementUtil.doSendKeys(password, pwd);
				elementUtil.doSendKeys(confirmPassword, confirmation);				
			   elementUtil.doClick(clickregisterBy);
				//return new (driver);
			}
		public void Gmail(){
			driver.navigate().to("https://mail.google.com/mail/u/2/#inbox");
			elementUtil.doSendKeys(email," sumeyra@peaceislands.org");
			elementUtil.doClick(nextBy);
			elementUtil.doSendKeys(passwordgmail, "Niyazi123");
			elementUtil.doClick(clicknextBy);
			elementUtil.doClick(linkmail);
			elementUtil.doClick(returnmail);
			
			
		}
		
		public String gettitle(){
			
			return driver.getTitle();
	
}
}