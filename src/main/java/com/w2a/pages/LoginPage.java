package com.w2a.pages;

import org.openqa.selenium.By;
import com.w2a.base.Page;

public class LoginPage extends Page {
	
	public ZohoAppPage doLogin(String username, String password) {
		
		click("oldloginpagelink_XPATH");
		type("email_XPATH",username);
		type("password_XPATH",password);
		click("submitbtn_XPATH");
		
		return new ZohoAppPage();
		
	}
	
	
	public void validateHeaderText(String text) {
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div[2]")).toString().contains(text);
		
	}
	
	
	public void goToSignUpNow() {
		
		click("signupnowbtn_XPATH");
		
	}

}
