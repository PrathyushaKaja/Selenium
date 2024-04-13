package selenium.XPath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathOperators {
/*
 * We have 6 types of XPath operators.
 * 1. =
 * 2. !=
 * 3. <
 * 4. >
 * 5. <=
 * 6. >=
 * First 2 operators will be applicable for text and numerical values
 * But last 4 operators will only applicable for the numerical values 
 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		driver.findElement(By.xpath("//input[@maxlength=10]")).sendKeys("prathyusha");
		highlight(driver, driver.findElement(By.xpath("//label[text()='Email']")));
		highlight(driver, driver.findElement(By.xpath("//input[@maxlength!=10]")));
		List<WebElement> elements = driver.findElements(By.xpath("//label[text()!='Password']"));
		for (WebElement webElement : elements) {
			highlight(driver, webElement);
		}
	}
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
}
