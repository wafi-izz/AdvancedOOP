package default_methods_override;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //create 4 new SmartphonePrice objects: 2 for Producer and 2 for Retail
        SmartphonePrice Producer1 = new SmartphonePrice("Producer",1200);
        SmartphonePrice Producer2 = new SmartphonePrice("Producer",1100);
        SmartphonePrice retail1 = new SmartphonePrice("retail",1300);
        SmartphonePrice retail2 = new SmartphonePrice("retail",1400);

        //create 2 new Smartphone objects, using the 4 newly created SmartphonePrice objects
        Smartphone phone1 = new Smartphone("iphone","iphone 15",5000,Producer1,retail1);
        Smartphone phone2 = new Smartphone("galaxy","s22 ultra",5300,Producer2,retail2);

        //print in console all the details of the 2 newly created Smartphone objects
        System.out.println(phone1);
        System.out.println(phone2);

        //check if the first smartphone is equal to the second smartphone, informing the user
        System.out.println(phone1.equals(phone2)?"yes the two phones are equal":"no the phones are equal");

        //use a try{ ... } catch(Exception exception) { ... } to:
        try {
            //get a new Smartphone object by cloning the second Smartphone
            Smartphone phone3 = phone2.clone();

            //print in console all the details of the newly cloned object
            System.out.println(phone3);

            //check if the second smartphone is equal to the newly cloned object, informing the user
            System.out.println(phone2.equals(phone3)?"yes the two phones are equal":"no the phones are equal");
        }
        //inside the catch(Exception exception) { ... } scope:
        catch (Exception e) {
            //print the stack trace of the exception
            e.printStackTrace();

            //inform the user about the error
            System.out.println("An error occurred during cloning. " + e.getMessage());
        }
    }
}

class Smartphone implements Cloneable {
    String brandName;
    String modelName;
    int batterymAH;
    SmartphonePrice producerPrice;
    SmartphonePrice retailPrice;
    public Smartphone(String brand, String model, int battery, SmartphonePrice prodP, SmartphonePrice retailP) {
        this.brandName = brand;
        this.modelName = model;
        this.batterymAH = battery;
        this.producerPrice = prodP;
        this.retailPrice = retailP;
    }
    @Override
    public String toString() {
        return "SmartPhone [brandName=" + brandName + ", modelName=" + modelName + ", batterymAH=" + batterymAH + ", producer Price=" + producerPrice + ", retail Price=" + retailPrice + "]";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone smartPhone = (Smartphone) o;
        return brandName.equals(smartPhone.brandName) && modelName.equals(smartPhone.modelName) && batterymAH == smartPhone.batterymAH && producerPrice.equals(smartPhone.producerPrice) && retailPrice.equals(smartPhone.retailPrice);
    }
    @Override
    public int hashCode() {
        int result = brandName.hashCode();
        result = 31 * result + modelName.hashCode();
        result = 31 * result + batterymAH;
        result = 31 * result + producerPrice.hashCode();
        result = 31 * result + retailPrice.hashCode();
        return result;
    }

    @Override
    public Smartphone clone() throws CloneNotSupportedException {
        Smartphone clonedSmartphone = (Smartphone) super.clone();
        clonedSmartphone.producerPrice = producerPrice.clone();
        clonedSmartphone.retailPrice = retailPrice.clone();
        return clonedSmartphone;
    }
}
class SmartphonePrice implements Cloneable {
    String priceType;
    double priceInEuros;
    public SmartphonePrice(String type, double price) {
        this.priceType = type;
        this.priceInEuros = price;
    }
    @Override
    public String toString() {
        return "[price type: " + priceType + ", price in Euros: " + priceInEuros + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartphonePrice price = (SmartphonePrice) o;
        return priceType.equals(price.priceType) && priceInEuros == price.priceInEuros;
    }

    @Override
    public int hashCode() {
        int result;
        result = priceType.hashCode();
        result = 31 * result + Double.hashCode(priceInEuros);
        return result;
    }

    @Override
    public SmartphonePrice clone() throws CloneNotSupportedException {
        return (SmartphonePrice) super.clone();
    }
}

/**
 * Define a Smartphone class that implements Cloneable and has:
 *
 * 5 attributes:
 * a string brandName
 * a string modelName
 * an int batterymAh
 * an attribute producerPrice of type SmartphonePrice
 * an attribute retailPrice of type SmartphonePrice
 * [using IntelliJ] an override of the toString() method in order to print all the attributes of a Smartphone object
 * [using IntelliJ] an override of the equals() method that check all the 5 attributes to establish if two Smartphone objects are equal
 * [using IntelliJ] an override of the hashCode(), using all the 5 attributes
 * [using IntelliJ] an override of the clone() method (that will have to be public) where:
 * a clonedSmartphone is generated using super.clone()
 * there's an assignment to the clonedSmartphone.producerPrice
 * there's an assignment to the clonedSmartphone.retailPrice
 * the return value is a Smartphone object
 * a constructor method that accepts 5 params (brand, model, battery, prodP, retailP) and assign the right values to the object
 * define a SmartphonePrice class that implements Cloneable and has:
 * 2 attributes:
 * a string priceType
 * a double priceInEuros
 * [using IntelliJ] an override of the clone() method (that will have to be public) where:
 * a clonedSmartphonePrice is generated using super.clone()
 * the return value is a SmartphonePrice object
 * [using IntelliJ] an override of the toString() method for returning an informative String about the 2 SmartphonePrice attributes
 * [using IntelliJ] an override of the equals() method that check the 2 attributes to establish if two SmartphonePrice objects are equal
 * [using IntelliJ] an override of the hashCode(), using the 2 attributes
 * a constructor method that accepts 2 params (type, price) and assign the right values to the object
 * define a tester class with main() method where you:
 * create 4 new SmartphonePrice objects: 2 for Producer and 2 for Retail
 * create 2 new Smartphone objects, using the 4 newly created SmartphonePrice objects
 * print in console all the details of the 2 newly created Smartphone objects
 * check if the first smartphone is equal to the second smartphone, informing the user
 * use a try{ ... } catch(Exception exception) { ... } to:
 * get a new Smartphone object by cloning the second Smartphone
 * print in console all the details of the newly cloned object
 * check if the second smartphone is equal to the newly cloned object, informing the user
 * inside the catch(Exception exception) { ... } scope:
 * print the stack trace of the exception
 * inform the user about the error
 * */
