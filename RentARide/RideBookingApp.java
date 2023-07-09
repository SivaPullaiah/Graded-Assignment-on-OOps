public class RideBookingApp {
    public static void main(String[] args) {
        // Create the drivers
        Driver driverA = new Driver("A", "Sedan", 4.0, 500);
        Driver driverB = new Driver("B", "Hatchback", 4.3, 1000);
        Driver driverC = new Driver("C", "5-Seater", 4.8, 200);
        Driver driverD = new Driver("D", "Sedan", 4.1, 700);
        Driver driverE = new Driver("E", "Hatchback", 4.7, 430);

        // Create the ride booking system
        RideBookingSystem bookingSystem = new RideBookingSystem();

        // Add the drivers to the booking system
        bookingSystem.addDriver(driverA);
        bookingSystem.addDriver(driverB);
        bookingSystem.addDriver(driverC);
        bookingSystem.addDriver(driverD);
        bookingSystem.addDriver(driverE);

        // Example 1: Book a ride with requested car model "Sedan" and ride distance of 43 km
        double distance1 = 43.0;
        String carModel1 = "Sedan";
        Driver selectedDriver1 = bookingSystem.bookRide(distance1, carModel1);

        if (selectedDriver1 != null) {
            System.out.println("Driver " + selectedDriver1.getName() + " will get you to the destination.");
            double charge1 = distance1 * 8.0;
            System.out.println("Your charge will be Rs " + charge1);
        } else {
            System.out.println("No available drivers for the requested car model.");
        }

        // Example 2: Book a ride with requested car model "Hatchback" and ride distance of 20.5 km
        double distance2 = 20.5;
        String carModel2 = "Hatchback";
        Driver selectedDriver2 = bookingSystem.bookRide(distance2, carModel2);

        if (selectedDriver2 != null) {
            System.out.println("Driver " + selectedDriver2.getName() + " will get you to the destination.");
            double charge2 = distance2 * 8.0;
            System.out.println("Your charge will be Rs " + charge2);
        } else {
            System.out.println("No available drivers for the requested car model.");
        }
    }
}
