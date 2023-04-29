package cp_practice;


import java.util.*;

public class Rangeupdatequerie {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int k = 0; k < cases; k++) {
				int len = console.nextInt();
				int inputs = console.nextInt();
				int[] arr = new int[len];
				Queue<Integer> q = new LinkedList<>();
				Queue<Integer> left = new LinkedList<>();
				Queue<Integer> right = new LinkedList<>();
				for (int i = 0; i < len;i ++) {
					arr[i] = console.nextInt();
				}
				for (int i = 0; i < inputs; i ++) {
					int input = console.nextInt();
					if (input == 1) {
						left.add(console.nextInt() - 1);
						right.add(console.nextInt() - 1);
					}
					else if (input == 2) {
						int smth = console.nextInt() - 1;
						for (int j = 0; j < left.size(); j ++) {
							if (smth >= left.peek() && smth <= right.peek()) {
								int num = 0;
								while (arr[smth] > 0) {
									num += arr[smth] % 10;
									arr[smth] /= 10;
								}
								arr[smth] = num;
								if (num == 0) {
									break;
								}
							}
							int temp = left.remove();
							int temp2 = right.remove();
							left.add(temp);
							right.add(temp2);
						}
						System.out.println(arr[smth]);
					}
				}
			}
		}
	}
}
