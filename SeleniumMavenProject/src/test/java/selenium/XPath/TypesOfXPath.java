package selenium.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TypesOfXPath {
/*
 * It is a dynamic locator.
 * Xpath (XML Path language) is a query language for selecting nodes from an XML document or 
 * for finding the elements in HTML web page.
 * XML and HTML documents both follow same structure
 * In XML document - user defined tags will also be used
 * In HTML document - only pre-defined tags will be used. 
 * Only this is the difference between the XML and HTML 
 * Defined by world wide web consortium(W3C).
 */
/*
 * Types of xpath: Absolute xpath and Relative xpath
 * Absolute xpath - starts from the root element of the document
 * Relative xpath - starts from any point in the document based on the search criteria
 */
	//In the document index will be starting from '0'
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/");
		//Absolute Xpath
		highlight(driver, driver.findElement(By.xpath("/html/body/div/div/nav/a[4]")));
		//Relative Xpath
		highlight(driver,driver.findElement(By.xpath("//a[contains(text(),'PYTHON')]")));
	}
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}

}
