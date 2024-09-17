
public class Student {
    // Data Members
    private String courseNumber;
    private int ID;
    private String firstName;
    private String lastName;
    private int[] examGrades;
    private double finalGrade;
    private char letterGrade;
    private static int numStudents;
    // Reference to Next Student in Courses Linked List
    private Student next;
    
    // CONSTRUCTORS
    
    // Constructs a Student Node given NO Parameters
    public Student() {
        this.courseNumber = null;
        this.ID = 0;
        this.firstName = null;
        this.lastName = null;
        this.examGrades = null;
        this.finalGrade = 0;
        this.letterGrade = 0;
        numStudents++;
        this.next = null;
    }
    
    // Constructs a Student Node given all Data Members EXCEPT for Next Reference
    public Student(String courseNumber, int ID, String firstName, String lastName, int[] examGrades, double finalGrade, char letterGrade) {
        this.courseNumber = courseNumber;
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.examGrades = examGrades;
        this.finalGrade = finalGrade;
        this.letterGrade = letterGrade;
        numStudents++;
        this.next = null;
    }
    
    // Constructs a Student Node given Next Reference and all Data Members
    public Student(String courseNumber, int ID, String firstName, String lastName, int[] examGrades, double finalGrade, char letterGrade, Student next) {
        this.courseNumber = courseNumber;
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.examGrades = examGrades;
        this.finalGrade = finalGrade;
        this.letterGrade = letterGrade;
        numStudents++;
        this.next = next;
    }
    
    // Accessor & Mutator Methods

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int[] getExamGrades() {
        return examGrades;
    }

    public void setExamGrades(int[] examGrades) {
        this.examGrades = examGrades;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public char getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(char letterGrade) {
        this.letterGrade = letterGrade;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }
    
    public static int getNumStudents() {
        return numStudents;
    }

    public static void setNumStudents(int aNumStudents) {
        numStudents = aNumStudents;
    }
    
    // This Function Returns a Student's Grade Information as a String Given a Student Object
    // PARAMETERS: None (Not Static)
    // PURPOSE: The SEARHBYID, SEARCHBYNAME, DISPLAYSTATS, and DISPLAYSTUDENTS Functions display the grade information for each Student
    // This function simplifies the process by giving both functions a Student's Grade Information
    // Similar to toString() Function
    public String getGradeInfo() {
        String str = "";
        str += String.format("\t\tExam 1:       %d%n", examGrades[0]);
        str += String.format("\t\tExam 2:       %d%n", examGrades[1]);
        str += String.format("\t\tFinal Exam:   %d%n", examGrades[2]);
        str += String.format("\t\tFinal Grade:  %.2f%n", finalGrade);
        str += String.format("\t\tLetter Grade: %s%n", letterGrade);
        return str;
    }
    
}
