package andrylat.atm.mainapplication;


import andrylat.atm.accountstreatments.AtmAvailableFunds;
import andrylat.atm.factories.AtmCurrencyFactory;
import andrylat.atm.interfaces.CurrencyInterface;

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
        System.out.println("Available amount at ATM is : " + currency.calculateTotalAmount(atmAvailableFunds.getAvailableMoney()));
        System.out.println(" Enter amount  for Withdraw");
        int withdraw = scanner.nextInt();
        validateInput(withdraw);
        Map<String, Integer> finalResults = currency.withdrawCalculation(withdraw);
        System.out.println("Total amount is " + withdraw + "\n" + finalResults);
    }

    private static void validateInput(int withdraw) {

        while (withdraw % 5 != 0) {
            {
                System.out.println("Please enter amount which is divisible by 5");
                Scanner scanner = new Scanner(System.in);
                withdraw = scanner.nextInt();

            }
        }
    }
}


