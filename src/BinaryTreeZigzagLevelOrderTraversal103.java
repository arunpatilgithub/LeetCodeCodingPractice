import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal103 {

    public static void main(String[] args) {

        zigzagLevelOrder(BinaryTreeFromArray.createTree(new Integer[]{3,9,20,null,null,15,7})).stream().forEach(System.out::println);
        //zigzagLevelOrder(BinaryTreeFromArray.createTree(new Integer[]{1})).stream().forEach(System.out::println);
        //zigzagLevelOrder(BinaryTreeFromArray.createTree(new Integer[]{1,2,3,4,null,null,5})).stream().forEach(System.out::println);
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        Stack<TreeNode> leftToRightStack = new Stack<>();
        Stack<TreeNode> rightToLeftStack = new Stack<>();
        leftToRightStack.push(root);

        boolean rightToLeftOrderForChildren = false;
        while (!leftToRightStack.isEmpty() || !rightToLeftStack.isEmpty()) {

            List<Integer> rowList = new ArrayList<>();

           if (rightToLeftOrderForChildren) {

               while (!rightToLeftStack.isEmpty()) {
                   TreeNode currNode = rightToLeftStack.pop();
                   rowList.add(currNode.val);

                   if (currNode.right != null) {
                       leftToRightStack.push(currNode.right);
                   }

                   if (currNode.left != null) {
                       leftToRightStack.push(currNode.left);
                   }
               }

               rightToLeftOrderForChildren = false;
               output.add(rowList);

           } else {
               while (!leftToRightStack.isEmpty()) {

                   TreeNode currNode = leftToRightStack.pop();
                   rowList.add(currNode.val);

                   if (currNode.left != null) {
                       rightToLeftStack.push(currNode.left);
                   }

                   if (currNode.right != null) {
                       rightToLeftStack.push(currNode.right);
                   }

               }

               rightToLeftOrderForChildren = true;
               output.add(rowList);
           }

        }

        return output;

    }

}
