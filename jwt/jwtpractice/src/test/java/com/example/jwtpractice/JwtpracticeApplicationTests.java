package com.example.jwtpractice;

import com.example.jwtpractice.domain.Car;
import com.example.jwtpractice.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootTest
class JwtpracticeApplicationTests {

    @Test
    void contextLoads() throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(100);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            numbers.add(i);
        }

//        List<Integer> evenNumbers = Collections.synchronizedList(new ArrayList<>());
        List<Integer> evenNumbers =new ArrayList<>();
        long start = System.currentTimeMillis();
        ForkJoinTask<List<Integer>> submit = pool.submit(() -> numbers.parallelStream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList()));
        System.out.println(submit.get().size());
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    @Test
    void timeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long start = System.currentTimeMillis();
        Long result = 0l;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    @Test
    void name() {
        Supplier<String> stringSupplier = () -> "hello";

        System.out.println(stringSupplier.get());


        Consumer<String> stringConsumer = s -> System.out.println(s);
        stringConsumer.accept("hey");

    }
}
