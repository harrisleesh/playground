package harris;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        List<Apple> apples = new ArrayList<>();
//        apples.add(new Apple(50d));
//        apples.add(new Apple(20d));
//        apples.add(new Apple(30d));
//
//        Collections.sort(apples, new Comparator<>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight().compareTo(o2.getWeight());
//            }
//        });
//
//        for (Apple apple : apples) {
//            System.out.println("apple = " + apple);
//        }
//
//        apples.sort(comparing(Apple::getWeight));
//
//        filterApples(apples, new AppleRedAndHeavyPredicate());
//        filterApples(apples, apple -> apple.getWeight() < 150);
//
////        prettyPrintApple(apples, );
//        Comparator<Apple> comparator = (o1, o2) -> o1.getWeight().compareTo(o2.getWeight());
//
//
//        Runnable r1 = () -> System.out.println("Hello world 1");
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello world 2");
//            }
//        };
//        int a = 5;
//        process(r1);
//        process(r2);
//        process(() -> System.out.println("Hello world 3"));
//        process(() -> System.out.println(a));
//        apples.sort(new AppleComparator());
//        apples.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
//        apples.sort(comparing(Apple::getWeight).reversed().thenComparing());
//        OptionalInt max = Arrays.asList(1, 2, 3).stream()
//                .mapToInt(Integer::intValue)
//                .max();
//        System.out.println("reduce = " + reduce.get());
//        Stream.iterate(0, n -> n < 10, n -> n+2)
//                .limit(10)
//                .forEach(System.out::println);
//        Stream.generate(Math::random)
//                .limit(5)
//                .forEach(System.out::println);

//        IntStream.generate(() -> 2);
//
//        IntStream.generate(new IntSupplier() {
//            @Override
//            public int getAsInt() {
//                return 2;
//            }
//        });
//
//        new IntSupplier() {
//            private int previous = 0;
//            private int current = 1;
//
//            @Override
//            public int getAsInt() {
//                int oldPrevious = this.previous;
//                int nextValue = this.previous + this.current;
//                this.previous = this.current;
//                this.current = nextValue;
//                return oldPrevious;
//            }
//        };
    }

    public static void process(Runnable runnable) {
        runnable.run();
    }

    public static void prettyPrintApple(List<Apple> inventory, PrintApple printApple) {
        for (Apple apple : inventory) {
            String output = printApple.print(apple);
            System.out.println(output);
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterGreenApple(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(Color.GREEN)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }
}
