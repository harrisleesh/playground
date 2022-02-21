package harris;

import java.util.ArrayList;
import java.util.List;

public class Apple {
    private Double weight;
    private Color color;

    public Apple(Double weight) {
        this.weight = weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return apple.getColor().equals(Color.GREEN);
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public Double getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
