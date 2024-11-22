import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int[] marks = new int[5];
    String dob;

    public Student(int rollNumber, String name, int[] marks, String dob) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
        this.dob = dob;
    }

    public int getTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", Total Marks: " + getTotalMarks() + ", DOB: " + dob;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(101, "Alice", new int[]{85, 90, 78, 92, 88}, "2003-05-12"));
        students.add(new Student(102, "Bob", new int[]{80, 75, 85, 88, 82}, "2004-03-22"));
        students.add(new Student(103, "Charlie", new int[]{70, 80, 75, 85, 90}, "2002-11-30"));
        students.add(new Student(104, "David", new int[]{88, 84, 90, 86, 89}, "2003-08-19"));
        students.add(new Student(105, "Eve", new int[]{95, 92, 88, 96, 94}, "2005-01-10"));

        Scanner scanner = new Scanner(System.in);

        // Display all records with total marks
        System.out.println("All Student Records:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by date of birth and display records
        students.sort(Comparator.comparing(s -> s.dob));
        System.out.println("\nStudent Records Sorted by DOB:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Search and update a record
        System.out.println("\nEnter roll number or name to update:");
        String input = scanner.nextLine();
        for (Student s : students) {
            if (String.valueOf(s.rollNumber).equals(input) || s.name.equalsIgnoreCase(input)) {
                System.out.println("Found: " + s);
                System.out.println("What would you like to update? (1: Name, 2: Marks, 3: DOB)");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        System.out.println("Enter new name:");
                        s.name = scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("Enter 5 new marks separated by spaces:");
                        for (int i = 0; i < 5; i++) {
                            s.marks[i] = scanner.nextInt();
                        }
                        scanner.nextLine(); // Consume newline
                        break;
                    case 3:
                        System.out.println("Enter new DOB (yyyy-mm-dd):");
                        s.dob = scanner.nextLine();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                break;
            }
        }

        // Delete a student record
        System.out.println("\nEnter roll number or name to delete:");
        String deleteInput = scanner.nextLine(); // Capture input in a final variable
        students.removeIf(s -> String.valueOf(s.rollNumber).equals(deleteInput) || s.name.equalsIgnoreCase(deleteInput));

        // Display updated list
        System.out.println("\nUpdated Student Records:");
        for (Student s : students) {
            System.out.println(s);
        }

        scanner.close();
    }
}