package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
	/**
	 *
	 * basic test
	 */
	 @Test
	  public void test01()  throws Throwable  {

		GregorianCalendar day = new GregorianCalendar(2016, 10,15);
		CalDay firstDay = new CalDay(day);
		CalDay secondDay = new CalDay();

		//assertions
		 assertTrue(firstDay.isValid());
		 assertFalse(secondDay.isValid());
		 assertEquals(15, firstDay.getDay());
		 assertEquals(10, firstDay.getMonth());
		 assertEquals(2016, firstDay.getYear());

	 }

	/**
	 *
	 * test with appointments
	 */

	 @Test
	  public void test02()  throws Throwable  {
		 GregorianCalendar day = new GregorianCalendar(2016, 10,15);
		 CalDay firstDay = new CalDay(day);

		 //application
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

		 firstDay.addAppt(appt);

		 LinkedList<Appt> list = new LinkedList<Appt>();
		 list.add(appt);
		 StringBuilder ledger = new StringBuilder();
		 ledger.append(" ");

		 //assertions
		 assertTrue(appt.getValid());
		 assertFalse(Objects.equals((String) ledger.toString(), (String) firstDay.toString()));
		 assertEquals(list, firstDay.getAppts());
		 assertEquals(1,firstDay.getSizeAppts());
	 }
}
