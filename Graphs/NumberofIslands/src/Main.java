import java.util.Scanner;

class Solution {
    private char[][] grid;
    private int m;
    private int n;

    public int numIslands(final char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int answer = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    ++answer;
                    dfs(i, j);
                }
            }
        }

        return answer;
    }

    private void dfs(final int x, final int y) {
        final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        grid[x][y] = '0';

        for (final int[] direction : directions) {
            final int newX = x + direction[0];
            final int newY = y + direction[1];

            if (isValid(newX, newY) && grid[newX][newY] == '1') {
                dfs(newX, newY);
            }
        }
    }

    private boolean isValid(final int x, final int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}

public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int m = scanner.nextInt();
        final int n = scanner.nextInt();
        final char[][] grid = new char[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                grid[i][j] = scanner.next().charAt(0);
            }
        }

        System.out.println(new Solution().numIslands(grid));

        scanner.close();
    }
}