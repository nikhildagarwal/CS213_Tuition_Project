
package student;

public class NonResident extends Student {
    public static final int FULL_TIME = 12;
    public static final int EXTRA_FULL_TIME = 16;

    public static final double NONRESIDENT_CREDIT_PRICE = 966;

    public static final double UNIVERSITY_FEE = 3268;
    public static final double PART_TIME_UNIVERSITY_FEE = UNIVERSITY_FEE * 0.8;
    public static final double NONRESIDENT_TUITION = 29737;

    public NonResident(Profile profile, Major major, int creditCompleted){
        super(profile,major,creditCompleted);
    }

    @Override
    public String toString(){
        return super.toString() + "(non-resident)";
    }

    @Override
    public boolean isResident(){
        return false;
    }

    @Override
    public String getType(){
        return "(Non-Resident)";
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuition = 0;
        if(creditsEnrolled<FULL_TIME){
            tuition = creditsEnrolled * NONRESIDENT_CREDIT_PRICE;
            tuition += PART_TIME_UNIVERSITY_FEE;
        }else if(creditsEnrolled>EXTRA_FULL_TIME){
            tuition += NONRESIDENT_TUITION+UNIVERSITY_FEE;
            tuition += (creditsEnrolled-EXTRA_FULL_TIME) * NONRESIDENT_CREDIT_PRICE;
        }else{
            tuition += NONRESIDENT_TUITION+UNIVERSITY_FEE;
        }
        return tuition;
    }

    public static void main (String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        NonResident res = new NonResident(p,Major.CS,132);
        System.out.println(res);
    }
}
