package cat.babot;

import cat.babot.common.BaseTest;
import cat.babot.common.ElementAction;
import cat.babot.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.ArrayList;


public class WikiTest  {
	public static WebDriver driver = null;
	public static ElementAction page;

	@BeforeAll
	public static void setUpBeforeClass() {

		WebDriverManager.chromedriver().setup();
		ArrayList<String> optionsList = new ArrayList<>();
		ChromeOptions chromeOptions = new ChromeOptions();
		optionsList.add("--start-maximized");
		optionsList.add("--incognito");
		optionsList.add("disable-notifications");
		optionsList.add("--remote-allow-origins=*");
		chromeOptions.addArguments(optionsList);
		chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		driver = new ChromeDriver(chromeOptions);
		page = new ElementAction(driver);

		//Open URL
		driver.get(Constants.General.URL);

	}

	public static WebDriver getDriver() {
		return driver;
	}

	@AfterAll
	public static void tearDownAfterClass() {
		driver.quit();
	}
	@Test public void wikipedia() {
		page.clickOn(Constants.General.COOKIESABTN);
		page.writeIn(Constants.General.SEARCHAREA, "automatización");
		page.clickOnWithJS(Constants.General.SEARCHBTN);
		page.clickOnWithJS(Constants.General.AUTOMWIKI);
		page.screenshot();
	}
}
