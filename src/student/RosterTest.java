package student;

import org.junit.Test;

import static org.junit.Assert.*;

public class RosterTest {

    @Test
    public void addInternationalTrue() {
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        International i = new International(p,Major.MATH,101,true);
        Roster roster = new Roster();
        assertTrue(roster.add(i));

    }

    @Test
    public void addInternationalFalse()
    {
        //will return false since we can't return same student again
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        International i = new International(p,Major.MATH,101,true);
        Roster roster = new Roster();
        roster.add(i);

        assertFalse(roster.add(i));

    }

    @Test
    public void addTriStateTrue()
    {
        Date d = new Date();
        Profile p = new Profile("Funcheon", "Hope", d);
        TriState res = new TriState(p, Major.CS, 132, "NJ");
        Roster roster = new Roster();
        assertTrue(roster.add(res));

    }

    @Test
    public void addTriStateFalse()
    {
        //will return false since we can't add same student again
        Date d = new Date();
        Profile p = new Profile("Funcheon", "Hope", d);
        TriState res = new TriState(p, Major.CS, 132, "NJ");
        Roster roster = new Roster();
        roster.add(res);

        assertFalse(roster.add(res));
    }
}

