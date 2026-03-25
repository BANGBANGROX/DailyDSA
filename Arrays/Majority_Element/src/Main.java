import java.util.Scanner;

class Solution {
    public int majorityElement(final int[] nums) {
        int count = 0;
        int element = nums[0];

        for (int num : nums) {
            if (num == element) {
                ++count;
            } else {
                --count;
            }

            if (count <= 0) {
                element = num;
            }
        }

        return element;
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

        System.out.println(new Solution().majorityElement(nums));

        scanner.close();
    }
}