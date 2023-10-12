import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree637 {

    public static void main(String[] args) {

        //averageOfLevels(BinaryTreeFromArray.createTree(new Integer[]{3,9,20,null,null,15,7})).stream().forEach(System.out::println);
        averageOfLevels(BinaryTreeFromArray.createTree(new Integer[]{3,9,20,15,7})).stream().forEach(System.out::println);

    }

    private static List<Double> averageOfLevels(TreeNode root) {

        List<Double> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            double sum = 0.0;
            int l = queue.size();
            int i=0;
            while (i<l) {
                TreeNode currNode = queue.poll();
                sum = sum + currNode.val;

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
                i++;
            }

            output.add(sum/i);

        }

        return output;

    }

}
