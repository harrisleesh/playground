package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {


    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }

    @Test
    void strategyV2(){

        Strategy strategyLogic1 = () -> log.info("비즈니스 로직1 실행");

        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();
    }
}
