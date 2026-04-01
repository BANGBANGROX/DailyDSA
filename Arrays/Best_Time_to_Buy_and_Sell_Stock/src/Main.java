import java.util.Scanner;

class Solution {
    public int maxProfit(final int[] prices) {
        int minPrice = prices[0];
        final int n = prices.length;
        int answer = 0;

        for (int i = 1; i < n; ++i) {
            if (prices[i] >= minPrice) {
                answer = Math.max(answer, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
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
        final int[] prices = new int[n];

        for (int i = 0; i < n; ++i) {
            prices[i] = scanner.nextInt();
        }

        System.out.println(new Solution().maxProfit(prices));
    }
}