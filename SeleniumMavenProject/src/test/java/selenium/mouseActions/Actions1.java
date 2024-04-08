package selenium.mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions1 {
/*
 * MoveToElement(Automation Terminology) or Mouse Hover action
 * Click 
 * Double-click
 * Right click or context click(Automation Terminology)
 */
	/*If we want to perform actions on the hardware peripherals then we have to create an 
	 * instance for the actions class */
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/blog/mouse-hover-in-selenium/");
		Actions actions = new Actions(driver);
		actions//Methods-chaining
		.moveToElement(driver.findElement(By.xpath("//a[.='Platform ']")))
		.moveToElement(driver.findElement(By.xpath("//h3[contains(text(),'Selenium Testing')]")))
		.click()
		.perform();//without this method actions will not get performed 
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[contains(text(),'Start free with Email')]")).click();
		driver.findElement(By.id("email")).sendKeys("P@gmail");
		actions.doubleClick(driver.findElement(By.id("email"))).perform();//Double-click action
		driver.quit();
	}

}
