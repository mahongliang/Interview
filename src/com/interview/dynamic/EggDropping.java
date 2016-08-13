package com.interview.dynamic;

public class EggDropping {

	public int eggDroppingRecv(int eggs, int floors){
		if (floors == 0) {
			return 0;
		}
		if (eggs == 1) {
			return floors;
		}
		int min = 1000;
		for (int i = 1; i <= floors; i++) {
			int val = 1+ eggDroppingRecv(eggs-1, i-1)+eggDroppingRecv(eggs, floors-i);
			if (val < min) {
				min = val;
			}
		}
		return min;
	}
	
	public int eggDropping(int eggs,int floors){
		int T[][] = new int[eggs+1][floors+1];
		int c = 0;
		for (int i = 0; i <= floors; i++) {
			T[1][i] = i;
		}
		
		for (int e = 2; e <= eggs; e++) {
			for (int f = 1; f <= floors; f++) {
				T[e][f] = Integer.MAX_VALUE;
				for (int k = 1; k <= f; k++) {
					c = 1+Math.max(T[e-1][k-1], T[e][f-k]);
					if (c < T[e][f]) {
						T[e][f] = c;
					}
				}
			}
		}
		return T[eggs][floors];
	}
	public static void main(String args[]){
        EggDropping ed = new EggDropping();
        int r = ed.eggDropping(3,100);
        System.out.println(r);
       // System.out.println(ed.eggDroppingRecv(6, 15));
    }
	
}
