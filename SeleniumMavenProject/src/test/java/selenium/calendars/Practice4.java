package selenium.calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice4 {
    public static int calenderDay3 = 10;
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        //Third Calendar
        driver.findElement(By.id("third_date_picker")).click();
        WebElement month = driver.findElement(By.className("ui-datepicker-month"));
        Select monthDropdown = new Select(month);
        List<WebElement> options = monthDropdown.getOptions();
        for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}
        monthDropdown.selectByVisibleText("Nov");
        WebElement year = driver.findElement(By.className("ui-datepicker-year"));
        Select yearDropdown = new Select(year);
        List<WebElement> yearOptions = yearDropdown.getOptions();
        for (WebElement webElement : yearOptions) {
			System.out.println(webElement.getText());
		}
        yearDropdown.selectByVisibleText("2026");
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+calenderDay3+"]")).click();
    }
}