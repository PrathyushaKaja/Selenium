package selenium.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators1 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement fName = driver.findElement(By.id("firstName"));
		WebElement lName = driver.findElement(By.name("lName"));
		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
		WebElement email = driver.findElement(By.xpath("//input[@class='bcTextBox' and @id='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
		WebElement register = driver.findElement(By.id("registerbtn"));
		WebElement successText = driver.findElement(By.id("msg"));
		WebElement clear = driver.findElement(By.xpath("//button[@id='clearbtn']"));
		String finalValue="";
		if(fName.isDisplayed()) {
			fName.sendKeys("Prathyusha");
			String name = fName.getAttribute("value");
			System.out.println(name);
			Thread.sleep(3000);
			if(lName.isDisplayed()) {
				lName.sendKeys("Kaja");
				String name1 = lName.getAttribute("value");
				System.out.print(name1);
				Thread.sleep(3000);
			}else {
				System.err.println("Lastname is not displayed");
			}
		}else {
			System.err.println("Firstname is not displayed");
		}
		for(int i=0;i<radio.size();i++) {
			WebElement values = radio.get(i);
			String a = values.getAttribute("id");
			if(a.equals("femalerb")) {
				finalValue = a;
				values.click();
				Thread.sleep(3000);
			}
			System.out.println(finalValue);
		}
		for(int i=0;i<checkbox.size();i++) {
			WebElement b = checkbox.get(i);
			String value = b.getAttribute("id");
			if(value.equals("hindichbx")||value.equals("spanishchbx")||value.equals("frenchchbx")) {
				b.click();
				Thread.sleep(3000);
			}
		}
		if(email.isDisplayed()) {
			if(email.isEnabled()) {
				email.sendKeys("prathyushakaja30@gmail.com");
				String c = email.getAttribute("value");
				System.out.println(c);
				Thread.sleep(3000);
				if(password.isEnabled()) {
					password.sendKeys("Sai@2000");
					String d = password.getAttribute("value");
					System.out.println(d);
					Thread.sleep(3000);
					if(register.isEnabled()) {
						register.click();
						Thread.sleep(3000);
						if(successText.isDisplayed()) {
							clear.click();
						}else {
							System.err.println("Success text is not displayed");
						}
					}else {
						System.err.println("Register button is not enabled");
					}
				}else {
					System.err.println("Password is not enabled");
				}
			}else {
				System.err.println("Email is not enabled");
			}
		}else {
			System.err.println("Email is not displayed");
		}
		driver.close();
	}
}
