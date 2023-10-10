import util.BinaryTreeFromArray.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


//FIXME: Incomplete code
public class ConstructBinaryTreeFromPreorderInorder105 {

    public static void main(String[] args) {

        buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {

        int mid = 0;
        while (preorder[0] != inorder[mid]) {
            mid++;
        }

        TreeNode root = new TreeNode(inorder[mid]);
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);




        return root;

    }

}
