package dataStructures;

public class Entry {
	private int key;
	private Entry next;
	private String name;
	private int val;
	private String DOB;//Date of birth
	public Entry(int key, String name, String DOB) {
		this.key = key;
		this.name = name;
		this.DOB = DOB;
	}
	public Entry(int key, int val) {
		this.key = key;
		this.val = val;
	}
	public void display() {
		System.out.println("name: " + name + "\n Date of Birth: " + DOB);
	}
}
