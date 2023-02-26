import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSZigzagBT {
        public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            if (root == null)
                return new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            List<List<Integer>> ans = new ArrayList<>();
            q.offer(root);
            boolean leftToRight = true;

            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> subAns = new ArrayList<>();

                while (size-- > 0) {
                    TreeNode temp = q.poll();

                    if (leftToRight)
                        subAns.add(temp.val);
                    else
                        subAns.add(0, temp.val);

                    if (temp.left != null)
                        q.offer(temp.left);
                    if (temp.right != null)
                        q.offer(temp.right);
                }
                leftToRight = !leftToRight;
                ans.add(subAns);
            }

            return ans;
        }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}