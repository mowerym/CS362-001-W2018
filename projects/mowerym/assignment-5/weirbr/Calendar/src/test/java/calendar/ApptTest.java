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

	 @Test
	  public void test02()  throws Throwable  {
	     //get test input
	     int startHour = 10;
	     int startMinute = 30;
	     int startDay = 30;
	     int startMonth = 01;
	     int startYear = 2018;
	     String title = "an appt that shouldn't be";
	     String description = "this should happen on the 30th of Feb which shouldn't happen";

	     //constructing a new Appointment object
	     Appt appt = new Appt(startHour, 
		   startMinute, 
		   startDay, 
		   startMonth, 
		   startYear, 
		   title, 
		   description);

	     //assertions
	     assertTrue(appt.getValid());
	     assertEquals(10, appt.getStartHour());
	     assertEquals(30, appt.getStartMinute());
	     assertEquals(30, appt.getStartDay());
	     assertEquals(01, appt.getStartMonth());
	     assertEquals(2018, appt.getStartYear());
	     assertEquals("an appt that shouldn't be", appt.getTitle());
	     assertEquals("this should happen on the 30th of Feb which shouldn't happen", appt.getDescription());
		 
	 }
		 
//add more unit tests as you needed
	@Test
	public void test03() throws Throwable {
	
	     //test input
	     int startHour = 10;
	     int startMinute = 00;
	     int startDay = 02;
	     int startMonth = 10;
	     int startYear = 2018;
	     String title = "Class";
	     String description = "class happens at 10am on T";
	     int [] recurDays = new int[] {0};
	     int recurBy = 1;
	     int recurIncrement = 1;
	     int recurNumber = 1;


	     //constructing a new Appointment object
	     Appt appt = new Appt(startHour, 
		   startMinute, 
		   startDay, 
		   startMonth, 
		   startYear, 
		   title, 
		   description);
	     appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);

	     //assertions
	     assertTrue(appt.getValid());
	     assertEquals(10, appt.getStartHour());
	     assertEquals(00, appt.getStartMinute());
	     assertEquals(02, appt.getStartDay());
	     assertEquals(10, appt.getStartMonth());
	     assertEquals(2018, appt.getStartYear());
	     assertEquals("Class", appt.getTitle());
	     assertEquals("class happens at 10am on T", appt.getDescription());
	     assertEquals(1, appt.getRecurBy());
	     assertArrayEquals(recurDays, appt.getRecurDays());
	     assertEquals(1, appt.getRecurIncrement());
	     assertEquals(1, appt.getRecurNumber());


	}
	
}
