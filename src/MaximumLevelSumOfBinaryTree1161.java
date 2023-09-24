import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfBinaryTree1161 {

    public static void main(String[] args) {

        System.out.println(maxLevelSum(BinaryTreeFromArray.createTree(new Integer[]{1,7,0,7,-8,null,null})));
        System.out.println(maxLevelSum(BinaryTreeFromArray.createTree(new Integer[]{989,null,10250,98693,-89388,null,null,null,-32127})));

    }

    private static int maxLevelSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int minLevelWithMaxSum = 1;
        int maxSum = root.val;
        int currentLevel=1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int l = queue.size();
            int sum = 0;

            for (int i =0; i<l; i++) {

                TreeNode lastNode = queue.poll();
                sum = sum + lastNode.val;

                if (lastNode.left != null) {
                    queue.add(lastNode.left);
                }

                if (lastNode.right != null) {
                    queue.add(lastNode.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                minLevelWithMaxSum = currentLevel;
            }

            currentLevel++;


        }

        return minLevelWithMaxSum;
    }

}
