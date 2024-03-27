package selenium.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingSingleDropdown {

	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
		WebElement course = driver.findElement(By.id("course"));
		Select courseName = new Select(course);
		List<WebElement> options = courseName.getOptions();
		for (WebElement a : options) {
			System.out.println(a.getText());
		}
		courseName.selectByIndex(2);
		Thread.sleep(3000);
		courseName.selectByValue("js");
		Thread.sleep(3000);
		courseName.selectByVisibleText("Java");
		Thread.sleep(3000);
		String value = courseName.getFirstSelectedOption().getText();
		System.out.println(value);
	}

}
