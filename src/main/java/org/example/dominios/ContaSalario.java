package org.example.dominios;

public class ContaSalario extends Conta{

    public ContaSalario(String numeroConta, String agencia) {
        super(numeroConta, agencia);
        this.tipoConta = TipoConta.SALARIO;
    }
}
