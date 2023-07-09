public class VirtusTrendline extends Car {
    private static final double RTO_PRICE = 113990;
    private static final double INSURANCE_PRICE = 47300;
    private static final double TCS_PRICE = 11000;

    public VirtusTrendline() {
        super("Virtus Trendline", 1105000);
    }

    @Override
    public double calculateTotalCost(boolean insurance, boolean additionalAccessories, double discount) {
        double totalCost = getShowroomPrice() + RTO_PRICE + TCS_PRICE;

        if (insurance)
            totalCost += INSURANCE_PRICE;

        if (additionalAccessories)
            totalCost += 15000;

        double maxDiscount = Math.min(discount, 30000); // Apply a maximum discount of 30,000

        if (insurance || additionalAccessories) {
            if (maxDiscount > 0) {
                if (discount <= 1) { // Discount provided as percentage
                    totalCost -= totalCost * maxDiscount;
                } else { // Discount provided as rupees
                    totalCost -= maxDiscount;
                }
            }
        } else {
            System.out.println("Error: Any one of the additional features has to be added and no discount should be applied.");
            totalCost = 0;
        }

        return totalCost;
    }
}
