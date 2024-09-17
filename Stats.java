
import java.util.*;

public class Stats {

    // This Class stores all the Statistics for a Course (Course Roster of Students)
    // NOTE: There is an Additional Setter for Letter Counts that simply Increments the Count Value (No Parameters Needed)
    // Data Members
    private double max; // Maximum Final Grade in Course
    private double min; // Minimum Final Grade in Course
    private double avg; // Average Final Grade in Course
    private double sum; // Sum of ALL Grade in Course (Used to Calculate AVG)
    private int count;  // Number of Students in CURRENT Course
    private int aCount; // Number of 'A' Final Grades in Course
    private int bCount; // Number of 'B' Final Grades in Course
    private int cCount; // Number of 'C' Final Grades in Course
    private int dCount; // Number of 'D' Final Grades in Course
    private int fCount; // Number of 'F' Final Grades in Course
    private ArrayList<Double> gradesList; // ArrayList of Grades used to Find New Min/Max when Student is Deleted

    // Constructs a Stats Object given NO Parameters
    public Stats() {
        this.max = 0;
        this.min = 0;
        this.avg = 0;
        this.sum = 0;
        this.count = 0;
        this.aCount = 0;
        this.bCount = 0;
        this.cCount = 0;
        this.dCount = 0;
        this.fCount = 0;
        this.gradesList = new ArrayList<>();
    }

    // Accessors and Mutators
    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addCount() {
        count++;
    }

    public int getaCount() {
        return aCount;
    }

    public void setaCount(int aCount) {
        this.aCount = aCount;
    }

    public void addaCount() {
        aCount++;
    }

    public int getbCount() {
        return bCount;
    }

    public void setbCount(int bCount) {
        this.bCount = bCount;
    }

    public void addbCount() {
        bCount++;
    }

    public int getcCount() {
        return cCount;
    }

    public void setcCount(int cCount) {
        this.cCount = cCount;
    }

    public void addcCount() {
        cCount++;
    }

    public int getdCount() {
        return dCount;
    }

    public void setdCount(int dCount) {
        this.dCount = dCount;
    }

    public void adddCount() {
        dCount++;
    }

    public int getfCount() {
        return fCount;
    }

    public void setfCount(int fCount) {
        this.fCount = fCount;
    }

    public void addfCount() {
        fCount++;
    }

    public ArrayList<Double> getGradesList() {
        return gradesList;
    }

    // Add Grade to GradeList using ArrayList .add() Method
    public void addGrade(double grade) {
        this.gradesList.add(grade);
    }

    // Remove Grade from GradeList using ArrayList .remove() Method
    public void removeGrade(double grade) {
        this.gradesList.remove(grade);
    }

    // To String Method
    // Returns String Representation of Grade Statistics for a Course
    @Override
    public String toString() {
        String str = "";
        str += String.format("\tTotal number of student records: %d%n", count);
        str += String.format("\tAverage Score: %.2f%n", avg);
        str += String.format("\tHighest Score: %.2f%n", max);
        str += String.format("\tLowest Score:  %.2f%n", min);
        // If Count is 0, Temporarily Change to 1 to Prevent Not A Number (NaN) Errors when Calculating AVG
        // Set Flag to True to Change back to 0 at end of toString
        boolean flag = false;
        if (count == 0) {
            count = 1;
            flag = true;
        }
        str += String.format("\tTotal 'A' Grades: %d (%.2f%% of class)%n", aCount, (100.00 * aCount / count));
        str += String.format("\tTotal 'B' Grades: %d (%.2f%% of class)%n", bCount, (100.00 * bCount / count));
        str += String.format("\tTotal 'C' Grades: %d (%.2f%% of class)%n", cCount, (100.00 * cCount / count));
        str += String.format("\tTotal 'D' Grades: %d (%.2f%% of class)%n", dCount, (100.00 * dCount / count));
        str += String.format("\tTotal 'F' Grades: %d (%.2f%% of class)%n", fCount, (100.00 * fCount / count));
        // Change Count back to 0 if Changed
        if (flag) {
            count = 0;
        }
        return str;
    }

}
