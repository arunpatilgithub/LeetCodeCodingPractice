import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class ValidateBinarySearchTree98 {

    public static void main(String[] args) {

//        System.out.println(isValidBST(BinaryTreeFromArray.createTree(new Integer[]{5,1,4,null,null,3,6})));
//        System.out.println(isValidBST(BinaryTreeFromArray.createTree(new Integer[]{2,1,3})));
//        System.out.println(isValidBST(BinaryTreeFromArray.createTree(new Integer[]{1,1})));
//        System.out.println(isValidBST(BinaryTreeFromArray.createTree(new Integer[]{0,null,-1})));
        System.out.println(isValidBST(BinaryTreeFromArray.createTree(new Integer[]{2147483647})));

    }

    private static boolean isValidBST(TreeNode root) {

        return recurseTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean recurseTree(TreeNode root, long minValue, long maxValue) {

        if (root == null) {
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }

        return recurseTree(root.left, minValue, root.val) && recurseTree(root.right, root.val,maxValue);

    }


}
