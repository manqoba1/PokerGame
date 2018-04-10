/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.pockergame.utils;

import com.sifiso.pockergame.model.Card;

/**
 *
 * @author sifiso.mtshweni
 */
public class Utils {

    public static Card[] readInputString(String input) throws Exception {

        if (!input.contains(",")) {
            throw new Exception("Input must be separated by comma(,)");
        }

//        Here we split our input string base on the , devide
        String[] strInput = input.split(",");

        if (strInput.length != 5) {
            throw new Exception("In correct deck of Cards");
        }

        Card[] cards = new Card[strInput.length];
//        Putting the card on the deck
        for (int i = 0; i < strInput.length; i++) {
            cards[i] = new Card(strInput[i].substring(0, strInput[i].length() - 1), strInput[i].charAt(strInput[i].length() - 1) + "");
        }
        return cards;
    }
}
