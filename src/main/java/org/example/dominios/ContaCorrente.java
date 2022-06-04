package org.example.dominios;

import org.example.exception.SaldoInvalidoException;

import java.math.BigDecimal;

public class ContaCorrente extends Conta implements IConta{
    public ContaCorrente(String numeroConta, String agencia) {
        super(numeroConta, agencia);
        this.tipoConta = TipoConta.CORRENTE;
    }

    @Override
    public void validarSaldoParaSaque(Double valor) throws SaldoInvalidoException {
       //TODO implementar validação
    }


}
