package com.pillar.vendingMachine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SoldOutTest {

    @Test
    public void givenNoMoneyAndColaProductSelectedDisplayShowsSoldOutThenShowsInsertCoin(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.clearColaProducts();
        vendingMachine.selectColaProduct();
        assertEquals("SOLD OUT", vendingMachine.getDisplay());
        vendingMachine.colaProductSoldOut();
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
    }

    @Test
    public void givenMoneyAndColaProductSelectedDisplayShowsSoldOutThenDisplaysRemainingAmount(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.clearColaProducts();
        vendingMachine.insertCoin(Coin.dime);
        vendingMachine.selectColaProduct();
        assertEquals("SOLD OUT", vendingMachine.getDisplay());
        vendingMachine.colaProductSoldOut();
        assertEquals("$0.10", vendingMachine.getDisplay());
    }

    @Test
    public void givenNoMoneyAndChipsProductSelectedDisplayShowsSoldOutThenShowsInsertCoin(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.clearChipsProducts();
        vendingMachine.selectChipsProduct();
        assertEquals("SOLD OUT", vendingMachine.getDisplay());
        vendingMachine.chipsProductSoldOut();
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
    }

    @Test
    public void givenMoneyAndChipsProductSelectedDisplayShowsSoldOutThenShowsRemainingAmount(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.clearChipsProducts();
        vendingMachine.insertCoin(Coin.nickel);
        vendingMachine.selectChipsProduct();
        assertEquals("SOLD OUT", vendingMachine.getDisplay());
        vendingMachine.chipsProductSoldOut();
        assertEquals("$0.05", vendingMachine.getDisplay());
    }

    @Test
    public void givenNoMoneyAndCandyProductSelectedDisplayShowsSoldOutThenShowsRemainingAmount(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.clearCandyProducts();
        vendingMachine.selectCandyProduct();
        assertEquals("SOLD OUT", vendingMachine.getDisplay());
        vendingMachine.candyProductSoldOut();
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
    }

    @Test
    public void givenMoneyAndCandyProductSelectedDisplayShowsSoldOutThenShowsRemainingAmount(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.clearCandyProducts();
        vendingMachine.insertCoin(Coin.dime);
        vendingMachine.selectCandyProduct();
        assertEquals("SOLD OUT", vendingMachine.getDisplay());
        vendingMachine.candyProductSoldOut();
        assertEquals("$0.10", vendingMachine.getDisplay());
    }
}
