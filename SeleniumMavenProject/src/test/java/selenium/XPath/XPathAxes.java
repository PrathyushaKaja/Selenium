package selenium.XPath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathAxes {
/*
 * To find the element we use attribute or text. 
 * If there are no attributes and text then we have to use axes. 
 * Even if we have attributes and text it may contains duplicate elements then it is not unique element.
 * 
 * label - current element - reference
 * Text box - target element 
 * 
 * We have to check the relation between current element and target element,
 * then we can perform the action this is called Xpath axes.
 * 
 * Relationships:
 * ancestor
 * parent
 * child
 * sibling
 * descendant
 * 
 * Ancestor: parent+grand parents
 * 1. ancestor
 * 2. ancestor-or-self 
 * 
 * descendant: child+grand children
 * 1. descendant
 * 2. descendant-or-self
 * 
 * sibling
 * 1. preceding-sibling
 * 2. following-sibling
 * 
 * child -- child
 * parent -- parent
 * 
 * preceding
 * following
 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		//Following-sibling
		highlight(driver, driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[@type='text']")));
		//Preceding-sibling
		driver.findElement(By.xpath("//td[text()='Maria Anders']/preceding-sibling::td/child::input")).click();
		//child
	    List<WebElement> ele = driver.findElements(By.xpath("//table[@id='contactList']/child::tbody/child::tr"));
	    for (WebElement webElement : ele) {
			highlight(driver, webElement);
		}
	    //parent
	    highlight1(driver,driver.findElement(By.xpath("//td[text()='Giovanni Rovelli']/parent::tr")));
	    //ancestor
	    List<WebElement> count = driver.findElements(By.xpath("//td[text()='Roland Mendel']/ancestor::*"));
	    System.out.println("Ancestor count: "+count.size());
	    //ancestor-or-self
	    List<WebElement> anscount = driver.findElements(By.xpath("//td[text()='Roland Mendel']/ancestor-or-self::*"));
	    System.out.println("Ancestor-or-self count: "+anscount.size());
	    //descendant
	    List<WebElement> desCount = driver.findElements(By.xpath("//table[@id='contactList']/descendant::tr"));
	    System.out.println("Descendant count:"+desCount.size());
	    //descendant-or-self
	    List<WebElement> des1Count = driver.findElements(By.xpath("//table[@id='contactList']/descendant-or-self::*"));
	    System.out.println("Descendant count:"+des1Count.size());
	    //following
	    highlight1(driver, driver.findElement(By.xpath("//label[text()='Password']/following::input[1]")));
	    //preceding
	    highlight(driver, driver.findElement(By.xpath("//button[text()='Clear']/preceding::button")));
	}
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
	public static void highlight1(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid black; background:green')", element);
	}
}
