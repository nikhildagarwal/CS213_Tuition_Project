package test;

import org.junit.Test;
import structure.Roster;
import student.*;

import static org.junit.Assert.*;

/**
 * Checks add() method and remove() in Roster.class
 * @author Hyeon Oh, Nikhil Agarwal
 */
public class RosterTest {

    @Test
    public void addInternationalTrue() {
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        International i = new International(p, Major.MATH,101,true);
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

    @Test
    public void removeInternationalStudentTrue() {
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        International i = new International(p,Major.MATH,101,true);
        Roster roster = new Roster();
        roster.add(i);

        assertTrue(roster.remove(i));
    }

    @Test
    public void removeInternationalStudentFalse()
    {
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        International i = new International(p,Major.MATH,101,true);
        Roster roster = new Roster();
        //this time the student is not added so the student cannot be removed

        assertFalse(roster.remove(i));
    }

    @Test
    public void removeTriStateTrue()
    {
        Date d = new Date();
        Profile p = new Profile("Funcheon", "Hope", d);
        TriState res = new TriState(p, Major.CS, 132, "NJ");
        Roster roster = new Roster();
        //student is added
        roster.add(res);
        assertTrue(roster.remove(res));
    }

    @Test
    public void removeTriStateFalse()
    {
        Date d = new Date();
        Profile p = new Profile("Funcheon", "Hope", d);
        TriState res = new TriState(p, Major.CS, 132, "NJ");
        Roster roster = new Roster();
        //student is not added to the roster so cannot be removed.
        assertFalse(roster.remove(res));
    }
}

