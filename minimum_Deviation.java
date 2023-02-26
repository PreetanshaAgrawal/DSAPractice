import java.util.TreeSet;

public class minimum_Deviation {
    
    static int minDeviation(int nums[]){
        
        // ordered set to set the elements in sorted order
        TreeSet<Integer> ts = new TreeSet<>();

        for(int num: nums){
            ts.add((num & 1) == 0 ? num : num*2);
        }

        // System.out.println(ts);

        boolean flag = true;
        int ans = ts.last() - ts.first();

        while(flag && ts.size() > 1){
            flag = false;
            int last = ts.pollLast();
            int first = ts.first();

            while(last % 2 == 0 && last/2 >= first){
                last = last/2;
                flag = true;
            }

            if(!flag && last % 2 == 0){
                last = last /2;
                flag = true;
            }
            
            // because odd elements are already dealt with only once because we have to divide it by 2 and hence getting the same element 
            ts.add(last);

            ans = Math.min(ans, ts.last() - ts.first());
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {2,10,8};

        System.out.println(minDeviation(nums));
    }
}
