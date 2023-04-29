package dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph {
	private ArrayList<ArrayList<Integer>> adj_list;
	public static void main(String[] args) {
		int[] arr = new int[6];
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = i;
		}
		UndirectedGraph graph = new UndirectedGraph(arr);
		graph.addEdge(1,2);
		graph.addEdge(3, 4);
		graph.addEdge(2, 3);
		graph.addEdge(0, 1);
		graph.addEdge(4,5);
		graph.printGraph();
		graph.bfs(0);
	}
	public UndirectedGraph(int[] nums) {
		adj_list = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < nums.length; i++) {
			adj_list.add(new ArrayList<Integer>());
			adj_list.get(i).add(nums[i]);
		}
	}
	public void addEdge(int i, int u) {
		this.adj_list.get(i).add(u); // connecting the two vertices to each other
		this.adj_list.get(u).add(i);
	}
	public void printGraph() {
		for(int i = 0; i < adj_list.size(); i ++) {
			for(int j = 1; j < adj_list.get(i).size(); j ++) {
				System.out.print(adj_list.get(i).get(0) + " ==> " + adj_list.get(i).get(j) + "    ");
			}
			System.out.println();
		}
	}
	public void bfs(int num) {
		System.out.print("BFS: ");
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(num);
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		while(!queue.isEmpty()) {
			for(int i = 1; i < adj_list.get(queue.peek()).size(); i ++) {
				if(!map.containsKey(queue.peek())) {
					queue.add(adj_list.get(queue.peek()).get(i));
				}
			}
			if(!map.containsKey(queue.peek())) {
				map.put(queue.peek(), count);
				System.out.print(queue.poll() + " ");
			}
			else {
				queue.poll();
			}
 			count ++;
		}
	}
	
	
}
