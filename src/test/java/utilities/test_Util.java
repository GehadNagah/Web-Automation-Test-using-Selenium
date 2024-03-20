package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class test_Util extends BaseTest {
	/**
	 * A utility method to capture a screenshot of the current browser window.
	 * @return The file path of the saved screenshot.
	 * @throws IOException If an I/O error occurs while capturing or saving the screenshot.
	 */
	public  String Screenshot() throws IOException {
Date cur_Date = new Date();
	String ScreenShot_Name = cur_Date.toString().replace(" ", "-").replace(":", "-");
	 // Generate a unique screenshot name according to the current date and time.
	File SSF = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    //full path where the screenshot will be saved
	String FullPath = System.getProperty("user.dir")+"//screenshots//"+ ScreenShot_Name + ".png";
	//Copy the screenshot to the path
	FileUtils.copyFile(SSF, new File(FullPath));
	return FullPath;
	}

}
