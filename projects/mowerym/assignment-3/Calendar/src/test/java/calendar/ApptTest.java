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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
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
		int startHour = 24;
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
}
