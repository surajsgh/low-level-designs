/*
* S: Single Responsibility Principle (Every class should have only one reason to change)
* O: Open for extension, Closed for modification (Use an interface and override its function for other classes.)
* L: Liskov substitution principle (We should be able to replace the object of parent with child without breaking the current flow.)
* I: Interface segment principle (The interface should be such that client shouldn't implement unnecessary functions they do not need.)
* D: Dependency inversion principle (Class should depend on interfaces rather than concrete classes.)
*
* The advantages of SOLID principle
* 1. Easy to maintain
* 2. Avoid duplication of code
* 3. Easy to understand
* 4. Flexible software
* 5. Reduce complexity
* */

import java.util.ArrayList;

class Marker {
    private String name;
    private String color;
    private int year;
    private int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}

class Invoice {
    private Marker marker;
    protected int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        return marker.getPrice() * this.quantity;
    }

    /* Introducing this two methods would cause multiple reasons to change the class.
    So as per Single Responsibility we'll create two separate class for this.
     */
    public void printInvoice() {

    }

    public void saveToDb() {

    }
}

/*
class InvoiceDao {
    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDb() {

    }

    //  Now, if there's another requirement to write another helper function that saves the records
    //  to the disk, then instead of writing it here(because that would fail Single responsibility
    //  principle. the file should open for extension but closed for modification), we'll introduce
    //  another interface and use its save method.
}
*/

interface InvoiceDao {
    public void save();
}

class InvoiceDaoDB implements InvoiceDao{
    @Override
    public void save() {

    }
}

class InvoiceDaoDisk implements InvoiceDao{
    @Override
    public void save() {

    }
}

class InvoicePrinter {
    Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {

    }
}

interface RestaurantEmployee {
    //  We should create separate interfaces for their specific use-cases.
    void washDishes();
    void serveCustomers();
}

interface Cleaner {
    void washDishes();
}

interface Waiter {
    void serveCustomer();
}

class RestaurantCleaner implements Cleaner {
    @Override
    public void washDishes() {

    }
}

class RestaurantWaiter implements Waiter {
    @Override
    public void serveCustomer() {

    }
}

//  Liskov Substitution principle
class Vehicle {
    public int getWheels() {
        return 2;
    }
}

class EngineVehicle extends Vehicle {
    public boolean hasEngine() {
        return true;
    }
}

class Bicycle extends Vehicle {

}

class Car extends EngineVehicle {
    @Override
    public int getWheels() {
        return 4;
    }
}

class Bike extends EngineVehicle {

}

public class Main {
    public static void main(String[] args) {
        ArrayList<EngineVehicle> list = new ArrayList<>();
//        list.add(new Bicycle());
        list.add(new Car());
        list.add(new Bike());

        for (EngineVehicle vehicle: list) {
            System.out.println(vehicle.hasEngine());
        }
    }
}