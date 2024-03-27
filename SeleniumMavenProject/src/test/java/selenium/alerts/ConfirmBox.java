package selenium.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfirmBox {

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
		//Accept 
		driver.findElement(By.id("confirmBox")).click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();  //accepting the button
		Thread.sleep(3000);
		WebElement o1 = driver.findElement(By.id("output"));
		String output1 = o1.getText();
		if(output1.equals("")) {
			System.out.println("null text");
		}else {
			System.out.println(output1);
		}
		//Dismiss
		driver.findElement(By.id("confirmBox")).click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();  //accepting the button
		Thread.sleep(3000);
		WebElement o2 = driver.findElement(By.id("output"));
		String output2 = o2.getText();
		if(output2.equals("")) {
			System.out.println("null text");
		}else {
			System.out.println(output2);
		}
		driver.close();

	}

}
