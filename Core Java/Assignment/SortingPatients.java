import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

class Patient{
    private int id;
    private String name;
    private int severity;
    private int arrival;
    private static int counter = 0;

    public Patient(String name, int severity, int arrival) {
        this.id = ++counter;
        this.name = name;
        this.severity = severity;
        this.arrival = arrival;
    }

    public int getSeverity() {
        return severity;
    }

    public int getArrival() {
        return arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", severity=" + severity +
                ", arrival=" + arrival +
                '}';
    }
}

public class SortingPatients {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of patients :");
        int n = sc.nextInt();
        ArrayList<Patient> patients = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter name of patient "+i);
            String name = sc.next();
            System.out.println("Enter severity level(1-10) of patient "+i);
            int severity = sc.nextInt();
            while(severity<1||severity>10){
                System.out.println("Severity should be 1-10.Enter again");
                severity = sc.nextInt();
            }
            System.out.println("Enter arrival time(1-23) of patient "+i);
            int arrival = sc.nextInt();
            while(arrival<1||arrival>23){
                System.out.println("Arrival time should be in 1-23.Enter again");
                arrival = sc.nextInt();
            }
            Patient patient = new Patient(name,severity,arrival);
            patients.add(patient);
        }
        patients.sort(Comparator.comparingInt(Patient::getArrival).thenComparing(Patient::getSeverity,Comparator.reverseOrder()));
        System.out.println("Patients after sorting:");
        patients.forEach(System.out::println);
    }
}
