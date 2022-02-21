package harris.flow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;

import static java.util.concurrent.Flow.*;

public class TempSubscription implements Subscription {
    private final Subscriber subscriber;
    private final String town;

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public TempSubscription(Subscriber subscriber, String town) {
        this.subscriber = subscriber;
        this.town = town;
    }

    @Override
    public void request(long n) {
        executor.submit(() -> {
            for (long i = 0L; i < n; i++) {
                try {
                    subscriber.onNext(TempInfo.fetch(town));
                } catch (Exception e) {
                    subscriber.onError(e);
                    break;
                }
            }
        });
    }

    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
