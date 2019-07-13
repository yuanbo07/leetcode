public class Main {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
//        ListNode a3 = new ListNode(3);
        a1.next = a2;
//        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        Solution solution = new Solution();
        solution.addTwoNumbers(a1, b1);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headSum = new ListNode(0);
        ListNode p = l1, q = l2, curr = headSum;
        int carry = 0;
        while (p != null || q != null) { // Time: O(max(m,n)), space:O(max(m,n))
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next; // advance 1 position in sum linkedlist
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return headSum.next;
    }
}
