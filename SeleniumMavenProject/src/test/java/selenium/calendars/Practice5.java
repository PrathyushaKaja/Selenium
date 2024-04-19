package selenium.calendars;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice5 {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		//User Target Date
		String targetDate="24/Aug/2025";
		Calendar cal = Calendar.getInstance();
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		sdf.setLenient(false);
		Date targetFormatDate = sdf.parse(targetDate);
		System.out.println("Target Format Date is: "+targetFormatDate);
	    cal.setTime(targetFormatDate);
		}catch(Exception e){
			throw new Exception("Enter valid target date!!!");
		}
		int targetMonth = cal.get(Calendar.MONTH);
		int targetYear = cal.get(Calendar.YEAR);
		int targetDay = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println("Target Month is: "+targetMonth);
		System.out.println("Target Year is: "+targetYear);
		System.out.println("Target Day is: "+targetDay);
		//Current Date
		driver.findElement(By.id("third_date_picker")).click();
		String selectedMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']/option[@selected]")).getText();
		String selectedYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']/option[@selected]")).getText();
		String CurrentDate = selectedMonth + " " + selectedYear;
		System.out.println("Current date is: "+CurrentDate);
		cal.setTime(new SimpleDateFormat("MMM yyyy").parse(CurrentDate));
		int currentMonth = cal.get(Calendar.MONTH);
		int currentYear = cal.get(Calendar.YEAR);
		System.out.println("Current Month is: "+currentMonth);
		System.out.println("Current Year is: "+currentYear);
		//Next and Previous Buttons
		while(targetMonth < currentMonth || targetYear < currentYear ) {
			driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-prev')]")).click();
			selectedMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']/option[@selected]")).getText();
			selectedYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']/option[@selected]")).getText();
			CurrentDate = selectedMonth + " " + selectedYear;
			cal.setTime(new SimpleDateFormat("MMM yyyy").parse(CurrentDate));
			currentMonth = cal.get(Calendar.MONTH);
			currentYear = cal.get(Calendar.YEAR);
			System.out.println("Current Month is: "+currentMonth);
			System.out.println("Current Year is: "+currentYear);
		}
		while((targetMonth > currentMonth || targetYear > currentYear )){
			driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-next')]")).click();
			selectedMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']/option[@selected]")).getText();
			selectedYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']/option[@selected]")).getText();
			CurrentDate = selectedMonth + " " + selectedYear;
			cal.setTime(new SimpleDateFormat("MMM yyyy").parse(CurrentDate));
			currentMonth = cal.get(Calendar.MONTH);
			currentYear = cal.get(Calendar.YEAR);
			System.out.println("Current Month is: "+currentMonth);
			System.out.println("Current Year is: "+currentYear);
		}
		if(targetMonth == currentMonth || targetYear == currentYear) {
			driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+targetDay+"]")).click();
		}else{
			throw new Exception("Mismatching");
		}
	}

}
