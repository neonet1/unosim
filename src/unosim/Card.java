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
	
	public Card changeColor(int newColor) {
		return new Card(this.symbol, newColor);
	}
	
	public Card changeSymbol(int newSymbol ) {
		return new Card(newSymbol, this.color);
	}
	
	//accepts gui player input to evaluate wild
	public Card evalWild(int playerColor) {
		return changeColor(playerColor);
	}
	
	//accepts gui player input to evaluate #
	public Card evalSharp(int playerNumber) {
		return changeSymbol(playerNumber);
	}
	
	public boolean matchesNumber(Card c) {
		//if simple match or chosen is #
		if ((c.getSymbol() <= 9 && c.getSymbol() == this.symbol) || (c.getSymbol() == 13 && this.symbol <= 9)) {
			return true;
		}
		return false;
	}
	
	public boolean matchesNumber(Card c1, Card c2) {
		if (this.matchesNumber(c1) && this.matchesNumber(c2)) {
			return true;
		}
		return false;
	}
	
	public boolean matchesColor(Card c) {
		if (this.color == c.getColor() || this.color == 4) {
			return true;
		}
		return false;
	}
	
	public boolean matchesColor(Card c1, Card c2) {
		if (this.matchesColor(c1) && this.matchesColor(c2)) {
			return true;
		}
		return false;
	}
	
	public boolean matchesSymbol(Card c) {
		if (c.getSymbol() == this.symbol || this.matchesNumber(c)) {
			return true;
		}
		return false;
	}
	
	public boolean connectsTo(Card t) {
		//Implicit parameter is the top card
		//Explicit parameter (argument) is the chosen card
		//this follows the useful matches convention
		//simple connectivity (like onto like)
		if (this.matchesSymbol(t) || this.matchesColor(t)) {
			return true;
		}
		//No connectivity
		return false;
	}
	
	public void printCard() {
		System.out.println("Symbol: " + symbol);
		System.out.println("Color: " + color);
		System.out.println();
	}
	
}
