package selenium.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCheckBoxes {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		driver.manage().window().maximize();
		
		//Selecting single checkbox
		/*WebElement singlechkbox = driver.findElement(By.id("chinesechbx"));
		singlechkbox.click();
		String a = singlechkbox.getAttribute("id");
		System.out.println(a);
		*/
		
		//Selecting all the checkboxes
		List<WebElement> chkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		//With FOR loop
		/*for(int i=0;i<chkboxes.size();i++) {
			chkboxes.get(i).click();
		}*/
		//With FOREACH loop
		/*for (WebElement webElement : chkboxes) {
			webElement.click();
		}*/
		
		//Selecting multiple checkboxes
		/*for (WebElement value : chkboxes) {
			String b = value.getAttribute("id");
			if(b.equals("chinesechbx")||b.equals("frenchchbx")) {
				value.click();
			}
		}*/
		
		//Selecting last 2 checkboxes
		int totalCheckboxes = chkboxes.size();
		/*for(int i=totalCheckboxes-2;i<totalCheckboxes;i++) {
			chkboxes.get(i).click();
		}*/
		
		//Selecting first 2 checkboxes
		for(int i=0;i<totalCheckboxes;i++) {
			if(i<2) {
				chkboxes.get(i).click();
			}
		}
	}

}
