import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees872 {

    public static void main(String[] args) {

        TreeNode root1 = BinaryTreeFromArray.createTree(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        TreeNode root2 = BinaryTreeFromArray.createTree(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});

        System.out.println(leafSimilar(root1, root2));

    }

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {


        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        getLeafsList(root1, leftList);
        getLeafsList(root2, rightList);

        return (leftList.equals(rightList));
    }

    private static void getLeafsList(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        getLeafsList(node.left, list);
        getLeafsList(node.right, list);

    }

}
