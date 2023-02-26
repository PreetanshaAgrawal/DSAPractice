public class capacity_D_days {

    // the isValid function takes arguments: weights,days,mid value. 
    // If it returns true i.e. the ship can carry that amount of weights in that amount of days then we will assign ans to mid and right to mid-1 , if not i.e. it can't carry that amount of weight in that weight so we increase our left to mid+1.

    static boolean isValid(int mid, int weights[], int days){
        int total_weight = 0, day = 1;
        boolean flag = true;

        for (int i = 0; i < weights.length; i++) {
            if(weights[i] > mid){
                flag = false;
                break;
            }

            if(total_weight + weights[i] <= mid){
                total_weight += weights[i];
            }
            else{
                day++;
                total_weight = weights[i];
            }   
        }

        if(flag == false) return false;

        return day <= days;
    }


    static int shipWithinDays(int days, int weights[]) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < weights.length; i++) {
            left = Math.min(left, weights[i]);
            right += weights[i];
        }

        while(left < right){
            int mid = (left + right) / 2;

            if(isValid(mid, weights, days)){
                right = mid;
            }

            else{
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(days, weights));
    }
}
