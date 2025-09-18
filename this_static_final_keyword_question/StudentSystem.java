class Student {
    private static String universityName = "Delhi University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name, grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Roll No: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }
}

public class StudentSystem {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Priya", "A");
        Student s2 = new Student(102, "Arjun", "B");

        s1.displayStudentDetails();
        s2.displayStudentDetails();
        Student.displayTotalStudents();
    }
}