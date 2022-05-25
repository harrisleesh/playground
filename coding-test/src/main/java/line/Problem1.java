package line;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useRadix(10);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        System.out.println(getArea(width, height));
    }

    public static int getArea(int width, int height){
        //TODO Implements
        return width * height;
    }
}
