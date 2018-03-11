package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Iterator;
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
	 * test appointments
	 */
	@Test
	public void test02() throws Throwable {
		GregorianCalendar day = new GregorianCalendar(2016, 9, 21);
		CalDay calday = new CalDay(day);
		Appt appt = new Appt(12,
				5 ,
				21 ,
				9 ,
				2016 ,
				"Thing",
				"Short Description."
				);
		calday.addAppt(appt);

		Appt appt2 = new Appt(15,
				30 ,
				12 ,
				10 ,
				2016 ,
				"Thing",
				"Short Description."
			);
		calday.addAppt(appt2);

		Appt appt3 = new Appt(9,
				50 ,
				15 ,
				6 ,
				2016 ,
				"Thing",
				"Short Description."
		);
		calday.addAppt(appt3);

		//assertinos
		Iterator<?> itr = calday.iterator();
		Object element = itr.next();
		assertEquals(appt3.toString(), element.toString());
		element = itr.next();
		assertEquals(appt.toString(), element.toString());
		element = itr.next();
		assertEquals(appt2.toString(), element.toString());
	}

	/**
	 *
	 * test with appointments
	 */

	 @Test
	  public void test03()  throws Throwable  {
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

	/**
	 *
	 * test isValid()
	 */
	 @Test
	public void test04() throws Throwable {
	 	CalDay calDays = new CalDay();

	 	//assertions
		 assertEquals(false, calDays.isValid());
	}

	/**
	 *
	 * test initialization
	 */
	@Test
	public void test05() throws Throwable {
	 	Calendar curCal = Calendar.getInstance();
	 	int thisMonth = curCal.get(Calendar.MONTH)+1;
	 	int thisYear = curCal.get(Calendar.YEAR);
	 	int today = curCal.get(Calendar.DAY_OF_MONTH);
	 	GregorianCalendar cal = new GregorianCalendar(thisYear, thisMonth, today);
		CalDay calDays = new CalDay(cal);

		//assertions
		assertEquals(true, calDays.isValid());
		assertNotNull(calDays.getMonth());
		assertNotNull(calDays.getYear());
		assertNotNull(calDays.getDay());
		assertNotNull(calDays.toString());
	}

	/**
	 *
	 * test string
	 */
	@Test
	public void test06() throws Throwable {
		GregorianCalendar cal = new GregorianCalendar(2016, 9, 21);
		CalDay calDays = new CalDay(cal);
		Appt appt = new Appt(21,
				55 ,
				21 ,
				9 ,
				2016 ,
				"Thing",
				"Short Description."
		);
		calDays.addAppt(appt);

		Iterator<Appt> itr = calDays.appts.iterator();
		Object element = itr.next();
		assertEquals("\t --- 9/21/2016 --- \n --- -------- Appointments ------------ --- \n\t9/21/2016 at 9:55pm ,Thing, Short Description.\n \n", calDays.toString());
	}

	/**
	 * test boundry checks
	 */
	@Test
	public void test07()  throws Throwable  {
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

		Calendar curCalendar = Calendar.getInstance();
		int thisMonth = curCalendar.get(Calendar.MONTH)+1;
		int thisYear = curCalendar.get(Calendar.YEAR);
		int today = curCalendar.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar cal = new GregorianCalendar(thisYear, thisMonth, today);
		CalDay calDays = new CalDay(cal);

		//assertions
		assertEquals(true, calDays.isValid());
		assertNotNull(calDays.getMonth());
		assertNotNull(calDays.getYear());
		assertNotNull(calDays.getDay());

		Appt appt2 = new Appt (23,
				32,
				17,
				03,
				2020,
				title,
				description);

		Appt appt3 = new Appt (19,
				28,
				13,
				01,
				2016,
				title,
				description);

		//assertions
		assertTrue(appt.getValid());
		assertEquals(true, appt2.getValid());
		assertTrue(appt3.getValid());
		calDays.addAppt(appt);
		assertNotNull(calDays.getAppts());
		calDays.addAppt(appt3);
		assertNotNull(calDays.getAppts());
		calDays.addAppt(appt2);
		assertNotNull(calDays.getAppts());
		assertNotNull(calDays.getSizeAppts());
		assertNotNull(calDays.toString());
		assertNotNull(calDays.iterator());
		assertNotNull(calDays.getAppts());
	}



}
