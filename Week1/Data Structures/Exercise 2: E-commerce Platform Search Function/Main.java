import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String toString() {
        return String.format("%04d - %-20s (%s)", productId, productName, category);
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcomeMessage();
        
        Product[] products = getProductsFromUser();
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
        
        performSearchOperations(products);
        
        displayExitMessage();
    }

    private static void displayWelcomeMessage() {
        System.out.println("====================================");
        System.out.println("   PRODUCT SEARCH APPLICATION");
        System.out.println("====================================");
        System.out.println();
    }

    private static Product[] getProductsFromUser() {
        System.out.print("Enter number of products: ");
        int n = getPositiveInteger();
        
        Product[] products = new Product[n];
        System.out.println("\nEnter product details:");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct #" + (i + 1));
            products[i] = createProduct();
        }
        
        return products;
    }

    private static Product createProduct() {
        int id = getValidProductId();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter Category: ");
        String category = scanner.nextLine().trim();
        
        return new Product(id, name, category);
    }

    private static int getValidProductId() {
        while (true) {
            try {
                System.out.print("Enter Product ID (4-digit number): ");
                int id = scanner.nextInt();
                if (id >= 1000 && id <= 9999) {
                    return id;
                }
                System.out.println("Error: ID must be a 4-digit number. Please try again.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static int getPositiveInteger() {
        while (true) {
            try {
                int n = scanner.nextInt();
                if (n > 0) {
                    return n;
                }
                System.out.print("Please enter a positive number: ");
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void performSearchOperations(Product[] products) {
        while (true) {
            displaySearchMenu();
            int choice = getMenuChoice();
            
            if (choice == 3) break;
            
            System.out.print("\nEnter Product ID to search: ");
            int searchId = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    performLinearSearch(products, searchId);
                    break;
                case 2:
                    performBinarySearch(products, searchId);
                    break;
            }
            
            System.out.println();
        }
    }

    private static void displaySearchMenu() {
        System.out.println("\nSEARCH OPTIONS:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getMenuChoice() {
        while (true) {
            try {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    return choice;
                }
                System.out.print("Please enter 1, 2, or 3: ");
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter 1, 2, or 3: ");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void performLinearSearch(Product[] products, int searchId) {
        System.out.println("\n=== LINEAR SEARCH ===");
        Product result = linearSearch(products, searchId);
        displaySearchResult(result);
    }

    private static void performBinarySearch(Product[] products, int searchId) {
        System.out.println("\n=== BINARY SEARCH ===");
        Product result = binarySearch(products, searchId);
        displaySearchResult(result);
    }

    private static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.getProductId() == targetId) {
                return p;
            }
        }
        return null;
    }

    private static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == targetId) {
                return products[mid];
            } else if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    private static void displaySearchResult(Product product) {
        if (product != null) {
            System.out.println("Product found:");
            System.out.println(product);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    private static void displayExitMessage() {
        System.out.println("\nThank you for using the Product Search Application!");
        System.out.println("====================================");
    }
}
