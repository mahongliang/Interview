package com.interview.binarytree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BinaryTreeTest {
	class Node{
		Node left;
		Node right;
		int data;
		public Node(int data){
			this.left = null;
			this.right = null;
			this.data = data;
		}
		
		public Node()
		{
			
		}
		
	}
	
	public void create(Node root,int data){
		if (root == null) {
			root = new Node(data);
		}else{
			if (data < root.data) {
				if (root.left == null) {
					root.left = new Node(data);
				}else {
					create(root.left, data);
				}
			}else{
				if (root.right == null) {
					root.right = new Node(data);
				}else{
					create(root.right, data);
				}
			}
		}	
	}
	
	public void preorder(Node node){
		if (node != null) {
			System.out.print(node.data+" ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public Node search(Node root, int key){
		if (root == null) {
			return null;
		}
		if (root.data == key) {
			return root;
		}
		
		if (root.data < key) {
			return search(root.right, key);
		}else{
			return search(root.left, key);
		}
	}
	public Node insert(Node root, int data){
		Node node = new Node(data);
		if (root == null) {
			return node;
		}
		Node parent = null,current = root;
		while(current !=null){
			parent = current;
			if (current.data <= data) {
				current = current.right;
			}else{
				current = current.left;
			}
		}
		
		if (parent.data <= data) {
			parent.right =node;
		}else{
			parent.left = node;
		}
		return root;
	}
	
	public boolean sameTree(Node root1,Node root2){
		if (root1 ==null && root2 ==null) {
			return true;
		}
		
		if (root1 == null || root2 ==null) {
			return false;
		}
		
		return (root1.data == root2.data)&&sameTree(root1.left, root2.left)
				&&sameTree(root1.right, root2.right);
	}
	
	public int size(Node root){
		if (root == null) {
			return 0;
		}
		
		int leftsize = size(root.left);
		int rightsize = size(root.right);
		
		return leftsize+rightsize+1;
	}
	
	public int height(Node root){
		if (root ==null) {
			return 0 ;
		}
		
		int leftheight = height(root.left);
		int rightheight = height(root.right);
		
		return (leftheight > rightheight?leftheight:rightheight)+1;
	}
	
	boolean rootToleafSum(Node root, int sum, List<Integer> result){
		if (root == null) {
			return false;
		}
		
		if (root.left == null && root.right == null) {
			if (root.data == sum) {
				result.add(root.data);
				return true;
			}else {
				return false;
			}
		}
		
		if (rootToleafSum(root.left, sum-root.data, result)) {
			result.add(root.data);
			return true;
		}
		
		if (rootToleafSum(root.right, sum, result)) {
			result.add(root.data);
			return true;
		}
		
		return false;
		
	}
	
	boolean isBST(Node root, int min, int max){
		if (root == null) {
			return true;
		}
		
		if (root.data <=min || root.data > max) {
			return false;
		}
		
		return isBST(root.left, min, root.data)&&isBST(root.right, root.data, max);
	}
	
	void levelOrderTravseral(Node root){
		if (root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			root = queue.poll();
			System.out.print(root.data+" ");
			if (root.left !=null) {
				queue.add(root.left);
			}
			
			if (root.right != null) {
				queue.add(root.right);
			}
		}
	}
	
	void iterativePostorder(Node root){
		if (root == null) {
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		
		stack1.push(root);
		while(!stack1.isEmpty()){
			root = stack1.pop();
			stack2.push(root);
			if (root.left != null) {
				stack1.push(root.left);
			}
			
			if (root.right != null) {
				stack1.push(root.right);
			}
		}
		System.out.print("iterativePostorder: ");
		while(!stack2.isEmpty()){
			root = stack2.pop();
			System.out.print(root.data+" ");
		}
	}
	void iterativePreorder(Node root){
		if (root == null) {
			return;
		}
		System.out.print("iterativePreorder: ");
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			root = stack.pop();
			System.out.print(root.data+" ");
			if (root.right != null) {
				stack.push(root.right);
			}
			if (root.left != null) {
				stack.push(root.left);
			}
		}
	}
	void iterativeInorder(Node root){
		if (root == null) {
			return;
		}
		System.out.print("iterativeIneorder: ");
		Stack<Node> stack = new Stack<>();
		
		while(true){
			if (root != null) {
				stack.push(root);
				root = root.left;
			}else{
				if (stack.isEmpty()) {
					break;
				}else{
					root = stack.pop();
					System.out.print(root.data+" ");
					root = root.right;
				}
			}
		}	
	}
	
	void levelOrderRevrse(Node root){
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			root = queue.poll();
			if (root.right != null) {
				queue.offer(root.right);
			}
			
			if (root.left != null) {
				queue.offer(root.left);
			}
			stack.push(root);
		}
		
		while(!stack.isEmpty()){
			root = stack.pop();
			System.out.print(root.data+" ");
		}
	}
	
	void spiralPrintTwoStack(Node root){
		if (root==null) {
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);
		while(!stack1.isEmpty()||!stack2.isEmpty()){
			while(!stack1.isEmpty()){
				root = stack1.pop();
				System.out.print(root.data+" ");
				if (root.left != null) {
					stack2.push(root.left);
				}
				if (root.right!= null) {
					stack2.push(root.right);
				}
			}
			
			while (!stack2.isEmpty()) {
				root = stack2.pop();
				System.out.print(root.data+" ");
				if (root.left != null) {
					stack1.push(root.left);
				}
				if (root.right != null) {
					stack1.push(root.right);
				}
			}
		}
	}
	
	public Node lcaBST(Node root, Node n1, Node n2){
		if (root.data > Math.max(n1.data, n2.data)) {
			return lcaBST(root.left, n1, n2);
		}else if(root.data < Math.min(n1.data, n2.data)){
			return lcaBST(root.right, n1, n2);
		}else {
			return root;
		}
	}
	
	public Node lca(Node root, Node n1,Node n2){
		if (root==null) {
			return null;
		}
		
		if (root==n1|| root==n2) {
			return root;
		}
		
		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);
		
		if (left != null  && right != null) {
			return root;
		}
		if (left == null && right == null) {
			return null;
		}
		return left!=null?left:right;
				
	}
	
	
	
	public static void main(String[] args) {
		BinaryTreeTest test = new BinaryTreeTest();
		Node node1 = test.new Node(10);
		Node node2 = test.new Node(15);
		Node node3 = test.new Node(30);
		Node node4 = test.new Node(3);
		Node node5 = test.new Node(6);
		Node node6 = test.new Node(2);
		Node node7 = test.new Node(5);
		Node node8 = test.new Node(9);
		Node node9 = test.new Node(8);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node4.left = node7;
		node6.left = node8;
		node6.right = node9;
		
		System.out.print("preorder: ");
		test.preorder(node1);
		System.out.println();
		System.out.println("size: "+test.size(node1));
		System.out.println("height: "+test.height(node1));
		System.out.println("isBST: "+test.isBST(node1, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.print("levelorder: ");
		test.levelOrderTravseral(node1);
		System.out.println();
		test.iterativePostorder(node1);
		System.out.println();
		test.iterativePreorder(node1);
		System.out.println();
		test.iterativeInorder(node1);
		System.out.println();
		System.out.print("levelorderreserve: ");
		test.levelOrderRevrse(node1);
		System.out.println();
		System.out.print("spiralorder: ");	
		test.spiralPrintTwoStack(node1);
		System.out.println();
		
		System.out.println("lca: data="+test.lca(node1, node5, node6).data);
	}
}
