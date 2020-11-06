package andrylat.atm.bankingCurrency;

import andrylat.atm.interfaces.CurrencyInterface;
import java.util.LinkedHashMap;
import java.util.Map;

public class Currency implements CurrencyInterface {

    private int totalAvailableAmount;

    private int initHundredGroup = 0;
    private int initFiftyGroup = 0;
    private int initTenGroup = 0;
    private int initFiveGroup = 0;

    private int initHundredGroupRes = 0;
    private int initFiftyGroupRes = 0;
    private int initTenGroupRes = 0;
    private int initFiveGroupRes = 0;

    private int totalAmount = 0;

    public int calculateTotalAmount(Map<String, Integer> founds) {

        totalAvailableAmount = atmAvailableMoney(founds);
        return totalAvailableAmount;
    }

    public Map<String, Integer> withdrawCalculation(int amount) {


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

        Map<String, Integer> finalResult = new LinkedHashMap<>();
        finalResult.put("Number of 100 bills is", initHundredGroupRes);
        finalResult.put("Number of 50 bills is", initFiftyGroupRes);
        finalResult.put("Number of 10 bills is", initTenGroupRes);
        finalResult.put("Number of 5 bills is", initFiveGroupRes);

        return finalResult;

    }

    private int atmAvailableMoney(Map<String, Integer> founds) {
        Map<String, Integer> availableMoney = founds;


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
