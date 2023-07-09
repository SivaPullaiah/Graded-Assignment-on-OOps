import java.util.ArrayList;
import java.util.List;

public class RideBookingSystem {
    private List<Driver> drivers;

    public RideBookingSystem() {
        drivers = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public Driver bookRide(double rideDistance, String requestedCarModel) {
        Driver selectedDriver = null;

        for (Driver driver : drivers) {
            if (driver.getRating() < 4.0) {
                continue; // Skip drivers with rating less than 4
            }

            if (!driver.getCarModel().equalsIgnoreCase(requestedCarModel)) {
                continue; // Skip drivers with different car models
            }

            if (selectedDriver == null || driver.getDistanceFromCustomer() < selectedDriver.getDistanceFromCustomer()) {
                selectedDriver = driver; // Update the selected driver if closer
            }
        }

        return selectedDriver;
    }
}
