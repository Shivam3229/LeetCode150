class Solution {

    private int findDays(int[] weights, int capacity) {
        int days = 1;
        int load = 0;

        for (int weight : weights) {
            if (load + weight <= capacity) {
                load += weight;
            } else {
                days++;
                load = weight;
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int requiredDays = findDays(weights, mid);

            if (requiredDays <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}