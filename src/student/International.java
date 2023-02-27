package student;

/**
 * Class to implement International subclass which extends to its parent class NonResident
 * Contains instance variable isStudyAbroad which will be used in tuition calculation purposes
 * Contains overrided methods such as toString, isValid, and getType
 * @author Nikhil Agarwal, Hyeon Oh
 */
public class International extends NonResident{

    public boolean isStudyAbroad;

    public static final int MAX_STUDY_ABROAD_CREDITS = 12;
    public static final int MIN_INTERNATIONAL_CREDITS_ENROLLED = 12;
    public static final double HEALTHCARE_FEE = 2650;

    /**
     * Constructor of the International subclass
     * This constructor will have isStudyAbroad set to false as default
     * @param profile of the international student
     * @param major major of the international student
     * @param creditCompleted creditCompleted of the international student
     */
    public International(Profile profile,Major major, int creditCompleted){
        super(profile,major,creditCompleted);
        this.isStudyAbroad = false;
    }

    /**
     * Constructor for the International subclass
     * @param profile profile of the international student
     * @param major major of the international student
     * @param creditCompleted creditCompleted of the international student
     * @param isStudyAbroad value of whether or not the student is studying abroad
     */
    public International(Profile profile, Major major, int creditCompleted, boolean isStudyAbroad){
        super(profile,major,creditCompleted);
        this.isStudyAbroad = isStudyAbroad;
    }

    /**
     * Overrides the toString method
     * @return invokes the parent class toString and shows whether or not the student is studying abroad
     */
    @Override
    public String toString(){
        if(isStudyAbroad == false){
            return super.toString()+"(international)";
        }else{
            return super.toString()+"(international:study abroad)";
        }
    }

    /**
     * Gets the type of international student
     * @return if the student is studying abroad, returns a String that tells that the international student is studying abroad
     */
    @Override
    public double tuitionDue(int creditEnrolled){
        if(isStudyAbroad){
            return UNIVERSITY_FEE + HEALTHCARE_FEE;
        }else{
            double tuition = UNIVERSITY_FEE + HEALTHCARE_FEE + NONRESIDENT_TUITION;
            if(creditEnrolled>EXTRA_FULL_TIME){
                return tuition + (creditEnrolled - EXTRA_FULL_TIME) * NONRESIDENT_CREDIT_PRICE;
            }else{
                return tuition;
            }
        }
    }

    @Override
    public String getType(){
        if(isStudyAbroad){
            return "(International student study abroad)";
        }
        return "(International student)";
    }

    /**
     * method which checks whether or not the student's credit fall within the range of an international student that is abroad
     * @param creditsEnrolled creditsEnrolle of the student
     * @return true if the number of creditsEnrolled are valid, false otherwise
     */
    @Override
    public boolean isValid(int creditsEnrolled){
        if(isStudyAbroad){
            if(creditsEnrolled>=MIN_CREDITS_ENROLLED && creditsEnrolled<=MAX_STUDY_ABROAD_CREDITS){
                return true;
            }else{
                return false;
            }
        }else{
            if(creditsEnrolled>=MIN_INTERNATIONAL_CREDITS_ENROLLED && creditsEnrolled<=MAX_CREDITS_ENROLLED){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        International i = new International(p,Major.MATH,101,true);
        Resident r = new Resident(p,Major.CS,20,100);
        System.out.println(i.equals(r));
        System.out.println(i);
    }
}
