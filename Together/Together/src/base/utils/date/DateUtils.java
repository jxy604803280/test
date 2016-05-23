package base.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String getDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = sdf.format(date);
		return s;
	}
	public static void main(String[] args){
		System.out.println(getDate());
	}
}
