import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand = new ArrayList<>();

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayHand() {
        Collections.sort(hand);
        System.out.print(" [ ");
        for (Card card : hand) {
            System.out.print(card+" ");
        }
        System.out.println("]");
    }

    public void giveCard(Deck deck) {
        ArrayList<Card> temp = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            temp.add(deck.getDeck().get(i*2));
        }
        hand.addAll(temp);
        deck.getDeck().removeAll(temp);

    }



    public HandType CheckCombination() {

        HashMap<Ranks, Integer> ranks = new HashMap<>();
        HashMap<Suits, Integer> suits = new HashMap<>();
        Collections.sort(hand);
        for (Card card : hand) {
            ranks.put(card.getRank(),ranks.getOrDefault(card.getRank(),0)+1);
            suits.put(card.getSuit(),suits.getOrDefault(card.getSuit(),0)+1);
        }
        int maxRank = Collections.max(ranks.values());// максимальное количество карт одного ранга
        int maxSuit = Collections.max(suits.values());// максимальное количествоо карт одной масти

        boolean isStraight = checkStraight(hand,ranks);
        boolean isStraightAndFlush = checkStraightAndFlush(hand,ranks,maxSuit);
        boolean isRoyalFlush = checkRoyalFlush(hand,ranks,maxSuit);

        if(isRoyalFlush){
            return HandType.ROYAL_FLUSH;
        }else if (isStraightAndFlush) {
            return HandType.STRAIGHT_FLUSH;
        }else if(isStraight){
            return HandType.STRAIGHT;
        }else if(maxRank==4 && ranks.size()==2){
            return HandType.FOUR;

        }else if(maxRank ==3 && ranks.size()==2){
            return HandType.FULL_HOUSE;

        } else if(maxSuit==5){
            return HandType.FLUSH;

        }else if (maxRank==3 && ranks.size()==3) {
            return HandType.THREE;

        }else if(maxRank==2 && ranks.size()==3){
            return HandType.TWO_PAIRS;

        } else if (maxRank==2) {

            return HandType.PAIR;

        }else{
            return HandType.HIGHCARD;

        }


    }

    private boolean checkRoyalFlush(List<Card> hand, HashMap<Ranks, Integer> ranks, int maxSuit) {
        if(this.hand.getFirst().getRank().toString().equals("10")&&this.hand.getLast().getRank().toString().equals("Ace") && ranks.size()==5 && maxSuit==5){
            return true;
        }
        return false;
    }

    private boolean checkStraightAndFlush(List<Card> hand, HashMap<Ranks, Integer> ranks, int maxSuit) {
        if(this.hand.getFirst().getRank().toString().equals("9")&&this.hand.getLast().getRank().toString().equals("King") && ranks.size()==5&& maxSuit==5){
            return true;
        }
        return false;
    }

    private boolean checkStraight(List<Card> hand, HashMap<Ranks, Integer> ranks) {
        if(this.hand.getFirst().getRank().toString().equals("10")&&this.hand.getLast().getRank().toString().equals("Ace") && ranks.size()==5
                    || this.hand.getFirst().getRank().toString().equals("9")&&this.hand.getLast().getRank().toString().equals("King") && ranks.size()==5) {
                return true;
        }
        return false;
    }


    public int checkHand() {
        int sum=0;
        for (Card card : hand) {
            sum+=card.rank.getWeight();
        }
        return sum;
    }
}


