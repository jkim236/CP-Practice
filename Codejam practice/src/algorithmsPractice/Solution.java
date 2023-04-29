/**
/**

* Wile builds machines that run on chain reactions.
* Each machine consists of N modules indexed 1,2,…,N.
* Each module may point at one other module with a lower index. If not, it points at the abyss.
* Initiators are modules that are not pointed at by any others.
* When a module is triggered, it triggers the module it is pointing at (if any)
* which may trigger a third module (if it points at one), and so on.
* Fun factor Fi of each module is known. The overall fun is the sum of the fun Wile gets from each chain reaction.
* Wile triggers each initiator module once, in some order. The overall fun Wile gets from the session is the sum of the fun he gets from each chain reaction.
* Input
* The first line contains the number of test cases, T.
* T test cases follow, each described using 3 lines.
* Each test case starts with a line with a single integer N, the number of modules Wile has.
* The second line contains N integers F1,F2,…,FN where Fi is the fun factor of the i-th module.
* The third line contains N integers P1,P2,…PN. If Pi=0, that means module i points at the abyss.
* Otherwise, module i points at module Pi.
* Output
* For each test case, output one line containing Case #x: y,
* where x is the test case number (starting from 1) and y is the maximum fun Wile can have
* by manually triggering the initiators in the best possible order.
*/
package algorithmsPractice;

import java.util.*;
import java.io.*;

// This class contains a solution for the problem statement above. Initializes a graph with weighted nodes and utilizes a dfs and a bottom up approach to 
// solve the problem statement. Also, avoids stack overflow error by increasing recursive stack limit
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
