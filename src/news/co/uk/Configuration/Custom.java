package news.co.uk.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Custom {

	
	public String currentimestamp() throws Exception{
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
			 //get current date time with Date()
			 Date date = new Date();
			 String dt = dateFormat.format(date); 
			 return dt;
	}
}
