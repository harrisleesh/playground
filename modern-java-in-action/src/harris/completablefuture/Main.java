package harris.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final Double DEFAULT_RATE = 0.98;
    static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));
    static ExchangeService exchangeService = new ExchangeService();
    private static final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    public static void main(String[] args) throws InterruptedException {
//        Shop shop = new Shop("BestShop");
//        long start = System.nanoTime();
//        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
//        long invocationTime = (System.nanoTime() - start) / 1000000;
//        System.out.println("Invocation returned after " + invocationTime + " msecs");
//
//        //doSomethingElse();
//        try {
//            double price = futurePrice.get();
//            System.out.printf("Price is %.2f%n", price);
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//
//        long retrievalTime = (System.nanoTime() - start) / 1000000;
//        System.out.println("Price returned after " + retrievalTime + " msecs");

        long start = System.nanoTime();
//        System.out.println(findPrices("myPhone27S"));
        CompletableFuture[] futures = findPricesStream("myPhone").map(f -> f.thenAccept(System.out::println))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs");
    }

//    public static List<String> findPrices(String product) {
//        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
//                new Shop("LetsSaveBig"),
//                new Shop("MyFavoriteShop"),
//                new Shop("BuyItAll"));
//        return shops.parallelStream()
//                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
//                .collect(Collectors.toList());
//    }

    public static Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));
    }
//    public static List<String> findPriceInUSD(String product){
//        Shop shop = shops.get(0);
//        CompletableFuture.supplyAsync(() -> shop.getPrice(product))
//                .thenCombine(CompletableFuture.supplyAsync(() -> exchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD)),
//                        (price, rate) -> price * rate)
//                .completeOnTimeout(DEFAULT_RATE, 3, TimeUnit.SECONDS);
//        return null;
//
//    }
    public static List<String> findPrices2(String product) {
        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public static List<String> findPrices(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());

        return priceFutures.stream().map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
