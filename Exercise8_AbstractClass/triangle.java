package Practical;

public class triangle extends shape {
    public triangle(int base,int height){super(base,height);}
    @Override
    public void printArea(){
        double area=0.5*a*b;
        System.out.println("triangle area="+area);
    }
    
}
