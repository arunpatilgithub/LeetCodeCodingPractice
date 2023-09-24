import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

public class DeleteNodeInBST450 {

    public static void main(String[] args) {
        System.out.println(deleteNode(BinaryTreeFromArray.createTree(new Integer[]{5,3,6,2,4,null,7}),3));
    }

    private static TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.right != null) {
                root.val = getSuccessor(root);
                //Now delete the duplicate node
                root.right = deleteNode(root.right, root.val);
            }
            else {
                root.val = getPredecessor(root);
                //Now delete the duplicate node
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;

    }

    private static int getSuccessor(TreeNode root) {

        root = root.right;
        while (root.left != null){
            root = root.left;
        }
        return root.val;
    }

    private static int getPredecessor(TreeNode root) {

        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;

    }

}
