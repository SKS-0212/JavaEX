package University.Java_Using_Project.Experiment6;

import java.util.*;
import java.util.Scanner;

class Operations {

    private final List<String> list = new ArrayList<>();

    void insert(String str) {
        list.add(str);
        System.out.println("Inserted successfully");
    }

    boolean search(String str) {
        for (String s : list) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }

    String delete(String str) {
        for (String s : list) {
            if (s.equals(str)) {
                list.remove(str);
                return "Item Deleted";
            }
        }
        return "Item dose not exist";
    }

    void display() {
        for (String s : list) {
            System.out.println(s);
        }
    }


    void start(Scanner in) {
        while (true) {
            System.out.println("\nEnter 1 for Insert");
            System.out.println("Enter 2 for Search");
            System.out.println("Enter 3 for Delete");
            System.out.println("Enter 4 for Display");
            System.out.println("Enter 5 for Exit\n");

            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1: {
                    System.out.print("Enter the item to be inserted: ");
                    String str = in.nextLine();
                    insert(str);
                }
                break;
                case 2: {
                    System.out.print("Enter the item to be searched: ");
                    String str = in.nextLine();
                    boolean result = search(str);
                    if (result) {
                        System.out.println("Item found in the list");
                    } else {
                        System.out.println("Item not found in the list");
                    }
                }
                break;
                case 3: {
                    System.out.print("Enter the item to be deleted: ");
                    String str = in.nextLine();
                    System.out.println(delete(str));
                }
                break;
                case 4: {
                    System.out.println("The items in the list are:");
                    display();
                }
                break;
                case 5: {
                    System.out.println("Exiting....");
                    System.exit(0);
                }
                default:
                    System.out.println("Wrong Choice");
            }
        }
    }
}


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Operations operations = new Operations();
        operations.start(in);
        in.close();
    }
}
