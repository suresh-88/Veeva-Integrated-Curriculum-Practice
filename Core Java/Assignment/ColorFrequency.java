import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ColorFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> colors = new ArrayList<>();
        System.out.println("Enter no.of colors you want:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            colors.add(sc.next().toLowerCase());
        System.out.println("Frequency of each color:");
        Map<String,Long> freq = colors.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(freq);
        System.out.println("Color with highest frequency");
        freq.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(1).forEach(System.out::println);
        System.out.println("Color with lowest frequency");
        freq.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(1).forEach(System.out::println);
        System.out.println("Colors with k frequency");
        System.out.println("Enter k:");
        int k = sc.nextInt();
        freq.entrySet().stream().filter(x->x.getValue()==k).forEach(System.out::println);
    }
}
