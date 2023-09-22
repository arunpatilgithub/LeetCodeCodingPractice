import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree104 {

    public static void main(String[] args) {

        System.out.println(maxDepth(BinaryTreeFromArray.createTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(maxDepthRecursion(BinaryTreeFromArray.createTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(maxDepth(BinaryTreeFromArray.createTree(new Integer[]{1,null,2})));
        System.out.println(maxDepthRecursion(BinaryTreeFromArray.createTree(new Integer[]{1,null,2})));

    }

    private static int maxDepthRecursion(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepthRecursion(root.left), maxDepthRecursion(root.right));
    }

    private static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int maxDepth = 0;

        while (!queue.isEmpty()) {

            int n = queue.size();

            for (int i=0; i<n;i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            maxDepth++;
        }

        return maxDepth;
    }
}
