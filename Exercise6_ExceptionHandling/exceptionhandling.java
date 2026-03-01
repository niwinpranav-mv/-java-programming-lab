package Practical;
import java.io.*;

class MyCheckedexception extends Exception {
    MyCheckedexception(String msg) {
        super(msg);
    }
}

public class exceptionhandling {
    static void mayThrowChecked(boolean throwlt) throws MyCheckedexception {
        if (throwlt) {
            throw new MyCheckedexception("Checked exception thrown!");
        }
    }

    static int divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        
        try {
            System.out.println("divide 10 by 2=>" + divide(10, 2));
            System.out.println("divide 10 by 0=>(next)");
            System.out.println("Result=>" + divide(10, 0));
        } catch (ArithmeticException re) {
            System.out.println("Other runtime exception:" + re);
        } finally {
            System.out.println("Finally always run");
        }

    
        try {
            mayThrowChecked(true);
        } catch (MyCheckedexception e) {
            System.out.println("caught custom checked exception :" + e.getMessage());
        }

      
        try (BufferedReader br = new BufferedReader(new StringReader("line1\nline2"))) {
            System.out.println("First line:" + br.readLine());
        } catch (IOException ioe) {
            System.out.println("IO error:" + ioe.getMessage());
        }

        System.out.println("Program Finished.");
    }
}