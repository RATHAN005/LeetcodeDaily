class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = findMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;  
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    private boolean canFinish(int[] piles, int h, int speed) {
        int totalHours = 0;

        for (int pile : piles) {
            totalHours += (pile + speed - 1) / speed;
        }

        return totalHours <= h;
    }

    private int findMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        return max;
    }
}