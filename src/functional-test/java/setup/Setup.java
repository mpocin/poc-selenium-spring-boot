package setup;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import urls.LinksPage;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FunctionalTestApplication.class)
@TestPropertySource("classpath:application.properties")
public class Setup extends LinksPage {

	public static WebDriver driver;

	@Value("${firefox.driver}")
	private String firefoxDriver;

	@Value("${firefox.driver.path}")
	private String firefoxDriverPath;

	@Before
	public void setup() {
		System.setProperty(firefoxDriver, firefoxDriverPath);
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--headless");
		
		driver = new FirefoxDriver(firefoxOptions);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get(DEFAULT_URL);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}