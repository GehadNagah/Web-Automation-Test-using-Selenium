package testcase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DataProvidor;

public class MyFirstTest extends BaseTest{
@Test(dataProvider = "TestData" ,  dataProviderClass = DataProvidor.class) //as data provider in another class.

/**
 * Performs a test scenario involving searching on a webpage and navigating through multiple pages of results.
 * @param search_word The search term to be used for the test.
 * @throws InterruptedException If the thread is interrupted while waiting.
 */
	public static void Test(String search_word) throws InterruptedException  {

	//Fluent wait setup 
	Wait<WebDriver> wait1 = new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(30)) // Maximum wait time of 30 seconds
    .pollingEvery(Duration.ofSeconds(1)) // Check every 1 seconds
    .ignoring(Exception.class); // Ignore exceptions
	
	JavascriptExecutor jse = (JavascriptExecutor)driver; // Cast the driver to JavaScript instance. 
// Soft Assertion (Title assertion)
	String actual = driver.getTitle();
	String Expected = "Bing";
	Assert.assertEquals(actual.contains("bing"), Expected.contains("bing"));
	// Find the place of search by id or we can find it by path also (Search_box contains the id of search box.)
		driver.findElement(By.id(Loc.getProperty("Search_box"))).sendKeys(search_word);
		driver.findElement(By.id(Loc.getProperty("Search_icon"))).click(); // Click on it.
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)"); //Scroll to the end of the page.

		//Go to next page
		WebElement button = driver.findElement(By.xpath(Loc.getProperty("next_button"))); 
		jse.executeScript("arguments[0].scrollIntoView(true);", button); //scrollIntoView used to ensure that a specific element is visible to the user.
		wait1.until(ExpectedConditions.elementToBeClickable(button));
		jse.executeScript("arguments[0].click();", button);			
		
		//Count the number of results displayed on the second page.
		//Wait1 is an object of fluent wait class so we wait until all links are loaded in the web site 
		//to be able to count them(to be visible).
		WebElement resultContainer = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Loc.getProperty("All_Search_Results"))));	
		int linksofpage_2 = resultContainer.findElements(By.xpath(Loc.getProperty("Single_Result"))).size();
		
		//Scroll to the end of page 2.
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)"); 
         button = driver.findElement(By.xpath(Loc.getProperty("next_button"))); 
		jse.executeScript("arguments[0].scrollIntoView(true);", button); //scrollIntoView used to ensure that a specific element is visible to the user.
		wait1.until(ExpectedConditions.elementToBeClickable(button));
		jse.executeScript("arguments[0].click();", button);		
		//Page 3
		WebElement resultContainer1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Loc.getProperty("All_Search_Results"))));	
		int linksofpage_3 = resultContainer1.findElements(By.xpath(Loc.getProperty("Single_Result"))).size();
		
	//Validate if the number of results on page 2 is equal to page 3 or not
	Assert.assertEquals(linksofpage_2, linksofpage_3);
	}











}
