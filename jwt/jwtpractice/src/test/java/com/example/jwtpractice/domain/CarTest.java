package com.example.jwtpractice.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car car = new Car("harris", "nono");

        Class<Car> carClass = Car.class;
        Method getCarname = carClass.getDeclaredMethod("getCarName");
//        getCarname.setAccessible(true);

        Object invoke = getCarname.invoke(car, null);
        System.out.println(invoke);
    }
}