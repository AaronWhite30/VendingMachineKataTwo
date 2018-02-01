package com.pillar.vendingMachine;

public class CoinValueService {

    public float getCoinValue(Coin coin){
        if(coin.getCoinSize() == 3 && coin.getCoinWeight() == 3){
            return 0.25f;
        }else if(coin.getCoinSize() == 2 && coin.getCoinWeight() == 2){
            return 0.05f;
        }else if(coin.getCoinSize() == 1 && coin.getCoinWeight() == 1){
            return 0.10f;
        }else{
            return 0.0f;
        }
    }
}
