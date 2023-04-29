package algorithmsPractice;
import java.util.*;

// SEing double codeforces
public class SeeingDouble {
	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int i = 1; i <= cases; i ++) {
				String input = console.next();
				StringBuilder str = new StringBuilder();
				Stack<String> stack = new Stack<>();
				for (int j = 0; j < input.length(); j ++) {
					str.append(input.substring(j, j + 1));
					stack.add(input.substring(j, j + 1));
				}
				while (!stack.isEmpty()) {
					str.append(stack.pop());
				}
				System.out.println(str.toString());
			}
		}
	}
}
// 5 5
// 5 2 3 4 1

// 4 2
// 2 4 3 1
// we cannot complete if we use a number between n/2 and n - 1 before
// 8 2
// 2 4 3 8 5 6 7 1
// We do not need to consider last number

// What we know:
/*
 * The resulting output should be lowest 
 * All numbers should be multiples of i
 * Therefore, number should >= i
 */

// Things to consider:
/*
 * Is there a case where we should put a larger lexographically number
 * First?
 * Is using a set to store used numbers and multiplying too slow?
 * Perhaps there is a way to determine if it's impossible and stop early
 * I think top down is good because we can instantly determine whether
 * Permutation is possible or not 
 */

