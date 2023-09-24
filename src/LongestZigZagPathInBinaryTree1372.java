import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class LongestZigZagPathInBinaryTree1372 {

    //private static int globalMax = 0;

    public static void main(String[] args) {

        System.out.println(longestZigZag(BinaryTreeFromArray.createTree(new Integer[]{1,null,2,3,4,null,null,5,6,null
                ,7,null,null,null,8})));
        //globalMax = 0;
        System.out.println(longestZigZag(BinaryTreeFromArray.createTree(new Integer[]{1,1,1,null,1,null,null,1,1,
                null,1})));
        //globalMax = 0;
        System.out.println(longestZigZag(BinaryTreeFromArray.createTree(new Integer[]{1})));

    }

    private static int longestZigZag(TreeNode root) {

        if (root == null) {
            return 0;
        }

        AtomicInteger globalMax = new AtomicInteger(0);

        dfs(root, true, 0, globalMax);  // start moving right
        dfs(root, false, 0, globalMax);  // start moving left

        return globalMax.get();

    }

    private static void dfs(TreeNode node, boolean movingRight, int currentLength, AtomicInteger globalMax) {

        if (node == null) {
            return;
        }

        globalMax.set(Math.max(globalMax.get(), currentLength));

        if (movingRight) {
            dfs(node.right, !movingRight, currentLength + 1, globalMax);
            dfs(node.left, movingRight, 1, globalMax);  // Restart the count for opposite direction
        } else {
            dfs(node.left, !movingRight, currentLength + 1, globalMax);
            dfs(node.right, movingRight, 1, globalMax);  // Restart the count for opposite direction
        }

    }

}
