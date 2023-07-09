import java.util.Scanner;

public class CarBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Car Model\t\tCost(Showroom Price)");
        System.out.println("===========================================");
        System.out.println("1. Polo Trendline\t8.70 lakh");
        System.out.println("2. Polo Highline\t10.09 lakh");
        System.out.println("3. Virtus Trendline\t11.05 lakh");
        System.out.println("4. Virtus Highline\t13.08 lakh");
        System.out.println("5. Taigun Trendline\t14.89 lakh");
        System.out.println("6. Taigun Highline\t15.42 lakh");
        System.out.println("7. Taigun Topline\t17.71 lakh");
        System.out.println("===========================================");

        System.out.print("Select car model: ");
        int carModel = scanner.nextInt();

        System.out.print("Do you need Insurance (yes/no): ");
        String insuranceInput = scanner.next();
        boolean insurance = insuranceInput.equalsIgnoreCase("yes");

        System.out.print("Do you need Additional Accessories (yes/no): ");
        String accessoriesInput = scanner.next();
        boolean additionalAccessories = accessoriesInput.equalsIgnoreCase("yes");

        System.out.print("Dealer discount (% or amount in rupees): ");
        String discountInput = scanner.next();
        double discount = parseDiscount(discountInput);

        Car car = null;

        switch (carModel) {
            case 1:
                car = new PoloTrendline();
                break;
            case 2:
                car = new PoloHighline();
                break;
            case 3:
                car = new VirtusTrendline();
                break;
            case 4:
                car = new VirtusHighline();
                break;
            case 5:
                car = new TaigunTrendline();
                break;
            case 6:
                car = new TaigunHighline();
                break;
            case 7:
                car = new TaigunTopline();
                break;
            default:
                System.out.println("Invalid car model");
                System.exit(0);
        }

        double totalCost = car.calculateTotalCost(insurance, additionalAccessories, discount);
        System.out.println("Total cost: " + formatCost(totalCost));
    }

    private static double parseDiscount(String discountInput) {
        if (discountInput.endsWith("%")) {
            // Parse percentage discount
            String percentage = discountInput.substring(0, discountInput.length() - 1);
            return Double.parseDouble(percentage) / 100.0;
        } else {
            // Parse rupee discount
            return Double.parseDouble(discountInput);
        }
    }

    private static String formatCost(double cost) {
        return String.format("%.2f", cost);
    }
}
