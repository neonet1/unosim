package unosim;
import java.util.LinkedList;
import java.util.Collections;

public class Deck {
	
	
	LinkedList<Card> deck = new LinkedList<Card>();
	
	//THERE ARE 59 DISTINCT CARD TYPES
	
	public Deck() {}
	
	//this constructor is a multiplicity config to deck number function
	public Deck(Integer[] config) {
		fillDeck(config);
	}
	
	public void fillDeck(Integer[] config) {
		//for regulars (number and action)
		for (int color = 0; color < 4; color++) {
			for (int symbol = 0; symbol < 14; symbol++) {
				//add the card with symbol symbol and color color x number of times
				//x = (color * 13) + symbol
				//System.out.println(14 * color + symbol);
				for (int i = 0; i < config[(14 * color + symbol)]; i++) {
					deck.push(new Card(symbol, color));
					//System.out.println("pushed");
				}
			}
		}
		//for wilds
		for (int symbol = 14; symbol < 17; symbol++) {
			//add the card with symbol and 4 color x number of times
			//x = (4 * 13) + symbol
			//System.out.println(14 * 4 + symbol - 14); an offset is used
			for (int i = 0; i < config[(14 * 4 + symbol - 14)]; i++) {
				deck.push(new Card(symbol, 5));
				//System.out.println("pushed");
			}
		}
	}
	
	public LinkedList<Card> getList() {
		return this.deck;
	}
	
	public void shuffle() {
		Collections.shuffle(this.deck);
	}
	
	public static void main(String[] args) {
		Integer[] testconfig = new Integer[59]; //59 card types
		for (int i = 0; i < 59; i++) {
			testconfig[i] = 1+ i % 4; //a test multiplicity assignment
		}
		Deck d = new Deck(testconfig);
		d.shuffle();
		for (Card c : d.getList()) {
			c.printCard();
		}
	}
	
}

