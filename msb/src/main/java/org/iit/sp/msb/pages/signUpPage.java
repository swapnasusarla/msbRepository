package org.iit.sp.msb.pages;

import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class signUpPage {
  
	WebDriver driver;
	public signUpPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void signUpfreepage() throws Exception  {
		
		JavascriptExecutor jse = (JavascriptExecutor)(driver);
		
		WebElement state = driver.findElement(By.name("selectedRegion"));
		Select st = new Select(state);
		List<WebElement> options = st.getOptions();		
		Random num = new Random();		
		st.selectByIndex(num.nextInt(options.size()));		
		System.out.println(state.getAttribute("value"));
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//select[@name='selectedDistrict']")));
		
		String distText = driver.findElement(By.xpath("//select[@name='selectedDistrict']/option")).getText();
		if(distText.equalsIgnoreCase("No Districts Available")) {
			System.out.println("No districts available for the given state");
			
		}else {
			
		Select district = new Select(driver.findElement(By.xpath("//select[@name='selectedDistrict']")));
		List<WebElement> Doptions = district.getOptions();		
		Random num1 = new Random();		
		district.selectByIndex(num1.nextInt(Doptions.size()));
		System.out.println(driver.findElement(By.xpath("//select[@name='selectedDistrict']"))
				                 .getAttribute("value"));		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		
		jse.executeScript("arguments[0].value='Swapna';", 
				         driver.findElement(By.name("firstName")));
		
		jse.executeScript("arguments[0].value='S';", 
		         driver.findElement(By.name("lastName")));
		
		jse.executeScript("arguments[0].value='(709) 689-6543';",
				           driver.findElement(By.name("mobilePhone")));		
		
		driver.findElement(By.name("mobileOptedIn")).click();		
		jse.executeScript("arguments[0].value='sksr0801@gmail.com';",
				           driver.findElement(By.name("userLoginID")));
		
		jse.executeScript("arguments[0].value='sksr0801@gmail.com';",
				           driver.findElement(By.name("retypeLoginID")));
	       		
		jse.executeScript("arguments[0].value='Sksr@123';",
				         driver.findElement(By.name("password")));
   			  
		jse.executeScript("arguments[0].value='Sksr@123';",
				          driver.findElement(By.name("retype")));
			  
		
		Select secQ1 = new Select(driver.findElement(By.name("securityQuestion")));
		List<WebElement> opt = secQ1.getOptions();		
		Random num3 = new Random();		
		secQ1.selectByIndex(num3.nextInt(opt.size()));
		System.out.println(driver.findElement(By.name("securityQuestion")).getAttribute("value"));
		
		WebElement secAns1=driver.findElement(By.name("securityAnswer"));
		jse.executeScript("arguments[0].value='123abc';",secAns1);		      
		
		Select secQ2 = new Select(driver.findElement(By.name("securityQuestion2")));
		List<WebElement> opt1 = secQ2.getOptions();		
		Random num4 = new Random();		
		secQ2.selectByIndex(num4.nextInt(opt1.size()));
		System.out.println(driver.findElement(By.name("securityQuestion2")).getAttribute("value"));
		
		WebElement secAns2 = driver.findElement(By.name("securityAnswer2"));
		jse.executeScript("arguments[0].value='123xyz';",secAns2);
		
		driver.findElement(By.xpath("//input[@name='emailNews']"));
		
		WebElement regButton =  driver.findElement(By.xpath("//button[@id='registerButton']"));
		jse.executeScript("arguments[0].scrollIntoView();",regButton);
		regButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='continueButton']")));
		driver.findElement(By.xpath("//a[@id='continueButton']")).click();
		
		String Expected = "Your user profile was created successfully."
				           + " A welcome email has been sent to your inbox.";
		String Actual = driver.findElement(By.xpath("//div[@class='simplemsg']//p"))
				              .getText();
		
		Assert.assertTrue(Actual.equalsIgnoreCase(Expected));
		
		}	
	}
}
