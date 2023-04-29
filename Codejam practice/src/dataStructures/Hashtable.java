package dataStructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hashtable {
	private Entry[] entries; 
	private int size;
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,7};
		int target = 15;
		System.out.println(Arrays.toString(sum(arr, target)));
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(duplicate(arr)));
	}
	public static int[] sum(int[] arr, int target) {
		Map<Integer, Integer> hashmap = new HashMap<>();
		int[] returnedArr = new int[2];
		for(int i = 0; i < arr.length; i ++) {
			System.out.println(hashmap.toString());
			int complement = target - arr[i];
			if(hashmap.containsKey(complement)) {
				returnedArr[0] = hashmap.get(complement);
				returnedArr[1] = i;
				return returnedArr;
			}
			hashmap.put(arr[i], i);
		}
		return returnedArr;
	}
	public Hashtable(int size) {
		entries = new Entry[size];
	}
	public void populate(int index, Entry entry) {
		entries[index] = entry;
	}
	public static int[] duplicate(int[] arr) {
		Map<Integer, Integer> hashtable = new HashMap<>();
		int[] answer = new int[2];
		for(int i = 0; i < arr.length; i ++) {
			if(hashtable.containsKey(arr[i])) {
				answer[0] = hashtable.get(arr[i]);
				answer[1] = i;
				System.out.println(arr[i] + " is the duplicate number");
				return answer;
			}
			hashtable.put(arr[i], i);
		}
		return answer;
		
	}
}
