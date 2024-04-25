package University.Java_Using_Project.Experiment5;

import java.util.*;

class Card {
    private char symbol;
    private int value;

    public Card(char symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return symbol + " " + value;
    }
}

class SortBySymbol implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return Character.compare(o1.getSymbol(), o2.getSymbol());
    }
}

class StartGame {
    ArrayList<Card> list = new ArrayList<>();
    Set<Card> cards = new TreeSet<>(new SortBySymbol());
    Map<Character, Boolean> map = new LinkedHashMap<>();

    void process(List<Card> list) {
        for (Card c : list) {
            map.put(c.getSymbol(), true);
        }

        for (Map.Entry<Character, Boolean> m : map.entrySet()) {
            for (Card c : list) {
                if (m.getKey() == c.getSymbol() && m.getValue()) {
                    cards.add(c);
                    map.put(c.getSymbol(), false);
                }
            }
        }
    }

    void display() {
        process(list);
        System.out.println("\nFour symbols gathered in " + list.size() + " cards");
        System.out.println("Cards in Set are:");
        for (Card c : cards) {
            System.out.println(c.getSymbol() + "  ->  " + c.getValue());
        }
    }

    void createCard(char symbol, int value) {
        list.add(new Card(symbol, value));
    }

    void playGame(Scanner in) {
        System.out.println("Enter the number of turns");
        int turns = in.nextInt();
        while (turns > 0) {
            System.out.println("\nEnter 1 for SPADE");
            System.out.println("Enter 2 for DIAMOND");
            System.out.println("Enter 3 for CLUB");
            System.out.println("Enter 4 for HEART\n");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    char symbol = '♠';
                    System.out.print("Enter the value of SPADE card: ");
                    int value = in.nextInt();
                    if (1 <= value && value <= 13) {
                        createCard(symbol, value);
                        turns--;
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
                        turns--;
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
                        turns--;
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
                        turns--;
                    } else {
                        System.out.println("Value is invalid!!!\n");
                    }
                }
                break;
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
        StartGame game = new StartGame();
        game.playGame(in);
        game.display();
        in.close();
    }
}

