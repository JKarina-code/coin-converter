package com.aluracursos.coinconverter.models;

import java.util.HashMap;

public class ConversionsType {
    public HashMap<Integer, String[]> conversions = new HashMap<>();

    //Conversions Types
    public ConversionsType() {
        this.conversions.put(1, new String[]{"USD", "BRL"});
        this.conversions.put(2, new String[]{"BRL", "USD"});
        this.conversions.put(3, new String[]{"USD", "COP"});
        this.conversions.put(4, new String[]{"COP", "USD"});
        this.conversions.put(5, new String[]{"ARS", "USD"});
        this.conversions.put(6, new String[]{"USD", "ARS"});
        this.conversions.put(7, new String[]{"USD", "MXN"});
        this.conversions.put(8, new String[]{"MXN", "USD"});
        this.conversions.put(9, new String[]{"CLP", "USD"});
    }

    //Method Conversions
    public HashMap<Integer, String[]> getConversions() {
        return conversions;
    }
}

