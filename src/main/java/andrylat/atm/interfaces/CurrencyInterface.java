package andrylat.atm.interfaces;

import java.util.Map;

public interface CurrencyInterface {

     int calculateTotalAmount(Map<String, Integer> availableMoney);

     Map<String, Integer> withdrawCalculation(int amount);

}
