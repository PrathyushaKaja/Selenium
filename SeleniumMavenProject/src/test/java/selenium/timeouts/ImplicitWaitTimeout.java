package selenium.timeouts;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitTimeout {
/*
 * Implicit wait timeout is all about if the driver is taking time to find the elements then we can use 
 * this timeout.
 * After initializing the driver. We have to mention this timeout.
 * In normal case, if we are not using the implicit timeout then the driver didn't find the
 * elements which we have mentioned then immediately it will throw an exception(NoSuchElementException).
 * It will not wait even for a second. In this case, we can use implicit timeout to mention
 * certain time to search an element. And once we mentioned the timeout then it will wait 
 * and checks for every element according to the time mentioned.
 * MAX time is 30 seconds. We should not mention the time more than this.
 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver will wait 5 seconds if it didn't find that element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		Instant startTime = Instant.now();
		System.out.println(startTime.toString());
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("txt1")).sendKeys("Implicit timeout1");
		Instant endTime = Instant.now();
		System.out.println(endTime.toString());
		Duration difference  = Duration.between(startTime, endTime);
		System.out.println(difference.toSeconds());
		//This will take 10 seconds 
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("txt2")).sendKeys("Implicit timeout2");
		driver.quit();
	}

}
