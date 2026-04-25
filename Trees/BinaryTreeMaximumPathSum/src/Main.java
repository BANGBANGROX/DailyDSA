class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(final int val) {
        this.left = this.right = null;
        this.val = val;
    }
}

class Solution {
    private int answer;

    public int maxPathSum(final TreeNode root) {
        answer = 0;

        maxPathSumHandler(root);

        return answer;
    }

    private int maxPathSumHandler(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int leftSum = Math.max(maxPathSumHandler(root.left), 0);
        final int rightSum = Math.max(maxPathSumHandler(root.right), 0);

        answer = Math.max(answer, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(final String[] args) {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-100);
        root.right = new TreeNode(100);
        root.left.left = new TreeNode(500);
        root.right.left = new TreeNode(-500);

        System.out.println(new Solution().maxPathSum(root));
    }
}