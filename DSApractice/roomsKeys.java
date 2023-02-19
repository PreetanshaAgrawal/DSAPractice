import java.util.ArrayList;
import java.util.List;

public class roomsKeys {
    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // int n = rooms.size();
        // boolean flag = true;
        // for (int i = 0; i < n-1; i++) {
        //     if(!rooms.get(i).contains(i+1)){
        //         flag = false;
        //     }
        // }

        // // System.out.println(cnt);

        // return flag;
            return false;
        }

        public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
            int n = rooms.size();
            ArrayList<Integer>[] graph = new ArrayList[n];
            for(int i=0;i<n;i++){
                graph[i] = new ArrayList<>();
            }
            
            for(int i=0;i<n;i++){
                List<Integer> room = rooms.get(i);
                for(int j=0;j<room.size();j++){
                    {
                        graph[i].add(room.get(j));
                    }
                }
            }
            
            
            boolean vis[] = new boolean[n];
            
            dfs(graph,0,vis);
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    return false;
                }
            }
            
            return true;
        }
        
        void dfs(ArrayList<Integer>[] graph,int src,boolean[] vis){
            vis[src] = true;
            for(int nbr : graph[src]){
                if(!vis[nbr]){
                    dfs(graph,nbr,vis);
                }
            }
        }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<List<Integer>>();

        for (int i = 0; i < 4; i++) {
            rooms.add(new ArrayList<Integer>());
        }

        rooms.get(0).add(1);
        // rooms.get(0).add(3);
        rooms.get(1).add(2);
        // rooms.get(1).add(0);
        // rooms.get(1).add(1);
        rooms.get(2).add(3);
        rooms.get(3).add(0);
        // rooms.get(0).add(1);
        // rooms.get(0).add(1);
        // rooms.get(0).add(1);
        // rooms.get(0).add(1);

        System.out.println(canVisitAllRooms(rooms));
        
    }
}
