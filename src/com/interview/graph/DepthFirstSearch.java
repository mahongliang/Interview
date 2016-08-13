package com.interview.graph;

import java.util.ArrayList;

public class DepthFirstSearch {
	private boolean[] marked;
	private int[] edgeTo;//从起到到一个顶点的已知路上的最后一个顶点
	private final int s; //起始点
	public DepthFirstSearch(Graph g, int s){
		this.s = s;
		marked = new boolean[g.v];
		dfs(g,s);
	}
	
	public void dfs(Graph g, int v){
		marked[v] = true;
		for (Integer w : g.adj(v)) {
			if (!marked[w] ) {
				edgeTo[w] = v;
				dfs(g,w);
			}
		}
	}
	public boolean hasPathTo(int w){
		return marked[w];
	}
	
	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)) {
			return null;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		for (int x = v; x != s; x= edgeTo[x]) {
			path.add(x);
		}
		path.add(s);
		return path;//倒序，从终点到起点
	}
}
