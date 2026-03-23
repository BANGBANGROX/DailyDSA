import java.util.Scanner;

class Solution {
    public boolean check(final int[] nums) {
        final int n = nums.length;
        int breakPoint = 0;

        for (int i = 0; i < n; ++i) {
            if (nums[i] > nums[(i + 1) % n]) {
                ++breakPoint;
            }
        }

        return breakPoint == 1;
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

        System.out.println(new Solution().check(nums));
    }
}