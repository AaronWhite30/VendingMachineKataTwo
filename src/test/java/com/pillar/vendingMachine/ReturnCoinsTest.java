package com.pillar.vendingMachine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReturnCoinsTest {

    @Test
    public void givenReturnCoinsButtonPressedDisplayShowsInsertCoin(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.nickel);
        vendingMachine.insertCoin(Coin.dime);
        vendingMachine.returnCoins();
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
    }
}
