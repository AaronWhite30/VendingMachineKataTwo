package com.pillar.vendingMachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SelectProductMakeChangeTest {

    private VendingMachine vendingMachine;

    @Before
    public void setup(){
        this.vendingMachine = new VendingMachine();
    }

    @Test
    public void givenSelectColaAndNotEnoughMoneyDisplayShowsColaPriceAndVerifiesNoChangeIsGiven(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectColaProduct();
        assertEquals("PRICE $1.00", vendingMachine.getDisplay());
        assertEquals("0.00", vendingMachine.getChangeInCoinReturn());
    }

    @Test
    public void givenSelectColaAndEnoughMoneyDisplayShowsThankYouDispensesProductThenShowsInsertCoinAndVerifiesNoChangeIsGiven(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectColaProduct();
        assertEquals("THANK YOU", vendingMachine.getDisplay());
        vendingMachine.dispenseColaProduct();
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
        assertEquals("0.00", vendingMachine.getChangeInCoinReturn());
    }

    @Test
    public void givenSelectColaAndTooMuchMoneyDisplayShowsThankYouDispensesProductThenShowsRemainingAmountThenDispensesChange(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.dime);
        vendingMachine.selectColaProduct();
        assertEquals("THANK YOU", vendingMachine.getDisplay());
        vendingMachine.dispenseColaProduct();
        assertEquals("$0.10", vendingMachine.getDisplay());
        assertEquals("0.10", vendingMachine.getChangeInCoinReturn());
    }

    @Test
    public void givenSelectChipsAndNotEnoughMoneyDisplayShowsChipsPriceAndVerifiesNoChangeIsGiven(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectChipsProduct();
        assertEquals("PRICE $0.50", vendingMachine.getDisplay());
        assertEquals("0.00", vendingMachine.getChangeInCoinReturn());
    }

    @Test
    public void givenSelectChipsAndEnoughMoneyDisplayShowsThankYouDispensesProductThenShowsInsertCoinAndVerifiesNoChangeIsGiven(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectChipsProduct();
        assertEquals("THANK YOU", vendingMachine.getDisplay());
        vendingMachine.dispenseChipsProduct();
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
        assertEquals("0.00", vendingMachine.getChangeInCoinReturn());
    }

    @Test
    public void givenSelectChipsAndTooMuchMoneyDisplayShowsThankYouDispensesProductThenShowsRemainingAmountThenDispensesChange(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.nickel);
        vendingMachine.selectChipsProduct();
        assertEquals("THANK YOU", vendingMachine.getDisplay());
        vendingMachine.dispenseChipsProduct();
        assertEquals("$0.05", vendingMachine.getDisplay());
        assertEquals("0.05", vendingMachine.getChangeInCoinReturn());
    }

    @Test
    public void givenSelectCandyAndNotEnoughMoneyDisplayShowsCandyPriceAndVerifiesNoChangeIsGiven(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.selectCandyProduct();
        assertEquals("PRICE $0.65", vendingMachine.getDisplay());
        assertEquals("0.00", vendingMachine.getChangeInCoinReturn());
    }

    @Test
    public void givenSelectCandyAndEnoughMoneyDisplayShowsThankYouDispensesProductThenShowsInsertCoinAndVerifiesNoChangeIsGiven(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.dime);
        vendingMachine.insertCoin(Coin.nickel);
        vendingMachine.selectCandyProduct();
        assertEquals("THANK YOU", vendingMachine.getDisplay());
        vendingMachine.dispenseColaProduct();
        assertEquals("INSERT COIN", vendingMachine.getDisplay());
        assertEquals("0.00", vendingMachine.getChangeInCoinReturn());
    }

    @Test
    public void givenSelectCandyAndTooMuchMoneyDisplayShowsThankYouDispensesProductThenShowsRemainingAmount(){
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.quarter);
        vendingMachine.insertCoin(Coin.dime);
        vendingMachine.insertCoin(Coin.nickel);
        vendingMachine.insertCoin(Coin.nickel);
        vendingMachine.selectCandyProduct();
        assertEquals("THANK YOU", vendingMachine.getDisplay());
        vendingMachine.dispenseCandyProduct();
        assertEquals("$0.05", vendingMachine.getDisplay());
        assertEquals("0.05", vendingMachine.getChangeInCoinReturn());
    }
}
