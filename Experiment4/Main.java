package University.Java_Using_Project.Experiment4;


import java.util.*;


class Card {

    private char cardSymbol;
    private int value;

    public Card(char cardSymbol, int value) {
        this.cardSymbol = cardSymbol;
        this.value = value;
    }

    public char getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(char cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


class PlayGame {

    ArrayList<Card> cards = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();
    void createCard(char symbol, int value) {
        cards.add(new Card(symbol, value));
    }

    void calculateTotal() {

        for (Card c : cards) {
            if (c.getCardSymbol() == '♠') {
                int cardValue = c.getValue();
                int value = map.getOrDefault('♠', 0);
                map.put('♠', value + cardValue);
            } else if (c.getCardSymbol() == '♦') {
                int cardValue = c.getValue();
                int value = map.getOrDefault('♦', 0);
                map.put('♦', value + cardValue);
            } else if (c.getCardSymbol() == '♣') {
                int cardValue = c.getValue();
                int value = map.getOrDefault('♣', 0);
                map.put('♣', value + cardValue);
            } else if (c.getCardSymbol() == '❤') {
                int cardVale = c.getValue();
                int value = map.getOrDefault('❤', 0);
                map.put('❤', value + cardVale);
            }
        }
    }


    void display() {
        calculateTotal();
        System.out.println("\nDistinct Symbols are:");
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            System.out.println("Cards in " + e.getKey() + " Symbol");
            int cardCount = 0;
            for (Card c : cards) {
                if (c.getCardSymbol() == e.getKey()) {
                    System.out.println(c.getCardSymbol() + " : " + c.getValue());
                    cardCount++;
                }
            }
            System.out.println("Number of " + e.getKey() + " cards: " + cardCount);
            System.out.println("Sum of Number: " + e.getValue() + "\n");
        }
    }

    void play(Scanner in) {
        System.out.println("Enter the number of cards");
        int numberOfCards = in.nextInt();
        int i = 0;
        while (i < numberOfCards) {

            System.out.println("\nEnter 1 for SPADE");
            System.out.println("Enter 2 for DIAMOND");
            System.out.println("Enter 3 for CLUB");
            System.out.println("Enter 4 for HEART\n");
            if (i == 0) {
                System.out.print("Enter 1st card: ");
            } else if (i == 1) {
                System.out.print("Enter 2nd card: ");
            } else if (i == 2) {
                System.out.print("Enter 3rd card: ");
            } else {
                System.out.print("\nEnter " + (i + 1) + "th card: ");
            }
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    char symbol = '♠';
                    System.out.print("Enter the value of SPADE card: ");
                    int value = in.nextInt();
                    if (1 <= value && value <= 13) {
                        createCard(symbol, value);
                        i++;
                    } else {
                        System.out.println("Value is invalid!!!");
                    }

                }
                break;
                case 2: {
                    char symbol = '♦';
                    System.out.print("Enter the value of DIAMOND card: ");
                    int value = in.nextInt();
                    if (1 <= value && value <= 13) {
                        createCard(symbol, value);
                        i++;
                    } else {
                        System.out.println("Value is invalid!!!");
                    }
                }
                break;
                case 3: {
                    char symbol = '♣';
                    System.out.print("Enter the value of CLUB card: ");
                    int value = in.nextInt();
                    if (1 <= value && value <= 13) {
                        createCard(symbol, value);
                        i++;
                    } else {
                        System.out.println("Value is invalid!!!");
                    }
                }
                break;
                case 4: {
                    char symbol = '❤';
                    System.out.print("Enter the value of HEART card: ");
                    int value = in.nextInt();
                    if (1 <= value && value <= 13) {
                        createCard(symbol, value);
                        i++;
                    } else {
                        System.out.println("Value is invalid!!!\n");
                    }
                }
                default: {
                    System.out.println("WRONG choice");
                }
                break;
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PlayGame game = new PlayGame();
        game.play(in);
        game.display();
    }
}

