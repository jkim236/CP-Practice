package algorithmsPractice;

public class Mergesorter {
	public static void main(String[] args) {
		int[] testArr = new int[100];
		for(int i = 0; i < 100; i ++) {
			int num = (int)(Math.random() * 100) + 1;
			testArr[i] = num;
		}
		testArr = sort(testArr);
		for(int i = 0; i < 100; i ++) {
			System.out.print(testArr[i] + ", ");
		}
	}
	public static int[] sort(int arr[]) {
		if(arr.length == 1) {
			return arr;
		}
		int count = 0;
		int[] temparr1 = new int[arr.length/2];
		while(count < arr.length/2) {
			temparr1[count] = arr[count];
			count ++;
		}
		int tempVal = 0;
		int add = 0;
		if(arr.length % 2 == 1 && arr.length > 1) {
			add = 1;
		}
		int[] temparr2 = new int[arr.length/2 + add];
		while(count < arr.length) {
			temparr2[tempVal] = arr[count];
			count ++;
			tempVal ++;
		}
		temparr1 = sort(temparr1);
		temparr2 = sort(temparr2);
		int[] real = new int[arr.length];
		count = 0;
		int track1 = 0;
		int track2 = 0;
		while(count < real.length) {
			if(track1 == temparr1.length) {
				real[count] = temparr2[track2];
				track2++;
			}
			else if(track2 == temparr2.length) {
				real[count] = temparr1[track1];
				track1++;
			}
			else if(temparr1[track1] < temparr2[track2]) {
				real[count] = temparr1[track1];
				track1++;
			}
			else {
				real[count] = temparr2[track2];
				track2 ++;
			}
			count++;
		}
		return real;
		

	}
}
