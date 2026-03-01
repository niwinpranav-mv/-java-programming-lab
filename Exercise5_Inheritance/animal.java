package Practical;

public class animal {
   
    protected String name;
    
    
    public animal(String name){
        this.name = name;
    }
    
  
    public void speak() {
        System.out.println(name + " makes a sound.");
    }
    
    public void info(){
        System.out.println("This is an animal named " + name);
    }
}
