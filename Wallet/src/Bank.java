public class Bank {
    public double convert(double value, String from, String to){
        if (from == "USD" && to == "RUB"){
            return value * 73;
        }else if (from == "USD" && to == "EUR"){
            return  (value * 0.92);
        } else if (from == "RUB" && to == "USD"){
            return  (value * 0.014);
        } else if (from == "RUB" && to == "EUR"){
            return (value * 0.013);
        }else if (from == "EUR" && to == "RUB"){
            return value * 79;
        }else if (from == "EUR" && to == "USD"){
            return  (value * 1.08);
        }else {
            return 0;
        }
    }
}
