package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem3 {
    /*
    You have several sticks of different lengths, and a stick case of a fixed length.

We want to find 2 sticks that just fit in the case.

⚠️ Please describe algorithm complexity as comment.

Input
[L1] [L2] ... [LN]
[target]
The first line of input contains a list of integers separated by a whitespace. This list represents the lengths of the sticks.

The second line of input contains an integer target. This integer represents the length of the case.

Output
Output a pair of lengths whose sum is equal to target.

[La] [Lb]
Output should be ordered in ascending order. (e.g. "1 2" is acceptable. "2 1" is not)

If you find 2 or more pairs, output the pair which contains the stick of the shortest length. (e.g. If the target is 5, and you find both "1 4" and "2 3", output "1 4")

In case there is no such pairs, output a single -1

-1
Input Example
1 2 3 4 5
6
Output Example
1 5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] lengthOfSticks = input.split(" ");
        String target = br.readLine();
        int caseSize = Integer.parseInt(target);
        // You have several sticks of different lengths
        // Complexity
        /*
         build Sticks Array = O(lengthOfSticks)
         build Sticks Set = O(lengthOfSticks)
         find fit sticks = O(lengthOfSticks)
         */
        System.out.println(getFitSticks(lengthOfSticks, caseSize));

    }

    private static String getFitSticks(String[] lengthOfSticks, int caseSize) {
        int[] sticksArray = Arrays.stream(lengthOfSticks)
                .mapToInt(Integer::parseInt)
                .filter(stickSize -> stickSize < caseSize)
                .toArray();
        Set<Integer> sticksSet = Arrays.stream(lengthOfSticks)
                .map(Integer::parseInt)
                .filter(stickSize -> stickSize < caseSize)
                .collect(Collectors.toUnmodifiableSet());

        for (int stickSize: sticksArray) {
            int otherStickSize = caseSize - stickSize;
            if (sticksSet.contains(otherStickSize)) {
                return stickSize + " " + otherStickSize;
            }
        }
        return "-1";
    }
}
