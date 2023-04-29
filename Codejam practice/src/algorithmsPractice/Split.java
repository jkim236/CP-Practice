package algorithmsPractice;
import java.util.*;

public class Split {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int i = 0; i < cases; i++) {
				int strLength = console.nextInt();
				int max = 0;
				StringBuilder str = new StringBuilder(console.next());
				HashMap<Character, Integer> map1 = new HashMap<>();
				Set<Character> set = new HashSet<>();
				for (int j = 0; j < strLength; j ++) {
					if (map1.containsKey(str.charAt(j))) {
						map1.put(str.charAt(j), map1.get(str.charAt(j)) + 1);
					}
					else {
						map1.put(str.charAt(j), 1);
					}
				}
				max = map1.size();
				for (int j = strLength - 1; j >= 0; j --) {
					set.add(str.charAt(j));
					if (map1.containsKey(str.charAt(j)) && map1.get(str.charAt(j)) > 1) {
						map1.put(str.charAt(j), map1.get(str.charAt(j)) - 1);
					}
					else if (map1.containsKey(str.charAt(j)) && map1.get(str.charAt(j)) == 1) {
						map1.remove(str.charAt(j));
					}
					max = Math.max(max, map1.size() + set.size());
				}
				System.out.println(max);
			}
		}
	}
}
