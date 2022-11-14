package algorithmsPractice;
import java.util.*;
public class BeautifulTree {
	public static void main(String[] args) {
		try(Scanner console = new Scanner(System.in)) {
			int cases = console.nextInt();
			for (int i = 1; i <= cases; i ++) {
				int ans = 0;
				int size = console.nextInt();
				int[] arr = new int[size];
				for (int j = 0; j< size; j ++) {
					arr[j]= console.nextInt();
				}
				boolean running = true;
				if (size == 1) {
					running = false;
				}
				int track = 2;
				while (running) {
					for (int j = 0; j < size && running; j += track) {
						int[] one = new int[track / 2];
						int[] two = new int[track / 2];
						int[] combined = new int[track];
						int count = 0;
						for (int k = j; k < j + track; k ++) {
							if(k < j + track / 2) {
								one[k - j] = arr[k];
							}
							else {
								two[count] = arr[k];
								count ++;
							}
						}
							if (one[one.length - 1] > two[0]) {
								for (int m = 0; m < track / 2; m ++) {
									if (one[0] < two[m]) {
										ans = -1;
										running = false;
										break;
									}
								}
								if (running){
									ans ++;
									for (int z = 0; z < track; z ++) {
										if(z < track / 2) {
											combined[z] = two[z]; 
										}
										else {
											combined[z] = one[z - track / 2];
										}
									}
									for (int z = j; z < j + track; z ++) {
										arr[z] = combined[z - j];
									}
								}
							}
							
						}
						track *= 2;
						if (track > size) {
							running = false;
						}
					}
					System.out.println(ans);
				}
			}	
		}
	}

// 3 4 7 8 1 2 5 6

