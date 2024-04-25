package com.aluracursos.coinconverter.models;

import java.util.HashMap;

public class Coin {
    public String type;
    public HashMap<String, Double> conversionCoin;
    private String changeCoin;
    private double value;
    private double conversion;

    public Coin(ExchangeRateData data) {
        this.type = data.base_code();
        this.conversionCoin = data.conversion_rates();
        this.value = 0;
        this.conversion = 0;
    }

    public double conversionHandle(String coinUser, double valueUser) {
        try {
            this.changeCoin = coinUser;
            this.value = valueUser;
            this.conversion = conversionCoin.get(changeCoin) * value;
            return this.conversion;

        } catch (Exception e) {
            System.out.println("Choose a number of the menu");
        }
        return 0;
    }


    @Override
    public String toString() {
        String formatterValue = String.format("%.2f", this.value);
        String formatted = String.format("%.2f", this.conversion);

        return formatterValue + " " + this.type + " is" + " " +
                formatted + " " + this.changeCoin + "\n";
    }


}