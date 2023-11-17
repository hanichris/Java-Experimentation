import com.examples.bicycle.ACMEBicycle;
import com.examples.bicycle.MountainBike;

class BicycleDemo {

    public static void main(String[] args) {
        ACMEBicycle bike1 = new ACMEBicycle(0, 1, 0);
        MountainBike bike2 = new MountainBike(5, 0, 1, 0);
        ACMEBicycle bike3 = new ACMEBicycle();
        
        bike1.changeCadence(50);
        bike1.speedUp(10);
        bike1.changeGear(2);
        bike1.printStatus();

        bike2.changeCadence(50);
        bike2.speedUp(10);
        bike2.changeGear(2);
        bike2.changeCadence(40);
        bike2.speedUp(10);
        bike2.changeGear(3);
        bike2.setSeatHeight(10);
        System.out.println(bike2.getSeatHeight());
        bike2.printStatus();

        bike3.printStatus();
    }
}