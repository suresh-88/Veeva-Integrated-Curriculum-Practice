import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class EmployeeManager {
    static Scanner sc = new Scanner(System.in);
    static TreeMap<Integer,Employee> employees = new TreeMap<>();
    public static void main(String[] args) {
        while(true){
            System.out.println("1.Add Employee\n2.Employee Count\n3.First Employee\n4.Last Employee\n5.Print All Employees\n6.Exit");
            int c = sc.nextInt();
            switch(c){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    System.out.println("Total Employees = " + employees.size());
                    break;
                case 3:
                    System.out.println(employees.firstEntry());
                    break;
                case 4:
                    System.out.println(employees.lastEntry());
                    break;
                case 5:
                    employees.forEach((x,y)->System.out.println(y));
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Enter valid choice.");
            }
        }


    }
    public static void addEmployee()
    {
        System.out.println("Enter id of employee ");
        int id = sc.nextInt();
        System.out.println("Enter name of employee ");
        String name = sc.next();
        System.out.println("Enter salary of employee ");
        int salary = sc.nextInt();
        Employee emp = new Employee(id,name,salary);
        employees.put(id,emp);
    }
}
