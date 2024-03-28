package selenium.handlingWindows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingNewTab {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow+":"+driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(By.id("newTabBtn")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				Thread.sleep(3000);
				System.out.println(driver.findElement(By.id("output")).getText());
				driver.findElement(By.id("confirmBox")).click();
				System.out.println(driver.switchTo().alert().getText());
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				System.out.println(driver.findElement(By.id("output")).getText());
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("name")).sendKeys("Selenium Java");
		Thread.sleep(4000);
		driver.quit();
	}

}
