package com.interview.dynamic;

public class Knapsack01 {

	public int bottomUpDP(int val[], int wt[], int W){
		 int dp[][] = new int[val.length+1][W+1];
		 for (int i = 0; i < val.length; i++) {
			for (int j = 0; j <= W; j++) {
				if (i==0||j==0) {
					dp[i][j] = 0;
				}
				if (j >= wt[i-1]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-wt[i-1]]+val[i-1]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
		return dp[val.length][W];
	}
}
