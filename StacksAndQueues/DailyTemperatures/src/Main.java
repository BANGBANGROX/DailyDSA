import java.util.Scanner;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(final int[] temperatures) {
        final int n = temperatures.length;
        final Stack<Integer> stack = new Stack<>();
        final int[] answer = new int[n];

        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            stack.push(i);
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
        final int[] temperatures = new int[n];

        for (int i = 0; i < n; ++i) {
            temperatures[i] = scanner.nextInt();
        }

        final int[] answer = new Solution().dailyTemperatures(temperatures);

        for (final int x : answer) {
            System.out.print(x + " ");
        }
        System.out.println();

        scanner.close();
    }
}