import java.util.Random;

public class linked_list_random_node {
    ListNode head;
    Random r;
    public void Solution(ListNode h) {
        head = h;
        r = new Random();
    }
    public int getRandom() {
        ListNode curr = head;
        int count = 0;
        int res = 0;
        while(curr!=null){
            if(r.nextInt(count+1)==count){
                res = curr.val;
            }
            count++;
            curr = curr.next;
        }
        return res;
    }
} 
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
