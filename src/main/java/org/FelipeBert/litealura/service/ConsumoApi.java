package org.FelipeBert.litealura.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    private static final String ENDERECO = "http://gutendex.com/books?search=";

    public String obterDados(String complementoEndereco) throws UnsupportedEncodingException {
        complementoEndereco = URLEncoder.encode(complementoEndereco, "UTF-8");
        String endereco = ENDERECO + complementoEndereco;

        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException ex){
            throw new RuntimeException(ex);
        }
        return response.body();
    }

}