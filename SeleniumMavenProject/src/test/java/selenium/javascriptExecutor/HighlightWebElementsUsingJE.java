package selenium.javascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighlightWebElementsUsingJE {
/*
 * To highlight the element 
 * We have to use css attributes
 * 1. border
 * 2. background
 * 3. border + background
 * 
 * These attributes are contained in style 
 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("document.getElementById('email').style.background='pink';");
		//js.executeScript("document.getElementById('email').style.border='10px blue solid';");
		js.executeScript("document.getElementsByName('pass')[0].setAttribute('style','border:5px pink solid;background:yellow');");
	}
}
