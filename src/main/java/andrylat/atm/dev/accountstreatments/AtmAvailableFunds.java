package andrylat.atm.dev.accountstreatments;

import java.util.HashMap;
import java.util.Map;

public class AtmAvailableFunds {

    private Map<String, Integer> availableMoney = null;

    public AtmAvailableFunds() {
        this.availableMoney = new HashMap();
        availableMoney.put("5", (int) ((Math.random() * 100) + 1));
        availableMoney.put("10", (int) ((Math.random() * 100) + 1));
        availableMoney.put("50", (int) ((Math.random() * 100) + 1));
        availableMoney.put("100", (int) ((Math.random() * 100) + 1));
    }

    public Map<String, Integer> getAvailableMoney() {
        return availableMoney;
    }
}
