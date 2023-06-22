import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockersApp stockersApp = new StockersApp();

        System.out.println("Enter the number of companies:");
        int numOfCompanies = scanner.nextInt();

        for (int i = 0; i < numOfCompanies; i++) {
            System.out.println("Enter the current stock price of company " + (i + 1) + ":");
            double stockPrice = scanner.nextDouble();

            System.out.println("Whether the company's stock price rose today compared to yesterday? (true/false):");
            boolean stockPriceRoseToday = scanner.nextBoolean();

            stockersApp.addCompany(stockPrice, stockPriceRoseToday);
        }

        int choice = -1;
        while (choice != 0) {
            System.out.println("\nEnter the operation that you want to perform:");
            System.out.println("1. Display the companies' stock prices in ascending order");
            System.out.println("2. Display the companies' stock prices in descending order");
            System.out.println("3. Display the total number of companies for which stock prices rose today");
            System.out.println("4. Display the total number of companies for which stock prices declined today");
            System.out.println("5. Search for a specific stock price");
            System.out.println("0. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    stockersApp.displayStockPricesAscending();
                    break;
                case 2:
                    stockersApp.displayStockPricesDescending();
                    break;
                case 3:
                    int companiesWithPriceRise = stockersApp.countCompaniesWithPriceRise();
                    System.out.println("Total number of companies whose stock price rose today: " + companiesWithPriceRise);
                    break;
                case 4:
                    int companiesWithPriceDecline = stockersApp.countCompaniesWithPriceDecline();
                    System.out.println("Total number of companies whose stock price declined today: " + companiesWithPriceDecline);
                    break;
                case 5:
                    System.out.println("Enter the stock price to search:");
                    double searchStockPrice = scanner.nextDouble();
                    boolean stockPriceFound = stockersApp.searchStockPrice(searchStockPrice);
                    if (stockPriceFound) {
                        System.out.println("Stock price " + searchStockPrice + " is present.");
                    } else {
                        System.out.println("Stock price " + searchStockPrice + " is not found.");
                    }
                    break;
                case 0:
                    System.out.println("Exited successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
