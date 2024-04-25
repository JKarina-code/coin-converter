package com.aluracursos.coinconverter.models;

import java.util.HashMap;

public record ExchangeRateData(String base_code, HashMap<String, Double> conversion_rates) {
}
