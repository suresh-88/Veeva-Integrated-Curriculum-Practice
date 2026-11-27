import java.util.*;
import java.util.stream.Collectors;

abstract class Employee{
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    abstract double calculateSalary();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + department + " " + calculateSalary();
    }
}

class FullTimeEmployee extends Employee
{
    double baseSalary;
    double bonus;

    public FullTimeEmployee(int id, String name, String department, double baseSalary, double bonus) {
        super(id, name, department);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    double calculateSalary(){
        return baseSalary + bonus;
    }
}

class ContractEmployee extends Employee
{
    double hourlyRate;
    int hoursWorked;

    public ContractEmployee(int id, String name, String department, double hourlyRate, int hoursWorked) {
        super(id, name, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

public class PayrollManager {
    static List<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee(101, "Alice", "IT", 60000, 10000);
        Employee e2 = new ContractEmployee(102, "Bob", "IT", 500, 100);
        Employee e3 = new FullTimeEmployee(103, "Charlie", "HR", 55000, 5000);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        System.out.println(getDepartmentWiseTotalSalary());
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter threshold:");
        double threshold = sc.nextDouble();
        System.out.println(getTopEarners(threshold));
    }

    static Map<String, Double> getDepartmentWiseTotalSalary(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingDouble(Employee::calculateSalary)));
    }

    static List<String> getTopEarners(double threshold){
        return employees.stream().filter(employee -> employee.calculateSalary()>threshold).map(Employee::toString).toList();
    }
}
