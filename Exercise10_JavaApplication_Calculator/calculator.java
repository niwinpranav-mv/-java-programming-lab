package Practical;

import java.util.Scanner;

public class calculator {
    static void printMenu() {
        System.out.println("\n=== Calculator ===");
        System.out.println("1) Add");
        System.out.println("2) Subtract");
        System.out.println("3) Multiply");
        System.out.println("4) Divide");
        System.out.println("5) Power (a^b)");
        System.out.println("6) Modulo (a % b)");
        System.out.println("7) Square root");
        System.out.println("0) Exit");
        System.out.print("Choose option: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {

            printMenu();
            if (!sc.hasNextInt()) { // Added check to prevent crash on non-integer input
                sc.next(); 
                continue;
            }
            int choice = sc.nextInt();
            double a, b;

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble(); 
                    b = sc.nextDouble();
                    System.out.println("Result = " + (a + b));
                    break;
                case 2:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble(); 
                    b = sc.nextDouble();
                    System.out.println("Result = " + (a - b));
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
        System.out.println("Calculator closed.");
    }
}
