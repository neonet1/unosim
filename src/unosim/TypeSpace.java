package unosim;
import java.util.ArrayList;

public class TypeSpace {

	private String description = "can be placed on";
	private int size = 0;
	private ArrayList<Type> space = new ArrayList<Type>();
	private ArrayList<ArrayList<Type>> relations = new ArrayList<ArrayList<Type>>();
	//An active Type and its relations will have the same index as per the adding process.
	//SubTypes are not edited here due to conflict with relations Lists.
	/*In effect, TypePool is for creation of Types and SubTypes, while
	TypeSpace is for establishing relations among said Types and SubTypes.
	Creation adder methods added as formality, may remove.
	One can create and use more than one TypeSpace per TypePool, with planned .txt import/export*/
	
	public TypeSpace(TypePool p) {
		this.space = p.getPool();
	}
	
	public TypeSpace(String d) {
		this.description = d;
	}
	
	public ArrayList<Type> getSpace() {
		return this.space;
	}
	
	public ArrayList<ArrayList<Type>> getRelationList() {
		return this.relations;
	}
	
	public Type getType(int index) {
		return this.space.get(index);
	}
	
	public ArrayList<Type> getRelations(int index) {
		return this.relations.get(index);
	}
	
	//Type addition methods
	public boolean addType(int id, String name) { //brand new Type
		return addType(new Type(id, name));
	}
	
	public boolean addType(Type newType) { //should I check uniqueness when adding                                  //
		boolean valid = true;              //if they all come from TypePool?
		for (Type already : space) {
			if (newType.sharesNameOrId(already)) {
				valid = false;
				break;
			}
		}
		if (valid) {
			space.add(newType);
			relations.add(new ArrayList<Type>());
			size++;
			return true;
		}
		return false;
		//boolean says if adding was successfull
	}
	
	//Type removal methods
	public void removeType(int index) {
		this.relations.remove(index);
		this.space.remove(index);
	}
	
	public void removeType(Type t) {
		for (int i = 0; i < size; i++) {
			if (t.equals(space.get(i))) {
				removeType(i);
				break;
			}
		}
	}
	
	//Establish A -> B in this TypeSpace methods
	public void connectTo(int a, int b) {       //should I add returning ints 
		ArrayList<Type> old = relations.get(a); //for success, failure, and invalid?
		old.add(space.get(b));                  //I did it for connects
		relations.set(a, old);
	}
	
	public void connectTo(Type A, Type B) {
		int a = this.indexOf(A);
		int b = this.indexOf(B);
		if (a > -1 && b > -1) {
			connectTo(a, b);
		}
	}
	
	//A -> B in this TypeSpace? inquiry methods.
	//ints used for intermediate state in overload (invalid Types)
	//I have to check if these contains methods even work (they do when using variables)
	public int connects(int a, int b) {
		if (relations.get(a).contains(space.get(b))) {
			return 1;
		}
		return 0;
	}
	
	public int connects(Type A, Type B) {
		int a = this.indexOf(A);
		int b = this.indexOf(B);
		if (a > -1 && b > -1) {
			return this.connects(a, b);
		}
		return -1;
	}
	
	//Contains A inquiry method
	public boolean contains(Type A) {
		if (indexOf(A) == -1) {
			return false;
		}
		return true;
	}
	
	public int indexOf(Type A) {
		for (int i = 0; i < size; i++) {
			if (A.equals(space.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	//Relation (->) clearing methods
	public void clearRelations(int a) {
		relations.set(a, new ArrayList<Type>());
	}
	
	public void clearRelations(Type A) { //add int confirmation?
		int a = this.indexOf(A);
		if (a > -1) {
			clearRelations(a);
		}
	}

	public void clearAllRelations() {
		for (ArrayList<Type> r : relations) {
			r.clear();
		}
	}
	
	//debug printing method
	public void printSpace() {
		for (int i = 0; i < size; i++) {
			int a = space.get(i).getId();
			System.out.println("-----------------------------");
			String b = space.get(i).getName();
			System.out.println("The following Types " + description + " " + b + "/" + a);
			System.out.println("-----------------------------");
			for (Type t : relations.get(i)) {
				//System.out.println("---------");
				t.printType();
				//System.out.println("---------");
			}
		}
		System.out.println();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
	}
	
}
