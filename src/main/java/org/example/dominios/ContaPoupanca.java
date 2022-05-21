package org.example.dominios;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(String numeroConta, String agencia) {
        super(numeroConta, agencia);
        this.tipoConta = TipoConta.POUPANCA;
    }

    @Override
    public BigDecimal sacar(Double bigDecimal) {
        System.out.println("Precisa retirar a porcentagem do banco");
        return super.sacar(bigDecimal);
    }
}
