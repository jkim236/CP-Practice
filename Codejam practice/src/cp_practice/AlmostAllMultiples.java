package cp_practice;
import java.util.*;

// INCOMPLETE, CODEFORCES ALMOST ALL MULTIPLES
public class AlmostAllMultiples {
	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int i = 1; i <= cases; i ++) {
				int len = console.nextInt();
				int start = console.nextInt();
				boolean funny = true;
				int[] arr = new int[len];
				arr[0] = start;
				Set<Integer> used = new HashSet<>();
				used.add(start);
				arr[len - 1] = 1;
				for (int j = 2; j <= len - 1; j ++) {
					int temp = j;
					if (used.contains(temp)) {
						if (len % temp == 0) {
							if (!used.contains(len)) {
								used.add(len);
								arr[j - 1] = len;
							}
							else {
								funny = false;
								break;
							}
						}
						else {
							funny = false;
							break;
						}
					}
					else {
						arr[j - 1] = temp;
						used.add(temp);
					}
				}
				if (funny) {
					for (int j = 0; j < arr.length; j ++) {
						System.out.print(arr[j] + " ");
					}
				}
				else {
					System.out.print("-1");
				}
				System.out.println();
			}
		}
	}
}
// 6 2
// 2 4 3 6 5 1
// 8 2
// 2 4 3 8 5 6 7 1

// Two things could be wrong
// 1. Could be saying array is funny when it's not or vice versa
// 2. Could be not giving the lexicographically lowest







