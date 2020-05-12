import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class MyTest {
    @Test
    public void addMoney() {
        Wallet wallet = new Wallet();
        String key = "RUB";
        wallet.addMoney(key, 500);

        Assert.assertEquals(500, wallet.getMoney(key));
    }
}

