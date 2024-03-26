import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem {
    static class Item {
        String name;
        String itemName;
        int quantity;
        boolean inStock;
        double itemWeight;
        String colorType;
        ArrayList<String> Items = new ArrayList<>();

        public Item(String name, String itemName, int quantity,
                    boolean inStock, double itemWeight, String colorType) {
            this.name = name;
            this.itemName = itemName;
            this.quantity = quantity;
            this.inStock = inStock;
            this.itemWeight = itemWeight;
            this.colorType = colorType;
        }

        public void displayItems() {
            System.out.println("Thanks for the info: " + name);
            System.out.println("You added the item: " + itemName);
            if (quantity > 50) {
                System.out.println("Your item is quite heavy\nWith a weight of: " + itemWeight);
            } else {
                System.out.println("Your item is quite light\nWith a weight of: " + itemWeight);
            }

            if (inStock) {
                System.out.println("Your item is in stock");
            } else {
                System.out.println("Your item is not in stock");
            }

            System.out.println("Your color choice was: " + colorType);
        }
        public void add(String item){
            Items. add(item);
        }
        public void display(){
            for(String i:Items){
                System.out.println("Here are your items");
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> itemList = new ArrayList<>();
        String name = null;

        while (true) {
            try {
                System.out.println("Would you like to create a new item? (Yes/No)");
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("yes")) {
                    if (name == null) {
                        System.out.println("What's your name?");
                        name = scanner.nextLine();
                    }

                    System.out.println("What item would you like to add?");
                    String itemName = scanner.nextLine();

                    System.out.println("How many units would you like to add?");
                    int quantity = scanner.nextInt();

                    boolean inStock = quantity > 0;

                    System.out.println("How much does a single unit weigh?");
                    double weight = scanner.nextDouble();

                    System.out.println("What type of color is it?");
                    System.out.println("1. Blue");
                    System.out.println("2. Green");
                    System.out.println("3. Red");
                    System.out.println("4. Yellow");
                    System.out.println("5. Black");
                    System.out.println("6. Other");
                    int colorType = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    String userColor;
                    switch (colorType) {
                        case 1:
                            userColor = "Blue";
                            break;
                        case 2:
                            userColor = "Green";
                            break;
                        case 3:
                            userColor = "Red";
                            break;
                        case 4:
                            userColor = "Yellow";
                            break;
                        case 5:
                            userColor = "Black";
                            break;
                        case 6:
                            System.out.println("Please enter that color");
                            userColor = scanner.nextLine();
                            break;
                        default:
                            System.out.println("Invalid color choice, setting to 'Not Provided'");
                            userColor = "Not Provided";
                            break;
                    }

                    Item newItem = new Item(name, itemName, quantity, inStock, weight, userColor);
                    itemList.add(newItem);
                    newItem.displayItems();
                    newItem.add(itemName);
                    newItem.display();
                } else if (answer.equalsIgnoreCase("no")) {
                    System.out.println("Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
