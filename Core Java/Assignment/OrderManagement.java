import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

class Order{
    private static int counter=0;
    private int orderId;
    private int customerId;
    private String category;
    private int amount;

    public Order(int customerId, String category, int amount) {
        this.orderId = ++counter;
        this.customerId = customerId;
        this.category = category;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }
}
public class OrderManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of orders:");
        int n = sc.nextInt();
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter customer id of order-"+i);
            int id = sc.nextInt();
            System.out.println("Enter category of order-"+i);
            String category = sc.next();
            System.out.println("Enter amount of order-"+i);
            int amount = sc.nextInt();
            Order order = new Order(id,category,amount);
            orders.add(order);
        }
        System.out.println("Orders with amount less than or equal to 0");
        orders.stream().filter(m->m.getAmount()<=0).forEach(System.out::println);
        System.out.println("top 3 highest spending customer ids");
        orders.stream().collect(Collectors.groupingBy(Order::getCustomerId,Collectors.summingInt(Order::getAmount))).entrySet().stream().sorted((a,b)->b.getValue()-a.getValue()).forEach(System.out::println);
    }
}
