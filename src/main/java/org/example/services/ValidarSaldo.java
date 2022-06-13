package org.example.services;

import org.example.dominios.ContaSimples;
import org.example.exception.SaldoInvalidoException;

import java.math.BigDecimal;

public class ValidarSaldo {


    public void execute(BigDecimal bigDecimal, ContaSimples contaSimples) throws SaldoInvalidoException {
        ObterSaldo obterSaldo = new ObterSaldo();
        BigDecimal saldoConta = obterSaldo.execute(contaSimples);

        if (saldoConta.compareTo(bigDecimal) < 0) {
            throw new SaldoInvalidoException();
        }
    }
}
