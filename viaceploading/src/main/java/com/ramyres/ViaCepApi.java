package com.ramyres;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ViaCepApi {
    public DtoViaCep buscarCep(long CEP) throws IOException, InterruptedException {
        String url = String.format("https://viacep.com.br/ws/%d/json/", CEP);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        DtoViaCep dto = new Gson().fromJson(json, DtoViaCep.class);

        return dto;
    }
}
