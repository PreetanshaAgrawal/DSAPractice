public class WT1_q2_TrailingZeros {
    
    // factorial
    // static int factorialOfMid(int mid) {
    //     // if(mid == 2 || mid == 1) return mid;

    //     // return mid * factorialOfMid(mid-1);
    //     int ans = 1;
    //     for(int i =1; i<= mid; i++){
    //         ans = ans * i;
    //     }
    //     return ans;
    // }
 
    // // count of trailing zeros
    // static int countTrailingZeros(int midFact) {
    //     int count = 0;

    //     while(midFact % 10 == 0){
    //         count ++;
    //         midFact /= 10;
    //     }

    //     return count;
    // }


    public static int traillingZeros(int n){
        int l = 0;
        int r = 5*n;

        if(n==1) return 5;

        
        while(l < r){
            int mid = l + (r-l)/2;

            // int midFact = factorialOfMid(mid);
            // int countOfZeros = countTrailingZeros(midFact);

            // System.out.println("For " + mid + " : The Factorial is : " + midFact);

            if(check(mid, n)){
                r = mid;
            }

            else{
                l = mid+1;
            }
        }

        return l;
    }

    static boolean check(int mid, int n){
        int temp = mid, f = 5;
        int count =0;

        while(temp >= f){
            count += temp/f;
            f = f*5;
        }
        return (count >= n);
    }
    public static void main(String[] args) {
        System.out.println(traillingZeros(3));
    }
}
