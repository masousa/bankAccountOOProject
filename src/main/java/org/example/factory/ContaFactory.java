package org.example.factory;

import org.example.dominios.*;

import java.util.Random;

public class ContaFactory {

    public static Conta createConta(Cliente cliente, TipoConta tipoConta, String agencia){
        var numeroConta = String.format("%04d", new Random().nextInt());
        Conta conta = null;
        switch (tipoConta){
            case SALARIO:
                conta = new ContaSalario(numeroConta,agencia);
                break;
            case POUPANCA:
                conta = new ContaPoupanca(numeroConta,agencia);
                break;
            case CORRENTE:
                conta = new Conta(numeroConta, agencia);
        }


        cliente.addConta(conta);
        return conta;
    }
}
