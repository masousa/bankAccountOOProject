package org.example.services;

import org.example.dominios.ContaSimples;
import org.example.dominios.TipoTransacao;
import org.example.dominios.Transacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RealizarExtrato {

    public List<Transacao> execute(ContaSimples contaSimples, TipoTransacao tipoTransacao) {
        List<Transacao> transacoes = new ArrayList<>();
        if (Objects.nonNull(tipoTransacao)) {
            ListarTransacoesPorTipo listarTransacoesPorTipo = new ListarTransacoesPorTipo();
            transacoes.addAll(listarTransacoesPorTipo.execute(contaSimples, tipoTransacao));
        } else {
            transacoes.addAll(contaSimples.getTransacoes());
        }
        return transacoes;
    }
}
