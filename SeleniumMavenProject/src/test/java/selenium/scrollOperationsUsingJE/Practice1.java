package selenium.scrollOperationsUsingJE;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {
/*
 * Scroll operations:ScrollTo and ScrollBy contains 2 parameters x-axis and y-axis
 * 1. ScrollTo/Scroll -> If we mention the points then it will scroll upto that only. if we mention the same statement again it will not scroll again
 * 2. ScrollBy -> It will scroll every time based on the mentioned points
 * 3. ScrollToVew --> It will directly scroll to the element 
 */
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500);");
		Thread.sleep(3000);
		js.executeScript("(document.evaluate(\"//div[@id='ty_footer']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue).scrollIntoView()");
	}

}
