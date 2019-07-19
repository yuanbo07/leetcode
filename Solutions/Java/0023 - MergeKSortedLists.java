import java.util.*;

public class Main {

    public static void main(String[] args) {
        // first linkedlist
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(2);
        ListNode n13 = new ListNode(4);
        n11.next = n12;
        n12.next = n13;
        // second linkedlist
        ListNode n21 = new ListNode(1);
        ListNode n22 = new ListNode(3);
        ListNode n23 = new ListNode(4);
        n21.next = n22;
        n22.next = n23;
        // third linkedlist
        ListNode n31 = new ListNode(3);
        ListNode n32 = new ListNode(5);
        ListNode n33 = new ListNode(6);
        n31.next = n32;
        n32.next = n33;
        ListNode[] nodes = {n11,n21,n31};
        ListNode node = new SolutionBruteForce().mergeKLists(nodes);
        while (null != node) {
            System.out.println(node);
            node = node.next;
        }
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

     @Override
    public String toString() {
         return String.valueOf(val);
     }
}

/**
 *
 * Time complexity : O(nlogn) <- loop over list O(n), sort O(nlogn)
 * Space complexity: O(n) <- list of n elements
 */
class SolutionBruteForce {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodeValues = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                nodeValues.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(nodeValues);
        ListNode dumpHead = new ListNode(-1);
        ListNode head = dumpHead;
        for (int i : nodeValues) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return dumpHead.next;
    }
}
