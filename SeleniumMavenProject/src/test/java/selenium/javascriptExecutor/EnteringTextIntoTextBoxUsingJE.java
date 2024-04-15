package selenium.javascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnteringTextIntoTextBoxUsingJE {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('email').value='prathyusha';");
		Thread.sleep(3000);
		js.executeScript("document.evaluate(\"//input[@type='password']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.value='selenium';");
		//performing click operation using javascript executor
		js.executeScript("document.getElementsByName('login')[0].click();");
	}
}
