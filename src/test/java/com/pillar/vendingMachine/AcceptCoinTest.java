package com.pillar.vendingMachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AcceptCoinTest {

    private VendingMachine vendingMachine;

    @Before
    public void setup(){
        this.vendingMachine = new VendingMachine();
    }

    @Test
    public void givenInvalidCoinInsertedDisplayIsInsertCoin(){
        vendingMachine.insertCoin(Coin.penny);
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
    }

    @Test
    public void givenValidCoinIsInsertedDisplayShowsAmount(){
        vendingMachine.insertCoin(Coin.quarter);
        assertEquals("$0.25", vendingMachine.getDisplay());
    }

    @Test
    public void givenValidCoinsInsertedDisplayShowAccumulatedAmount(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.nickel);
        vendingMachine.insertCoin(Coin.dime);
        assertEquals("$0.40", vendingMachine.getDisplay());
    }
}
