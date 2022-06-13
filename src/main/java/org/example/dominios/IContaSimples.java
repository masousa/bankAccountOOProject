package org.example.dominios;

import org.example.exception.SaldoInvalidoException;

import java.math.BigDecimal;

public interface IContaSimples {

     BigDecimal transferir(BigDecimal valor, ContaSimples contaSimples) throws SaldoInvalidoException;

}
