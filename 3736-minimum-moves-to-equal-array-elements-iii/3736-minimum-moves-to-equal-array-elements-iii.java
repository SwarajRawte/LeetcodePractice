class Solution {

    public int minMoves(int[] nums) {
        int max = nums[0];

        for (int n : nums) {
            max = Math.max(max, n);
        }

        int mv = 0;

        for (int n : nums) {
            mv += max - n;
        }

        return mv;
    }
}