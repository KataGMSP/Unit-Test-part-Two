public class MoneyPrinter extends Wallet{
    public String print(String operation, String currency){
        String result = "";
        for (WalletOperations el : walletOperationsList) {
            if (el.operation.equals(operation) && el.currency.equals(currency)){
                result += el.operation + " " + el.currency + el.amount + "\n";
            }
        }
        return result;
    }
}
