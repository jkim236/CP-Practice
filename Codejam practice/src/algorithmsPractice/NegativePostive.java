package algorithmsPractice;
import java.util.Scanner;

// Codeforces negative positive problem, see past submissions
public class NegativePostive {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int k = 0; k < cases; k++) {
				int len = console.nextInt();
				int[] arr = new int[len];
				for (int i = 0; i < len; i ++) {
					arr[i] = console.nextInt();
				}
				for (int i = 0; i < len - 1; i ++) {
					if (arr[i] == 0) {
						arr[i + 1] = Math.abs(arr[i + 1]);
						if (i > 0) {
							arr[i - 1] = Math.abs(arr[i - 1]);
						}
					}
				}
				long ans = 0;
				int neg = 0;
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < len; i ++) {
					if (arr[i] < 0) {
						neg ++;
					}
					if (min > Math.abs(arr[i])) {
						min = Math.abs(arr[i]);
					}
					ans += Math.abs(arr[i]);
				}
				if (neg % 2 == 1 && min > 0) {
					ans -= min * 2;
				}
				System.out.println(ans);
			}
		}
	}
}
