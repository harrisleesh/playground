package kakao.global;

import java.util.*;

public class Problem3 {

    public static List<Integer> solution(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
        // Write your code here

        List<Set<Integer>> studentsGroups = createStudentsGroup(n);

        List<Integer> totalIndices = matchingFriend(queryType, students1, students2, studentsGroups);

        List<Integer> answer = new ArrayList<>();
        for (int totalIndex : totalIndices) {
            answer.add(findFriendCount(students1, students2, studentsGroups, totalIndex));
        }
        return answer;
    }

    private static List<Set<Integer>> createStudentsGroup(int n) {
        List<Set<Integer>> studentsGroups = new ArrayList<>();
        studentsGroups.add(new HashSet<>());
        for (int i = 1; i <= n; i++) {
            // 1부터 n 까지 고유번호 부여
            Set<Integer> studentsSet = new HashSet<>();
            studentsSet.add(i);
            studentsGroups.add(studentsSet);
        }
        return studentsGroups;
    }

    private static List<Integer> matchingFriend(List<String> queryType, List<Integer> students1, List<Integer> students2, List<Set<Integer>> studentsGroups) {
        List<Integer> totalIndices = new ArrayList<>();

        for(int i = 0; i < queryType.size(); i++){
            if(queryType.get(i).equals("Friend")){
                Integer frd1 = students1.get(i);
                Integer frd2 = students2.get(i);
                studentsGroups.get(frd1).add(frd2);
                studentsGroups.get(frd2).add(frd1);
            } else {
                totalIndices.add(i);
            }
        }

        return totalIndices;
    }

    private static Integer findFriendCount(List<Integer> students1, List<Integer> students2, List<Set<Integer>> studentsGroups, int totalIndex) {
        int firstFriendCount = 0;
        int secondFriendCount = 0;

        Integer firstStudent = students1.get(totalIndex);
        Integer secondStudent = students2.get(totalIndex);
        Set<Integer> integers = studentsGroups.get(firstStudent);
        for (Set<Integer> group : studentsGroups) {
            if (group.contains(firstStudent)) {
                firstFriendCount = Math.max(firstFriendCount, group.size());
            }
            if (group.contains(secondStudent)) {
                secondFriendCount = Math.max(secondFriendCount, group.size());
            }
        }

        System.out.println(firstFriendCount);
        System.out.println(secondFriendCount);
        return firstFriendCount + secondFriendCount;
    }

    public static void main(String[] args) {
        List<Integer> solution = solution(4, Arrays.asList("Friend", "Friend", "Total"), Arrays.asList(1, 2, 1), Arrays.asList(2, 3, 4));
        System.out.println(solution.get(0));
    }
}
