package algorithmsPractice;
import java.util.*;

public class CountPathsSol {
	public int countPaths(int n, int[][] roads) {
        if (n == 1) {
            return 1;
        }
        int mod = 1000000007;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i ++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < roads.length; i ++) {
            int node1 = roads[i][0];
            int node2 = roads[i][1];
            int cost = roads[i][2];
            nodes[node1].neighbors.put(nodes[node2], cost);
            nodes[node2].neighbors.put(nodes[node1], cost);
        }
        long[] costs = new long[n];
        long[] paths = new long[n];
        Set<Node> relaxed = new HashSet<>();
        Set<Node> neighborsCur = nodes[0].neighbors.keySet();
        for (Node node : neighborsCur) {
            costs[node.val] = nodes[0].neighbors.get(node);
            paths[node.val] = 1;
        }
        relaxed.add(nodes[0]);
        while (relaxed.size() < n) {
            int nextNode = 0;
            long min = Long.MAX_VALUE;
            for (int i = 0; i < costs.length; i ++) {
                if (costs[i] == 0 || relaxed.contains(nodes[i])) continue;
                if (min > costs[i]) {
                    nextNode = i;
                    min = costs[i];
                }
            }
            neighborsCur = nodes[nextNode].neighbors.keySet();
            long curCost = costs[nextNode];
            for (Node node : neighborsCur) {
                if (relaxed.contains(nodes[node.val])) continue;
                if (costs[node.val] == 0 || curCost + nodes[nextNode].neighbors.get(node) < costs[node.val]) {
                    costs[node.val] = curCost + nodes[nextNode].neighbors.get(node);
                    paths[node.val] = paths[nextNode] % (long)mod;
                }
                else if (curCost + nodes[nextNode].neighbors.get(node) == costs[node.val]) {
                    paths[node.val] = (paths[node.val] + paths[nextNode]) % (long)mod;
                }
            }
            relaxed.add(nodes[nextNode]);
        }
        return (int)(paths[n - 1] % (long)mod);
    }
    class Node {
        int val;
        Map<Node, Integer> neighbors;
        public Node(int val) {
            this.val = val;
            this.neighbors = new HashMap<>();
        }
    }
}
