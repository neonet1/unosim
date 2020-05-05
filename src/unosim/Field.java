package unosim;
import java.util.ArrayList;

//this needs to be overhauled after the engine is implemented
//Do I hardcode actions here as methods? seems so.
//I can make an actions class perhaps to generalize a bit
//Card actions: reverse, skip, draw 2 and draw 4.
//Turn actions: draw, play, pass
//pass and skip are the same:
//pass ends your turn, skip ends the next player's turn
//draw and the draw cards are the same:
//draw gets you one card, draw 2/4 gets the next player 2/4 cards.
//(draw also has a skip effect in the normal UNO ruleset)
//Base Actions: Draw, Skip, Play, Reverse, Swap

public class Field {
	
	
	private Deck cardProfile = new Deck();
	private Discard discardPile = new Discard();
	private Draw drawPile = new Draw();
	private ArrayList<Hand> playerHands = new ArrayList<Hand>();
	
	public Field() {
	}
	
	public void setup() {
		
	}
	
}
