package com.examples.defaultmethods;

import java.util.*;
import java.util.stream.*;

public class StandardDeck implements Deck {
    
    private List<Card> entireDeck;

    public StandardDeck(List<Card> existingList) {
        this.entireDeck = existingList;
    }

    public StandardDeck() {
        this.entireDeck = new ArrayList<>();
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Rank r : Card.Rank.values()) {
                this.entireDeck.add(new PlayingCard(r, s));
            }
        }
    }

    public Deck deckFactory() {
        return new StandardDeck(new ArrayList<Card>());
    }

    public int size() {
        return entireDeck.size();
    }

    public List<Card> getCards() {
        return entireDeck;
    }

    public void addCard(Card card) {
        entireDeck.add(card);
    }

    public void addCards(List<Card> cards) {
        entireDeck.addAll(cards);
    }

    public void addDeck(Deck deck) {
        List<Card> listToAdd = deck.getCards();
        entireDeck.addAll(listToAdd);
    }

    /* Collections.sort sorts an instance of `List` whose element
     * type implements the interface Comparable. (The member `entireDeck`
     * is an instance of List whose elements are of the type `Card`, which
     * extends `Comparable`. The class `Playing card` implements the
     * `Comparable.compareTo` method.)
    */
    public void sort() {
        Collections.sort(entireDeck);
    }

    /* To modify the sort order such that the deck is first sorted by the
     * rank, then by the suit. The `Comparator` interface allows for the
     * specification of a new sorting criteria
    */
    public void sort(Comparator<Card> c) {
        Collections.sort(entireDeck, c);
    }

    public void shuffle() {
        Collections.shuffle(entireDeck);
    }

    public String deckToString() {
        return this.entireDeck
            .stream()
            .map(Card::toString)
            .collect(Collectors.joining("\n"));
    }

    public Map<Integer, Deck> deal(int players, int numberOfCards)
        throws IllegalArgumentException {
        int cardsDealt = players * numberOfCards;
        int sizeOfDeck = entireDeck.size();
        if (cardsDealt > sizeOfDeck) {
            throw new IllegalArgumentException(
                "Number of players (" + players +
                ") times number of cards to be dealt (" + numberOfCards +
                ") is greater than the number of cards in the deck (" +
                sizeOfDeck + ")."
            );
        }

        Map<Integer, List<Card>> dealtDeck = entireDeck
            .stream()
            .collect(
                Collectors.groupingBy(
                    card -> {
                        int cardIndex = entireDeck.indexOf(card);
                        if (cardIndex >= cardsDealt) return (players + 1);
                        else return (cardIndex % players) + 1;
                    }
                )
            );
        // Convert Map<Integer, List<Card>> to Map<Integer, Deck>
        Map<Integer, Deck> mapToReturn = new HashMap<>();
        for (int i = 1; i <= (players + 1); i++) {
            Deck currentDeck = deckFactory();
            currentDeck.addCards(dealtDeck.get(i));
            mapToReturn.put(i, currentDeck);
        }
        return mapToReturn;
    }

    public static void main(String[] args) {
        StandardDeck myDeck = new StandardDeck();
        System.out.println("Creating deck:");
        myDeck.sort();
        System.out.println("Sorted deck:");
        System.out.println(myDeck.deckToString());
        myDeck.shuffle();
        System.out.println();
        myDeck.sort(new SortByRankThenSuit());
        System.out.println("Sorted by rank, then by suit");
        /*
         * Alternatively, one could use the default method of the operator
         * class which builds a `Comparator` instance from a series of
         * Comparator instances.
         * myDeck.sort(
         *  Comparator
         *      .comparing(Card::getRank)
         *      .thenComparing(Comparator.comparing(Card::getSuit))
         * );
         */
        System.out.println(myDeck.deckToString());
        myDeck.shuffle();
        System.out.println();
        // Sort the cards purely by the rank and disregard the suit.
        // Uses the static method of the Comparator interface.
        // Employs the method reference.
        myDeck.sort(
            Comparator.comparing(Card::getRank).reversed()
        );
        /*
         * Alternative to:
         * myDeck.sort(
         *  (firstCard, secondCard) ->
         *      firstCard.getRank().value() - secondCard.getRank().value()
         * )
         */
        System.out.println("Sorted by rank, and disregard suit");
        System.out.println(myDeck.deckToString());
        myDeck.shuffle();
        System.out.println();

        System.out.println("Sorted by ascending order of rank and descending order of suit");
        myDeck.sort(
            Comparator.comparing(Card::getRank)
                .thenComparing(Comparator.comparing(Card::getSuit).reversed())
        );
        System.out.println(myDeck.deckToString());
    }
}
