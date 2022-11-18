package algorithmsPractice;

public class Test {
	private int val;
	public static void main(String[] args) {
		Test one = new Test(1);
		Test two = one;
		one = new Test(2);
		System.out.println(one.val);
		System.out.println(two.val);
	}
	public Test(int val) {
		this.val = val;
	}
}
