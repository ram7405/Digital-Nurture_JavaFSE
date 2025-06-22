import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Item {
    private String productId;
    private String productName;
    private int quantity;
    private double unitPrice;

    public Item(String productId, String productName, int quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }

    public void setProductName(String name) { this.productName = name; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setUnitPrice(double price) { this.unitPrice = price; }

    @Override
    public String toString() {
        return String.format("%s - %s | Qty: %d | Price: $%.2f", productId, productName, quantity, unitPrice);
    }
}

class WarehouseManager {
    private Map<String, Item> stockMap = new HashMap<>();

    public boolean addItem(Item item) {
        if (stockMap.containsKey(item.getProductId())) {
            System.out.println("Item already exists: " + item.getProductId());
            return false;
        }
        stockMap.put(item.getProductId(), item);
        System.out.println("Added: " + item);
        return true;
    }

    public boolean updateItem(String id, String name, int qty, double price) {
        Item item = stockMap.get(id);
        if (item == null) {
            System.out.println("Item not found: " + id);
            return false;
        }
        item.setProductName(name);
        item.setQuantity(qty);
        item.setUnitPrice(price);
        System.out.println("Updated: " + item);
        return true;
    }

    public boolean removeItem(String id) {
        Item removed = stockMap.remove(id);
        if (removed == null) {
            System.out.println("Item not found: " + id);
            return false;
        }
        System.out.println("Removed: " + removed);
        return true;
    }

    public Item findItem(String id) {
        Item item = stockMap.get(id);
        if (item == null) {
            System.out.println("Item not found: " + id);
        }
        return item;
    }

    public void printInventory() {
        if (stockMap.isEmpty()) {
            System.out.println("Inventory is currently empty.");
            return;
        }
        System.out.println("\n--- Inventory List ---");
        for (Item item : stockMap.values()) {
            System.out.println(item);
        }
        System.out.println("Total items: " + stockMap.size());
    }
}

public class Main {
    public static void main(String[] args) {
        WarehouseManager manager = new WarehouseManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n---- Inventory Menu ----");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Find Item");
            System.out.println("5. Show Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    manager.addItem(new Item(id, name, qty, price));
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    id = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    qty = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    price = scanner.nextDouble();
                    scanner.nextLine();
                    manager.updateItem(id, name, qty, price);
                    break;

                case 3:
                    System.out.print("Enter Product ID to remove: ");
                    id = scanner.nextLine();
                    manager.removeItem(id);
                    break;

                case 4:
                    System.out.print("Enter Product ID to find: ");
                    id = scanner.nextLine();
                    Item found = manager.findItem(id);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    }
                    break;

                case 5:
                    manager.printInventory();
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting Inventory Manager. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
