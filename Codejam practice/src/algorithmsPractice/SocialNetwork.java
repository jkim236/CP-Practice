
/**
Date attempted (not optimized): Nov/15/2022
* Problem statement
* William arrived at a conference dedicated to cryptocurrencies.
* Networking, meeting new people, and using friends' connections are essential
* to stay up to date with the latest news from the world of cryptocurrencies.
* The conference has 𝑛 participants, who are initially unfamiliar with each other.
* William can introduce any two people, 𝑎 and 𝑏, who were not familiar before, to each other.
* William has 𝑑 conditions, 𝑖'th of which requires person 𝑥𝑖 to have a connection to person 𝑦𝑖.
* Formally, two people 𝑥 and 𝑦 have a connection if there is such a chain 𝑝1=𝑥,𝑝2,𝑝3,…,𝑝𝑘=𝑦
* for which for all 𝑖 from 1 to 𝑘−1 it's true that two people with numbers 𝑝𝑖 and 𝑝𝑖+1 know each other.
* For every 𝑖 (1≤𝑖≤𝑑), William wants you to calculate the maximal number of acquaintances
* one person can have, assuming that William satisfied all conditions from 1 and up to and including 𝑖
* and performed exactly 𝑖 introductions. The conditions are being checked after William performed 𝑖
* introductions. The answer for each 𝑖 must be calculated independently. It means that when you
* compute an answer for 𝑖, you should assume that no two people have been introduced to each other yet.
* Input:
* The first line contains two integers 𝑛 and 𝑑 (2≤𝑛≤103,1≤𝑑≤𝑛−1), the number of people, and number of conditions, respectively.
* Each of the next 𝑑 lines each contain two integers 𝑥𝑖 and 𝑦𝑖 (1≤𝑥𝑖,𝑦𝑖≤𝑛,𝑥𝑖≠𝑦𝑖), the numbers of people
* which must have a connection according to condition 𝑖.
* Output:
* Output 𝑑 integers. 𝑖th number must equal the number of acquaintances the person with the
* maximal possible acquaintances will have, if William performed 𝑖 introductions and satisfied
* the first 𝑖 conditions.
*/
package algorithmsPractice;
import java.util.*;

/*
 * NOTE: FURTHER OPTIMIZATION NEEDED
 * Utilizes graph implementation and bfs to solve problem statement
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
