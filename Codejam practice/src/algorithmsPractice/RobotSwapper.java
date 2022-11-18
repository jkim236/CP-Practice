package algorithmsPractice;

import java.util.*;


class RobotSwapper {
	public static void main(String[] args) {
		System.out.println(robotStack("stringasdfdsaf"));
	}
	public static String robotStack(String s) {
		int[] test = new int[26];
		StringBuilder ans = new StringBuilder();
		for (char c : s.toCharArray()) {
			test[c - 'a'] ++;
		}
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			stack.push(c);
			test[c - 'a'] --;
			while (!stack.isEmpty()) {
				char temp = stack.peek();
				if (lowerChar(temp, test)) {
					break;
				}
				ans.append(stack.pop());
			}
		}
		return ans.toString();
	}
	public static boolean lowerChar(char c, int[] freq) {
		for (int i = 0; i < c - 'a'; i ++) {
			if (freq[i] > 0) {
				return true;
			}
		}
		return false;
	}
    public static String robotWithString(String s) {
        String print = "";
        String[] chars = s.split("");
        Arrays.sort(chars);
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chars.length; i ++) {
            if (map.containsKey(chars[i])) {
            	map.get(chars[i]).add(i);
                map.put(chars[i], map.get(chars[i]));
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(chars[i], list);
            }
        }
        int[] arr = new int[chars.length];
        chars = s.split("");
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = map.get(chars[i]).remove(0);
        }
        Map<Integer, Integer> sortedToReg = new HashMap<>();
        for (int i = 0; i < arr.length; i ++) {
            sortedToReg.put(arr[i], i);
        }
        int curIndex = sortedToReg.get(0);
        Queue<String> toBeAdded = new LinkedList<>();
        toBeAdded.add(chars[curIndex]);
        for (int i = 1; i < arr.length; i ++) {
            if (sortedToReg.get(i) > curIndex) {
                toBeAdded.add(chars[sortedToReg.get(i)]);
                curIndex = sortedToReg.get(i);
            }
        }
        String reverse = "";
        chars = s.split("");
        for (int i = 0; i < arr.length; i ++) {
            if (toBeAdded.peek().equals(chars[i]) && (reverse.length() == 0 || reverse.substring(reverse.length() - 1).compareTo(chars[i]) > 0)) {
                print += toBeAdded.remove();
            }
            else {
            	if (reverse.length() > 0 && reverse.substring(reverse.length() - 1).compareTo(chars[i]) <= 0
            			&& (toBeAdded.isEmpty() || reverse.substring(reverse.length() - 1).compareTo(toBeAdded.peek()) <= 0)) {
            		System.out.println(reverse.substring(reverse.length() - 1, reverse.length()));
            		print += reverse.substring(reverse.length() - 1, reverse.length());
            		reverse = reverse.substring(0, reverse.length() - 1);
            		System.out.println(print);
            		i --;
            	}
            	else {
                    reverse += chars[i];
            	}
            }
        }
        while (reverse.length() > 0) {
            print += reverse.substring(reverse.length() - 1);
            reverse = reverse.substring(0, reverse.length() - 1);
        }  
        return print;
    }
}


