import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] number;
    private int[][][][][][] dp;
    private int k;
    private static final int MAX_NUM_LENGTH = 10;
    private static final int MAX_DIGIT = 9;

    public int numberOfBeautifulIntegers(final int low, final int high, final int k) {
        this.k = k;

        return countBeautifulLessThanNum(high) - countBeautifulLessThanNum(low - 1);
    }

    private int countBeautifulLessThanNum(final int num) {
        if (num <= 0) {
            return 0;
        }

        number = padNumber(num);
        dp = new int[MAX_NUM_LENGTH][MAX_NUM_LENGTH][MAX_NUM_LENGTH][2][2][k];

        for (final int[][][][][] i : dp) {
            for (final int[][][][] j : i) {
                for (final int[][][] l : j) {
                    for (final int[][] m : l) {
                        for (final int[] n : m) {
                            Arrays.fill(n, -1);
                        }
                    }
                }
            }
        }

        return dfs(0, 0, 0, true, true, 0);
    }

    private int dfs(
            final int pos,
            final int evenCount,
            final int oddCount,
            final boolean isLimit,
            final boolean isLeading,
            final int remWithK
    ) {
        if (pos == MAX_NUM_LENGTH) {
            return evenCount == oddCount && remWithK == 0 && !isLeading ? 1 : 0;
        }

        final int intIsLimit = isLimit ? 1 : 0;
        final int intIsLeading = isLeading ? 1 : 0;

        if (dp[pos][evenCount][oddCount][intIsLimit][intIsLeading][remWithK] != -1) {
            return dp[pos][evenCount][oddCount][intIsLimit][intIsLeading][remWithK];
        }

        final int maxDigitAvb = isLimit ? number[pos] : MAX_DIGIT;
        int count = 0;

        for (int digit = 0; digit <= maxDigitAvb; ++digit) {
            final int nextRemWithK = (remWithK * 10 + digit) % k;
            final boolean nextIsLeading = isLeading && (digit == 0);
            final boolean nextIsLimit = isLimit && (digit == maxDigitAvb);

            if (!nextIsLeading) {
                final int nextEvenCount = ((digit & 1) > 0 ? evenCount : evenCount + 1);
                final int nextOddCount = ((digit & 1) > 0 ? oddCount + 1 : oddCount);

                count += dfs(pos + 1, nextEvenCount, nextOddCount, nextIsLimit, false, nextRemWithK);
            } else {
                count += dfs(pos + 1, evenCount, oddCount, nextIsLimit, true, remWithK);
            }
        }

        return dp[pos][evenCount][oddCount][intIsLimit][intIsLeading][remWithK] = count;
    }

    private int[] padNumber(final int num) {
        final String numString = String.valueOf(num);
        final int leadingZeroesNeeded = MAX_NUM_LENGTH - numString.length();
        final int[] number = new int[MAX_NUM_LENGTH];

        for (int i = leadingZeroesNeeded; i < MAX_NUM_LENGTH; ++i) {
            number[i] = numString.charAt(i - leadingZeroesNeeded) - '0';
        }

        return number;
    }
}

public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println(new Solution().numberOfBeautifulIntegers(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));

        scanner.close();
    }
}
