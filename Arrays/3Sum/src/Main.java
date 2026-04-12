import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<List<Integer>> threeSum(final int[] nums) {
        final int n = nums.length;
        final List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; ++i) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            final int newSumNeeded = -1 * nums[i];

            while (left < right) {
                final int currentSum = nums[left] + nums[right];

                if (currentSum == newSumNeeded) {
                    answer.add(List.of(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        --right;
                    }

                    ++left;
                    --right;

                } else if (currentSum > newSumNeeded) {
                    --right;
                } else {
                    ++left;
                }
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
        final int[] nums = new int[n];

        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(new Solution().threeSum(nums));

        scanner.close();
    }
}