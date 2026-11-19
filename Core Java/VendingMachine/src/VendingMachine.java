package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Item
{
    private final int productId;
    private String productName;
    private int price;
    private int stock;

    public Item(int productId, String productName, int price, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public int getPrice() {
        return price;
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
                ", stock=" + stock +
                '}';
    }
}

class InsufficientQuantityException extends Exception{
    InsufficientQuantityException(String msg){
        super(msg);
    }
}

class SoldOutException extends Exception{
    SoldOutException(String msg){
        super(msg);
    }
}

public class VendingMachine {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer,Item> items = new HashMap<>();
    public static void main(String[] args) {
        while(true){
            System.out.println("\nWho are you:");
            System.out.println("1.Owner\n2.Customer\n3.Exit");
            int login = sc.nextInt();
            if(login==1)
                ownerLogin();
            else if(login==2)
                customerLogin();
            else if(login==3)
                break;
            else
                System.out.println("Choose valid login type.");
        }
    }

    public static void ownerLogin()
    {
        System.out.println("\nHello Owner");
        while (true) {
            System.out.println("""
                    
                    Here is your menu:
                    1.Add a product
                    2.Update existing product
                    3.Print all products
                    4.Log Out
                    5.Exit
                    Enter your choice""");
            int c = sc.nextInt();
            sc.nextLine();
            switch (c) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProducts();
                    break;
                case 3:
                    printProducts();
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(4);
                default:
                    System.out.println("enter valid choice");
            }
        }
    }
    public static void updateProducts()
    {
        if(items.isEmpty()){
            System.out.println("There are no products in vending machine.");
            return;
        }
        System.out.println("Enter product id:");
        int id = sc.nextInt();
        if(items.containsKey(id)){
            System.out.println("Choose what you want to update(1 or 2)\n1.price\n2.quantity\n");
            int opt = sc.nextInt();
            if(opt==1) {
                System.out.println("Enter updated price:");
                int price = sc.nextInt();
                if(price>0)
                    items.get(id).setPrice(price);
                else
                    System.out.println("Price should be greater than 0.");
            }
            else if(opt==2){
                System.out.println("Enter updated stock:");
                int stock = sc.nextInt();
                if(stock>=0)
                    items.get(id).setStock(stock);
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

    public static void customerLogin()
    {
        System.out.println("\nHello Customer");
        while(true)
        {
            System.out.println("\nHere is your menu:\n1.Select Items\n2.Buy selected items\n3.Check available money\n4.Cancel transaction\n5.Exit\nEnter your choice:");
            int c = sc.nextInt();
            switch(c)
            {
                case 1:
                    try {
                        selectItems();
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
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("GoodBye Customer!");
                    System.exit(404);
            }
        }

    }

    public static void printProducts()
    {
        if (items.isEmpty())
            System.out.println("No products added till now.");
        else{
            for (Item item : items.values())
                System.out.println(item);
            System.out.println();
        }
    }

    public static void addProduct()
    {
        System.out.println("Enter product Id:");
        int id = sc.nextInt();
        if(items.containsKey(id)){
            System.out.println("Product with id "+id+" already exists.");
            return;
        }
        System.out.println("Enter product name:");
        String name = sc.next();
        System.out.println("Enter product price:");
        int price = sc.nextInt();
        System.out.println("Enter product stock:");
        int stock = sc.nextInt();
        if(stock<1){
            System.out.println("Stock can't be less than 1, add valid product.");
            return;
        }
        Item item = new Item(id,name,price,stock);
        items.put(id,item);
        System.out.println("Product added successfully.");
    }

    public static void printProductPriceById()
    {
        if(items.isEmpty()){
            System.out.println("There are no products in database.");
            return;
        }
        System.out.println("Enter product id:");
        int id = sc.nextInt();
        if(items.containsKey(id))
            System.out.println("Price = " + items.get(id).getPrice());
        else
            System.out.println("Product Not Found.");;
    }


    public static void buyItems() throws InsufficientStockException,OutOfStockException
    {
        if(items.isEmpty()){
            System.out.println("There are no products in database.");
            return;
        }
        printProducts();
        System.out.println("Enter the no.of products you want to buy:");
        int n = sc.nextInt();
        if(n>items.size()) {
            System.out.println("There are only " +items.size()  + " products in database.");
            return;
        }
        HashMap<Integer,Integer> cart = new HashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the product id: ");
            int id = sc.nextInt();
            while (!items.containsKey(id)) {
                System.out.println("Product with id: " + id+" does not exist.Choose valid product:");
                id = sc.nextInt();
            }
            if(cart.containsKey(id)){
                System.out.println("Product already added.");
                continue;
            }
            int currStock = items.get(id).getStock();
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
            Item p = items.get(id);
            int currStock = p.getStock();
            p.setStock(currStock-quan);
            total+=(long)quan*p.getPrice();
        }
        System.out.println("Transaction successful. Total amount = $" + total);
    }
}