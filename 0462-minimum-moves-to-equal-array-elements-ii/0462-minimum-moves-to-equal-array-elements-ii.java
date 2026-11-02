class Solution {

    public int minMoves2(int[] nums) {
        long answer = Long.MAX_VALUE;

        for (int candidate : nums) {
            long moves = 0;

            for (int number : nums) {
                moves += Math.abs((long) number - candidate);
            }

            answer = Math.min(answer, moves);
        }

        return (int) answer;
    }
}