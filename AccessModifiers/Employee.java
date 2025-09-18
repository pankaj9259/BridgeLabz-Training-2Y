class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    String teamName;

    Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    void display() {
        System.out.println("ID: " + employeeID + ", Dept: " + department +
                           ", Team: " + teamName + ", Salary: " + getSalary());
    }

    public static void main(String[] args) {
        Manager m = new Manager(201, "IT", 60000, "Backend Team");
        m.display();
        m.setSalary(70000);
        System.out.println("Updated Salary: " + m.getSalary());
    }
}