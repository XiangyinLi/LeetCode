class Solution {
    public int stoneGameII(int[] piles) {
        int l = piles.length;
        int[][] dp = new int[l][l+1];
        // initial values
        for (int m = 1; m <= l; m++) {
            dp[l-1][m] = piles[l-1];
        }
        // prefix sum
        int[] preSum = new int[l+1];
        for (int i = 0; i < l; i++) {
            preSum[i+1] = preSum[i] + piles[i];
        }
        for (int n = l - 2; n >= 0; n--) {
            for (int m = l; m >= 1; m--) {
                // if (m >= stones left)
                if (2 * m >= l - n) {
                    dp[n][m] = preSum[l] - preSum[n];
                    continue;
                }
                int max = Integer.MIN_VALUE;
                for (int i = 1; i <= 2 * m; i++) {
                    if (n + i >= l) {
                        break;
          
                    }
                    max = Math.max(max, preSum[n+i] - preSum[n] - dp[n+i][Math.max(m,i)]);
                }
                dp[n][m] = max;
            }
        }
        return (preSum[l] - preSum[0] + dp[0][1]) / 2;
    }
}