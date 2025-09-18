import java.util.*;

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        setBaseSalary(baseSalary);
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            throw new IllegalArgumentException("Base salary cannot be negative");
        }
    }

    public void setDepartment(String department) { this.department = department; }
    public String getDepartment() { return department; }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: " + baseSalary + ", Dept: " + department);
    }
}

class FullTimeEmployee extends Employee implements Department {
    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public double calculateSalary() {
        // For full time, baseSalary is monthly salary
        return getBaseSalary();
    }

    @Override
    public void assignDepartment(String dept) { setDepartment(dept); }

    @Override
    public String getDepartmentDetails() { return "Department: " + getDepartment(); }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, hourlyRate * hoursWorked); // baseSalary stores last computed
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int hours) {
        if (hours >= 0) this.hoursWorked = hours;
        else throw new IllegalArgumentException("Hours cannot be negative");
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void assignDepartment(String dept) { setDepartment(dept); }

    @Override
    public String getDepartmentDetails() { return "Department: " + getDepartment(); }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        FullTimeEmployee fte = new FullTimeEmployee(1, "Amit", 50000);
        fte.assignDepartment("IT");
        PartTimeEmployee pte = new PartTimeEmployee(2, "Raj", 500, 40);
        pte.assignDepartment("Support");

        employees.add(fte);
        employees.add(pte);

        System.out.println("---- Employee Details ----");
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Salary: " + emp.calculateSalary());
            System.out.println();
        }
    }
}
