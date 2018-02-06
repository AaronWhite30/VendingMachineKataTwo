package com.pillar.vendingMachine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExactChangeTest {

    @Test
    public void givenNoMoneyInMachineDisplayShowsExactChangeForColaWhenLessThanOneDollarInMoneyInMachine(){
        VendingMachine vendingMachine = new VendingMachine(0f);
        assertEquals("EXACT CHANGE ONLY", vendingMachine.getDisplay());
    }
}
