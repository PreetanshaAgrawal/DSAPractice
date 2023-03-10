import java.lang.StringBuilder;

public class AddBinary {
    static String solve(String a, String b){
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder str = new StringBuilder();
        while(i >= 0 || j >= 0){
            int sum = carry;

            if(i>=0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }

            carry = sum > 1 ? 1 : 0;

            str.append(sum%2);
        }
        if(carry != 0){
            str.append(carry);
        }
        return str.reverse().toString();
    }
}
