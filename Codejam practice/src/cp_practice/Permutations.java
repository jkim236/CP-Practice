package cp_practice;
import java.util.Scanner;

// Two Permutations codeforces
public class Permutations {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int i = 0; i < cases; i ++) {
				int n = console.nextInt();
				int a = console.nextInt();
				int b = console.nextInt();
				if (n >= a + b + 2 || (a == n && b == n)) {
					System.out.println("Yes");
				}
				else {
					System.out.println("No");
				}
			}
		}
	}
}
