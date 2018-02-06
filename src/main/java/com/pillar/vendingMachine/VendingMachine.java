package com.pillar.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private String display = "INSERT COIN";
    private List<Coin> acceptedCoins = new ArrayList<Coin>();
    private float changeReturned = 0f;
    private float moneyInMachine = 0f;
    private List<Product> colaProducts = new ArrayList<Product>();
    private List<Product> chipsProducts = new ArrayList<Product>();
    private List<Product> candyProducts = new ArrayList<Product>();
    private CoinValueService coinValueService;

    public VendingMachine(float moneyToLoad){
        moneyInMachine = moneyToLoad;
        initialize();
        initializeDisplay();
    }

    public VendingMachine(){
        initialize();
    }

    private void initialize(){
        coinValueService = new CoinValueService();
        colaProducts.add(Product.cola);
        chipsProducts.add(Product.chips);
        candyProducts.add(Product.candy);
    }

    private void initializeDisplay(){
        if(moneyInMachine == 0f){
            display = "EXACT CHANGE ONLY";
        }
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
        if(candyProducts.size() == 0){
            display = "SOLD OUT";
        }else {
            selectProduct(Product.candy);
        }
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
            processChangeReturn(product);
        }else {
            display = "PRICE "+String.format("$%.02f",product.getPrice());
        }
    }

    private void processChangeReturn(Product product){
        if(getTotalAcceptedCoins() > product.getPrice()){
            changeReturned = getTotalAcceptedCoins() - product.getPrice();
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
        productSoldOut();
    }

    public void clearChipsProducts(){
        chipsProducts.clear();
    }

    public void chipsProductSoldOut(){
        productSoldOut();
    }

    public void clearCandyProducts(){
        candyProducts.clear();
    }

    public void candyProductSoldOut(){
        productSoldOut();
    }

    public void productSoldOut(){
        if(acceptedCoins.size() > 0){
            display = String.format("$%.02f", getTotalAcceptedCoins());
        }else {
            display = "INSERT COIN";
        }
    }

    public String getChangeInCoinReturn(){
        return String.format("%.02f",changeReturned);
    }
}
