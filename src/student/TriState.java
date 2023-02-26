package student;

public class TriState extends NonResident{

    private String state;

    public TriState(Profile profile, Major major, int creditCompleted, String state){
        super(profile,major,creditCompleted);
        this.state = state;
    }

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
