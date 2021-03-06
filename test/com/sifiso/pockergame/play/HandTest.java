/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.pockergame.play;

import com.sifiso.pockergame.model.Card;
import com.sifiso.pockergame.utils.HelperUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sifiso.mtshweni
 */
public class HandTest {

    Card[] cards;

    public HandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of display method, of class Hand.
     */
    @Test
    public void testTwoPairDisplay() throws Exception {
        System.out.println("testTwoPairDisplay");
        cards = HelperUtils.readInputString("AS,10C,10H,3D,3S");
        Hand instance = new Hand(cards);
        instance.displayResults();
        // TODO review the generated test code and remove the default call to fail.
//        assertThat(instance, Is.is(cards));
    }

    @Test
    public void testForOfAKindDisplay() throws Exception {
        System.out.println("testFlushDisplay");
        cards = HelperUtils.readInputString("AS,10C,AH,AD,AS");
        Hand instance = new Hand(cards);
        instance.displayResults();
    }

}
