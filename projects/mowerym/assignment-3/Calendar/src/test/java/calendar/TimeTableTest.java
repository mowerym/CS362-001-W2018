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
//import sun.util.calendar.Gregorian;

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

		 int startHour=15;
		 int startMinute=30;
		 int startDay=21;
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

		 int[] recurArray={2,3,4};
		 appt.setRecurrence( recurArray, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
	 	 lists.add(appt);

	 	 TimeTable timeTable = new TimeTable();
		 GregorianCalendar firstDay = new GregorianCalendar(2018,01,21);
		 GregorianCalendar lastDay = (GregorianCalendar)firstDay.clone();
		 lastDay.add(Calendar.DAY_OF_MONTH,10);
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = timeTable.getApptRange(lists, firstDay, lastDay);

		 CalDay compare = new CalDay(firstDay);
		 compare.addAppt(appt);
		 cpr = calDays.get(0).getAppts();

		 //assertions
		 //assertEquals("", calDays.get(0));
		 assertEquals(lists, calDays.get(0).getAppts());
		 assertEquals(appt.getRecurBy(), cpr.get(0).getRecurBy());

	 }

	/**
	 *
	 * other tests including permute
	 */

	@Test
	  public void test02()  throws Throwable  {
		LinkedList<Appt> list1 = new LinkedList<Appt>();
		LinkedList<Appt> list2 = new LinkedList<Appt>();

		int startHour=15;
		int startMinute=30;
		int startDay=21;
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

		int[] recurArray={2,3,4};
		appt.setRecurrence( recurArray, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
		list1.add(appt);

		startHour = 15;
		startMinute=30;
		startDay=22;
		startMonth=01;
		startYear=2018;
		title="Second appt";
		description="This is the second appt.";
		//Construct a new Appointment object with the initial data
		Appt appt2 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		appt2.setRecurrence( recurArray, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
		list1.add(appt2);

		int[] temp = {1,0};

		TimeTable timeTable = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2018,01,21);
		GregorianCalendar lastDay = (GregorianCalendar)firstDay.clone();
		lastDay.add(Calendar.DAY_OF_MONTH,5);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(list1, firstDay, lastDay);

		list1 = timeTable.permute(list1,temp);

		//assertions
		assertEquals(list1.get(0).getStartHour(),appt.getStartHour());
	 }
}
