package student;

/**
 * Class to implement EnrollStudent object
 * Holds profile and creditsEnrolled as parameters
 * Contains methods to fetch information about enrolled students' credits and change credits
 * Contains overrided methods toString, equals
 * @author Nikhil Agarwal, Hyeon Oh
 */
public class EnrollStudent {

    private Profile profile;
    private int creditsEnrolled;

    /**
     * Constructor for EnrollStudent object
     * @param profile profile of the student
     * @param creditsEnrolled credits enrolled of the specified student
     */
    public EnrollStudent(Profile profile, int creditsEnrolled){
        this.profile = profile;
        this.creditsEnrolled = creditsEnrolled;
    }

    /**
     * Overrides toString
     * @return returns the student's profile along with the credits enrolled
     */
    @Override
    public String toString(){
        return profile.toString()+": credits enrolled: "+creditsEnrolled;
    }

    /**
     * this method overrides the equals method of the Object class
     * @param obj which is an instance of the Object class
     * @return true if the profiles are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        student.EnrollStudent enrollStudent = (student.EnrollStudent) obj;
        if(profile.equals(enrollStudent.profile)){
            return true;
        }
        return false;
    }

    /**
     * Changes the student's credits
     * @param newCredits which are the credits to be changed
     */
    public void changeCredits(int newCredits){
        creditsEnrolled = newCredits;
    }

    public static void main (String[] args){
        Date date = new Date();
        Profile profile = new Profile("Agarwal","Nikhil",date);
        student.EnrollStudent s = new student.EnrollStudent(profile,14);
    }
}
