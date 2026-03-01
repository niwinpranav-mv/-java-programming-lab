package Practical;
import java.util.Random;

class NumberGenerator extends Thread {
    Random rand = new Random();
    int number;
    volatile boolean running = true; 

    @Override
    public void run() {
        while (running) {
            number = rand.nextInt(100); 
            System.out.println("\n[Generator] Number Generated: " + number);

            if (number % 2 == 0) {
                new EvenThread(number).start(); 
            } else {
                new OddThread(number).start();
            }

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Generation Stopped");
                running = false; 
                Thread.currentThread().interrupt(); 
            }
        }
    }
}

class EvenThread extends Thread {
    int num;
    
    EvenThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("[EvenThread] Square of " + num + " = " + (num * num));
    }
}

class OddThread extends Thread {
    int num;

    OddThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("[OddThread] Cube of " + num + " = " + (num * num * num));
    }
}


public class Multithreading {
    public static void main(String[] args) {
        System.out.println("--- Starting Number Generation Demo ---");
        
        NumberGenerator generator = new NumberGenerator();
        generator.start(); 
        
        try {
             System.out.println("[Main] Running for 10 seconds...");
             Thread.sleep(10000); 
        } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
        }

        generator.running = false;
        System.out.println("\n--- Generator Stopped. Main Program Exiting. ---");
    }
}