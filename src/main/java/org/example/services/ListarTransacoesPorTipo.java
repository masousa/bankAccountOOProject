package org.example.services;

import org.example.dominios.ContaSimples;
import org.example.dominios.TipoTransacao;
import org.example.dominios.Transacao;

import java.util.ArrayList;
import java.util.List;

public class ListarTransacoesPorTipo {

    public List<Transacao> execute(ContaSimples contaSimples, TipoTransacao tipoTransacao) {
        List<Transacao> transacoes = new ArrayList<>();
        for (Transacao transacao : contaSimples.getTransacoes()) {
            if (transacao.getTipoTransacao().equals(tipoTransacao)) {
                transacoes.add(transacao);
            }
        }
        return transacoes;
    }
}
