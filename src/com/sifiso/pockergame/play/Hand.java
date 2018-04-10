/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.pockergame.play;

import com.sifiso.pockergame.model.Card;

/**
 *
 * @author sifiso.mtshweni
 */
public class Hand {

    private Card[] decks;

    public Hand(Card[] decks) {
        this.decks = decks;
    }

    private boolean isRoyalFlush(Card[] h) {
        boolean royalFlush = false;
        if (isStraight(h) && isFlush(h) && h[1].getRank().equals("9")) {
            royalFlush = true;
        }
        return royalFlush;
    }

    // method to check if hand is a straight flush (hand is a straight, a flush,
    // and NOT a royal flush)
    private boolean isStraightFlush(Card[] h) {
        boolean straightFlush = false;

        if (isStraight(h) && isFlush(h) && !(h[1].getRank().equals("10"))) {
            straightFlush = true;
        }

        return straightFlush;
    }

    // method to check if hand is a four of a kind
    private boolean isFourOfaKind(Card[] h) {
        boolean fourOfaKind = false;
        Card[] hand = h;
        // since my hand is in order, the middle card MUST be one of the four
        String commonValue = hand[2].getRank();
        int counter = 0;

        // for loop to count number of repeat values
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].getRank().equals(commonValue)) {
                counter++;
            }
        }

        if (counter == 4) {
            fourOfaKind = true;
        }

        return fourOfaKind;

    }

    // method to check if it's a full house (hand has three of a kind and the
    // other two cards are a pair)
    private boolean isFullHouse(Card[] h) {
        boolean fullHouse = false;
        Card[] hand = h;

        if (isThreeOfaKind(hand) && isPair(hand)) {
            fullHouse = true;
        }

        return fullHouse;
    }

    // method to check if hand is a flush
    private boolean isFlush(Card[] h) {
        boolean flush = false;
        String commonSuit = h[0].getSuit();
        int counter = 0;

        // for loop to count number of repeat suits (needs to be 5)
        for (int i = 0; i < h.length; i++) {
            if (h[i].getSuit().equals(commonSuit)) {
                counter++;
            }
        }

        if (counter == h.length) {
            flush = true;
        }

        return flush;

    }

    // method to check if hand is a straight
    private boolean isStraight(Card[] h) {
        boolean straight = false;
        Card[] hand;
        hand = h;
        String startValue = hand[0].getRank();

        // if statement to ensure that ace can be high or low (A2345 as well as
        // 10JQKA are straights)
        if (hand[0].getRank().equals("A") && hand[1].getRank().equals("9")
                && hand[2].getRank().equals("10") && hand[3].getRank().equals("J")
                && hand[4].getRank().equals("Q")) {

            straight = true;
            return straight;

        } else {
            // for loop checks if each successive card is one higher (we can do
            // this because hand is sorted)
            for (int i = 1; i < 5; i++) {
                if (hand[i].getRank().equals(startValue + i)) {
                    straight = true;
                } else {
                    straight = false;
                    return straight;
                }
            }
        }

        return straight;
    }

    // method to check for three of a kind
    private boolean isThreeOfaKind(Card[] h) {
        boolean threeOfaKind = false;

        // since hand is in order, middle card MUST be one of the 3
        String commonValue = h[2].getRank();
        int counter = 0;

        for (int i = 0; i < h.length; i++) {
            if (h[i].getRank().equals(commonValue)) {
                counter++;
            }
        }

        if (counter == 3) {
            threeOfaKind = true;
        }

        return threeOfaKind;
    }

    // method to check if there are two pairs
    private boolean isTwoPair(Card[] h) {
        boolean twoPair = false;
        int counter = 0;

        for (int i = 0; i < 4; i++) {
            if (h[i].getRank().equals(h[i + 1].getRank())) {
                counter++;
            }
        }

        if (counter == 2) {
            twoPair = true;
        }

        return twoPair;
    }

    // method to check if there is a pair
    private boolean isPair(Card[] h) {
        boolean pair = false;
        Card[] hand = h;
        int pairCounter = 0;

        for (int i = 0; i < 4; i++) {
            if (hand[i].getRank().equals(hand[i + 1].getRank())) {
                pairCounter++;
            }
        }

        // Second part of or statement is to make sure when we are checking for
        // isFullHouse using isThreeOfaKind and isPair, isPair isn't true if
        // hand only has three of a kind
        if (!(pairCounter == 0 || pairCounter == 2)) {
            pair = true;
        }

        return pair;
    }

    public void displayResults() {

        Card[] h = decks;
        if (isRoyalFlush(h)) {
            System.out.println("Royal Flush");
        } else if (isStraightFlush(h)) {
            System.out.println("Straight Flush");
        } else if (isFourOfaKind(h)) {
            System.out.println("Four of a Kind");
        } else if (isFullHouse(h)) {
            System.out.println("Full House");
        } else if (isFlush(h)) {
            System.out.println("Flush");
        } else if (isStraight(h)) {
            System.out.println("Straight");
        } else if (isThreeOfaKind(h)) {
            System.out.println("Three of a kind!");
        } else if (isTwoPair(h)) {
            System.out.println("Two Pair.");
        } else if (isPair(h)) {
            System.out.println("Pair.");
        } else if (h[0].getRank().equalsIgnoreCase("A")) {
            System.out.println("High card: "
                    + h[0].toString());
        } else {
            System.out.println("High card: "
                    + h[4].toString());
        }
    }

}
