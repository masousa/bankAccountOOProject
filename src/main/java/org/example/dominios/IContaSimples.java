package org.example.dominios;

import org.example.exception.SaldoInvalidoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IContaSimples {
     BigDecimal sacar(BigDecimal valor) throws SaldoInvalidoException;

     BigDecimal transferir(BigDecimal valor, ContaSimples contaSimples) throws SaldoInvalidoException;

     BigDecimal saldo();

     List<Transacao> extrato(LocalDate dateStart, LocalDate dateEnd);
}
