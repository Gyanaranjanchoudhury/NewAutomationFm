package genaricUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This methods is used to generate random numbers 
	 * 
	 * @return
	 */
	public int toGetRandomNumber()
	{
		Random r=new Random();
		int random=r.nextInt(1000);
		return random;	
	}
	
	/**
	 * This method is used to get system date and time in format 
	 * 
	 * @return
	 */
	public String toGetSystemDateAndTime()
	{
		Date d=new Date();
		String[] date = d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":","-");
		String year = date[5];
		String finaldate = day+" "+month+" "+date1+" "+time+" "+year;
		return  finaldate;								
	}
}
