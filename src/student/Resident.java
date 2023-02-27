package student;

/**
 * Implementing subclass Resident that extends Student
 * Contains overrided methods
 * @author Nikhil Agarwal, Hyeon Oh
 */
public class Resident extends Student {
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



    public static void main (String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        Resident res = new Resident(p,Major.CS,132,0);
        System.out.println(res);
    }

}
