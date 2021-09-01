package org.iit.sp.msb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class helperClass {
	
	WebDriver driver;
	public helperClass(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public void navigateToAModule(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
		
	}
	

}
