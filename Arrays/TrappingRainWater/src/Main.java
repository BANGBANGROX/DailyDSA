import java.util.Scanner;

class Solution {
    public int trap(final int[] height) {
        final int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int answer = 0;

        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if (maxLeft < maxRight) {
                answer += (maxLeft - height[left]);
                ++left;
            } else {
                answer += (maxRight - height[right]);
                --right;
            }
        }

        return answer;
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[] height = new int[n];

        for (int i = 0; i < n; ++i) {
            height[i] = scanner.nextInt();
        }

        System.out.print(new Solution().trap(height));
    }
}