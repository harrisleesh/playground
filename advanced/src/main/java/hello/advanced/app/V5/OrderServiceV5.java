package hello.advanced.app.V5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepositoryV5;
    private final TraceTemplate trace;

    public OrderServiceV5(OrderRepositoryV5 orderRepositoryV5, LogTrace logTrace) {
        this.orderRepositoryV5 = orderRepositoryV5;
        this.trace = new TraceTemplate(logTrace);
    }

    public void orderItem(String itemId) {
        trace.execute("OrderServiceV2.orderItem()", () -> {
            orderRepositoryV5.save(itemId);
            return null;
        });
    }
}
