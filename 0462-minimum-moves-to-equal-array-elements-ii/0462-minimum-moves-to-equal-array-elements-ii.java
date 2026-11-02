import java.util.Arrays;

class Solution {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int m = nums[nums.length / 2];
        long mv = 0;

        for (int n : nums) {
            mv += Math.abs((long) n - m);
        }

        return (int) mv;
    }
}