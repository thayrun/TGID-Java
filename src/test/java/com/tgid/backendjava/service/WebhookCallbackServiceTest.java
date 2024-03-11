package com.tgid.backendjava.service;

import org.junit.jupiter.api.Test;



public class WebhookCallbackServiceTest {

    @Test
    public void testSendCallback() {
        // URL do webhook fornecido
        String callbackUrl = "https://webhook.site/495d0636-a318-45ca-a47e-11664d652995";
        
        // Cria uma instância do serviço de callback com o URL
        WebhookCallbackService callbackService = new WebhookCallbackService(callbackUrl);

        // Simula uma transação
        String transactionInfo = "Informações da transação";
        
        // Envia o callback
        callbackService.sendCallback(transactionInfo);
        
    }
}
