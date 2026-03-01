package Practical;

public class rectangle extends shape {
    public rectangle(int width,int height){super(width,height);}
    @Override
    public void printArea(){
        System.out.println("Rectangle area="+(a*b));
    }
    
}
