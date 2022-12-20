import java.util.ArrayList;

public class Stack {
    private ArrayList<Stack> Stacks = new ArrayList<Stack>();
    private Card cardOnTop;
    private int id;
    public ArrayList<Stack> getStacks() {
        return Stacks;
    }

    public void print_stacks(){
        for(int i=0; i<this.getStacks().size();i++){
            int pies = i+1;
            System.out.println("Card on stack nr " + pies + ": " + this.getStacks().get(i));
        }
    }
    public void setStacks(ArrayList<Stack> stacks) {
        Stacks = stacks;
    }

    public Card getCardOnTop() {
        return cardOnTop;
    }

    public void setCardOnTop(Card cardOnTop) {
        this.cardOnTop = cardOnTop;
    }

    public Stack(Card cardOnTop) {
        this.cardOnTop = cardOnTop;
    }

    @Override
    public String toString() {
        return cardOnTop.getColor() + " " + cardOnTop.getType();
    }
}
