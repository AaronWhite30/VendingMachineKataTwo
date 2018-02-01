package com.pillar.vendingMachine;

public enum Product {
    cola(1.00f),chips(0.50f),candy(0.65f);
    Product(float price){
        this.price = price;
    }
    float price;
    public float getPrice(){
        return price;
    }
}
