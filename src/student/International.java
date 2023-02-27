package student;

public class International extends NonResident{

    public boolean isStudyAbroad;

    public static final int MAX_STUDY_ABROAD_CREDITS = 12;
    public static final int MIN_INTERNATIONAL_CREDITS_ENROLLED = 12;

    public International(Profile profile,Major major, int creditCompleted){
        super(profile,major,creditCompleted);
        this.isStudyAbroad = false;
    }

    public International(Profile profile, Major major, int creditCompleted, boolean isStudyAbroad){
        super(profile,major,creditCompleted);
        this.isStudyAbroad = isStudyAbroad;
    }

    @Override
    public String toString(){
        if(isStudyAbroad == false){
            return super.toString()+"(international)";
        }else{
            return super.toString()+"(international:study abroad)";
        }
    }

    @Override
    public boolean isValid(int creditsEnrolled){
        if(isStudyAbroad==true){
            if(creditsEnrolled>=MIN_CREDITS_ENROLLED && creditsEnrolled<=MAX_STUDY_ABROAD_CREDITS){
                return true;
            }else{
                return false;
            }
        }else{
            if(creditsEnrolled>=MIN_INTERNATIONAL_CREDITS_ENROLLED && creditsEnrolled<=MAX_CREDITS_ENROLLED){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        International i = new International(p,Major.MATH,101,true);
        Resident r = new Resident(p,Major.CS,20,100);
        System.out.println(i.equals(r));
        System.out.println(i);
    }
}
