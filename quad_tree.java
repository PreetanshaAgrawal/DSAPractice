import java.util.LinkedList;
import java.util.Queue;
import java.util.Pair;

public class quad_tree {
    static Node construct(int grid[][]){
        int n = grid.length;
        Queue<Pair<Node, int[]>> q = new LinkedList<>();
        Node root = new Node();
        q.add(new Pair<>(root, new int[] {0, 0, n}));
        while (!q.isEmpty()) {
            Pair<Node, int[]> p = q.poll();
            Node node = p.getKey();
            int[] bounds = p.getValue();
            int r = bounds[0], c = bounds[1], s = bounds[2];
            int cur = isValid(r, c, s, grid);
            if (cur > 0) {
                node.val = cur == 2;
                node.isLeaf = true;
            } else {
                node.val = false;
                node.isLeaf = false;
                node.topLeft = new Node();
                node.topRight = new Node();
                node.bottomLeft = new Node();
                node.bottomRight = new Node();
                q.add(new Pair<>(node.topLeft, new int[] {r, c, s / 2}));
                q.add(new Pair<>(node.topRight, new int[] {r, c + s / 2, s / 2}));
                q.add(new Pair<>(node.bottomLeft, new int[] {r + s / 2, c, s / 2}));
                q.add(new Pair<>(node.bottomRight, new int[] {r + s / 2, c + s / 2, s / 2}));
            }
        }
        return root; 
    }
    static int isValid(int r, int c, int s, int[][] grid) {
        int num = grid[r][c];
        for (int i = r; i < r + s; i++) {
            for (int j = c; j < c + s; j++) {
                if (num != grid[i][j]) {
                    return 0;
                }
            }
        }
        return num + 1;
    }
}
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};