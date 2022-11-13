package codejamsolutions;

import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        try(Scanner console = new Scanner(System.in)) {
            int cases = console.nextInt();
            for (int k = 1; k <= cases; k ++) {
                int num = console.nextInt();
                Node[] nodes = new Node[num + 1];
                nodes[0] = new Node(0);
                for (int i = 1; i <= num; i ++) {
                    nodes[i] = new Node(console.nextInt());
                }
                for (int i = 0; i < num; i ++) {
                    int temp = console.nextInt();
                    nodes[temp].addNeighbor(nodes[i]);
                }
                ans = nodes[0].dfs() + ans;
                System.out.print("Case #" + k + ": " + ans);
                if (k < cases) {
                    System.out.println();
                }
            }
        }
    }
	static int ans;
	static class Node {
	    int val;
	    List<Node> neighbors = new ArrayList<>();
	    public Node(int val) {
	        this.val = val;
	    }
	    public void addNeighbor(Node node) {
	        this.neighbors.add(node);
	    }
	    public int dfs() {
	    	if (this.neighbors.isEmpty()) {
	    		return val;
	    	}
	    	List<Integer> list = new ArrayList<>();
	    	for (Node root : neighbors) {
	    		list.add(root.dfs());
	    	}
	    	Collections.sort(list);
	    	for (int i = 1; i < list.size(); i ++) {
	    		ans += list.get(i);
	    	}
	    	int toReturn = Math.max(val, list.get(0));
	    	val = toReturn;
	    	return toReturn;
	    }
	}
}
