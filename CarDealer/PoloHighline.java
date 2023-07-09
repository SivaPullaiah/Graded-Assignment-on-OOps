public class PoloHighline extends Car {
    private static final double RTO_PRICE = 113990;
    private static final double INSURANCE_PRICE = 47300;
    private static final double TCS_PRICE = 11000;

    public PoloHighline() {
        super("Polo Highline", 1009000);
    }

    @Override
    public double calculateTotalCost(boolean insurance, boolean additionalAccessories, double discount) {
        double totalCost = getShowroomPrice() + RTO_PRICE + TCS_PRICE;

        if (insurance)
            totalCost += INSURANCE_PRICE;

        if (additionalAccessories)
            totalCost += 15000;

        if (discount > 0) {
            if ((insurance || additionalAccessories) && discount <= 30000) {
                totalCost -= discount;
            } else {
                System.out.println("Error: Maximum discount cannot exceed 30,000, or additional features are required.");
                totalCost += 0;
            }
        }

        return totalCost;
    }
}
