public class buySellCooldown {
    static int maxProfit(int prices[]){
        // int sum =0;

        // for (int i = 0; i < profit.length - 1; i++) {
        //     int j;
        //     for (j = i+1; j < profit.length; j++) {
        //         if(profit[j] > profit[i]){
        //             sum += (profit[j] - profit[i]);
        //             break;
        //         }
        //     }
        //     i = j+1;
        // }

        // return sum;


        int profit1 = 0, profit2 = 0;   
        for(int i = 1; i < prices.length; ++i) {
            int prev = profit1;
            profit1 = Math.max(profit1 + (- prices[i-1] + prices[i]), profit2);
            profit2 = Math.max(prev, profit2);
        }
        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        int profit[] = {1,2,3,0,2};
        System.out.println(maxProfit(profit));
    }
}
