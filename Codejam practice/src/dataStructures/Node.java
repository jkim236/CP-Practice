package dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Node {
	private int key;
	private Node leftChild;
	private Node rightChild;
	public static void main(String[] args) {
		Node tree = new Node(3);
		int count = 0;
		tree.addValue(5);
		tree.addValue(4);
		tree.addValue(6);
		tree.addValue(2);
		tree.addValue(1);
		tree.printTree();
		String s = "   ";
		Map<Integer, String> m = new HashMap<>();
		int[] nums = new int[5];
		
		int[] nus = new int[5];
		nums = nus;
		System.out.println(tree.sumDepths(1));
		//tree.printBottom();
	}
	int total = 0;
	public int sumDepths(int k) {
		total += k;
		if(this == null) {
			return total;
		}
		this.leftChild.sumDepths(k + 1);
		this.rightChild.sumDepths(k + 1);
		return total;
		
		
	}
	public Node(int value) {
		this.key = value;
	}
	public int getValue() {
		return this.key;
	}
	public void addValue(int val) {
		if(val < this.key) {
			if(this.leftChild == null) {
				this.leftChild = new Node(val);
			}
			else {
				this.leftChild.addValue(val);
			}
		}
		else if(val > this.key) {
			if(this.rightChild == null) {
				this.rightChild = new Node(val);
			}
			else {
				this.rightChild.addValue(val);
			}
		}
	}
	public void countPointers(Node root) {
		System.out.println(countPointers(root, 0));
	}
	public int countPointers(Node node, int tracker) {
		if(leftChild != null) {
			countPointers(leftChild, tracker + 1);
		}
		if(rightChild != null) {
			countPointers(rightChild, tracker + 1);
		}
		return tracker;
	}
	public void printTree() {
		
		if(this.leftChild != null) {
			this.leftChild.printTree();
		}
		System.out.print(this.getValue() + " ");
		if(this.rightChild != null) {
			this.rightChild.printTree();
		}	
	}
	public Node reverse(Node smth) {
		if(smth == null) {
			return smth;
		}
		Node left = reverse(smth.leftChild);
		Node right = reverse(smth.rightChild);
		smth.leftChild = right;
		smth.rightChild = left;
		return smth;
		
	}
	public void printLeft() {
		if(this.leftChild != null) {
			System.out.print(this.key + " ");
			this.leftChild.printLeft();
		}
		else {
			System.out.print(this.key);
		}
	}
	public int bstChecker() {
		int track = 1;
		if(leftChild != null) {
			if(this.key < this.leftChild.key) {
				return 0;
			}
			else {
				track = this.leftChild.bstChecker();
			}
		}
		if(track == 0) {
			return 0;
		}
		if(rightChild != null) {
			if(this.key > this.rightChild.key) {
				return 0;
			}
			else {
				track = this.rightChild.bstChecker();
			}
		}
		if(track == 0) {
			return 0;
		}
		return 1;
	}
	/*public void printBottom(){
		ArrayList<Integer> something = new ArrayList<Integer>();
		printBottom(something);
	}
	(public int[] printBottom(ArrayList<Integer> arrList) {
		int[] arr = new int[arrList.size() + 1];
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = arrList.get(i);
		}
		if(leftChild == null && rightChild == null) {
			arr
		}
		else {
			if(leftChild != null) {
				leftChild.printBottom();
			}
			if(rightChild != null){
				rightChild.printBottom();
			}
		}
		
	}*/
}

