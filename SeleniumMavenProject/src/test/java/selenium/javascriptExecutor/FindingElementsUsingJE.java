package selenium.javascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingElementsUsingJE {
	/*In case, if we are unable to find the elements which means we can able to find only the elements 
	 * which are displayed and we can't able to find the elements which are not displayed in the html 
	 * document then we have to use javascript to find those kind of elements.
	 * 
	 * If we are using javascript then we have create reference for Javascript executor.
	 * 
	 * Javascript executor is an interface and it contains two methods:
	 * 1.executeScript() - synchronous
	 * 2.executeAsyncScript() - Asynchronous
	 * 
	 * Remote web driver is implementing the javascript executor interface
	 * 
	 * Javascript contains two scripts: 
	 * 1.Synchronous java script
	 * 2.Asynchronous java script  mostly we don’t use this one 
	 * 
	 * We have static and dynamic locators to find the elements using javascript
	 * 1.	Id
	 * 2.	Name
	 * 3.	Classname
	 * 4.	Tagname
	 * 5.	Css selector
	 * 6.	Xpath
	 */
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		//we have to do type casting because we have created driver for webdriver reference in the previous step
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		//without return word it will not display the input which we have send using sendKeys()
		//Id
		WebElement ele1 = (WebElement) jsExecutor.executeScript("return document.getElementById('email');");
		ele1.sendKeys("Id");
		Thread.sleep(3000);
		//name
		ele1.clear();
		WebElement ele2 = (WebElement) jsExecutor.executeScript("return document.getElementsByName('email')[0];");
		ele2.sendKeys("name");
		Thread.sleep(3000);
		//className
		ele1.clear();
		WebElement ele3 = (WebElement) jsExecutor.executeScript("return document.getElementsByClassName('inputtext')[0];");
		ele3.sendKeys("classname");
		Thread.sleep(3000);
		//tagName
		ele1.clear();
		WebElement ele4 = (WebElement) jsExecutor.executeScript("return document.getElementsByTagName('input')[13];");
		ele4.sendKeys("tag name");
		Thread.sleep(3000);
		//css selector
		ele1.clear();
		WebElement ele5 = (WebElement) jsExecutor.executeScript("return document.querySelector('#email');");
		ele5.sendKeys("css selector");
		Thread.sleep(3000);
		//Xpath
		//document.evaluate(xpathExpression,contextNode,namespaceResolver,resultType,result)
		//contextNode--> document 
		ele1.clear();
		WebElement ele6 = (WebElement) jsExecutor.executeScript("return document.evaluate(\"//input[@name='email']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue;");
		ele6.sendKeys("xpath");
	}
	
}
