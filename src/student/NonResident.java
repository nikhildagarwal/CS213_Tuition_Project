package student;

public class NonResident extends Student{

    public NonResident(Profile profile, Major major, int creditCompleted){
        super(profile,major,creditCompleted);
    }

    @Override
    public String toString(){
        return super.toString() + " (non-resident)";
    }

    public static void main (String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        NonResident res = new NonResident(p,Major.CS,132);
        System.out.println(res);
    }
}
