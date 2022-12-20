import java.util.ArrayList;

public class Card {
    private String type;
    private String color;
    private ArrayList<Card> Deck = new ArrayList<Card>();
    private int id;

    public Card(String type, String color) {
        this.type = type;
        this.color = color;
        this.id++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Card> getDeck() {
        return Deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        Deck = deck;
    }

    @Override
    public String toString() {
        String msg;
        if(this.getType()=="#"){
            msg = this.getColor() + " Wild Card";
        }
        else if(this.getColor()!="None"){
            msg = this.getColor() + " " + this.getType();
        }
        else{
            msg = this.getType();
        }
        return msg;
    }

    public void fillDeck(){
        for(int i=0;i<3;i++){
            Deck.add(new Card("1","Red"));
            Deck.add(new Card("3","Red"));
            Deck.add(new Card("4","Red"));
            Deck.add(new Card("5","Red"));

            Deck.add(new Card("1","Blue"));
            Deck.add(new Card("3","Blue"));
            Deck.add(new Card("4","Blue"));
            Deck.add(new Card("5","Blue"));

            Deck.add(new Card("1","Yellow"));
            Deck.add(new Card("3","Yellow"));
            Deck.add(new Card("4","Yellow"));
            Deck.add(new Card("5","Yellow"));

            Deck.add(new Card("1","Green"));
            Deck.add(new Card("3","Green"));
            Deck.add(new Card("4","Green"));
            Deck.add(new Card("5","Green"));
        }
        for(int i=0; i<2;i++){
            Deck.add(new Card("6","Red"));
            Deck.add(new Card("7","Red"));
            Deck.add(new Card("8","Red"));
            Deck.add(new Card("9","Red"));
            Deck.add(new Card("10","Red"));
            Deck.add(new Card("#","Red"));

            Deck.add(new Card("6","Blue"));
            Deck.add(new Card("7","Blue"));
            Deck.add(new Card("8","Blue"));
            Deck.add(new Card("9","Blue"));
            Deck.add(new Card("10","Blue"));
            Deck.add(new Card("#","Blue"));

            Deck.add(new Card("6","Green"));
            Deck.add(new Card("7","Green"));
            Deck.add(new Card("8","Green"));
            Deck.add(new Card("9","Green"));
            Deck.add(new Card("10","Green"));
            Deck.add(new Card("#","Green"));

            Deck.add(new Card("6","Yellow"));
            Deck.add(new Card("7","Yellow"));
            Deck.add(new Card("8","Yellow"));
            Deck.add(new Card("9","Yellow"));
            Deck.add(new Card("10","Yellow"));
            Deck.add(new Card("#","Yellow"));
        }
        for(int i=0;i<12;i++){
            Deck.add(new Card("Dos","None"));
        }

    }
}
