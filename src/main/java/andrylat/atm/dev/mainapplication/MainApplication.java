package andrylat.atm.dev.mainapplication;


import andrylat.atm.dev.accountstreatments.AtmAvailableFunds;
import andrylat.atm.dev.factories.AtmCurrencyFactory;
import andrylat.atm.dev.interfaces.CurrencyInterface;

import java.util.Map;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        initApplication();
    }

    private static void initApplication() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("In which currency you'd like to have a withdraw \n for us money press USD \n for canadian press CAD");
        String currencyChoice = scanner.nextLine();
        CurrencyInterface currency = AtmCurrencyFactory.getCurrencyType(currencyChoice);
        if (currency != null) {
            interactingWithCustomer(scanner, currency);
        } else {
            invalidCurrencySolution(scanner);

        }
    }

    private static void invalidCurrencySolution(Scanner scanner) {
        System.out.println("Invalid currency \n Press any key to continue");
        scanner.nextLine();
        initApplication();
    }

    private static void interactingWithCustomer(Scanner scanner, CurrencyInterface currency) {
        AtmAvailableFunds atmAvailableFunds = new AtmAvailableFunds();
        atmAvailableFunds.getAvailableMoney();
        int availableFondsAtm = currency.calculateTotalAmount(atmAvailableFunds.getAvailableMoney());
        System.out.println("Available amount at ATM is : " + availableFondsAtm);
        System.out.println(" Enter amount  for Withdraw");
        int withdraw = scanner.nextInt();
        withdraw = validateInput(withdraw, scanner, availableFondsAtm);
        Map<String, Integer> finalResults = currency.withdrawCalculation(withdraw);
        System.out.println("Total amount is " + withdraw + "\n" + finalResults);
    }

    private static int validateInput(int withdraw, Scanner scanner, int availableFondsAtm) {

        while (!(withdraw % 5 == 0) || withdraw > availableFondsAtm ) {

            System.out.println("Please enter amount which is divisible by 5 or less then availableFonds from ATM");
            withdraw = scanner.nextInt();

        }
        return withdraw;
    }
}


