package student;

/**
 * Class to implement Enrollment object
 * Holds an array of EnrollStudent data type, size of the array
 * Contains methods to add, remove, print, getStudent , and check if a student is contained in the array
 * @author Nikhil Agarwal, Hyeon Oh
 */
public class Enrollment {

    private EnrollStudent[] enrollStudents;
    private int size;

    public static final int INITIAL_SIZE = 4;
    public static final int NOT_FOUND = -1;
    public static final int INITIAL_NUMBER_OF_ELEMENTS = 0;

    /**
     * Constructor for the Enrollment object
     */
    public Enrollment(){
        this.enrollStudents = new EnrollStudent[INITIAL_SIZE];
        this.size = INITIAL_NUMBER_OF_ELEMENTS;
    }

    /**
     * adds a student of EnrollStudent type
     * @param enrollStudent which is the student to be added
     */
    public void add(EnrollStudent enrollStudent){
        if(size==enrollStudents.length){
            grow();
        }
        enrollStudents[size] = enrollStudent;
        size++;
    }

    /**
     * removes a student from the array
     * @param enrollStudent which is the student to be deleted
     */
    public void remove(EnrollStudent enrollStudent){
        int index = find(enrollStudent);
        if(index == NOT_FOUND){
            return;
        }
        for(int i = index + 1; i < size; i++) {
            enrollStudents[index] = enrollStudents[i];
            index++;
        }
        size--;
        enrollStudents[size] = null;
    }

    /**
     * checks the EnrollStudent array to see if the student exists
     * @param enrollStudent student to be searched for in the array
     * @return true if the student is in the array, false otherwise
     */
    public boolean contains(EnrollStudent enrollStudent){
        for(int i = 0;i<size;i++){
            if(enrollStudent.equals(enrollStudents[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * fetches the student from the array
     * @param enrollStudent which is the student to be fetched
     * @return returns the student and null if the student is not found
     */
    public EnrollStudent getStudent(EnrollStudent enrollStudent){
        for(int i = 0;i<size;i++){
            if(enrollStudent.equals(enrollStudents[i])){
                return enrollStudents[i];
            }
        }
        return null;
    }

    /**
     * prints the EnrollStudent array
     */
    public void print(){
        for(int i =0;i<size;i++){
            System.out.println(enrollStudents[i]);
        }
    }

    /**
     * Increases the size of the EnrollStudent array when need be
     */
    private void grow(){
        int prevLength = enrollStudents.length;
        EnrollStudent[] newEnrollment = new EnrollStudent[prevLength+INITIAL_SIZE];
        for(int i = 0; i < prevLength; i++){
            newEnrollment[i] = enrollStudents[i];
        }
        enrollStudents = newEnrollment;
    }

    /**
     * returns the size of the EnrollStudent array
     * @return size of the array
     */
    public int size(){
        return size;
    }

    /**
     * looks for the student in the EnrollStudent array
     * @param enrollStudent which is the student to be searched
     * @return returns the index of the student found in the array, returns NOT_FOUND otherwise
     */
    private int find(EnrollStudent enrollStudent){
        for(int i = 0;i<size;i++){
            if(enrollStudent.equals(enrollStudents[i])){
                return i;
            }
        }
        return NOT_FOUND;
    }

    public static void main(String[] args){
        EnrollStudent e1 = new EnrollStudent(new Profile("Agarwal","Nikhil",new Date("4/22/2002")),15);
        EnrollStudent e2 = new EnrollStudent(new Profile("Funcheon","Hope",new Date("10/8/2001")),20);
        EnrollStudent e3 = new EnrollStudent(new Profile("Agarwal","Navin",new Date("5/20/2007")),13);
        EnrollStudent e4 = new EnrollStudent(new Profile("Agarwal","Alok",new Date("10/1/1973")),12);
        EnrollStudent e5 = new EnrollStudent(new Profile("Kim","Sangsoon",new Date("1/27/1969")),15);
        EnrollStudent e6 = new EnrollStudent(new Profile("Rooprai","Aman",new Date("4/19/2002")),15);

        Enrollment enrollment = new Enrollment();
        enrollment.add(e1);
        enrollment.add(e2);
        enrollment.add(e3);
        enrollment.add(e4);
        enrollment.add(e5);
        enrollment.add(e6);
        System.out.println("Size: "+enrollment.size());
        enrollment.print();
        enrollment.remove(e3);
        System.out.println("Size: "+enrollment.size());
        enrollment.print();


    }

}

