package student;

import javax.swing.plaf.nimbus.State;
import java.util.Scanner;
import java.io.File;

/**
 * Implements the RosterManager class to take care of the roster and make changes to the roster.
 * Processes all console inputs and outputs a response to the console.
 * @author Nikhil Agarwal, Hyeon Oh
 */
public class TuitionManager {
    public static final int LENGTH_RESIDENT_INPUT = 6;
    public static final int LENGTH_TRISTATE_INPUT = 7;
    public static final int LENGTH_TRISTATE_INPUT_NO_STATE = 6;
    public static final int STARTING_SCHOLARSHIP = 0;
    public static final int STATE_INDEX = 6;
    public static final int ABROAD_INDEX = 6;

    /**
     * minimum number of credits to be considered a student
     */
    public static final int MIN_CREDITS = 0;

    /**
     * index in array containing command code
     */
    public static final int CODE_INDEX = 0;

    /**
     * index in array containing first name
     */
    public static final int FIRSTNAME_INDEX = 1;

    /**
     * index in array containing last name
     */
    public static final int LASTNAME_INDEX = 2;

    /**
     * index in array containing date
     */
    public static final int DATE_INDEX = 3;

    /**
     * index in array containing major
     */
    public static final int MAJOR_INDEX = 4;

    /**
     * index in array containing number of credits
     */
    public static final int CREDITS_INDEX = 5;

    /**
     * null holder
     */
    public static final int ANY_NUMBER_OF_CREDITS = 0;

    /**
     * index in array containing school
     */
    public static final int SCHOOL_INDEX = 1;

    /**
     * indicates we are working with full roster list
     */
    public static final int FULL_ROSTER = 0;

    /**
     * indicates we are working with a school roster list
     */
    public static final int SCHOOL_ROSTER = 1;

    /**
     * null holder
     */
    public static final String ALL_SCHOOLS = "";


    public void run(){
        Roster roster = new Roster();
        Enrollment enrollment = new Enrollment();
        System.out.println("Tuition Manager running...");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String[] tokens = processLine(scanner.nextLine());
            try{
                switch(tokens[CODE_INDEX]){
                    case "LS":
                        processLS(roster); break;
                    case "R":
                        //processRemove(tokens,roster);
                        break;
                    case "P":
                        processPrint(roster,FULL_ROSTER,ALL_SCHOOLS); break;
                    case "PS":
                        processPrintStanding(roster); break;
                    case "PC":
                        processPrintMajor(roster); break;
                    case "L":
                        //processSchoolList(tokens,roster);
                        break;
                    case "C":
                        //processChange(tokens,roster);
                        break;
                    case "Q":
                        System.out.println("Roster Manager terminated."); return;
                    case "AR":
                        processAddResident(tokens,roster); break;
                    case "AT":
                        processAddTriState(tokens,roster); break;
                    default:
                        System.out.println(tokens[0] + " is an invalid command!");
                }
            }catch (Exception e){

            }
        }
    }

    private void processAddTriState(String[] tokens, Roster roster){
        if(tokens.length==LENGTH_TRISTATE_INPUT_NO_STATE){
            System.out.println("Missing the state code.");
            return;
        }
        if(tokens.length<LENGTH_TRISTATE_INPUT){
            System.out.println("Missing data in command line.");
            return;
        }
        String upperCaseState = tokens[STATE_INDEX].toUpperCase();
        if(!upperCaseState.equals("NY") && !upperCaseState.equals("CT")){
            System.out.println(tokens[STATE_INDEX]+": Invalid state code.");
            return;
        }
        if(studentChecker(tokens)){
            Profile profile = new Profile(tokens[LASTNAME_INDEX],tokens[FIRSTNAME_INDEX],new Date(tokens[DATE_INDEX]));
            TriState triState = new TriState(profile,grabMajorString(tokens[MAJOR_INDEX]),Integer.parseInt(tokens[CREDITS_INDEX]),tokens[STATE_INDEX]);
            if(triState.isValidStudent()){
                if(roster.contains(triState)){
                    System.out.println(triState.getProfile()+" is already in the roster.");
                }else{
                    roster.add(triState);
                    System.out.println(triState.getProfile()+" added to the roster.");
                }
            }
        }

    }

    private void processAddResident(String[] tokens, Roster roster){
        if(tokens.length<LENGTH_RESIDENT_INPUT){
            System.out.println("Missing data in line command.");
            return;
        }
        if(studentChecker(tokens)){
            Profile profile = new Profile(tokens[LASTNAME_INDEX],tokens[FIRSTNAME_INDEX],new Date(tokens[DATE_INDEX]));
            Resident resident = new Resident(profile,grabMajorString(tokens[MAJOR_INDEX]),Integer.parseInt(tokens[CREDITS_INDEX]),STARTING_SCHOLARSHIP);
            if(resident.isValidStudent()){
                if(roster.contains(resident)){
                    System.out.println(resident.getProfile()+" is already in the roster.");
                }else{
                    roster.add(resident);
                    System.out.println(resident.getProfile()+" added to the roster.");
                }
            }
        }
    }

    /**
     * Displays the roster sorted by standing by calling printByStanding method from the roster class
     * If the roster is empty, it will display to the user that it is empty
     * @param roster the argument that is to be displayed
     */
    private void processPrintStanding(Roster roster){
        if(roster.isEmpty()){
            System.out.println("Student roster is empty!");
            return;
        }
        System.out.println("** Student roster sorted by standing **");
        roster.printByStanding();
        System.out.println("* end of roster *");
    }

    /**
     * Displays the roster sorted by school, major
     * @param roster the argument that is to be displayed
     */
    private void processPrintMajor(Roster roster){
        if(roster.isEmpty()){
            System.out.println("Student roster is empty!");
            return;
        }
        System.out.println("** Student roster sorted by school, major **");
        roster.printByMajor();
        System.out.println("* end of roster *");
    }

    /**
     * Displays to the user whether the roster or list is empty, and displays the roster
     * @param roster argument used to determine if the roster is empty and also used to call print method from roster class
     * @param typeOfRoster type of roster (Full student roster, school specific roster).
     * @param school if the type of roster is a school list, the school of the list will be input, otherwise this parameter is an empty string.
     */
    private void processPrint(Roster roster,int typeOfRoster,String school){
        if(roster.isEmpty()){
            if(typeOfRoster == FULL_ROSTER){
                System.out.println("Student roster is empty!");
                return;
            }
            if(typeOfRoster == SCHOOL_ROSTER){
                System.out.println("School list is empty!");
                return;
            }
        }
        if(typeOfRoster == FULL_ROSTER){
            System.out.println("** Student roster sorted by last name, first name, DOB **");
        }
        if(typeOfRoster == SCHOOL_ROSTER){
            System.out.println("** Students in "+ school+" **");
        }
        roster.print();
        if(typeOfRoster == FULL_ROSTER){
            System.out.println("* end of roster *");
        }
        if(typeOfRoster == SCHOOL_ROSTER){
            System.out.println("* end of list *");
        }

    }

    /**
     * uses string methods such as split to take inputs separately
     * @param command the command which is taken to be split
     * @return newLine which is a string array that returns the commands
     */
    private String[] processLine(String command){
        String[] line = command.split("\\s");
        int counter = 0;
        String[] newLine = new String[line.length];
        for(String token:line){
            if(!token.equals("")){
                newLine[counter] = token;
                counter++;
            }
        }
        return newLine;
    }

    private String[] processLineLS(String command){
        String[] line = command.split(",");
        int counter = 0;
        String[] newLine = new String[line.length];
        for(String token:line){
            if(!token.equals("")){
                newLine[counter] = token;
                counter++;
            }
        }
        return newLine;
    }

    private boolean studentChecker(String[] tokens){
        Date dob = new Date(tokens[DATE_INDEX]);
        if(!dob.isValid()){
            System.out.println("DOB invalid: "+dob+" not a valid calendar date!");
            return false;
        }
        if(!dob.isValidAge()){
            System.out.println("DOB invalid: "+dob+" younger than 16 years old.");
            return false;
        }
        Major major = grabMajor(tokens);
        if(major == null){
            return false;
        }
        try{
            if(Integer.parseInt(tokens[CREDITS_INDEX]) < MIN_CREDITS){
                System.out.println("Credits completed invalid: cannot be negative!");
                return false;
            }
        }catch(Exception e){
            System.out.println("Credits completed invalid: not an integer!");
            return false;
        }
        return true;
    }

    private void processLS(Roster roster){
        try{
            Scanner scanner = new Scanner(new File("studentList.txt"));
            while(scanner.hasNextLine()){
                String[] tokens = processLineLS(scanner.nextLine());
                switch(tokens[CODE_INDEX]){
                    case "R":
                        Resident resident = makeResident(tokens[FIRSTNAME_INDEX],tokens[LASTNAME_INDEX],tokens[DATE_INDEX],tokens[MAJOR_INDEX],tokens[CREDITS_INDEX]);
                        roster.add(resident);
                        break;
                    case "I":
                        String abroad = "";
                        International international = null;
                        try{
                            abroad = tokens[ABROAD_INDEX];
                            international = makeInternational(tokens[FIRSTNAME_INDEX],tokens[LASTNAME_INDEX],tokens[DATE_INDEX],tokens[MAJOR_INDEX],tokens[CREDITS_INDEX],abroad);
                        }catch (Exception e){
                            international = makeInternational(tokens[FIRSTNAME_INDEX],tokens[LASTNAME_INDEX],tokens[DATE_INDEX],tokens[MAJOR_INDEX],tokens[CREDITS_INDEX]);
                        }
                        roster.add(international);
                        break;
                    case "T":
                        TriState triState = makeTriState(tokens[FIRSTNAME_INDEX],tokens[LASTNAME_INDEX],tokens[DATE_INDEX],tokens[MAJOR_INDEX],tokens[CREDITS_INDEX],tokens[STATE_INDEX]);
                        roster.add(triState);
                        break;
                    case "N":
                        NonResident nonResident = makeNonResident(tokens[FIRSTNAME_INDEX],tokens[LASTNAME_INDEX],tokens[DATE_INDEX],tokens[MAJOR_INDEX],tokens[CREDITS_INDEX]);
                        roster.add(nonResident);
                }
            }
            System.out.println("Students loaded to the roster.");
        }catch (Exception e){

        }
    }

    private NonResident makeNonResident(String firstName, String lastName, String date, String major, String creditCompleted){
        Major nonResMajor = grabMajorString(major);
        NonResident nonResident  = new NonResident(new Profile(lastName,firstName,new Date(date)),nonResMajor,Integer.parseInt(creditCompleted));
        return nonResident;
    }

    private TriState makeTriState(String firstName, String lastName, String date, String major, String creditCompleted, String state){
        Major triMajor = grabMajorString(major);
        TriState triState = new TriState(new Profile(lastName,firstName,new Date(date)),triMajor,Integer.parseInt(creditCompleted),state);
        return triState;
    }

    private Resident makeResident(String firstName, String lastName, String date, String major, String creditCompleted){
        Major resMajor = grabMajorString(major);
        Resident resident  = new Resident(new Profile(lastName,firstName,new Date(date)),resMajor,Integer.parseInt(creditCompleted),0);
        return resident;
    }

    private International makeInternational(String firstName, String lastName, String date, String major, String creditCompleted,String abroad){
        Major iMajor = grabMajorString(major);
        boolean isAbroad = false;
        if(abroad.equals("true")){
            isAbroad = true;
        }
        International international = new International(new Profile(lastName,firstName,new Date(date)),iMajor,Integer.parseInt(creditCompleted),isAbroad);
        return international;
    }

    private International makeInternational(String firstName, String lastName, String date, String major, String creditCompleted){
        Major iMajor = grabMajorString(major);
        International international = new International(new Profile(lastName,firstName,new Date(date)),iMajor,Integer.parseInt(creditCompleted));
        return international;
    }

    private Major grabMajor(String[] tokens){
        Major major = null;
        switch(tokens[MAJOR_INDEX].toUpperCase()){
            case "EE":
                major = Major.EE;
                break;
            case "CS":
                major = Major.CS;
                break;
            case "BAIT":
                major = Major.BAIT;
                break;
            case "MATH":
                major = Major.MATH;
                break;
            case "ITI":
                major = Major.ITI;
                break;
            default:
                System.out.println("Major code invalid: "+tokens[MAJOR_INDEX]);
        }
        return major;
    }

    private Major grabMajorString(String majorString){
        Major major = null;
        switch(majorString.toUpperCase()){
            case "EE":
                major = Major.EE;
                break;
            case "CS":
                major = Major.CS;
                break;
            case "BAIT":
                major = Major.BAIT;
                break;
            case "MATH":
                major = Major.MATH;
                break;
            case "ITI":
                major = Major.ITI;
                break;
            default:
                System.out.println("Major code invalid: "+majorString);
        }
        return major;
    }

    public static void main(String[] args){
        new TuitionManager().run();
    }
}