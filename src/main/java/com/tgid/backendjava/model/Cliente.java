package com.tgid.backendjava.model;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.tgid.backendjava.service.EmailNotificationService;

public class Cliente {
    private Empresa empresa;
    private String cpf;
    private String nome;
    private double saldo;
    private EmailNotificationService emailNotificationService;

    public Cliente(Empresa empresa, String cpf, String nome, double saldo, EmailNotificationService emailNotificationService) {
        this.empresa = empresa;
        this.cpf = cpf;
        this.nome = nome;
        this.saldo = saldo;
        this.emailNotificationService = emailNotificationService;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor) {
        empresa.saque(this, valor); // Chama o método de saque da empresa passando o próprio cliente
    }

    public void depositar(double valor) {
        empresa.deposito(this, valor); // Chama o método de depósito da empresa passando o próprio cliente
    }

    public void enviarNotificacaoPorEmail(String recipientEmail, String subject, String body) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.example.com");
        email.setSmtpPort(587); 
        email.setAuthenticator(new DefaultAuthenticator("username", "password")); 
        email.setStartTLSEnabled(true); 
        email.setFrom("from@example.com"); 
        email.addTo(recipientEmail); 
        email.setSubject(subject); 
        email.setHtmlMsg(body); 
        email.send(); 
    }
}
