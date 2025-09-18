class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }
}

class PostgraduateStudent extends Student {
    String specialization;

    PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    void display() {
        System.out.println("Roll: " + rollNumber + ", Name: " + name +
                           ", Specialization: " + specialization + ", CGPA: " + getCGPA());
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Suman", 8.5, "AI");
        pg.display();
        pg.setCGPA(9.0);
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}