package factories;

import bankingCurrency.CadCurrency;
import bankingCurrency.UsdCurrency;
import interfaces.ICurrency;

public class AtmCurrencyFactory {

    public static ICurrency getCurrencyType(String accountName){

        if(accountName == null){
            return null;
        }
        if(accountName.equalsIgnoreCase("USD")){
            return new UsdCurrency();
        }
        else if(accountName.equalsIgnoreCase("CAD")){
            return new CadCurrency();
        }
        return  null;
    }
}

