package Practical;

public class dog extends animal implements pet {
    private String owner;
    
    
    public dog(String name, String owner){
        super(name); 
        this.owner = owner;
    }

    @Override
    public void speak() {
        System.out.println(name + " barks: woof!");
    }

    @Override
    public void play() {
        
        System.out.println(name + " plays fetch with " + owner + "."); 
    }

    @Override
    public String getOwnerName() {
        return owner;
    }
    
    
    public void wagTail() {
        System.out.println(name + " is wagging its tail.");
    }
}
