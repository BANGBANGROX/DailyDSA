// User function Template for Java

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int longestSubarray(final int[] arr, final int k) {
        // code here
        final int n = arr.length;
        final Map<Integer, Integer> firstIndex = new HashMap<>();
        int answer = 0;
        int runningSum = 0;

        for (int i = 0; i < n; ++i) {
            runningSum += arr[i];

            if (runningSum == k) {
                answer = i + 1;
            }

            if (firstIndex.containsKey(runningSum - k)) {
                answer = Math.max(answer, i - firstIndex.get(runningSum - k));
            }

            if (!firstIndex.containsKey(runningSum)) {
                firstIndex.put(runningSum, i);
            }
        }

        return answer;
    }
}


public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }

        final int k = scanner.nextInt();

        System.out.println(new Solution().longestSubarray(arr, k));

        scanner.close();
    }
}
