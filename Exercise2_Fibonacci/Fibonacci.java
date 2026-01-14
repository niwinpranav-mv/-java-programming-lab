package Practical;
import java.util.Scanner;

public class Fibonacci {
    static void printFibonacci(int n) {
        if(n<=0){
            System.out.println("ntg to print");

        }
        long a=0,b=1;
        System.out.println("Fibonacci:");
        for (int i = 0; i<n;i++){
            System.out.print(a + (i==n-1?"\n":","));
            long next = a + b;
            a=b;
            b=next;

        }


    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("how many fibonacci num?:");
        int n = sc.nextInt();
        printFibonacci(n);
        System.out.print("enter an integer to test even or odd:");
        int x=sc.nextInt();
        System.out.println(x+(x%2==0? "is even":"is odd"));
        sc.close();
    }

    
}
