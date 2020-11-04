package bankingCurrency;

import accountstreatments.AtmAvailableFunds;
import interfaces.ICurrency;

import java.util.Map;

public class Currency implements ICurrency {

    private int totalAvailableAmount;
    int initHundredGroup = 0;
    int initFiftyGroup = 0;
    int initTenGroup = 0;
    int initFiveGroup = 0;

    int initHundredGroupRes = 0;
    int initFiftyGroupRes = 0;
    int initTenGroupRes = 0;
    int initFiveGroupRes = 0;

    private int totalAmount = 0;

    public void calculateTotalAmount() {

        totalAvailableAmount = calculFromStatus();
    }

    public void withDrawcalculation(int amount) {
        withdrawcalculation(amount);
    }

    private void withdrawcalculation(int amount) {


        while (amount >= 100 && initHundredGroup > 0) {
            initHundredGroup = initHundredGroup - 1;
            initHundredGroupRes++;
            amount = amount - 100;
        }
        while (amount >= 50 && initFiftyGroup > 0) {
            initFiftyGroup = initFiftyGroup - 1;
            initFiftyGroupRes++;
            amount = amount - 50;
        }
        while (amount >= 10 && initTenGroup > 0) {
            initTenGroup = initTenGroup - 1;
            initTenGroupRes++;
            amount = amount - 10;
        }
        while (amount >= 5 && initFiveGroup > 0) {
            initFiveGroup = initFiveGroup - 1;
            initFiveGroupRes++;
            amount = amount - 5;
        }

        System.out.println("Take your amount "
                + (initHundredGroupRes * 100 + initFiftyGroupRes * 50 + initTenGroupRes * 10 + initFiveGroupRes * 5));
        System.out.println("Number of 100 bills is " + initHundredGroupRes);
        System.out.println("Number of 50 bills is " + initFiftyGroupRes);
        System.out.println("Number of 10 bills is " + initTenGroupRes);
        System.out.println("Number of 5 bills is " + initFiveGroupRes);


    }

    private int calculFromStatus() {
        Map<String, Integer> availableMoney = (new AtmAvailableFunds()).getAvailableMoney();


        for (String key : availableMoney.keySet()) {
            if (key.equals("100")) {
                initHundredGroup = availableMoney.get(key);
            }
            if (key.equals("50")) {
                initFiftyGroup = availableMoney.get(key);
            }
            if (key.equals("10")) {
                initTenGroup = availableMoney.get(key);
            }
            if (key.equals("5")) {
                initFiveGroup = availableMoney.get(key);
            }
        }

        totalAmount = (initHundredGroup * 100) + (initFiftyGroup * 50) + (initTenGroup * 10) + (initFiveGroup * 5);

        return totalAmount;
    }
}
