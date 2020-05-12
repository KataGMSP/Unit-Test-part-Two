import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {
    private Map<String, Integer> hashMapCurrency = new HashMap<String, Integer>();
    Bank bank;
    MoneyPrinter moneyPrinter;
    List<WalletOperations> walletOperationsList;

    public Wallet(){
        bank = new Bank();
        walletOperationsList = new ArrayList<>();
        hashMapCurrency.put("RUB", 0);
        hashMapCurrency.put("USD", 0);
        hashMapCurrency.put("EUR", 0);
    }

    public void addMoney(String key, int value){
        if (hashMapCurrency.containsKey(key)){
            int balance = hashMapCurrency.get(key);
            hashMapCurrency.put(key, balance + value);
            walletOperationsList.add(new WalletOperations("addMoney", key, value));
        }else{
            System.out.println("Такая валюта не поддерживается");
        }
    }

    public String removeMoney(String key, int value){
        if (value > hashMapCurrency.get(key)){
             return  "На вашем счету недостаточно средств";
        }else if (hashMapCurrency.containsKey(key)){
            int balance = hashMapCurrency.get(key);
            hashMapCurrency.put(key, balance - value);
            walletOperationsList.add(new WalletOperations("removeMoney", key, value));
            return String.valueOf(value);
        }

        return "Такая валюта не поддерживается";
    }



    public String getMoney(String key){
        if (hashMapCurrency.containsKey(key)){
            return hashMapCurrency.get(key) + " " + key;
        }else{
            return "Такая валюта не поддерживается";
        }
    }


    public double getTotalMoney(String key){
        if (hashMapCurrency.containsKey(key)) {
            double eur = 0;
            double usd = 0;
            double rub = 0;
            double convert1 = 0;
            double convert2 = 0;

            for (Map.Entry entry : hashMapCurrency.entrySet()) {
                if (entry.getKey() == "RUB") {
                    rub += (int) entry.getValue();
                } else if (entry.getKey() == "USD") {
                    usd += (int) entry.getValue();
                } else {
                    eur += (int) entry.getValue();
                }
            }

            if (key == "RUB") {
                convert1 = bank.convert(usd, "USD", key);
                convert2 = bank.convert(eur, "EUR", key);
                return Math.round(rub + convert1 + convert2);
            } else if (key == "USD") {
                convert1 = bank.convert(rub, "RUB", key);
                convert2 = bank.convert(eur, "EUR", key);
                return Math.round(usd + convert1 + convert2);
            } else {
                convert1 = bank.convert(rub, "RUB", key);
                convert2 = bank.convert(usd, "USD", key);
                return Math.round(eur + convert1 + convert2);
            }
        }else {
            System.out.println("Такая валюта не поддерживается");
            return 0;
        }
    }

    public String toString() {
        String res = "{ ";

        for (Map.Entry entry : hashMapCurrency.entrySet()) {
            res +=  entry.getValue() + " " + entry.getKey() + "; ";
        }

        res += "}";

        return res;
    }
}
