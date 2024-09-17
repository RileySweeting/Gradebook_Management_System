
import java.util.*;

public class FSCcourseRoster {

    // Data Members
    // head: reference variable to the first node of the list
    private Student head;
    // courseNumber: Course Code (Identifier) of the Linked List
    private String courseNumber;
    // stats: Statistics unqiue to each course
    private Stats stats;

    // CONSTRUCTORS
    public FSCcourseRoster() {
        head = null;
        // Construct an Empty Stats Object for this Course
        this.stats = new Stats();
    }

    // Accessor & Mutator Methods
    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }


    /* Below are MANY methods that are used on Linked Lists.
	 * 
	 * Examples:
	 * search, insert, delete, isEmpty, sumNodes, and many more
     */
    // Checks if Linked List is Empty
    // If so, Returns True
    public boolean isEmpty() {
        return head == null;
    }

    // Given Student ID, checks if a Student (node) with the same ID exists in the course roster (FSCcourseRoster Linked List)
    // Loops over Each Node in Linked List and compares node (student) data to data sent as parameters (ID)
    public boolean search(int data) {
        return search(head, data);
    }

    // The extra parameter, Student head, is simply the head and is where helpPtr starts from
    private boolean search(Student head, int data) {
        Student helpPtr = head;
        while (helpPtr != null) {
            if (helpPtr.getID() == data) {
                return true;
            }
            helpPtr = helpPtr.getNext();
        }
        return false;
    }

    // Given Student First and Last Name, checks if a Student (node) with the same Name exists in the course roster (FSCcourseRoster Linked List)
    // Loops over Each Node in Linked List and compares node (student) data to data sent as parameters (firstName and lastName)
    public boolean search(String firstName, String lastName) {
        return search(head, firstName, lastName);
    }

    // The extra parameter, Student p, is simply the head and is where helpPtr starts from
    private boolean search(Student p, String firstName, String lastName) {
        Student helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getFirstName().equals(firstName) && helpPtr.getLastName().equals(lastName)) {
                return true;
            }
            helpPtr = helpPtr.getNext();
        }
        return false;
    }

    // Same functionality as above search() functions, but instead returns the Student (node) if found instead of a boolean
    // This findNode function takes the Student ID as a Parameter
    public Student findNode(int data) {
        return findNode(head, data);
    }

    // The extra parameter, Student p, is simply the head and is where helpPtr starts from
    private Student findNode(Student p, int data) {
        Student helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getID() == data) {
                return helpPtr;
            }
            helpPtr = helpPtr.getNext();
        }
        return null;
    }

    // Same functionality as above search() functions, but instead returns the Student (node) if found instead of a boolean
    // This findNode function takes the Student First and Last Names as Parameters
    public Student findNode(String firstName, String lastName) {
        return findNode(head, firstName, lastName);
    }

    // The extra parameter, Student p, is simply the head and is where helpPtr starts from
    private Student findNode(Student p, String firstName, String lastName) {
        Student helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getFirstName().equals(firstName) && helpPtr.getLastName().equals(lastName)) {
                return helpPtr;
            }
            helpPtr = helpPtr.getNext();
        }
        return null;
    }

    // This function loops through and prints the contents (Students) of a Course Roster
    public void PrintList() {
        PrintList(head);
    }

    private void PrintList(Student head) {
        // We need to traverse...so we need a help ptr
        Student helpPtr = head;
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Print the data value of the node
            System.out.print(helpPtr.getID() + ", ");
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }

    // This function, given an ALREADY CREATED Student Node, will insert it into its proper place in the Course Roster LL
    // The Proper Place is determined by comparing Student IDs
    public void insert(Student newNode) {
        head = insert(head, newNode); // Update Head of Linked List
    }

    // The head is sent over as a parameter to tell the function where to start looping
    private Student insert(Student head, Student newNode) {
        // IF there is no list, newNode will be the first node, so just return it OR
        // IF Student needs to be inserted at beginning of LL
        if (head == null || head.getID() > newNode.getID()) {
            newNode.setNext(head); // Set Next of newNode to HEAD
            // Save address of new student node into head
            head = newNode; // Head Node will not be trashed by Garbage Collector, as NewNode is pointing to it
            return head;
        } // ELSE, we have a list. Insert the new node at the correct location
        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            Student helpPtr = head;
            // Traverse to correct insertion point
            while (helpPtr.getNext() != null) {
                if (helpPtr.getNext().getID() > newNode.getID()) {
                    break; // we found our spot and should break out of the while loop
                }
                // Move HelpPtr through List
                helpPtr = helpPtr.getNext();
            }

            // Set new node's next to point to the successor node. (New Node is Already Created)
            // And then make the predecessor node point to the new node
            newNode.setNext(helpPtr.getNext());
            helpPtr.setNext(newNode);
            // ^^ Must be done in this order for sucessor node NOT to be trashed by Java Garbage Collector
        }
        // Return head
        return head;
    }

    // This function, given a Student ID, will find the Student's Node in the LL and Delete it
    public void delete(int data) {
        head = delete(head, data);
    }

    // The head is sent over as a parameter to tell the function where to start looping   
    private Student delete(Student head, int data) {
        // We can only delete if the list has nodes (is not empty)
        if (!isEmpty()) {
            // IF the first node (at the head) has the data value we are wanting to delete
            // we found it. Delete by skipping the node and making head point to the next node.
            if (head.getID() == data) {
                head = head.getNext();
            } // ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
            else {
                // We need to traverse to find the data we want to delete...so we need a help ptr
                Student helpPtr = head;
                // Traverse to correct deletion point
                while (helpPtr.getNext() != null) {
                    if (helpPtr.getNext().getID() == data) {
                        helpPtr.setNext(helpPtr.getNext().getNext());
                        break; // we deleted the value and should break out of the while loop
                    }
                    helpPtr = helpPtr.getNext();
                }
            }
            // return the possibly updated head of the list
            return head;
        }
        return head;
    }

    // This Function, toString(), Returns a String Representation of a Course Object to be Displayed by Main
    // This Function will Loop through Course, Adding each Student's Grade Info to a String to be Returned
    @Override
    public String toString() {
        return toString(head);
    }

    private String toString(Student head) {
        // Define HelpPtr
        Student helpPtr = head;

        // Define Return String
        String str = String.format("Course Roster for %s:%n", courseNumber);

        // Loop Through Each Student in Course
        while (helpPtr != null) {
            str += String.format("\t%s %s (ID# %d):%n", helpPtr.getFirstName(), helpPtr.getLastName(), helpPtr.getID());
            str += helpPtr.getGradeInfo();
            // Move HelpPtr Forward
            helpPtr = helpPtr.getNext();
        }

        return str;
    }

}
