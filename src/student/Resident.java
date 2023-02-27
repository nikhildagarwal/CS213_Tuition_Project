package student;

public class Resident extends Student {

    public static final int FULL_TIME = 12;
    public static final int EXTRA_FULL_TIME = 16;

    public static final double RESIDENT_CREDIT_PRICE = 404;

    public static final double UNIVERSITY_FEE = 3268;
    public static final double PART_TIME_UNIVERSITY_FEE = UNIVERSITY_FEE*0.8;
    public static final double RESIDENT_TUITION = 12536;

    private int scholarship;

    public Resident(Profile profile, Major major, int creditCompleted, int scholarship){
        super(profile,major,creditCompleted);
        this.scholarship = scholarship;
    }

    @Override
    public String toString(){
        return super.toString() + "(resident)";
    }

    @Override
    public boolean isResident(){
        return true;
    }

    @Override
    public String getType(){
        return "(Resident)";
    }

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
