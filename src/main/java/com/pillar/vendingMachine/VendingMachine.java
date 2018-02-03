package com.pillar.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private String display;
    private List<Coin> acceptedCoins = new ArrayList<Coin>();
    private List<Product> colaProducts = new ArrayList<Product>();
    private List<Product> chipsProducts = new ArrayList<Product>();
    private CoinValueService coinValueService;

    public VendingMachine(){
        display = "INSERT COIN";
        coinValueService = new CoinValueService();
        colaProducts.add(Product.cola);
        chipsProducts.add(Product.chips);
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
        if(colaProducts.size() == 0){
            display = "SOLD OUT";
        }else {
            selectProduct(Product.cola);
        }
    }

    public void dispenseColaProduct(){
        dispenseProduct(Product.cola);
    }

    public void dispenseChipsProduct(){
        dispenseProduct(Product.chips);
    }

    public void selectCandyProduct(){
        selectProduct(Product.candy);
    }

    public void dispenseCandyProduct(){
        dispenseProduct(Product.candy);
    }

    public void selectChipsProduct(){
        if(chipsProducts.size() == 0){
            display = "SOLD OUT";
        }else {
            selectProduct(Product.chips);
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

    public void dispenseProduct(Product product){
        if(getTotalAcceptedCoins() > product.getPrice()){
            display = String.format("$%.02f", getTotalAcceptedCoins() - product.getPrice());
        }else {
            display = "INSERT COIN";
        }
    }

    public void clearColaProducts(){
        colaProducts.clear();
    }

    public void colaProductSoldOut(){
        if(acceptedCoins.size() > 0){
            display = String.format("$%.02f", getTotalAcceptedCoins());
        }else {
            display = "INSERT COIN";
        }
    }

    public void clearChipsProducts(){
        chipsProducts.clear();
    }
}
