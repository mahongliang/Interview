package com.interview.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	public final int v;//顶点树
	public int e;//边的树目
	private List<List<Integer>> adj;//邻接表
	
	public Graph(int v){
		this.v = v;
		this.e = 0;
		adj = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int v, int w){
		adj.get(v).add(w);
		e++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj(v);
	}
	
}
