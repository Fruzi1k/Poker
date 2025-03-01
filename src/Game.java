import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public void start(){
        Player player = new Player("Gamer_1");
        Player player2 = new Player("Gamer_2");
        Deck deck = new Deck();
        System.out.println("Cards in Deck");
        deck.showDeck();
        System.out.println("\nShuffle Deck");
        deck.shuffleCards();
        deck.showDeck();
        giveCard(player,player2,deck);
        System.out.print("\n"+player.getName());
        player.displayHand();
        System.out.print("\n"+player2.getName());
        player2.displayHand();
        System.out.println("****");
        System.out.println("Ruch gracza Player "+player.getName());
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbe kart do wyminy: ");
        int liczba = sc.nextInt();
        if(liczba != 0){
            System.out.println("Wskaz karty do wymiany");
            wymianyCard(player,deck);
        }
        System.out.println("\n****");
        System.out.println("Ruch gracza Player"+player2.getName());
        System.out.print("Podaj liczbe kart do wyminy: ");
        liczba = sc.nextInt();
        if(liczba != 0){
            System.out.println("Wskaz karty do wymiany");
            wymianyCard(player2,deck);
        }
        HandType p1 = player.CheckCombination();
        HandType p2 = player2.CheckCombination();
        player.CheckCombination();
        player2.CheckCombination();
        System.out.println("-------------------------------------");
        System.out.print(player.getName()+" "+p1.getDescription());
        player.displayHand();
        System.out.print(player2.getName()+" "+p2.getDescription());
        player2.displayHand();

    }

    public void start2(){
        Player P1 = new Player("Gamer_1");
        Player P2 = new Player("Gamer_2");
        Deck deck = new Deck();
        System.out.println("Cards in Deck");
        deck.showDeck2();
        System.out.println("\n"+P1.getName()+" Podaj carty jaki chcesz");
        poberanieCard(P1,deck);
        deck.showDeck2();
        System.out.println("\n"+P2.getName()+" Podaj carty jaki chcesz");
        poberanieCard(P2,deck);
        System.out.println("-----------------------------------------------");
        HandType p1 = P1.CheckCombination();
        HandType p2 = P2.CheckCombination();
        System.out.print(P1.getName()+" "+p1.getDescription());
        P1.displayHand();
        System.out.print(P2.getName()+" "+p2.getDescription());
        P2.displayHand();
        if(Integer.compare(p1.getWeight(), p2.getWeight())<0){
            System.out.println(P1.getName()+" You WIN!!!");
        }else if(Integer.compare(p1.getWeight(), p2.getWeight())>0){
            System.out.println(P2.getName()+" You WIN!!!");
        }else{
            if(P1.checkHand()>P2.checkHand()){
                System.out.println(P1.getName()+" WIN!!!");
            }else if(P2.checkHand()>P1.checkHand()){
                System.out.println(P2.getName()+" WIN!!!");
            }else{
                System.out.println("Both WIN!!!");
            }
        }







    }


    private void poberanieCard(Player player, Deck deck) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] cards = line.split(" ");
        for(int i = 0; i < cards.length; i++){
            int card = Integer.parseInt(cards[i]);
            player.getHand().add(deck.getDeck().get(card-1));
        }
        deck.getDeck().removeAll(player.getHand());
        System.out.print(player.getName()+" ");
        player.displayHand();
    }


    private static void wymianyCard(Player player, Deck deck) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] cards = line.split(" ");
        for (int i = 0; i < cards.length; i++) {
            int card = Integer.parseInt(cards[i]);
            player.getHand().set(card-1,deck.getDeck().get(i));
            //deck.getDeck().remove(card-1);
        }
        deck.getDeck().removeAll(player.getHand());
        System.out.print(player.getName()+" ");
        player.displayHand();

    }

    private static void giveCard(Player player, Player player2, Deck deck) {
        ArrayList<Card> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                temp.add(deck.getDeck().get(i));
                player.getHand().addAll(temp);
                temp.clear();
            }else {
                temp.add(deck.getDeck().get(i));
                player2.getHand().addAll(temp);
                temp.clear();
            }
        }
        deck.getDeck().removeAll(player.getHand());
        deck.getDeck().removeAll(player2.getHand());
        System.out.println();
        deck.showDeck();
    }
}
