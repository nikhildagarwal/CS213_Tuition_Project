package student;

/**
 * Implementation of subclass TriState which extends to parent class NonResident
 * Contains instance variable state
 * Contains overrided methods such as toString
 * @author Nikhil Agarwal, Hyeon Oh
 */
public class TriState extends NonResident{

    private String state;


    public static final int FULL_TIME = 12;
    public static final int EXTRA_FULL_TIME = 16;

    public static final double NY_DISCOUNT = 4000;
    public static final double CT_DISCOUNT = 5000;


    /**
     * Constructor for the TriState subclass object
     * @param profile profile of the student
     * @param major major of the student
     * @param creditCompleted creditCompleted of the student
     * @param state state of the student
     */

    public TriState(Profile profile, Major major, int creditCompleted, String state){
        super(profile,major,creditCompleted);
        this.state = state;
    }

    /**
     * Overrides the toString method
     * @return invokes the parent class toString method and adds the information that the student is from a tri-state
     */
    @Override
    public String toString(){
        return super.toString()+"(tri-state:"+state+")";
    }

    @Override
    public String getType(){
        String type = "";
        switch(state){
            case "NY":
                type = "(Tri-state NY)";
                break;
            case "CT":
                type = "(Tri-state CT)";
        }
        return type;
    }

    @Override
    public double tuitionDue(int creditEnrolled){
        if(creditEnrolled<FULL_TIME){
            return super.tuitionDue(creditEnrolled);
        }else{
            double temp = super.tuitionDue(creditEnrolled);
            switch(state){
                case "NY":
                    temp -= NY_DISCOUNT;
                    break;
                case "CT":
                    temp -= CT_DISCOUNT;

            }
            return temp;
        }
    }

    public static void main (String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        TriState res = new TriState(p,Major.CS,132,"NJ");
        System.out.println(res);
    }
}
