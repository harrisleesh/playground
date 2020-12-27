package hash;

import java.util.Arrays;

//완주하지 못한 선수
//https://programmers.co.kr/learn/courses/30/lessons/42576
public class CompletionFail {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String [] participant = {"leo", "kiki", "eden"};
//        String [] completion = {"kiki", "eden"};
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String s = solution.solution(participant, completion);
        System.out.println("s = " + s);
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            Arrays.sort(participant);
            Arrays.sort(completion);

            for(int i=0; i < participant.length - 1; i ++){
                if(!participant[i].equals(completion[i])){
                    return participant[i];
                }
            }
            return participant[participant.length - 1];
        }
    }
}
