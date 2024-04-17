package selenium.keyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionWithMultipleKeys {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://text-compare.com/");
		WebElement inp1 = driver.findElement(By.name("text1"));
		inp1.sendKeys("Welcome to selenium practice");
		Actions actions = new Actions(driver);
		//CTRL+A
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		//CTRL+C
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		//Tab shift 
		actions.sendKeys(Keys.TAB);
		//CTRL+V
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		WebElement compare = driver.findElement(By.xpath("//div[text()='Compare!']"));
		compare.click();
		
	}

}
