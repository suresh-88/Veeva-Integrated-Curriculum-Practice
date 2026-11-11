import java.util.*;
import java.util.stream.Collectors;

public class CaseStudy2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,5,7,9,10));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        while(true) {
            System.out.println("""
                    
                    1.print lists
                    2.sum, avg, max and min of each list
                    3.k most frequent elements in each list
                    4.second most frequent in each list
                    5.merge two lists into single list
                    6.Common elements in two lists
                    7.Exit
                    Enter your choice""");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    list1.forEach(x-> System.out.print(x+" "));
                    System.out.println();
                    list2.forEach(x-> System.out.print(x+" "));
                    System.out.println();
                    break;
                case 2:
                    IntSummaryStatistics stats1 = list1.stream().mapToInt(n->n).summaryStatistics();
                    IntSummaryStatistics stats2 = list2.stream().mapToInt(n->n).summaryStatistics();
                    System.out.println("List1 : {sum="+stats1.getSum()+" max="+stats1.getMax()+" min="+stats1.getMin()+" avg="+stats1.getAverage()+"}");
                    System.out.println("List2 : {sum="+stats2.getSum()+" max="+stats2.getMax()+" min="+stats2.getMin()+" avg="+stats2.getAverage()+"}");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(4);
                default:System.out.println("Enter valid choice");
            }
        }
    }


}