package unosim;

public class Discard extends Deck{
	
	//private boolean effectUsed = true;
	
	public Discard() {}
	
	public boolean discard(Card c) {
		//boolean to confirm the insertion occurred
		Card top = this.deck.peek();
		if (top.connectsTo(c)) {
			this.deck.push(c);
			return true;
		}
		else {
			System.out.println("try another card");
			return false;
		}
	}
	
	public void clear() {
		this.deck.clear();
	}
	
	
}
