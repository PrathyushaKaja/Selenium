package selenium.calendars;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Practice3 {
//Validating the user input
	public static void main(String[] args) throws Exception {
		String targetDate = "33/Apr/2024";//User input 
		//Below line will format the target date to the formatted date because target date is an string. So, here we are converting the string to the date format
		try {
			//Formating the date according to the user input
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			//If setLenient set to false then extra dates will not 
			dateFormat.setLenient(false);
			Date formattedDate = dateFormat.parse(targetDate);
			System.out.println(formattedDate);
		} catch (Exception e) {
			throw new Exception("Enter valid target date!!");
		}
	}

}
