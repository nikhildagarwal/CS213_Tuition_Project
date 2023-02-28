package test;

import org.junit.Test;
import student.Date;
import student.International;
import student.Major;
import student.Profile;

import static org.junit.Assert.*;

/**
 * Checks tuitionDue() method in Internation Class which extends the student class.
 * @author Hyeon Oh, Nikhil Agarwal
 */
public class InternationalTest {

    @Test
    public void tuitionDue_international_abroad() {

        //international student abroad with 12 credits
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        International i = new International(p, Major.MATH,12,true);
        //international student abroad should be $5918
        assertEquals(5918.00, i.tuitionDue(12),0);

    }

    @Test
    public void tuitionDue_international_notabroad()
    {
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        International i = new International(p,Major.MATH,12,false);
        //international student not abroad should be $35655
        assertEquals(35655.00, i.tuitionDue(12),0);

    }
}