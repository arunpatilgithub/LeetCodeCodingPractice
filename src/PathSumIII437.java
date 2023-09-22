import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class PathSumIII437 {
    public static void main(String[] args) {
        //System.out.println(pathSum(BinaryTreeFromArray.createTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}),8));
        System.out.println(pathSum(BinaryTreeFromArray.createTree(new Integer[]{1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null, 1000000000}), 0));
        //System.out.println(pathSum(BinaryTreeFromArray.createTree(new Integer[]{10,10,null,29,null,10,null,10,null,10}),0));
    }

//    private static int pathSum(TreeNode root, long targetSum) {
//
//        if (root == null) {
//            return 0;
//        }
//
//        long longTargetSum = targetSum;
//
//        return dfs(root, targetSum) + pathSum(root.left,targetSum) + pathSum(root.right, longTargetSum);
//
//    }
//
//    private static int dfs(TreeNode node, long remainingSum) {
//
//        if (node == null) {
//            return 0;
//        }
//
//        int count = 0;
//
//        if (remainingSum == node.val) {
//            count++;
//        }
//
//        count = count + dfs(node.left, remainingSum- node.val);
//        count = count + dfs(node.right, remainingSum- node.val);
//
//        return count;
//    }



    private static int pathSum(TreeNode root, int targetSum) {

        AtomicInteger pathCount = new AtomicInteger(0);

        long longTargetSum = targetSum;
        pathFromStartNode(root, longTargetSum, pathCount);

        return pathCount.get();
    }

    private static void pathFromStartNode(TreeNode node,long remainingSum, AtomicInteger pathCount) {

        if (node == null) {
            return;
        }

        dfs (node, remainingSum, pathCount);

        pathFromStartNode(node.left, remainingSum, pathCount);
        pathFromStartNode(node.right, remainingSum, pathCount);

    }


    private static void dfs (TreeNode node, long remainingSum, AtomicInteger pathCount) {

        if (node == null) {
            return;
        }

        if (remainingSum == node.val) {
            pathCount.incrementAndGet();
        }

        dfs(node.left, remainingSum - node.val, pathCount);
        dfs(node.right, remainingSum - node.val, pathCount);
    }

}
//    private static int pathSum(TreeNode root, int sum) {
//        if (root == null) return 0;
//        // Start a path from current root, or move root to left/right child and start from there.
//        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//    }
//
//    private static int dfs(TreeNode node, int remainingSum) {
//        if (node == null) return 0;
//
//        // If current node's value matches the remaining sum, it's a valid path.
//        int count = (node.val == remainingSum) ? 1 : 0;
//
//        // Continue the search with reduced sum.
//        count += dfs(node.left, remainingSum - node.val);
//        count += dfs(node.right, remainingSum - node.val);
//
//        return count;
//    }

//    private static int pathSum(TreeNode root, int targetSum) {
//        AtomicInteger count = new AtomicInteger(0);
//        traverseAndStart(root, targetSum, count);
//        return count.get();
//    }
//
//    private static void traverseAndStart(TreeNode node, int target, AtomicInteger count) {
//        if (node == null) return;
//
//        // Start a new path from current node
//        dfs(node, target, count);
//
//        // Continue traversing the tree
//        traverseAndStart(node.left, target, count);
//        traverseAndStart(node.right, target, count);
//    }
//
//    private static void dfs(TreeNode node, int remainingSum, AtomicInteger count) {
//        if (node == null) return;
//
//        // Check if current node's value matches the remaining sum
//        if (node.val == remainingSum) {
//            count.incrementAndGet();
//        }
//
//        // Continue the sequence
//        dfs(node.left, remainingSum - node.val, count);
//        dfs(node.right, remainingSum - node.val, count);
//    }
//}


