import java.util.Stack;

public class postfixNotation {
    static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {

                int a = st.pop();
                int b = st.pop();
                int ans;
                if (tokens[i] == "+") {
                    ans = a + b;
                    st.push(ans);
                } 
                else if (tokens[i] == "-") {
                    ans = Math.abs(a-b);
                    st.push(ans);
                } else if (tokens[i] == "*") {
                    ans = a * b;
                    st.push(ans);
                } else if (tokens[i] == "/") {
                    if (a > b) {
                        ans = Math.round(a / b);
                    } else {
                        ans = Math.round(b / a);
                    }
                    st.push(ans);
                }
            }

            else {
                st.push(Integer.parseInt(tokens[i]));
            }

        }

        return st.pop();
    }

    public static void main(String[] args) {
        String tokens[] = { "4", "13", "5", "/", "+" };
        System.out.println(evalRPN(tokens));
    }
}
