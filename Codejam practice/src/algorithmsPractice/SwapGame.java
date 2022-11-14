package algorithmsPractice;

import java.util.Scanner;

public class SwapGame {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int i = 1; i <= cases; i ++) {
				int nums = console.nextInt();
				int start = console.nextInt();
				boolean a = false;
				for (int j = 1; j < nums; j ++) {
					if (start > console.nextInt()) {
						a = true;
					}
				}
				if (a) { System.out.println("Alice"); }
				else {
					System.out.println("Bob");
				}
			}
			
		}
	}
}
// Strat take lowest doesn't work
// first person for other to switch to 2 -> 1 loses
// swap for max strategy?
// optimal strat: swap for max
// alice wins when first is 5, 2
// alice loses when first is 3, 1
// alice wins if start > 2 and 2 exists
// alice wins when start is greater than at least one value!
/*
3 4 4 2
2 4 4 2
4 1 4 2
1 3 4 2


*/
