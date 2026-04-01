import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(final int[] nums, final int target) {
        final List<List<Integer>> answer = new ArrayList<>();
        final int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;
                final long requiredSum = (long) target - nums[i] - nums[j];

                while (left < right) {
                    long runningSum = (long) nums[left] + nums[right];

                    if (runningSum == requiredSum) {
                        final List<Integer> finalList = List.of(nums[i], nums[j], nums[left], nums[right]);

                        while (left < right && nums[left] == nums[left + 1]) {
                            ++left;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            --right;
                        }

                        answer.add(finalList);

                        ++left;
                        --right;
                    } else if (runningSum > requiredSum) {
                        --right;
                    } else {
                        ++left;
                    }
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[] nums = new int[n];

        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }

        final int target = scanner.nextInt();

        System.out.println(new Solution().fourSum(nums, target));
    }
}