import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ArrayListStream {
    public static void main() {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("""
                    1.Add N elements
                    2.Starts with specific letter
                    3.starts with j and ends with a
                    4.Starts with specific letter in upper case
                    5.Starts with specific letter distinct
                    6.Starts with specific letter distinct and uppercase
                    7.Starts with specific letter sorted
                    8.Starts with specific letter distinct,sorted,uppercase
                    9.count distinct elements Starts with specific letter
                    10.First element that starts with specific letter
                    11.whether any element starts with 's'
                    12.whether all element starts with 's'
                    13.Print all elements
                    14.Exit""");
            System.out.println("Choose an option ");
            int c = sc.nextInt();
            switch(c){
                case 1:
                    System.out.println("Enter the no.of elements: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++)
                        list.add(sc.next());
                    break;
                case 2:
                    System.out.println("Enter the letter: ");
                    char l = sc.next().toLowerCase().charAt(0);
                    list.stream().filter(element->element.toLowerCase().charAt(0)== l).forEach(System.out::println);
                    break;
                case 3:
                    list.stream().filter(element->element.toLowerCase().charAt(0)=='j'||element.toLowerCase().endsWith("a")).forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Enter the letter: ");
                    char p = sc.next().toLowerCase().charAt(0);
                    list.stream().filter(element->element.toLowerCase().charAt(0)== p).map(String::toUpperCase).forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Enter the letter: ");
                    char d = sc.next().toLowerCase().charAt(0);
                    list.stream().filter(element->element.toLowerCase().charAt(0)== d).distinct().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Enter the letter: ");
                    char t = sc.next().toLowerCase().charAt(0);
                    list.stream().filter(element->element.toLowerCase().charAt(0)== t).map(String::toUpperCase).distinct().forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Enter the letter: ");
                    char j = sc.next().toLowerCase().charAt(0);
                    list.stream().filter(element->element.toLowerCase().charAt(0)== j).sorted().forEach(System.out::println);
                    break;
                case 8:
                    System.out.println("Enter the letter: ");
                    char ltr = sc.next().toLowerCase().charAt(0);
                    list.stream().filter(element->element.toLowerCase().charAt(0)== ltr).map(String::toUpperCase).distinct().sorted().forEach(System.out::println);
                    break;
                case 9:
                    System.out.println("Enter the letter: ");
                    char le = sc.next().toLowerCase().charAt(0);
                    System.out.println(list.stream().filter(element->element.toLowerCase().charAt(0)==le).distinct().count());
                    break;
                case 10:
                    System.out.println("Enter the letter: ");
                    char let = sc.next().toLowerCase().charAt(0);
                    System.out.println(list.stream().filter(element->element.toLowerCase().charAt(0)==let).findFirst());
                    break;
                case 11:
                    System.out.println(list.stream().anyMatch(m->m.toLowerCase().charAt(0)=='s'));
                    break;
                case 12:
                    System.out.println(list.stream().allMatch(m->m.toLowerCase().charAt(0)=='s'));
                    break;
                case 13:
                    for(String s:list)
                        System.out.println(s);
                    System.out.println();
                case 14:
                    System.exit(4);
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
