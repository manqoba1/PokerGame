/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.pockergame.test;

import com.sifiso.pockergame.model.Card;
import com.sifiso.pockergame.play.Deck;
import com.sifiso.pockergame.play.Hand;
import com.sifiso.pockergame.utils.Utils;
import java.util.Scanner;

/**
 *
 * @author sifiso.mtshweni
 */
public class PockerGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        System.out.println("Enter poker deck ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

//        Card[] cards = Utils.readInputString("AS,10C,10H,3D,4S");
        Card[] cards = Utils.readInputString(text);
        Deck d = new Deck(cards);
        Hand h = new Hand(d);

        h.displayResults();
    }

}
