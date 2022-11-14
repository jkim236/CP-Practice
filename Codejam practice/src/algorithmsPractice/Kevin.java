package algorithmsPractice;
import java.util.Scanner; 
public class Kevin {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int i = 1; i <= cases; i ++) {
				int len = console.nextInt();
				int num = len / 2;
				if (len % 2 == 1) {
					num ++;
				}
				int divisor = 1;
				for (int j = 0; j < num; j ++) {
					System.out.print((num - j) + " ");
					if (j != num - 1 || len % 2 == 0) {
						System.out.print((len - j) + " ");
					}
				}
				System.out.println();
			}
		}
	}
}
