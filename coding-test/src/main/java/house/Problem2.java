package house;

public class Problem2 {
//https://daegwonkim.tistory.com/82
    // 합이 `n`이 되는 최소 제곱 수를 찾는 반복 함수
    public static int findMinSquares(int n)
    {
        // 보조 어레이 T[]를 생성합니다. 여기서 T[i]는 최소 숫자를 저장합니다.
        // 합이 `i`인 제곱


//        return RECORD[n];
        return 0;
    }

    public static void main(String[] args)
    {
        int n = 5;
        int[] RECORD = new int[n + 1];

        // 상향식으로 보조 어레이 T[] 채우기
        for (int i = 1; i <= n; i++)
        {
            // 가능한 최대 제곱수로 T[i]를 초기화합니다.
            RECORD[i] = i;

            // 다음보다 작거나 같은 모든 양의 정수를 반복합니다.
            // `i`의 제곱근
            for (int j = 1; j*j <= i; j++)
            {
                // 더 작은 결과를 사용하여 T[i]의 값을 계산합니다.
                // 하위 문제 T[i-j×j]
                RECORD[i] = Math.min(RECORD[i], 1 + RECORD[i - j*j]);
            }
        }
        System.out.println("The minimum number of squares is " + RECORD[n]);
    }
}
