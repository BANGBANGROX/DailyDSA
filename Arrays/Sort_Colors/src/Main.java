import java.util.Scanner;

class Solution {
    public void sortColors(final int[] nums) {
        final int[] count = new int[3];
        int ptr = 0;

        for (final int num : nums) {
            ++count[num];
        }

        for (int i = 0; i < 3; ++i) {
            while (count[i] > 0) {
                nums[ptr] = i;
                ++ptr;
                --count[i];
            }
        }
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

        new Solution().sortColors(nums);

        for (final int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}

