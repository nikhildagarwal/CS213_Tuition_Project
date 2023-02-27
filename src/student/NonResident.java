
package student;

/**
 * Implementation of subclass NonResident that extends to Student superclass
 * Contains overrided methods such as toString
 * Contains methods to calculate tuition, type of nonresident student, checking to see whether or not student is a resident
 * @author Nikhil Agarwal, Hyeon Oh
 */
public class NonResident extends Student {
    public static final int FULL_TIME = 12;
    public static final int EXTRA_FULL_TIME = 16;

    public static final double NONRESIDENT_CREDIT_PRICE = 966;

    public static final double UNIVERSITY_FEE = 3268;
    public static final double PART_TIME_UNIVERSITY_FEE = UNIVERSITY_FEE * 0.8;
    public static final double NONRESIDENT_TUITION = 29737;

    /**
     * Constructor for the NonResident object
     * @param profile profile of the NonResident student
     * @param major major of the NonResident student
     * @param creditCompleted creditCompleted of the NonResident student
     */
    public NonResident(Profile profile, Major major, int creditCompleted){
        super(profile,major,creditCompleted);
    }

    /**
     * Overrides the toString method
     * @return invokes the superclass toString and adds non-resident information
     */
    @Override
    public String toString(){
        return super.toString() + "(non-resident)";
    }

    /**
     * checks to see if the student is a resident
     * @return returns false
     */
    @Override
    public boolean isResident(){
        return false;
    }

    /**
     * gets the type of the student
     * @return returns a String "(Non-Resident)"
     */
    @Override
    public String getType(){
        return "(Non-Resident)";
    }

    /**
     * Calculates the tuition due for a NonResident student
     * @param creditsEnrolled of the NonResident student
     * @return tuition which is the amount due assigned to the NonResident student
     */
    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuition = 0;
        if(creditsEnrolled<FULL_TIME){
            tuition = creditsEnrolled * NONRESIDENT_CREDIT_PRICE;
            tuition += PART_TIME_UNIVERSITY_FEE;
        }else if(creditsEnrolled>EXTRA_FULL_TIME){
            tuition += NONRESIDENT_TUITION+UNIVERSITY_FEE;
            tuition += (creditsEnrolled-EXTRA_FULL_TIME) * NONRESIDENT_CREDIT_PRICE;
        }else{
            tuition += NONRESIDENT_TUITION+UNIVERSITY_FEE;
        }
        return tuition;
    }

    public static void main (String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        NonResident res = new NonResident(p,Major.CS,132);
        System.out.println(res);
    }
}
