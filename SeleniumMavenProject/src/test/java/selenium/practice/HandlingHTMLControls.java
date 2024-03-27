package selenium.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingHTMLControls {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://scxv.appian.community/suite/design/lMBkhfYMQ3WH4e_sSCXugtzcjfhAdO8X8cIbCHfmlg4ybkw-RSyFigESWaqkI5WO1fiKGfAbYERYCsgxbLQuJLMX-jTKeX2HvhaJ7FATg1hLDN7fw");
		driver.findElement(By.xpath("//input[@type='button']")).click();
		WebElement uName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		uName.sendKeys("saiprathyusha.kaja@yexle.com");
		String username = uName.getAttribute("value");
		System.out.println(username);
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("prathyusha2000");
		String pwd = password.getAttribute("value");
		System.out.println(pwd);
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='remember']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", checkbox);
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", checkbox);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebElement text = driver.findElement(By.xpath("//input[@id='58e55fbf71087d9b4ac9f896c051e1d7']"));
		text.sendKeys("strawberry");
		String textValue = text.getAttribute("value");
		System.out.println(textValue);
		List<WebElement> radiobtns = driver.findElements(By.xpath("//input[@type='radio']"));
		for (WebElement options : radiobtns) {
			System.out.println(options);
		}
	}

}
