package com.pillar.vendingMachine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SelectProductTest {

    @Test
    public void givenSelectColaAndNotEnoughMoneyDisplayShowsColaPrice(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectColaProduct();
        assertEquals("PRICE $1.00", vendingMachine.getDisplay());
    }

    @Test
    public void givenSelectColaAndEnoughMoneyDisplayShowsThankYouDispensesProductThenShowsInsertCoin(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectColaProduct();
        assertEquals("THANK YOU", vendingMachine.getDisplay());
        vendingMachine.dispenseProduct();
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
    }
}
