package student;

/**
 * Implementation of the subclass Resident that extends superclass Student
 * Contains overrided methods toString, getType, isResident, tuitionDue
 * @author Nikhil Agarwal, Hyeon Oh
 */
public class Resident extends Student {

    public static final int FULL_TIME = 12;
    public static final int EXTRA_FULL_TIME = 16;

    public static final double RESIDENT_CREDIT_PRICE = 404;

    public static final double UNIVERSITY_FEE = 3268;
    public static final double PART_TIME_UNIVERSITY_FEE = UNIVERSITY_FEE*0.8;
    public static final double RESIDENT_TUITION = 12536;

    private int scholarship;

    /**
     * Constructor of Resident class
     * @param profile profile of the student
     * @param major major of the student
     * @param creditCompleted creditsCompleted by the student
     * @param scholarship scholarship amount of the student
     */
    public Resident(Profile profile, Major major, int creditCompleted, int scholarship){
        super(profile,major,creditCompleted);
        this.scholarship = scholarship;
    }

    /**
     * Overrides toString
     * @return invokes the superclass toString method and adds resident
     */
    @Override
    public String toString(){
        return super.toString() + "(resident)";
    }

    /**
     * Used to check if the student is a resident
     * @return true if student is a resident, false otherwise
     */
    @Override
    public boolean isResident(){
        return true;
    }

    /**
     * gets the type of student
     * @return returns "(Resident)" which when getType() is invoked
     */
    @Override
    public String getType(){
        return "(Resident)";
    }

    /**
     * Calculates the student's tuition
     * @param creditsEnrolled credits enrolled by the student
     * @return returns tuition of the student
     */
    @Override
    public double tuitionDue(int creditsEnrolled){
        double tuition = 0;
        if(creditsEnrolled<FULL_TIME){
            tuition = creditsEnrolled * RESIDENT_CREDIT_PRICE;
            tuition += PART_TIME_UNIVERSITY_FEE;
        }else if(creditsEnrolled>EXTRA_FULL_TIME){
            tuition += RESIDENT_TUITION+UNIVERSITY_FEE;
            tuition += (creditsEnrolled-EXTRA_FULL_TIME) * RESIDENT_CREDIT_PRICE;
        }else{
            tuition += RESIDENT_TUITION+UNIVERSITY_FEE;
        }
        return tuition;
    }


    public static void main (String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        Resident res = new Resident(p,Major.CS,132,0);
        System.out.println(res);
    }

}
