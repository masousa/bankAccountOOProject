package org.example.dominios;

import org.example.exception.SaldoInvalidoException;

public class ContaSimplesSalario extends ContaSimples implements IContaSimples{

    public ContaSimplesSalario(String numeroConta, String agencia) {
        super(numeroConta, agencia);
        this.tipoConta = TipoConta.SALARIO;
    }

    @Override
    public void validarSaldoParaSaque(Double valor) throws SaldoInvalidoException {
        // TODO implementar validação
    }
}
