package com.interview.dynamic;


public class CoinChanging {

	public int numberOfSolutions(int total, int[] coins){
		int[][] dp = new int[coins.length+1][total+1];
		for (int i = 0; i < dp.length; i++) {			
				dp[i][0]=1;
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j>=coins[i-1]) {
					dp[i][j] = dp[i-1][j]+dp[i][j-coins[i]];
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[coins.length][total];
	}
}
