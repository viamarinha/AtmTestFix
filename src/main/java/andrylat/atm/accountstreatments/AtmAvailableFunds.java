package andrylat.atm.accountstreatments;

import java.util.HashMap;
import java.util.Map;

public class AtmAvailableFunds {

    private  Map<String, Integer>  availableMoney = null;

    public AtmAvailableFunds() {
        this.availableMoney = new HashMap();
        availableMoney.put("5", null);
        availableMoney.put("10" , null);
        availableMoney.put("50", null);
        availableMoney.put("100" , null);

        availableMoney.entrySet().forEach(entry -> entry.setValue((int) ((Math.random() * 100) + 1)));

    }

    public Map<String, Integer> getAvailableMoney() {
        return availableMoney;
    }
}
