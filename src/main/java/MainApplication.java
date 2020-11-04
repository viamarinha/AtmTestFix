import factory.AtmFactory;
import interfaces.ICurrency;

import java.util.Scanner;

public class MainApplication {

    private static int withdraw;


    public static void main(String[] args) {
        initApplication();
    }

    private static void initApplication() {
        System.out.println("git");

        Scanner scanner = new Scanner(System.in);
        System.out.println("In which currency you'd like to have a withdraw \n for us money press USD \n for canadian press CAD");
        String currency = scanner.nextLine();
        ICurrency Currency = AtmFactory.getCurrencyType(currency);
        if (Currency != null) {
            System.out.println(" Enter amount  for Withdraw");
            withdraw = scanner.nextInt();
            enteringRightAmount(withdraw);
            Currency.calculateTotalAmount();
            Currency.withDrawcalculation(withdraw);
        } else {
            System.out.println("Invalid currency \n Press any key to continue");
            scanner.nextLine();
            initApplication();

        }
    }

    private static void enteringRightAmount(int withdraw) {

        while (withdraw % 5 != 0) {
            {
                System.out.println("Please enter amount which is divisible by 5");
                Scanner scanner = new Scanner(System.in);
                withdraw = scanner.nextInt();

            }
        }
    }
}


