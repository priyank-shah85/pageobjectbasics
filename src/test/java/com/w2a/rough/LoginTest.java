package com.w2a.rough;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;

public class LoginTest {

	public static void main(String[] args) {
		
		
		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();
		ZohoAppPage zp = lp.doLogin("pgshah08@gmail.com", "Prince19@08");
		zp.goToCRM();
		AccountsPage account = Page.menu.goToAccounts();
		CreateAccountPage cap = account.goToCreateAccounts();
		cap.createAccount("Priyank01");
		
		
	}

}
