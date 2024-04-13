package selenium.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathConditions {
/*
 * In Xpath, we have three conditions:
 * 1. and --> use this if both of the conditions should satisfy 
 * 2. or  --> use this if any one of the condition should satisfy
 * 3. not --> negative condition 
 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		//and condition
		highlight(driver, driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Register')]")));
		//or condition
		highlight(driver, driver.findElement(By.xpath("//a[contains(text(),'Sign in into') or text()='Sign' ]")));
		//not condition -- It will retrieve the elements even if the mentioned attribute is not there 
		System.out.println(driver.findElements(By.xpath("//input[not(@maxlength=10)]")).size());
	}
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
}
