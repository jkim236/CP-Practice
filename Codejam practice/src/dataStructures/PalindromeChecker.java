package dataStructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PalindromeChecker {
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.print(obj.isPalindrome(1004554001));
	}
}
class Solution {
	public boolean isPalindrome(int x) {
		String str = ""  + x;
		String[] chars = str.split("");
		System.out.println(Arrays.toString(chars));
		String[] inverse = new String[chars.length];
		for (int i = chars.length - 1; i >= 0; i--) {	
			inverse[chars.length - i - 1] = chars[i];
		}
		String reverse = "";
		for (int i = 0; i < inverse.length; i++) {
			reverse += inverse[i];
		}
		if (reverse.equals(str)) {
			return true;
		}
		else {
			return false;
		}
	}
}
