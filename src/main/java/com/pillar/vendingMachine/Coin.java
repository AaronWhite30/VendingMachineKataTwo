package com.pillar.vendingMachine;

public enum Coin {
    penny(1,2),nickel(2,2),dime(1,1),quarter(3,3);
    Coin(int coinSize, int coinWeight){
        this.coinSize = coinSize;
        this.coinWeight = coinWeight;
    }
    int coinSize;
    int coinWeight;
    public float getCoinSize(){
        return coinSize;
    }
    public float getCoinWeight(){
        return coinWeight;
    }
}

