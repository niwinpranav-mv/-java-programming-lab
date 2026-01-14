package Practical;



public class exp1 {
    public static void main(String[] args) {
        
        int a = 10;
        double b =3.0;
        char letter ='A';
        boolean isJavaFun= true;

        //arithmetic and casting 
        int sum = a + (int) b;
        double division = a / b;
        int remainder = a % 3;
        String msg="value of a:"+ a +",b:"+b;
        System.out.println(msg);
        System.out.println("sum ="+sum);
        System.out.println("division ="+division);
        System.out.println("remainder ="+remainder);
        System.out.println("letter ="+ letter + ", isJavaFun="+ isJavaFun);
    }
}
