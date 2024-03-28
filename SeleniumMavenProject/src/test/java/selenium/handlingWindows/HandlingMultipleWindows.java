package selenium.handlingWindows;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleWindows {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();
	//	System.out.println("Parent window"+parentWindow+":"+driver.getTitle());
		driver.findElement(By.id("newWindowsBtn")).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		for (String window : windows) {
			driver.switchTo().window(window);
			System.out.println(window+":"+driver.getTitle());
			if(!window.equals(parentWindow)&&driver.getTitle().equals("Basic Controls - H Y R Tutorials")) {
				driver.switchTo().window(window);
				driver.manage().window().maximize();
				List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
				for (WebElement options : checkbox) {
					String value = options.getAttribute("id");
					if(value.equals("spanishchbx")||value.equals("frenchchbx")) {
						options.click();
						Thread.sleep(3000);
						System.out.println(options.getAttribute("id"));
					}
				}
			}
			if(!window.equals(parentWindow)&&driver.getTitle().equals("XPath Practice - H Y R Tutorials")) {
				driver.manage().window().maximize();
				WebElement name = driver.findElement(By.name("name"));
				name.sendKeys("prathyusha");
				Thread.sleep(3000);
				String n = name.getAttribute("value");
				System.out.println(n);
			}
			if(window.equals(parentWindow)) {
			WebElement a = driver.findElement(By.id("name"));
			a.sendKeys("Selenium Practice");
			Thread.sleep(3000);
			String b = a.getAttribute("value");
			System.out.println(b);
			}
		}
		
	driver.quit();
	}

}
