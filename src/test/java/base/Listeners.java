package base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.test_Util;

public class Listeners extends test_Util implements ITestListener{
	/**
	 * This method is invoked when a test starts execution.
	 * @param result The result object representing the test execution.
	 */
	public void onTestStart(ITestResult result) {
	    System.out.println("On Test");
	  }

/**
 * This method is called when a test fails during execution.
 * It captures a screenshot of the current state of the browser window and embeds it into the test report.
 * @param result The result object representing the failed test execution.
 */
public void onTestFailure(ITestResult result) {

	System.out.println("Test Failed");
	  try {
			String path = Screenshot();
			System.setProperty("org.uncommons.reportng.escape-output","false");
			Reporter.log(" <a href='"+path+"'> <img src='"+path+"' height='200' width='200'/> </a>  ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	

}
/**
 * This method is invoked when a test succeeds during execution.
 * It logs a success message to the test report and the console.
 * @param result The result object representing the successful test execution.
 */
public void onTestSuccess(ITestResult result) {
	Reporter.log("Test Successed");
    System.out.println("Test Successed");
  
}

	
	
	}
	


