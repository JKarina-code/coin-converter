package com.aluracursos.coinconverter.models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ApiConsultation {
    public ExchangeRateData consultationCoin(String apiKey, String coinType) {
        // create URI
        String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + coinType;
        URI uri = URI.create(urlStr);

        // client HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

        try {
            Gson gson = new Gson();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
           return gson.fromJson(response.body(), ExchangeRateData.class);
        } catch (Exception e) {
            throw new RuntimeException("Not found this coin");
        }
    }

}
