import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Card forFill = new Card("pies","pies");
        Stack forFillStack = new Stack(forFill);
        forFill.fillDeck();
        ArrayList<Card> deck = forFill.getDeck();
        int playerAmount = 2;
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
            if (deck.get(cardForStack).getType() != "#" && deck.get(cardForStack).getType() != "Dos") {
                Stack stack = new Stack(deck.get(cardForStack));
                deck.remove(deck.get(cardForStack));
                forFillStack.getStacks().add(stack);
                break;
            }
        }
        player1.giveCards(deck,player1);
        player2.giveCards(deck,player2);
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
                forFillStack.print_stacks();
                    turn.print_cards();
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
                    else{
                        if(which==-1 || which>forFillStack.getStacks().size()){
                            System.out.println("This is not a valid stack!");
                        }
                        else{
                            selectedStack = forFillStack.getStacks().get(which);
                            System.out.println("card on top of selected stack is: " + selectedStack.getCardOnTop());
                            if(turn==player1)
                                turn = player2;
                            else
                                turn=player1;
                        }
                    }


                }
            }

        }
    }