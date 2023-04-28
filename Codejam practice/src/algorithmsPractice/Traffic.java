/** 
* Date completed: Nov/14/2022
--------------------------------
* Problem statement: 
* This Java program solves a problem where we need to find the minimum amount
* of time required to cross a traffic light, given a string that describes the 
* order of its three colors (red, yellow, and green). We are given the current 
* color of the traffic light and can only cross when the green color is on.
* The program takes the number of test cases, the length of the string, the 
* current color of the traffic light, and the string describing the order of 
* the colors as input. For each test case, it outputs the minimal number of 
* seconds required to cross the road.
*/
package algorithmsPractice;
import java.util.*;

/**
* This Java code takes input for the number of test cases, the length of a 
* traffic light sequence, the current color of the traffic light, and the
* sequence of colors. It calculates the minimum time required to cross the 
* road when the green light is on by finding the closest green light to the 
* current position, and outputs the result for each test case.
*/
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
	// helper method for solution, finds the closest green light to a given index
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
