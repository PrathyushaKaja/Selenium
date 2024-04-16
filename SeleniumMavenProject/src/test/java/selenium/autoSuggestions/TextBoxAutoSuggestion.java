package selenium.autoSuggestions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxAutoSuggestion {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/auto-complete");
		WebElement element = driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']"));
		element.sendKeys("a");
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(element, Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
		.perform();
	}

}
