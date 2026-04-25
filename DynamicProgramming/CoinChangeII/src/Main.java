import java.util.Scanner;

class Solution {
    public int change(final int amount, final int[] coins) {
        final int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (final int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int amount = scanner.nextInt();
        final int n = scanner.nextInt();
        final int[] coins = new int[n];
        for (int i = 0; i < n; ++i) {
            coins[i] = scanner.nextInt();
        }

        System.out.println(new Solution().change(amount, coins));
    }
}