package com.interview.graph;

public class Dijkstra {	
	public int[] dist;//每个结点距离起始结点的距离
	public int[] prev;//前驱结点
	public boolean[] isvisited;// 结点是否被访问
	public static final int INF= Integer.MAX_VALUE;
	public int[][] edges;
	public Dijkstra(Graph g, int s){
		edges= new int[g.v][g.v];
		dist = new int[g.v];
		prev = new int[g.v];
		isvisited = new boolean[g.v];
		for (int i = 0; i < g.v; i++) {
			dist[i] = INF;
			prev[i] = -1;
		}
		dijkstra(g,s);
	}
	
	private void dijkstra(Graph g, int s){
		dist[s] = 0;
		isvisited[s] = true;
		while(true){
			int index = -1;
			int min = INF;
			for (int i = 0; i < g.v; i++) {
				if (!isvisited[i] && edges[s][i] < min) {
					min = edges[s][i];
					index =-1;
				}
			}
			if (index == -1) {
				break;
			}			
			dist[index] = min;
			isvisited[index] = true;
			
			for (int i = 0; i < g.v; i++) {
				if (!isvisited[i] && edges[s][index] + edges[index][i] < edges[s][i]) {
					edges[s][i] = edges[s][index] + edges[index][i];
					prev[i]=index;
				} 
			}
		}
			
	}
}