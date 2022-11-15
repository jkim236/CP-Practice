package algorithmsPractice;
import java.util.*;
/*
 * NOTE: FURTHER OPTIMIZATION NEEDED
 */
public class SocialNetwork {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int people = console.nextInt();
			int connections = console.nextInt();
			Map<Integer, Set<Integer>> map = new HashMap<>();
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
					mapMod(map, p1, p2);
					max = Math.max(max, map.get(p1).size());
					max = Math.max(max, map.get(p2).size());
				}
				else {
					extras ++;
				}
				Map<Integer, Set<Integer>> saved = new HashMap<>();
				Set<Integer> keySet = map.keySet();
				for (int key : keySet) {
					Set<Integer> monkey = new HashSet<>();
					monkey.addAll(map.get(key));
					saved.put(key, monkey);
				}
				for (int k = 0; k < extras; k ++) {
					int indexNode = findNode(map.get(p2), people, p2);
					int fml = map.get(indexNode).size();
					int max1 = Math.max(map.get(p2).size(), fml);
					int max2 = Math.min(map.get(p2).size(), fml);
					int index1;
					int index2;
					if (fml >= map.get(p2).size()) {
						index1 = indexNode;
						index2 = p2;
					}
					else {
						index1 = p2;
						index2 = indexNode;
					}
					for (int i = 1; i <= people; i ++) {
						if (!map.get(index1).contains(i) && !map.get(index2).contains(i) &&
								i != index1 && i != index2) {
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
				map = saved;
				System.out.println(max);
			}
		}
	}
	public static int findNode(Set<Integer> set, int people, int p2) {
		for (int i = 1; i <= people; i ++) {
			if (!set.contains(i) && p2 != i) {
				return i;
			}
		}
		return 0;
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
}
