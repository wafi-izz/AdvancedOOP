package abstraction_override;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car(4,4,30000.00);
        Vehicle boat = new Boat(152.00,600);
        System.out.println(car.showVehicleDetails());
        car.doVehicleSound();
        System.out.println(((Boat) boat).getBoatWeightAndSpeed());
        boat.doVehicleSound();
    }
}

abstract class Vehicle {
    String type;
    int numOfWheels;
    public String showVehicleDetails() {
        return "vehicle type: " + type + ", num of wheels: " + numOfWheels;
    }
    public abstract void doVehicleSound();
}
class Car extends Vehicle {
    int numOfDoors;
    double carPrice;
    public Car(int wheels, int doors, double price) {
        this.type = "car";
        this.numOfWheels = wheels;
        this.numOfDoors = doors;
        this.carPrice = price;
    }
    @Override
    public String showVehicleDetails() {
        return super.showVehicleDetails() + ", number of Door: " + numOfDoors + ", price: " + carPrice;
    }
    @Override
    public void doVehicleSound() {
        System.out.println("car sound is vroom-vroom");
    }
}
class Boat extends Vehicle {
    double maxKnotsSpeed;
    int boatKilosWeight;
    public Boat(double maxSpeed, int weight) {
        this.type = "boat";
        this.maxKnotsSpeed = maxSpeed;
        this.boatKilosWeight = weight;
    }
    public String getBoatWeightAndSpeed() {
        return "boat weight in kilos: " + boatKilosWeight + ", max knot speed: " + maxKnotsSpeed;
    }
    @Override
    public void doVehicleSound() {
        System.out.println("boat sound is booooom");
    }
}



/**
 * Define an abstract class called Vehicle that has:
 *
 * a string attribute type
 * an int attribute numberOfWheels
 * a method showVehicleDetails() that prints in console an informative message about the type and the numberOfWheels
 * an abstract method doVehicleSound()
 * define a subclass Car of Vehicle that has:
 * an int attribute numberOfDoors
 * a double attribute carPrice
 * an override of the superclass method showVehicleDetails() that:
 * recalls the super method showVehicleDetails()
 * prints in console an informative message about the car's numberOfDoors
 * a mandatory override of the abstract method doVehicleSound() where you print the car's sound
 * a constructor method that:
 * accepts 3 params (wheels, doors, price)
 * assign the correct values to type, numberOfWheels, numberOfDoors and carPrice
 *
 * define a subclass Boat of Vehicle that has:
 * a double attribute maxKnotsSpeed
 * an int attribute boatKilosWeight
 * a mandatory override of the abstract method doVehicleSound() where you print the boat's sound
 * a constructor method that:
 * accepts 2 params (maxSpeed, weight)
 * assign the correct values to type, maxKnotsSpeed and boatKilosWeight
 *
 * a method getBoatWeightAndSpeed that returns an informative String about the total kilos weight and the maximum knots speed
 * define a tester class where you:
 * create a Car object and a Boat object
 * invoke the two Vehicle methods for the newly created Car and Boat objects
 * print in console the Boat weight and speed using the dedicated method.
 * */