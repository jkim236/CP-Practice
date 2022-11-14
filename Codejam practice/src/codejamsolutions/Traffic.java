package codejamsolutions;

import java.util.*;


public class Traffic {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int k = 1; k <= cases; k ++) {
				int len = console.nextInt();
				String start = console.next();
				String pat = console.next();
				List<Integer> green = new ArrayList<>();
				for (int i = 0; i < len; i ++) {
					if (pat.charAt(i) == 'g') {
						green.add(i);
					}
				}
				int max = 0;
				for (int i = 0; i < len; i ++) {
					if (pat.substring(i, i + 1).equals(start)) {
						max = Math.max(max, closestGreen(i, len, green));
					}
				}
				System.out.println(max);
			}
		}
	}
	public static int closestGreen(int index, int len, List<Integer> green) {
		int closest = len;
		for (int i : green) {
			if (i >= index) {
				closest = Math.min(i - index, closest);
			}
			else {
				closest = Math.min(len - (index - i), closest);
			}
		}
		return closest;
	}
}
