package Practical;
import java.util.Scanner;

public class control {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("enter an integer:");
        int n =sc.nextInt();
        //if-else
        if (n<0) {
            System.out.println("negative");
            
        }
        else if(n==0){
              System.out.println("zero");

        }
        else{
              System.out.println("positive");
        }
        if (n%2==0) {
              System.out.println("even");
            
        }
        else{
              System.out.println("odd");
        }
        int day = n % 7 + 1;
        switch (day) {
            case 1:
              System.out.println("Monday");
            case 2:
             System.out.println("tuesday");

            case 3:
             System.out.println("wednesday");

            case 4:
             System.out.println("thursday");

            case 5:
             System.out.println("friday");

            case 6:
             System.out.println("Saturday");
            
            

            
        
            default:
             System.out.println("sunday");
                
        }
        sc.close();

    }
    
}
