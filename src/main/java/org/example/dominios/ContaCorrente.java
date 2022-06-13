package org.example.dominios;

public class ContaCorrente extends Conta implements IConta{
    public ContaCorrente(String numeroConta, String agencia) {
        super(numeroConta, agencia);
        this.tipoConta = TipoConta.CORRENTE;
    }


}
