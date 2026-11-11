import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private final String name;
    private final int age;
    private final String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }


    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}


public class CaseStudy1
{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();
    public static void main(String[] args){
        while(true) {
            System.out.println("""
                    
                    1.Add Employees
                    2.display all employees
                    3.group employees by department
                    4.group employees by age
                    5.find oldest employee
                    6.Find youngest employee
                    7.Exit
                    Enter your choice""");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    for(Employee e : employees)
                        System.out.println(e);
                    System.out.println();
                    break;
                case 3:
                    System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)));
                    break;
                case 4:
                    System.out.println(employees.stream().collect(Collectors.groupingBy(m -> m.getAge() >= 40 ? "senior"
                            : m.getAge() >= 30 ? "lead"
                            : "junior")));
                    break;
                case 5:
                    System.out.println(employees.stream().max(Comparator.comparingInt(Employee::getAge)));
                    break;
                case 6:
                    System.out.println(employees.stream().min(Comparator.comparingInt(Employee::getAge)));
                    break;
                case 7:
                    System.exit(4);
                default:System.out.println("Enter valid choice");
            }
        }
    }

    public static void addEmployee(){
        System.out.println("Enter employee name ");
        String name = sc.next();
        System.out.println("Enter employee age ");
        int age = sc.nextInt();
        System.out.println("Enter employee department ");
        String department = sc.next();
        Employee employee = new Employee(name,age,department);
        employees.add(employee);
    }


}