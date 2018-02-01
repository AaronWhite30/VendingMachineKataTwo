package com.pillar.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private String display;
    private List<Coin> acceptedCoins = new ArrayList<Coin>();

    public String getDisplay(){
        return display;
    }

    public void insertCoin(Coin coin){
        if(coin != Coin.penny){
            acceptedCoins.add(coin);
            display = String.format("$%.02f", getTotalAcceptedCoins());
        }else {
            display = "INSERT COIN";
        }
    }

    private float getTotalAcceptedCoins(){
        float total = 0;
        for (Coin coin : acceptedCoins) {
            if(coin.getCoinSize() == 3 && coin.getCoinWeight() == 3){
                total = total + 0.25f;
            }else if(coin.getCoinSize() == 2 && coin.getCoinWeight() == 2){
                total = total + 0.05f;
            }
        }
        return total;
    }
}
