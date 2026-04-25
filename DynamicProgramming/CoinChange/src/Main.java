import java.util.Scanner;

class Solution {
    public int coinChange(final int[] coins, final int amount) {
        final int[] dp = new int[amount + 1];

        dp[0] = 0;

        for (int i = 1; i <= amount; ++i) {
            int minCoins = Integer.MAX_VALUE;

            for (final int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    minCoins = Math.min(minCoins, dp[i - coin] + 1);
                }
            }

            dp[i] = minCoins != Integer.MAX_VALUE ? minCoins : -1;
        }

        return dp[amount];
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[] coins = new int[n];
        for (int i = 0; i < n; ++i) {
            coins[i] = scanner.nextInt();
        }
        final int amount = scanner.nextInt();

        System.out.println(new Solution().coinChange(coins, amount));
    }
}