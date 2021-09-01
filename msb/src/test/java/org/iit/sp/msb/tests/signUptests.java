package org.iit.sp.msb.tests;

import org.iit.sp.base.testbase;
import org.iit.sp.msb.helperClass;
import org.iit.sp.msb.pages.signUpPage;
import org.testng.annotations.Test;

public class signUptests extends testbase {
	
	@Test
	public void validatesignuptest() throws Exception   {
		helperClass helperobj = new helperClass(driver);
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		
        helperobj.navigateToAModule(("(//a[contains(normalize-space(),'Sign Up Free')])[2]"));
        signUpPage signupobj = new signUpPage(driver);
        signupobj.signUpfreepage();
        
		
		
	}
	

}
