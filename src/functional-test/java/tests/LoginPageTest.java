package tests;

import static org.junit.Assert.assertTrue;

import config.ConfigurationService;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pages.CreateAccountPage;
import pages.LoginPage;
import setup.Setup;

@Service
public class LoginPageTest extends Setup {

	@Autowired
	private ConfigurationService configurationService;

	private LoginPage login;
	private CreateAccountPage accountPage;
	
	@Test
	public void shouldAccessAccountCreation() {

		login = new LoginPage(driver);

		accountPage = login.createAsValidEmail(configurationService.getEmail());

		assertTrue(accountPage.getPageUrl().contains("account-creation"));
		
	}

}