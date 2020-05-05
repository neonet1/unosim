package unosim;
import java.util.LinkedList;

public class Card {
	
	//dont know if to make card persistence or deck persistence
	private boolean isPersistent = false;
	
	//can be generalized with array later
	private LinkedList<Type> type1 = new LinkedList<Type>();
	private LinkedList<Type> type2 = new LinkedList<Type>();

	
	public Card(Type A, Type B) {
		type1.push(A);
		type2.push(B);
	}
	
	public Card(Type A, Type B, boolean p) {
		type1.push(A);
		type2.push(B);
		isPersistent = p;
	}
	
	//changes a card's active (top) type to a subtype of its current active type
	//int parameter to choose between type slots (can be generalized later)
	public void evaluate(int typeNumber, int subIndex) {
		if(typeNumber == 0) {
			type1.push(type1.peek().evaluate(subIndex));
		}
		else {
			type2.push(type2.peek().evaluate(subIndex));
		}
	}
	
	
	//restores a card to its original types
	//can be generalized later
	public void restore() {
		for (int i = 1; i < type1.size(); i++) {
			type1.pop();
		}
		for (int i = 1; i < type2.size(); i++) {
			type2.pop();
		}
	}
	
	public void printCard() {
		System.out.println("Type1: " + type1.peek().getName());
		System.out.println("Type2: " + type2.peek().getName());
		System.out.println();
	}
	
}
