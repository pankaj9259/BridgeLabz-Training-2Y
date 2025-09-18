import java.util.*;

interface MedicalRecord {
    void addRecord(String entry);
    List<String> viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private List<String> records = new ArrayList<>();

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        setAge(age);
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setAge(int age) { if (age >= 0) this.age = age; else throw new IllegalArgumentException("Age invalid"); }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("PatientId: " + patientId + ", Name: " + name + ", Age: " + age);
    }

    protected void addRecordInternal(String entry) { records.add(entry); }
    protected List<String> getInternalRecords() { return records; }
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double ratePerDay;

    public InPatient(String id, String name, int age, int days, double ratePerDay) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.ratePerDay = ratePerDay;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * ratePerDay;
    }

    @Override
    public void addRecord(String entry) { addRecordInternal(entry); }

    @Override
    public List<String> viewRecords() { return getInternalRecords(); }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String entry) { addRecordInternal(entry); }

    @Override
    public List<String> viewRecords() { return getInternalRecords(); }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new InPatient("P001", "Sonal", 40, 5, 2000),
            new OutPatient("P002", "Kiran", 28, 500)
        );

        System.out.println("---- Patient Billing ----");
        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: " + p.calculateBill());
            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord)p;
                mr.addRecord("Initial checkup done");
                System.out.println("Records: " + mr.viewRecords());
            }
            System.out.println();
        }
    }
}
