package baemin;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stream<String> lines = br.lines();
        String collect = lines.filter(line -> line.length() >= 5 && line.length() < 10)
                .map(line -> line.toUpperCase())
                .collect(Collectors.joining("\n"));
        bw.write(collect);
        bw.flush();
    }
    public static class Solution{
        public String solution(String message){
            String answer = "";
            return answer;
        }
    }

    class Tree{
        public Tree(String message) {
        }
    }
}
