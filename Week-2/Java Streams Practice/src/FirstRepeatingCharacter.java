import java.util.*;
import java.util.stream.Collectors;

public class FirstRepeatingCharacter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string ");
        String s = sc.next();
        System.out.println(Arrays.stream(s.split("")).collect(Collectors.groupingBy(n -> n)));
    }
}
