package selenium.capturingScreenshots;

import java.io.File;
import java.io.FileOutputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotBytes {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
//		byte[] byteArr = driver.getScreenshotAs(OutputType.BYTES);
//		File destFile = new File("./Screenshots/image5.jpg");
//		FileOutputStream fos = new FileOutputStream(destFile);
//		fos.write(byteArr);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		TakesScreenshot takesScreenshot = (RemoteWebDriver) driver;
		byte[] byteArr = takesScreenshot.getScreenshotAs(OutputType.BYTES);
		File destFile = new File("./Screenshots/image6.jpg");
		FileOutputStream fos = new FileOutputStream(destFile);
		fos.write(byteArr);
		System.out.println("Screenshot saved successfully!");
		fos.close();
		driver.quit();
	}

}
