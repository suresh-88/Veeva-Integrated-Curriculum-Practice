import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ShortestWord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of strings ");
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Enter the strings ");
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }
        list.stream().min(Comparator.comparingInt(String::length)).ifPresent(System.out::println);
    }
}
