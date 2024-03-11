package com.tgid.backendjava.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.tgid.backendjava.repository.CallbackService;

public class WebhookCallbackService implements CallbackService {

    private String callbackUrl;

    public WebhookCallbackService(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public void sendCallback(String transactionInfo) {
        try {
            // Criação da conexão HTTP
            URL url = new URL(callbackUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            // Escreve os dados da transação no corpo da requisição
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = transactionInfo.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Callback enviado com sucesso para: " + callbackUrl);
            } else {
                System.err.println("Falha ao enviar callback. Código de resposta: " + responseCode);
            }
        } catch (IOException e) {
            System.err.println("Erro ao enviar callback: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
