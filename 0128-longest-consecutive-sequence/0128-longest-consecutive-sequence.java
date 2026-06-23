class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : nums) {

            if (!set.contains(num))
                continue;

            set.remove(num);

            int left = num - 1;
            while (set.remove(left)) {
                left--;
            }

            int right = num + 1;
            while (set.remove(right)) {
                right++;
            }

            max = Math.max(max, right - left - 1);
        }

        return max;
    }
}