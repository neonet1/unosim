package unosim;
import java.util.ArrayList;

public class Type {

	/*A Type has 3 identifiers: a hexcode id, a String name, and a List of subTypes. 
	  The hexcode is interpreted both numerically and as color, while the name String name
	  is used as-is. The identifiers are used in the graphical engine. Which is used depends
	  on its position in a card.*/
	//There is a special UNO/DOS graphics interpreter for preset types
	//but we can make a general graphics interpreter for types based on these variables.
	private int id;
	private String name;
	private ArrayList<Type> subTypes = new ArrayList<Type>(20);
	
	public Type(int i, String n) {
		this.id = i;
		this.name = n;
	}
	
	public Type(int i, String n, ArrayList<Type> subs) {
		this.id = i;
		this.name = n;
		this.subTypes = subs;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Type evaluate(int index) {
		return subTypes.get(index);
	}
	
	public void addSubType(Type t) {
		if (!subTypes.contains(t)) {
			subTypes.add(t);
		}
	}
	
	public void removeSubType(Type t) {
		if (!subTypes.contains(t)) {
			subTypes.remove(t);
		}
	}
	
	public boolean isSubTypeOf(Type B) {
		if (subTypes.contains(B)) {
			return true;
		}
		return false;
	}
	
	//The similarity methods. Should equals be a || or && statement?
	//Should I also check subTypes?
	public boolean sharesNameOrId(Type t) {
		if (this.name.equals(t.getName()) || this.id == t.getId()) {
			return true;
		}
		return false;
	}
	
	public boolean equals(Type t) {
		if (this.name.equals(t.getName()) && this.id == t.getId()) {
			return true;
		}
		return false;
	}
	
	public boolean isChoice() {
		if (!subTypes.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void clearSub() {
		this.subTypes.clear();
	}
	
	public void printType() {
		System.out.println(name + "/" + id);
	}
}
