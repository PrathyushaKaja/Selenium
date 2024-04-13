package selenium.XPath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathFunctions {
	/*
	 * XPath provides few pre-defined functions
	 * 1. text()
	 * 2. contains()
	 * 3. normalize-space() --> It will remove the spaces that to starting and ending of the sentence/word
	 * 4. starts-with() 
	 * 5. last()
	 * 6. position() --> similar to index
	 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		//text()
		highlight(driver, driver.findElement(By.xpath("//a[text()='Sign in']")));
		//contains()
		highlight(driver, driver.findElement(By.xpath("//table[@id='contactList']/tbody/tr/td[contains(text(),'UK')]")));
		//normalize-space()
		highlight(driver, driver.findElement(By.xpath("//label[normalize-space(text())='First Name']")));
		//starts-with()
		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr/td"));
		List<WebElement> ele= driver.findElements(By.xpath("//td[starts-with(text(),'M')]"));	
		for (WebElement webElement : elements) {
			for (WebElement element : ele) {
				if(webElement.equals(element)) {
					highlight(driver, webElement );
				}
			}
		}
		//last()
		highlight(driver, driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr)[last()]")));
		//position()
		highlight(driver, driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr)[position()=4]")));
	}
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
}
