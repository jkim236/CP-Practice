package algorithmsPractice;
import java.util.*;

// Codeforces problem
public class DoremysPaint {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int k = 0; k < cases; k ++) {
				int len = console.nextInt();
				int[] arr  = new int[len];
				for (int i = 0; i < len; i ++) {
					arr[i] = console.nextInt();
				}
				int l = 0;
				int r = arr.length - 1;
				System.out.println((l + 1) + " " + (r + 1) );
			}
		}
	}
}
// 2 3 14
// 2 3 4 6 8 10 12 14 (+ 5)
// 2 3 4 5 6 7 8 9 10 11 12 14 (+ 4)

