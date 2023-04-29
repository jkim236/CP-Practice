package cp_practice;

import java.util.*;

// Codeforces prob
public class FollowDirections {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int i = 0; i < cases; i++) {
				int x = 0;
				int y = 0;
				int num = console.nextInt();
				boolean smth = true;
				String str = console.next();
				StringBuilder build = new StringBuilder(str);
				for (int j = 0; j < num; j ++) {
					if (build.charAt(j) == 'U') {
						y ++;
					}
					if (build.charAt(j) == 'D') {
						y --;		
					}
					if (build.charAt(j) == 'R') {
						x++;
					}
					if (build.charAt(j) == 'L') {
						x--;
					}
					if (x == 1 && y == 1) {
						System.out.println("yes");
						smth = false;
						break;
					}
				}
				if (smth) {
					System.out.println("no");
				}
			}
		}
	}
}
