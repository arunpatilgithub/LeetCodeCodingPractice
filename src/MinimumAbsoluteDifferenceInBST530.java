import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

public class MinimumAbsoluteDifferenceInBST530 {

    static Integer minDiff;

    public static void main(String[] args) {
        System.out.println(getMinimumDifference(BinaryTreeFromArray.createTree(new Integer[]{4,2,6,1,3})));
        System.out.println(getMinimumDifference(BinaryTreeFromArray.createTree(new Integer[]{1,0,48,null,null,12,49})));
        System.out.println(getMinimumDifference(BinaryTreeFromArray.createTree(new Integer[]{1,null,5,3})));
    }

    private static int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        inorder(root,Integer.MIN_VALUE);
        return minDiff;
    }

    private static int inorder(TreeNode root, int prev) {

        if(root == null) {
            return prev;
        }

        prev = inorder(root.left,prev);

        if (prev != Integer.MIN_VALUE) {
            minDiff = Math.min(minDiff, root.val - prev);
        }

        prev = root.val;

        prev = inorder(root.right, prev);
        return prev;
    }


}
