package selenium.timeouts;

import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTimeOut {
/*
 * Page load time is all about how much time is taking to load the web pages. 
 * For every web page the time will be different it depends on the several factors like
 * internet speed, and the data contained in that web page if there are images and videos then
 * it will take some time. If we are executing multiple times then the time will also change everytime
 */
 /*
  * PageLoadTimeOut--> we can set the time. If that web page is not loaded according to the
  * mentioned time then it will throw timeoutexception.
  * If the web page is loaded below the expected time then it will not wait for the mentioned time it
  * will continue the execution
  */
	//Default timeout is 300000 milli seconds which is 300 seconds 
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		Instant startTime = Instant.now();
		System.out.println(startTime.toString());
		driver.get("https://www.hyrtutorials.com/");
		Instant endTime = Instant.now();
		System.out.println(endTime.toString());
		Duration difference = Duration.between(startTime, endTime);
		System.out.println(difference.toSeconds());
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
