package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;


import org.junit.Test;
//import sun.awt.image.ImageWatched;
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
		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 int[] recurArray={5,5,5};
		 appt.setRecurrence( recurArray, 1,1,1);
	 	 lists.add(appt);
	 	 lists.add(appt2);

	 	 TimeTable timeTable = new TimeTable();
	 	 LinkedList<CalDay> CalDays;
		 GregorianCalendar firstDay = new GregorianCalendar(2018,01,21);
		 GregorianCalendar lastDay = new GregorianCalendar(2018, 01, 23);
		 lastDay.add(Calendar.DAY_OF_MONTH,10);
		 //LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 CalDays = timeTable.getApptRange(lists, firstDay, lastDay);
		 assertEquals(12, CalDays.size());
		 Iterator<Appt> itr1 = CalDays.get(0).appts.iterator();
		 Object element = itr1.next();
		 assertEquals(appt.toString(), element.toString());
		 Iterator<Appt> itr2 = CalDays.get(1).appts.iterator();
		 Object element2 = itr2.next();
		 assertEquals(appt2.toString(), element.toString());
		 CalDay compare = new CalDay(firstDay);
		 compare.addAppt(appt);
		 cpr = CalDays.get(0).getAppts();

		 //assertions
		 //assertEquals("", calDays.get(0));
		 assertEquals(lists, CalDays.get(0).getAppts());
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

	/**
	 *
	 * permute continued
	 */

	@Test
	public void test03()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 2, 12);
		GregorianCalendar tomorrow = new GregorianCalendar(2018, 2, 12);

		int startHour=15;
		int startMinute=30;
		int startDay=12;
		int startMonth=02;
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

		Appt appt2 = new Appt(startHour + 1,
				startMinute + 1 ,
				startDay + 1 ,
				startMonth ,
				startYear ,
				title,
				description);

		Appt appt3 = new Appt(startHour + 3,
				startMinute + 3 ,
				startDay + 3 ,
				startMonth + 3 ,
				startYear ,
				title,
				description);

		LinkedList<Appt> list1 = new LinkedList<Appt>();
		list1.add(appt);
		list1.add(appt2);
		list1.add(appt3);

		TimeTable tables = new TimeTable();
		int ar[] = {2, 1, 0};
		LinkedList<Appt> appts2;
		appts2 = tables.permute(list1, ar);

		//assert
		assertEquals("Birthday Party", appts2.get(0).getTitle());

		int ar2[] = {0,1,2};
		appts2 = tables.permute(list1, ar2);

		//assert
		assertEquals("Birthday Party", appts2.get(0).getTitle());

		int ar3[] = {1,0,2};
		appts2 = tables.permute(list1, ar3);

		//assert
		assertEquals("Birthday Party", appts2.get(0).getTitle());

		int ar4[] = {0,2,1};
		appts2 = tables.permute(list1, ar4);

		//assert
		assertEquals("Birthday Party", appts2.get(0).getTitle());
	}

	/**
	 * 	 Final Test
	 */
	@Test
	public void test04() throws Throwable {
		TimeTable tables = new TimeTable();
		GregorianCalendar today = new GregorianCalendar(2018, 2, 12);
		GregorianCalendar tomorrow = new GregorianCalendar(2018, 2, 20);
		CalDay calDay = new CalDay(today);
		CalDay calDay2 = new CalDay(tomorrow);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		Appt appt = new Appt(12,
				00 ,
				15 ,
				2 ,
				2018,
				"Test",
				"Test appt");

		Appt appt2 = new Appt(12,
				00 ,
				15 ,
				2 ,
				2019,
				"Test2",
				"Test appt2");

		Appt appt3 = new Appt(-1,
				00 ,
				05 ,
				06 ,
				2019,
				"Test3",
				"Test appt3");

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt);
		appts.add(appt2);
		appts.add(appt3);

		calDays = tables.getApptRange(appts, today, tomorrow);
		// assertions
		assertEquals(false, appt3.getValid());
		assertEquals(null, tables.deleteAppt(appts, appt));
		assertEquals(null, tables.deleteAppt(appts, appt3));
	}
}
