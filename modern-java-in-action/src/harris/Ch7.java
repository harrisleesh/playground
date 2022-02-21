package harris;

import java.util.*;

public class Ch7 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        List<String> friends = new ArrayList<>();
        friends.add("harris");
        friends.add("surris");

        List<String> lists = List.of("harris", "surris");
//        lists.add("norris");

//        Set.of("harris", "harris");

        Map<String, Integer> age = Map.of("harris", 31, "summer", 30);

        String a = null;

//        Optional<String> optionalS= (Optional<String>) Optional.of(a);
        Optional<String> a1 = Optional.ofNullable(a);
        System.out.println(a1.isEmpty());
        Optional<String> optionalS = a1.map(s -> s + "changed");
        System.out.println(optionalS.isEmpty());
    }
}
