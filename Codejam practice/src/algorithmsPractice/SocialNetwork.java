package algorithmsPractice;
import java.util.*;
public class SocialNetwork {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int people = console.nextInt();
			int connections = console.nextInt();
			HashMap<Integer, Set<Integer>> map = new HashMap<>();
			for (int j = 1; j <= people; j ++) {
				Set<Integer> set = new HashSet<>();
				map.put(j, set);
			}
			int max = 1;
			int extras = 0;
			for (int j = 0; j < connections; j ++) {
				int p1 = console.nextInt();
				int p2 = console.nextInt();
				if(!map.get(p1).contains(p2)) {
					// add p2 and all of p2's neighbors to p1 neighbors
					// add p1 and all of p1's neighbors to p2 neighbors
					// keep track of all of p1's neighbors in a set before modifying
					// use that to modify p2 and p2's neighbors
					mapMod(map, p1, p2);
					max = Math.max(max, map.get(p1).size());
					max = Math.max(max, map.get(p2).size());
				}
				else {
					extras ++;
					System.out.println("test hihi");
					int max1 = map.get(p2).size();
					int max2 = 0;
					int index1 = p2;
					int index2 = 1;
					for (int i = 1; i <= people; i ++) {
						if (!map.get(p2).contains(i)) {
							if (map.get(i).size() >= max2) {
								if (map.get(i).size() >= max1) {
									int temp = max1;
									max1 = map.get(i).size();
									max2 = temp;
									temp = index1;
									index1 = i;
									index2 = temp;
								}
								else {
									max2 = map.get(i).size();
									index2 = i;
								}
							}
						}
					}
					mapMod(map, index1, index2);
					max = Math.max(max, map.get(index1).size());
					max = Math.max(max, map.get(index2).size());
				}
				System.out.println(max);
			}
		}
	}
	public static void mapMod(Map<Integer, Set<Integer>> map, int p1, int p2) {
		Set<Integer> set = new HashSet<>();
		set.addAll(map.get(p1));
		for (int i : map.get(p1)) {
			map.get(i).add(p2);
			map.get(i).addAll(map.get(p2));
		}
		for (int i : map.get(p2)) {
			map.get(i).add(p1);
			map.get(i).addAll(set);
		}
		map.get(p1).add(p2);
		map.get(p1).addAll(map.get(p2));
		map.get(p2).add(p1);
		map.get(p2).addAll(set);
	}
	static class Node {
		int val;
		Set<Node> met;
		public Node(int val) {
			this.val = val;
			met = new HashSet<>();
		}
		
	}
}
