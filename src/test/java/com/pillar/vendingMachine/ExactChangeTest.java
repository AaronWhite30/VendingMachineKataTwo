package com.pillar.vendingMachine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExactChangeTest {

    @Test
    public void givenNoMoneyInMachineDisplayShowsExactChangeInsteadOfInsertCoin(){
        VendingMachine vendingMachine = new VendingMachine(0f);
        assertEquals("EXACT CHANGE ONLY", vendingMachine.getDisplay());
    }

    @Test
    public void givenMoneyInMachineDisplayShowsInsertCoinInsteadOfExactChangeOnly(){
        VendingMachine vendingMachine = new VendingMachine(1.00f);
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
    }
}
