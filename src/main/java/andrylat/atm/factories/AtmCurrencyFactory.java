package andrylat.atm.factories;


import andrylat.atm.bankingCurrency.CadCurrency;
import andrylat.atm.bankingCurrency.UsdCurrency;
import andrylat.atm.interfaces.CurrencyInterface;

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

