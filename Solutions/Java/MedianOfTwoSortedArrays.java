import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] nums1 = {1};
        int[] nums2 = {2,3,4,5,6,7,8};
        Solution solution = new Solution();
        Double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}

class Solution {
    double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int total = m + n;
        if (0 != total % 2)
            // if the number of the combined array is odd, just take the (m+n)/2 + 1 th element
            return findKth(A, B, total / 2 + 1);
        else {
            // if the number of the combined array is even, take the average of (m+n)/2 th element and (m+n)/2 + 1 th element
            double x = findKth(A, B, total / 2);
            double y = findKth(A, B, total / 2 + 1);
            return (x + y) / 2;
        }
    }

    private double findKth(int[] nums1, int[] nums2, int k) {

        int m = nums1.length;
        int n = nums2.length;

        if (m == 0) return nums2[k - 1];
        if (n == 0) return nums1[k - 1];
        if (k == 1) return Math.min(nums1[0], nums2[0]);

        int i = Math.min(m, k / 2);
        int j = Math.min(n, k / 2);
        if (nums1[i - 1] > nums2[j - 1]) {
            // if the k/2-th element "b" in nums2 is smaller than k/2-th element "a" in nums1,
            // as there are k/2 -1 elements before "b", k/2 -1 elements before "a",
            // in the combined array of nums1 and nums2, there may be at most k-2 elements in total smaller than "b"
            // that means "b" is at most the (k-1)-th element in the combined array
            // so all elements equal to or smaller than "b" are impossible to be k-th element of the combined array
            // we should remove them and shrink k
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        } else {
            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
        }
    }
}