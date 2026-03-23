import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int subarraySum(final int[] nums, final int k) {
        final Map<Integer, Integer> sumCount = new HashMap<>();
        int runningSum = 0;
        int answer = 0;

        for (final int num : nums) {
            runningSum += num;

            if (runningSum == k) {
                ++answer;
            }

            answer += sumCount.getOrDefault(runningSum - k, 0);
            sumCount.put(runningSum, sumCount.getOrDefault(runningSum, 0) + 1);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[] nums = new int[n];

        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }

        final int k = scanner.nextInt();

        final Solution solution = new Solution();

        System.out.println(solution.subarraySum(nums, k));
    }
}