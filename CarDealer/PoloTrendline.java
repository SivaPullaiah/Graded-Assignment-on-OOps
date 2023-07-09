public class PoloTrendline extends Car {
    private static final double RTO_PRICE = 113990;
    private static final double INSURANCE_PRICE = 47300;
    private static final double TCS_PRICE = 11000;

    public PoloTrendline() {
        super("Polo Trendline", 870000);
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
                if (discount <= 1) { // Discount provided as percentage
                    totalCost -= totalCost * discount;
                } else { // Discount provided as rupees
                    totalCost -= discount;
                }
            } else {
                System.out.println("Error: Maximum discount cannot exceed 30,000, or additional features are required.");
                totalCost = 0;
            }
        }

        return totalCost;
    }
}
