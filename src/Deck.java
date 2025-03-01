import java.util.ArrayList;
import java.util.Collections;

public class Deck {


    private ArrayList<Card> deck = new ArrayList<>();
    public int size = 24;

    public Deck() {
        Ranks[] ranks = {Ranks.NINE,Ranks.TEN,Ranks.JACK,
                Ranks.QUEEN,Ranks.KNIGHT,Ranks.ACE};
        Suits[] suits = {Suits.HEART,Suits.CLOVER,Suits.PIKE,Suits.TILE};
        //Heart → \u2665, Tile → \u2666, Clover → \u2663, Pike → \u2660
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck.add(new Card(ranks[i], suits[j]));
            }
        }
    }

    public void shuffleCards() {
        Collections.shuffle(deck);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void showDeck(){
        for (Card card : deck) {
            System.out.print(card+" ");
        }
    }

    public int getSize() {
        return size;
    }

    public void showDeck2(){
        int counter = 1;
        for (Card card : deck) {
            System.out.print(counter+") "+card+" ");
            counter++;
        }
    }

}
