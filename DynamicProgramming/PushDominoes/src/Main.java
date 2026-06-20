import java.util.Scanner;

class Solution {
    public String pushDominoes(final String dominoes) {
        final int n = dominoes.length();
        final int[] nearestLeft = new int[n];
        final int[] nearestRight = new int[n];
        final StringBuilder answer = new StringBuilder();
        int lastLeft = -1;
        int lastRight = -1;

        for (int i = n - 1; i >= 0; --i) {
            if (dominoes.charAt(i) == 'L') {
                lastLeft = i;
            } else if (dominoes.charAt(i) == 'R') {
                lastLeft = -1;
            }

            nearestLeft[i] = lastLeft;
        }

        for (int i = 0; i < n; ++i) {
            if (dominoes.charAt(i) == 'R') {
                lastRight = i;
            } else if (dominoes.charAt(i) == 'L') {
                lastRight = -1;
            }

            nearestRight[i] = lastRight;
        }

        for (int i = 0; i < n; ++i) {
            if (nearestLeft[i] == -1 && nearestRight[i] == -1) {
                answer.append(dominoes.charAt(i));
            } else if (nearestLeft[i] == -1) {
                answer.append('R');
            } else if (nearestRight[i] == -1) {
                answer.append('L');
            } else {
                final int leftDistance = nearestLeft[i] - i;
                final int rightDistance = i - nearestRight[i];

                if (leftDistance < rightDistance) {
                    answer.append('L');
                } else if (leftDistance > rightDistance) {
                    answer.append('R');
                } else {
                    answer.append(dominoes.charAt(i));
                }
            }
        }

        return answer.toString();
    }
}

public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String dominoes = scanner.next();

        System.out.println(new Solution().pushDominoes(dominoes));

        scanner.close();
    }
}
