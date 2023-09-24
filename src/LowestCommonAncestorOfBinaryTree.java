import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

public class LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args) {

        System.out.println(lowestCommonAncestor(BinaryTreeFromArray.createTree(new Integer[]{3,5,1,6,2,0,8,null,null,
                7,4}), new TreeNode(6), new TreeNode(4)).val);

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;

    }

}
