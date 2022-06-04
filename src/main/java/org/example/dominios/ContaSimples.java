package org.example.dominios;

import org.example.exception.SaldoInvalidoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ContaSimples implements IContaSimples {

    protected TipoConta tipoConta;
    private String numeroConta;
    private String agencia;
    private List<Transacao> transacoes;

    public ContaSimples() {
    }

    public ContaSimples(String numeroConta, String agencia) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.tipoConta = TipoConta.CORRENTE;
        transacoes = new ArrayList<>();

    }

    public String getNumeroConta() {
        return numeroConta;
    }

    private void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public abstract void validarSaldoParaSaque(Double valor) throws SaldoInvalidoException;

    public BigDecimal sacar(BigDecimal valor) {

        addTransacao(new Transacao(valor, TipoTransacao.DEBITO));
        return valor;
    }

    public BigDecimal sacar(Double valor) throws SaldoInvalidoException {
        validarSaldoParaSaque(valor);

        BigDecimal valorBigdecimal = BigDecimal.valueOf(valor);
        return sacar(valorBigdecimal);
    }

    public BigDecimal transferir(BigDecimal valor) {
        return BigDecimal.ZERO;
    }

    public BigDecimal saldo() {
        BigDecimal debitos = getInfoTransacoes(TipoTransacao.DEBITO);
        BigDecimal creditos = getInfoTransacoes(TipoTransacao.CREDITO);
        return debitos.subtract(creditos);
    }

    private BigDecimal getInfoTransacoes(TipoTransacao tipoTransacao) {
        BigDecimal resultado = BigDecimal.ZERO;
        for (Transacao transacao : transacoes) {
            if (transacao.getTipoTransacao().equals(tipoTransacao)) {
                resultado = resultado.add(transacao.getValor());
            }
        }
        return resultado;
    }

    @Override
    public BigDecimal transferir(BigDecimal valor, ContaSimples contaSimples) throws SaldoInvalidoException {
        return null;
    }

    @Override
    public List<Transacao> extrato(LocalDate dateStart, LocalDate dateEnd) {
        return null;
    }

    protected void addTransacao(Transacao transacao) {
        this.transacoes.add(transacao);
    }
}
