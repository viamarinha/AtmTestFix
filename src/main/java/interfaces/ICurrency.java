package interfaces;

import java.util.Map;

public interface ICurrency {

     int calculateTotalAmount();

     Map<String, Integer> withdrawCalculation(int amount);

}
