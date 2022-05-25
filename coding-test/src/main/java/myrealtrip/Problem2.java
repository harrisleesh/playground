package myrealtrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Bracket> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            String s = input.substring(i, i + 1);
            Bracket bracket = Bracket.of(s);
            if (bracket.isLeft()) {
                stack.add(bracket);
            } else{
                Bracket pop = stack.pop();
                if (!bracket.pair().equals(pop)) {
                    System.out.println("False");
                    return;
                }
            }
        }
        if (stack.size() > 0) {
            System.out.println("False");
            return;
        }
        System.out.println("True");
    }

    public enum Bracket{
        BIG_LEFT("["), BIG_RIGHT("]"),
        MID_LEFT("{"), MID_RIGHT("}"),
        SMALL_LEFT("("), SMALL_RIGHT(")");

        private String value;

        public String getValue() {
            return value;
        }

        Bracket(String value) {
            this.value = value;
        }

        public static Bracket of(String value){
            for (Bracket bracket : values()) {
                if (bracket.getValue().equals(value)) {
                    return bracket;
                }
            }
            return null;
        }
        public Bracket pair() {
            if (this.value == "[") {
                return BIG_RIGHT;
            }
            if (this.value == "]") {
                return BIG_LEFT;
            }
            if (this.value == "{") {
                return MID_RIGHT;
            }
            if (this.value == "}") {
                return MID_LEFT;
            }
            if (this.value == "(") {
                return SMALL_RIGHT;
            }
            return SMALL_LEFT;
        }

        public Boolean isLeft() {
            return this == BIG_LEFT || this == MID_LEFT || this == SMALL_LEFT;
        }
    }


}
