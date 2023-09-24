import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {

    public static void main(String[] args) {

 //       System.out.println(rightSideView(BinaryTreeFromArray.createTree(new Integer[]{1,2,3,4})));
        System.out.println(rightSideView(BinaryTreeFromArray.createTree(new Integer[]{1,2,3,null,5,null,4})));
//        System.out.println(rightSideView(BinaryTreeFromArray.createTree(new Integer[]{1,null,3})));
        System.out.println(rightSideView(BinaryTreeFromArray.createTree(new Integer[]{})));

    }

    private static List<Integer> rightSideView(TreeNode root) {

        List<Integer> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int l = queue.size();
            TreeNode lastPopped = null;
            for (int i=0; i<l; i++) {
                lastPopped = queue.poll();

                if (lastPopped.left != null) {
                    queue.add(lastPopped.left);
                }

                if (lastPopped.right != null) {
                    queue.add(lastPopped.right);
                }

            }
            output.add(lastPopped.val);

        }

        return output;
    }



}
