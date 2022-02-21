package harris;

public interface ApplePredicate {
//    default String a = 10;
    default String a() {
        return null;
    }
    boolean test(Apple apple);
}
