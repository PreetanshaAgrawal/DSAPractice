import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class existingPathTwo {
    static void prepareAdjacency(ArrayList<ArrayList<Integer>> adj, int edges[][]){

        for (int i = 0; i < edges.length; i++) {
            
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

    }

    static void printAdj(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("List for "+ i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.println(adj.get(i).get(j));
            }
        }
    }

    static boolean validPath(int edges[][], int n, int src, int des){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        prepareAdjacency(adj, edges);
        // printAdj(adj);

        if(adj.get(src).contains(des)) return true;

        boolean vis[] = new boolean[n];
        Arrays.fill(vis, false);

        // bfs
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(src);
        vis[src] = true;


        // elements only connected to the source
        while(!q.isEmpty()){
            int front = q.peek();
            q.poll();

            System.out.println(front);
            if(front == des) return true;

            for (Integer i : adj.get(front)) {
                if(!vis[i]){
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
        return false;
    }


    // bfs code
    // static int bfs(int n, ArrayList<ArrayList<Integer>> adj , boolean vis[], int des){
    //     Queue<Integer> q = new LinkedList<Integer>();

    //     q.add(n);
    //     vis[n] = true;


    //     while(!q.isEmpty()){
    //         int front = q.peek();
    //         q.poll();

    //         System.out.println(front);
    //         if(front == des) return 1;

    //         for (Integer i : adj.get(front)) {
    //             if(!vis[i]){
    //                 q.add(i);
    //                 vis[i] = true;
    //             }
    //         }
    //     }
    //     return 0;
    // }
    public static void main(String[] args) {
        int edges[][] = {
            {0,1},
            {0,2},
            {3,4},
            {4,5},
            {5,3}
        };
        int n = 6;

        System.out.println(validPath(edges, n, 0, 5));
    }
}
