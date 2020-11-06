package andrylat.atm.dev.factories;


import andrylat.atm.dev.bankingCurrency.CadCurrency;
import andrylat.atm.dev.bankingCurrency.UsdCurrency;
import andrylat.atm.dev.interfaces.CurrencyInterface;

public class AtmCurrencyFactory {

    public static CurrencyInterface getCurrencyType(String accountName){

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

