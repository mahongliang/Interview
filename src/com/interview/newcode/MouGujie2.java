package com.interview.newcode;

import java.util.Scanner;

public class MouGujie2 {
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
				Scanner in = new Scanner(System.in);
				int n = in.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = in.nextInt();
				}
				int cnt=0;
				for (int i = 0; i < arr.length-1; i++) {					
					for (int j = 0; j < arr.length-1-i; j++) {
						if (arr[j] >arr[j+1]) {
							int temp = arr[j];
							arr[j] = arr[j+1];
							arr[j+1] = temp;
							cnt++;
						}
					}
				}
				
				System.out.println(cnt);
				
				in.close();
	}
}
