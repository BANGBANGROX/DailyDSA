import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public boolean canFinish(final int numCourses, final int[][] prerequisites) {
        final List<List<Integer>> graph = new ArrayList<>();
        final int[] indegree = new int[numCourses];
        final Queue<Integer> queue = new LinkedList<>();
        int coursesTaken = 0;

        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }

        for (final int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
            ++indegree[edge[1]];
        }

        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            final int node = queue.poll();
            ++coursesTaken;

            for (final int child : graph.get(node)) {
                --indegree[child];

                if (indegree[child] == 0) {
                    queue.add(child);
                }
            }
        }

        return coursesTaken == numCourses;
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numCourses = scanner.nextInt();
        final int edges = scanner.nextInt();
        final int[][] prerequisites = new int[edges][2];

        for (int i = 0; i < numCourses; ++i) {
            prerequisites[i][0] = scanner.nextInt();
            prerequisites[i][1] = scanner.nextInt();
        }

        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }
}