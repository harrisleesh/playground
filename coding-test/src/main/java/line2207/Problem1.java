package line2207;

public class Problem1 {

    public static void main(String[] args) {
        solution("bcd");

    }
    public static int solution(String s) {
        if (s.length() == 1) {
            return 0;
        }
        String extracted = extractAZ (s);
        if (extracted.length() <= 1) {
            return 0;
        }
        System.out.println(extracted);
        String duplicated = removeDuplicate (extracted);
        System.out.println(duplicated);
        return duplicated.length() - 1;
    }

    private static String removeDuplicate(String s) {
        StringBuffer duplicated = new StringBuffer();
        char before = s.charAt(0);
        duplicated.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (before != s.charAt(i)) {
                before = s.charAt(i);
                duplicated.append(s.charAt(i));
            }
        }
        return duplicated.toString();
    }

    private static String extractAZ(String s) {
        StringBuffer extracted = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) =='z') {
                extracted.append(s.charAt(i));
            }
        }
        return extracted.toString();
    }


}
