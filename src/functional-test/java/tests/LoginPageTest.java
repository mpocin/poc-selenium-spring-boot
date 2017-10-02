package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import pages.LoginPage;
import setup.Setup;

public class LoginPageTest extends Setup {
	
	private String username;
	private String password;
	
	private LoginPage login;
	
	@Test
	public void shouldBeOnLoginPage() {

		login = new LoginPage(driver);

		assertEquals(login.getPageTitle(), "Sign in to GitHub · GitHub");
		
	}

}