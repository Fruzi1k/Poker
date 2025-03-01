import java.util.ArrayList;
import java.util.List;

public class Card implements Comparable<Card>{


    public Suits suit; //масть
    public Ranks rank; //тип карты

    public Card(Ranks rank,Suits suit) {
        this.suit = suit;
        this.rank = rank;
    }



    public Suits getSuit() {
        return suit;
    }



    public Ranks getRank() {
        return rank;
    }



    @Override
    public String toString() {
        return rank.getDescription()+suit.getDescription();
    }

    @Override
    public int compareTo(Card o) {
        int rank = Integer.compare(this.rank.getWeight(), o.getRank().getWeight());
        return rank == 0 ? this.suit.compareTo(o.suit) : rank;
    }
}


