package harris.completablefuture;

import static harris.completablefuture.Shop.randomDelay;

public class ExchangeService {
    public enum Money{
        EUR, USD
    }

    public double getRate(Money m1, Money m2) {
        randomDelay();
        return 0.98;
    }
}
