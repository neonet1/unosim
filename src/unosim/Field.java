package unosim;
import java.util.LinkedList;

public class Field {
	
	//config is just an array
	//the configuration table is available in the readme
	private Integer[][] fieldConfig = new Integer[2][59];
	private Deck cardProfile = new Deck();
	private Discard discardPile = new Discard();
	private Draw drawPile = new Draw();
	private LinkedList<Hand> playerHands = new LinkedList<Hand>();
	
	public Field(Integer[][] configurations) {
		this.fieldConfig = configurations;
		cardProfile.fillDeck(fieldConfig[0]);
	}
	
	public void setup() {
		
	}
	
}
