package com.example.jwtpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class JwtpracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtpracticeApplication.class, args);
    }
//    private static boolean stopRequested;
//
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("hello world!");
//        Thread backgroundThread = new Thread(() -> {
//            int i = 0;
//            while (!stopRequested) {
//                i++;
//            }
//        });
//
//        backgroundThread.start();
//        TimeUnit.SECONDS.sleep(10);
//        stopRequested = true;
//    }

}
