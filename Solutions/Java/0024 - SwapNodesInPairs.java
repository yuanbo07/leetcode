import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // first linkedlist
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode head = new Solution().swapPairs(n1);
        while (null != head) {
            System.out.println(head);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        p2.next = p1;
        if (null != p3) {
            p1.next = swapPairs(p3);
        } else {
            p1.next = null;
        }
        return p2;
    }
}

/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class SolutionIterative {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (null != current.next && null != current.next.next) {
            swap(current);
            current = current.next.next;
        }
        return dummy.next;
    }

    private void swap(ListNode pre) {
        ListNode dummy = pre.next;
        pre.next = dummy.next;
        dummy.next = dummy.next.next;
        pre.next.next = dummy;
    }
}
