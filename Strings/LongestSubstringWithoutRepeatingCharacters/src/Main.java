import java.util.Scanner;

class Solution {
    public int lengthOfLongestSubstring(final String s) {
        final int[] countOfChars = new int[26];
        final int n = s.length();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < n; ++right) {
            final char ch = s.charAt(right);

            ++countOfChars[ch - 'a'];

            while (countOfChars[ch - 'a'] > 1) {
                --countOfChars[s.charAt(left) - 'a'];
                ++left;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String s = scanner.next();

        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
