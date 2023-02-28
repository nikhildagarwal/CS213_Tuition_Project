package student;

import org.junit.Test;

import static org.junit.Assert.*;

public class InternationalTest {

    @Test
    public void tuitionDue_international_abroad() {

        //international student abroad with 12 credits
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        International i = new International(p,Major.MATH,12,true);
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