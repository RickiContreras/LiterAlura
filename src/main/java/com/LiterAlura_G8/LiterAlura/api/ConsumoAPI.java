package com.LiterAlura_G8.LiterAlura.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    private final HttpClient client = HttpClient.newHttpClient();

    public String obtenerDatos(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("❌ Error al realizar la solicitud HTTP: " + e.getMessage());
            return null;
        }
    }
}

