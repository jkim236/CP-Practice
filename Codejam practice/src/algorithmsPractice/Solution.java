package codejamsolutions;

import java.util.*;
import java.io.*;
public class Solution {
	static boolean killMePls = false;
	public static void main(String[] args) throws Exception {
		Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
				killMePls = true;
			}
		};
		Thread t = new Thread(null,()->A(args),"",1<<28);
		t.setUncaughtExceptionHandler(h);
		t.start();
		t.join();
		if (killMePls) {
			throw null;
		}
	}
	public static void A(String args[]) {
        try(Scanner console = new Scanner(System.in)) {
            int cases = console.nextInt();
            for (int k = 1; k <= cases; k ++) {
                ans = 0;
            	int num = console.nextInt() + 1;
                Node[] nodes = new Node[num];
                nodes[0] = new Node(0);
                for (int i = 1; i < num; i ++) {
                    nodes[i] = new Node(console.nextInt());
                }
                for (int i = 1; i < num; i ++) {
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
	static long ans;
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
	    	for (Node root : this.neighbors) {
	    		list.add(root.dfs());
	    	}
	    	Collections.sort(list);
	    	for (int i = 1; i < list.size(); i ++) {
	    		ans += list.get(i);
	    	}
	    	int toReturn = Math.max(val, list.get(0));
	    	return toReturn;
	    }
	}
}
