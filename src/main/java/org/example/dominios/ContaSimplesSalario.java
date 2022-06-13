package org.example.dominios;

public class ContaSimplesSalario extends ContaSimples implements IContaSimples{

    public ContaSimplesSalario(String numeroConta, String agencia) {
        super(numeroConta, agencia);
        this.tipoConta = TipoConta.SALARIO;
    }

}
