package unosim;

public class Hand extends Deck {
		
	public Hand() {}
	
	//this wont change the draw pile
	public void add(Card c) {
		this.deck.push(c);
	}
	
	public Card play(int index) {
		//index bound error handling
		//shoudlnt be invoked due to gui
		if (index < 0 || this.deck.size() <= index) {
			return this.deck.pop();
		}
		return this.deck.remove(index);
	}
	
	public boolean isEmpty() {
		if (this.deck.isEmpty()) {
			return true;
		}
		return false;
	}
	
}
