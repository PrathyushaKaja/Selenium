package selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingLinksAndButtons {

	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("registerbtn")).click();
		Thread.sleep(3000);
		WebElement message = driver.findElement(By.id("msg"));
		String text = message.getText();
		System.out.println(text);
		if(message.isDisplayed()) {
			Thread.sleep(3000);
			driver.findElement(By.linkText("Click here to navigate to the home page")).click();
		}else {
			System.err.println("Message is not displayed");
		}
		Thread.sleep(3000);
		driver.close();
	}

}
