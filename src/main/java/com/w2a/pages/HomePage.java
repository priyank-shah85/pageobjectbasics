package com.w2a.pages;

import com.w2a.base.Page;

public class HomePage extends Page {
	
	public void goToSupport() {
		
		click("supportlink_XPATH");
		
	}
	
	
	public void goToSignUp() {
		
		click("signuplink_XPATH");
		
	}
	
	public LoginPage goToLogin() {
		
		click("loginlink_XPATH");
		
		return new LoginPage();
		
	}
	
	public void goToLearnMore() {
		
		click("learmorelink_XPATH");
		
	}
	
	public void validateFooterLinks() {
		
		click("footerlink1_XPATH");
		click("footerlink2_XPATH");
		
	}
	
	

}
