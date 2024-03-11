package com.tgid.backendjava.model;

import com.tgid.backendjava.repository.CallbackService;

public class Empresa {
	private String cnpj;
	private String nome;
	private double saldo;
	private CallbackService callbackService;

	public Empresa(String cnpj, String nome, double saldo) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.saldo = saldo;

	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
    public void setCallbackService(CallbackService callbackService) {
        this.callbackService = callbackService;
    }

	public double calcularTaxaTransacao(double valor, TipoTransacao tipoTransacao) {
		if (tipoTransacao == TipoTransacao.DEPOSITO && valor >= 50000.0) {
			return valor * 0.027;
		} else if (tipoTransacao == TipoTransacao.SAQUE) {
			return valor * 0.015;
		} else {
			return 0.0;
		}
	}

	public void deposito(Cliente cliente, double valor) {
		// Verificar se o valor do depósito é válido
		if (valor <= 0.0) {
			throw new IllegalArgumentException("O valor do depósito deve ser maior que zero");
		}

		// Calcular a taxa de transação
		double taxa = calcularTaxaTransacao(valor, TipoTransacao.DEPOSITO);

		// Atualizar o saldo da empresa: adicionar o valor do depósito e subtrair a taxa
		double saldoFinal = saldo + valor - taxa;

		// Atualizar o saldo da empresa
		saldo = saldoFinal;

		System.out.println("Depósito de " + valor + " feito com sucesso. Novo saldo: " + saldoFinal);
		System.out.println("Taxa adicional: " + taxa);

	}

	public void saque(Cliente cliente, double valor) {
	    // Verificar se o valor do saque é válido
	    if (valor <= 0.0 || valor > saldo) {
	        throw new IllegalArgumentException("Valor de saque inválido");
	    }

	    // Calcular a taxa de transação
	    double taxa = calcularTaxaTransacao(valor, TipoTransacao.SAQUE);

	    double novoSaldo = cliente.getSaldo() - (valor + taxa);

	    cliente.setSaldo(novoSaldo);
	    
        if (callbackService != null) {
            String transactionInfo = "Saque de " + valor + " realizado com sucesso para o cliente " + cliente.getNome();
            callbackService.sendCallback(transactionInfo);

	}
	
	

}
}