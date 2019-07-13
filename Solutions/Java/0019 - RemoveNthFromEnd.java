package main;

public class Main {

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        System.out.println(new Solution().removeNthFromEnd(ln1, 2));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// O(L) time, O(1) space
class Solution {
    // two passes
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        // length to step forward
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        // no need to have two cursors
        first.next = first.next.next;
        return dummy.next;
    }
}

// O(L) time, O(1) space
class SolutionOnePass {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}