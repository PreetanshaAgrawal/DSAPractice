import java.util.Arrays;

public class WT1_q1_countTriplets {
    static int countTriplets(int nums[], int k, int n){
        
        if(n < 3) return 0;
        
        Arrays.sort(nums);
        int count =0;
        for(int i = 0; i < n-2; i++){
            int l = i+1;
            int r = n-1;

            while(l < r){
                int sum = nums[i] + nums[r] + nums[l];
                if(sum < k){
                    count += r - l;
                    l++; 
                }
                else if(sum >= k){
                    r--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {5,4,1,3,7};
        int n = nums.length;
        int k = 12;

        System.out.println(countTriplets(nums, k, n));
    }
}
