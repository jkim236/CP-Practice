package dataStructures;

import java.util.Stack;

public class PalindromeCheckerWithStack {
	public boolean is_palindrome(String str) {
		char[] arr = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < arr.length; i ++) {
			stack.add(arr[i]);
		}
		String track = "";
		String other = str.substring(0,str.length()/2);
		for(int i = 0; i < arr.length / 2; i ++) {
			track += stack.pop();
		}
		if(stack.size() % 2 == 1) {
			stack.pop();
		}
		if(track.equals(other)) {
			return true;
		}
		return false;
	}
}
