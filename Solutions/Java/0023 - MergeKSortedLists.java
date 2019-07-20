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
        ListNode node = new SolutionPointer().mergeKLists(nodes);
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


/**
 *
 * Time:
 * Loop to get the min node : O(k), where k is the number of lists
 * Loop over each list : O(n)
 * complexity: O(n*k)
 *
 * Space:
 * We only use the same listnode : O(1)
 * If we don't want to change the original lists, we can create one list node each time : O(n)
 */
class SolutionPointer {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dumpHead = new ListNode(0);
        ListNode nodeMinValue = getMinNode(lists);
        ListNode nodeHeadOfMergedList = dumpHead;
        while (nodeMinValue != null) {
            nodeHeadOfMergedList.next = nodeMinValue;
            nodeHeadOfMergedList = nodeMinValue;
            nodeMinValue = getMinNode(lists);
        }
        return dumpHead.next;
    }

    ListNode getMinNode(ListNode[] lists) {
        int valueMin = Integer.MAX_VALUE;
        int indexValueMin = -1;
        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            if (null != cur) {
                if (cur.val < valueMin) {
                    indexValueMin = i;
                    valueMin = cur.val;
                }
            }
        }
        if (-1 != indexValueMin) {
            ListNode nodeMinValue = lists[indexValueMin];
            // move the cursor to the next element of the list containing min value
            lists[indexValueMin] = nodeMinValue.next;
            return nodeMinValue;
        }
        return null;
    }
}
