package ProjectReport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
 
	public String GetTodayDateAndTime() {
		//DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ss");
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		//DateFormat dateFormat =new DateTime().format("dd-MM-yy");
		Date date = new Date();
		String todaydate = dateFormat.format(date);
		return todaydate;
	}
}
