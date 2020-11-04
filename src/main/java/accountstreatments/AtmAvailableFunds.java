package accountstreatments;

import java.util.HashMap;
import java.util.Map;

public class AtmAvailableFunds {

    private  Map<String, Integer>  availableMoney = null;

    public AtmAvailableFunds() {
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
