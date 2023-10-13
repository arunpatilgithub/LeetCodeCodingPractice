import util.BinaryTreeFromArray;
import util.BinaryTreeFromArray.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestElementInBST230 {

    static Integer kThMin;

    public static void main(String[] args) {

        System.out.println(kthSmallest(BinaryTreeFromArray.createTree(new Integer[]{5,3,6,2,4,null,null,1}),3));

    }

    private static int kthSmallest(TreeNode root, int k) {
        kThMin = 0;
        AtomicInteger counter = new AtomicInteger(0);
        dfs(root, counter, k);
        return kThMin;
    }

    private static void dfs(TreeNode treeNode, AtomicInteger counter, int k) {

        if (treeNode == null) {
            return;
        }

        dfs(treeNode.left, counter, k);

        counter.set(counter.incrementAndGet());

        if (k == counter.get()) {
            kThMin = treeNode.val;
            return;
        }

        dfs(treeNode.right, counter, k);



    }

}
