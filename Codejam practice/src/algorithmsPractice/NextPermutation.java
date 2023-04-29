package algorithmsPractice;

import java.util.*;
// LEETCODE #31
public class NextPermutation {
	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int i = 1; i <= cases; i ++) {
				int len = console.nextInt();
				int[] arr = new int[len];
				for (int j = 0; j < len; j ++) {
					arr[j] = console.nextInt();
				}
				next(arr);
				System.out.println("Case #" + i + ": " + Arrays.toString(arr));
			}
		}
	}
	public static void next(int[] nums) {
		int index1 = -1;
		int index2 = -1;
		for (int i = 1; i < nums.length; i ++) {
			// check if increasing, if so set indexes
			if (nums[i - 1] < nums[i]) {
				index1 = i - 1;
				index2 = i;
			}
			// if we found indexes, then consider if arr is increasing
			if (index1 != -1 && nums[i - 1] > nums[i]) {
				// consider changing index2, if num at current index
				// is greater than num at first index
				if (nums[index1] > nums[i]) {
					index2 = i;
				}
			}
		}
		// if we found a swap, then swap
		if (index1 != -1) {
			int temp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = temp;
		}
		// else sort in ascending order
		else {
			for (int i = 0; i < nums.length / 2; i ++) {
				int temp = nums[i];
				nums[i] = nums[nums.length - 1 - i];
				nums[nums.length - 1 - i] = temp;
			}
		}
	}
}
// 5 3 2 1 5, can only look at number after the one we are changing
// 5 3 2 5 1

// 5 4 3 3 4
// 4 5 2 4 1 6 5 7 6, trying to make change with the last numbers possible
// that way we can make the smallest larger number
// keep track of two numbers, first should be smaller than second
// keep track if arr is decreasing, make changes depending on that.
// for example, take 5 4 3 2 1 5 4 3 2 1, we should change the first
// '1' and the '2', we do not consider the second one as it wouldn't
// be a different permutation.
// take 5 4 3 6 1 7 6, The first pair the algorithm would consider is
// '3' and '6', the '6' would then be replaced by '5',
// Then the '3' would be replaced by '5' and '7' would take place
// same with next number.
// if arr increases, consider past number and current,
// if arr decreases, keep lower and consider current.
// can only swap with current if it is greater than lower


// sample input:
// 1
// 9
// 1 2 3 4 5 6 7 2 4
