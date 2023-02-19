public class robberyHouse {
    static int solver(int[] nums){
        int n = nums.length;
        // int dp[] = new int[n];

        int sum = 0;
        int sum1 = nums[0];

        for(int i=1; i<n; i++){
            int newSum1 = sum + nums[i];
            int newSum = Math.max(sum, sum1); 
            
            sum = newSum;
            sum1 = newSum1;
        }

        return Math.max(sum, sum1);

    }
    public static void main(String[] args) {
        int nums[] = {2,1,1,2};
        System.out.println(solver(nums));
    }
}
