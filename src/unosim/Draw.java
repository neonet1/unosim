package unosim;

public class Draw extends Deck {

	public Draw() {}
	
	public Draw(Deck d) {
		this.deck = d.getList();
	}
	
	public Card draw() {
		return deck.pop();
	}
	
	public void reset(Discard p) {
		deck.addAll(p.getList());
		shuffle();
	}
	
}
