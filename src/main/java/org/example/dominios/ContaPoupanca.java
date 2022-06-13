package org.example.dominios;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta implements IConta {
    public ContaPoupanca(String numeroConta, String agencia) {
        super(numeroConta, agencia);
        this.tipoConta = TipoConta.POUPANCA;
    }



    @Override
    public void depositar(BigDecimal valor) {

    }
}
