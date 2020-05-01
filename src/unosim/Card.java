package unosim;

public class Card {

	private int symbol;
	private int color;
	
	public Card(int s, int c) {
		this.symbol = s;
		this.color = c;
	}
	
	public int getSymbol() {
		return this.symbol;
	}
	
	public int getColor() {
		return this.color;	
	}
	
	public boolean connectsTo(Card t) {
		//Implicit parameter is the top card
		//Explicit parameter (argument) is the chosen card
		//this follows the useful matches convention
		//simple connectivity (like onto like)
		if (this.color == t.getColor() || this.symbol == t.getSymbol()) {
			return true;
		}
		//chosen wild cards onto anything
		else if (t.getColor() == 4) {
			return true;
		}
		//chosen # card onto numbers
		else if (0 <= t.getSymbol() && t.getSymbol() <= 9 && this.symbol == 13) {
			return true;
		}
		//chosen 2 onto wild 2
		else if (this.symbol == 16 && t.getSymbol() == 2) {
			return true;
		}
		//No connectivity
		else {
			return false;
		}
	}
	
	public boolean matchesNumber(Card c) {
		if (0 <= c.getSymbol() && c.getSymbol() <= 9) {
			//if simple match or chosen is #
			if (c.getSymbol() == this.symbol || c.getSymbol() == 13) {
				return true;
			}
			else if (c.getSymbol() == 2) {
				if (this.symbol == 16 || this.symbol == 2) {
					return true;
				}
				return false;
			}
			return false;
		}
		else if (c.getSymbol() == 16) {
			if (this.symbol == 16 || this.symbol == 2) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean matchesNumber(Card c1, Card c2) {
		if (this.matchesNumber(c1) && this.matchesNumber(c2)) {
			return true;
		}
		return false;
	}
	
	public void printCard() {
		System.out.println("Symbol: " + symbol);
		System.out.println("Color: " + color);
		System.out.println();
	}
	
}
