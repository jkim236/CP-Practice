package dataStructures;

import java.util.Stack;

public class Stacks {
	
	public static void main(String[] args) {
		Stack<Character> st = new Stack<Character>();
		st.add('A');
		st.add('B');
		st.add('C');
		System.out.println(st.get(0)); //should be A
		st.pop(); // removes C
		System.out.println(st);
		System.out.println(st.contains('A'));
	}
}
