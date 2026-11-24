import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class Employee{
    private int Id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        Id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Id == employee.Id;
    }

    @Override
    public String toString() {
        return "{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class StoringEmployees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of employees:");
        int n = sc.nextInt();
        TreeSet<Employee> employeesIdAsc = new TreeSet<>(Comparator.comparing(Employee::getId));
        TreeSet<Employee> employeesNameAsc = new TreeSet<>(Comparator.comparing(Employee::getName));
        TreeSet<Employee> employeesSalAsc = new TreeSet<>(Comparator.comparing(Employee::getSalary));
        TreeSet<Employee> employeesSalDesc = new TreeSet<>(Comparator.comparing(Employee::getSalary).reversed());
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter id of employee - "+i);
            int id = sc.nextInt();
            System.out.println("Enter name of employee - "+i);
            String name = sc.next();
            System.out.println("Enter salary of employee - "+i);
            int salary = sc.nextInt();
            Employee emp = new Employee(id,name,salary);
            employeesIdAsc.add(emp);
            employeesNameAsc.add(emp);
            employeesSalAsc.add(emp);
            employeesSalDesc.add(emp);
        }
        System.out.println("Employees sorted by id ascending :");
        System.out.println(employeesIdAsc);
        System.out.println("Employees sorted by name ascending :");
        System.out.println(employeesNameAsc);
        System.out.println("Employees sorted by salary ascending :");
        System.out.println(employeesSalAsc);
        System.out.println("Employees sorted by salary descending :");
        System.out.println(employeesSalDesc);
    }
}
