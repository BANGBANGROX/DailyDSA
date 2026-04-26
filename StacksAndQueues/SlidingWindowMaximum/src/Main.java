import java.util.ArrayDeque;
import java.util.Scanner;

class Solution {
    public int[] maxSlidingWindow(final int[] nums, final int k) {
        final int n = nums.length;
        final ArrayDeque<Integer> deque = new ArrayDeque<>();
        final int[] answer = new int[n - k + 1];

        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        answer[0] = nums[deque.peekFirst()];

        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && i - k + 1 > deque.peekFirst()) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);
            answer[i - k + 1] = nums[deque.peekFirst()];
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

        final int k = scanner.nextInt();
        final int[] answer = new Solution().maxSlidingWindow(nums, k);

        for (final int x : answer) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}