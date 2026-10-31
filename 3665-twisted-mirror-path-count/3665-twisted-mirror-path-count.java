class Solution {

    private static final int MOD = 1_000_000_007;
    private static final int MOVE_RIGHT = 0;
    private static final int MOVE_DOWN = 1;
    private static final int START = 2;

    private int[][] cityMap;
    private int totalRows;
    private int totalColumns;

    // dp[row][column][direction]
    private int[][][] dp;

    public int uniquePaths(int[][] cityMap) {
        this.cityMap = cityMap;
        this.totalRows = cityMap.length;
        this.totalColumns = cityMap[0].length;

        dp = new int[totalRows][totalColumns][3];

        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < totalColumns; c++) {
                Arrays.fill(dp[r][c], -1);
            }
        }

        return countWays(0, 0, START);
    }

    private int countWays(int currentRow, int currentColumn, int direction) {

        if (currentRow >= totalRows || currentColumn >= totalColumns) {
            return 0;
        }

        if (currentRow == totalRows - 1 &&
            currentColumn == totalColumns - 1) {
            return 1;
        }

        if (dp[currentRow][currentColumn][direction] != -1) {
            return dp[currentRow][currentColumn][direction];
        }

        long paths;

        if (cityMap[currentRow][currentColumn] == 0) {

            long rightPaths =
                    countWays(currentRow, currentColumn + 1, MOVE_RIGHT);

            long downPaths =
                    countWays(currentRow + 1, currentColumn, MOVE_DOWN);

            paths = (rightPaths + downPaths) % MOD;

        } else if (direction == MOVE_RIGHT) {

            paths = countWays(currentRow + 1, currentColumn, MOVE_DOWN);

        } else {

            paths = countWays(currentRow, currentColumn + 1, MOVE_RIGHT);
        }

        dp[currentRow][currentColumn][direction] = (int) paths;
        return (int) paths;
    }
}