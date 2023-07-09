public abstract class Car {
    private String model;
    private double showroomPrice;

    public Car(String model, double showroomPrice) {
        this.model = model;
        this.showroomPrice = showroomPrice;
    }

    public String getModel() {
        return model;
    }

    public double getShowroomPrice() {
        return showroomPrice;
    }

    public abstract double calculateTotalCost(boolean insurance, boolean additionalAccessories, double discount);
}
