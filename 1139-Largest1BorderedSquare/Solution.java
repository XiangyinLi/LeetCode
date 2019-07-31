class Solution {
    // dp数组代表先手方能赢的值
    private int[][] dp;
    private int[] presum;

    public int stoneGameII(int[] piles) {
        presum = new int[piles.length+1];
        dp = new int[piles.length][piles.length+1];
        for (int i = 0; i < piles.length; i++) {
            presum[i+1] = piles[i] + presum[i];
        }
        return (presum[piles.length] + helper(0, 1, piles)) / 2;
    }

    private int helper(int n, int m, int[] piles) {
        // 从cache中取值
        if (dp[n][m] != 0) {
            return dp[n][m];
        }
        int max = Integer.MIN_VALUE;
        // n+i <= piles.length : 不能超出piles的范围
        for (int i = 1; i <= 2*m && n+i <= piles.length; i++) {
            // 将石头全部拿走
            if (n+i == piles.length) {
                max = Math.max(presum[n+i] - presum[n], max);
            } else {
                max = Math.max(presum[n+i] - presum[n] - helper(n+i, Math.max(m,i), piles), max);
            }
        }
        dp[n][m] = max;
        return max;
    }
}