package com.lucamartins.dev.consultaveiculofipe.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpService {
    final private HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> sendRequest(String url) {
        URI requestURI = URI.create(url);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(requestURI)
                .GET()
                .build();

        try {
            HttpResponse<String> httpResponse = client.send(
                    httpRequest,
                    HttpResponse.BodyHandlers.ofString()
            );

            return httpResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
