package selenium.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleDropdown {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
		WebElement IDE = driver.findElement(By.id("ide"));
		Select IDEDropdown = new Select(IDE);
		List<WebElement> options = IDEDropdown.getOptions();
		for (WebElement values : options) {
			System.out.println(values.getText());
		}
		IDEDropdown.selectByIndex(2);
		Thread.sleep(3000);
		IDEDropdown.selectByValue("ec");
		Thread.sleep(3000);
		IDEDropdown.selectByVisibleText("NetBeans");
		Thread.sleep(3000);
		IDEDropdown.deselectByValue("vs");
		List<WebElement> finalValue = IDEDropdown.getAllSelectedOptions();
		for (WebElement items : finalValue) {
			System.out.println(items.getText());
		}
		driver.close();
	}

}
