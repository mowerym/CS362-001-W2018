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
import sun.util.calendar.Gregorian;

import static org.junit.Assert.*;

public class TimeTableTest {
	/**
	 *
	 * initial test
	 */
	 @Test
	  public void test01()  throws Throwable  {
	 	LinkedList<Appt> lists = new LinkedList<Appt>();
	 	LinkedList<Appt> cpr = new LinkedList<Appt>();

		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 int[] recurArray={1,2,3};
		 appt.setRecurrence( recurArray, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
	 	 lists.add(appt);

	 	 TimeTable timeTable = new TimeTable();
		 GregorianCalendar firstDay = new GregorianCalendar(2016,10,15);
		 GregorianCalendar lastDay = (GregorianCalendar)firstDay.clone();
		 lastDay.add(Calendar.DAY_OF_MONTH,10);
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = timeTable.getApptRange(lists, firstDay, lastDay);

		 CalDay compare = new CalDay(firstDay);
		 compare.addAppt(appt);
		 cpr = calDays.get(0).getAppts();

		 //assertions
		 assertEquals(compare, calDays.get(0));
		 assertEquals(lists, calDays.get(0).getAppts());
		 assertEquals(appt.getRecurBy(), cpr.get(0).getRecurBy());

	 }

	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed
}
