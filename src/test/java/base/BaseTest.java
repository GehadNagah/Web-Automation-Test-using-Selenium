package base;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Readfile;


public class BaseTest extends Readfile{
public static WebDriver driver ;
Properties p;
public static Properties Loc = new Properties();

@Parameters({"browser", "website"})
@BeforeMethod
/**
 * Launches a web browser and navigates to the specified website.
 * @param browser The name of the browser to launch (e.g., "chrome", "firefox", "edge").
 * @param website The URL of the website to navigate to.
 * @throws IOException If an I/O error occurs while reading the configuration file.
 */
public  void LaunchBrowser(String browser, String website ) throws IOException {
	
	Loc = ReadFile("\\src\\test\\resources\\configurationfile\\Locators.properties");
	if(driver == null) {
		if (browser.equalsIgnoreCase("chrome") ) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(website);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(website); // Get the specified website.

		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(website);
		}	
	}
	}
		@AfterMethod
		/**
		 * Closes the web browser and resets the WebDriver instance to null for the next run.
		 */
		public  void TearDown() {
			driver.close();
			driver = null;
			}
}