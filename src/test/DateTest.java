/**
 * test classes
 * JUnit tests
 */
package test;

import org.junit.Test;
import student.Date;

import static org.junit.Assert.*;

/**
 * Checks isValid() method in Date.class
 * @author Hyeon Oh, Nikhil Agarwal
 */
public class DateTest {

    @Test
    public void test_isValid_daysInFeb_nonLeap() {
        //a non leap year should not have 29 days
        Date date = new Date("2/29/2011");
        assertFalse(date.isValid());
    }

    @Test
    public void test_isValid_daysInFeb_Leap()
    {
        //a leap year should have 29 days
        Date date = new Date("2/29/2016");
        assertTrue(date.isValid());
    }

    @Test
    public void test_isValid_invalidMonth()
    {
        //there is no month 13
        Date date = new Date("13/21/1999");
        assertFalse(date.isValid());
    }

    @Test
    public void test_isValid_invalidDays()
    {
        //no month has 32 days
        Date date = new Date("3/32/2003");
        assertFalse(date.isValid());
    }

    @Test
    public void test_isValid_invalidYear()
    {
        //date below 1900 is invalid
        Date date = new Date("1/29/1899");
        assertFalse(date.isValid());
    }

    @Test
    public void test_isValid_invalidDaysInSpecificMonth()
    {
        //the month april should only have up to 30 days
        Date date = new Date("4/31/2003");
        assertFalse(date.isValid());
    }

    @Test
    public void test_isValid_validNumberOfDaysInSpecificMonth()
    {
        //the month specified should have the correct amount of days in the date
        //in our case january does indeed have 31 days
        Date date = new Date("1/31/2003");
        assertTrue(date.isValid());
    }
}