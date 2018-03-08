package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
	     //testing for getNextOccurence
	     int startHour = 9;
	     int startMinute = 00;
	     int startDay = 3;
	     int startMonth = 5;
	     int startYear = 2018;
	     String title = "non-recurring event";
	     String description = "no repeats of this event";

	     Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
	     TimeTable table = new TimeTable();

	     //TEST THAT the function returns null for the next occurence
	     GregorianCalendar noRecur = new GregorianCalendar(2018, 3, 5);
	     //noRecur = null;
	     //assertEquals(0, table.getNextApptOccurence(appt, noRecur).size());
		     
	 }
	 @Test
	  public void test02()  throws Throwable  {
	     int startHour = 9;
	     int startMinute = 00;
	     int startDay = 3;
	     int startMonth = 5;
	     int startYear = 2018;
	     String title = "monthly-recurring event";
	     String description = "repeats each month";
	     int [] recurDays = new int[] {2};
	     int recurBy = 2;
	     int recurIncrement = 1;
	     int recurNumber = 5;

	     Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
	     appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
	     TimeTable table = new TimeTable();

	     GregorianCalendar origDay = new GregorianCalendar(2018, 5, 3);
	     GregorianCalendar nextDay = new GregorianCalendar(2018, 6, 3);

	     //assertEquals(nextDay, table.getNextApptOccurence(appt, origDay));
		 
	 }
//add more unit tests as you needed
}
