package selenium.capturingScreenshots;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotBase64 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
//		String base64 = driver.getScreenshotAs(OutputType.BASE64);
//		byte[] byteArr = Base64.getDecoder().decode(base64);
//		File destFile = new File("./Screenshots/image3.jpg");
//		FileOutputStream fos = new FileOutputStream(destFile);
//		fos.write(byteArr);
//		System.out.println("Screenshot saved successfully!");
//		fos.close();
//		driver.quit();
		
		//WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		TakesScreenshot takeScreenshot = (RemoteWebDriver) driver;
		String base64 = takeScreenshot.getScreenshotAs(OutputType.BASE64);
		byte[] byteArr = Base64.getDecoder().decode(base64);
		File destFile = new File("./Screenshots/image4.jpg");
		FileOutputStream fos = new FileOutputStream(destFile);
		fos.write(byteArr);
		System.out.println("Screenshot saved successfully!");
		fos.close();
		driver.quit();
	}

}
