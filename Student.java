import java.util.Scanner;

class Student {
    
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    
    public boolean checkEligibility() {
        return this.marks >= 50;
    }

    
    public double calculateFee() {
        return this.courseCredits * 1500.0;
    }

    
    public double calculateScholarship() {
        double fee = calculateFee();
        if (this.marks >= 85) {
            return fee * 0.20; 
        } else if (this.marks >= 70 && this.marks <= 84) {
            return fee * 0.10; 
        } else {
            return 0.0; 
        }
    }

    
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    
    public void displayDetails() {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks              : " + marks);
        System.out.println("Course Name        : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);
        
        boolean isEligible = checkEligibility();
        System.out.println("Eligibility Status : " + (isEligible ? "Eligible" : "Not Eligible"));

        if (isEligible) {
            System.out.println("Total Course Fee   : Rs. " + calculateFee());
            System.out.println("Scholarship Amount : Rs. " + calculateScholarship());
            System.out.println("Final Fee Payable  : Rs. " + calculateFinalFee());
        } else {
            System.out.println("Message            : Student is not eligible for course registration due to low marks.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNo = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter Course Name: ");
        String course = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = scanner.nextInt();

        
        Student student = new Student(name, rollNo, marks, course, credits);

        
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nRegistration Failed: Student is not eligible for registration (Marks must be 50 or above).");
        }

        scanner.close();
    }
}