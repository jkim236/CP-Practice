package cp_practice;
import java.util.*;

public class MathClass {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int k = 0; k < cases; k ++) {
				int len = console.nextInt();
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < len; i ++) {
					list.add(console.nextInt());
				}
				list.sort(null);
				int index = 1;
				int min = list.get(0);
				while (index < list.size()) {
					if (min == 1) {
						break;
					}
					int temp = gcd(min, list.get(index));
					if (temp < min) {
						index = 1;
						min = temp;
						list.add(0, min);
					}
					else {
						index ++;
					}
				}
				System.out.println(list.get(list.size() - 1) / min);
			}
		}
	}
	public static int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }
}









