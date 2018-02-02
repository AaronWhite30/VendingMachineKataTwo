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
}
