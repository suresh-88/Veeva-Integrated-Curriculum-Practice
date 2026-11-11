import java.sql.SQLOutput;
import java.util.*;

class Product {
    private final int product_id;
    private final String product_name;
    private final String company_name;
    private final double price;
    private final String manufactured_date;
    private final int quantity;

    public Product(int product_id, String product_name, String company_name, double price, String manufactured_date, int quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.company_name = company_name;
        this.price = price;
        this.manufactured_date = manufactured_date;
        this.quantity = quantity;
    }

    public String getProductName() {
        return product_name;
    }

    public String getCompanyName() {
        return company_name;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturedDate() {
        return manufactured_date;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "{" +
                "product id = " + product_id +
                ", product name = '" + product_name + '\'' +
                ", company name = '" + company_name + '\'' +
                ", price = " + price +
                ", manufactured on = '" + manufactured_date + '\'' +
                ", quantity = " + quantity +
                '}';
    }
}

class InvalidQuantity extends Exception
{
    InvalidQuantity(String message){
        super(message);
    }
}
public class ProductManagement
{
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer,Product> products = new HashMap<>();
    static ArrayList<Product> list = new ArrayList<>();
    public static void main(String[] args){
        seedSampleData();
        while(true) {
            System.out.println("\n1.Add Product\n2.Print all products\n3.Print all products by prices descending\n4.Print products by a price range descending\n" +
                    "5.Print all products by price and date descending\n6.Print Products Matching Specific Date\n7.Print Products Matching Specific Price\n" +
                    "8.Print Products Matching Specific Price and Company\n9.Top Costliest Products\n10.Top cheapest products\n11.Exit\nEnter your choice");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    for(Product p : products.values())
                        System.out.println(p);
                    System.out.println();
                    break;
                case 3:
                    printProductsByPriceDescending();
                    break;
                case 4:
                    printProductsByPriceRangeDescending();
                    break;
                case 5:
                    printProductsByPriceAndDateDescending();
                    break;
                case 6:
                    printProductsMatchingSpecificDate();
                    break;
                case 7:
                    printProductsMatchingSpecificPrice();
                    break;
                case 8:
                    printProductsMatchingSpecificPriceAndCompany();
                    break;
                case 9:
                    printTopKCostliestProducts();
                    break;
                case 10:
                    printTopkCheapestProducts();
                    break;
                case 11:
                    System.exit(4);
                default:System.out.println("enter valid choice");
            }
        }
    }

    public static void addProduct(){
        System.out.println("Enter product id ");
        int id = sc.nextInt();
        if(products.containsKey(id)) {
            System.out.println("Duplicate products not allowed.");
            return;
        }
        System.out.println("Enter product name ");
        String name = sc.next();
        System.out.println("Enter company name ");
        String company = sc.next();
        System.out.println("Enter product price ");
        double price = sc.nextDouble();
        System.out.println("Enter product manufactured date ");
        String date = sc.next();
        System.out.println("Enter product quantity ");
        int quantity = sc.nextInt();
        try{
            if(quantity<100)
                throw new InvalidQuantity("Quantity should not be less than 100.");
        }
        catch(InvalidQuantity e){
            System.out.println("Exception:"+e);
            return;
        }
        Product product = new Product(id,name,company,price,date,quantity);
        products.put(id,product);
        list.add(product);
    }

    public static void printProductsByPriceDescending()
    {

        list.sort((s1, s2) -> Double.compare(s2.getPrice(), s1.getPrice()));
        for(Product p : list)
            System.out.println(p);
        System.out.println();
    }

    public static void printProductsMatchingSpecificDate()
    {
        System.out.println("Enter the date you want :");
        String date = sc.next();
        for(Product p : products.values())
            if(p.getManufacturedDate().equals(date))
                System.out.println(p);
        System.out.println();
    }

    public static void printProductsMatchingSpecificPrice()
    {
        System.out.println("Enter the price you want :");
        double price = sc.nextDouble();
        for(Product p : products.values())
            if(p.getPrice()==price)
                System.out.println(p);
        System.out.println();
    }

    public static void printTopKCostliestProducts()
    {
        System.out.println("Enter no.of products you want :");
        int n = sc.nextInt();
        list.sort((s1, s2) -> Double.compare(s2.getPrice(), s1.getPrice()));
        if(n>list.size()) {
            System.out.println("There are only " + list.size() + " products.");
            for (Product p : list)
                System.out.println(p);
        }
        else{
            for(int i=0;i<n;i++)
                System.out.println(list.get(i));
        }
        System.out.println();
    }

    public static void printTopkCheapestProducts()
    {
        System.out.println("Enter no.of products you want :");
        int n = sc.nextInt();
        list.sort((s1, s2) -> Double.compare(s1.getPrice(), s2.getPrice()));
        if(n>list.size()) {
            System.out.println("There are only " + list.size() + " products.");
            for (Product p : list)
                System.out.println(p);
        }
        else{
            for(int i=0;i<n;i++)
                System.out.println(list.get(i));
        }
        System.out.println();
    }

    public static void printProductsMatchingSpecificPriceAndCompany()
    {
        System.out.println("Enter the price you want :");
        double price = sc.nextDouble();
        System.out.println("Enter the company you want :");
        String company = sc.next();
        for(Product p : products.values())
            if(p.getPrice()==price&&p.getCompanyName().equalsIgnoreCase(company))
                System.out.println(p);
        System.out.println();
    }

    public static void printProductsByPriceAndDateDescending()
    {
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getPrice() < p2.getPrice())
                    return 1;
                else if (p1.getPrice() > p2.getPrice())
                    return -1;
                else
                    return p1.getManufacturedDate().compareTo(p2.getManufacturedDate());
            }
        });
        for(Product p : list)
            System.out.println(p);
        System.out.println();
    }
    public static void printProductsByPriceRangeDescending()
    {
        System.out.println("Enter min price :");
        int min = sc.nextInt();
        System.out.println("Enter max price :");
        int max = sc.nextInt();
        list.sort((s1, s2) -> Double.compare(s2.getPrice(), s1.getPrice()));
        for(Product p : list)
            if(p.getPrice()>=min&&p.getPrice()<=max)
                System.out.println(p);
        System.out.println();
    }

    private static void seedSampleData() {
        products.put(106, new Product(106, "Mobile", "Samsung", 5000.0, "2022-11-25", 102));
        products.put(101, new Product(101, "Laptop", "Lenovo", 1000.0, "2024-01-15", 150));
        products.put(102, new Product(102, "Mouse", "Logitech", 2000.0, "2024-02-10", 200));
        products.put(103, new Product(103, "Keyboard", "Portronics", 3000.0, "2024-03-01", 120));
        products.put(104, new Product(104, "Monitor", "Dell", 4000.0, "2024-01-20", 110));
        products.put(105, new Product(105, "Mobile", "Vivo", 3000.0, "2023-12-16", 143));
        list.addAll(products.values());
    }
}