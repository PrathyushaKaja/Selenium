package selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingRadioButton {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		driver.manage().window().maximize();
		WebElement radiobtn1 = driver.findElement(By.id("malerb"));
		WebElement radiobtn2 = driver.findElement(By.id("femalerb"));

		if(radiobtn1.isSelected()) {
			radiobtn2.click();
			String btn = radiobtn2.getAttribute("id");
			System.out.println(btn);
		}else {
			System.out.println("radio button 2 is already selected");
		}

		driver.close();
	}

}
