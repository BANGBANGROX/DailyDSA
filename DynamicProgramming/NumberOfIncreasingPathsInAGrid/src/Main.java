import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private int[][] grid;
    private int[][] dp;
    private int m;
    private int n;

    public int countPaths(final int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        dp = new int[m][n];
        long answer = 0;

        for (final int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer = (answer + dfs(i, j)) % MOD;
            }
        }

        return (int) answer;
    }

    private int dfs(final int i, final int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        long count = 1;

        for (final int[] direction : DIRECTIONS) {
            final int newI = i + direction[0];
            final int newJ = j + direction[1];

            if (isValid(newI, newJ) && grid[newI][newJ] > grid[i][j]) {
                count = (count + dfs(newI, newJ)) % MOD;
            }
        }

        return dp[i][j] = (int) count;
    }

    private boolean isValid(final int i, final int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}

public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int m = scanner.nextInt();
        final int n = scanner.nextInt();
        final int[][] grid = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                grid[i][j] = scanner.nextInt();
            }
        }

        System.out.println(new Solution().countPaths(grid));

        scanner.close();
    }
}
