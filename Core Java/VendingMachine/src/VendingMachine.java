package src;

import java.time.LocalDateTime;
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

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=Rs." + price +
                ", stock=" + stock +
                '}';
    }
}

class Transaction
{
    static int counter = 0;
    int transactionId;
    HashMap<Integer,Integer> products;
    long totalAmount;
    String paymentMode;
    LocalDateTime timeStamp;

    public Transaction(HashMap<Integer, Integer> products, long totalAmount, String paymentMode) {
        transactionId = ++counter;
        this.products = new HashMap<>(products);
        this.totalAmount = totalAmount;
        this.paymentMode = paymentMode;
        timeStamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", products=" + products +
                ", totalAmount=Rs." + totalAmount +
                ", paymentMode='" + paymentMode + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}

class NoSufficientFundException extends Exception {
    NoSufficientFundException(String msg) {
        super(msg);
    }
}

class InsufficientChangeException extends Exception {
    InsufficientChangeException(String msg) {
        super(msg);
    }
}

class SoldOutException extends Exception {
    SoldOutException(String msg) {
        super(msg);
    }
}

class InsufficientQuantityException extends Exception {
    InsufficientQuantityException(String msg) {
        super(msg);
    }
}

public class VendingMachine {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer,Item> items = new HashMap<>();
    static HashMap<Integer,Integer> currency = new HashMap<>();
    static ArrayList<Transaction> transactions = new ArrayList<>();

    static int[] denominations = {500, 200, 100, 50, 20, 10, 5, 2, 1};

    public static void main(String[] args) {
        while(true) {
            System.out.println("\nWho are you:");
            System.out.println("1.Owner\n2.Customer\n3.Exit");
            int login = sc.nextInt();

            if(login == 1)
                ownerLogin();
            else if(login == 2)
                customerLogin();
            else if(login == 3) {
                System.out.println("Vending Machine Closed.");
                break;
            }
            else
                System.out.println("Choose valid login type.");
        }
    }

    public static void ownerLogin() {
        System.out.println("\nHello Owner");
        while(true) {
            System.out.println("""

                    Here is your menu:
                    1.Add a product
                    2.Update existing product
                    3.Print all products
                    4.Add currency for change
                    5.Check available currency
                    6.Log Out
                    Enter your choice""");

            int c = sc.nextInt();
            sc.nextLine();

            switch(c) {
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
                    addCurrency();
                    break;
                case 5:
                    printCurrency();
                    break;
                case 6:
                    System.out.println("Owner logged out.");
                    return;
                default:
                    System.out.println("Enter valid choice.");
            }
        }
    }

    public static void customerLogin() {
        System.out.println("\nHello Customer");
        while(true) {
            System.out.println("""

                    Here is your menu:
                    1.Select items and buy
                    2.View available products
                    3.Transaction history
                    4.Log Out
                    Enter your choice""");

            int c = sc.nextInt();

            switch(c) {
                case 1:
                    try {
                        buyItems();
                    }
                    catch(SoldOutException e) {
                        System.out.println(e.getMessage());
                    }
                    catch(InsufficientQuantityException e) {
                        System.out.println(e.getMessage());
                    }
                    catch(NoSufficientFundException e) {
                        System.out.println(e.getMessage());
                    }
                    catch(InsufficientChangeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    printProducts();
                    break;
                case 3:
                    printTransactions();
                    break;
                case 4:
                    System.out.println("GoodBye Customer!");
                    return;
                default:
                    System.out.println("Enter valid choice.");
            }
        }
    }

    public static void addProduct() {
        System.out.println("Enter product Id:");
        int id = sc.nextInt();

        if(items.containsKey(id)) {
            System.out.println("Product with id " + id + " already exists.");
            return;
        }

        sc.nextLine();
        System.out.println("Enter product name:");
        String name = sc.nextLine();

        System.out.println("Enter product price:");
        int price = sc.nextInt();

        if(price <= 0) {
            System.out.println("Price should be greater than 0.");
            return;
        }

        System.out.println("Enter product stock:");
        int stock = sc.nextInt();

        if(stock < 0) {
            System.out.println("Stock can't be negative.");
            return;
        }

        Item item = new Item(id, name, price, stock);
        items.put(id, item);
        System.out.println("Product added successfully.");
    }

    public static void updateProducts() {
        if(items.isEmpty()) {
            System.out.println("There are no products in vending machine.");
            return;
        }

        System.out.println("Enter product id:");
        int id = sc.nextInt();

        if(items.containsKey(id)) {
            System.out.println("Choose what you want to update:\n1.Price\n2.Quantity");
            int opt = sc.nextInt();

            if(opt == 1) {
                System.out.println("Enter updated price:");
                int price = sc.nextInt();

                if(price > 0)
                    items.get(id).setPrice(price);
                else
                    System.out.println("Price should be greater than 0.");
            }
            else if(opt == 2) {
                System.out.println("Enter updated stock:");
                int stock = sc.nextInt();

                if(stock >= 0)
                    items.get(id).setStock(stock);
                else
                    System.out.println("Stock can't be negative.");
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
        else {
            System.out.println("Product Not Found.");
        }
    }

    public static void printProducts() {
        if(items.isEmpty()) {
            System.out.println("No products added till now.");
            return;
        }

        for(Item item : items.values())
            System.out.println(item);

        System.out.println();
    }

    public static void addCurrency() {
        System.out.println("Available denominations: 1, 2, 5, 10, 20, 50, 100, 200, 500");
        System.out.println("Enter denomination:");
        int denomination = sc.nextInt();

        boolean valid = false;
        for(int d : denominations) {
            if(d == denomination) {
                valid = true;
                break;
            }
        }

        if(!valid) {
            System.out.println("Invalid denomination.");
            return;
        }

        System.out.println("Enter quantity:");
        int quantity = sc.nextInt();

        if(quantity <= 0) {
            System.out.println("Quantity should be greater than 0.");
            return;
        }

        currency.put(denomination, currency.getOrDefault(denomination, 0) + quantity);
        System.out.println("Currency added successfully.");
    }

    public static void printCurrency() {
        System.out.println("\nAvailable currency inside machine:");

        for(int denomination : denominations) {
            System.out.println("Rs." + denomination + " : " +
                    currency.getOrDefault(denomination, 0));
        }
    }

    public static void printTransactions() {
        if(transactions.isEmpty()) {
            System.out.println("No transactions till now.");
            return;
        }

        for(Transaction transaction : transactions)
            System.out.println(transaction);
    }

    public static void buyItems() throws SoldOutException,
            InsufficientQuantityException, NoSufficientFundException,
            InsufficientChangeException {

        if(items.isEmpty()) {
            System.out.println("There are no products in vending machine.");
            return;
        }

        printProducts();

        System.out.println("Enter the number of different products you want to select:");
        int n = sc.nextInt();

        if(n <= 0) {
            System.out.println("Select at least one product.");
            return;
        }

        if(n > items.size()) {
            System.out.println("There are only " + items.size() + " products in vending machine.");
            return;
        }

        HashMap<Integer,Integer> cart = new HashMap<>();

        for(int i = 0; i < n; i++) {
            System.out.println("Enter product id (enter -1 to cancel):");
            int id = sc.nextInt();

            if(id == -1) {
                System.out.println("Selection cancelled.");
                return;
            }

            while(!items.containsKey(id)) {
                System.out.println("Product with id " + id + " does not exist. Enter valid id:");
                id = sc.nextInt();

                if(id == -1) {
                    System.out.println("Selection cancelled.");
                    return;
                }
            }

            Item item = items.get(id);

            if(item.getStock() == 0)
                throw new SoldOutException(item.getProductName() + " is sold out.");

            System.out.println("Enter quantity:");
            int quantity = sc.nextInt();

            if(quantity <= 0) {
                System.out.println("Quantity should be greater than 0.");
                i--;
                continue;
            }

            int alreadySelected = cart.getOrDefault(id, 0);
            if(alreadySelected + quantity > item.getStock()) {
                throw new InsufficientQuantityException(
                        "Insufficient quantity. Available stock of " +
                        item.getProductName() + " = " + (item.getStock() - alreadySelected));
            }

            cart.put(id, alreadySelected + quantity);
        }

        long total = 0;

        System.out.println("\nYour selected items:");
        for(Map.Entry<Integer,Integer> e : cart.entrySet()) {
            Item item = items.get(e.getKey());
            int quantity = e.getValue();

            System.out.println(item.getProductName() + " x " + quantity +
                    " = Rs." + ((long) quantity * item.getPrice()));

            total += (long) quantity * item.getPrice();
        }

        System.out.println("Total amount = Rs." + total);
        System.out.println("1.Continue to payment\n2.Cancel transaction");
        int confirm = sc.nextInt();

        if(confirm != 1) {
            System.out.println("Transaction cancelled. No items dispensed.");
            return;
        }

        System.out.println("""
                Select payment method:
                1.Cash (coins/notes)
                2.Card
                3.UPI
                4.Cancel transaction""");

        int paymentChoice = sc.nextInt();
        String paymentMode;

        if(paymentChoice == 1) {
            paymentMode = "Cash";
            processCashPayment(total);
        }
        else if(paymentChoice == 2) {
            paymentMode = "Card";
            System.out.println("Card payment successful.");
        }
        else if(paymentChoice == 3) {
            paymentMode = "UPI";
            System.out.println("UPI payment successful.");
        }
        else {
            System.out.println("Transaction cancelled. No items dispensed.");
            return;
        }

        // Stock is reduced only after payment is completed successfully.
        for(Map.Entry<Integer,Integer> e : cart.entrySet()) {
            Item item = items.get(e.getKey());
            item.setStock(item.getStock() - e.getValue());
        }

        Transaction transaction = new Transaction(cart, total, paymentMode);
        transactions.add(transaction);

        System.out.println("\nPayment successful.");
        System.out.println("Please collect your items.");
        System.out.println("Total paid = Rs." + total);
    }

    public static void processCashPayment(long total) throws NoSufficientFundException,
            InsufficientChangeException {

        HashMap<Integer,Integer> insertedCash = new HashMap<>();
        long amountReceived = 0;

        System.out.println("\nInsert coins/notes one by one.");
        System.out.println("Enter 0 to finish payment or -1 to cancel.");

        while(true) {
            System.out.println("Enter denomination:");
            int denomination = sc.nextInt();

            if(denomination == -1) {
                System.out.println("Payment cancelled. Your inserted cash is returned.");
                throw new NoSufficientFundException("Customer cancelled cash payment.");
            }

            if(denomination == 0)
                break;

            boolean valid = false;
            for(int d : denominations) {
                if(d == denomination) {
                    valid = true;
                    break;
                }
            }

            if(!valid) {
                System.out.println("Invalid denomination. Try again.");
                continue;
            }

            insertedCash.put(denomination,
                    insertedCash.getOrDefault(denomination, 0) + 1);
            amountReceived += denomination;

            System.out.println("Amount received = Rs." + amountReceived);
            System.out.println("Amount remaining = Rs." +
                    Math.max(0, total - amountReceived));
        }

        if(amountReceived < total) {
            throw new NoSufficientFundException(
                    "No sufficient funds. Required = Rs." + total +
                    ", received = Rs." + amountReceived +
                    ". Your inserted cash is returned.");
        }

        long changeAmount = amountReceived - total;

        // Create a temporary currency map to check change before updating machine cash.
        HashMap<Integer,Integer> availableCurrency = new HashMap<>(currency);

        for(Map.Entry<Integer,Integer> e : insertedCash.entrySet()) {
            availableCurrency.put(e.getKey(),
                    availableCurrency.getOrDefault(e.getKey(), 0) + e.getValue());
        }

        HashMap<Integer,Integer> change = calculateChange(changeAmount, availableCurrency);

        if(change == null) {
            throw new InsufficientChangeException(
                    "Insufficient change available. Your inserted cash is returned. " +
                    "Please try another payment method.");
        }

        // Update machine currency only after confirming that exact change is available.
        currency.clear();

        for(int denomination : denominations) {
            int available = availableCurrency.getOrDefault(denomination, 0);
            int returned = change.getOrDefault(denomination, 0);
            currency.put(denomination, available - returned);
        }

        System.out.println("Cash payment successful.");
        if(changeAmount > 0) {
            System.out.println("Please collect your change:");
            for(int denomination : denominations) {
                int quantity = change.getOrDefault(denomination, 0);
                if(quantity > 0)
                    System.out.println("Rs." + denomination + " x " + quantity);
            }
            System.out.println("Total change = Rs." + changeAmount);
        }
        else {
            System.out.println("No change to return.");
        }
    }

    public static HashMap<Integer,Integer> calculateChange(
            long changeAmount, HashMap<Integer,Integer> availableCurrency) {

        HashMap<Integer,Integer> change = new HashMap<>();
        long remaining = changeAmount;

        for(int denomination : denominations) {
            int available = availableCurrency.getOrDefault(denomination, 0);
            int required = (int) Math.min(available, remaining / denomination);

            if(required > 0) {
                change.put(denomination, required);
                remaining -= (long) required * denomination;
            }
        }

        if(remaining != 0)
            return null;

        return change;
    }
}