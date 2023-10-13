import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

public class ValidateBinarySearchTree98 {

    public static void main(String[] args) {

        //System.out.println(isValidBST(BinaryTreeFromArray.createTree(new Integer[]{5,1,4,null,null,3,6})));
        System.out.println(isValidBST(BinaryTreeFromArray.createTree(new Integer[]{2,1,3})));

    }

    private static boolean isValidBST(TreeNode root) {

        return dfs(root, null, null);
    }

    private static boolean dfs(TreeNode node, Integer left, Integer right) {

        if (node == null) {
            return true;
        }

        if ((left != null && node.val <= left) || (right != null && node.val >= right)) {
            return false;
        }

        return dfs(node.left, left, node.val) && dfs(node.right, node.val, right);
    }

}
