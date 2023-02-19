import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ExistingPath{

    static boolean validPath(int n, int[][] edges, int source, int destination){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);

        prepareAdjacency(adj, edges);
        printAdj(adj);
        for (int i = source; i < n; i++) {
            if(!visited[source]){
                bfs(i, adj, visited);
            }
        }

        return visited[destination];
    }

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
            for (int j = 0; j < adj.size(); j++) {
                System.out.println(adj.get(i).get(j));
            }
        }
    }
    static void bfs(int n, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(n);
        visited[n] = true;

        while(!q.isEmpty()){
            int front = q.peek();
            q.poll();

            for (Integer i : adj.get(front)) {
                
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }


    static boolean validPath2(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        int i, j;
        
        for(i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
		
        if(graph[source].contains(destination)){  
            return true;
        }
       
        Queue<Integer> queue = new LinkedList<Integer>();
        int N, current;
        queue.offer(source);
        visited[source] = true;
       
        while(!queue.isEmpty()){
            N = queue.size();
            current = queue.poll();
            if(current == destination){
                    return true;
            }
                
            for(Integer neighbor : graph[current]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
       
        return false;   
    }


    public static void main(String[] args) {
        int edges[][] = {
            {0,1},
            {1,2},
            {2,0}
        };

        System.out.println(validPath(3, edges, 0, 2));
    }
}
