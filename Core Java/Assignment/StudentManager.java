import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student{
    private int id;
    private String name;
    private int marks;
    private double grade;

    public Student(int id, String name, int marks, double grade) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", marks = " + marks +
                ", grade = " + grade +
                '}';
    }
}

class StudentNotFoundException extends Exception
{
    public StudentNotFoundException(String message)
    {
        super(message);
    }
}
public class StudentManager {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer,Student> students = new HashMap<>();
    public static void main(String[] args) {
        while(true){
            System.out.println("1.Add Student\n2.Get Student Details By Name\n3.Get Marks of Student By id\n4.Update student marks\n5.Remove Student by id\n6.Exists\n7.Exit");
            int c = sc.nextInt();
            switch(c){
                case 1:
                    addStudent();
                    break;
                case 2:
                    System.out.println("Enter student name:");
                    String name = sc.next();
                    try {
                        getStudent(name);
                    }catch (StudentNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter student id:");
                    int id = sc.nextInt();
                    try {
                        System.out.println(getStudentMarks(id));
                    }catch (StudentNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Enter student id:");
                    int sid = sc.nextInt();
                    updateStudentMarks(sid);
                    break;
                case 5:
                    System.out.println("Enter student id:");
                    int stdid = sc.nextInt();
                    try {
                        removeStudent(stdid);
                    }catch (StudentNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Enter student id:");
                    int stdId = sc.nextInt();
                    System.out.println(exists(stdId));
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Enter valid choice.");
            }
        }


    }
    public static void addStudent()
    {
        System.out.println("Enter id of student ");
        int id = sc.nextInt();
        System.out.println("Enter name of student ");
        String name = sc.next();
        System.out.println("Enter marks of student ");
        int marks = sc.nextInt();
        System.out.println("Enter grade of student");
        double grade = sc.nextDouble();
        if(!exists(id)){
            Student student = new Student(id,name,marks,grade);
            students.put(id,student);
            System.out.println("Student added successfully.");
        }
        else {
            students.get(id).setMarks(marks);
            System.out.println("Student marks updated successfully.");
        }
    }

    public static void getStudent(String name) throws StudentNotFoundException {
        boolean studentExist = false;
        for(Map.Entry<Integer,Student> e:students.entrySet()){
            Student std = e.getValue();
            if(std.getName().equalsIgnoreCase(name)) {
                System.out.println(std);
                studentExist = true;
            }
        }
        if(!studentExist)
            throw new StudentNotFoundException(name+" not found.");
    }

    public static int getStudentMarks(int id) throws StudentNotFoundException {
        if(exists(id))
            return students.get(id).getMarks();
        else
            throw new StudentNotFoundException(id+" not found.");
    }

    public static void updateStudentMarks(int id)  {
        if(exists(id)){
            System.out.println("Enter updated marks:");
            int marks = sc.nextInt();
            students.get(id).setMarks(marks);
            System.out.println("Marks updated successfully.");
        }
        else{
            System.out.println("Enter name of student ");
            String name = sc.next();
            System.out.println("Enter marks of student ");
            int marks = sc.nextInt();
            System.out.println("Enter grade of student");
            double grade = sc.nextDouble();
            Student student = new Student(id,name,marks,grade);
            students.put(id,student);
            System.out.println("Student Added successfully.");
        }
    }

    public static void removeStudent(int id) throws StudentNotFoundException {
        if(exists(id)){
            students.remove(id);
            System.out.println("Student removed successfully.");
        }
        else
            throw new StudentNotFoundException(id+" not found.");
    }

    public static boolean exists(int id)
    {
        return students.containsKey(id);
    }
}
