import java.util.*;
import java.util.stream.Collectors;

class NewEmployee
{
    int employeeId;
    String employeeName;
    String job;
    ArrayList<String> skills;
    int salary;
    String department;

    public NewEmployee(int employeeId, String employeeName, String job, ArrayList<String> skills, int salary, String deptartment) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.job = job;
        this.skills = skills;
        this.salary = salary;
        this.department = deptartment;
    }


    public String getEmployeeName() {
        return employeeName;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", job='" + job + '\'' +
                ", skills='" + skills + '\'' +
                ", salary=" + salary +
                ", deptartment='" + department + '\'' +
                '}';
    }
}
public class CaseStudy3 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<NewEmployee> employees = new ArrayList<>();
    public static void main(String[] args) {
        seedSampleData();
        while(true) {
            System.out.println("""
                    
                    1.Add Employees
                    2.display all employees
                    3.top earning employees in each department dept wise
                    4.names of employees in engineering department salary greater than 80000 in sorted order
                    5.extracted the de-duplicated list of all employee skills that start with j
                    6.group all employees by department but only include employees earning more than 1 lakh salary
                    7.first employee in each department
                    8.Exit
                    Enter your choice""");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    addEmployees();
                    break;
                case 2:
                    for(NewEmployee e : employees)
                        System.out.println(e);
                    System.out.println();
                    break;
                case 3:
                    System.out.println(employees.stream().collect(Collectors.groupingBy(NewEmployee::getDepartment, Collectors.maxBy(Comparator.comparingInt(NewEmployee::getSalary)))));
                    break;
                case 4:
                    System.out.println(employees.stream().filter(e->e.getDepartment().equalsIgnoreCase("Engineering")&& e.getSalary()>80000).sorted(Comparator.comparing(NewEmployee::getEmployeeName)).map(NewEmployee::getEmployeeName).toList());
                    break;
                case 5:
                    System.out.println(employees.stream().flatMap(e->e.getSkills().stream()).filter(e->e.toLowerCase().startsWith("j")).distinct().toList());
                    break;
                case 6:
                    System.out.println(employees.stream().filter(e->e.getSalary()>100000).collect(Collectors.groupingBy(NewEmployee::getDepartment)));
                    break;
                case 7:
                    employees.stream().collect(Collectors.groupingBy(NewEmployee::getDepartment)).forEach((x,y)-> System.out.println(x+" "+y.getFirst()));
                    break;
                case 8:
                    System.exit(4);
                default:System.out.println("Enter valid choice");
            }
        }
    }

    public static void addEmployees(){
        System.out.println("Enter no.of employees ");
        int n = sc.nextInt();
        System.out.println("Enter employees data ");
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter employee-%d id : ",i);
            int id = sc.nextInt();
            System.out.printf("Enter employee-%d name : ",i);
            String name = sc.next();
            System.out.printf("Enter employee-%d job : ",i);
            String job = sc.next();
            sc.nextLine();
            System.out.printf("Enter employee-%d skills : ",i);
            String skill = sc.nextLine();
            ArrayList<String> skills = new ArrayList<>(Arrays.asList(skill.split(" ")));
            System.out.printf("Enter employee-%d salary : ",i);
            int salary = sc.nextInt();
            System.out.printf("Enter employee-%d department : ",i);
            String department = sc.next();
            NewEmployee employee = new NewEmployee(id,name,job,skills,salary,department);
            employees.add(employee);
            System.out.println("Employee added successfully.");
        }
    }
    private static void seedSampleData() {
        employees.add(new NewEmployee(
                101, "Alice", "Developer",
                new ArrayList<>(Arrays.asList("Java", "Spring", "SQL")),
                85000, "Engineering"
        ));
        employees.add(new NewEmployee(
                102, "Bob", "Designer",
                new ArrayList<>(Arrays.asList("Figma", "CSS", "HTML")),
                72000, "Product"
        ));
        employees.add(new NewEmployee(
                103, "Charlie", "Analyst",
                new ArrayList<>(Arrays.asList("Python", "Excel", "Tableau")),
                78000, "Engineering"
        ));
        employees.add(new NewEmployee(
                104, "Diana", "Manager",
                new ArrayList<>(Arrays.asList("Agile", "Scrum", "Jira")),
                95000, "Operations"
        ));
        employees.add(new NewEmployee(
                105, "Daniel", "Tester",
                new ArrayList<>(Arrays.asList("Agile", "Scrum", "Jira")),
                87000, "Engineering"
        ));
    }
}
