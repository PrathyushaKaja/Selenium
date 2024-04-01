package selenium.capturingScreenshots;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotFile {
/*Here, getScreenshotAs method contains in RemoteWebDriver class and this class implements 
 * ChromeDRiver interface and takeScreenshot interface.
 * 
 * We can also use takeScreenshot interface also 
 */
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		//We can use ChromeDriver and RemoteWebDriver
//		ChromeDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com/");
//		//File
//		File sourceFile =driver.getScreenshotAs(OutputType.FILE);
//		File destFile = new File("./Screenshots/image1.jpg");
//		FileUtils.copyFile(sourceFile, destFile);
//		System.out.println("Screenshot saved successfully!");
//		driver.quit();
		
		//we can also take screenshot using WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		TakesScreenshot takeScreenshot = (RemoteWebDriver) driver;
		File sourceFile =takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/image2.jpg");
		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Screenshot saved successfully!");
		driver.quit();
	}

}
