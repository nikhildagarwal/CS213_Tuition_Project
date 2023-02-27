
package student;

public class NonResident extends Student {

    public NonResident(Profile profile, Major major, int creditCompleted){
        super(profile,major,creditCompleted);
    }

    @Override
    public String toString(){
        return super.toString() + "(Non-Resident)";
    }

    @Override
    public boolean isResident(){
        return false;
    }

    public String getType(){
        return "(Non-Resident)";
    }

    public static void main (String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        NonResident res = new NonResident(p,Major.CS,132);
        System.out.println(res);
    }
}
