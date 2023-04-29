package dataStructures;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	private Vertice trie;
	public static void main(String[] args) {
		Trie tri = new Trie();
		tri.insert("hello");
		tri.insert("goodbye");
		System.out.println(tri.findWord("goodbye"));
	}
	public Trie() {
		trie = new Vertice('\0');
	}
	public void insert(String str) {
		Vertice cur = this.trie;
		while(str.length() != 1) {
			System.out.println(str.charAt(0));
			cur.children.put(str.charAt(0), new Vertice(str.charAt(0)));
			cur = cur.children.get(str.charAt(0));
			str = str.substring(1);
		}
		cur.children.put(str.charAt(0), new Vertice(str.charAt(0)));
	}
	public boolean findWord(String str) {
		Vertice cur = this.trie;
		while(str.length() != 1) {
			if(!cur.children.containsKey(str.charAt(0))) {
				return false;
			}
			cur = cur.children.get(str.charAt(0));
			str = str.substring(1);		
		}
		if(!cur.children.containsKey(str.charAt(0))) {
			return false;
		}
		return true;
	}
	
}

