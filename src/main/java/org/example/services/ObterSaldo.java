package org.example.services;

import org.example.dominios.ContaSimples;
import org.example.dominios.TipoTransacao;
import org.example.dominios.Transacao;

import java.math.BigDecimal;
import java.util.List;

public class ObterSaldo {
    private ContaSimples contaSimples;

    public BigDecimal execute(ContaSimples contaSimples) {
        this.contaSimples = contaSimples;
        BigDecimal debitos = getInfoTransacoes(TipoTransacao.DEBITO);
        BigDecimal creditos = getInfoTransacoes(TipoTransacao.CREDITO);
        return creditos.subtract(debitos);

    }

    private BigDecimal getInfoTransacoes(TipoTransacao tipoTransacao) {
        BigDecimal resultado = BigDecimal.ZERO;
        ListarTransacoesPorTipo listarTransacoesPorTipo = new ListarTransacoesPorTipo();
        List<Transacao> transacoes = listarTransacoesPorTipo.execute(contaSimples, tipoTransacao);
        for (Transacao transacao : transacoes) {
            resultado = resultado.add(transacao.getValor());
        }
        return resultado;
    }
}
