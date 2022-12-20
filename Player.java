import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> Cards = new ArrayList<Card>();
    ;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return Cards;
    }
    public void print_cards(){
        System.out.println("Cards of: " + this.getName());
        for(int i=0;i<this.getCards().size();i++){
            System.out.println(i+1 + " " + this.getCards().get(i));
        }
    }

    public void setCards(ArrayList<Card> cards) {
        Cards = cards;
    }

    public void giveCards(ArrayList<Card> Deck, Player player) {
        int cardId = (int) (Math.random() * Deck.size());
        while (player.getCards().size() != 7) {
            cardId = (int) (Math.random() * Deck.size());
            Card card = Deck.get(cardId);
            player.getCards().add(card);
            Deck.remove(card);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
