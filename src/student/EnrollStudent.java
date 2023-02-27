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
        student.EnrollStudent enrollStudent = (student.EnrollStudent) obj;
        if(profile.equals(enrollStudent.profile)){
            return true;
        }
        return false;
    }

    public Profile getProfile(){
        return profile;
    }

    public int getCreditsEnrolled(){
        return creditsEnrolled;
    }

    public void changeCredits(int newCredits){
        creditsEnrolled = newCredits;
    }

    public static void main (String[] args){
        Date date = new Date();
        Profile profile = new Profile("Agarwal","Nikhil",date);
        student.EnrollStudent s = new student.EnrollStudent(profile,14);
    }
}
