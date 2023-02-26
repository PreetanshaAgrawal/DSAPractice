import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ipo_LC {
    static int solveRec(int w, int k, int profits[], int capital[], int usedCapital[]){
        if(k==0){
			return 0;
		}
		
		int n=capital.length,ans=0;
		for(int i=0;i<n;i++){
			if((usedCapital[i]==0) && (w-capital[i]>=0)){
				usedCapital[i]=1;
				int tempans=solveRec(w+profits[i],k-1, profits,capital,usedCapital);
				ans=Math.max(ans,profits[i]+tempans);
				usedCapital[i]=0;
            }
		}
		return ans;    
    }


    static int solve(int w, int k, int profit[], int capital[]){
        int n = capital.length;

        int usedCapital[] = new int[n];

        return solveRec(w, k, profit, capital, usedCapital);

    }

    static int greedy_approach(int k,int w,int[] profits,int[] capital){
        if(k==0){
            return w;
        }

        //preprocessing the profits and capitals
        //sorting the temparr according decreasing capital
        ArrayList<Integer[]> temparr=new ArrayList<Integer[]>();
		Queue<Integer>maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder()); 
		

        int n=capital.length;
        for(int i=0;i<n;i++){
            temparr.add(new Integer[]{capital[i],profits[i]});
        }

        Collections.sort(temparr,new mycomparator());  //sorting according to minimum capital
		
		int i=0;
		
		while(k>0){
			
			while( (i<n) && (w-temparr.get(i)[0]>=0)){
				maxHeap.offer(temparr.get(i)[1]);
				i++;
			}
			
			if(maxHeap.isEmpty()==true){
				break;
			}
			
			w+=maxHeap.peek();
			maxHeap.poll();
			k-=1;
		}
		
		return w;
    }

    public static void main(String[] args) {
        int w =0, k = 2;

        int profit[] = {1,2,3};
        int capital[] = {0,1,1};

        // System.out.println(solve(w, k, profit, capital));
        System.out.println(greedy_approach(k, w, profit, capital));
    }
}

class mycomparator implements Comparator<Integer[]>{
	public int compare(Integer[] arr1,Integer[] arr2){
		return arr1[0]-arr2[0];
	}
}