import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CountGoodNodesInBinaryTree1448 {

    public static void main(String[] args) {

        System.out.println(goodNodes(BinaryTreeFromArray.createTree(new Integer[]{3,1,4,3,null,1,5})));
        System.out.println(goodNodes(BinaryTreeFromArray.createTree(new Integer[]{3,3,null,4,2})));

    }

    private static int goodNodes(TreeNode root) {


        return preOrder(root, root.val);

    }


    private static int preOrder(TreeNode root, int maxRootValSoFar) {

        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val >= maxRootValSoFar) {
            count++;
            maxRootValSoFar = root.val;
        }
        count = count + preOrder(root.left, maxRootValSoFar);
        count = count + preOrder(root.right, maxRootValSoFar);

        return count;
    }

    private static int goodNodes2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        AtomicInteger goodNodesCount = new AtomicInteger(0);
        preOrderCall(root, goodNodesCount, root.val);
        return goodNodesCount.get();
    }

    private static void preOrderCall(TreeNode root, AtomicInteger goodNodesCount, int maxRootValSoFar) {


        if (root == null) {
            return;
        }

        if (root.val >= maxRootValSoFar) {
            goodNodesCount.incrementAndGet();
            maxRootValSoFar = root.val;
        }

        preOrderCall(root.left, goodNodesCount, maxRootValSoFar);
        preOrderCall(root.right, goodNodesCount, maxRootValSoFar);

    }

}
