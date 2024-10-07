package inheritance_polymorphism;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("animal");
        Animal lion = new Lion();
        Animal cow = new Cow();
        animal.animalSound();
        lion.animalSound();
        cow.animalSound();
    }
}

class Animal {
    private String animalName;
    public Animal(String animalName) {
        this.animalName = animalName;
    }
    public void animalSound() {
        System.out.println("default animal sound");
    }
}
class Lion extends Animal {
    public Lion() {
        super("Lion");
    }
    @Override
    public void animalSound() {
        System.out.println("Lion sound: roar");
    }
}

class Cow extends Animal {
    public Cow() {
        super("Cow");
    }
    @Override
    public void animalSound() {
        System.out.println("Cow sound: moo");
    }
}





/**
 * Define a class Animal that has:
 *
 * an instance variable animalName
 * a constructor that instantiate animalName
 * a method animalSound() that prints default animal sound Define a subclass Lion Define a subclass Cow
 * achieve polymorphism by using method overriding on animalSound(), printing the right sounds Define a tester class where you:
 * create an Animal object
 * create a Lion object
 * create a Cow object
 * executes the animalSound() method on all the 3 objects
 * */