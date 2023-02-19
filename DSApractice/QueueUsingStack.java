import java.util.Stack;

public class QueueUsingStack {
    
    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();

    static void MyQueue() {
        
    }
    
    static void push(int x) {

        // the oldest element is always on top of s1
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        
        s1.push(x);
        
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }

    }
    
    static int pop() {
        if(!s1.isEmpty()){
            int x = s1.peek();
            s1.pop()
            return x;
        }    

        return -1;
    }
    
    static int peek() {
        return s1.peek();
    }
    
    static boolean empty() {
        return s1.isEmpty();
    }
}
