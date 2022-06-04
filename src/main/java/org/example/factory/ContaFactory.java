package org.example.factory;

import org.example.dominios.*;

import java.util.Random;

public class ContaFactory {

    public static ContaSimples createConta(Cliente cliente, TipoConta tipoConta, String agencia){
        var numeroConta = String.format("%04d", new Random().nextInt());
        ContaSimples contaSimples = null;
        switch (tipoConta){
            case SALARIO:
                contaSimples = new ContaSimplesSalario(numeroConta,agencia);
                break;
            case POUPANCA:
                contaSimples = new ContaPoupanca(numeroConta,agencia);
                break;
            case CORRENTE:
                contaSimples = new ContaCorrente(numeroConta, agencia);
        }


        cliente.addConta(contaSimples);
        return contaSimples;
    }
}
