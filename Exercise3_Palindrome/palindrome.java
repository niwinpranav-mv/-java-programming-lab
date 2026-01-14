package Practicals;
import java.util.Scanner;

public class palindrome {

    static long factorialIterative(int n) {
        if (n < 0) throw new IllegalArgumentException("negative not allowed");
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    static long factorialRecursive(int n) {
        if (n < 0) throw new IllegalArgumentException("negative not allowed");
        return (n <= 1) ? 1 : n * factorialRecursive(n - 1);
    }

    // check palindrome (case-insensitive)
    static boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int i = 0;
        int j = clean.length() - 1;

        while (i < j) {
            if (clean.charAt(i) != clean.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter a string to test palindrome:");
        String input = sc.nextLine();
        System.out.println("Is palindrome? " + isPalindrome(input));

        System.out.print("Enter a non-negative number to find factorial: ");
        int n = sc.nextInt();

        System.out.println("Iterative factorial of " + n + " = " + factorialIterative(n));
        System.out.println("Recursive factorial of " + n + " = " + factorialRecursive(n));

        sc.close();
    }
}
