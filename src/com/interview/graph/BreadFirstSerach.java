package com.interview.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadFirstSerach {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;

	public BreadFirstSerach(Graph g, int s) {
		marked = new boolean[g.v];
		edgeTo = new int[g.v];
		this.s = s;
		bfs(g, s);
	}

	public void bfs(Graph g, int s) {
		Queue<Integer> queue = new LinkedList<>();
		marked[s] = true;
		queue.offer(s);
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (Integer w : g.adj(v)) {
				edgeTo[w] = s;
				marked[w] = true;
				queue.offer(w);
			}
		}
	}

	public boolean hasPathTo(int w) {
		return marked[w];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.add(x);
		}
		path.add(s);
		return path;// 倒序，从终点到起点
	}
}
