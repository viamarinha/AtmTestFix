package mainapplication;

import factories.AtmCurrencyFactory;
import interfaces.ICurrency;

import java.util.Map;
import java.util.Scanner;

public class MainApplication {

    private static int withdraw;


    public static void main(String[] args) {
        initApplication();
    }

    private static void initApplication() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("In which currency you'd like to have a withdraw \n for us money press USD \n for canadian press CAD");
        String currencyChoice = scanner.nextLine();
        ICurrency currency = AtmCurrencyFactory.getCurrencyType(currencyChoice);
        if (currency != null) {
            System.out.println("Available amount at ATM is : " +currency.calculateTotalAmount());
            System.out.println(" Enter amount  for Withdraw");
            withdraw = scanner.nextInt();
            validateInput(withdraw);
            Map<String, Integer> finalResults = currency.withdrawCalculation(withdraw);
            System.out.println("Total amount is " + withdraw +"\n" + finalResults);
        } else {
            System.out.println("Invalid currency \n Press any key to continue");
            scanner.nextLine();
            initApplication();

        }
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


