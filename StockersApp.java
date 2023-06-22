import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class StockersApp {
    private List<Company> companies;

    public StockersApp() {
        companies = new ArrayList<>();
    }

    public void addCompany(double stockPrice, boolean stockPriceRoseToday) {
        Company company = new Company(stockPrice, stockPriceRoseToday);
        companies.add(company);
    }

    public void displayStockPricesAscending() {
        Collections.sort(companies, Comparator.comparingDouble(c -> c.stockPrice));
        System.out.println("Stock prices in ascending order are:");
        for (Company company : companies) {
            System.out.println(company.stockPrice);
        }
    }

    public void displayStockPricesDescending() {
        Collections.sort(companies, Comparator.comparingDouble((Company c) -> c.stockPrice).reversed());
        System.out.println("Stock prices in descending order are:");
        for (Company company : companies) {
            System.out.println(company.stockPrice);
        }
    }

    public int countCompaniesWithPriceRise() {
        int count = 0;
        for (Company company : companies) {
            if (company.stockPriceRoseToday) {
                count++;
            }
        }
        return count;
    }

    public int countCompaniesWithPriceDecline() {
        int count = 0;
        for (Company company : companies) {
            if (!company.stockPriceRoseToday) {
                count++;
            }
        }
        return count;
    }

    public boolean searchStockPrice(double stockPrice) {
        for (Company company : companies) {
            if (company.stockPrice == stockPrice) {
                return true;
            }
        }
        return false;
    }
}