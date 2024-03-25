package selenium.textboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTextBoxAndRadioBtn {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		driver.manage().window().maximize();
		WebElement firstName = driver.findElement(By.id("firstName"));
		WebElement lastName = driver.findElement(By.name("lName"));
		WebElement radiobtn1 = driver.findElement(By.id("malerb"));
		WebElement radiobtn2 = driver.findElement(By.id("femalerb"));
		if(firstName.isEnabled()) {
			firstName.sendKeys("prathyusha");
			String fn = firstName.getAttribute("value");
			System.out.println(fn);
			if(lastName.isEnabled()) {
				lastName.sendKeys("kaja");
				String ln = lastName.getAttribute("value");
				System.out.println(ln);
				if(radiobtn1.isSelected()) {
					radiobtn2.click();
					String btn = radiobtn2.getAttribute("id");
					System.out.println(btn);
				}else {
					System.out.println("radio button 2 is already selected");
				}
			}else {
				System.err.println("last name is not enabled");
			}
		}else {
			System.err.println("first name is not enabled");
		}	 
		driver.close();
	}

}
