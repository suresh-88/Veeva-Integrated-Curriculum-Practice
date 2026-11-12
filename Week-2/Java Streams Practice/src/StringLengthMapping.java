import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringLengthMapping {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of strings ");
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Enter the strings ");
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }
        Map<String,Integer> m = list.stream().collect(Collectors.toMap(str -> str, String::length));
        System.out.println(m);
    }
}
