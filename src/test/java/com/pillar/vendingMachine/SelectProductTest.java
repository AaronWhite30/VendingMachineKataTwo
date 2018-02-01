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
        vendingMachine.dispenseColaProduct();
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
    }

    @Test
    public void givenSelectColaAndTooMuchMoneyDisplayShowsThankYouDispensesProductThenShowsRemainingAmount(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.dime);
        vendingMachine.selectColaProduct();
        assertEquals("THANK YOU", vendingMachine.getDisplay());
        vendingMachine.dispenseColaProduct();
        assertEquals("$0.10", vendingMachine.getDisplay());
    }

    @Test
    public void givenSelectChipsAndNotEnoughMoneyDisplayShowsChipsPrice(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectChipsProduct();
        assertEquals("PRICE $0.50", vendingMachine.getDisplay());
    }

    @Test
    public void givenSelectChipsAndEnoughMoneyDisplayShowsThankYou(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectChipsProduct();
        assertEquals("THANK YOU", vendingMachine.getDisplay());
    }
}
