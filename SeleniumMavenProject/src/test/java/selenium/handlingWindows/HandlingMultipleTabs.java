package selenium.handlingWindows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleTabs {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("newTabsBtn")).click();
		String parentWindow = driver.getWindowHandle();
		//System.out.println("parent window"+":"+parentWindow+":"+driver.getTitle());
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
			Thread.sleep(3000);
			if(!window.equals(parentWindow)&&driver.getTitle().equals("Basic Controls - H Y R Tutorials")) {
				WebElement radiobtn = driver.findElement(By.id("femalerb"));
				radiobtn.click();
				String a = radiobtn.getAttribute("id");
				System.out.println(a);
				WebElement radiobtn1 = driver.findElement(By.id("malerb"));
				Thread.sleep(3000);
				radiobtn1.click();
				String b = radiobtn1.getAttribute("id");
				System.out.println(b);
			}
			Thread.sleep(3000);
			if(!window.equals(parentWindow)&&driver.getTitle().equals("AlertsDemo - H Y R Tutorials")) {
				WebElement msg = driver.findElement(By.id("output"));
				String m = msg.getText();
				if(m.equals("")) {
					System.out.println("null text");
				}else {
					System.out.println(m);
				}
				driver.findElement(By.id("promptBox")).click();
				driver.switchTo().alert().sendKeys("alerts practice");
				Thread.sleep(3000);
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				WebElement o1 = driver.findElement(By.id("output"));
				String output1 = o1.getText();
				if(output1.equals("")) {
					System.out.println("null text");
				}else {
					System.out.println(output1);
				}
			}
			Thread.sleep(3000);
			if(window.equals(parentWindow)) {
				WebElement className =driver.findElement(By.className("whTextBox"));
				className.sendKeys("selenium");
				Thread.sleep(3000);
				String c = className.getAttribute("value");
				System.out.println(c);
			}
		}
		driver.quit();
	}

}
