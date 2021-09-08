package kakao.banktest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) throws ParseException {
//        String[] harris = {"01/01 2 50000", "01/03 1 999", "01/31 9 10000", "02/05 5 6547", "02/05 6 1", "06/30 5 5000", "10/15 5 2529", "12/30 4 10000"};
        String[] harris = {"03/01 5 15000", "05/15 2 9527", "11/30 9 10000"};
        System.out.println(solution(harris));
    }

    public static int solution(String[] deposits) {
        int answer = Arrays.stream(deposits).map(deposit -> getReturnMoney(deposit))
                .mapToInt(Long::intValue).sum();
        return answer;
    }

    public static long calculateDate(String beforeString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd");
        Date after = simpleDateFormat.parse("12/31");
        Date before = simpleDateFormat.parse(beforeString);
         return (after.getTime() - before.getTime()) / (24 * 60 * 60 * 1000);
    }
    public static long getReturnMoney(String deposit) {
        String[] split = deposit.split(" ");

        long days = 0;
        try {
            days = calculateDate(split[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int rate = Integer.parseInt(split[1]);
        int originalMoney = Integer.parseInt(split[2]);

        return originalMoney + originalMoney*days*rate/36500;
    }
}
