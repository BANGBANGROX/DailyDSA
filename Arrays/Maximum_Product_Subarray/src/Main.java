import java.util.Scanner;

class Solution {
    public int maxProduct(final int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int answer = nums[0];
        final int n = nums.length;

        for (int i = 1; i < n; ++i) {
            if (nums[i] < 0) {
                final int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(maxProduct * nums[i], nums[i]);
            minProduct = Math.min(minProduct * nums[i], nums[i]);
            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}

public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[] nums = new int[n];

        System.out.println(new Solution().maxProduct(nums));
    }
}