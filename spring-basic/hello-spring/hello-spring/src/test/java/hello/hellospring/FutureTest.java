package hello.hellospring;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureTest {
    @Test
    void cf() throws ExecutionException, InterruptedException {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Hello4";
        }); //future 가 종료될때까지 block해서 결과를 얻는다.
        String result = (String) future.get();
        System.out.println(result);
        CompletableFuture future2 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Hello5");
        }); //future 가 종료될때까지 block
        future2.get();


    }

    @Test
    void cftest2() {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Hello6";
        });
        CompletableFuture future1 = future.thenApply(s -> s + " World1");
        CompletableFuture future2 = future.thenAccept(s -> {
            System.out.println(s + " World2");
        });
        CompletableFuture future3 = future.thenRun(() -> {
            System.out.println("Computation finished.");
        });
        try {
            String future1Result = (String) future1.get();
            System.out.println(future1Result);
            future2.get();
            future3.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
