package org.example.dominios;

import org.example.exception.SaldoInvalidoException;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta implements IConta {
    public ContaPoupanca(String numeroConta, String agencia) {
        super(numeroConta, agencia);
        this.tipoConta = TipoConta.POUPANCA;
    }

    @Override
    public void validarSaldoParaSaque(Double bigDecimal) throws SaldoInvalidoException {
        System.out.println("Precisa retirar a porcentagem do banco");
        //Verificar se tem saldo
        BigDecimal saldoConta = saldo();



        if(saldoConta.compareTo(BigDecimal.valueOf(bigDecimal))<0){
            throw new SaldoInvalidoException();
        }
    }


    @Override
    public void depositar(BigDecimal valor) {

    }
}
