package harris;

import java.util.*;

import static java.util.Comparator.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(50d));
        apples.add(new Apple(20d));
        apples.add(new Apple(30d));

        Collections.sort(apples, new Comparator<>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        for (Apple apple: apples) {
            System.out.println("apple = " + apple);
        }

        apples.sort(comparing(Apple::getWeight));
    }
}
