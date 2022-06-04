package org.example.dominios;

import java.math.BigDecimal;

public class Transacao {

    private BigDecimal valor;
    private TipoTransacao tipoTransacao;

    public Transacao(BigDecimal valor, TipoTransacao tipoTransacao) {
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}
