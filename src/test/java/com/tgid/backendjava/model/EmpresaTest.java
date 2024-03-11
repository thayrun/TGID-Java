package com.tgid.backendjava.model;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpresaTest {

    private Empresa minhaEmpresa;
    private Cliente meuCliente;

    @BeforeEach
    public void setUp() {
        minhaEmpresa = new Empresa("123456789", "Minha Empresa", 50000.0);
        meuCliente = new Cliente(minhaEmpresa, "456456564", "Thayron", 9055.0, null);
    }

    @Test
    public void testSaqueCliente() {
        double valorSaque = 1100.0;

        minhaEmpresa.saque(meuCliente, valorSaque);	

        
        System.out.println("Valor sacado: " + valorSaque);
        System.out.println("Saldo atual: " + meuCliente.getSaldo());
        double taxa = minhaEmpresa.calcularTaxaTransacao(valorSaque, TipoTransacao.SAQUE);
        System.out.println("Taxa de transação: " + taxa);
    }




}
