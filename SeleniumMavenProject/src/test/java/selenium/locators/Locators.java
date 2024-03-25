package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/login");
		highlight(driver,driver.findElement(By.id("login_field")));//Id locator
		Thread.sleep(3000);//it will rest for 3 seconds
		highlight(driver,driver.findElement(By.name("password")));//Name locator
		Thread.sleep(3000);
		highlight(driver,driver.findElement(By.className("header-logo")));//Class name locator
		Thread.sleep(3000);
		highlight(driver,driver.findElement(By.linkText("Forgot password?")));//Link text locator
		Thread.sleep(3000);
		highlight(driver,driver.findElement(By.partialLinkText("Create an")));//Partial Link text locator
		Thread.sleep(3000);
		highlight(driver,driver.findElement(By.tagName("h1")));//Tag name locator
		Thread.sleep(3000);
		highlight(driver,driver.findElement(By.xpath("//label[contains(text(),\"Username or email address\")]")));//Xpath locator
		Thread.sleep(3000);
		highlight(driver,driver.findElement(By.cssSelector("input[name ='commit']")));//CSS selection locator
		driver.close();
	}
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
}
