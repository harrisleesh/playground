package kakao.global;

public class Problem2 {
    public static String solution(String s) {
        // Write your code here
        StringBuilder sb = optimalString(s);
        StringBuilder answer = new StringBuilder();

        int length = sb.length();
        for (int i = 0; i < length; i++){
            sb.reverse();
            int lastIndex = sb.length()-1;
            answer.append(sb.charAt(lastIndex));
            sb.deleteCharAt(lastIndex);
        }
        return answer.reverse().toString();
    }

    private static StringBuilder optimalString(String s) {
        StringBuilder sbOne = new StringBuilder();
        StringBuilder sbZero = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sbOne.append(1);
            } else {
                sbZero.append(0);
            }
        }
        return sbOne.append(sbZero);
    }

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
}
