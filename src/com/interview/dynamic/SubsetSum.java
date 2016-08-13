package com.interview.dynamic;

public class SubsetSum {
	public boolean subsetSum(int input[], int total){
		boolean[][] T = new boolean[input.length+1][total+1];
		for (int i = 0; i < input.length; i++) {
			T[i][0] = true;
		}
		
		for (int i = 1; i <= input.length; i++) {
			for (int j = 1; j <= total; j++) {
				if(j < input[i-1]){
					T[i][j] = T[i-1][j];
				}else{
					T[i][j] = T[i-1][j]||T[i-1][j-input[i-1]];
				}
			}
		}
		return T[input.length][total];
	}
	public static void main(String[] args) {
		SubsetSum subsetSum = new SubsetSum();
		int arr[] = {2,3,7,8};
		System.out.println(subsetSum.subsetSum(arr, 11));
	}
}
