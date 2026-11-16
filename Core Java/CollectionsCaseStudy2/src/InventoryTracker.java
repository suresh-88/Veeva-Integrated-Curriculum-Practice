package src;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Company
{
    private final int companyId;
    private String companyName;
    private String contact;
    private String location;

    public Company(int companyId, String companyName, String contact, String location) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.contact = contact;
        this.location = location;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", contact='" + contact + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

class Product
{
    private final int productId;
    private String productName;
    private int price;
    private Company company;
    private String category;
    private int stock;

    public Product(int productId, String productName, int price, Company company, String category, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.company = company;
        this.category = category;
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public Company getCompany() {
        return company;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", company=" + company.getCompanyName() +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                '}';
    }
}
class Transaction
{
    private static int counter=0;
    private int transactionId;
    private HashMap<Integer,Integer> products;
    private long totalAmount;
    private LocalDateTime timeStamp;

    public Transaction(HashMap<Integer, Integer> products, long totalAmount) {
        transactionId=++counter;
        this.products = products;
        this.totalAmount = totalAmount;
        timeStamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", products=" + products +
                ", totalAmount=" + totalAmount +
                ", timeStamp=" + timeStamp +
                '}';
    }
}

class InsufficientStockException extends Exception{
    InsufficientStockException(String msg){
        super(msg);
    }
}

class OutOfStockException extends Exception{
    OutOfStockException(String msg){
        super(msg);
    }
}

public class InventoryTracker {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer,Company> companies = new HashMap<>();
    static HashMap<Integer,Product> products = new HashMap<>();
    static ArrayList<Transaction> transactions = new ArrayList<>();
    public static void main(String[] args) {
        while(true){
            System.out.println("\nChoose login Type:");
            System.out.println("1.Admin\n2.Customer");
            int login = sc.nextInt();
            if(login==1)
                adminLogin();
            else if(login==2)
                customerLogin();
            else
                System.out.println("Choose valid login type.");
        }
    }

    public static void adminLogin()
    {
        System.out.println("\nHello Admin");
        while (true) {
            System.out.println("""
                    
                    Here is your menu:
                    1.Add a company
                    2.Add a product
                    3.Update existing product
                    4.Update existing company
                    5.Print all companies
                    6.Print all products
                    7.Get product price by id
                    8.Get product supplier details by id
                    9.Log Out
                    10.Exit
                    Enter your choice""");
            int c = sc.nextInt();
            sc.nextLine();
            switch (c) {
                case 1:
                    addCompany();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    updateProductById();
                    break;
                case 4:
                    updateCompanyDetailsById();
                    break;
                case 5:
                    printCompanies();
                    break;
                case 6:
                    printProducts();
                    break;
                case 7:
                    printProductPriceById();
                    break;
                case 8:
                    printProductSupplierDetailsById();
                    break;
                case 9:
                    return;
                case 10:
                    System.exit(4);
                default:
                    System.out.println("enter valid choice");
            }
        }
    }
    public static void updateProductById()
    {
        if(products.isEmpty()){
            System.out.println("There are no products in database.");
            return;
        }
        System.out.println("Enter product id:");
        int id = sc.nextInt();
        if(products.containsKey(id)){
            System.out.println("Choose what you want to update(1 or 2)\n1.price\n2.quantity\n");
            int opt = sc.nextInt();
            if(opt==1) {
                System.out.println("Enter updated price:");
                int price = sc.nextInt();
                if(price>0)
                    products.get(id).setPrice(price);
                else
                    System.out.println("Price should be greater than 0.");
            }
            else if(opt==2){
                System.out.println("Enter updated stock:");
                int stock = sc.nextInt();
                if(stock>=0)
                    products.get(id).setStock(stock);
                else
                    System.out.println("Stock can't be negative");
            }
            else {
                System.out.println("Invalid choice");
            }
        }
        else
            System.out.println("Product Not Found.");;
    }
    public static void updateCompanyDetailsById()
    {
        if(companies.isEmpty()){
            System.out.println("There are no companies in database.");
            return;
        }
        System.out.println("Enter company id:");
        int id = sc.nextInt();
        if(companies.containsKey(id)){
            System.out.println("Choose what you want to update(1 or 2)\n1.name\n2.contact\n3.location");
            int opt = sc.nextInt();
            sc.nextLine();
            if(opt==1) {
                System.out.println("Enter updated name:");
                companies.get(id).setCompanyName(sc.nextLine());
            }
            else if(opt==2){
                System.out.println("Enter updated contact:");
                companies.get(id).setContact(sc.nextLine());
            }
            else if(opt==3){
                System.out.println("Enter updated location:");
                companies.get(id).setLocation(sc.nextLine());
            }
            else {
                System.out.println("Invalid choice");
            }
        }
        else
            System.out.println("Company Not Found.");;
    }
    public static void customerLogin()
    {
        System.out.println("\nHello Customer");
        while(true)
        {
            System.out.println("\nHere is your menu:\n1.Buy Items\n2.Transaction History\n3.Log Out\n4.Exit\nEnter your choice:");
            int c = sc.nextInt();
            switch(c)
            {
                case 1:
                    try {
                        buyItems();
                    }
                    catch(OutOfStockException e){
                        System.out.println(e);
                    }
                    catch(InsufficientStockException e){
                        System.out.println(e);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println(transactions);
                    break;
                case 3:
                    return;
                case 4:
                    System.out.println("GoodBye Customer!");
                    System.exit(404);
            }
        }

    }

    public static void printCompanies()
    {
        if (companies.isEmpty())
            System.out.println("No companies added till now.");
        else {
            for (Company comp : companies.values())
                System.out.println(comp);
            System.out.println();
        }
    }

    public static void printProducts()
    {
        if (products.isEmpty())
            System.out.println("No products added till now.");
        else{
            for (Product prod : products.values())
                System.out.println(prod);
            System.out.println();
        }
    }

    public static void addCompany()
    {
        System.out.println("Enter company Id:");
        int id = sc.nextInt();
        if(companies.containsKey(id)){
            System.out.println("Company with id "+id+" already exists.");
            return;
        }
        System.out.println("Enter company name:");
        String name = sc.next();
        sc.nextLine();
        System.out.println("Enter contact details:");
        String contact = sc.nextLine();
        System.out.println("Enter company location:");
        String location = sc.next();
        Company company = new Company(id,name,contact,location);
        companies.put(id,company);
        System.out.println("Company added successfully.");
    }

    public static void addProduct()
    {
        System.out.println("Enter product Id:");
        int id = sc.nextInt();
        if(products.containsKey(id)){
            System.out.println("Product with id "+id+" already exists.");
            return;
        }
        System.out.println("Enter product name:");
        String name = sc.next();
        System.out.println("Enter product price:");
        int price = sc.nextInt();
        System.out.println("Enter company id:");
        int compId = sc.nextInt();
        if(!companies.containsKey(compId)){
            System.out.println("Company doesn't exist, add valid product.");
            return;
        }
        System.out.println("Enter product category:");
        String category = sc.next();
        System.out.println("Enter product stock:");
        int stock = sc.nextInt();
        if(stock<1){
            System.out.println("Stock can't be less than 1, add valid product.");
            return;
        }
        Product product = new Product(id,name,price,companies.get(compId),category,stock);
        products.put(id,product);
        System.out.println("Product added successfully.");
    }

    public static void printProductPriceById()
    {
        if(products.isEmpty()){
            System.out.println("There are no products in database.");
            return;
        }
        System.out.println("Enter product id:");
        int id = sc.nextInt();
        if(products.containsKey(id))
            System.out.println("Price = " + products.get(id).getPrice());
        else
            System.out.println("Product Not Found.");;
    }

    public static void printProductSupplierDetailsById()
    {
        if(products.isEmpty()){
            System.out.println("There are no products in database.");
            return;
        }
        System.out.println("Enter product id:");
        int id = sc.nextInt();
        if(products.containsKey(id))
            System.out.println(products.get(id).getCompany());
        else
            System.out.println("Product not found.");
    }

    public static void buyItems() throws InsufficientStockException,OutOfStockException
    {
        if(products.isEmpty()){
            System.out.println("There are no products in database.");
            return;
        }
        printProducts();
        System.out.println("Enter the no.of products you want to buy:");
        int n = sc.nextInt();
        if(n>products.size()) {
            System.out.println("There are only " +products.size()  + " products in database.");
            return;
        }
        HashMap<Integer,Integer> cart = new HashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the product id: ");
            int id = sc.nextInt();
            while (!products.containsKey(id)) {
                System.out.println("Product with id: " + id+" does not exist.Choose valid product:");
                id = sc.nextInt();
            }
            if(cart.containsKey(id)){
                System.out.println("Product already added.");
                continue;
            }
            int currStock = products.get(id).getStock();
            if(currStock==0){
                throw new OutOfStockException("Product Out of Stock.");
            }
            System.out.print("Enter the quantity you want to buy: ");
            int quantity = sc.nextInt();
            while(quantity<=0){
                System.out.println("Quantity should be greater than 0. Enter valid quantity:");
                quantity = sc.nextInt();
            }
            if (currStock<quantity) {
                String msg = "Insufficient Stock. Current stock = "+currStock;
                throw new InsufficientStockException(msg);
            }
            cart.put(id,quantity);
        }
        long total = 0;
        for(Map.Entry<Integer,Integer> e: cart.entrySet()){
            int id = e.getKey();
            int quan = e.getValue();
            Product p = products.get(id);
            int currStock = p.getStock();
            p.setStock(currStock-quan);
            total+=(long)quan*p.getPrice();
        }
        Transaction t = new Transaction(cart,total);
        transactions.add(t);
        System.out.println("Transaction successful. Total amount = $" + total);
    }
}