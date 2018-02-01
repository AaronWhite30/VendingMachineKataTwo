package com.pillar.vendingMachine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SoldOutTest {

    @Test
    public void givenNoMoneyAndColaProductSelectedDisplayShowsSoldOut(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectColaProduct();
        assertEquals("SOLD OUT", vendingMachine.getDisplay());
    }
}
