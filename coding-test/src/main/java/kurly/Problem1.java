package kurly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputArray = input.split(" ");

//        if (inputArray.length != 2) {
//
//        }
        int pizzaCounts = Integer.parseInt(inputArray[0]);
        int couponCounts = pizzaCounts;
        int pizzaPerCoupon = Integer.parseInt(inputArray[1]);
        while (couponCounts / pizzaPerCoupon > 0) {
            int servicePizzaCounts = couponCounts / pizzaPerCoupon;
            pizzaCounts += servicePizzaCounts;
            couponCounts = couponCounts % pizzaPerCoupon + servicePizzaCounts;
        }
        System.out.println(pizzaCounts);

    }
}
