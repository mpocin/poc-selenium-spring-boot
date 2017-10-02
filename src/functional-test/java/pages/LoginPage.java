package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;

	@FindBy(css = "input#login_field")
	@CacheLookup
	private WebElement inputUsername;
	
	@FindBy(css = "input#password")
	@CacheLookup
	private WebElement inputPassword;
	
	@FindBy(css = ".btn-primary.btn-block")
	@CacheLookup
	private WebElement loginButton;
	
	@FindBy(css = ".flash-close.js-flash-close")
	@CacheLookup
	private WebElement closeButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage loginAsInvalidUser(String username, String password) {
		
		loginAs(username, password);
		
		return new LoginPage(driver);
		
	}
	
	public String getPageTitle() {

		return this.driver.getTitle();
	}
	
	private void loginAs(String username, String password) {
		
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		loginButton.click();
	}

}