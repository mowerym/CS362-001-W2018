package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
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
		 Appt appt2 = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);
	// assertions
		 assertTrue(appt.getValid());
		 assertTrue(appt2.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 appt.setStartHour(21);
		 appt.setStartMinute(30);
		 appt.setStartDay(15);
		 appt.setStartMonth(01);
		 assertEquals("\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
		 appt.setStartYear(2018);
		 assertEquals("\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 assertEquals(false, appt.isRecurring());
		 assertEquals(0, appt.getRecurIncrement());
		 assertEquals(0, appt.getRecurNumber());
		 assertEquals(2, appt.getRecurBy());
		 assertNotNull(appt.getRecurDays());
		 assertNotNull(appt.compareTo(appt2));
		 appt.setTitle("");
		 appt.setDescription("");
		 assertEquals("\t1/15/2018 at 9:30pm ,, \n", appt.toString());
		 appt.setStartHour(12);
		 assertEquals("\t1/15/2018 at 12:30pm ,, \n", appt.toString());
	 }

	/**
	 *
	 * test that the isValid works
	 */
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=25;
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
		 // assertions
		 assertFalse(appt.getValid());
	 }

	/**
	 *
	 * test that the isValid works
	 */
	@Test
	public void test03()  throws Throwable {
		int startHour = 12;
		int startMinute = 70;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		// assertions
		assertFalse(appt.getValid());
	}

	/**
	 *
	 * test that the isValid works
	 */
	@Test
	public void test04()  throws Throwable {
		int startHour = 24;
		int startMinute = 30;
		int startDay = 32;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		// assertions
		assertFalse(appt.getValid());
	}

	/**
	 * Test that the gets methods work as expected. null check
	 */
	@Test
	public void test05()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title= null;
		String description=null;
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear,
				title,
				description);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
	}

	/**
	 * Test
	 */
	@Test
	public void test06()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title= "recurring stuff";
		String description="stuff that recurs";
		int[] recurringDays = new int[0];
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear,
				title,
				description);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(0, appt.getRecurNumber());
		assertEquals(2, appt.getRecurBy());
		assertEquals(0, appt.getRecurIncrement());
		assertFalse(appt.isRecurring());
		assertEquals("9:30pm", appt.represntationApp());
	}

	/**
	 * Test
	 */
	@Test
	public void test07()  throws Throwable  {
		int startHour=0;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title= "recurring stuff";
		String description="stuff that recurs";
		int[] recurringDays = new int[0];
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear,
				title,
				description);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(0, appt.getRecurNumber());
		assertEquals(2, appt.getRecurBy());
		assertEquals(0, appt.getRecurIncrement());
		assertFalse(appt.isRecurring());
		assertEquals("12:30am", appt.represntationApp());
		assertEquals("\t1/15/2018 at 12:30am ,recurring stuff, stuff that recurs\n", appt.toString());
		assertEquals(0, appt.compareTo(appt));
	}

	/**
	 * Test
	 */
	@Test
	public void test08()  throws Throwable  {
		int startHour=0;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title= "recurring stuff";
		String description="stuff that recurs";
		int[] recurringDays = null;
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear,
				title,
				description);
		// assertions
		assertTrue(appt.getValid());
		appt.setRecurrence(recurringDays, 2, 2, 3);
		assertEquals(3, appt.getRecurNumber());
		assertEquals(2, appt.getRecurBy());
		assertEquals(2, appt.getRecurIncrement());
		assertNotNull(appt.getRecurDays());
	}

	/**
	 * Test
	 */
	@Test
	public void test09()  throws Throwable  {
		int startHour=3;
		int startMinute=0;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title= "recurring stuff";
		String description="stuff that recurs";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear,
				title,
				description);

		Appt appt2 = new Appt(startHour,
				59 ,
				startDay ,
				startMonth ,
				startYear,
				title,
				description);

		Appt appt3 = new Appt(startHour,
				15 ,
				1 ,
				startMonth ,
				startYear,
				title,
				description);

		int startDay2 = CalendarUtil.NumDaysInMonth(startYear,startMonth-1);
		Appt appt4 = new Appt(startHour,
				15 ,
				startDay2 ,
				startMonth ,
				startYear,
				title,
				description);

		Appt appt5 = new Appt(startHour,
				15 ,
				startDay ,
				12 ,
				startYear,
				title,
				description);


		// assertions
		assertEquals(true, appt.getValid());
		assertEquals(true, appt2.getValid());
		assertEquals(true, appt3.getValid());
		assertEquals(true, appt4.getValid());
		assertEquals(true, appt5.getValid());
		appt.setStartMinute(3);
		assertTrue(appt.getValid());
		assertEquals(3, appt.getStartMinute());
		appt2.setStartMinute(40);
		assertEquals(40, appt2.getStartMinute());
		assertTrue(appt2.getValid());
		appt3.setStartDay(5);
		assertTrue(appt3.getValid());
		appt4.setStartDay(startDay2);
		appt5.setStartMonth(12);
	}

	/**
	 *
	 * test that the isValid works
	 */
	@Test
	public void test10()  throws Throwable  {
		int startHour=12;
		int startMinute=70;
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
		// assertions
		assertFalse(appt.getValid());
	}

	/**
	 *
	 * test that the isValid works
	 */
	@Test
	public void test11()  throws Throwable  {
		int startHour=12;
		int startMinute=30;
		int startDay=40;
		int startMonth=01;
		int startYear=2018;
		String title="";
		String description="";

		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		// assertions
		assertFalse(appt.getValid());
		assertEquals(null, appt.toString());
	}

	/**
	 *
	 * test that the isValid works
	 */
	@Test
	public void test12()  throws Throwable  {
		int startHour=25;
		int startMinute=30;
		int startDay=40;
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
		// assertions
		assertFalse(appt.getValid());
	}

	/**
	 *
	 * test that the isValid works
	 */
	@Test
	public void test13()  throws Throwable  {
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(0,
				0 ,
				1 ,
				1 ,
				0 ,
				"Final",
				"Final test hopefully.");
		// assertions
		assertEquals(true, appt.getValid());

		for(int i = 0; i < 50; i++)
		{
			appt.setStartHour(i);
			appt.setStartMinute(0);
			appt.setStartDay(1);
			appt.setStartMonth(1);
			if(i < 0 || i > 23) assertEquals(false, appt.getValid());
			else assertEquals(true, appt.getValid());
		}
		for(int i = 0; i < 100; i++)
		{
			appt.setStartHour(0);
			appt.setStartMinute(i);
			appt.setStartDay(1);
			appt.setStartMonth(1);
			if(i < 0 || i > 59) assertEquals(false, appt.getValid());
			else assertEquals(true, appt.getValid());
		}
		for(int i = 0; i < 100; i++)
		{
			for(int j=1; j <= 12; j++)
			{
				int dayInMonth = CalendarUtil.NumDaysInMonth(2000, j-1);
				appt.setStartHour(0);
				appt.setStartMinute(0);
				appt.setStartDay(i);
				appt.setStartMonth(j);
				if(i<1 || i > dayInMonth) assertEquals(false, appt.getValid());
				else assertEquals(true, appt.getValid());
			}
		}
		appt.setStartHour(24);
		appt.setStartMinute(60);
		appt.setStartDay(32);
		assertEquals(false, appt.getValid());
	}
}
