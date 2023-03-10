public class ReverseTheBits {
    static int getReverse(int n){
        int res =0;

        for(int i = 0; i < 32; i++){
            res <<= 1;
            if((n&1) == 1) res += 1;
            n >>= 1;
        }
        return res;
    }

    // Power of two
    static boolean powOfTwo(int n){
        return n > 0 && (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println((3&1));
    }
}
