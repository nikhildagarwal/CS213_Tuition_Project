package student;

/**
 * Implementation of subclass TriState which extends to parent class NonResident
 * Contains instance variable state
 * Contains overrided methods such as toString
 * @author Nikhil Agarwal, Hyeon Oh
 */
public class TriState extends NonResident{

    private String state;

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

    public static void main (String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        TriState res = new TriState(p,Major.CS,132,"NJ");
        System.out.println(res);
    }
}
