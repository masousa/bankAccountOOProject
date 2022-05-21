package org.example.dominios;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Conta {

    private String numeroConta;
    private String agencia;
    protected TipoConta tipoConta;

    public Conta(String numeroConta, String agencia) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.tipoConta = TipoConta.CORRENTE;
    }



    public String getNumeroConta() {
        return numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public BigDecimal depositar(BigDecimal valor){
        return BigDecimal.ZERO;
    }

    public BigDecimal sacar(BigDecimal valor){
        return BigDecimal.ZERO;
    }

  public BigDecimal sacar(Double bigDecimal){
        return BigDecimal.ZERO;
  }

    public BigDecimal transferir(BigDecimal valor){
        return BigDecimal.ZERO;
    }

    public BigDecimal saldo(){
        return BigDecimal.ZERO;
    }

    private void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public ArrayList<BigDecimal> extrato(LocalDate dateStart, LocalDate dateEnd){
        return (ArrayList<BigDecimal>) Arrays.asList(BigDecimal.ZERO);
    }

}
