package accountsTreatments;

import java.util.HashMap;
import java.util.Map;

public class AtmStatus {

    public Map<String, Integer>  availableMoney = null;

    public AtmStatus() {
        this.availableMoney = new HashMap();
        availableMoney.put("5", 10);
        availableMoney.put("10" , 10);
        availableMoney.put("50", 10);
        availableMoney.put("100" , 10);
    }

    public Map<String, Integer> getAvailableMoney() {
        return availableMoney;
    }
}
