package com.pillar.vendingMachine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AcceptCoinTest {

    @Test
    public void givenInvalidCoinInsertedDisplayIsInsertCoin(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.penny);
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
    }
}
