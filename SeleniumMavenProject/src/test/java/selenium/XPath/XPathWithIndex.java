package selenium.XPath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathWithIndex {
//Index is the last option
//After performing all the combinations still if we didn't find the expected element then only we have to go for the indexing
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		highlight(driver, driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr)[2]")));
		highlight(driver, driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr/td)[24]")));
		driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr/td[1]/input[@type='checkbox'])[1]")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr/td"));
		WebElement name = driver.findElement(By.xpath("//td[text()='Austria']"));
		for (WebElement webElement : elements) {
			if(webElement.equals(name)) {
				highlight(driver, webElement);
			}
		}
	}
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
}
