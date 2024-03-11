
package com.tgid.backendjava.service;

import org.apache.commons.mail.EmailException;

public class EmailNotificationServiceTest {

    public static void main(String[] args) {
        String host = "smtp.example.com";
        int port = 587;
        String username = "your_username";
        String password = "your_password";

        EmailNotificationService emailService = new EmailNotificationService(host, port, username, password);

        try {
            String recipientEmail = "495d0636-a318-45ca-a47e-11664d652995@email.webhook.site";
            String subject = "Assunto do E-mail";
            String body = "<html><body>Corpo do E-mail</body></html>";

            emailService.sendEmail(recipientEmail, subject, body);
            System.out.println("E-mail enviado com sucesso para: " + recipientEmail);
        } catch (EmailException e) {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
        }
    }
}
