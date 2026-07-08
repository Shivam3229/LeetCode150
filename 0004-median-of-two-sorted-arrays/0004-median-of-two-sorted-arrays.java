class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while (low <= high) {

            // Partition of first array
            int cut1 = low + (high - low) / 2;

            // Partition of second array
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            // Left and Right values around the partition
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {

                // Even total elements
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }

                // Odd total elements
                return Math.max(l1, l2);
            }

            // Move left
            else if (l1 > r2) {
                high = cut1 - 1;
            }

            // Move right
            else {
                low = cut1 + 1;
            }
        }

        return 0;
    }
}