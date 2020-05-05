package unosim;
import java.util.LinkedList;
import java.util.Collections;

public class Deck {
	
	LinkedList<Card> deck = new LinkedList<Card>();
	
	public Deck() {}
	
	//this constructor is a multiplicity config to deck number function
	//public Deck() {
		//fillDeck(config);
	//}
	
	/*
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
		//for regular wild and +4
		for (int symbol = 14; symbol < 16; symbol++) {
			//add the card with symbol and 4 color x number of times
			//x = (4 * 13) + symbol
			//System.out.println(14 * 4 + symbol - 14); an offset is used
			for (int i = 0; i < config[(14 * 4 + symbol - 14)]; i++) {
				deck.push(new Card(symbol, 5));
				//System.out.println("pushed");
			}
		}
		//for 2 wild
		for (int i = 0; i < config[(14 * 4 + 17 - 14)]; i++) {
			deck.push(new Card(2, 4));
		}
	}
	*/
	public LinkedList<Card> getList() {
		return this.deck;
	}
	
	public void fillDeck(Deck d) {
		this.deck = d.getList();
	}
	
	public void shuffle() {
		Collections.shuffle(this.deck);
	}
	
	public boolean isEmpty() {
		return this.deck.isEmpty();
	}
	
}

