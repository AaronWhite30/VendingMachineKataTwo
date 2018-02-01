package com.pillar.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private String display;
    private List<Coin> acceptedCoins = new ArrayList<Coin>();
    private CoinValueService coinValueService;

    public VendingMachine(){
        display = "INSERT COIN";
        coinValueService = new CoinValueService();
    }

    public String getDisplay(){
        return display;
    }

    public void insertCoin(Coin coin){
        if(coin != Coin.penny){
            acceptedCoins.add(coin);
            display = String.format("$%.02f", getTotalAcceptedCoins());
        }
    }

    private float getTotalAcceptedCoins(){
        float total = 0;
        for (Coin coin : acceptedCoins) {
            total = total + coinValueService.getCoinValue(coin);
        }
        return total;
    }

    public void returnCoins(){
        display = "INSERT COIN";
    }

    public void selectColaProduct(){
        selectProduct(Product.cola);
    }

    public void dispenseColaProduct(){
        if(getTotalAcceptedCoins() > Product.cola.getPrice()){
            display = String.format("$%.02f", getTotalAcceptedCoins() - Product.cola.getPrice());
        }else {
            display = "INSERT COIN";
        }
    }

    public void selectChipsProduct(){
        selectProduct(Product.chips);
    }

    public void dispenseChipsProduct(){
        if(getTotalAcceptedCoins() > Product.chips.getPrice()){
            display = String.format("$%.02f", getTotalAcceptedCoins() - Product.chips.getPrice());;
        }else {
            display = "INSERT COIN";
        }
    }

    public void selectProduct(Product product){
        if(getTotalAcceptedCoins() == product.getPrice()
                || getTotalAcceptedCoins() > product.getPrice()) {
            display = "THANK YOU";
        }else {
            display = "PRICE "+String.format("$%.02f",product.getPrice());
        }
    }
}
