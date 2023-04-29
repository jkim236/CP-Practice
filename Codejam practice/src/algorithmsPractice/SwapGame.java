/**
* Date completed: Nov/14/2022

* Problem statement: 
* Alice and Bob play a game on an array 𝑎 of 𝑛 positive integers.
* In alternating turns, starting with Alice, each player performs the following:
* If a[1] = 0, the player loses the game.
* Otherwise, the player selects some 2 ≤ i ≤ n, decreases a[1] by 1, and swaps a[1] with a[i].
* Determine the winner of the game if both players play optimally.
* Input:
* The first line contains a single integer t (1 ≤ t ≤ 2⋅10^4) — the number of test cases.
* Each test case consists of:
* The first line contains a single integer n (2 ≤ n ≤ 10^5) — the length of the array a.
* The second line contains n integers a1,a2,…,an (1 ≤ ai ≤ 10^9) — the elements of the array a.
* The sum of n over all test cases does not exceed 2⋅10^5.
* Output:
* For each test case, output "Alice" if Alice wins the game. Otherwise, output "Bob".
* The output letters can be in any case.
* For example, "alIcE", "Alice", "alice" will all be considered identical.
*/
package algorithmsPractice;
import java.util.Scanner;

// Utilizes game theory in order to solve the problem, if the starting sandcastle is not the tallest, then Bob will win and vice versa
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
