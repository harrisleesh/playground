package harris.flow;
import java.util.concurrent.Flow;
import io.reactivex.Observable;

public class FlowMain {
    public static void main(String[] args) {
//        getTemperatures("New York").subscribe(new TempSubscriber());
//        getCelsiusTemperatures("New York").subscribe(new TempSubscriber());

    }

//    private static Flow.Publisher<TempInfo> getTemperatures( String town) {
//        return subscriber -> subscriber.onSubscribe(new TempSubscription(subscriber, town));
//    }

    public static Flow.Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe( subscriber);
            subscriber.onSubscribe(new TempSubscription(processor, town));
        };
    }
}
