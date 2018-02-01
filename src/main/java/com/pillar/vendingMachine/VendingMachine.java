package com.pillar.vendingMachine;

public class VendingMachine {

    private String display;

    public String getDisplay(){
        return display;
    }

    public void insertCoin(Coin coin){
        if(coin != Coin.penny){
            display = "$0.25";
        }else {
            display = "INSERT COIN";
        }
    }
}
