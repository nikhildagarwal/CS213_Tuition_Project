package student;

public class EnrollStudent {

    private Profile profile;
    private int creditsEnrolled;

    public EnrollStudent(Profile profile, int creditsEnrolled){
        this.profile = profile;
        this.creditsEnrolled = creditsEnrolled;
    }

    @Override
    public String toString(){
        return profile.toString()+": credits enrolled: "+creditsEnrolled;
    }

    @Override
    public boolean equals(Object obj){
        EnrollStudent enrollStudent = (EnrollStudent) obj;
        if(profile.equals(enrollStudent.profile) && creditsEnrolled==enrollStudent.creditsEnrolled){
            return true;
        }
        return false;
    }

    public static void main (String[] args){
        Date date = new Date();
        Profile profile = new Profile("Agarwal","Nikhil",date);
        EnrollStudent s = new EnrollStudent(profile,14);
    }
}
