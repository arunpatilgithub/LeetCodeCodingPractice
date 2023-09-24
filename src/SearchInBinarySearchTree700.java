import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

public class SearchInBinarySearchTree700 {

    public static void main(String[] args) {
        System.out.println(searchBST(BinaryTreeFromArray.createTree(new Integer[]{4,2,7,1,3}),-4));
    }

    private static TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }


    }

}
