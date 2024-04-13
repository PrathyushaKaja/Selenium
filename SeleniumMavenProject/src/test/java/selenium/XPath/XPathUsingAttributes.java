package selenium.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathUsingAttributes {
/*
 * Attributes and text will be there for every element in the document.
 * On-click, on-mouse over - we should not use these kind of attributes because these are the events.
 * syntax: //tagName[@attibute='value'] 
 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/");
		//with attribute
		highlight(driver, driver.findElement(By.xpath("(//a[@title='Sign Up to Improve Your Learning Experience'])[1]")));
		//with text
		highlight(driver, driver.findElement(By.xpath("//a[contains(text(),'Exercises')]")));
		//This will return the list of attributes
		System.out.println(driver.findElements(By.xpath("//a[@id]")).size());
	}
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
}
