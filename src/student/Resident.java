package student;

import java.util.concurrent.locks.ReentrantLock;

public class Resident extends Student {
    private int scholarship;

    public Resident(Profile profile, Major major, int creditEnrolled, int scholarship){
        super(profile,major,creditEnrolled);
        this.scholarship = scholarship;
    }

    @Override
    public String toString(){
        return super.toString() + " (resident)";
    }

    public static void main (String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        Resident res = new Resident(p,Major.CS,132,0);
        System.out.println(res);
    }

}
