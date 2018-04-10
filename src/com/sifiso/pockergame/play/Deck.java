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
public class Deck {

    private Card deck[];

    public Deck(Card deck[]) {

        this.deck = deck;

    }

    public Card getCard(int index) {
        return deck[index];
    }

    public Card[] getDeck() {
        return deck;
    }

}
