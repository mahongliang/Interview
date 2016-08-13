package com.interview.graph;

import java.util.LinkedList;

import java.util.Queue;
import java.util.Stack;



public class GraphTest {
	static class GraphNode{
		int val;
		GraphNode[] neighbors;
		boolean visited;
		public GraphNode(int x){
			val=x;
		}
		public GraphNode(int x, GraphNode[] nodes){
			val = x;
			neighbors = nodes;
		}
		
	}
	
	public void bfs(GraphNode root){
		
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(root);
		root.visited = true;
		System.out.println(root.val);
		while(!queue.isEmpty()){
			root = queue.remove();		
			for (GraphNode node : root.neighbors) {
				if (!node.visited) {					
					System.out.println(node.val);
					node.visited=true;
					queue.add(node);
				}
			}
		}
	}
	
	public void dfs(GraphNode root){		
		Stack<GraphNode> stack = new Stack<>();
		System.out.println(root.val);
		root.visited = true;
		stack.push(root);
		while(!stack.isEmpty()){	
			root = getNode(root.neighbors);
			if (root != null) {
				System.out.println(root.val);
				root.visited = true;
				stack.push(root);

			}else{
				root = stack.pop();
			}
			
		}
	}
	
	public GraphNode getNode(GraphNode[] nodes){
		for (int i = 0; i < nodes.length; i++) {
			if (!nodes[i].visited) {
				return nodes[i];
			}
		}
		return null;
	}
	
	void dijkstra(int[][] graph, int src){
		int[] dist = new int[graph.length];
		boolean[] Isinset = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			dist[i] = Integer.MAX_VALUE;
			Isinset[i] = false;
		}
		
		dist[src] = 0;
		for (int i = 0; i < graph.length; i++) {
			int u = minDistance(dist,Isinset);
			Isinset[u] = true;
			
			for (int j = 0; j < graph.length; j++) {
				if (!Isinset[j] &&(dist[u]+graph[u][j])< dist[j] && graph[u][j] !=0) {
					dist[j] = dist[u]+graph[u][j];
				}
			}
			
		}
		 printSolution(dist, dist.length);
	}
	void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i+" \t\t "+dist[i]);
    }
	public int minDistance(int[] dist, boolean[] Isinset){
		int min = Integer.MAX_VALUE, minindex =-1;
		for (int i = 0; i < dist.length; i++) {
			if (Isinset[i]==false && dist[i] < min) {
				min = dist[i];
				minindex = i;
			}
		}
		
		return minindex;
	}
	
	
	public static void main(String[] args) {
		GraphTest test = new GraphTest();
		GraphNode n1 = new GraphNode(1); 
		GraphNode n2 = new GraphNode(2); 
		GraphNode n3 = new GraphNode(3); 
		GraphNode n4 = new GraphNode(4); 
		GraphNode n5 = new GraphNode(5); 
 
		n1.neighbors = new GraphNode[]{n2,n3,n5};
		n2.neighbors = new GraphNode[]{n1,n4};
		n3.neighbors = new GraphNode[]{n1,n4,n5};
		n4.neighbors = new GraphNode[]{n2,n3,n5};
		n5.neighbors = new GraphNode[]{n1,n3,n4};
		
		test.bfs(n1);
		//test.dfs(n1);
		
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 0, 10, 0, 2, 0, 0},
            {0, 0, 0, 14, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
           };
        test.dijkstra(graph, 0);
	}
}
