package org.example.services;

import org.example.dominios.ContaSimples;
import org.example.dominios.TipoTransacao;
import org.example.dominios.Transacao;
import org.example.exception.SaldoInvalidoException;

import java.math.BigDecimal;

public class RealizarSaque {

    public BigDecimal execute(BigDecimal valor, ContaSimples conta) throws SaldoInvalidoException {
        ValidarSaldo validarSaldo = new ValidarSaldo();
        validarSaldo.execute(valor, conta);
        conta.getTransacoes().add(new Transacao(valor, TipoTransacao.DEBITO));
        return valor;
    }
}
