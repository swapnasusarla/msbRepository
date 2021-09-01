package org.iit.sp.base;

import java.util.Properties;


import org.iit.sp.projConfig.projectConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testbase {
	
	protected WebDriver driver ;
	public Properties pro;
	
	@BeforeClass
	public void instantiateDriver() throws Exception 
	{		
		projectConfiguration pconf = new projectConfiguration();
		
		pro=pconf.Loadproperties();
		String browser = pro.getProperty("browser");
		
		
		if(browser.equalsIgnoreCase("chrome")){
			System.out.println("Inside if");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")){	
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		System.out.println("LastLine of the instatiate method of TestBase");
	}
	
	
	@AfterClass
	public void Closebrowser() {
		driver.quit();
	}
}



