package com.interview.dynamic;

public class LongestIncreasingSubsequence {
	public int logestIncreasingSubsequence(int[] arr){
		int[] T = new int[arr.length];
		int[] actualSolution = new int[arr.length];
		
		for (int i = 0; i < T.length; i++) {
			T[i] = 1;
			actualSolution[i] = i;
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if(T[j]+1 > T[i]){
						T[i] = T[j]+1;
						actualSolution[i] = j;
					}
				}
				
			}
		}
		
		int maxIndex=0;
		for (int i = 0; i < T.length; i++) {
			if (T[i] > T[maxIndex]) {
				maxIndex = i;
			}
		}
		
		int t = maxIndex;
		int newT= maxIndex;
		do {
			t = newT;
			System.out.print(arr[t]+" ");
			newT = actualSolution[t];
			
		} while (t != newT);
		
		System.out.println();
		return T[maxIndex];
	}
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int arr[] = {3,4,-1,0,6,2,3};
		System.out.println(lis.logestIncreasingSubsequence(arr));
	}
}
