import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int eraseOverlapIntervals(final int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        final int n = intervals.length;
        int answer = 0;
        int maxEnd = intervals[0][1];

        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] < maxEnd) {
                ++answer;
            } else {
                maxEnd = intervals[i][1];
            }
        }

        return answer;
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[][] intervals = new int[n][2];

        for (int i = 0; i < n; ++i) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        System.out.println(new Solution().eraseOverlapIntervals(intervals));
    }
}