import util.BinaryTreeFromArray.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/**
 * Refer @see <a href="https://www.youtube.com/watch?v=PbPS460rbMo&ab_channel=NikhilLohia"> this video</a>
 * with great explanation.
 */
public class ConstructBinaryTreeFromPreorderInorder105 {

    public static void main(String[] args) {

        buildTree(new int[]{8,2,7,1,9,3,6}, new int[]{7,2,1,8,3,9,6});
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {


        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i=0; i< inorder.length; i++) {
            inOrderMap.put(inorder[i],i);
        }

        return recurse(preorder, inOrderMap, 0, 0, inorder.length-1);

    }

    private static TreeNode recurse(int[] preorder, Map<Integer, Integer> inOrderMap, int rootIndex,
                                    int inOrderLeftBoundary, int inorderRightBoundary) {

        TreeNode root = new TreeNode(preorder[rootIndex]);

        int partitionPosition = inOrderMap.get(preorder[rootIndex]);

        if (partitionPosition > inOrderLeftBoundary) {
            root.left = recurse(preorder, inOrderMap, rootIndex+1, inOrderLeftBoundary, partitionPosition-1);
        }

        if (partitionPosition < inorderRightBoundary) {
            root.right = recurse(preorder, inOrderMap, rootIndex+partitionPosition-inOrderLeftBoundary+1, partitionPosition+1, inorderRightBoundary);
        }

        return root;
    }

}
