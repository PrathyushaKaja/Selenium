package selenium.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertBox {
//These alerts are javascript alerts. We can't even inspect that box.
//AlertBox will helps us to continue the work which we are trying to do 
//we can do the actions like getting the alert text, clicking the button
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		Thread.sleep(3000);
		WebElement o =driver.findElement(By.id("output"));
		String output =o.getText();
		if(output.equals("")) {
			System.out.println("null text");
		}else {
			System.out.println(output);
		}
		driver.findElement(By.id("alertBox")).click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		//whatever the text in button it reciprocates the positive and accept is also a positive word
		driver.switchTo().alert().accept();  //accepting the button
		Thread.sleep(3000);
		WebElement o1 = driver.findElement(By.id("output"));
		String output1 = o1.getText();
		if(output1.equals("")) {
			System.out.println("null text");
		}else {
			System.out.println(output1);
		}
		driver.close();
	}

}
