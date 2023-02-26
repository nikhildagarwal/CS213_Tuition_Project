package student;

public class International extends NonResident{

    public boolean isStudyAbroad;

    public International(Profile profile, Major major, int creditCompleted, boolean isStudyAbroad){
        super(profile,major,creditCompleted);
        this.isStudyAbroad = isStudyAbroad;
    }

    @Override
    public String toString(){
        return super.toString()+" (international)";
    }

    public static void main(String[] args){
        Date d = new Date();
        Profile p = new Profile("Funcheon","Hope",d);
        International i = new International(p,Major.MATH,101,true);
        System.out.println(i);
    }
}
