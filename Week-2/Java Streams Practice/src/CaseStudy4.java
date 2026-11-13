import java.util.ArrayList;
import java.util.Scanner;

class Employee1
{
    int id;
    String name;
    int salary;

    public Employee1(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", salary = " + salary +
                '}';
    }
}
class Company
{
    int id;
    String name;
    String location;
    ArrayList<Employee1> employees;

    public Company(int id, String name, String location, ArrayList<Employee1> employees) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.employees = employees;
    }

    public ArrayList<Employee1> getEmp() {
        return employees;
    }
}
public class CaseStudy4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Company> companies = new ArrayList<>();
        System.out.println("Enter no.of companies");
        int n = sc.nextInt();
        System.out.println("Enter companies details");
        for (int i = 1; i <= n; i++) {
            System.out.printf("Enter company-%d id: ",i);
            int id = sc.nextInt();
            System.out.printf("Enter company-%d name: ",i);
            String name = sc.next();
            System.out.printf("Enter company-%d location: ",i);
            String location = sc.next();
            System.out.printf("Enter no.of employees in the %s company: ",name);
            int k = sc.nextInt();
            ArrayList<Employee1> employees = new ArrayList<>();
            System.out.println("Enter employee details");
            for (int l = 1; l <= k; l++) {
                System.out.printf("Enter employee-%d id: ",l);
                int eid = sc.nextInt();
                System.out.printf("Enter employee-%d name: ",l);
                String ename = sc.next();
                System.out.printf("Enter employee-%d salary: ",l);
                int salary = sc.nextInt();
                Employee1 employee = new Employee1(eid,ename,salary);
                employees.add(employee);
            }
            Company company = new Company(id,name,location,employees);
            companies.add(company);
        }
        System.out.println(companies.stream().flatMap(company -> company.getEmp().stream()).toList());
    }
}
