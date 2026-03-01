package Practical;

public class Inheritence {
    public static void main (String[] args){
        animal generic = new animal("Gneric");

    
    generic.speak();
    dog d = new dog("Buddy", "Alice");
    d.speak();
    d.info();
    d.wagTail();
    animal petAsanimal = new dog("Rex", "Bob");
    petAsanimal.speak();
    

    if (petAsanimal instanceof pet){
        ((pet)petAsanimal).play();
    }
}

}
