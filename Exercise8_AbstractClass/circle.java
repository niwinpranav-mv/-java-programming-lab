package Practical;

public class circle extends shape {
    public circle(int radius,int ignored){super(radius,ignored);}
    @Override
    public void printArea(){
        double area= Math.PI*a*a;
        System.out.println("circle area="+area);
    }
    
}
