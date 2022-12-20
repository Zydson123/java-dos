import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    TO FIX LIST
    -Some problems with detecting valid cards when choosing 2 cards, if you choose a combo of cards that have more than 10 of value it doesn't tell the that player he's an idiot
    -the first card is ignored when doing 2 cards (dont remember the rules so I don't think its a problem if the first one is fixed)
     */
    public static void main(String[] args) {
        String amount2;
        Card forFill = new Card("pies","pies");
        Stack forFillStack = new Stack(forFill);
        forFill.fillDeck();
        ArrayList<Card> deck = forFill.getDeck();
        Player player1 = new Player("Player 1");
        Player player2= new Player("Player 2");
        Player turn = player1;
        Stack selectedStack = forFillStack;
        boolean isValid=false;
        while(!isValid){
            int cardForStack = (int)(Math.random()* deck.size());
            System.out.println(deck.get(cardForStack).getType());
            if(deck.get(cardForStack).getType()!="#" && deck.get(cardForStack).getType()!="Dos"){
                Stack stack = new Stack(deck.get(cardForStack));
                deck.remove(deck.get(cardForStack));
                forFillStack.getStacks().add(stack);
                break;
            }
        }
        isValid=false;
        while(!isValid) {
            int cardForStack = (int) (Math.random() * deck.size());
            System.out.println(deck.get(cardForStack).getType());
            if (deck.get(cardForStack).getType() != "#" && deck.get(cardForStack).getType() != "2") {
                Stack stack = new Stack(deck.get(cardForStack));
                deck.remove(deck.get(cardForStack));
                forFillStack.getStacks().add(stack);
                break;
            }
        }
        player1.giveCards(deck,player1);
        player2.giveCards(deck,player2);
        /*
        player1.getCards().add(new Card("1", "Red"));
        player1.getCards().add(new Card("1", "Red"));
        player2.getCards().add(new Card("1", "Red"));
        player2.getCards().add(new Card("1", "Red"));
        forFillStack.getStacks().add(new Stack(new Card("1", "Red")));
        forFillStack.getStacks().add(new Stack(new Card("2", "Red")));*/
        while(true){
            if(player1.getCards().size()==0){
                System.out.println("Player 1 won!");
                break;
            }
            else if(player2.getCards().size()==0){
                System.out.println("Player 2 won!");
                break;
            }
            else{
                int which=0;
                System.out.println("it's the turn of: " + turn);
                turn.print_cards();
                forFillStack.print_stacks();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("choose stack you want to put cards into, type in 2137 to skip turn and draw a card");
                    which = scanner.nextInt();
                    which--;
                    if(which==2136){
                        int cardfordraw = (int) (Math.random() * deck.size());
                        turn.getCards().add(deck.get(cardfordraw));
                        if(turn==player1)
                            turn = player2;
                        else
                            turn=player1;
                    }
                    else if(which==-1 || which+1>forFillStack.getStacks().size()){
                            System.out.println("This is not a valid stack!");
                    }
                    else{
                        selectedStack = forFillStack.getStacks().get(which);
                        System.out.println("card on top of selected stack is: " + selectedStack.getCardOnTop());
                        Card cot = selectedStack.getCardOnTop();
                        System.out.println("do you want to use 1 or 2 cards? (if 2 cards then the cards get added together)");
                        int how = scanner.nextInt();
                        if(how==1){
                            turn.print_cards();
                            System.out.println("Select your card");
                            int whichCard = scanner.nextInt();
                            whichCard--;
                            if(whichCard==-1 || which+1>turn.getCards().size()){
                                System.out.println("This is not a valid card!");
                            }
                            else{
                                Card card = turn.getCards().get(whichCard);
                                if(
                                        (cot.getColor() == card.getColor() || cot.getColor()=="None" || card.getColor()=="None")
                                                && (cot.getType() == card.getType() || cot.getType()=="#" || card.getType()=="#"))
                                {
                                    turn.getCards().remove(card);
                                    turn.print_cards();
                                    System.out.println("You have to make a new stack using one of your cards, choose it");
                                    whichCard = scanner.nextInt();
                                    whichCard--;
                                    if(whichCard==-1 || which+1>turn.getCards().size()){
                                        System.out.println("This is not a valid card!");
                                    }
                                    else{
                                        forFillStack.getStacks().add(new Stack(turn.getCards().get(whichCard)));
                                        turn.getCards().remove(turn.getCards().get(whichCard));
                                    }
                                }
                                else if(cot.getColor()== card.getColor() || cot.getColor()=="None" || card.getColor()=="None"){
                                    selectedStack.setCardOnTop(card);
                                    turn.getCards().remove(card);
                                }
                                else if(cot.getType()== card.getType() || cot.getType()=="#" || card.getType()=="#"){
                                    selectedStack.setCardOnTop(card);
                                    turn.getCards().remove(card);
                                }
                            }
                        }
                        else if(how==2){
                            turn.print_cards();
                            System.out.println("Choose your first card");
                            int whichCard = scanner.nextInt();
                            whichCard--;
                            if(whichCard==-1 || which+1>turn.getCards().size()){
                                System.out.println("This is not a valid card!");
                            }
                            else{
                                Card card1 = turn.getCards().get(whichCard);
                                if(card1.getType()=="#"){
                                    System.out.println("Choose the value of your wild card");
                                    Scanner skaner = new Scanner(System.in);
                                    String pies = skaner.nextLine();
                                    card1.setType(pies);
                                }
                                turn.getCards().remove(card1);
                                turn.print_cards();
                                System.out.println("Choose your second card");
                                whichCard = scanner.nextInt();
                                whichCard--;
                                if(whichCard==-1 || which+1>turn.getCards().size()){
                                    System.out.println("This is not a valid card!");
                                }
                                else{
                                    Card card2 = turn.getCards().get(whichCard);
                                    turn.getCards().remove(card2);
                                    String color = card2.getColor();
                                    if(card2.getType()=="#"){
                                        System.out.println("Choose the value of your wild card");
                                        String value = scanner.nextLine();
                                        int amount = Integer.parseInt(card1.getType()) + Integer.parseInt(value);
                                        amount2 = String.valueOf(amount);
                                    }
                                    else{
                                        int amount = Integer.parseInt(card1.getType()) + Integer.parseInt(card2.getType());
                                        amount2 = String.valueOf(amount);
                                    }
                                    if(
                                            (cot.getColor().equals(color) || cot.getColor()=="None" || color=="None")
                                                    && (cot.getType().equals(amount2) || cot.getType()=="#" || card2.getType()=="#"))
                                    {
                                        turn.print_cards();
                                        System.out.println("You have to make a new stack using one of your cards, choose it");
                                        whichCard = scanner.nextInt();
                                        whichCard--;
                                        if(whichCard==-1 || which+1>turn.getCards().size()){
                                            System.out.println("This is not a valid card!");
                                        }
                                        else{
                                            Card card = turn.getCards().get(whichCard);
                                            forFillStack.getStacks().add(new Stack(card));
                                            turn.getCards().remove(card);
                                        }
                                    }
                                    else if(cot.getColor()== color|| cot.getColor()=="None" || color=="None"){
                                        selectedStack.setCardOnTop(card2);
                                    }
                                    else if(cot.getType()== amount2 || cot.getType()=="#" || card2.getType()=="#"){
                                        selectedStack.setCardOnTop(card2);
                                    }
                                }
                            }
                        }
                        else{
                            System.out.println("This is not a valid option!");
                        }
                        if(turn==player1)
                            turn = player2;
                        else
                            turn=player1;
                        }
                }
            }

        }
    }