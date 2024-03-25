package selenium.textboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTextBox {

	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/login");
		WebElement uname = driver.findElement(By.id("login_field"));
		WebElement labelname = driver.findElement(By.xpath("//label[contains(text(),\"Username or email address\")]"));
		if(uname.isDisplayed()) {
			if(uname.isEnabled()) {
				uname.sendKeys("prathyusha");
				String b = labelname.getText();
				String a = uname.getAttribute("value");
				System.out.println(b+":"+""+a);
				Thread.sleep(3000);
				uname.clear();
			}else {
				System.err.println("uname is not enabled");
			}
		}else {
			System.err.println("uname is not displayed");
		}
		driver.close();
	}

}
