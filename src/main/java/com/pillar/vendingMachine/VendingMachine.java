package com.pillar.vendingMachine;

public class VendingMachine {

    private String display;

    public String getDisplay(){
        return display;
    }

    public void insertCoin(Coin coin){
        display = "INSERT COIN";
    }
}
