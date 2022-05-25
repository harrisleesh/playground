package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem4 {
    /*
    Given a directed graph, detect whether the graph contains a cycle or not.

⚠️ Please describe algorithm complexity as comment.

Input
[N_NODES]
[E1_FROM_NODE] [E1_TO_NODE]
[E2_FROM_NODE] [E2_TO_NODE]
...
Where N_NODES is the number of nodes in the graph,

and a pair of EnFROMNODE and EnTONODE represents a directed edge in the graph.

EnFROMNODE and EnTONODE are node ids, which are integers in the range 0..N_NODES-1

Output
Output "true" if the graph contains at least one cycle; otherwise, "false".

[RESULT]
Input Example
3
0 1
1 2
2 0
Output Example
true
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Graph graph = new Graph();
        int edgeCount = Integer.parseInt(input);
        int visitedCount = 0;
        for (int i = 0; i < edgeCount; i++) {
            String[] fromTo = br.readLine().split(" ");
            int from = Integer.parseInt(fromTo[0]);
            int to = Integer.parseInt(fromTo[1]);
            graph.insertEdge(from, to);
            visitedCount = Math.max(Math.max(from, to), visitedCount);
        }
        /*
         시간복잡도
         모든 정점들을 방문하는 시간 nodeCount
         모든 Edge들을 방문하는 시간 edgeCount
         시작점에서 한번 검색하는 시간 (nodeCount + edgeCount)
         모든 시작점에서 한 번 검색하는 시간 nodeCount * (nodeCount + edgeCount)
         */
        System.out.println(graph.findCycleForEveryKeySet(visitedCount + 1));
    }



    static class Graph {
        private Map<Integer, List<Integer>> edges = new HashMap<>();

        void print(){
            edges.values().stream()
                    .forEach(System.out::println);
        }

        void insertEdge(int key, int value) {
            List<Integer> valueDefault = edges.getOrDefault(key, new ArrayList<>());
            valueDefault.add(value);
            edges.put(key, valueDefault);
        }

        String findCycleForEveryKeySet(int visitedCount) {
            for (int start : edges.keySet()) {
                if(findCycle(start, start, new boolean[visitedCount])){
                    return "true";
                }
            }
            return "false";
        }

        boolean findCycle(int start, int current, boolean[] visited) {
            if (visited[current]) {
                if (current == start) {
                    return true;
                }
                return false;
            }

            visited[current] = true;
            for (int next : edges.getOrDefault(current, new ArrayList<>())) {
                if (findCycle(start, next, visited)) {
                    return true;
                }
            }
            return false;
        }
    }
}
