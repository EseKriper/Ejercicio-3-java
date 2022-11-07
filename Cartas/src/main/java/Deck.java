import java.util.*;

public class Deck{
    public static void main(String[] args){
        Card card;
        int cartas;
        ArrayList<String> deck;
        
        card = new Card();
        cartas = card.valor.length;
        deck = new ArrayList<>();
        
        System.out.print("\n");
        System.out.print("Mostrando cartas:\n");
        for (int i = 0; i < cartas; i++){
                deck.add(card.palo[0]+ "-"+card.color[1]+"-" + card.valor[i]);
                deck.add(card.palo[1]+ "-"+card.color[0]+"-" + card.valor[i]);
                deck.add(card.palo[2]+ "-"+card.color[1]+"-" + card.valor[i]);
                deck.add(card.palo[3]+ "-"+card.color[0]+"-" + card.valor[i]);
        }
        for (String elemento : deck){
            System.out.print(elemento+" || ");
        } 
        System.out.print("\n");
        shuffle(deck);
        head(deck);
        pick(deck);
        hand(deck);
    }

    public static void shuffle (ArrayList deck){
        ArrayList<String> values = deck;
        Collections.shuffle(values);
        System.out.println("\nSe mezcló el Deck. Asi quedarón las cartas:");
        Iterator<String> mezclador;
        mezclador = deck.iterator();
        while(mezclador.hasNext()){
            String elemento = mezclador.next();
            System.out.print(elemento+" || ");
        } System.out.print("\n");
    }

    public static void head(ArrayList deck){
        System.out.println("\nLa primera carta es: "+deck.get(0));
        deck.remove(0);
        System.out.println("Quedan " + deck.size() + " cartas en la baraja \n");
    }

    public static void pick(ArrayList  deck){
        Random randomizador = new Random();
        System.out.println("Se toma la carta: "+deck.get(randomizador.nextInt(deck.size())));
        deck.remove(randomizador.nextInt(deck.size()));
        System.out.println("Quedan " + deck.size() + " cartas en la baraja \n");
    }

    public static void hand(ArrayList deck){
        for(int i=0; i<=4; i++){
            System.out.println(deck.get(i));
        }
        for(int i=0; i<=4; i++){
            deck.remove(i);
        }
        System.out.println("\nQuedan " + deck.size()+ " cartas\n");
    }
}
