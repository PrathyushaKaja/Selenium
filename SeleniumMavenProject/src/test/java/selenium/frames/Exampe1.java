package selenium.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exampe1 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		WebElement text = driver.findElement(By.className("frmTextBox"));
		text.sendKeys("Frames practice");
		Thread.sleep(3000);
		driver.switchTo().frame("frm1");
		WebElement a = driver.findElement(By.id("course"));
		Select courseDropdown = new Select(a);
		courseDropdown.selectByIndex(1);
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		text.clear();
		text.sendKeys("Practice 2");
		Thread.sleep(3000);
		driver.switchTo().frame("frm2");
		driver.findElement(By.id("lastName")).sendKeys("selenium");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		text.clear();
		text.sendKeys("Practice 3");
		Thread.sleep(3000);
		driver.switchTo().frame("frm3");
		driver.findElement(By.id("name")).sendKeys("Inside frame3");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frm3").switchTo().frame("frm1");
		WebElement b = driver.findElement(By.id("course"));
		Select dropdown = new Select(b);
		dropdown.selectByVisibleText("Javascript");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		text.clear();
		text.sendKeys("test");
		Thread.sleep(3000);
		driver.switchTo().frame("frm3").switchTo().frame("frm2");
		driver.findElement(By.id("firstName")).sendKeys("Java");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		text.clear();
		text.sendKeys("test1");
		driver.close();
	}

}
