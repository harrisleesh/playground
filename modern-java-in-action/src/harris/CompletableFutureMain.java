package harris;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CompletableFutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int x = 1337;

        Future<Double> future = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                System.out.println("return 1.0");
                return 1.0;
            }
        });

        System.out.println("doSomethingElse()");

        try {
            Double result = future.get(1, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
//
//        CompletableFuture<Integer> a = new CompletableFuture<>();
//        CompletableFuture<Integer> b = new CompletableFuture<>();
//
//        CompletableFuture<Integer> c = a.thenCombine(b, (y, z) -> y + z);
//        executorService.submit(() -> a.complete(f(x)));
//        executorService.submit(() -> b.complete(g(x)));
//
//        System.out.println(c.get());
//        executorService.shutdown();
    }

    static int f(int x){
        int result = 0;
        for (int i = 0; i < 10000; i++) {
            result += x;
        }
        return result;
    }

    static int g(int x){
        int result = 0;
        for (int i = 0; i < 20000; i++) {
            result += x;
        }
        return result;
    }
}
