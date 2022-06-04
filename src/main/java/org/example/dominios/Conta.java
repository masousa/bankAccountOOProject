package org.example.dominios;

import java.math.BigDecimal;

public abstract class Conta extends ContaSimples implements IConta {
    public Conta(String numeroConta, String agencia) {
        super(numeroConta, agencia);
    }

    @Override
    public void depositar(BigDecimal valor) {
        this.addTransacao(new Transacao(valor, TipoTransacao.CREDITO));
    }


}
