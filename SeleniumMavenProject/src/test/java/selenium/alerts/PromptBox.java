package selenium.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PromptBox {
//Prompt box we can enter the input and performs the actions like accept/dismiss
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
		driver.findElement(By.id("promptBox")).click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Prathyusha Shetty");
		Thread.sleep(3000);
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
