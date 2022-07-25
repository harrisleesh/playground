package baemin.june;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        String[] grades = {"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"};

        Solution solution = new Solution();
        String[] answers = solution.solution(grades);
        for (String answer: answers) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public String[] solution(String[] grades) {
            //순서가 중요하므로 List를 사용한다.
            List<Grade> gradeList = new ArrayList<>();
            for (String grade : grades) {
                String[] splits = grade.split(" ");
                String classNumber = splits[0];
                String gradesString = splits[1];

                Grade gradeCandidate = new Grade(classNumber, gradesString);
                updateList(gradeList, gradeCandidate);
            }

            gradeList.sort((o1, o2) -> Integer.compare(o2.getGrades().getScore(), o1.getGrades().getScore()));
            String[] answer = gradeList.stream().map(Grade::toStringFormat).toArray(String[]::new);

            return answer;
        }

        private void updateList(List<Grade> gradeList, Grade gradeCandidate) {
            if (gradeList.stream().anyMatch(grade -> grade.getClassNumber().equals(gradeCandidate.getClassNumber()))) {
                for (int i = 0; i < gradeList.size(); i++) {
                    if (gradeList.get(i).isSameClassAndLowerThan(gradeCandidate)) {
                        gradeList.remove(i);
                        gradeList.add(gradeCandidate);
                        break;
                    }
                }
            } else {
                gradeList.add(gradeCandidate);
            }
        }

        class Grade {
            String classNumber;
            Grades grades;

            public String getClassNumber() {
                return classNumber;
            }

            public Grades getGrades() {
                return grades;
            }

            public String toStringFormat(){
                return this.getClassNumber() + " " + this.getGrades().getValue();
            }

            public Grade(String classNumber, String gradesString) {
                this.classNumber = classNumber;
                this.grades = Grades.from(gradesString);
            }

            public boolean isSameClassAndLowerThan(Grade gradeCandidate) {
                if (this.classNumber.equals(gradeCandidate.getClassNumber()) &&
                        this.grades.isLowerThan(gradeCandidate.getGrades())) {
                    return true;
                }
                return false;
            }
        }

        enum Grades {
            Ap("A+", 100), Az("A0", 95), Am("A-", 90),
            Bp("B+", 85), Bz("B0", 80), Bm("B-", 75),
            Cp("C+", 70), Cz("C0", 65), Cm("C-", 60),
            Dp("D+", 55), Dz("D0", 50), Dm("D-", 45),
            Fz("F", 0);

            private String value;
            private int score;

            Grades(String value, int score) {
                this.value = value;
                this.score = score;
            }

            public String getValue() {
                return value;
            }

            public int getScore() {
                return score;
            }

            public static Grades from(String value) {
                Optional<Grades> anyGrades = Arrays.stream(values())
                        .filter(grades -> grades.getValue().equals(value))
                        .findAny();
                return anyGrades.orElse(Grades.Fz);
            }

            public boolean isLowerThan(Grades grades) {
                if (this.getScore() < grades.getScore()) {
                    return true;
                }
                return false;
            }
        }
    }
}
