package Practical;

public class shapedemo {
    public static void main(String[] args){
        shape r = new rectangle(5, 3);
        shape t = new triangle(4, 5);
        shape c = new circle(3, 0);
        r.printArea();
        t.printArea();
        c.printArea();

    }
    
}
