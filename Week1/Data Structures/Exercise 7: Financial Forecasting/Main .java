import java.util.Scanner;

public class FinancialForecast {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        double previousValue = calculateFutureValue(presentValue, growthRate, years - 1);
        return previousValue * (1 + growthRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial investment amount: ");
        double initialInvestment = scanner.nextDouble();

        System.out.print("Enter annual growth rate (e.g., enter 5 for 5%): ");
        double annualGrowthRatePercent = scanner.nextDouble();
        double annualGrowthRate = annualGrowthRatePercent / 100;

        System.out.print("Enter number of years: ");
        int numberOfYears = scanner.nextInt();

        double futureValue = calculateFutureValue(initialInvestment, annualGrowthRate, numberOfYears);

        System.out.printf("Future Value after %d years: $%.2f\n", numberOfYears, futureValue);
        
        scanner.close();
    }
}
