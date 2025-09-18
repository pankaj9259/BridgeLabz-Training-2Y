class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name, ailment;
    private int age;

    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient(1, "Suman", 30, "Fever");
        Patient p2 = new Patient(2, "Rohan", 45, "Diabetes");

        p1.displayPatientDetails();
        p2.displayPatientDetails();
        Patient.getTotalPatients();
    }
}