package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;

	@FindBy(id = "email_create")
	@CacheLookup
	private WebElement inputEmailCreate;

	@FindBy(css = "input:invalid")
	private WebElement inputInvalid;

	@FindBy(id = "SubmitCreate")
	@CacheLookup
	private WebElement createButton;
	
	@FindBy(id = "email")
	@CacheLookup
	private WebElement inputEmail;
	
	@FindBy(id = "passwd")
	@CacheLookup
	private WebElement inputPassword;
	
	@FindBy(id = "SubmitLogin")
	@CacheLookup
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CreateAccountPage createAsValidEmail(String email) {

		inputEmailCreate.sendKeys(email);

		return new CreateAccountPage(driver);
	}

	public LoginPage createAsInvalidUser(String email) {

		inputEmailCreate.sendKeys(email);

		return new LoginPage(driver);
	}
	
	public LoginPage loginAsValidUser(String username, String password) {
		
		loginAs(username, password);
		
		return new LoginPage(driver);
		
	}
	
	public String getPageTitle() {

		return this.driver.getTitle();
	}
	
	private void loginAs(String username, String password) {

		inputEmail.sendKeys(username);
		inputPassword.sendKeys(password);
		loginButton.click();
	}

}