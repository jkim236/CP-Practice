package dataStructures;

import java.util.HashMap;

public class Vertice{
	private char data;
	HashMap<Character,Vertice> children;
	boolean isCompleteWord;
	public Vertice(char car) {
		data = car;
		children = new HashMap<>();
	}
}
