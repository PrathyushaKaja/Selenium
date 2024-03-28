package selenium.handlingWindows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingNewWindow {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow+":"+driver.getTitle());
		driver.findElement(By.id("newWindowBtn")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				driver.manage().window().maximize();
				driver.findElement(By.id("firstName")).sendKeys("Prathyusha");
				Thread.sleep(3000);
				driver.close();//Close the current window, quitting the browser if it's the last window currently open
			}
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("Selenium Practice");
		Thread.sleep(3000);
		driver.quit();//Quits this driver, closing every associated window. 

	}

}
