package hello.aop.exam.aop;

import hello.aop.exam.ExamService;
import hello.aop.exam.annotation.Retry;
import hello.aop.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@RequiredArgsConstructor
@Aspect
public class RetryAspect {
    private final OrderService orderService;

    @Around("@annotation(retry)")
    public Object doRetry(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
        log.info("[retry] {} args={}", joinPoint.getSignature(), retry);

        int maxRetry = retry.value();
        Exception exceptionHolder = null;

        for (int retryCount = 1; retryCount <= maxRetry; retryCount++) {
            try {
                log.info("[retry] try count ={}/{}", retryCount, maxRetry);
                Object ret = joinPoint.proceed();
                if(ret instanceof String){
                    log.info(ret.toString());
                }
                return ret;
            } catch (Exception e) {
                exceptionHolder = e;
            }
        }
        throw exceptionHolder;

    }
}
