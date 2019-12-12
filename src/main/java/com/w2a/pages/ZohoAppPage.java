package com.w2a.pages;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page {
	
	public void goToCliq() {
		
		click("cliqbtn_XPATH");
		
	}
	
	public CRMHomePage goToCRM() {
		
		click("crmbtn_XPATH");
		
		return new CRMHomePage();
		
	}
	
	public void goToInvoice() {
		
		click("invoicebtn_XPATH");
		
	}
	

}
