import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public boolean wordBreak(final String s, final List<String> wordDict) {
        final int n = s.length();
        final Set<String> dictionary = new HashSet<>(wordDict);
        final boolean[] dp = new boolean[n];

        for (int i = 0; i < n; ++i) {
            if (dictionary.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (dp[j] && dictionary.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n - 1];
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(final String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String s = scanner.next();
            final int n = scanner.nextInt();
            final List<String> wordDict = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                wordDict.add(scanner.next());
            }

            System.out.println(new Solution().wordBreak(s, wordDict));
        }
    }
}