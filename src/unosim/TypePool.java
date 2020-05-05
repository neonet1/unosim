package unosim;
import java.util.ArrayList;

public class TypePool {
	
	private int size = 0;
	private ArrayList<Type> pool = new ArrayList<Type>();
	
	public ArrayList<Type> getPool() {
		return this.pool;
	}
	
	public boolean addType(Type newType) {
		boolean valid = true;
		for (Type already : pool) {
			if (newType.sharesNameOrId(already)) {
				valid = false;
				break;
			}
		}
		if (valid) {
			pool.add(newType);
			size++;
			return true;
		}
		return false;
		//boolean says if adding was successfull
	}
	
	public void removeType(Type t) {
		this.pool.remove(t);
	}
	
	public void removeType(int index) {
		this.pool.remove(index);
	}
	
	public void clearAllSub() {
		for (Type t : pool) {
			t.clearSub();
		}
	}
	
}
