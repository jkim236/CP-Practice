package dataStructures;

public class LinkedList {
	Node1 head;
	LinkedList next;
	public LinkedList(int data) {
		this.head = new Node1(data);
	}
	public void append(int data) {
		Node1 current = this.head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new Node1(data);
	}
	public void prepend(int data) {
		Node1 temp = new Node1(data);
		temp.next = this.head;
		this.head = temp;
	}
	public void printlist() {
		Node1 curr = this.head;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	public void deleteValue(int num) {
		Node1 temp = this.head;
		while(temp != null) {
			if(temp.next.data == num) {
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
			
		}
	}
	public void findMid(LinkedList list) {
		int length = 0;
		Node1 temp = list.head;
		while(temp != null) {
			length ++;
			temp = temp.next;
		}
		int count = 0;
		temp = list.head;
		while(count < length/2) {
			temp = temp.next;
			count ++;
		}
		System.out.print("\n"+ temp.data);
	}
}


